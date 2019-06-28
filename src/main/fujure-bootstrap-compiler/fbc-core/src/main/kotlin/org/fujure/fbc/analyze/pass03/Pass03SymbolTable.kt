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
import org.funktionale.option.Option

class Pass03SymbolTable(_modules: Map<Module, Pass03ModuleSymbols>,
        private val symbolTable: SymbolTable?) {
    val modules = _modules + mapOf(
            Module("fujure", "Int") to Pass03ModuleSymbols(
                    mapOf(), mapOf(
                        "minInt" to (TypeReference("Int") to null),
                        "maxInt" to (TypeReference("Int") to null)
                    )
            ),
            Module("fujure", "Unit") to Pass03ModuleSymbols(
                    mapOf(), mapOf()
            ),
            Module("fujure", "Bool") to Pass03ModuleSymbols(
                    mapOf(), mapOf()
            ),
            Module("fujure", "Char") to Pass03ModuleSymbols(
                    mapOf(), mapOf()
            ),
            Module("fujure", "String") to Pass03ModuleSymbols(
                    mapOf(), mapOf()
            )
    )

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
            } catch (e: SymbolTable.NotFound) {
                return LookupResult.RefNotFound
            }
            return LookupResult.RefFound(qualifiedType, candidateModule)
        } else {
            return LookupResult.RefNotFound
        }
    }

    fun pushNewScope(module: Module) {
        modules[module]!!.pushNewScope()
    }

    fun addToLatestScope(module: Module, id: String, qualifiedType: QualifiedType?): Boolean {
        return modules[module]!!.addToLatestScope(id, qualifiedType)
    }

    fun popLatestScope(module: Module) {
        modules[module]!!.popLatestScope()
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
        simpleValues: Map<String, Pair<TypeReference?, Expr?>>) {
    internal val values: Map<String, ValueTypeHolder> = simpleValues.mapValues { (_, pair) ->
        ValueTypeHolder(pair.first, pair.second)
    }

    private val scopes = mutableListOf<Scope>()

    fun candidateModule(moduleName: String, currentModule: Module): Module? {
        // if there is an import of this name, return it
        if (imports.containsKey(moduleName))
            return imports[moduleName]

        // if it's one of the implicitly imported, built-in modules, return that
        if (IMPLICIT_IMPORTS.containsKey(moduleName))
            return IMPLICIT_IMPORTS[moduleName]

        // otherwise, the fallback is a module in the same package with the given name
        return Module(currentModule.packageName, moduleName)
    }

    fun pushNewScope() {
        scopes.add(0, Scope())
    }

    fun addToLatestScope(id: String, qualifiedType: QualifiedType?): Boolean {
        return scopes[0].add(id, qualifiedType)
    }

    fun popLatestScope() {
        scopes.removeAt(0)
    }

    fun lookupVariable(id: String, module: Module, anchor: String?, symbolTable: Pass03SymbolTable, chain: List<ValueCoordinates>):
            Pass03SymbolTable.LookupResult {
        // checks local scopes first
        for (scope in scopes) {
            val result = scope.find(id)
            if (result.nonEmpty()) {
                return Pass03SymbolTable.LookupResult.RefFound(result.get(), module)
            }
        }

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

    private companion object {
        val IMPLICIT_IMPORTS = mapOf(
                "Int" to Module("fujure", "Int"),
                "Unit" to Module("fujure", "Unit"),
                "Bool" to Module("fujure", "Bool"),
                "Char" to Module("fujure", "Char"),
                "String" to Module("fujure", "String"))
    }

    private class Scope {
        private val values = mutableMapOf<String, QualifiedType?>()

        fun add(id: String, qualifiedType: QualifiedType?): Boolean {
            return if (values.containsKey(id)) {
                false
            } else {
                values[id] = qualifiedType
                true
            }
        }

        fun find(id: String): Option<QualifiedType?> {
            return if (values.containsKey(id)) {
                Option.Some(values[id])
            } else {
                Option.None
            }
        }
    }

    internal class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr?) {
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
        object NoInfoProvided : ValueResolution()

        companion object {
            fun fromDeclaration(declaredType: TypeReference?, initializer: Expr?):
                    ValueResolution {
                return if (declaredType == null) {
                    if (initializer == null) NoInfoProvided else FromInitializer(initializer)
                } else {
                    FromDeclaredType(declaredType)
                }
            }
        }

        fun resolve(symbolTable: Pass03SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>):
                QualifiedType? {
            return when (this) {
                is NoInfoProvided -> null
                is FromDeclaredType -> symbolTable.findType(this.declaredType)
                is FromInitializer -> {
                    // first, check if we don't have a cycle already
                    if (chain.size > 1) {
                        val chainAsSet = chain.toSet()
                        if (chainAsSet.size < chain.size)
                            throw CyclicReferenceException(chain)
                    }

                    // if not, infer the type from the initializer, failing if that contains a cycle
                    val exprAnalysisResult = ExprVerifier(symbolTable, module, valName, chain).analyzeExpr(this.initializer)
                    when (exprAnalysisResult) {
                        is ExprVerificationResult.Failure -> {
                            val semanticErrors = exprAnalysisResult.errors
                            val cyclicError = semanticErrors.find { it is SemanticError.CyclicDefinition }
                            if (cyclicError == null)
                                exprAnalysisResult.qualifiedType
                            else
                                throw CyclicReferenceException((cyclicError as SemanticError.CyclicDefinition).cycle)
                        }
                        is ExprVerificationResult.Success -> exprAnalysisResult.qualifiedType
                    }
                }
            }
        }
    }

    private class CyclicReferenceException(val cycle: List<ValueCoordinates>) : Exception()
}
