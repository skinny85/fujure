package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeName
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

    sealed class TypeRequired : SemanticError() {
        data class FunctionReturn(val context: ErrorContext) : TypeRequired()
        data class FunctionArgument(val context: ErrorContext, val argName: String) : TypeRequired()
    }

    data class DefaultArgumentValueUnsupported(val context: ErrorContext, val argName: String) : SemanticError()

    data class TypeNotFound(val context: ErrorContext, val typeName: TypeName) :
            SemanticError()

    data class TypeParametersMismatch(val context: ErrorContext, val reference: TypeReference.SimpleType,
            val typeFamily: TypeFamily) : SemanticError()

    data class TypeMismatch(val context: ErrorContext, val expected: PartialType,
            val actual: PartialType) : SemanticError()

    data class ConflictingTypeVariables(val context: ErrorContext, val variableIndex: Int,
            val type1: PartialType, val type2: PartialType) : SemanticError()

    data class UnresolvedTypeVariable(val context: ErrorContext, val variable: Int) : SemanticError()

    data class NotInvokable(val context: ErrorContext, val found: PartialType.NonFunc) :
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
                    "Unresolved type reference ${this.typeName.inStringForm()}"
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
        is TypeRequired.FunctionReturn ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "A function definition must specify its return type"
        is TypeRequired.FunctionArgument ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "function argument '${this.argName}' does not declare its type"
        is DefaultArgumentValueUnsupported ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Argument '${this.argName}' declares a default value, which is currently not supported"
        is TypeParametersMismatch -> {
            val preamble = "Error ${this.context.humanReadableMsg()}: "
            val errorMessage = if (this.typeFamily.typeParameters > 0) {
                "Wrong number of type arguments for ${this.typeFamily.inStringForm()}: ${this.reference.genericTypes.size}, required: ${this.typeFamily.typeParameters}"
            } else {
                "Type ${this.typeFamily.inStringForm()} does not have type parameters"
            }
            preamble + errorMessage
        }
        is TypeMismatch ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Type mismatch, expected: ${this.expected.inStringForm()} " +
                    "but got: ${this.actual.inStringForm()}"
        is ConflictingTypeVariables ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Conflicting types provided: ${this.type1.inStringForm()} and ${this.type2.inStringForm()}"
        is UnresolvedTypeVariable ->
            "Error ${this.context.humanReadableMsg()}: " +
                    "Type variable ${this.variable} could not be inferred from the function arguments"
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
