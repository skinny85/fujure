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

    data class DuplicateDefinition(val name: String, val context: ErrorContext? = null) :
            SemanticError()

    data class UnresolvedImport(val import: Import) : SemanticError()

    data class UnresolvedReference(val context: ErrorContext, val valueReference: ValueReference) :
            SemanticError()

    data class IllegalForwardReference(val context: ErrorContext, val name: String) :
            SemanticError()

    data class IllegalSelfReference(val context: ErrorContext) :
            SemanticError()

    data class CannotBeAbstract(val context: ErrorContext, val subValue: String? = null) :
            SemanticError()

    data class CyclicDefinition(val context: ErrorContext, val cycle: List<ValueCoordinates>) :
            SemanticError()

    data class TypeNotFound(val context: ErrorContext, val typeReference: TypeReference.SimpleType) :
            SemanticError()

    data class TypeMismatch(val context: ErrorContext, val expected: QualifiedType,
                            val actual: QualifiedType) :
            SemanticError()

    data class NotInvokable(val context: ErrorContext, val found: QualifiedType) :
            SemanticError()

    data class ArgumentCountMismatch(val context: ErrorContext, val expected: Int, val actual: Int) :
            SemanticError()

    fun humanReadableMsg(): String = when (this) {
        is DuplicateModule -> {
            val prefix = if (this.packageName.isEmpty()) "" else "${this.packageName}."
            "Error: module ${prefix}${this.moduleName} is defined twice, in " +
                    "${this.firstOccurence.userProvidedFilePath} and " +
                    this.secondOccurance.userProvidedFilePath
        }
        is InvalidName ->
            "Invalid name: '${this.name}'. Fujure names cannot contain '$' characters, " +
                    "can't be a single underscore, nor one of the reserved keywords"
        is DuplicateDefinition ->
            (if (this.context != null) "Error ${this.context.humanReadableMsg()}: " else "") +
                "${this.name} is already defined"
        is UnresolvedImport ->
            "Unresolved import: '${this.import.inStringForm()}'"
        is TypeNotFound ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Unresolved type reference ${this.typeReference.inStringForm()}"
        is UnresolvedReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Unresolved reference '${this.valueReference.inStringForm()}'"
        is IllegalForwardReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Illegal forward reference to '${this.name}'"
        is IllegalSelfReference ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Illegal self reference"
        is CannotBeAbstract ->
            "Error ${this.context.humanReadableMsg()}: " +
                    (if (this.subValue == null)
                        "a top-level value definition in a module cannot be abstract"
                    else
                        "local variable '${this.subValue}' cannot be abstract")
        is CyclicDefinition ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Cycle detected, ${this.cycle.map { it.inStringForm() }.joinToString(" -> ")}"
        is TypeMismatch ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Type mismatch, expected: ${this.expected.inStringForm()} " +
                    "but got: ${this.actual.inStringForm()}"
        is NotInvokable ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Expression of type '${this.found.inStringForm()}' cannot be invoked as a function"
        is ArgumentCountMismatch ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Expected ${this.expected} arguments to function call, but received: ${this.actual}"
    }
}

sealed class ErrorContext {
    data class ValueDefinition(val name: String) :
            ErrorContext()

    fun humanReadableMsg(): String = when (this) {
        is ValueDefinition ->
            "in definition of ${this.name}"
    }
}
