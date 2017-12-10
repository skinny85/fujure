package org.fujure.fbc.analyze

data class QualifiedType(val packageName: String, val typeName: String) {
    fun inStringForm(): String = "$packageName.$typeName"
}

object BuiltInTypes {
    val Int = QualifiedType("fujure", "Int")
    val Unit = QualifiedType("fujure", "Unit")
    val Bool = QualifiedType("fujure", "Bool")
    val Char = QualifiedType("fujure", "Char")
}
