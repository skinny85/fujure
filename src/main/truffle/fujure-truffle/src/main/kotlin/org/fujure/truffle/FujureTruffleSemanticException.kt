package org.fujure.truffle

import com.oracle.truffle.api.TruffleException
import org.fujure.fbc.ProblematicFile

class FujureTruffleSemanticException(semanticFileIssue: ProblematicFile.SemanticFileIssue) :
        RuntimeException(semanticFileIssue.humanReadableMsg()),
        TruffleException {
    override fun getLocation() = null

    override fun isSyntaxError() = false

    override fun fillInStackTrace() = null
}
