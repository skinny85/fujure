package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.ast.FileContents as AstFileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef

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
