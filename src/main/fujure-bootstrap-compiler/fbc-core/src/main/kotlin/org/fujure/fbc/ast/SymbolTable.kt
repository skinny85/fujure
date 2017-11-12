package org.fujure.fbc.ast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.pass_01.FileSymbolTable
import kotlin.properties.Delegates

class SymbolTable(private val fileSymbolTables: List<FileSymbolTable>) {
    private var currentContext: FileSymbolTable by Delegates.notNull()

    fun enterContext(inputFile: InputFile) {
        // ToDo this needs to be better
        // (for example, return something nullable so the clients can assert instead)
        currentContext = fileSymbolTables.find { it.inputFile == inputFile }!!
    }

    // ToDo this entire API is meh at best
    fun fillInTypeFor(id: String, qualifiedType: QualifiedType) {
        currentContext.fillInTypeFor(id, qualifiedType)
    }

    fun findImport(import: Import): QualifiedType? {
        for (fileSymbolTable in fileSymbolTables) {
            val qualifiedType = fileSymbolTable.findImport(import)
            if (qualifiedType != null)
                return qualifiedType
        }
        return null
    }

    fun addToCurrentContext(qualifiedType: QualifiedType): Boolean {
        return true
    }

    fun lookup(ref: ValueReference): QualifiedType? {
        val targetContext: FileSymbolTable?
        val simpleName: String

        when (ref.ids.size) {
            1 -> {
                targetContext = currentContext
                simpleName = ref.ids[0]
            }
            2 -> {
                targetContext = findContextByName(ref.ids[0])
                simpleName = ref.ids[1]
            }
            else -> {
                targetContext = null
                simpleName = "whatever"
            }
        }
        return if (targetContext == null)
            null
        else
            targetContext.lookup(simpleName)
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

    private fun findContextByName(moduleName: String): FileSymbolTable? {
        return fileSymbolTables.find { it.inputFile.moduleName == moduleName }
    }
}
