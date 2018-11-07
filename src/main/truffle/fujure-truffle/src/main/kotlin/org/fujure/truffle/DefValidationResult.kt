package org.fujure.truffle

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError

sealed class DefValidationResult {
    fun withError(semanticError: SemanticError): DefValidationResult {
        return when (this) {
            is DefValidationResult.Correct -> DefValidationResult.Incorrect(listOf(semanticError))
            is DefValidationResult.Incorrect -> DefValidationResult.Incorrect(this.errors + semanticError)
        }
    }

    data class Correct(val type: QualifiedType) : DefValidationResult()
    data class Incorrect(val errors: List<SemanticError>) : DefValidationResult()
}
