package org.fujure.fbc.internal.ast

import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage

object PackageNameExtractor : FileContents.Visitor<String, Unit> {
    override fun visit(fileContents: FileInNamedPackage, arg: Unit): String {
        return fileContents.listpkgfragm_
                .map { it.accept({ packageFragment, _ -> packageFragment.ident_ }, Unit) }
                .joinToString(".")
    }

    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): String {
        return "";
    }
}