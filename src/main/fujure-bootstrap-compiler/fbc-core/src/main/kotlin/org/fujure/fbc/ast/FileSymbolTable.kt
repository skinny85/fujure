package org.fujure.fbc.ast

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.funktionale.either.Either

class FileSymbolTable(val inputFile: InputFile, simpleDeclarations: LinkedHashMap<String, Pair<TypeReference?, Expr>>,
                      val packageName: String) {
    private val simpleValues = simpleDeclarations.mapValues { (_, pair) ->
        ValueTypeHolder(pair.first, pair.second)
    }

    fun lookup(id: String, anchor: String?, symbolTable: SymbolTable, chain: List<ValueCoordinates>): LookupResult {
        if (id == anchor)
            return LookupResult.SelfReference

        var seenAnchor = false
        var ret: LookupResult = LookupResult.RefNotFound

        for ((valName, valHolder) in simpleValues) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                ret = if (seenAnchor) {
                    LookupResult.ForwardReference
                } else {
                    try {
                        val valueCoordinates = ValueCoordinates(packageName, inputFile.moduleName, id)
                        val qualifiedType = valHolder.resolvedType(symbolTable, id, chain + valueCoordinates)
                        LookupResult.RefFound(qualifiedType)
                    } catch (e: CyclicReference) {
                        LookupResult.CyclicReference(e.cycle)
                    }
                }
            }
        }

        return ret
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        object ForwardReference : LookupResult()
        object SelfReference : LookupResult()
        data class CyclicReference(val cycle: List<ValueCoordinates>) : LookupResult()
        data class RefFound(val qualifiedType: QualifiedType?) : LookupResult()
    }

    private class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr) {
        private val valResolution = ValueResolution.fromDeclaration(declaredType, initializer)
        private var resolved = false
        private var resolvedType: QualifiedType? = null

        fun resolvedType(symbolTable: SymbolTable, valName: String, chain: List<ValueCoordinates>): QualifiedType? {
            if (!resolved)
                resolve(symbolTable, valName, chain)

            return resolvedType
        }

        private fun resolve(symbolTable: SymbolTable, valName: String, chain: List<ValueCoordinates>) {
            resolvedType = valResolution.resolve(symbolTable, valName, chain)
            resolved = true
        }
    }

    private sealed class ValueResolution {
        class FromDeclaredType(val declaredType: TypeReference) : ValueResolution()
        class FromInitializer(val initializer: Expr) : ValueResolution()

        companion object {
            fun fromDeclaration(declaredType: TypeReference?, initializer: Expr):
                    ValueResolution {
                return if (declaredType == null)
                    FromInitializer(initializer)
                else
                    FromDeclaredType(declaredType)
            }
        }

        fun resolve(symbolTable: SymbolTable, valName: String, chain: List<ValueCoordinates>): QualifiedType? {
            return when (this) {
                is FromDeclaredType -> symbolTable.findType(this.declaredType)
                is FromInitializer -> {
                    // first, check if we don't have a cycle already
                    if (chain.size > 1) {
                        val chainAsSet = chain.toSet()
                        if (chainAsSet.size < chain.size)
                            throw CyclicReference(chain)
                    }

                    // if not, infer the type from the initializer, failing if that contains a cycle
                    val qualifiedTypeOrError = VerificationAnalysis.exprType(this.initializer, symbolTable, valName, chain)
                    when (qualifiedTypeOrError) {
                        is Either.Left -> {
                            val semanticError = qualifiedTypeOrError.l
                            when (semanticError) {
                                is SemanticError.CyclicDefinition -> throw CyclicReference(semanticError.cycle)
                                else -> null
                            }
                        }
                        is Either.Right -> qualifiedTypeOrError.r
                    }
                }
            }
        }
    }

    private class CyclicReference(val cycle: List<ValueCoordinates>) : Exception()

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as FileSymbolTable

        return inputFile.moduleName == other.inputFile.moduleName &&
                packageName == other.packageName
    }

    override fun hashCode(): Int {
        return 31 * inputFile.moduleName.hashCode() + packageName.hashCode()
    }
}
