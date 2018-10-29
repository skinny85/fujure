package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.SemanticError
import org.fujure.truffle.nodes.InvalidReference
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.NonExistentTypeReferenced
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.TypeMismatch
import org.fujure.truffle.nodes.UnresolvedReference

class ModuleSymbolTable() {
    private val bindings = mutableMapOf<String, Any?>()

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        val errors = mutableListOf<SemanticError>()
        moduleNode.definitions().forEach { defNode ->
            if (defNode is SimpleValueDefNode) {
                try {
                    val value = defNode.execute(frame)
                    bindings[defNode.id] = value
                } catch (e: Exception) {
                    val valueDefinitionContext = ErrorContext.ValueDefinition(defNode.id)
                    bindings[defNode.id] = null
                    when (e) {
                        is UnresolvedReference -> {
                            errors.add(SemanticError.UnresolvedReference(
                                    valueDefinitionContext, e.reference))
                        }
                        is NonExistentTypeReferenced -> {
                            errors.add(SemanticError.TypeNotFound(
                                    valueDefinitionContext, e.reference))
                        }
                        is TypeMismatch -> {
                            errors.add(SemanticError.TypeMismatch(
                                    valueDefinitionContext, e.declaredType, e.actualType))
                        }
                        is InvalidReference -> {
                            // If a value references an incorrectly defined value in its definition,
                            // it becomes incorrectly defined, transitively.
                            // However, we don't report another error for it -
                            // the original one from the incorrect definition will be enough.
                        }
                        else -> throw e
                    }
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
