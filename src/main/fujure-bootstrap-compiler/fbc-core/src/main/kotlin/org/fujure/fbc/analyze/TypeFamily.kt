package org.fujure.fbc.analyze

data class TypeFamily(val packageName: String, val typeName: String, val typeParameters: Int = 0) {
    fun inStringForm(): String = if (packageName.isEmpty() || packageName == "fujure")
        // we skip the 'fujure' prefix, as it's used for built-in types like Int, String, Double, etc.
        typeName
    else
        "$packageName.$typeName"

    fun toQualifiedType(genericTypes: List<QualifiedType> = emptyList()): QualifiedType? {
        return if (this.typeParameters == genericTypes.size)
            QualifiedType.SimpleType(this, genericTypes)
        else
            null
    }

    override fun toString(): String = inStringForm()
}

object BuiltInTypeFamilies {
    val Int = TypeFamily("fujure", "Int")
    val Unit = TypeFamily("fujure", "Unit")
    val Bool = TypeFamily("fujure", "Bool")
    val Char = TypeFamily("fujure", "Char")
    val String = TypeFamily("fujure", "String")
    val IO = TypeFamily("fujure.io.std", "IO", 1)
}
