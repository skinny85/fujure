package org.fujure.fbc.parse

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.parse.bnfc.FbcAntlrErrorListener
import org.fujure.fbc.parse.bnfc.ParseTree2AstVisitor
import org.fujure.fbc.parser.bnfc.antlr.fujure.fujureLexer
import org.fujure.fbc.parser.bnfc.antlr.fujure.fujureParser
import org.fujure.fbc.read.OpenedFile
import org.funktionale.either.Disjunction

object BnfcParser : Parser {
    override fun parse(openedFile: OpenedFile):
            Disjunction<ProblematicFile.ParsingFileIssue, ParsedFile> {
        val lexer = fujureLexer(ANTLRInputStream(openedFile.stream))
        val parser = fujureParser(CommonTokenStream(lexer))
        parser.removeErrorListeners() // remove the default console listener
        val errorListener = FbcAntlrErrorListener()
        parser.addErrorListener(errorListener)

        val fileContentsContext = parser.fileContents()

        return if (errorListener.hasErrors)
            Disjunction.left(
                    ProblematicFile.ParsingFileIssue(
                            openedFile.inputFile.userProvidedFilePath, errorListener.errors))
        else
            Disjunction.right(
                    ParsedFile(openedFile.inputFile,
                            fileContentsContext.result.accept(ParseTree2AstVisitor, Unit)))
    }
}
