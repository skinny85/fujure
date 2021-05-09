package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.AArgument
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.analyze.PartialType
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.CompleteType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeVariables
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.common.NameValidator
import org.funktionale.either.Disjunction

class ValueDeclarationVerifier(private val symbolTable: Pass03SymbolTable,
        private val module: Module, private val valName: String,
        private val chain: List<ValueCoordinates>?,
        private val topLevelDeclaration: Boolean = true) {
    fun analyzeValueDeclaration(valueDeclaration: Def.ValueDef):
            Disjunction<List<SemanticError>, ADef.AValueDef?> {
        val errors = mutableListOf<SemanticError>()
        var aDef: ADef.AValueDef? = null

        // logic common to all kinds of values
        val context = ErrorContext.ValueDefinition(valName)
        if (!NameValidator.validValueName(valueDeclaration.id)) {
            errors.add(SemanticError.InvalidName(valueDeclaration.id))
        }

        when (valueDeclaration) {
            is Def.ValueDef.SimpleValueDef -> {
                val declaredQualifiedType = CompleteType.fromPartialType(partialType(valueDeclaration.declaredType, errors, context))

                if (valueDeclaration.initializer == null) {
                    errors.add(SemanticError.CannotBeAbstract(context, if (topLevelDeclaration) null else valueDeclaration.id))
                } else {
                    val initializerAnalysisResult = ExprVerifier(symbolTable, module, valName, chain)
                            .analyzeExpr(valueDeclaration.initializer)
                    val initializerType = initializerAnalysisResult.completeType
                    when (initializerAnalysisResult) {
                        is ExprVerificationResult.Failure -> {
                            errors.addAll(initializerAnalysisResult.errors)
                        }
                        is ExprVerificationResult.Success -> {
                            val initializerAExpr = initializerAnalysisResult.aExpr
                            val valueType = declaredQualifiedType ?: initializerType
                            if (valueType != null && initializerAExpr != null) {
                                aDef = ADef.AValueDef.ASimpleValueDef(valueDeclaration.id, valueType, initializerAExpr)
                            }
                        }
                    }
                    if (initializerType != null && declaredQualifiedType != null &&
                            declaredQualifiedType != initializerType) {
                        errors.add(SemanticError.TypeMismatch(context, declaredQualifiedType.partialType, initializerType.partialType))
                    }
                }
            }
            is Def.ValueDef.FunctionValueDef -> {
                // handle the function arguments
                val aArguments = mutableListOf<AArgument>()
                symbolTable.pushNewScope(module, true)
                for (argument in valueDeclaration.arguments) {
                    val argumentType = CompleteType.fromPartialType(partialType(argument.declaredType, errors, context))
                    if (!symbolTable.addToLatestScope(module, argument.id, argumentType)) {
                        errors.add(SemanticError.DuplicateDefinition(argument.id, context))
                    }
                    if (argument.declaredType == null) {
                        errors.add(SemanticError.TypeRequired.FunctionArgument(context, argument.id))
                    }
                    if (argument.initializer != null) {
                        errors.add(SemanticError.DefaultArgumentValueUnsupported(context, argument.id))
                    }
                    if (argumentType != null) {
                        aArguments.add(AArgument(argument.id, argumentType.partialType))
                    }
                }

                // handle the return type
                val returnType: PartialType? = if (valueDeclaration.returnType == null) {
                    errors.add(SemanticError.TypeRequired.FunctionReturn(context))
                    null
                } else {
                    partialType(valueDeclaration.returnType, errors, context)
                }

                // handle the body
                if (valueDeclaration.body == null) {
                    errors.add(SemanticError.CannotBeAbstract(context))
                } else {
                    val bodyAnalysisResult = ExprVerifier(symbolTable, module, valName, chain)
                            .analyzeExpr(valueDeclaration.body)
                    val bodyType = bodyAnalysisResult.completeType
                    when (bodyAnalysisResult) {
                        is ExprVerificationResult.Failure -> {
                            errors.addAll(bodyAnalysisResult.errors)
                        }
                        is ExprVerificationResult.Success -> {
                            val bodyAExpr = bodyAnalysisResult.aExpr
                            if (returnType != null && bodyAExpr != null) {
                                // ToDo allow function definitions to have type variables
                                aDef = ADef.AValueDef.AFunctionValueDef(valueDeclaration.id, TypeVariables(), aArguments, returnType, bodyAExpr)
                            }
                        }
                    }
                    if (bodyType != null && returnType != null &&
                            bodyType != CompleteType(returnType)) {
                        errors.add(SemanticError.TypeMismatch(context, returnType, bodyType.partialType))
                    }
                }

                symbolTable.popLatestScope(module)
            }
        }

        return if (errors.isEmpty())
            Disjunction.Right(aDef)
        else
            Disjunction.Left(errors)
    }

    private fun partialType(typeReference: TypeReference?, errors: MutableList<SemanticError>,
            context: ErrorContext.ValueDefinition): PartialType? {
        return when (typeReference) {
            is TypeReference.SimpleType -> {
                val genericTypes = typeReference.genericTypes.map { partialType(it, errors, context) }
                val typeFamily = symbolTable.findTypeFamily(typeReference.typeName, this.module)
                if (typeFamily == null) {
                    errors.add(SemanticError.TypeNotFound(context, typeReference.typeName))
                }
                if (typeFamily != null && genericTypes.all { it != null }) {
                    val ret = typeFamily.toPartialType(genericTypes.requireNoNulls())
                    if (ret == null) {
                        errors.add(SemanticError.TypeParametersMismatch(context, typeReference, typeFamily))
                    }
                    ret
                } else {
                    null
                }
            }
            is TypeReference.FunctionType -> {
                val qualifiedArgumentTypes = typeReference.argumentTypes.map { partialType(it, errors, context) }
                val qualifiedReturnType = partialType(typeReference.returnType, errors, context)
                if (qualifiedReturnType != null && qualifiedArgumentTypes.all { it != null }) {
                    PartialType.Func(qualifiedReturnType, qualifiedArgumentTypes.requireNoNulls())
                } else {
                    null
                }
            }
            null -> null
        }
    }
}
