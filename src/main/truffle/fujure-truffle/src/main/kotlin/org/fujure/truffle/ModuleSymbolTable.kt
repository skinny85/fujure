package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.SimpleValueDefNode

class ModuleSymbolTable(private val moduleNode: ModuleNode) {
    private val bindings = mutableMapOf<String, Any>()

    internal fun execute(frame: VirtualFrame) {
        moduleNode.definitions().forEach { defNode ->
            if (defNode is SimpleValueDefNode) {
                bindings[defNode.id] = defNode.execute(frame)
            }
        }
    }

    fun phase2lookup(ref: String): Any? {
        return bindings[ref]
    }

    fun valueNames(): Set<String> = bindings.keys
}
