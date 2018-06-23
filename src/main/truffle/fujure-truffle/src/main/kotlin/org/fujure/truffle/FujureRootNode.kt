package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import com.oracle.truffle.api.nodes.RootNode
import org.fujure.fbc.parse.ParsedFile

class FujureRootNode(language: FujureTruffleLanguage,
        private val parsedFile: ParsedFile) : RootNode(language) {
    private val contextReference = language.contextReference

    override fun execute(frame: VirtualFrame): Any {
        // register values defined in the file as Truffle bindings
        contextReference.get().register(parsedFile)

        return if (parsedFile.ast.packageName.isEmpty()) 42 else 129
    }
}
