package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.ADef
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueCoordinates
import org.funktionale.either.Disjunction

class ValueDeclarationVerifier(private val symbolTable: Pass03SymbolTable,
        private val module: Module, private val valName: String,
        private val chain: List<ValueCoordinates>) {
    fun analyzeValueDeclaration(valueDeclaration: Def.ValueDef):
            Disjunction<List<SemanticError>, ADef.AValueDef?> {
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

                // ToDo we need to move name validation here

                if (valueDeclaration.initializer == null) {
                    errors.add(SemanticError.MissingInitializer(context))
                } else {
                    val initializerAnalysisResult = ExprVerifier(symbolTable, module, valName, chain)
                            .analyzeExpr(valueDeclaration.initializer)
                    when (initializerAnalysisResult) {
                        is ExprVerificationResult.Failure -> {
                            errors.addAll(initializerAnalysisResult.errors)
                        }
                        is ExprVerificationResult.Success -> {
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
}
