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
import org.fujure.fbc.ast.ValueReference
import org.funktionale.either.Disjunction

class ExprVerifier(private val symbolTable: Pass03SymbolTable,
        private val module: Module, private val valName: String,
        private val chain: List<ValueCoordinates>?) {
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
            is Expr.UnqualifiedReference -> {
                handleValueReference(ValueReference(expr.ref), context)
            }
            is Expr.QualifiedReference -> {
                handleValueReference(ValueReference(expr.module, expr.ref), context)
            }
            is Expr.Complement -> {
                handleUnaryOperation(expr.operand, BuiltInTypes.Bool, AExpr::AComplement)
            }
            is Expr.Negation -> {
                handleUnaryOperation(expr.operand, BuiltInTypes.Int, AExpr::ANegation)
            }
            is Expr.Positation -> {
                handleUnaryOperation(expr.operand, BuiltInTypes.Int, AExpr::APositation)
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
            is Expr.If -> {
                handleIfExpression(expr)
            }
            is Expr.FunctionCall -> {
                val errors = mutableListOf<SemanticError>()

                // first, resolve the target of the call
                val callTargetAnalysis = analyzeExpr(expr.target)
                val callTargetExpr: AExpr? = when (callTargetAnalysis) {
                    is ExprVerificationResult.Success -> {
                        callTargetAnalysis.aExpr
                    }
                    is ExprVerificationResult.Failure -> {
                        errors.addAll(callTargetAnalysis.errors)
                        null
                    }
                }

                val targetFunctionType: QualifiedType.FunctionType? = if (callTargetAnalysis.qualifiedType == null) {
                    null
                } else {
                    if (callTargetAnalysis.qualifiedType is QualifiedType.FunctionType) {
                        // report an error about incorrect number of arguments
                        if (callTargetAnalysis.qualifiedType.argumentTypes.size != expr.arguments.size) {
                            errors.add(SemanticError.ArgumentCountMismatch(context,
                                    callTargetAnalysis.qualifiedType.argumentTypes.size, expr.arguments.size))
                        }
                        callTargetAnalysis.qualifiedType
                    } else {
                        // report an error that the target is of a non-invokable type
                        errors.add(SemanticError.NotInvokable(context, callTargetAnalysis.qualifiedType))
                        null
                    }
                }

                // then, handle the arguments
                val args: List<AExpr?> = expr.arguments.mapIndexed { i, arg ->
                    val argAnalysis = analyzeExpr(arg)
                    // check whether the argument type for this index matches
                    if (targetFunctionType != null && i < targetFunctionType.argumentTypes.size &&
                            argAnalysis.qualifiedType != null &&
                            argAnalysis.qualifiedType != targetFunctionType.argumentTypes[i]) {
                        errors.add(SemanticError.TypeMismatch(context,
                                targetFunctionType.argumentTypes[i],
                                argAnalysis.qualifiedType))
                    }

                    when (argAnalysis) {
                        is ExprVerificationResult.Failure -> {
                            errors.addAll(argAnalysis.errors)
                            null
                        }
                        is ExprVerificationResult.Success -> {
                            argAnalysis.aExpr
                        }
                    }
                }

                if (errors.isEmpty()) {
                    ExprVerificationResult.Success(targetFunctionType?.returnType,
                            if (callTargetExpr != null && args.all { it != null } && targetFunctionType != null)
                                AExpr.ACall(callTargetExpr, args.requireNoNulls(), targetFunctionType.returnType)
                            else
                                null
                    )
                } else {
                    ExprVerificationResult.Failure(targetFunctionType?.returnType, errors)
                }
            }
            is Expr.MethodCall -> {
                if (expr.receiver is Expr.UnqualifiedReference) {
                    // Check if there is a variable of that name in scope -
                    // if there is, we treat it as any other method call.
                    // If there isn't, we treat it as a module reference, like Int.abs(-1).
                    val referenceLookupResult = symbolTable.lookup(ValueReference(expr.receiver.ref), this.module, null, null)
                    val treatAsFuncCall = when (referenceLookupResult) {
                        is Pass03SymbolTable.LookupResult.ValueRefFound -> false
                        is Pass03SymbolTable.LookupResult.TempRefFound -> false
                        else -> true
                    }
                    if (treatAsFuncCall) {
                        return this.analyzeExpr(Expr.FunctionCall(
                                Expr.QualifiedReference(expr.receiver.ref, expr.methodName),
                                expr.arguments))
                    }
                }

                val errors = mutableListOf<SemanticError>()
                // first, analyze the receiver expression
                val receiverAnalysisResult = analyzeExpr(expr.receiver)
                val receiverAExpr = when (receiverAnalysisResult) {
                    is ExprVerificationResult.Success -> receiverAnalysisResult.aExpr
                    is ExprVerificationResult.Failure -> {
                        errors.addAll(receiverAnalysisResult.errors)
                        null
                    }
                }
                val receiverType: QualifiedType? = receiverAnalysisResult.qualifiedType

                // The algorithm is as follows (currently):
                // 1. Check the current scope. If a value with the name of the method was found, take it.
                // 2. If #1 failed, check the module of the receiver. If a value with the name of the method was found, take it.
                // 3. If #2 failed, report an unresolved reference error.

                val methodReference = ValueReference(expr.methodName)

                // do 1.
                val currentModuleMethodLookupResult = symbolTable.lookup(methodReference, module, null, null)
                val (currentModuleMethodReferenceType: QualifiedType?, foundInCurrentModule) = when (currentModuleMethodLookupResult) {
                    is Pass03SymbolTable.LookupResult.ValueRefFound -> Pair(currentModuleMethodLookupResult.qualifiedType, true)
                    else -> Pair(null, false)
                }
                // do 2.
                val receiverModule: Module? = when (receiverType) {
                    is QualifiedType.SimpleType -> Module(receiverType.packageName, receiverType.typeName)
                    null -> null
                    else -> null // ToDo we need to report some error here, but I'm not sure what it should be...?
                }
                // look up the method in the module of the receiver
                val (receiverModuleMethodReferenceType: QualifiedType?, foundInReceiverModule) =
                        if (receiverModule == null) Pair(null, false) else {
                            val methodLookupResult = symbolTable.lookup(methodReference, receiverModule, null, null)
                            when (methodLookupResult) {
                                is Pass03SymbolTable.LookupResult.ValueRefFound -> {
                                    Pair(methodLookupResult.qualifiedType, true)
                                }
                                else -> {
                                    Pair(null, false)
                                }
                            }
                        }

                // choose 1. first, then 2.
                var methodModule: Module? = null
                val methodReferenceType = if (currentModuleMethodReferenceType != null) {
                    methodModule = module
                    currentModuleMethodReferenceType
                } else if (receiverModuleMethodReferenceType != null) {
                    methodModule = receiverModule
                    receiverModuleMethodReferenceType
                } else {
                    null
                }
                if (!foundInCurrentModule && !foundInReceiverModule) {
                    errors.add(SemanticError.UnresolvedReference(context, methodReference))
                }
                val methodType: QualifiedType.FunctionType? = when (methodReferenceType) {
                    is QualifiedType.FunctionType -> {
                        // report an error about incorrect number of arguments
                        if (methodReferenceType.argumentTypes.size != expr.arguments.size + 1) {
                            errors.add(SemanticError.ArgumentCountMismatch(context,
                                    methodReferenceType.argumentTypes.size, expr.arguments.size))
                        }
                        methodReferenceType
                    }
                    null -> null
                    else -> {
                        // report an error that the target is of a non-invokable type
                        errors.add(SemanticError.NotInvokable(context, methodReferenceType))
                        null
                    }
                }

                // handle the arguments
                // first, check the receiver (= first argument)
                if (methodType != null && methodType.argumentTypes.isNotEmpty() &&
                            receiverType != null &&
                            receiverType != methodType.argumentTypes[0]) {
                    errors.add(SemanticError.TypeMismatch(context,
                            methodType.argumentTypes[0],
                            receiverType))
                }
                // then, check the remaining arguments
                val argExprs: List<AExpr?> = expr.arguments.mapIndexed { i, arg ->
                    val argAnalysis = analyzeExpr(arg)
                    // check whether the argument type for this index matches
                    if (methodType != null && i + 1 < methodType.argumentTypes.size &&
                            argAnalysis.qualifiedType != null &&
                            argAnalysis.qualifiedType != methodType.argumentTypes[i + 1]) {
                        errors.add(SemanticError.TypeMismatch(context,
                                methodType.argumentTypes[i + 1],
                                argAnalysis.qualifiedType))
                    }

                    when (argAnalysis) {
                        is ExprVerificationResult.Failure -> {
                            errors.addAll(argAnalysis.errors)
                            null
                        }
                        is ExprVerificationResult.Success -> {
                            argAnalysis.aExpr
                        }
                    }
                }

                if (errors.isEmpty()) {
                    ExprVerificationResult.Success(methodType?.returnType,
                            if (methodModule != null && receiverAExpr != null && argExprs.all { it != null } && methodType != null)
                                AExpr.ACall(
                                        AExpr.AValueReference(methodModule, expr.methodName, methodType),
                                        listOf(receiverAExpr) + argExprs.requireNoNulls(),
                                        methodType.returnType)
                            else
                                null
                    )
                } else {
                    ExprVerificationResult.Failure(methodType?.returnType, errors)
                }
            }
        }
    }

    private fun handleValueReference(ref: ValueReference, context: ErrorContext.ValueDefinition):
            ExprVerificationResult {
        // a null chain means a function - we don't care about an anchor in that case (functions can use forward declarations)
        val lookupResult = symbolTable.lookup(ref, module, if (chain == null) null else valName, chain)
        return when (lookupResult) {
            is Pass03SymbolTable.LookupResult.RefNotFound ->
                ExprVerificationResult.Failure(SemanticError.UnresolvedReference(context, ref))
            is Pass03SymbolTable.LookupResult.ForwardReference ->
                ExprVerificationResult.Failure(SemanticError.IllegalForwardReference(context, lookupResult.name))
            is Pass03SymbolTable.LookupResult.SelfReference ->
                ExprVerificationResult.Failure(SemanticError.IllegalSelfReference(context))
            is Pass03SymbolTable.LookupResult.CyclicReference ->
                ExprVerificationResult.Failure(SemanticError.CyclicDefinition(context, lookupResult.cycle))
            is Pass03SymbolTable.LookupResult.TempRefFound -> {
                val qualifiedType = lookupResult.qualifiedType
                val referenceExpr = if (qualifiedType == null)
                    null
                else if (lookupResult.isFuncArg)
                    AExpr.AFuncArgReference(ref.variable(), lookupResult.index, qualifiedType)
                else
                    AExpr.ATemporaryVarReference(ref.variable(), lookupResult.index, qualifiedType)
                ExprVerificationResult.Success(qualifiedType, referenceExpr)
            }
            is Pass03SymbolTable.LookupResult.ValueRefFound -> {
                val qualifiedType = lookupResult.qualifiedType
                ExprVerificationResult.Success(qualifiedType, if (qualifiedType == null)
                    null
                else
                    AExpr.AValueReference(lookupResult.module, ref.variable(), qualifiedType)
                )
            }
        }
    }

    private fun handleUnaryOperation(operand: Expr, expectedType: QualifiedType, cons: (AExpr) -> AExpr):
            ExprVerificationResult {
        val errors = mutableListOf<SemanticError>()
        val operandAnalysisResult = analyzeExpr(operand)
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
        if (operandType != null && operandType != expectedType) {
            errors.add(SemanticError.TypeMismatch(ErrorContext.ValueDefinition(valName), expectedType, operandType))
        }
        return if (errors.isEmpty())
            ExprVerificationResult.Success(expectedType, if (operandAast == null) null else
                cons(operandAast))
        else
            ExprVerificationResult.Failure(expectedType, errors)
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

    private fun handleIfExpression(ifExpr: Expr.If): ExprVerificationResult {
        val conditionAnalysisResult = analyzeExpr(ifExpr.conditionExpr)
        val thenAnalysisResult = analyzeExpr(ifExpr.thenExpr)
        val elseAnalysisResult = analyzeExpr(ifExpr.elseExpr)

        val errors = mutableListOf<SemanticError>()

        val conditionAast: AExpr? = when (conditionAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(conditionAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                conditionAnalysisResult.aExpr
            }
        }
        val conditionType = conditionAnalysisResult.qualifiedType

        val thenAast: AExpr? = when (thenAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(thenAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                thenAnalysisResult.aExpr
            }
        }
        val thenType = thenAnalysisResult.qualifiedType

        val elseAast: AExpr? = when (elseAnalysisResult) {
            is ExprVerificationResult.Failure -> {
                errors.addAll(elseAnalysisResult.errors)
                null
            }
            is ExprVerificationResult.Success -> {
                elseAnalysisResult.aExpr
            }
        }
        val elseType = elseAnalysisResult.qualifiedType

        val errorContext = ErrorContext.ValueDefinition(valName)
        if (conditionType != null && conditionType != BuiltInTypes.Bool) {
            errors.add(SemanticError.TypeMismatch(errorContext,
                    BuiltInTypes.Bool, conditionType))
        }
        if (thenType != null && elseType != null && thenType != elseType) {
            errors.add(SemanticError.TypeMismatch(errorContext,
                    thenType, elseType))
        }
        val returnType = thenType ?: elseType

        return if (errors.isEmpty()) {
            ExprVerificationResult.Success(returnType, if (conditionAast != null && thenAast != null && elseAast != null)
                AExpr.AIf(conditionAast, thenAast, elseAast)
            else
                null)
        } else {
            ExprVerificationResult.Failure(returnType, errors)
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

        symbolTable.pushNewScope(module, false)
        for (declaration in letExpr.declarations) {
            var aValueDeclaration: ADef.AValueDef? = null

            val result = ValueDeclarationVerifier(symbolTable, module, valName, chain, false).analyzeValueDeclaration(declaration)
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
                is Def.ValueDef.FunctionValueDef -> throw UnsupportedOperationException(
                        "Function declarations are not currently supported in 'let' expressions")
            }
            val qualifiedType = when (aValueDeclaration) {
                is ADef.AValueDef.ASimpleValueDef -> aValueDeclaration.type
                else -> null
            }
            if (!symbolTable.addToLatestScope(module, id, qualifiedType)) {
                errors.add(SemanticError.DuplicateDefinition(id, ErrorContext.ValueDefinition(valName)))
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
