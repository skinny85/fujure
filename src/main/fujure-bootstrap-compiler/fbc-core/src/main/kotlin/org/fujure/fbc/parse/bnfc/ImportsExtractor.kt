package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Import
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports

internal object ImportsExtractor : FileContents.Visitor<List<Import>, Unit> {
    override fun visit(fileContents: FileInNamedPackage, arg: Unit): List<Import> {
        return visitImports(fileContents.imports_)
    }

    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): List<Import> {
        return visitImports(fileContents.imports_)
    }

    private fun visitImports(imports: Imports): List<Import> {
        return imports.accept({ importStmts, _ ->
            importStmts.listimport_.map { import ->
                Import(import.accept({ importStmt, _ ->
                    importStmt.listimportfragm_.map { importFragm ->
                        importFragm.accept({ importFragment, _ ->
                            importFragment.jid_
                        }, Unit)
                    }
                }, Unit))
            }
        }, Unit)
    }
}
