package org.fujure.fbc.parse

import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
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

class ParsedFile(val inputFile: InputFile, val parseTree: FileContents) {
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as ParsedFile

        return inputFile == other.inputFile
    }

    override fun hashCode(): Int {
        return inputFile.hashCode()
    }
}

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
                            openedFile.inputFile.userProvidedFilePath, errorListener.errors))
        } else {
            ParsingResult.Success(
                    ParsedFile(openedFile.inputFile, fileContentsContext.result))
        }
    }
}
