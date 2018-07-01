package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode

class SymbolTable {
    internal val fujureTruffleBindings = FujureTruffleBindings()

    private val moduleSymbolTables = mutableMapOf<String, ModuleSymbolTable>()
    private lateinit var currentModule: String

    fun register(moduleNode: ModuleNode, frame: VirtualFrame) {
        val fqn = moduleNode.fullyQualifiedModuleName()
        val moduleSymbolTable = ModuleSymbolTable()
        moduleSymbolTables.put(fqn, moduleSymbolTable)
        currentModule = fqn
        moduleSymbolTable.register(moduleNode.definitions(), frame)

        fujureTruffleBindings.register(fqn, moduleSymbolTable)
    }

    fun lookup(ref: String): Any? {
        return moduleSymbolTables[currentModule]?.lookup(ref)
    }
}
