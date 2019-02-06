package org.fujure.truffle

import com.oracle.truffle.api.Scope
import org.fujure.fbc.ast.Module

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf(
            Scope.newBuilder("global", fujureTruffleBindings).build())

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
}
