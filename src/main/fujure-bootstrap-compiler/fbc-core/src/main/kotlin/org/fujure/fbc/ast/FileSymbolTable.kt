package org.fujure.fbc.ast

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.fujure.fbc.ast.SymbolTable.LookupResult.*
import org.funktionale.either.Either

class FileSymbolTable(val inputFile: InputFile, simpleDeclarations: LinkedHashMap<String, Pair<TypeReference?, Expr>>,
                      val packageName: String) {
    private val names: LinkedHashMap<String, NameEntity> = LinkedHashMap(simpleDeclarations.mapValues { (_, pair) ->
        NameEntity.ValueTypeHolder(pair.first, pair.second)
    })

    private val moduleName = inputFile.moduleName

    fun registerImport(name: String, module: FileSymbolTable): Boolean {
        // ToDo verify that the imported name is not the same as this module name
        return names.put(name, NameEntity.ImportedModule(module)) == null
    }

    fun lookup(ref: ValueReference, anchor: String?, symbolTable: SymbolTable, chain: List<ValueCoordinates>):
            SymbolTable.LookupResult {
        return when (ref.ids.size) {
            1 -> {
                lookup(ref.ids[0], anchor, symbolTable, chain)
            }
            2 -> {
                val importedModule = findImport(ref.ids[0]) ?: if (ref.ids[0] == moduleName) this else null
                importedModule?.lookup(ref.ids[1], if (importedModule == this) anchor else null, symbolTable, chain) ?:
                        RefNotFound
            }
            else -> {
                RefNotFound
            }
        }
    }

    private fun lookup(id: String, anchor: String?, symbolTable: SymbolTable, chain: List<ValueCoordinates>):
            SymbolTable.LookupResult {
        if (id == anchor)
            return SelfReference(id)

        var seenAnchor = false
        var ret: SymbolTable.LookupResult = RefNotFound

        for ((valName, valHolder) in names) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                when (valHolder) {
                    is NameEntity.ValueTypeHolder -> {
                        ret = if (seenAnchor) {
                            ForwardReference(id)
                        } else {
                            try {
                                val valueCoordinates = ValueCoordinates(packageName, inputFile.moduleName, id)
                                val qualifiedType = valHolder.resolvedType(symbolTable, id, chain + valueCoordinates)
                                RefFound(qualifiedType, toModule())
                            } catch (e: CyclicReferenceException) {
                                CyclicReference(e.cycle)
                            }
                        }
                    }
                }
            }
        }

        return ret
    }

    private fun findImport(moduleName: String): FileSymbolTable? {
        val candidate = names[moduleName]
        return if (candidate is NameEntity.ImportedModule)
            candidate.fileSymbolTable
        else
            null
    }

    private fun toModule(): Module {
        return Module(packageName, moduleName)
    }

    sealed class NameEntity {
        class ValueTypeHolder(declaredType: TypeReference?, initializer: Expr) : NameEntity() {
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

        class ImportedModule(val fileSymbolTable: FileSymbolTable) : NameEntity()
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
                            throw CyclicReferenceException(chain)
                    }

                    // if not, infer the type from the initializer, failing if that contains a cycle
                    val qualifiedTypeOrError = VerificationAnalysis.exprType(this.initializer, symbolTable, valName, chain)
                    when (qualifiedTypeOrError) {
                        is Either.Left -> {
                            val semanticError = qualifiedTypeOrError.l
                            when (semanticError) {
                                is SemanticError.CyclicDefinition -> throw CyclicReferenceException(semanticError.cycle)
                                else -> null
                            }
                        }
                        is Either.Right -> qualifiedTypeOrError.r
                    }
                }
            }
        }
    }

    private class CyclicReferenceException(val cycle: List<ValueCoordinates>) : Exception()

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as FileSymbolTable

        return moduleName == other.moduleName &&
                packageName == other.packageName
    }

    override fun hashCode(): Int {
        return 31 * moduleName.hashCode() + packageName.hashCode()
    }
}
