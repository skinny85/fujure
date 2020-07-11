package org.fujure.fbc.analyze

import org.fujure.fbc.analyze.QualifiedType.SimpleType

sealed class QualifiedType {
    abstract fun inStringForm(): String

    data class SimpleType(val packageName: String, val typeName: String) : QualifiedType() {
        override fun inStringForm(): String = if (packageName.isEmpty() || packageName == "fujure")
            // we skip the 'fujure' prefix, as it's used for built-in types like Int, String, Double, etc.
            typeName
        else
            "$packageName.$typeName"
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
    val Int = SimpleType("fujure", "Int")
    val Unit = SimpleType("fujure", "Unit")
    val Bool = SimpleType("fujure", "Bool")
    val Char = SimpleType("fujure", "Char")
    val String = SimpleType("fujure", "String")
    val IO = SimpleType("fujure.io.std", "IO")
}
