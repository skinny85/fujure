package org.fujure.fbc.ast

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.TypeErrorContext
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.funktionale.either.Either

class FileSymbolTable(val inputFile: InputFile, simpleDeclarations: LinkedHashMap<String, Pair<TypeReference?, Expr>>,
                      val packageName: String) {
    private val simpleValues = simpleDeclarations.mapValues { (_, pair) ->
        ValueTypeHolder(pair.first, pair.second)
    }

    fun lookup(id: String, anchor: String?, symbolTable: SymbolTable): LookupResult {
        if (id == anchor)
            return LookupResult.SelfReference

        var seenAnchor = false
        var ret: LookupResult = LookupResult.RefNotFound

        for ((valName, valHolder) in simpleValues) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                ret = if (seenAnchor)
                    LookupResult.ForwardReference
                else
                    LookupResult.RefFound(valHolder.resolvedType(symbolTable, id))
            }
        }

        return ret
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        object ForwardReference : LookupResult()
        object SelfReference : LookupResult()
        data class RefFound(val qualifiedType: QualifiedType?) : LookupResult()
    }

    private class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr) {
        private val valResolution = ValueResolution.fromDeclaration(declaredType, initializer)
        private var resolved = false
        private var resolvedType: QualifiedType? = null

        fun resolvedType(symbolTable: SymbolTable, valName: String): QualifiedType? {
            if (!resolved)
                resolve(symbolTable, valName)

            return resolvedType
        }

        private fun resolve(symbolTable: SymbolTable, valName: String) {
            resolvedType = valResolution.resolve(symbolTable, valName)
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

        fun resolve(symbolTable: SymbolTable, valName: String): QualifiedType? {
            return when (this) {
                is FromDeclaredType -> symbolTable.findType(this.declaredType)
                is FromInitializer -> {
                    val qualifiedTypeOrError = VerificationAnalysis.exprType(this.initializer, symbolTable, valName)
                    when (qualifiedTypeOrError) {
                        is Either.Left -> null
                        is Either.Right -> qualifiedTypeOrError.r
                    }
                }
            }
        }
    }
}
