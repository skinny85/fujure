package org.fujure.fbc.analyze.pass_02

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeErrorContext
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.SymbolTable
import org.funktionale.either.Disjunction
import org.funktionale.either.Either
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents

object VerificationAnalysis {
    fun analyze(analyzedProgram: AnalyzedProgram):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram> {
        val problematicFiles = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (ast in analyzedProgram.asts) {
            val problematicFile = analyze(ast, analyzedProgram.symbolTable)
            if (problematicFile != null)
                problematicFiles.add(problematicFile)
        }
        return if (problematicFiles.isEmpty())
            Disjunction.Right(analyzedProgram)
        else
            Disjunction.Left(problematicFiles)
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

                val initializerTypeOrError = exprType(def.initializer, symbolTable, def.id)
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

    fun exprType(expr: Expr, symbolTable: SymbolTable, valName: String):
            Either<SemanticError, QualifiedType?> = when (expr) {
        is Expr.IntLiteral -> Either.Right(BuiltInTypes.Int)
        is Expr.BoolLiteral -> Either.Right(BuiltInTypes.Bool)
        is Expr.ValueReferenceExpr -> {
            val context = TypeErrorContext.VariableDefinition(valName)
            val lookupResult = symbolTable.lookup(expr.ref, valName)
            when (lookupResult) {
                is SymbolTable.LookupResult.RefNotFound ->
                    Either.Left(SemanticError.UnresolvedReference(context, expr.ref))
                is SymbolTable.LookupResult.ForwardReference ->
                    Either.Left(SemanticError.IllegalForwardReference(context, lookupResult.name))
                is SymbolTable.LookupResult.SelfReference ->
                    Either.Left(SemanticError.IllegalSelfReference(context))
                is SymbolTable.LookupResult.RefFound ->
                    Either.Right(lookupResult.qualifiedType)
            }
        }
    }
}
