package org.fujure.fbc.ast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.pass_01.FileSymbolTable
import org.funktionale.option.Option
import kotlin.properties.Delegates

class SymbolTable(private val fileSymbolTables: List<FileSymbolTable>) {
    private var currentFile: FileSymbolTable by Delegates.notNull()

    fun enterContext(inputFile: InputFile) {
        // ToDo this needs to be better
        // (for example, return something nullable so the clients can assert instead)
        currentFile = fileSymbolTables.find { it.inputFile == inputFile }!!
    }

    fun lookup(ref: ValueReference, anchorVariable: String): LookupResult {
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
            val optTypeRef = targetFile.lookup(simpleName, anchor)
            when (optTypeRef) {
                is Option.None -> LookupResult.RefNotFound
                is Option.Some -> {
                    val typeRef = optTypeRef.t
                    if (typeRef == null)
                        LookupResult.ForwardReference(simpleName)
                    else
                        LookupResult.RefFound(findType(typeRef))
                }
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
        data class RefFound(val qualifiedType: QualifiedType?) : LookupResult()
    }
}
