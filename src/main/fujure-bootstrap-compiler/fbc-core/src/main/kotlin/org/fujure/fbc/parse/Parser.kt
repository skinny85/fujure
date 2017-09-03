package org.fujure.fbc.parse

import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.internal.ArgumentFile
import org.fujure.fbc.internal.SyntaxError

interface Parser {
    fun parse(openedFile: ArgumentFile.OpenedFile): ParsingResult
}

sealed class ParsingResult(open val userProvidedFilePath: String) {
    data class ParsingFailed(val errors: List<SyntaxError>,
                             override val userProvidedFilePath: String ) :
            ParsingResult(userProvidedFilePath)
    data class ParsingSucceeded(val ast: FileContents,
                                override val userProvidedFilePath: String) :
            ParsingResult(userProvidedFilePath)
}
