package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticProblem
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.ast.TypeReference
import org.funktionale.either.Either

class FileSymbolTable(val inputFile: InputFile, simpleValues: MutableMap<String, Pair<TypeReference?, Expr>>,
                      val packageName: String) {
    private class SimpleValueTypeHolder(declaredType: TypeReference?, initializingExpression: Expr) {
        var initializerExpressionCheckState: InitializerExpressionCheckState =
                InitializerExpressionCheckState.NotYetCheckedInitializer(declaredType, initializingExpression)

        fun flipTo(qualifiedType: QualifiedType) {
            val expressionCheckState = this.initializerExpressionCheckState
            if (expressionCheckState is InitializerExpressionCheckState.CheckedInitializerCorrect)
                throw IllegalStateException("already given a type: ${expressionCheckState.qualifiedType}")
            this.initializerExpressionCheckState = InitializerExpressionCheckState.CheckedInitializerCorrect(qualifiedType)
        }

        fun lookup(symbolTable: SymbolTable): QualifiedType? {
            val expressionCheckState = this.initializerExpressionCheckState
            return when (expressionCheckState) {
                is InitializerExpressionCheckState.NotYetCheckedInitializer -> {
                    val initExprResult = VerificationAnalysis.exprType(expressionCheckState.initializingExpression, symbolTable)
                    // Any errors here will be reported by semantic analysis when it gets to this node.
                    // For now, we ignore them
                    val type: QualifiedType? = if (initExprResult is Either.Right) initExprResult.r else null
                    initializerExpressionCheckState = InitializerExpressionCheckState.CheckedInitializerCorrect(type)
                    type
                }
                is InitializerExpressionCheckState.CheckedInitializerCorrect -> {
                    expressionCheckState.qualifiedType
                }
                is InitializerExpressionCheckState.CheckedInitializerIncorrect -> {
                    null
                }
            }
        }
    }

    private sealed class InitializerExpressionCheckState {
        data class NotYetCheckedInitializer(val declaredType: TypeReference?, val initializingExpression: Expr) :
                InitializerExpressionCheckState()
        data class CheckedInitializerCorrect(val qualifiedType: QualifiedType?) :
                InitializerExpressionCheckState()
        data class CheckedInitializerIncorrect(val semanticProblem: SemanticProblem) :
                InitializerExpressionCheckState()
    }

    private val simpleValuesTypes: Map<String, SimpleValueTypeHolder> =
            simpleValues.mapValues { SimpleValueTypeHolder(it.value.first, it.value.second) }

    fun fillInTypeFor(id: String, qualifiedType: QualifiedType) {
        val holder = simpleValuesTypes[id]!!
        holder.flipTo(qualifiedType)
    }

    fun lookup(id: String, symbolTable: SymbolTable): QualifiedType? {
        val holder = simpleValuesTypes[id]
        return holder?.lookup(symbolTable)
    }
}

class FileSymbolTableBuilder(val inputFile: InputFile, val packageName: String) {
    private val simpleValues = mutableMapOf<String, Pair<TypeReference?, Expr>>()

    fun noteSimpleValueDeclaration(id: String, declaredType: TypeReference?, initializingExpression: Expr): Boolean =
            simpleValues.putIfAbsent(id, Pair(declaredType, initializingExpression)) == null

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues, packageName)
    }
}
