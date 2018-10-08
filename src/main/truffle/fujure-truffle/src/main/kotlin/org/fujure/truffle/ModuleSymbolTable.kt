package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.ValueReference
import org.fujure.truffle.nodes.InvalidReferenceException
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.UnresolvedReferenceException

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
                            ErrorContext.ValueDefinition(defNode.id),
                            ValueReference(e.ref)))
                    bindings[defNode.id] = null
                } catch (e: InvalidReferenceException) {
                    // If a value references an incorrectly defined value in its definition,
                    // it becomes incorrectly defined, transitively.
                    // However, we don't report another error for it -
                    // the original one from the incorrect definition will be enough.
                    bindings[defNode.id] = null
                }
            }
        }
        return LoadModuleResult(moduleNode, errors)
    }

    fun lookup(ref: String): LookupResult {
        return if (bindings.containsKey(ref)) {
            val v = bindings[ref]
            if (v == null) LookupResult.InvalidRefFound else LookupResult.ValidRefFound(v)
        } else {
            LookupResult.RefNotFound
        }
    }

    fun valueNames(): Set<String> = bindings.keys
}

sealed class LookupResult {
    object RefNotFound : LookupResult()
    object InvalidRefFound : LookupResult()
    data class ValidRefFound(val value: Any) : LookupResult()
}
