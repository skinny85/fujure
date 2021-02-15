package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.ast.FileContents as AstFileContents

object ParseTree2AstVisitor : FileContents.Visitor<AstFileContents, Unit>{
    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): AstFileContents {
        return visitFileContents(fileContents)
    }

    override fun visit(fileContents: FileInNamedPackage, arg: Unit): AstFileContents {
        return visitFileContents(fileContents)
    }

    private fun visitFileContents(fileContents: FileContents) = AstFileContents(
            fileContents.accept(PackageNameExtractor, Unit),
            fileContents.accept(ImportsExtractor, Unit),
            fileContents.accept(DefsParseTree2AstExtractor, Unit))
}
