package org.fujure.fbc.analyze

data class TypeVariables(private val variables: List<String> = emptyList()) {
    constructor(firstVariable: String, vararg remainingVariables: String): this(listOf(firstVariable, *remainingVariables))
}

data class CompleteType(val variables: TypeVariables, val partialType: PartialType) {
    constructor(partialType: PartialType): this(TypeVariables(), partialType)

    companion object {
        fun fromPartialType(partialType: PartialType?): CompleteType? {
            return if (partialType == null)
                null
            else
                CompleteType(partialType)
        }
    }
}

sealed class PartialType {
    abstract fun inStringForm(): String

    data class SimpleType internal constructor(private val typeFamily: TypeFamily, private val genericTypes: List<PartialType> = emptyList()) : PartialType() {
        override fun inStringForm(): String {
            val typeFamilyPart = this.typeFamily.inStringForm()

            val genericPart = if (genericTypes.isEmpty())
                ""
            else
                "<" + genericTypes.joinToString(", ") { it.inStringForm() } + ">"

            return typeFamilyPart + genericPart
        }

        val packageName = this.typeFamily.packageName
        val typeName = this.typeFamily.typeName

        override fun toString(): String = inStringForm()
    }

    data class FunctionType(val returnType: PartialType, val argumentTypes: List<PartialType>) : PartialType() {
        override fun inStringForm(): String {
            val argumentsPart = if (argumentTypes.isEmpty())
                "()"
            else
                argumentTypes.joinToString(" -> ") { renderTypeInFunction(it) }
            return "$argumentsPart -> ${renderTypeInFunction(returnType)}"
        }

        private fun renderTypeInFunction(type: PartialType): String = when (type) {
            is SimpleType -> type.inStringForm()
            is FunctionType -> "(" + type.inStringForm() + ")"
        }
    }
}

object BuiltInTypes {
    val Int = PartialType.SimpleType(BuiltInTypeFamilies.Int)
    val Unit = PartialType.SimpleType(BuiltInTypeFamilies.Unit)
    val Bool = PartialType.SimpleType(BuiltInTypeFamilies.Bool)
    val Char = PartialType.SimpleType(BuiltInTypeFamilies.Char)
    val String = PartialType.SimpleType(BuiltInTypeFamilies.String)
    fun io(partialType: PartialType): PartialType {
        return PartialType.SimpleType(BuiltInTypeFamilies.IO, listOf(partialType))
    }
}
