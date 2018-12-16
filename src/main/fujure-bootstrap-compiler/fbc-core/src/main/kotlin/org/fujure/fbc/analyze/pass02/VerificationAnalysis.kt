package org.fujure.fbc.analyze.pass02

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object VerificationAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: SymbolTable):
            Pair<SymbolTable, List<ProblematicFile.SemanticFileIssue>> {
        val problematicFiles = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (parsedFile in parsedFiles) {
            val problematicFile = analyze(parsedFile, symbolTable)
            if (problematicFile != null)
                problematicFiles.add(problematicFile)
        }
        return Pair(symbolTable, problematicFiles)
    }

    private fun analyze(parsedFile: ParsedFile, symbolTable: SymbolTable): ProblematicFile.SemanticFileIssue? {
        symbolTable.enterContext(parsedFile.inputFile)

        val errors = mutableListOf<SemanticError>()

        // handle imports
        for (import in parsedFile.ast.imports) {
            val importError = symbolTable.registerImport(import)
            if (importError != null)
                errors.add(importError)
        }

        // handle definitions
        for (def in parsedFile.ast.defs) {
            val defErrors = analyze(def, symbolTable, parsedFile.ast.packageName, parsedFile.inputFile.moduleName)
            errors.addAll(defErrors)
        }

        return if (errors.isEmpty())
            null
        else
            ProblematicFile.SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, errors)
    }

    private fun analyze(def: Def, symbolTable: SymbolTable, packageName: String, moduleName: String):
            List<SemanticError> {
        val ret = mutableListOf<SemanticError>()
        when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = ErrorContext.ValueDefinition(def.id)

                val initializerTypeOrError = exprType(def.initializer, symbolTable, def.id, packageName, moduleName)
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

    private fun exprType(expr: Expr, symbolTable: SymbolTable, valName: String,
                         packageName: String, moduleName: String): Disjunction<SemanticError, QualifiedType?> =
            exprType(expr, symbolTable, valName, listOf(ValueCoordinates(packageName, moduleName, valName)))

    fun exprType(expr: Expr, symbolTable: SymbolTable, valName: String, chain: List<ValueCoordinates>):
            Disjunction<SemanticError, QualifiedType?> = when (expr) {
        is Expr.IntLiteral -> Disjunction.Right(BuiltInTypes.Int)
        is Expr.UnitLiteral -> Disjunction.Right(BuiltInTypes.Unit)
        is Expr.BoolLiteral -> Disjunction.Right(BuiltInTypes.Bool)
        is Expr.CharLiteral -> Disjunction.Right(BuiltInTypes.Char)
        is Expr.StringLiteral -> Disjunction.Right(BuiltInTypes.String)
        is Expr.ValueReferenceExpr -> {
            val context = ErrorContext.ValueDefinition(valName)
            val lookupResult = symbolTable.lookup(expr.ref, valName, chain)
            when (lookupResult) {
                is SymbolTable.LookupResult.RefNotFound ->
                    Disjunction.Left(SemanticError.UnresolvedReference(context, expr.ref))
                is SymbolTable.LookupResult.ForwardReference ->
                    Disjunction.Left(SemanticError.IllegalForwardReference(context, lookupResult.name))
                is SymbolTable.LookupResult.SelfReference ->
                    Disjunction.Left(SemanticError.IllegalSelfReference(context))
                is SymbolTable.LookupResult.CyclicReference ->
                    Disjunction.Left(SemanticError.CyclicDefinition(context, lookupResult.cycle))
                is SymbolTable.LookupResult.RefFound ->
                    Disjunction.Right(lookupResult.qualifiedType)
            }
        }
    }
}
