package org.fujure.fbc.ast

sealed class Def {
    sealed class ValueDef : Def() {
        data class SimpleValueDef(val id: String, val declaredType: TypeReference?, val initializer: Expr?) : ValueDef()
    }
}
