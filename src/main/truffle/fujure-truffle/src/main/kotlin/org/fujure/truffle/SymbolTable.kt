package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode
import java.util.Optional

class SymbolTable {
    internal val fujureTruffleBindings = FujureTruffleBindings()

    private val moduleSymbolTables = mutableMapOf<String, ModuleSymbolTable>()
    private lateinit var currentModule: String

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        val fqn = moduleNode.fullyQualifiedModuleName()
        val moduleSymbolTable = ModuleSymbolTable()
        moduleSymbolTables.put(fqn, moduleSymbolTable)
        currentModule = fqn
        val loadModuleResult = moduleSymbolTable.load(moduleNode.definitions(), frame)

        if (loadModuleResult.isSuccess()) {
            fujureTruffleBindings.register(fqn, moduleSymbolTable)
        }

        return loadModuleResult
    }

    fun lookup(ref: String): Optional<Optional<Any>> {
        return moduleSymbolTables[currentModule]!!.lookup(ref)
    }
}
