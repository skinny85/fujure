package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.truffle.nodes.ModuleNode

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf<Scope>(Scope.newBuilder("global", fujureTruffleBindings).build())

    fun register(moduleNode: ModuleNode, frame: VirtualFrame) {
        fujureTruffleBindings.register(moduleNode, frame)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
