package org.fujure.truffle.analyze

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.ErrorContext
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

class NotTruffleSymbolTable {
    fun findType(typeReference: TypeReference): QualifiedType? {
        return if (typeReference.ids.size != 1) {
            null
        } else {
            val id = typeReference.ids[0]
            when (id) {
                "Int" -> BuiltInTypes.Int
                "Unit" -> BuiltInTypes.Unit
                "Bool" -> BuiltInTypes.Bool
                "Char" -> BuiltInTypes.Char
                "String" -> BuiltInTypes.String
                else -> null
            }
        }
    }

    fun merge(moduleSymbols: NotTruffleModuleSymbols) {
        // ToDo
    }
}

sealed class SymbolLookupResult {
    object RefNotFound : SymbolLookupResult()
    object InvalidRefFound : SymbolLookupResult()
    data class ValidRefFound(val type: QualifiedType) : SymbolLookupResult()
}

class NotTruffleModuleSymbols {
    private val values = mutableMapOf<String, QualifiedType?>()

    fun register(id: String, effectiveType: QualifiedType?) {
        values.put(id, effectiveType)
    }

    fun lookup(ref: ValueReference): SymbolLookupResult {
        if (ref.size != 1) {
            throw UnsupportedOperationException("Translating complex references like '$ref' to Truffle is not supported (yet)")
        } else {
            val id = ref.variable()
            return if (values.containsKey(id)) {
                val v = values[id]
                if (v == null) SymbolLookupResult.InvalidRefFound else SymbolLookupResult.ValidRefFound(v)
            } else {
                SymbolLookupResult.RefNotFound
            }
        }
    }
}

object NotTruffleSemanticAnalyzer {
    fun analyze(parsedFile: ParsedFile, symbolTable: NotTruffleSymbolTable):
            Disjunction<
                List<SemanticError>,
                NotTruffleModuleSymbols
            > {
        // ToDo split into 2 passes (to handle imports)

        val mutableErrors = mutableListOf<SemanticError>()

        val moduleSymbols = NotTruffleModuleSymbols()
        for (def in parsedFile.ast.defs) {
            when (def) {
                is Def.ValueDef.SimpleValueDef -> {
                    val errorContext = ErrorContext.ValueDefinition(def.id)
                    val (effectiveType, errors) = determineEffectiveType(def.initializer, moduleSymbols, errorContext)
                    mutableErrors.addAll(errors)
                    moduleSymbols.register(def.id, effectiveType)

                    if (def.declaredType != null){
                        val declaredType = symbolTable.findType(def.declaredType!!)
                        if (declaredType == null) {
                            mutableErrors.add(SemanticError.TypeNotFound(errorContext, def.declaredType!!))
                        } else {
                            if (effectiveType != null && effectiveType != declaredType) {
                                mutableErrors.add(SemanticError.TypeMismatch(errorContext,
                                        declaredType, effectiveType))
                            }
                        }
                    }
                }
            }
        }

        return if (mutableErrors.isEmpty())
            Disjunction.right(moduleSymbols)
        else
            Disjunction.left(mutableErrors)
    }

    private fun determineEffectiveType(expr: Expr, moduleSymbols: NotTruffleModuleSymbols,
            errorContext: ErrorContext.ValueDefinition): Pair<QualifiedType?, List<SemanticError>> {
        val errors = mutableListOf<SemanticError>()

        val effectiveType = when (expr) {
            is Expr.UnitLiteral -> BuiltInTypes.Unit
            is Expr.BoolLiteral -> BuiltInTypes.Bool
            is Expr.CharLiteral -> BuiltInTypes.Char
            is Expr.IntLiteral -> BuiltInTypes.Int
            is Expr.StringLiteral -> BuiltInTypes.String
            is Expr.ValueReferenceExpr -> {
                val lookupResult = moduleSymbols.lookup(expr.ref)
                when (lookupResult) {
                    is SymbolLookupResult.RefNotFound -> {
                        errors.add(SemanticError.UnresolvedReference(errorContext, expr.ref))
                        null
                    }
                    is SymbolLookupResult.InvalidRefFound -> {
                        // This is an interesting scenario - it means the reference was found, but its definition was incorrect.
                        // We handle this case by returning an Incorrect result, but with an empty list of errors.
                        null
                    }
                    is SymbolLookupResult.ValidRefFound -> {
                        lookupResult.type
                    }
                }
            }
        }

        return Pair(effectiveType, errors)
    }
}
