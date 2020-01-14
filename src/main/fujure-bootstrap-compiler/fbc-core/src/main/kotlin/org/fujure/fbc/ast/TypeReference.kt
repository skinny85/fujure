package org.fujure.fbc.ast

sealed class TypeReference {
    data class SimpleType(val ids: List<String>) : TypeReference() {
        constructor(id: String, vararg ids: String) : this(listOf(id, *ids))
        fun inStringForm(): String = ids.joinToString(".")
    }

    data class FunctionType(val returnType: TypeReference, val argumentTypes: List<TypeReference>) : TypeReference()
}
