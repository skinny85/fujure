package org.fujure.fbc.internal

import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fbc.bnfc.antlr.Fujure.FujureLexer
import org.fujure.fbc.bnfc.antlr.Fujure.FujureParser

sealed class ReadFile(val userProvidedFile: String) {
    companion object {
        fun parse(openFile: ArgumentFile.OpenedFile): ReadFile {
            val lexer = FujureLexer(openFile.stream)
            val parser = FujureParser(CommonTokenStream(lexer))
            parser.removeErrorListeners() // remove the default console listener
            val errorListener = FbcAntlrErrorListener()
            parser.addErrorListener(errorListener)

            val valDefContext = parser.valDef()

            return if (errorListener.hasErrors) {
                ReadFile.UnparsedFile(openFile.userProvidedFile, errorListener.errors)
            } else {
                ReadFile.ParsedFile(openFile.userProvidedFile, valDefContext.result)
            }
        }
    }

    class UnparsedFile(userProvidedFile: String, val errors: List<SyntaxError>) :
            ReadFile(userProvidedFile)
    class ParsedFile(userProvidedFile: String, val ast: ValDef) :
            ReadFile(userProvidedFile)
}
