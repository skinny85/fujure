package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

sealed class SemanticError {
    data class DuplicateModule(val packageName: String, val moduleName: String, val firstOccurence: InputFile,
                               val secondOccurance: InputFile) :
            SemanticError()

    data class InvalidName(val name: String) :
            SemanticError()

    data class DuplicateDefinition(val name: String) :
            SemanticError()

    sealed class ImportError : SemanticError() {
        data class UnresolvedImport(val import: Import) : ImportError()
        data class ClashingImport(val import: Import) : ImportError()
    }

    data class UnresolvedReference(val context: TypeErrorContext, val valueReference: ValueReference) :
            SemanticError()

    data class IllegalForwardReference(val context: TypeErrorContext, val name: String) :
            SemanticError()

    data class IllegalSelfReference(val context: TypeErrorContext) :
            SemanticError()

    data class CyclicDefinition(val context: TypeErrorContext, val cycle: List<ValueCoordinates>) :
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
