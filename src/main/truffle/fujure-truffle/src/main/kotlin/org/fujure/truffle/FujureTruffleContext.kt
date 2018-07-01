package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode

class FujureTruffleContext {
    private val symbolTable = SymbolTable()
    private val topScopes = setOf<Scope>(
            Scope
                    .newBuilder("global", symbolTable.fujureTruffleBindings)
                    .build())

    fun register(moduleNode: ModuleNode, frame: VirtualFrame) {
        symbolTable.register(moduleNode, frame)
    }

    fun lookup(ref: String): Any? {
        return symbolTable.lookup(ref)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
