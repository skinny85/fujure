package org.fujure.truffle;

import com.oracle.truffle.api.Scope
import org.fujure.fbc.parse.ParsedFile

class FujureTruffleContext {
    private val fujureTruffleBindings = FujureTruffleBindings()
    private val topScopes = setOf<Scope>(Scope.newBuilder("global", fujureTruffleBindings).build())

    fun register(parsedFile: ParsedFile) {
        fujureTruffleBindings.register(parsedFile)
    }

    fun findTopScopes(): Iterable<Scope> {
        return topScopes
    }
}
