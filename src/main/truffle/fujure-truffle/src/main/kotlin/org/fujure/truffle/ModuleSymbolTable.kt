package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.SimpleValueDefNode

class ModuleSymbolTable() {
    private val bindings = mutableMapOf<String, Any>()

    fun register(definitions: List<DefNode>, frame: VirtualFrame) {
        definitions.forEach { defNode ->
            if (defNode is SimpleValueDefNode) {
                bindings[defNode.id] = defNode.execute(frame)
            }
        }
    }

    fun lookup(ref: String): Any? {
        return bindings[ref]
    }

    fun valueNames(): Set<String> = bindings.keys
}
