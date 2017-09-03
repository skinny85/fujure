package org.fujure.fbc.parse

import org.fujure.fbc.internal.ArgumentFile
import org.fujure.fbc.internal.ReadFile

object BnfcParser : Parser {
    override fun parse(openedFile: ArgumentFile.OpenedFile): ParsingResult {
        val readFile = ReadFile.parse(openedFile)
        return when (readFile) {
            is ReadFile.ParsedFile ->
                ParsingResult.ParsingSucceeded(readFile.ast, readFile.userProvidedFile)
            is ReadFile.UnparsedFile ->
                ParsingResult.ParsingFailed(readFile.errors, readFile.userProvidedFile)
        }
    }
}
