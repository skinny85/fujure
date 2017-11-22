package org.fujure.fbc.analyze

import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference

sealed class SemanticError(open val semanticProblem: SemanticProblem) {
    data class ModuleLevelError(override val semanticProblem: SemanticProblem.ModuleLevelProblem) :
            SemanticError(semanticProblem)

    data class ConstructLevelError(val context: ConstructContext,
                                   override val semanticProblem: SemanticProblem.ConstructLevelProblem) :
            SemanticError(semanticProblem)
}

sealed class SemanticProblem {
    sealed class ModuleLevelProblem : SemanticProblem() {
        data class DuplicateDefinition(val name: String) :
                ModuleLevelProblem()
    }

    sealed class ConstructLevelProblem : SemanticProblem() {
        data class UnresolvedReference(val valueReference: ValueReference) :
                ConstructLevelProblem()

        data class TypeNotFound(val typeReference: TypeReference) :
                ConstructLevelProblem()

        data class TypeMismatch(val expected: QualifiedType, val actual: QualifiedType) :
                ConstructLevelProblem()
    }
}

sealed class ConstructContext {
    data class VariableDefinition(val name: String) :
            ConstructContext()
}
