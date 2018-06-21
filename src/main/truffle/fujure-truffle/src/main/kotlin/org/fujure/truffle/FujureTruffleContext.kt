package org.fujure.truffle;

import com.oracle.truffle.api.Scope

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf<Scope>(Scope.newBuilder("global", fujureTruffleBindings).build())

    fun register(id: String) {
        fujureTruffleBindings.register(id)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
