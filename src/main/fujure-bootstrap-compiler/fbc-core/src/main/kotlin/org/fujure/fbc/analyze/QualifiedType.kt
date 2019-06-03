package org.fujure.fbc.analyze

interface QualifiedType {
    fun inStringForm(): String
}

private data class SimpleType(val packageName: String, val typeName: String) : QualifiedType {
    override fun inStringForm() = "$packageName.$typeName"
}

private data class FunctionType(val returnType: QualifiedType, val argumentTypes: List<QualifiedType>) : QualifiedType {
    override fun inStringForm(): String {
        return "(${argumentTypes.map { it.inStringForm() }.joinToString()}) -> ${returnType.inStringForm()}"
    }
}

object BuiltInTypes {
    val Int: QualifiedType = SimpleType("fujure", "Int")
    val Unit: QualifiedType = SimpleType("fujure", "Unit")
    val Bool: QualifiedType = SimpleType("fujure", "Bool")
    val Char: QualifiedType = SimpleType("fujure", "Char")
    val String: QualifiedType = SimpleType("fujure", "String")
}
