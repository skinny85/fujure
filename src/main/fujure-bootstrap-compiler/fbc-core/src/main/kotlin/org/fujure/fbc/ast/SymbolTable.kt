package org.fujure.fbc.ast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.pass_01.FileSymbolTable
import kotlin.properties.Delegates

class SymbolTable(private val fileSymbolTables: List<FileSymbolTable>) {
    private var currentContext: FileSymbolTable by Delegates.notNull()

    fun enterContext(userProvidedFilePath: String) {
        // ToDo this needs to be better
        // (for example, return something nullable so the clients can assert instead)
        currentContext = fileSymbolTables.find { it.userProvidedFilePath == userProvidedFilePath }!!
    }

    // ToDo this entire API is meh at best
    fun fillInTypeFor(id: String, qualifiedType: QualifiedType) {
        currentContext.fillInTypeFor(id, qualifiedType)
    }

    fun lookup(id: String): QualifiedType? {
        return currentContext.lookup(id)
    }

    fun findType(typeReference: TypeReference): QualifiedType? {
        if (typeReference.ids.size != 1) {
            return null
        } else {
            val id = typeReference.ids[0]
            return when (id) {
                "Int" -> BuiltInTypes.Int
                "Bool" -> BuiltInTypes.Bool
                else -> null
            }
        }
    }
}
