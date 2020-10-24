package org.fujure.fbc.ast

sealed class TypeReference {
    data class SimpleType(val ids: List<String>, val genericTypes: List<TypeReference> = emptyList()) : TypeReference() {
        constructor(id: String, vararg ids: String) : this(listOf(id, *ids))
        fun inStringForm(): String = ids.joinToString(".") +
                (if (genericTypes.isEmpty()) "" else "<${genericTypes.joinToString(", ") { renderTypeReference(it) } }>")

        override fun toString(): String = inStringForm()
    }

    data class FunctionType(val returnType: TypeReference, val argumentTypes: List<TypeReference>) : TypeReference()
}

fun renderTypeReference(typeReference: TypeReference): String = when (typeReference) {
    is TypeReference.SimpleType -> typeReference.inStringForm()
    is TypeReference.FunctionType -> {
        val argumentsPart = if (typeReference.argumentTypes.isEmpty())
            "()"
        else
            typeReference.argumentTypes.joinToString(" -> ") { renderTypeReferenceInFunction(it) }

        "$argumentsPart -> ${renderTypeReferenceInFunction(typeReference.returnType)}"
    }
}

fun renderTypeReferenceInFunction(typeReference: TypeReference): String = when (typeReference) {
    is TypeReference.SimpleType -> renderTypeReference(typeReference)
    is TypeReference.FunctionType -> "(" + renderTypeReference(typeReference) + ")"
}
