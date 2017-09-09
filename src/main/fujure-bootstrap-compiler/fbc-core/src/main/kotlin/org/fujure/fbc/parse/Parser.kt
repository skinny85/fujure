package org.fujure.fbc.parse

import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureLexer
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureParser
import org.fujure.fbc.read.OpenedFile

interface Parser {
    fun parse(openedFile: OpenedFile): ParsingResult
}

sealed class ParsingResult {
    data class Failure(val cause: ProblematicFile.ParsingFileIssue) :
            ParsingResult()

    data class Success(val parsedFile: ParsedFile) :
            ParsingResult()
}

data class ParsedFile(val userProvidedFilePath: String, val parseTree: FileContents)

object BnfcParser : Parser {
    override fun parse(openedFile: OpenedFile): ParsingResult {
        val lexer = FujureLexer(openedFile.stream)
        val parser = FujureParser(CommonTokenStream(lexer))
        parser.removeErrorListeners() // remove the default console listener
        val errorListener = FbcAntlrErrorListener()
        parser.addErrorListener(errorListener)

        val fileContentsContext = parser.fileContents()

        return if (errorListener.hasErrors) {
            ParsingResult.Failure(
                    ProblematicFile.ParsingFileIssue(
                            openedFile.userProvidedFilePath, errorListener.errors))
        } else {
            ParsingResult.Success(
                    ParsedFile(openedFile.userProvidedFilePath, fileContentsContext.result))
        }
    }
}
