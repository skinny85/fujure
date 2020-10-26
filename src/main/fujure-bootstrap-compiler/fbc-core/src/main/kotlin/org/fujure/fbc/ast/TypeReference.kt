package org.fujure.fbc.ast

/**
 * A value class that represents the name of a type in Fujure,
 * like "String", or "Outer.Inner".
 * Note that Fujure does not have fully-qualified types,
 * like Java does (for example, "java.lang.String").
 * Of course, the same type name can point to different qualified types,
 * depending on the context
 * (like the imports used in a file, or what package it is in).
 * To go from just a type name to an actual qualified type,
 * you need to use the Pass03SymbolTable.findTypeFamily() method.
 */
data class TypeName(private val ids: List<String>) {
    constructor(id: String, vararg ids: String) : this(listOf(id, *ids))

    fun inStringForm(): String = ids.joinToString(".")
    override fun toString() = inStringForm()
}

sealed class TypeReference {
    data class SimpleType(val typeName: TypeName, val genericTypes: List<TypeReference> = emptyList()) : TypeReference() {
        constructor(id: String, vararg ids: String) : this(TypeName(id, *ids))

        fun inStringForm(): String = typeName.inStringForm() +
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
