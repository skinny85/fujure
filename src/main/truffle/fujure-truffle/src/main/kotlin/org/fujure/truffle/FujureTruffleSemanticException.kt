package org.fujure.truffle

import com.oracle.truffle.api.TruffleException
import org.fujure.fbc.analyze.SemanticError

class FujureTruffleSemanticException(semanticErrors: List<SemanticError>) :
        RuntimeException("There were some semantic errors"),
        TruffleException {
    override fun getLocation() = null

    override fun isSyntaxError() = false

    override fun fillInStackTrace() = null
}
