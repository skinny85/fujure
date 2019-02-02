package org.fujure.truffle

import com.oracle.truffle.api.Scope
import org.fujure.fbc.ast.Module

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf<Scope>(
            Scope
                    .newBuilder("global", fujureTruffleBindings)
                    .build())

    fun enterModuleScope(module: Module) {
         fujureTruffleBindings.enterModuleScope(module)
    }

    fun resetCurrentModule() {
        fujureTruffleBindings.resetCurrentModule()
    }

    fun registerInCurrentModule(name: String, value: Any) {
        fujureTruffleBindings.registerInCurrentModule(name, value)
    }

    fun leaveCurrentModule() {
        fujureTruffleBindings.leaveCurrentModule()
    }

    fun find(targetModule: Module, reference: String): Any {
        return fujureTruffleBindings.find(targetModule, reference)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
