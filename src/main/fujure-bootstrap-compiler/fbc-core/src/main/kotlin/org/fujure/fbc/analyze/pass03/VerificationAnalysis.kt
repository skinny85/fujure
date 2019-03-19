package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
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
        return when (def) {
            is Def.ValueDef.SimpleValueDef -> {
                analyzeValueDeclaration(def, symbolTable, module, def.id,
                        listOf(ValueCoordinates(module.packageName, module.moduleName, def.id)))
            }
        }
    }

    private fun analyzeValueDeclaration(valueDeclaration: Def.ValueDef, symbolTable: Pass03SymbolTable, module: Module,
            valName: String, chain: List<ValueCoordinates>): Disjunction<List<SemanticError>, ADef.AValueDef?> {
        val errors = mutableListOf<SemanticError>()
        var aDef: ADef.AValueDef? = null

        when (valueDeclaration) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = ErrorContext.ValueDefinition(valName)
                val declaredQualifiedType = if (valueDeclaration.declaredType == null) {
                    null
                } else {
                    symbolTable.findType(valueDeclaration.declaredType)
                }
                if (valueDeclaration.declaredType != null && declaredQualifiedType == null) {
                    errors.add(SemanticError.TypeNotFound(context, valueDeclaration.declaredType))
                }

                if (valueDeclaration.initializer == null) {
                    errors.add(SemanticError.MissingInitializer(context))
                } else {
                    val initializerAnalysisResult = analyzeExpr(valueDeclaration.initializer, symbolTable, module,
                            valName, chain)
                    when (initializerAnalysisResult) {
                        is ExprAnalysisResult.Failure -> {
                            errors.addAll(initializerAnalysisResult.errors)
                        }
                        is ExprAnalysisResult.Success -> {
                            val initializerType = initializerAnalysisResult.qualifiedType
                            if (initializerType != null && declaredQualifiedType != null &&
                                    declaredQualifiedType != initializerType) {
                                errors.add(SemanticError.TypeMismatch(context, declaredQualifiedType, initializerType))
                            }

                            val initializerExpr = initializerAnalysisResult.aExpr
                            val valueType = declaredQualifiedType ?: initializerType
                            if (valueType != null && initializerExpr != null) {
                                aDef = ADef.AValueDef.ASimpleValueDef(valueDeclaration.id, valueType, initializerExpr)
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

    fun analyzeExpr(expr: Expr, symbolTable: Pass03SymbolTable, module: Module, valName: String,
            chain: List<ValueCoordinates>): ExprAnalysisResult {
        val context = ErrorContext.ValueDefinition(valName)

        return when (expr)  {
            is Expr.IntLiteral -> ExprAnalysisResult.Success(BuiltInTypes.Int, AExpr.AIntLiteral(expr.value))
            is Expr.UnitLiteral -> ExprAnalysisResult.Success(BuiltInTypes.Unit, AExpr.AUnitLiteral)
            is Expr.BoolLiteral -> ExprAnalysisResult.Success(BuiltInTypes.Bool, if (expr is Expr.BoolLiteral.True)
                AExpr.ABoolLiteral.True
            else
                AExpr.ABoolLiteral.False
            )
            is Expr.CharLiteral -> ExprAnalysisResult.Success(BuiltInTypes.Char, AExpr.ACharLiteral(expr.value))
            is Expr.StringLiteral -> ExprAnalysisResult.Success(BuiltInTypes.String, AExpr.AStringLiteral(expr.value))
            is Expr.ValueReference -> {
                val lookupResult = symbolTable.lookup(expr.ref, module, valName, chain)
                when (lookupResult) {
                    is Pass03SymbolTable.LookupResult.RefNotFound ->
                        ExprAnalysisResult.Failure(SemanticError.UnresolvedReference(context, expr.ref))
                    is Pass03SymbolTable.LookupResult.ForwardReference ->
                        ExprAnalysisResult.Failure(SemanticError.IllegalForwardReference(context, lookupResult.name))
                    is Pass03SymbolTable.LookupResult.SelfReference ->
                        ExprAnalysisResult.Failure(SemanticError.IllegalSelfReference(context))
                    is Pass03SymbolTable.LookupResult.CyclicReference ->
                        ExprAnalysisResult.Failure(SemanticError.CyclicDefinition(context, lookupResult.cycle))
                    is Pass03SymbolTable.LookupResult.RefFound -> {
                        val qualifiedType = lookupResult.qualifiedType
                        ExprAnalysisResult.Success(qualifiedType, if (qualifiedType == null)
                            null
                        else
                            AExpr.AValueReference(lookupResult.module, expr.ref.variable(), qualifiedType)
                        )
                    }
                }
            }
            is Expr.Negation -> {
                val errors = mutableListOf<SemanticError>()
                val operandAnalysisResult = analyzeExpr(expr.operand, symbolTable, module, valName, chain)
                val operandAast: AExpr? = when (operandAnalysisResult) {
                    is ExprAnalysisResult.Failure -> {
                        errors.addAll(operandAnalysisResult.errors)
                        null
                    }
                    is ExprAnalysisResult.Success -> {
                        operandAnalysisResult.aExpr
                    }
                }
                val operandType = operandAnalysisResult.qualifiedType
                if (operandType != null && operandType != BuiltInTypes.Bool) {
                    errors.add(SemanticError.TypeMismatch(context, BuiltInTypes.Bool, operandType))
                }
                if (errors.isEmpty())
                    ExprAnalysisResult.Success(BuiltInTypes.Bool, if (operandAast == null) null else
                        AExpr.ANegation(operandAast))
                else
                    ExprAnalysisResult.Failure(BuiltInTypes.Bool, errors)
            }
            is Expr.Disjunction -> handleBinaryBoolOperation(expr.leftDisjunct, expr.rightDisjunct, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ADisjunction(left, right) })
            is Expr.Conjunction -> handleBinaryBoolOperation(expr.leftConjunct, expr.rightConjunct, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AConjunction(left, right) })
            is Expr.Lesser -> handleOrderingOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ALesser(left, right) })
            is Expr.LesserEqual -> handleOrderingOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ALesserEqual(left, right) })
            is Expr.Greater -> handleOrderingOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AGreater(left, right) })
            is Expr.GreaterEqual -> handleOrderingOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AGreaterEqual(left, right) })
            is Expr.Addition -> handleIntAdditionOrStringConcatenation(expr.augend, expr.addend, symbolTable, module,
                    valName, chain)
            is Expr.Subtraction -> handleArithmeticOperation(expr.minuend, expr.subtrahend, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ASubtraction(left, right) })
            is Expr.Multiplication -> handleArithmeticOperation(expr.multiplicand, expr.multiplier, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AMultiplication(left, right) })
            is Expr.Division-> handleArithmeticOperation(expr.dividend, expr.divisor, symbolTable, module,
                    valName, chain, { left, right -> AExpr.ADivision(left, right) })
            is Expr.Modulus-> handleArithmeticOperation(expr.dividend, expr.divisor, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AModulus(left, right) })
            is Expr.Equality -> handleComparisonOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AStringEquality(left, right) },
                    { left, right -> AExpr.APrimitiveEquality(left, right) })
            is Expr.Inequality -> handleComparisonOperation(expr.leftOperand, expr.rightOperand, symbolTable, module,
                    valName, chain, { left, right -> AExpr.AStringInequality(left, right) },
                    { left, right -> AExpr.APrimitiveInequality(left, right) })
            is Expr.Let -> handleLetExpression(expr, symbolTable, module, valName, chain)
        }
    }

    private fun handleBinaryBoolOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable, module: Module,
            valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr): ExprAnalysisResult {
        return handleHomogeneousBinaryOperatorReturningBool(leftExpr, rightExpr, symbolTable, module, valName,
                chain, cons, BuiltInTypes.Bool)
    }

    private fun handleOrderingOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable, module: Module,
            valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr): ExprAnalysisResult {
        return handleHomogeneousBinaryOperatorReturningBool(leftExpr, rightExpr, symbolTable, module, valName,
                chain, cons, BuiltInTypes.Int)
    }

    private fun handleHomogeneousBinaryOperatorReturningBool(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable,
            module: Module, valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr,
            expectedType: QualifiedType): ExprAnalysisResult {
        return handleHomogeneousBinaryOperation(leftExpr, rightExpr, symbolTable, module, valName, chain, cons,
                expectedType, BuiltInTypes.Bool)
    }

    private fun handleArithmeticOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable, module: Module,
            valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr): ExprAnalysisResult {
        return handleHomogeneousBinaryOperation(leftExpr, rightExpr, symbolTable, module, valName,
                chain, cons, BuiltInTypes.Int, BuiltInTypes.Int)
    }

    private fun handleHomogeneousBinaryOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable,
            module: Module, valName: String, chain: List<ValueCoordinates>, cons: (AExpr, AExpr) -> AExpr,
            expectedType: QualifiedType, returnType: QualifiedType): ExprAnalysisResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr, symbolTable, module, valName, chain)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr, symbolTable, module, valName, chain)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val leftOperandType = leftOperandAnalysisResult.qualifiedType
        if (leftOperandType != null && leftOperandType != expectedType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), expectedType,
                    leftOperandType))
        }

        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                rightOperandAnalysisResult.aExpr
            }
        }
        val rightOperandType = rightOperandAnalysisResult.qualifiedType
        if (rightOperandType != null && rightOperandType != expectedType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), expectedType,
                    rightOperandType))
        }

        return if (errors.isEmpty()) {
            ExprAnalysisResult.Success(returnType, if (leftOperandAast != null && rightOperandAast != null)
                cons(leftOperandAast, rightOperandAast)
            else
                null)
        } else {
            ExprAnalysisResult.Failure(returnType, errors)
        }
    }

    private fun handleComparisonOperation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable,
            module: Module, valName: String, chain: List<ValueCoordinates>, consIfString: (AExpr, AExpr) -> AExpr,
            consIfPrimitive: (AExpr, AExpr) -> AExpr): ExprAnalysisResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr, symbolTable, module, valName, chain)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr, symbolTable, module, valName, chain)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                rightOperandAnalysisResult.aExpr
            }
        }

        val leftOperandType = leftOperandAnalysisResult.qualifiedType
        val rightOperandType = rightOperandAnalysisResult.qualifiedType
        if (leftOperandType != null && rightOperandType != null &&
                leftOperandType != rightOperandType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName),
                    leftOperandType, rightOperandType))
        }

        return if (errors.isEmpty()) {
            ExprAnalysisResult.Success(BuiltInTypes.Bool, if (leftOperandAast != null && rightOperandAast != null) {
                if (leftOperandType == BuiltInTypes.String)
                    consIfString(leftOperandAast, rightOperandAast)
                else
                    consIfPrimitive(leftOperandAast, rightOperandAast)
            } else {
                null
            })
        } else {
            ExprAnalysisResult.Failure(BuiltInTypes.Bool, errors)
        }
    }

    private fun handleIntAdditionOrStringConcatenation(leftExpr: Expr, rightExpr: Expr, symbolTable: Pass03SymbolTable,
            module: Module, valName: String, chain: List<ValueCoordinates>): ExprAnalysisResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr, symbolTable, module, valName, chain)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr, symbolTable, module, valName, chain)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val leftOperandType = leftOperandAnalysisResult.qualifiedType

        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprAnalysisResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprAnalysisResult.Success -> {
                rightOperandAnalysisResult.aExpr
            }
        }
        val rightOperandType = rightOperandAnalysisResult.qualifiedType

        val errorContext = ErrorContext.ValueDefinition(valName)
        val exprIsStringConcatenation = leftOperandType == BuiltInTypes.String && rightOperandType != BuiltInTypes.Int ||
                rightOperandType == BuiltInTypes.String && leftOperandType != BuiltInTypes.Int
        val exprType = if (exprIsStringConcatenation) BuiltInTypes.String else BuiltInTypes.Int

        if (leftOperandType != null && leftOperandType != exprType) {
            errors.add(SemanticError.TypeMismatch(errorContext, exprType, leftOperandType))
        }
        if (rightOperandType != null && rightOperandType != exprType) {
            errors.add(SemanticError.TypeMismatch(errorContext, exprType, rightOperandType))
        }

        return if (errors.isEmpty()) {
            ExprAnalysisResult.Success(exprType, if (leftOperandAast != null && rightOperandAast != null) {
                if (leftOperandType == BuiltInTypes.String)
                    AExpr.AStringConcatenation(leftOperandAast, rightOperandAast)
                else
                    AExpr.AAddition(leftOperandAast, rightOperandAast)
            } else {
                null
            })
        } else {
            ExprAnalysisResult.Failure(exprType, errors)
        }
    }

    private fun handleLetExpression(letExpr: Expr.Let, symbolTable: Pass03SymbolTable, module: Module, valName: String,
            chain: List<ValueCoordinates>): ExprAnalysisResult {
        // 1. Create a new scope in symbolTable
        // 2. For each declaration:
        //   - analyze it, reporting any errors
        //   - add it to the new scope, reporting an error if it's a duplicate
        // 3. Analyze the expression, taking into account the new scope

        // ToDo we actually don't have the concept of a scope in the SymbolTable - add it

        val errors = mutableListOf<SemanticError>()
        val declarations = mutableListOf<ADef.AValueDef>()
        var aExpr: AExpr? = null

        for (declaration in letExpr.declarations) {
            val result = analyzeValueDeclaration(declaration, symbolTable, module, valName, chain)
            when (result) {
                is Disjunction.Left -> errors.addAll(result.value)
                is Disjunction.Right -> {
                    val aValueDeclaration = result.value
                    if (aValueDeclaration != null)
                        declarations.add(aValueDeclaration)
                }
            }
        }

        val result = analyzeExpr(letExpr.expr, symbolTable, module, valName, chain)
        when (result) {
            is ExprAnalysisResult.Failure -> errors.addAll(result.errors)
            is ExprAnalysisResult.Success -> aExpr = result.aExpr
        }

        return if (errors.isEmpty()) {
            ExprAnalysisResult.Success(result.qualifiedType, if (aExpr == null)
                null
            else
                AExpr.ALet(declarations, aExpr))
        } else {
            ExprAnalysisResult.Failure(result.qualifiedType, errors)
        }
    }

    sealed class ExprAnalysisResult(open val qualifiedType: QualifiedType?) {
        class Success(override val qualifiedType: QualifiedType?, val aExpr: AExpr?) :
                ExprAnalysisResult(qualifiedType)

        class Failure(override val qualifiedType: QualifiedType?, val errors: List<SemanticError>) :
                ExprAnalysisResult(qualifiedType) {
            constructor(error: SemanticError) : this(null, listOf(error))
        }
    }
}
