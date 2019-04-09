package org.fujure.truffle

import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.frame.FrameDescriptor
import com.oracle.truffle.api.frame.FrameSlot
import org.fujure.fbc.ast.Module

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf(
            Scope.newBuilder("global", fujureTruffleBindings).build())
    private val localScopes = mutableListOf<FrameDescriptor>()

    fun resetModule(module: Module) {
        fujureTruffleBindings.resetModule(module)
    }

    fun registerSimpleValue(module: Module, name: String, value: Any) {
        fujureTruffleBindings.registerSimpleValue(module, name, value)
    }

    fun find(targetModule: Module, reference: String): Any {
        return fujureTruffleBindings.find(targetModule, reference)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }

    fun enterNewLocalScope(frameDescriptor: FrameDescriptor) {
        localScopes.add(0, frameDescriptor)
    }

    fun findInLocalScopes(reference: String): LocalSearchResult {
        for (localScope in localScopes) {
            val frameSlot = localScope.findFrameSlot(reference)
            if (frameSlot != null) {
                return LocalSearchResult.Hit(frameSlot)
            }
        }
        return LocalSearchResult.Miss
    }

    fun leaveLatestLocalScope() {
        localScopes.removeAt(0)
    }

    sealed class LocalSearchResult {
        class Hit(val frameSlot: FrameSlot) : LocalSearchResult()
        object Miss : LocalSearchResult()
    }
}
