package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import com.oracle.truffle.api.nodes.RootNode
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage

class FujureRootNode(language: FujureTruffleLanguage,
        private val fileContents: FileContents) : RootNode(language) {
    override fun execute(frame: VirtualFrame): Any {
        return fileContents.accept(object : FileContents.Visitor<Int, Unit> {
            override fun visit(p: FileInDefaultPackage, arg: Unit): Int {
                return 42
            }

            override fun visit(p: FileInNamedPackage, arg: Unit): Int {
                return 129
            }
        }, Unit)
    }
}
