package org.fujure.fbc.analyze

sealed class SemanticError {
    data class DuplicateDefintion(val name: String) :
            SemanticError()
}
