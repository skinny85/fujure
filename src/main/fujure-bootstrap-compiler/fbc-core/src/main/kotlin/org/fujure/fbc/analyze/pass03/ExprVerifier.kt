package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueCoordinates
import org.funktionale.either.Disjunction

class ExprVerifier(private val symbolTable: Pass03SymbolTable,
        private val module: Module, private val valName: String,
        private val chain: List<ValueCoordinates>) {
    fun analyzeExpr(expr: Expr): ExprVerificationResult {
        val context = ErrorContext.ValueDefinition(valName)

        return when (expr)  {
            is Expr.IntLiteral -> {
                ExprVerificationResult.Success(BuiltInTypes.Int, AExpr.AIntLiteral(expr.value))
            }
            is Expr.UnitLiteral -> {
                ExprVerificationResult.Success(BuiltInTypes.Unit, AExpr.AUnitLiteral)
            }
            is Expr.BoolLiteral -> {
                ExprVerificationResult.Success(BuiltInTypes.Bool, if (expr is Expr.BoolLiteral.True)
                    AExpr.ABoolLiteral.True
                else
                    AExpr.ABoolLiteral.False
                )
            }
            is Expr.CharLiteral -> {
                ExprVerificationResult.Success(BuiltInTypes.Char, AExpr.ACharLiteral(expr.value))
            }
            is Expr.StringLiteral -> {
                ExprVerificationResult.Success(BuiltInTypes.String, AExpr.AStringLiteral(expr.value))
            }
            is Expr.ValueReference -> {
                val lookupResult = symbolTable.lookup(expr.ref, module, valName, chain)
                when (lookupResult) {
                    is Pass03SymbolTable.LookupResult.RefNotFound ->
                        ExprVerificationResult.Failure(SemanticError.UnresolvedReference(context, expr.ref))
                    is Pass03SymbolTable.LookupResult.ForwardReference ->
                        ExprVerificationResult.Failure(SemanticError.IllegalForwardReference(context, lookupResult.name))
                    is Pass03SymbolTable.LookupResult.SelfReference ->
                        ExprVerificationResult.Failure(SemanticError.IllegalSelfReference(context))
                    is Pass03SymbolTable.LookupResult.CyclicReference ->
                        ExprVerificationResult.Failure(SemanticError.CyclicDefinition(context, lookupResult.cycle))
                    is Pass03SymbolTable.LookupResult.RefFound -> {
                        val qualifiedType = lookupResult.qualifiedType
                        ExprVerificationResult.Success(qualifiedType, if (qualifiedType == null)
                            null
                        else
                            AExpr.AValueReference(lookupResult.module, expr.ref.variable(), qualifiedType)
                        )
                    }
                }
            }
            is Expr.Negation -> {
                val errors = mutableListOf<SemanticError>()
                val operandAnalysisResult = analyzeExpr(expr.operand)
                val operandAast: AExpr? = when (operandAnalysisResult) {
                    is ExprVerificationResult.Failure -> {
                        errors.addAll(operandAnalysisResult.errors)
                        null
                    }
                    is ExprVerificationResult.Success -> {
                        operandAnalysisResult.aExpr
                    }
                }
                val operandType = operandAnalysisResult.qualifiedType
                if (operandType != null && operandType != BuiltInTypes.Bool) {
                    errors.add(SemanticError.TypeMismatch(context, BuiltInTypes.Bool, operandType))
                }
                if (errors.isEmpty())
                    ExprVerificationResult.Success(BuiltInTypes.Bool, if (operandAast == null) null else
                        AExpr.ANegation(operandAast))
                else
                    ExprVerificationResult.Failure(BuiltInTypes.Bool, errors)
            }
            is Expr.Disjunction -> {
                handleBinaryBoolOperation(expr.leftDisjunct, expr.rightDisjunct, { left, right -> AExpr.ADisjunction(left, right) })
            }
            is Expr.Conjunction -> {
                handleBinaryBoolOperation(expr.leftConjunct, expr.rightConjunct, { left, right -> AExpr.AConjunction(left, right) })
            }
            is Expr.Lesser -> {
                handleOrderingOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.ALesser(left, right) })
            }
            is Expr.LesserEqual -> {
                handleOrderingOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.ALesserEqual(left, right) })
            }
            is Expr.Greater -> {
                handleOrderingOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.AGreater(left, right) })
            }
            is Expr.GreaterEqual -> {
                handleOrderingOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.AGreaterEqual(left, right) })
            }
            is Expr.Addition -> {
                handleIntAdditionOrStringConcatenation(expr.augend, expr.addend)
            }
            is Expr.Subtraction -> {
                handleArithmeticOperation(expr.minuend, expr.subtrahend, { left, right -> AExpr.ASubtraction(left, right) })
            }
            is Expr.Multiplication -> {
                handleArithmeticOperation(expr.multiplicand, expr.multiplier, { left, right -> AExpr.AMultiplication(left, right) })
            }
            is Expr.Division-> {
                handleArithmeticOperation(expr.dividend, expr.divisor, { left, right -> AExpr.ADivision(left, right) })
            }
            is Expr.Modulus-> {
                handleArithmeticOperation(expr.dividend, expr.divisor, { left, right -> AExpr.AModulus(left, right) })
            }
            is Expr.Equality -> {
                handleComparisonOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.AStringEquality(left, right) },
                        { left, right -> AExpr.APrimitiveEquality(left, right) })
            }
            is Expr.Inequality -> {
                handleComparisonOperation(expr.leftOperand, expr.rightOperand, { left, right -> AExpr.AStringInequality(left, right) },
                        { left, right -> AExpr.APrimitiveInequality(left, right) })
            }
            is Expr.Let -> {
                handleLetExpression(expr)
            }
        }
    }

    private fun handleBinaryBoolOperation(leftExpr: Expr, rightExpr: Expr, cons: (AExpr, AExpr) -> AExpr):
            ExprVerificationResult {
        return handleHomogeneousBinaryOperatorReturningBool(leftExpr, rightExpr, cons, BuiltInTypes.Bool)
    }

    private fun handleOrderingOperation(leftExpr: Expr, rightExpr: Expr, cons: (AExpr, AExpr) -> AExpr):
            ExprVerificationResult {
        return handleHomogeneousBinaryOperatorReturningBool(leftExpr, rightExpr, cons, BuiltInTypes.Int)
    }

    private fun handleHomogeneousBinaryOperatorReturningBool(leftExpr: Expr, rightExpr: Expr, cons: (AExpr, AExpr) -> AExpr,
            expectedType: QualifiedType): ExprVerificationResult {
        return handleHomogeneousBinaryOperation(leftExpr, rightExpr, cons, expectedType, BuiltInTypes.Bool)
    }

    private fun handleArithmeticOperation(leftExpr: Expr, rightExpr: Expr, cons: (AExpr, AExpr) -> AExpr):
            ExprVerificationResult {
        return handleHomogeneousBinaryOperation(leftExpr, rightExpr, cons, BuiltInTypes.Int, BuiltInTypes.Int)
    }

    private fun handleHomogeneousBinaryOperation(leftExpr: Expr, rightExpr: Expr, cons: (AExpr, AExpr) -> AExpr,
            expectedType: QualifiedType, returnType: QualifiedType): ExprVerificationResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val leftOperandType = leftOperandAnalysisResult.qualifiedType
        if (leftOperandType != null && leftOperandType != expectedType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), expectedType,
                    leftOperandType))
        }

        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                rightOperandAnalysisResult.aExpr
            }
        }
        val rightOperandType = rightOperandAnalysisResult.qualifiedType
        if (rightOperandType != null && rightOperandType != expectedType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), expectedType,
                    rightOperandType))
        }

        return if (errors.isEmpty()) {
            ExprVerificationResult.Success(returnType, if (leftOperandAast != null && rightOperandAast != null)
                cons(leftOperandAast, rightOperandAast)
            else
                null)
        } else {
            ExprVerificationResult.Failure(returnType, errors)
        }
    }

    private fun handleComparisonOperation(leftExpr: Expr, rightExpr: Expr, consIfString: (AExpr, AExpr) -> AExpr,
            consIfPrimitive: (AExpr, AExpr) -> AExpr): ExprVerificationResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
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
            ExprVerificationResult.Success(BuiltInTypes.Bool, if (leftOperandAast != null && rightOperandAast != null) {
                if (leftOperandType == BuiltInTypes.String)
                    consIfString(leftOperandAast, rightOperandAast)
                else
                    consIfPrimitive(leftOperandAast, rightOperandAast)
            } else {
                null
            })
        } else {
            ExprVerificationResult.Failure(BuiltInTypes.Bool, errors)
        }
    }

    private fun handleIntAdditionOrStringConcatenation(leftExpr: Expr, rightExpr: Expr): ExprVerificationResult {
        val errors = mutableListOf<SemanticError>()

        val leftOperandAnalysisResult = analyzeExpr(leftExpr)
        val rightOperandAnalysisResult = analyzeExpr(rightExpr)

        val leftOperandAast: AExpr? = when (leftOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(leftOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                leftOperandAnalysisResult.aExpr
            }
        }
        val leftOperandType = leftOperandAnalysisResult.qualifiedType

        val rightOperandAast: AExpr? = when (rightOperandAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(rightOperandAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
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
            ExprVerificationResult.Success(exprType, if (leftOperandAast != null && rightOperandAast != null) {
                if (leftOperandType == BuiltInTypes.String)
                    AExpr.AStringConcatenation(leftOperandAast, rightOperandAast)
                else
                    AExpr.AAddition(leftOperandAast, rightOperandAast)
            } else {
                null
            })
        } else {
            ExprVerificationResult.Failure(exprType, errors)
        }
    }

    private fun handleLetExpression(letExpr: Expr.Let): ExprVerificationResult {
        // 1. Create a new scope in symbolTable
        // 2. For each declaration:
        //   - analyze it, reporting any errors
        //   - add it to the new scope, reporting an error if it's a duplicate
        // 3. Analyze the expression, taking into account the new scope

        val errors = mutableListOf<SemanticError>()
        val declarations = mutableListOf<ADef.AValueDef>()

        symbolTable.pushNewScope(module)
        for (declaration in letExpr.declarations) {
            var aValueDeclaration: ADef.AValueDef? = null

            val result = ValueDeclarationVerifier(symbolTable, module, valName, chain).analyzeValueDeclaration(declaration)
            when (result) {
                is Disjunction.Left -> errors.addAll(result.value)
                is Disjunction.Right -> {
                    aValueDeclaration = result.value
                    if (aValueDeclaration != null)
                        declarations.add(aValueDeclaration)
                }
            }

            val id = when (declaration) {
                is Def.ValueDef.SimpleValueDef -> declaration.id
            }
            val qualifiedType = when (aValueDeclaration) {
                is ADef.AValueDef.ASimpleValueDef -> aValueDeclaration.type
                else -> null
            }
            if (!symbolTable.addToLatestScope(module, id, qualifiedType)) {
                errors.add(SemanticError.DuplicateDefinition(id))
            }
        }

        var aExpr: AExpr? = null
        val result = analyzeExpr(letExpr.expr)
        when (result) {
            is ExprVerificationResult.Failure -> errors.addAll(result.errors)
            is ExprVerificationResult.Success -> aExpr = result.aExpr
        }

        symbolTable.popLatestScope(module)

        return if (errors.isEmpty()) {
            ExprVerificationResult.Success(result.qualifiedType, if (aExpr == null)
                null
            else
                AExpr.ALet(declarations, aExpr))
        } else {
            ExprVerificationResult.Failure(result.qualifiedType, errors)
        }
    }
}
