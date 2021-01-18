package org.fujure.fbc.analyze

data class TypeVariables(private val variables: Int = 0)

data class UnificationError(val declaredType: PartialType, val providedType: PartialType)

sealed class TypeResolveResult {
    data class Success(val returnType: PartialType) : TypeResolveResult()
    data class Failure(val reasons: List<UnificationError>) : TypeResolveResult()
}

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
                val errors = mutableListOf<UnificationError>()
                for (i in 0 until this.partialType.argumentTypes.size) {
                    val providedCompleteType = if (i < providedTypes.size) providedTypes[i] else null
                    if (providedCompleteType == null) {
                        continue
                    }
                    val providedType = providedCompleteType.partialType
                    val declaredType = this.partialType.argumentTypes[i]
                    if (!declaredType.unify(providedType)) {
                        errors.add(UnificationError(declaredType, providedType))
                    }
                }

                if (errors.isEmpty()) {
                    TypeResolveResult.Success(this.partialType.returnType)
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

sealed class PartialType {
    abstract fun inStringForm(): String
    fun unify(providedType: PartialType): Boolean {
        // ToDO this needs to be much more sophisticated to handle variables :)
        return this == providedType
    }

    sealed class NonFunc : PartialType() {
        data class KnownType internal constructor(private val typeFamily: TypeFamily, private val genericTypes: List<PartialType> = emptyList()) : NonFunc() {
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

        data class TypeVariable(val name: String) : NonFunc() {
            override fun inStringForm(): String {
                return name
            }
        }
    }

    data class Func(val returnType: PartialType, val argumentTypes: List<PartialType>) : PartialType() {
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
