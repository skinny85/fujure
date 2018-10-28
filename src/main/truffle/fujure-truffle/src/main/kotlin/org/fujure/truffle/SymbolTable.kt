package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.TypeReference
import org.fujure.truffle.nodes.ModuleNode

class SymbolTable {
    internal val fujureTruffleBindings = FujureTruffleBindings()

    private val moduleSymbolTables = mutableMapOf<String, ModuleSymbolTable>()
    private lateinit var currentModule: String

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        val fqn = moduleNode.fullyQualifiedModuleName()
        val moduleSymbolTable = ModuleSymbolTable()
        moduleSymbolTables.put(fqn, moduleSymbolTable)
        currentModule = fqn
        val loadModuleResult = moduleSymbolTable.load(moduleNode, frame)

        if (loadModuleResult.isSuccess()) {
            fujureTruffleBindings.register(fqn, moduleSymbolTable)
        }

        return loadModuleResult
    }

    fun lookup(ref: String): LookupResult {
        return moduleSymbolTables[currentModule]!!.lookup(ref)
    }

    fun findType(typeReference: TypeReference): QualifiedType? {
        if (typeReference.ids.size != 1) {
            return null
        } else {
            val id = typeReference.ids[0]
            return when (id) {
                "Int" -> BuiltInTypes.Int
                "Char" -> BuiltInTypes.Char
                "String" -> BuiltInTypes.String
                else -> null
            }
        }
    }

    fun establishTypeOfValue(value: Any): QualifiedType? {
        return when (value) {
            is Char -> BuiltInTypes.Char
            is Int -> BuiltInTypes.Int
            is String -> BuiltInTypes.String
            else -> null
        }
    }
}
