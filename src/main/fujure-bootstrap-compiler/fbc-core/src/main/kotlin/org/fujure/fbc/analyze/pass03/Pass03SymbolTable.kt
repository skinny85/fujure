package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference
import org.funktionale.either.Disjunction

class Pass03SymbolTable(val modules: Map<Module, Pass03ModuleSymbols>,
        private val symbolTable: SymbolTable?) {
    fun findType(typeReference: TypeReference): QualifiedType? {
        if (typeReference.ids.size != 1) {
            return null
        } else {
            val id = typeReference.ids[0]
            return when (id) {
                "Int" -> BuiltInTypes.Int
                "Unit" -> BuiltInTypes.Unit
                "Bool" -> BuiltInTypes.Bool
                "Char" -> BuiltInTypes.Char
                "String" -> BuiltInTypes.String
                else -> null
            }
        }
    }

    fun lookup(ref: ValueReference, module: Module, anchor: String?, chain: List<ValueCoordinates>):
            LookupResult {
        val candidateModule = when (ref.size) {
            1 -> module
            2 -> modules[module]!!.candidateModule(ref.ids[0], module) ?: return LookupResult.RefFound(null, module)
            else -> return LookupResult.RefNotFound
        }
        val candidateModuleSymbols = modules[candidateModule]
        if (candidateModuleSymbols != null) {
            return candidateModuleSymbols.lookupVariable(ref.variable(), candidateModule, anchor, this, chain)
        } else if (symbolTable != null) {
            val qualifiedType: QualifiedType
            try {
                qualifiedType = symbolTable.lookup(candidateModule, ref.variable())
            } catch (e: Exception) {
                return LookupResult.RefNotFound
            }
            return LookupResult.RefFound(qualifiedType, candidateModule)
        } else {
            return LookupResult.RefNotFound
        }
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        data class ForwardReference(val name: String) : LookupResult()
        data class SelfReference(val name: String) : LookupResult()
        data class CyclicReference(val cycle: List<ValueCoordinates>) : LookupResult()
        data class RefFound(val qualifiedType: QualifiedType?, val module: Module) : LookupResult()
    }
}

class Pass03ModuleSymbols(val imports: Map<String, Module?>,
        simpleValues: Map<String, Pair<TypeReference?, Expr>>) {
    internal val values: Map<String, ValueTypeHolder> = simpleValues.mapValues { (_, pair) ->
        ValueTypeHolder(pair.first, pair.second)
    }

    fun candidateModule(moduleName: String, currentModule: Module): Module? {
        return if (imports.containsKey(moduleName)) {
            imports[moduleName]
        } else {
            Module(currentModule.packageName, moduleName)
        }
    }

    fun lookupVariable(id: String, module: Module, anchor: String?, symbolTable: Pass03SymbolTable, chain: List<ValueCoordinates>):
            Pass03SymbolTable.LookupResult {
        if (id == anchor)
            return Pass03SymbolTable.LookupResult.SelfReference(id)

        var seenAnchor = false
        var ret: Pass03SymbolTable.LookupResult = Pass03SymbolTable.LookupResult.RefNotFound

        for ((valName, valHolder) in values) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                ret = if (seenAnchor) {
                    Pass03SymbolTable.LookupResult.ForwardReference(id)
                } else {
                    try {
                        val valueCoordinates = ValueCoordinates(module.packageName, module.moduleName, id)
                        val qualifiedType = valHolder.resolvedType(symbolTable, module, id, chain + valueCoordinates)
                        Pass03SymbolTable.LookupResult.RefFound(qualifiedType, module)
                    } catch (e: CyclicReferenceException) {
                        Pass03SymbolTable.LookupResult.CyclicReference(e.cycle)
                    }
                }
            }
        }

        return ret
    }

    internal class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr) {
        private val valResolution = ValueResolution.fromDeclaration(declaredType, initializer)
        private var resolved = false
        private var resolvedType: QualifiedType? = null

        fun resolvedType(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                chain: List<ValueCoordinates>): QualifiedType? {
            if (!resolved)
                resolve(symbolTable, module, valName, chain)

            return resolvedType
        }

        private fun resolve(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                chain: List<ValueCoordinates>) {
            resolvedType = valResolution.resolve(symbolTable, module, valName, chain)
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

        fun resolve(symbolTable: Pass03SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>): QualifiedType? {
            return when (this) {
                is FromDeclaredType -> symbolTable.findType(this.declaredType)
                is FromInitializer -> {
                    // first, check if we don't have a cycle already
                    if (chain.size > 1) {
                        val chainAsSet = chain.toSet()
                        if (chainAsSet.size < chain.size)
                            throw CyclicReferenceException(chain)
                    }

                    // if not, infer the type from the initializer, failing if that contains a cycle
                    val annotatedExprOrError = VerificationAnalysis.astExpr2AastExpr(this.initializer, symbolTable, module, valName, chain)
                    when (annotatedExprOrError) {
                        is Disjunction.Left -> {
                            val semanticError = annotatedExprOrError.value
                            when (semanticError) {
                                is SemanticError.CyclicDefinition -> throw CyclicReferenceException(semanticError.cycle)
                                else -> null
                            }
                        }
                        is Disjunction.Right -> annotatedExprOrError.value?.type()
                    }
                }
            }
        }
    }

    private class CyclicReferenceException(val cycle: List<ValueCoordinates>) : Exception()
}
