package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueReference

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

    fun findInCurrentModule(reference: ValueReference): Any {
        return fujureTruffleBindings.findInCurrentModule(reference)
    }

    fun registerInCurrentModule(name: String, value: Any) {
        fujureTruffleBindings.registerInCurrentModule(name, value)
    }

    fun leaveCurrentModule() {
        fujureTruffleBindings.leaveCurrentModule()
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
