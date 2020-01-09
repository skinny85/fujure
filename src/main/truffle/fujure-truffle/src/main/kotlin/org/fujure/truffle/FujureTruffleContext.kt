package org.fujure.truffle

import com.oracle.truffle.api.Scope
import org.fujure.fbc.ast.Module

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf(
            Scope.newBuilder("global", fujureTruffleBindings).build())
    private val localScopes = mutableListOf<FujureTruffleBindings.ModuleBindings>()

    fun resetModule(module: Module) {
        fujureTruffleBindings.resetModule(module)
    }

    fun registerValue(module: Module, name: String, value: Any) {
        fujureTruffleBindings.registerValue(module, name, value)
    }

    fun find(targetModule: Module, reference: String): Any {
        return fujureTruffleBindings.find(targetModule, reference)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }

    fun enterNewLocalScope(frameDescriptor: FujureTruffleBindings.ModuleBindings) {
        localScopes.add(0, frameDescriptor)
    }

    fun findInLocalScopes(reference: String): LocalSearchResult {
        val containingScope = localScopes.find { it.contains(reference) }
        return if (containingScope == null)
            LocalSearchResult.Miss
        else
            LocalSearchResult.Hit(containingScope)
    }

    fun leaveLatestLocalScope() {
        localScopes.removeAt(0)
    }

    sealed class LocalSearchResult {
        class Hit(val bindings: FujureTruffleBindings.ModuleBindings) : LocalSearchResult()
        object Miss : LocalSearchResult()
    }
}
