package org.fujure.fbc.analyze

import org.fujure.fbc.analyze.QualifiedType.SimpleType

sealed class QualifiedType {
    abstract fun inStringForm(): String

    data class SimpleType(val packageName: String, val typeName: String) : QualifiedType() {
        override fun inStringForm(): String = "$packageName.$typeName"
    }

    data class FunctionType(val returnType: QualifiedType, val argumentTypes: List<QualifiedType>) : QualifiedType() {
        override fun inStringForm(): String {
            return "(${argumentTypes.joinToString(", ") { it.inStringForm() }}) -> ${returnType.inStringForm()}"
        }
    }
}

object BuiltInTypes {
    val Int = SimpleType("fujure", "Int")
    val Unit = SimpleType("fujure", "Unit")
    val Bool = SimpleType("fujure", "Bool")
    val Char = SimpleType("fujure", "Char")
    val String = SimpleType("fujure", "String")
}
