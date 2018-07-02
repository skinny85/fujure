package org.fujure.truffle

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.SemanticError
import org.fujure.truffle.nodes.ModuleNode

class LoadModuleResult(val moduleNode: ModuleNode, val errors: MutableList<SemanticError>) {
    fun isSuccess(): Boolean {
        return errors.isEmpty()
    }

    fun semanticException(): FujureTruffleSemanticException? {
        return if (isSuccess())
            null
        else
            FujureTruffleSemanticException(ProblematicFile.SemanticFileIssue(
                    moduleNode.userProvidedFilePath(), errors))
    }
}
