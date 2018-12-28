package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object VerificationAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: Pass03SymbolTable):
            List<ProblematicFile.SemanticFileIssue> {
        val problematicFiles = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (parsedFile in parsedFiles) {
            val problematicFile = analyzeFile(parsedFile, symbolTable)
            if (problematicFile != null)
                problematicFiles.add(problematicFile)
        }
        return problematicFiles
    }

    private fun analyzeFile(parsedFile: ParsedFile, symbolTable: Pass03SymbolTable):
            ProblematicFile.SemanticFileIssue? {
        val module = parsedFile.module()

        val errors = mutableListOf<SemanticError>()

        // handle definitions
        for (def in parsedFile.ast.defs) {
            val defErrors = analyzeDefinition(def, symbolTable, module)
            errors.addAll(defErrors)
        }

        return if (errors.isEmpty())
            null
        else
            ProblematicFile.SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, errors)
    }

    private fun analyzeDefinition(def: Def, symbolTable: Pass03SymbolTable, module: Module):
            List<SemanticError> {
        val ret = mutableListOf<SemanticError>()
        when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = ErrorContext.ValueDefinition(def.id)

                val initializerTypeOrError = exprType(def.initializer, symbolTable, def.id, module)
                val declaredQualifiedType: QualifiedType? = if (def.declaredType == null)
                    null
                else
                    symbolTable.findType(def.declaredType)

                when (initializerTypeOrError) {
                    is Disjunction.Left -> ret.add(initializerTypeOrError.value)
                    is Disjunction.Right -> {
                        val initializerQualifiedType = initializerTypeOrError.value
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

    private fun exprType(expr: Expr, symbolTable: Pass03SymbolTable, valName: String,
                         module: Module): Disjunction<SemanticError, QualifiedType?> =
            exprType(expr, symbolTable, module, valName, listOf(ValueCoordinates(module.packageName, module.moduleName, valName)))

    fun exprType(expr: Expr, symbolTable: Pass03SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>):
            Disjunction<SemanticError, QualifiedType?> = when (expr)  {
        is Expr.IntLiteral -> Disjunction.Right(BuiltInTypes.Int)
        is Expr.UnitLiteral -> Disjunction.Right(BuiltInTypes.Unit)
        is Expr.BoolLiteral -> Disjunction.Right(BuiltInTypes.Bool)
        is Expr.CharLiteral -> Disjunction.Right(BuiltInTypes.Char)
        is Expr.StringLiteral -> Disjunction.Right(BuiltInTypes.String)
        is Expr.ValueReferenceExpr -> {
            val context = ErrorContext.ValueDefinition(valName)
            val lookupResult = symbolTable.lookup(expr.ref, module, valName, chain)
            when (lookupResult) {
                is Pass03SymbolTable.LookupResult.RefNotFound ->
                    Disjunction.Left(SemanticError.UnresolvedReference(context, expr.ref))
                is Pass03SymbolTable.LookupResult.ForwardReference ->
                    Disjunction.Left(SemanticError.IllegalForwardReference(context, lookupResult.name))
                is Pass03SymbolTable.LookupResult.SelfReference ->
                    Disjunction.Left(SemanticError.IllegalSelfReference(context))
                is Pass03SymbolTable.LookupResult.CyclicReference ->
                    Disjunction.Left(SemanticError.CyclicDefinition(context, lookupResult.cycle))
                is Pass03SymbolTable.LookupResult.RefFound ->
                    Disjunction.Right(lookupResult.qualifiedType)
            }
        }
    }
}
