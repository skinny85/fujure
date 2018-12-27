package org.fujure.fbc.analyze.pass02

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.pass03.VerificationAnalysis2
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference
import org.funktionale.either.Disjunction

class Pass02SymbolTable(val modules: Map<Module, Pass02ModuleSymbols>) {
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
        val fileLookupResult = modules[module]!!.lookup(ref, anchor, module, this, chain)
        if (fileLookupResult is LookupResult.RefNotFound &&
                ref.ids.size > 1) {
            // perhaps it's a reference to a non-imported module in the same package?
            val targetModule = Module(module.packageName, ref.ids[0])
            val moduleSymbols = modules[targetModule]
            if (moduleSymbols != null) {
                return moduleSymbols.lookup(ValueReference(ref.ids.subList(1, ref.ids.size)), anchor, targetModule, this, chain)
            }
            // ToDo: there's a very subtle edge case here - what if ref.ids[0] was imported,
            // but didn't contain the variable ref.ids[1]? In that case, we shouldn't search
            // for ref.ids[0] in the same package - that would be wrong!
        }
        return fileLookupResult
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        data class ForwardReference(val name: String) : LookupResult()
        data class SelfReference(val name: String) : LookupResult()
        data class CyclicReference(val cycle: List<ValueCoordinates>) : LookupResult()
        data class RefFound(val qualifiedType: QualifiedType?, val module: Module) : LookupResult()
    }
}

class Pass02ModuleSymbols(val imports: Map<String, Module?>,
        simpleValues: Map<String, Pair<TypeReference?, Expr>>) {
    val values: Map<String, NameEntity> = simpleValues.mapValues { (_, pair) ->
        NameEntity.ValueTypeHolder(pair.first, pair.second)
    }

    fun lookup(ref: ValueReference, anchor: String?, currentModule: Module, symbolTable: Pass02SymbolTable,
               chain: List<ValueCoordinates>): Pass02SymbolTable.LookupResult {
        return when (ref.ids.size) {
            1 -> {
                lookupVariable(ref.ids[0], currentModule, anchor, symbolTable, chain)
            }
            2 -> {
                val importedModule = imports[ref.ids[0]] ?: if (ref.ids[0] == currentModule.moduleName) currentModule else null
                if (importedModule == null) {
                    Pass02SymbolTable.LookupResult.RefNotFound
                } else {
                    symbolTable.lookup(
                            ValueReference(ref.ids[1]),
                            importedModule,
                            if (importedModule == currentModule) anchor else null,
                            chain)
                }
            }
            else -> {
                Pass02SymbolTable.LookupResult.RefNotFound
            }
        }
    }

    private fun lookupVariable(id: String, module: Module, anchor: String?, symbolTable: Pass02SymbolTable, chain: List<ValueCoordinates>):
            Pass02SymbolTable.LookupResult {
        if (id == anchor)
            return Pass02SymbolTable.LookupResult.SelfReference(id)

        var seenAnchor = false
        var ret: Pass02SymbolTable.LookupResult = Pass02SymbolTable.LookupResult.RefNotFound

        for ((valName, valHolder) in values) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                when (valHolder) {
                    is NameEntity.ValueTypeHolder -> {
                        ret = if (seenAnchor) {
                            Pass02SymbolTable.LookupResult.ForwardReference(id)
                        } else {
                            try {
                                val valueCoordinates = ValueCoordinates(module.packageName, module.moduleName, id)
                                val qualifiedType = valHolder.resolvedType(symbolTable, module, id, chain + valueCoordinates)
                                Pass02SymbolTable.LookupResult.RefFound(qualifiedType, module)
                            } catch (e: CyclicReferenceException) {
                                Pass02SymbolTable.LookupResult.CyclicReference(e.cycle)
                            }
                        }
                    }
                }
            }
        }

        return ret
    }
}

sealed class NameEntity {
    abstract fun resolvedType(symbolTable: Pass02SymbolTable, module: Module, valName: String,
            chain: List<ValueCoordinates>): QualifiedType?

    class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr) : NameEntity() {
        private val valResolution = ValueResolution.fromDeclaration(declaredType, initializer)
        private var resolved = false
        private var resolvedType: QualifiedType? = null

        override fun resolvedType(symbolTable: Pass02SymbolTable, module: Module, valName: String,
                         chain: List<ValueCoordinates>): QualifiedType? {
            if (!resolved)
                resolve(symbolTable, module, valName, chain)

            return resolvedType
        }

        private fun resolve(symbolTable: Pass02SymbolTable, module: Module, valName: String,
                            chain: List<ValueCoordinates>) {
            resolvedType = valResolution.resolve(symbolTable, module, valName, chain)
            resolved = true
        }
    }
}

internal sealed class ValueResolution {
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

    fun resolve(symbolTable: Pass02SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>): QualifiedType? {
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
                val qualifiedTypeOrError = VerificationAnalysis2.exprType(this.initializer, symbolTable, module, valName, chain)
                when (qualifiedTypeOrError) {
                    is Disjunction.Left -> {
                        val semanticError = qualifiedTypeOrError.value
                        when (semanticError) {
                            is SemanticError.CyclicDefinition -> throw CyclicReferenceException(semanticError.cycle)
                            else -> null
                        }
                    }
                    is Disjunction.Right -> qualifiedTypeOrError.value
                }
            }
        }
    }
}

internal class CyclicReferenceException(val cycle: List<ValueCoordinates>) : Exception()
