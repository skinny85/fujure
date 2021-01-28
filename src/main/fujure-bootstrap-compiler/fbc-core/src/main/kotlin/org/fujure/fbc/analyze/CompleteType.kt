package org.fujure.fbc.analyze

import org.funktionale.either.Disjunction

sealed class TypeResolutionProblem {
    data class TypeMismatch(val declaredType: PartialType, val providedType: PartialType) : TypeResolutionProblem()
    data class ConflictingVariables(val variableIndex: Int, val type1: PartialType, val type2: PartialType) : TypeResolutionProblem()
    data class UnresolvedVariable(val variable: Int) : TypeResolutionProblem()
}

sealed class TypeResolveResult {
    data class Success(val returnType: PartialType) : TypeResolveResult()
    data class Failure(val reasons: List<TypeResolutionProblem>) : TypeResolveResult()
}

data class TypeVariables(private val variables: Int = 0)

data class CompleteType(val variables: TypeVariables, val partialType: PartialType) {
    constructor(partialType: PartialType): this(TypeVariables(), partialType)

    fun resolve(providedTypes: List<CompleteType?>): TypeResolveResult {
        return when (this.partialType) {
            is PartialType.NonFunc -> {
                // if this type is not a function, just return success,
                // and let the semantic analysis handle reporting the NotInvokable error
                TypeResolveResult.Success(this.partialType)
            }
            is PartialType.Func -> {
                val errors = mutableListOf<TypeResolutionProblem>()
                val variableAssignments = mutableMapOf<Int, PartialType>()
                for (i in 0 until this.partialType.argumentTypes.size) {
                    val providedCompleteType = if (i < providedTypes.size) providedTypes[i] else null
                    if (providedCompleteType == null) {
                        continue
                    }
                    val providedType = providedCompleteType.partialType
                    val declaredType = this.partialType.argumentTypes[i]
                    val unificationResults = declaredType.unify(providedType)
                    for (unificationResult in unificationResults) {
                        when (unificationResult) {
                            is UnificationResult.TypesMismatch -> {
                                errors.add(TypeResolutionProblem.TypeMismatch(
                                        unificationResult.declaredType, unificationResult.providedType))
                            }
                            is UnificationResult.VariableAssignment -> {
                                val existingAssignedType = variableAssignments[unificationResult.variableIndex]
                                if (existingAssignedType != null && existingAssignedType != unificationResult.assignedType) {
                                    errors.add(TypeResolutionProblem.ConflictingVariables(
                                            unificationResult.variableIndex, existingAssignedType, unificationResult.assignedType))
                                } else {
                                    variableAssignments[unificationResult.variableIndex] = unificationResult.assignedType
                                }
                            }
                        }
                    }
                }

                // make sure all parameter types have been resolved
                // ToDo for now, we only do it for the return type
                val returnTypeResolution = this.partialType.returnType.resolveVariables(variableAssignments)
                val returnType: PartialType? = when (returnTypeResolution) {
                    is Disjunction.Left  -> {
                        errors.addAll(returnTypeResolution.value.map { TypeResolutionProblem.UnresolvedVariable(it) })
                        null
                    }
                    is Disjunction.Right -> returnTypeResolution.value
                }

                if (errors.isEmpty()) {
                    TypeResolveResult.Success(returnType!!)
                } else {
                    TypeResolveResult.Failure(errors)
                }
            }
        }
    }

    companion object {
        fun fromPartialType(partialType: PartialType?): CompleteType? {
            return if (partialType == null)
                null
            else
                CompleteType(partialType)
        }
    }
}

sealed class UnificationResult {
    data class TypesMismatch(val declaredType: PartialType, val providedType: PartialType) : UnificationResult()
    data class VariableAssignment(val variableIndex: Int, val assignedType: PartialType) : UnificationResult()
}

sealed class PartialType {
    abstract fun inStringForm(): String
    abstract fun unify(providedType: PartialType): List<UnificationResult>
    abstract fun resolveVariables(variableAssignments: Map<Int, PartialType>): Disjunction<Set<Int>, PartialType>

    sealed class NonFunc : PartialType() {
        data class KnownType internal constructor(private val typeFamily: TypeFamily, private val genericTypes: List<PartialType> = emptyList()) : NonFunc() {
            override fun unify(providedType: PartialType): List<UnificationResult> {
                return when (providedType) {
                    is KnownType -> {
                        if (this.typeFamily != providedType.typeFamily) {
                            // if the families don't match, don't bother with the argument types
                            listOf(UnificationResult.TypesMismatch(this, providedType))
                        } else {
                            val results = mutableListOf<UnificationResult>()
                            for (i in 0.until(this.genericTypes.size)) {
                                if (i < providedType.genericTypes.size) {
                                    results.addAll(this.genericTypes[i].unify(providedType.genericTypes[i]))
                                }
                            }
                            results
                        }
                    }
                    else -> listOf(UnificationResult.TypesMismatch(this, providedType))
                }
            }

