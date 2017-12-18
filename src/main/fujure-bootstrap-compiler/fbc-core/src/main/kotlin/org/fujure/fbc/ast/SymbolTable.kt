package org.fujure.fbc.ast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import kotlin.properties.Delegates

class SymbolTable(private val fileSymbolTables: Set<FileSymbolTable>) {
    private var currentFile: FileSymbolTable by Delegates.notNull()

    fun enterContext(inputFile: InputFile) {
        // ToDo this needs to be better
        // (for example, return something nullable so the clients can assert instead)
        currentFile = fileSymbolTables.find { it.inputFile == inputFile }!!
    }

    fun registerImport(import: Import): SemanticError.UnresolvedImport? {
        if (import.size == 1) {
            // you cannot import classes from the default package in Java
            // (see more: https://stackoverflow.com/a/2193298),
            // so we ban it in Fujure as well
            return SemanticError.UnresolvedImport(import)
        } else {
            val packageName = import.allButLastFragments()
            val moduleName = import.lastFragment()

            val importedModule = findFile(packageName, moduleName)
            if (importedModule == null) {
                return SemanticError.UnresolvedImport(import)
            } else {
                currentFile.registerImport(moduleName, importedModule)
                return null
            }
        }
    }

    fun lookup(ref: ValueReference, anchorVariable: String? = null, chain: List<ValueCoordinates> = emptyList()): LookupResult {
        val fileLookupResult = currentFile.lookup(ref, anchorVariable, this, chain)
        if (fileLookupResult is LookupResult.RefNotFound &&
                ref.ids.size > 1) {
            // perhaps it's a reference to a non-imported module in the same package?
            val candidateModule = findFile(currentFile.packageName, ref.ids[0])
            if (candidateModule != null)
                return candidateModule.lookup(ref, anchorVariable, this, chain)
            // there's a very subtle edge case here - what if Filex was imported,
            // but didn't contain the requested field? In that case, we shouldn't search
            // for Filex in the same package - that would be wrong!
        }
        return fileLookupResult
    }

    fun findType(typeReference: TypeReference): QualifiedType? {
        if (typeReference.ids.size != 1) {
            return null
        } else {
            val id = typeReference.ids[0]
            return when (id) {
                "Int" -> BuiltInTypes.Int
                "Unit" -> BuiltInTypes.Unit
                "Bool" -> BuiltInTypes.Bool
                "Char" -> BuiltInTypes.Char
                "String" -> BuiltInTypes.String
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
        data class RefFound(val qualifiedType: QualifiedType?, val module: Module) : LookupResult()
    }
}
