package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode
import java.util.Optional

class FujureTruffleContext {
    private val symbolTable = SymbolTable()
    private val topScopes = setOf<Scope>(
            Scope
                    .newBuilder("global", symbolTable.fujureTruffleBindings)
                    .build())

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        return symbolTable.load(moduleNode, frame)
    }

    fun lookup(ref: String): Optional<Optional<Any>> {
        return symbolTable.lookup(ref)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
