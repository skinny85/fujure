package org.fujure.fbc.analyze

import org.fujure.fbc.ast.TypeReference

sealed class SemanticError {
    data class DuplicateDefinition(val name: String) :
            SemanticError()

    data class VariableNotFound(val context: TypeErrorContext, val name: String) :
            SemanticError()

    data class TypeNotFound(val context: TypeErrorContext, val typeReference: TypeReference) :
            SemanticError()

    data class TypeMismatch(val context: TypeErrorContext, val expected: QualifiedType,
                            val actual: QualifiedType) :
            SemanticError()
}

sealed class TypeErrorContext {
    data class VariableDefinition(val name: String) :
            TypeErrorContext()
}
