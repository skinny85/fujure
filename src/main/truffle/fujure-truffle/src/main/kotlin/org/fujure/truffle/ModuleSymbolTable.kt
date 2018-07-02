package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeErrorContext
import org.fujure.fbc.ast.ValueReference
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.UnresolvedReferenceException
import java.util.Optional

class ModuleSymbolTable() {
    private val bindings = mutableMapOf<String, Any?>()

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        val errors = mutableListOf<SemanticError>()
        moduleNode.definitions().forEach { defNode ->
            if (defNode is SimpleValueDefNode) {
                try {
                    val value = defNode.execute(frame)
                    bindings[defNode.id] = value
                } catch (e: UnresolvedReferenceException) {
                    errors.add(SemanticError.UnresolvedReference(
                            TypeErrorContext.VariableDefinition(defNode.id),
                            ValueReference(e.ref)))
                    bindings[defNode.id] = null
                }
            }
        }
        return LoadModuleResult(moduleNode, errors)
    }

    fun lookup(ref: String): Optional<Optional<Any>> {
        return if (bindings.containsKey(ref))
            Optional.of(Optional.ofNullable(bindings[ref]))
        else
            Optional.empty()
    }

    fun valueNames(): Set<String> = bindings.keys
}
