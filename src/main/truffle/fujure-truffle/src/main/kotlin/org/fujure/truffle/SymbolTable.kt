package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode

class SymbolTable {
    internal val fujureTruffleBindings = FujureTruffleBindings()

    private val moduleSymbolTables = mutableMapOf<String, ModuleSymbolTable>()
    private lateinit var currentModule: String

    fun register(moduleNode: ModuleNode, frame: VirtualFrame) {
        val fqn = moduleNode.fullyQualifiedModuleName()
        currentModule = fqn
        // ToDO this doesn't actually work!
        // ModuleSymbolTable constructor tries to execute the initializers of the definitions,
        // but if they contain reference expressions, they will call `lookup`, and, at this point,
        // always get null back!
        val moduleSymbolTable = ModuleSymbolTable(moduleNode, frame)
        moduleSymbolTables.put(fqn, moduleSymbolTable)
        fujureTruffleBindings.register(moduleNode, frame)
    }

    fun lookup(ref: String): Any? {
        return moduleSymbolTables[currentModule]?.lookup(ref)
    }
}
