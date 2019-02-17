package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object VerificationAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: Pass03SymbolTable):
            Pair<List<AFileContents>, List<SemanticFileIssue>> {
        val problematicFiles = mutableListOf<SemanticFileIssue>()
        val aAsts = mutableListOf<AFileContents>()

        for (parsedFile in parsedFiles) {
            val fileContentsOrIssue = analyzeFile(parsedFile, symbolTable)
            when (fileContentsOrIssue) {
                is Disjunction.Left -> problematicFiles.add(fileContentsOrIssue.value)
                is Disjunction.Right -> aAsts.add(fileContentsOrIssue.value)
            }
        }

        return Pair(aAsts, problematicFiles)
    }

    private fun analyzeFile(parsedFile: ParsedFile, symbolTable: Pass03SymbolTable):
            Disjunction<SemanticFileIssue, AFileContents> {
        val errors = mutableListOf<SemanticError>()
        val aDefs = mutableListOf<ADef>()

        val module = parsedFile.module()

        // handle definitions
        for (def in parsedFile.ast.defs) {
            val defOrErrors = analyzeDefinition(def, symbolTable, module)
            when (defOrErrors) {
                is Disjunction.Left -> {
                    errors.addAll(defOrErrors.value)
                }
                is Disjunction.Right -> {
                    val aDef = defOrErrors.value
                    if (aDef != null)
                        aDefs.add(aDef)
                }
            }
        }

        return if (errors.isEmpty())
            Disjunction.right(AFileContents(parsedFile.inputFile, module, aDefs))
        else
            Disjunction.left(SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, errors))
    }

    private fun analyzeDefinition(def: Def, symbolTable: Pass03SymbolTable, module: Module):
            Disjunction<List<SemanticError>, ADef?> {
        val errors = mutableListOf<SemanticError>()
        var aDef: ADef? = null

        when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = ErrorContext.ValueDefinition(def.id)
                val declaredQualifiedType = if (def.declaredType == null) {
                    null
                } else {
                    symbolTable.findType(def.declaredType)
                }
                if (def.declaredType != null && declaredQualifiedType == null) {
                    errors.add(SemanticError.TypeNotFound(context, def.declaredType))
                }

                if (def.initializer == null) {
                    errors.add(SemanticError.MissingInitializer(context))
                } else {
                    val annotatedExprOrErrors = astExpr2AastExpr(def.initializer, symbolTable, def.id, module)
                    when (annotatedExprOrErrors) {
                        is Disjunction.Left -> {
                            errors.addAll(annotatedExprOrErrors.value)
                        }
                        is Disjunction.Right -> {
                            val initializerExpr = annotatedExprOrErrors.value
                            if (initializerExpr != null) {
                                val initializerType = initializerExpr.type()
                                if (declaredQualifiedType != null && declaredQualifiedType != initializerType) {
                                    errors.add(SemanticError.TypeMismatch(context, declaredQualifiedType, initializerType))
                                } else {
                                    aDef = ADef.AValueDef.ASimpleValueDef(def.id, initializerType, initializerExpr)
                                }
                            }
                        }
                    }
                }
            }
        }

        return if (errors.isEmpty())
            Disjunction.Right(aDef)
        else
            Disjunction.Left(errors)
    }

    private fun astExpr2AastExpr(expr: Expr, symbolTable: Pass03SymbolTable, valName: String, module: Module):
            Disjunction<List<SemanticError>, AExpr?> =
        astExpr2AastExpr(expr, symbolTable, module, valName, listOf(ValueCoordinates(module.packageName, module.moduleName, valName)))

    fun astExpr2AastExpr(expr: Expr, symbolTable: Pass03SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>):
            Disjunction<List<SemanticError>, AExpr?> {
        val context = ErrorContext.ValueDefinition(valName)

        return when (expr)  {
            is Expr.IntLiteral -> Disjunction.Right(AExpr.AIntLiteral(expr.value))
            is Expr.UnitLiteral -> Disjunction.Right(AExpr.AUnitLiteral)
            is Expr.BoolLiteral -> Disjunction.Right(if (expr is Expr.BoolLiteral.True)
                AExpr.ABoolLiteral.True
            else
                AExpr.ABoolLiteral.False
            )
            is Expr.CharLiteral -> Disjunction.Right(AExpr.ACharLiteral(expr.value))
            is Expr.StringLiteral -> Disjunction.Right(AExpr.AStringLiteral(expr.value))
            is Expr.ValueReferenceExpr -> {
                val lookupResult = symbolTable.lookup(expr.ref, module, valName, chain)
                when (lookupResult) {
                    is Pass03SymbolTable.LookupResult.RefNotFound ->
                        Disjunction.Left(listOf(SemanticError.UnresolvedReference(context, expr.ref)))
                    is Pass03SymbolTable.LookupResult.ForwardReference ->
                        Disjunction.Left(listOf(SemanticError.IllegalForwardReference(context, lookupResult.name)))
                    is Pass03SymbolTable.LookupResult.SelfReference ->
                        Disjunction.Left(listOf(SemanticError.IllegalSelfReference(context)))
                    is Pass03SymbolTable.LookupResult.CyclicReference ->
                        Disjunction.Left(listOf(SemanticError.CyclicDefinition(context, lookupResult.cycle)))
                    is Pass03SymbolTable.LookupResult.RefFound -> {
                        val qualifiedType = lookupResult.qualifiedType
                        Disjunction.Right(if (qualifiedType == null)
                            null
                        else
                            AExpr.AValueReferenceExpr(lookupResult.module, expr.ref.variable(), qualifiedType)
                        )
                    }
                }
            }
            is Expr.Negation -> {
                val operandAastOrErrors = astExpr2AastExpr(expr.operand, symbolTable, module, valName, chain)
                when (operandAastOrErrors) {
                    is Disjunction.Left -> operandAastOrErrors
                    is Disjunction.Right -> {
                        val operandAast = operandAastOrErrors.value
                        val operandType = operandAast?.type()
                        if (operandType == null) {
                            Disjunction.Right(null)
                        } else {
                            if (operandType != BuiltInTypes.Bool) {
                                Disjunction.Left(listOf(SemanticError.TypeMismatch(context, BuiltInTypes.Bool, operandType)))
                            } else {
                                Disjunction.Right(AExpr.ANegation(operandAast))
                            }
                        }
                    }
                }
            }
            is Expr.Disjunction -> handleBinaryBoolOperation(expr.leftDisjunct, expr.rightDisjunct, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ADisjunction(left, right) })
            is Expr.Conjunction -> handleBinaryBoolOperation(expr.leftConjunct, expr.rightConjunct, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AConjunction(left, right) })
        }
    }

    private fun handleBinaryBoolOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable, module: Module,
            valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr): Disjunction<List<SemanticError>, AExpr?> {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAastOrErrors = astExpr2AastExpr(leftExpr, symbolTable, module, valName, chain)
        val rightOperandAastOrErrors = astExpr2AastExpr(rightExpr, symbolTable, module, valName, chain)

        val leftOperandAast: AExpr? = when (leftOperandAastOrErrors) {
            is Disjunction.Left -> {
                errors.addAll(leftOperandAastOrErrors.value)
                null
            }
            is Disjunction.Right -> {
                leftOperandAastOrErrors.value
            }
        }
        if (leftOperandAast != null && leftOperandAast.type() != BuiltInTypes.Bool) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), BuiltInTypes.Bool,
                    leftOperandAast.type()))
        }

        val rightOperandAast: AExpr? = when (rightOperandAastOrErrors) {
            is Disjunction.Left -> {
                errors.addAll(rightOperandAastOrErrors.value)
                null
            }
            is Disjunction.Right -> {
                rightOperandAastOrErrors.value
            }
        }
        if (rightOperandAast != null && rightOperandAast.type() != BuiltInTypes.Bool) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), BuiltInTypes.Bool,
                    rightOperandAast.type()))
        }

        return if (errors.isEmpty()) {
            Disjunction.Right(cons(leftOperandAast!!, rightOperandAast!!))
        } else {
            Disjunction.Left(errors)
        }
    }
}
