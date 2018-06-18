package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import com.oracle.truffle.api.nodes.RootNode
import org.fujure.fbc.ast.FileContents

class FujureRootNode(language: FujureTruffleLanguage,
        private val fileContents: FileContents) : RootNode(language) {
    override fun execute(frame: VirtualFrame): Any {
        return if (fileContents.packageName.isEmpty()) 42 else 129
    }
}
