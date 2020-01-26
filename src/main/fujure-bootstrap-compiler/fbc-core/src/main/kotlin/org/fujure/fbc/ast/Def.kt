package org.fujure.fbc.ast

sealed class Def {
    sealed class ValueDef : Def() {
        abstract val id: String

        data class SimpleValueDef(override val id: String, val declaredType: TypeReference?, val initializer: Expr?) : ValueDef()

        data class FunctionValueDef(override val id: String, val arguments: List<SimpleValueDef>,
                val returnType: TypeReference?, val body: Expr?) : ValueDef()
    }
}