            override fun resolveVariables(variableAssignments: Map<Int, PartialType>): Disjunction<Set<Int>, PartialType> {
                val genericTypes = mutableListOf<PartialType>()
                val missingVariables = mutableSetOf<Int>()
                for (genericType in this.genericTypes) {
                    val resolutionResult = genericType.resolveVariables(variableAssignments)
                    when (resolutionResult) {
                        is Disjunction.Left  -> missingVariables.addAll(resolutionResult.value)
                        is Disjunction.Right -> genericTypes.add(resolutionResult.value)
                    }
                }
                return if (missingVariables.isEmpty()) {
                    Disjunction.right(KnownType(this.typeFamily, genericTypes))
                } else {
                    Disjunction.left(missingVariables)
                }
            }

            override fun inStringForm(): String {
                val typeFamilyPart = this.typeFamily.inStringForm()

                val genericPart = if (genericTypes.isEmpty())
                    ""
                else
                    "<" + genericTypes.joinToString(", ") { it.inStringForm() } + ">"

                return typeFamilyPart + genericPart
            }

            val packageName = this.typeFamily.packageName
            val typeName = this.typeFamily.typeName

            override fun toString(): String = inStringForm()
        }

        data class TypeVariable(val index: Int) : NonFunc() {
            override fun unify(providedType: PartialType): List<UnificationResult> {
                return listOf(UnificationResult.VariableAssignment(this.index, providedType))
            }

            override fun resolveVariables(variableAssignments: Map<Int, PartialType>): Disjunction<Set<Int>, PartialType> {
                val partialType = variableAssignments[this.index]
                return if (partialType == null) {
                    Disjunction.left(setOf(this.index))
                } else {
                    Disjunction.right(partialType)
                }
            }

            override fun inStringForm(): String {
                return "$index"
            }
        }
    }

    data class Func(val returnType: PartialType, val argumentTypes: List<PartialType>) : PartialType() {
        override fun unify(providedType: PartialType): List<UnificationResult> {
            return when (providedType) {
                is Func -> {
                    val results = mutableListOf<UnificationResult>()
                    for (i in 0.until(this.argumentTypes.size)) {
                        if (providedType.argumentTypes.size < i) {
                            results.addAll(this.argumentTypes[i].unify(providedType.argumentTypes[i]))
                        }
                    }
                    results.addAll(this.returnType.unify(providedType.returnType))
                    results
                }
                else -> listOf(UnificationResult.TypesMismatch(this, providedType))
            }
        }

        override fun resolveVariables(variableAssignments: Map<Int, PartialType>): Disjunction<Set<Int>, PartialType> {
            val missingVariables = mutableSetOf<Int>()

            val returnTypeResolution = this.returnType.resolveVariables(variableAssignments)
            val returnType: PartialType? = when (returnTypeResolution) {
                is Disjunction.Left -> {
                    missingVariables.addAll(returnTypeResolution.value)
                    null
                }
                is Disjunction.Right -> {
                    returnTypeResolution.value
                }
            }

            val argumentTypes = mutableListOf<PartialType>()
            for (argumentType in this.argumentTypes) {
                val resulutionResult = argumentType.resolveVariables(variableAssignments)
                when (resulutionResult) {
                    is Disjunction.Left  -> missingVariables.addAll(resulutionResult.value)
                    is Disjunction.Right -> argumentTypes.add(resulutionResult.value)
                }
            }

            return if (missingVariables.isEmpty()) {
                Disjunction.right(Func(returnType!!, argumentTypes))
            } else {
                Disjunction.left(missingVariables)
            }
        }

        override fun inStringForm(): String {
            val argumentsPart = if (argumentTypes.isEmpty())
                "()"
            else
                argumentTypes.joinToString(" -> ") { renderTypeInFunction(it) }
            return "$argumentsPart -> ${renderTypeInFunction(returnType)}"
        }

        private fun renderTypeInFunction(type: PartialType): String = when (type) {
            is NonFunc -> type.inStringForm()
            is Func -> "(" + type.inStringForm() + ")"
        }
    }
}

object BuiltInTypes {
    val Int = PartialType.NonFunc.KnownType(BuiltInTypeFamilies.Int)
    val Unit = PartialType.NonFunc.KnownType(BuiltInTypeFamilies.Unit)
    val Bool = PartialType.NonFunc.KnownType(BuiltInTypeFamilies.Bool)
    val Char = PartialType.NonFunc.KnownType(BuiltInTypeFamilies.Char)
    val String = PartialType.NonFunc.KnownType(BuiltInTypeFamilies.String)
    fun io(partialType: PartialType): PartialType {
        return PartialType.NonFunc.KnownType(BuiltInTypeFamilies.IO, listOf(partialType))
    }
}
