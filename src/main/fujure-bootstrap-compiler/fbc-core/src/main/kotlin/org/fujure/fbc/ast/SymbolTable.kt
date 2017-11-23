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

    fun lookup(ref: ValueReference): Option<QualifiedType?> {
        val targetFile: FileSymbolTable?
        val simpleName: String

        when (ref.ids.size) {
            1 -> {
                targetFile = currentFile
                simpleName = ref.ids[0]
            }
            2 -> {
                targetFile = findFile(currentFile.packageName, ref.ids[0])
                simpleName = ref.ids[1]
            }
            else -> {
                targetFile = null
                simpleName = "not used"
            }
        }
        return if (targetFile == null)
            Option.None
        else {
            val typeReference = targetFile.lookup(simpleName)
            if (typeReference == null) Option.None else Option.Some(findType(typeReference))
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
}
