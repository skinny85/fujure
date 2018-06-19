package org.fujure.truffle

import com.oracle.truffle.api.TruffleException
import com.oracle.truffle.api.source.Source
import com.oracle.truffle.api.source.SourceSection
import org.fujure.fbc.ProblematicFile

class FujureTruffleParsingException(private val source: Source,
        private val parsingError: ProblematicFile.ParsingFileIssue) :
        RuntimeException("Could not parse '${parsingError.userProvidedFilePath}':\n${
            parsingError.errors.map { "\t(${it.line}, ${it.column}): ${it.msg}" }.joinToString("\n")
        }"),
        TruffleException {
    override fun getSourceLocation(): SourceSection {
        return source.createSection(parsingError.errors[0].line)
    }

    override fun getLocation() = null

    override fun isSyntaxError() = true

    override fun fillInStackTrace() = null
}
