package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import com.oracle.truffle.api.nodes.RootNode
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileContents

class FujureRootNode(language: FujureTruffleLanguage,
        private val fileContents: FileContents) : RootNode(language) {
    private val contextReference = language.contextReference

    override fun execute(frame: VirtualFrame): Any {
        // register values defined in the file as Truffle bindings
        for (def in fileContents.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef -> contextReference.get().register(def.id)
            }
        }

        return if (fileContents.packageName.isEmpty()) 42 else 129
    }
}
