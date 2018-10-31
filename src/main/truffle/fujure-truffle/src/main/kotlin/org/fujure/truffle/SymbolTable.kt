package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
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

    fun lookup(reference: ValueReference): LookupResult {
        if (reference.size != 1) {
            throw UnsupportedOperationException("Translating complex references like '$reference' to Truffle is not supported (yet)")
        } else {
            return moduleSymbolTables[currentModule]!!.lookup(reference.variable())
        }
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

    fun establishTypeOfValue(value: Any): QualifiedType? {
        return when (value) {
            is Char -> BuiltInTypes.Char
            is Int -> BuiltInTypes.Int
            is String -> BuiltInTypes.String
            else -> null
        }
    }
}
