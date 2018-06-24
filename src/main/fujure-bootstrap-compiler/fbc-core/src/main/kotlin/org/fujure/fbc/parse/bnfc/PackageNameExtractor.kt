package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage

internal object PackageNameExtractor : FileContents.Visitor<String, Unit> {
    override fun visit(fileContents: FileInNamedPackage, arg: Unit): String {
        return fileContents.pkgname_.accept({ packageName, _ ->
            packageName.listpkgfragm_
                    .map { it.accept({ packageFragment, _ -> packageFragment.jid_ }, Unit) }
                    .joinToString(".")
        }, Unit)
    }

    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): String {
        return "";
    }
}