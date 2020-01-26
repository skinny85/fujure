package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.ADef
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.common.NameValidator
import org.funktionale.either.Disjunction

class ValueDeclarationVerifier(private val symbolTable: Pass03SymbolTable,
        private val module: Module, private val valName: String,
        private val chain: List<ValueCoordinates>,
        private val topLevelDeclaration: Boolean = true) {
    fun analyzeValueDeclaration(valueDeclaration: Def.ValueDef):
            Disjunction<List<SemanticError>, ADef.AValueDef?> {
        val errors = mutableListOf<SemanticError>()
        var aDef: ADef.AValueDef? = null

        when (valueDeclaration) {
            is Def.ValueDef.SimpleValueDef -> {
                val context = ErrorContext.ValueDefinition(valName)

                if (!NameValidator.validValueName(valueDeclaration.id)) {
                    errors.add(SemanticError.InvalidName(valueDeclaration.id))
                }

                val declaredQualifiedType = qualifiedType(valueDeclaration.declaredType, errors, context)

                if (valueDeclaration.initializer == null) {
                    errors.add(SemanticError.CannotBeAbstract(context, if (topLevelDeclaration) null else valueDeclaration.id))
                } else {
                    val initializerAnalysisResult = ExprVerifier(symbolTable, module, valName, chain)
                            .analyzeExpr(valueDeclaration.initializer)
                    val initializerType = initializerAnalysisResult.qualifiedType
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
                        errors.add(SemanticError.TypeMismatch(context, declaredQualifiedType, initializerType))
                    }
                }
            }
        }

        return if (errors.isEmpty())
            Disjunction.Right(aDef)
        else
            Disjunction.Left(errors)
    }

    private fun qualifiedType(typeReference: TypeReference?, errors: MutableList<SemanticError>,
            context: ErrorContext.ValueDefinition): QualifiedType? {
        return when (typeReference) {
            is TypeReference.SimpleType -> {
                val ret = symbolTable.findType(typeReference)
                if (ret == null) {
                    errors.add(SemanticError.TypeNotFound(context, typeReference))
                }
                ret
            }
            is TypeReference.FunctionType -> {
                val qualifiedArgumentTypes = typeReference.argumentTypes.map { qualifiedType(it, errors, context) }
                val qualifiedReturnType = qualifiedType(typeReference.returnType, errors, context)
                if (qualifiedReturnType != null && qualifiedArgumentTypes.all { it != null }) {
                    QualifiedType.FunctionType(qualifiedReturnType, qualifiedArgumentTypes.requireNoNulls())
                } else {
                    null
                }
            }
            null -> null
        }
    }
}
