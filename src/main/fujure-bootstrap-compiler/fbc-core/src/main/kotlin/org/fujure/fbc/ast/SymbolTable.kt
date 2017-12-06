package org.fujure.fbc.ast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import kotlin.properties.Delegates

class SymbolTable(private val fileSymbolTables: Set<FileSymbolTable>) {
    private var currentFile: FileSymbolTable by Delegates.notNull()

    fun enterContext(inputFile: InputFile) {
        // ToDo this needs to be better
        // (for example, return something nullable so the clients can assert instead)
        currentFile = fileSymbolTables.find { it.inputFile == inputFile }!!
    }

    fun lookup(ref: ValueReference, anchorVariable: String, chain: List<ValueCoordinates> = emptyList()): LookupResult {
        val targetFile: FileSymbolTable?
        val simpleName: String
        val anchor: String?

        when (ref.ids.size) {
            1 -> {
                targetFile = currentFile
                simpleName = ref.ids[0]
                anchor = anchorVariable
            }
            2 -> {
                targetFile = findFile(currentFile.packageName, ref.ids[0])
                simpleName = ref.ids[1]
                anchor = if (targetFile == currentFile) anchorVariable else null
            }
            else -> {
                targetFile = null
                simpleName = "not used"
                anchor = null
            }
        }
        return if (targetFile == null) {
            LookupResult.RefNotFound
        } else {
            val lookupResult = targetFile.lookup(simpleName, anchor, this, chain)
            when (lookupResult) {
                is FileSymbolTable.LookupResult.RefNotFound ->
                    LookupResult.RefNotFound
                is FileSymbolTable.LookupResult.ForwardReference ->
                    LookupResult.ForwardReference(simpleName)
                is FileSymbolTable.LookupResult.SelfReference ->
                    LookupResult.SelfReference(simpleName)
                is FileSymbolTable.LookupResult.CyclicReference ->
                    LookupResult.CyclicReference(lookupResult.cycle)
                is FileSymbolTable.LookupResult.RefFound ->
                    LookupResult.RefFound(lookupResult.qualifiedType)
            }
        }
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

    private fun findFile(packageName: String, moduleName: String): FileSymbolTable? {
        return fileSymbolTables.find {
            it.packageName == packageName &&
                    it.inputFile.moduleName == moduleName
        }
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        data class ForwardReference(val name: String) : LookupResult()
        data class SelfReference(val name: String) : LookupResult()
        data class CyclicReference(val cycle: List<ValueCoordinates>) : LookupResult()
        data class RefFound(val qualifiedType: QualifiedType?) : LookupResult()
    }
}
