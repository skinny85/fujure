package org.fujure.fbc.analyze

import org.fujure.fbc.analyze.QualifiedType.SimpleType

sealed class QualifiedType {
    abstract fun inStringForm(): String

    data class SimpleType internal constructor(private val typeFamily: TypeFamily, private val genericTypes: List<QualifiedType> = emptyList()) : QualifiedType() {
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

    data class FunctionType(val returnType: QualifiedType, val argumentTypes: List<QualifiedType>) : QualifiedType() {
        override fun inStringForm(): String {
            val argumentsPart = if (argumentTypes.isEmpty())
                "()"
            else
                argumentTypes.joinToString(" -> ") { renderTypeInFunction(it) }
            return "$argumentsPart -> ${renderTypeInFunction(returnType)}"
        }

        private fun renderTypeInFunction(type: QualifiedType): String = when (type) {
            is SimpleType -> type.inStringForm()
            is FunctionType -> "(" + type.inStringForm() + ")"
        }
    }
}

object BuiltInTypes {
    val Int: SimpleType = SimpleType(BuiltInTypeFamilies.Int)
    val Unit: SimpleType = SimpleType(BuiltInTypeFamilies.Unit)
    val Bool: SimpleType = SimpleType(BuiltInTypeFamilies.Bool)
    val Char: SimpleType = SimpleType(BuiltInTypeFamilies.Char)
    val String: SimpleType = SimpleType(BuiltInTypeFamilies.String)
    fun io(qualifiedType: QualifiedType): SimpleType {
        return SimpleType(BuiltInTypeFamilies.IO, listOf(qualifiedType))
    }
}
