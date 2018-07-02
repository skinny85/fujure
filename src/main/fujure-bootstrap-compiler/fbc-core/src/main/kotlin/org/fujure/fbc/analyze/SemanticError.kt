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

    data class UnresolvedImport(val import: Import) : SemanticError()

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

    fun humanReadableMsg(): String = when (this) {
        is SemanticError.DuplicateModule -> {
            val prefix = if (this.packageName.isEmpty()) "" else "${this.packageName}."
            "Error: module ${prefix}${this.moduleName} is defined twice, in " +
                    "${this.firstOccurence.userProvidedFilePath} and " +
                    this.secondOccurance.userProvidedFilePath
        }
        is SemanticError.InvalidName ->
            "Invalid name: '${this.name}'. Fujure names cannot contain '$' characters, " +
                    "can't be a single underscore, nor one of the reserved keywords"
        is SemanticError.DuplicateDefinition ->
            "${this.name} is already defined"
        is SemanticError.UnresolvedImport ->
            "Unresolved import: '${this.import.inStringForm()}'"
        is SemanticError.TypeNotFound ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Unresolved type reference ${this.typeReference.inStringForm()}"
        is SemanticError.UnresolvedReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Unresolved reference '${this.valueReference.inStringForm()}'"
        is SemanticError.IllegalForwardReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Illegal forward reference to '${this.name}'"
        is SemanticError.IllegalSelfReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Illegal self reference"
        is SemanticError.CyclicDefinition ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Cycle detected, ${this.cycle.map { it.inStringForm() }.joinToString(" -> ")}"
        is SemanticError.TypeMismatch ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Type mismatch, expected: ${this.expected.inStringForm()} " +
                    "but got: ${this.actual.inStringForm()}"
    }
}

sealed class TypeErrorContext {
    data class VariableDefinition(val name: String) :
            TypeErrorContext()

    fun humanReadableMsg(): String = when (this) {
        is TypeErrorContext.VariableDefinition ->
            "in declaration of ${this.name}"
    }
}
