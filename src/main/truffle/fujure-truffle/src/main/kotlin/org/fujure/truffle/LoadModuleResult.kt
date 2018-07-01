package org.fujure.truffle

import org.fujure.fbc.analyze.SemanticError

class LoadModuleResult(val errors: List<SemanticError>) {
    fun isSuccess(): Boolean {
        return errors.isEmpty()
    }

    fun semanticException(): FujureTruffleSemanticException? {
        return if (isSuccess())
            null
        else
            FujureTruffleSemanticException(errors)
    }
}
