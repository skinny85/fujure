package org.fujure.fbc.analyze.pass_02

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeErrorContext
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.SymbolTable
import org.funktionale.either.Either
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents

object VerificationAnalysis {
    fun analyze(asts: List<AstRoot>, symbolTable: SymbolTable): SemanticAnalysisResult {
        val problematicFiles = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (ast in asts) {
            val problematicFile = analyze(ast, symbolTable)
            if (problematicFile != null)
                problematicFiles.add(problematicFile)
        }
        return if (problematicFiles.isEmpty())
            SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTable))
        else
            SemanticAnalysisResult.Failure(problematicFiles)
    }

    private fun analyze(ast: AstRoot, symbolTable: SymbolTable): ProblematicFile.SemanticFileIssue? {
        symbolTable.enterContext(ast.inputFile)

        val errors = mutableListOf<SemanticError>()
        for (def in ast.fileContents.defs) {
            val defErrors = analyze(def, symbolTable)
            errors.addAll(defErrors)
        }
        return if (errors.isEmpty())
            null
        else
            ProblematicFile.SemanticFileIssue(ast.inputFile.userProvidedFilePath, errors)
    }

    private fun analyze(def: Def, symbolTable: SymbolTable): List<SemanticError> {
        val ret = mutableListOf<SemanticError>()
        when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = TypeErrorContext.VariableDefinition(def.id)

                val initializerTypeOrError = exprType(def.initializer, symbolTable, context)
                val declaredQualifiedType: QualifiedType? = if (def.declaredType == null)
                    null
                else
                    symbolTable.findType(def.declaredType)

                when (initializerTypeOrError) {
                    is Either.Left -> ret.add(initializerTypeOrError.l)
                    is Either.Right -> {
                        val initializerQualifiedType = initializerTypeOrError.r
                        if (declaredQualifiedType != null &&
                                initializerQualifiedType != null &&
                                declaredQualifiedType != initializerQualifiedType)
                            ret.add(SemanticError.TypeMismatch(context, declaredQualifiedType,
                                    initializerQualifiedType))
                    }
                }

                if (def.declaredType != null && declaredQualifiedType == null)
                    ret.add(SemanticError.TypeNotFound(context, def.declaredType))
            }
        }
        return ret
    }

    private fun exprType(expr: Expr, symbolTable: SymbolTable, valDef: TypeErrorContext.VariableDefinition):
            Either<SemanticError, QualifiedType?> = when (expr) {
        is Expr.IntLiteral -> Either.Right(BuiltInTypes.Int)
        is Expr.BoolLiteral -> Either.Right(BuiltInTypes.Bool)
        is Expr.ValueReferenceExpr -> {
            val lookupResult = symbolTable.lookup(expr.ref, valDef.name)
            when (lookupResult) {
                is SymbolTable.LookupResult.RefNotFound ->
                    Either.Left(SemanticError.UnresolvedReference(valDef, expr.ref))
                is SymbolTable.LookupResult.ForwardReference ->
                    Either.Left(SemanticError.IllegalForwardReference(valDef, lookupResult.name))
                is SymbolTable.LookupResult.SelfReference ->
                    Either.Left(SemanticError.IllegalSelfReference(valDef))
                is SymbolTable.LookupResult.RefFound ->
                    Either.Right(lookupResult.qualifiedType)
            }
        }
    }
}
