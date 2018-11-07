package org.fujure.truffle

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.truffle.nodes.ModuleNode
import org.fujure.truffle.nodes.ValueDefNode

class ModuleSymbolTablePhase1 {
    private val bindings = mutableMapOf<String, QualifiedType?>()

    fun validate(moduleNode: ModuleNode): ValidateModulePhase1Result {
        val errors = mutableListOf<SemanticError>()
        moduleNode.definitions().forEach { defNode ->
            if (defNode is ValueDefNode) {
                val validationResult = defNode.validate()
                bindings[defNode.id] = when (validationResult) {
                    is DefValidationResult.Correct -> {
                        validationResult.type
                    }
                    is DefValidationResult.Incorrect -> {
                        errors.addAll(validationResult.errors)
                        null
                    }
                }
            }
        }
        return if (errors.isEmpty())
            ValidateModulePhase1Result.Valid(ModuleSymbolTable(moduleNode))
        else
            ValidateModulePhase1Result.Invalid(errors)
    }

    fun phase1Lookup(ref: String): Phase1LookupResult {
        return if (bindings.containsKey(ref)) {
            val v = bindings[ref]
            if (v == null) Phase1LookupResult.InvalidRefFound else Phase1LookupResult.ValidRefFound(v)
        } else {
            Phase1LookupResult.RefNotFound
        }
    }
}

sealed class ValidateModulePhase1Result {
    data class Invalid(val errors: List<SemanticError>) : ValidateModulePhase1Result()
    data class Valid(val moduleSymbolTable: ModuleSymbolTable) : ValidateModulePhase1Result()
}

sealed class Phase1LookupResult {
    object RefNotFound : Phase1LookupResult()
    object InvalidRefFound : Phase1LookupResult()
    data class ValidRefFound(val type: QualifiedType) : Phase1LookupResult()
}
