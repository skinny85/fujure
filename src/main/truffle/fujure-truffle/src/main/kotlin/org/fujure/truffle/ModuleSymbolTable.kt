package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.SimpleValueDefNode

class ModuleSymbolTable(moduleNode: ModuleNode, frame: VirtualFrame) {
    private val bindings: Map<String, Any>

    init {
        bindings = moduleNode.definitions()
                .filter { defNode -> defNode is SimpleValueDefNode }
                .associate {
                    val defNode = it as SimpleValueDefNode
                    Pair(defNode.id, defNode.execute(frame))
                }
    }

    fun lookup(ref: String): Any? {
        return bindings[ref]
    }
}
