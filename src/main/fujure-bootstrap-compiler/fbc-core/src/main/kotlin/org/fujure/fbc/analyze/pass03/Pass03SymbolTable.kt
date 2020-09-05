package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

class Pass03SymbolTable(val modules: Map<Module, Pass03ModuleSymbols>,
        private val symbolTable: SymbolTable) {
    fun findType(typeReference: TypeReference): QualifiedType? = when (typeReference) {
        is TypeReference.SimpleType -> findType(typeReference)
        is TypeReference.FunctionType -> {
            val returnType = findType(typeReference.returnType)
            val argumentTypes = typeReference.argumentTypes.map { findType(it) }
            if (returnType != null && argumentTypes.all { it != null }) {
                QualifiedType.FunctionType(returnType, argumentTypes.requireNoNulls())
            } else {
                null
            }
        }
    }

    fun findType(typeReference: TypeReference.SimpleType): QualifiedType? {
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
                "IO" -> BuiltInTypes.IO
                else -> null
            }
        }
    }

    fun lookup(ref: ValueReference, module: Module, anchor: String?, chain: List<ValueCoordinates>?):
            LookupResult {
        val candidateModule = when (ref.size) {
            1 -> module
            2 -> modules[module]!!.candidateModule(ref.ids[0], module) ?:
                return LookupResult.ValueRefFound(null, module)
                // null candidateModule means "there was an import with that name,
                // but the imported module doesn't exist" -
                // so, we say the value exists (to not cascade errors),
                // but with an unknown type
            else -> return LookupResult.RefNotFound
        }
        val candidateModuleSymbols = modules[candidateModule]
        if (candidateModuleSymbols != null) {
            return candidateModuleSymbols.lookupVariable(ref.variable(), candidateModule, anchor, this, chain)
        }

        val qualifiedType: QualifiedType
        try {
            qualifiedType = symbolTable.lookup(candidateModule, ref.variable())
        } catch (e: SymbolTable.NotFound) {
            return LookupResult.RefNotFound
        }
        return LookupResult.ValueRefFound(qualifiedType, candidateModule)
    }

    fun pushNewScope(module: Module, isFuncArgScope: Boolean) {
        modules[module]!!.pushNewScope(isFuncArgScope)
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
        data class ValueRefFound(val qualifiedType: QualifiedType?, val module: Module) : LookupResult()
        data class TempRefFound(val qualifiedType: QualifiedType?, val index: Int, val isFuncArg: Boolean) : LookupResult()
    }
}

class Pass03ModuleSymbols(val imports: Map<String, Module?>, values: Map<String, Def.ValueDef>) {
    internal val values: Map<String, ValueTypeHolder> = values.mapValues { entry ->
        val def = entry.value
        when (def) {
            is Def.ValueDef.SimpleValueDef -> ValueTypeHolder.SimpleValueTypeHolder(def)
            is Def.ValueDef.FunctionValueDef -> ValueTypeHolder.FunctionValueTypeHolder(def)
        }
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

    fun pushNewScope(isFuncArgScope: Boolean) {
        scopes.add(0, Scope(isFuncArgScope))
    }

    fun addToLatestScope(id: String, qualifiedType: QualifiedType?): Boolean {
        return scopes[0].add(id, qualifiedType)
    }

    fun popLatestScope() {
        scopes.removeAt(0)
    }

    fun lookupVariable(id: String, module: Module, anchor: String?, symbolTable: Pass03SymbolTable, chain: List<ValueCoordinates>?):
            Pass03SymbolTable.LookupResult {
        // checks local scopes first
        for (scope in scopes) {
            val result = scope.find(id)
            when (result) {
                is ScopeFindResult.Found -> {
                    return Pass03SymbolTable.LookupResult.TempRefFound(result.qualifiedType,
                            result.index, result.isFuncArg)
                }
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
                        val qualifiedType = valHolder.resolvedType(symbolTable, module, id,
                                if (chain == null) null else chain + valueCoordinates)
                        Pass03SymbolTable.LookupResult.ValueRefFound(qualifiedType, module)
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
                "String" to Module("fujure", "String"),
                "IO" to Module("fujure.io.std", "IO")
        )
    }

    private class Scope(private val isFuncArgScope: Boolean) {
        private val values = linkedMapOf<String, QualifiedType?>()

        fun add(id: String, qualifiedType: QualifiedType?): Boolean {
            return if (values.containsKey(id)) {
                false
            } else {
                values[id] = qualifiedType
                true
            }
        }

        fun find(id: String): ScopeFindResult {
            var index = 0
            for (entry in values) {
                if (entry.key == id)
                    return ScopeFindResult.Found(entry.value, index, this.isFuncArgScope)
                else
                    index += 1
            }
            return ScopeFindResult.Missing
        }
    }

    private sealed class ScopeFindResult {
        data class Found(val qualifiedType: QualifiedType?, val index: Int, val isFuncArg: Boolean) : ScopeFindResult()
        object Missing : ScopeFindResult()
    }

    internal sealed class ValueTypeHolder {
        abstract fun resolvedType(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                chain: List<ValueCoordinates>?): QualifiedType?

        class FunctionValueTypeHolder(private val functionValueDef: Def.ValueDef.FunctionValueDef) : ValueTypeHolder() {
            override fun resolvedType(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                    chain: List<ValueCoordinates>?): QualifiedType? {
                val returnType = functionValueDef.returnType;
                val argumentTypes = functionValueDef.arguments.map { arg -> arg.declaredType }
                return if (returnType != null && argumentTypes.all { it != null }) {
                    symbolTable.findType(TypeReference.FunctionType(returnType, argumentTypes.requireNoNulls()))
                } else {
                    null
                }
            }
        }

        class SimpleValueTypeHolder(simpleValueDef: Def.ValueDef.SimpleValueDef) : ValueTypeHolder() {
            private val valResolution = ValueResolution.fromDeclaration(simpleValueDef.declaredType, simpleValueDef.initializer)
            private var resolved = false
            private var resolvedType: QualifiedType? = null

            override fun resolvedType(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                    chain: List<ValueCoordinates>?): QualifiedType? {
                if (!resolved)
                    resolve(symbolTable, module, valName, chain)

                return resolvedType
            }

            private fun resolve(symbolTable: Pass03SymbolTable, module: Module, valName: String,
                    chain: List<ValueCoordinates>?) {
                resolvedType = valResolution.resolve(symbolTable, module, valName, chain)
                resolved = true
            }
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

        fun resolve(symbolTable: Pass03SymbolTable, module: Module, valName: String, chain: List<ValueCoordinates>?):
                QualifiedType? {
            return when (this) {
                is NoInfoProvided -> null
                is FromDeclaredType -> symbolTable.findType(this.declaredType)
                is FromInitializer -> {
                    // first, check if we don't have a cycle already
                    if (chain != null && chain.size > 1) {
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
