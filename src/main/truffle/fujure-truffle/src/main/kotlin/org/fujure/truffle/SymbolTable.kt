package org.fujure.truffle

import com.oracle.truffle.api.frame.VirtualFrame
import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.truffle.nodes.ModuleNode

class SymbolTable {
    internal val fujureTruffleBindings = FujureTruffleBindings()

    private val moduleSymbolTables = mutableMapOf<String, ModuleSymbolTable>()
    private lateinit var currentlyValidatingModule: ModuleSymbolTablePhase1
    private lateinit var currentlyExecutingModule: ModuleSymbolTable

    fun load(moduleNode: ModuleNode, frame: VirtualFrame): LoadModuleResult {
        currentlyValidatingModule = ModuleSymbolTablePhase1()
        val validateModuleResult = currentlyValidatingModule.validate(moduleNode)
        return when (validateModuleResult) {
            is ValidateModulePhase1Result.Invalid -> {
                LoadModuleResult(moduleNode, validateModuleResult.errors)
            }
            is ValidateModulePhase1Result.Valid -> {
                currentlyExecutingModule = validateModuleResult.moduleSymbolTable
                val fqn = moduleNode.fullyQualifiedModuleName()
                moduleSymbolTables[fqn] = currentlyExecutingModule
                currentlyExecutingModule.execute(frame)
                fujureTruffleBindings.register(fqn, currentlyExecutingModule)
                LoadModuleResult(moduleNode, emptyList())
            }
        }
    }

    fun phase1Lookup(reference: ValueReference): Phase1LookupResult {
        if (reference.size != 1) {
            throw UnsupportedOperationException("Translating complex references like '$reference' to Truffle is not supported (yet)")
        } else {
            return currentlyValidatingModule.phase1Lookup(reference.variable())
        }
    }

    fun phase2Lookup(reference: ValueReference): Any? {
        return currentlyExecutingModule.phase2lookup(reference.variable())
    }

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
}
