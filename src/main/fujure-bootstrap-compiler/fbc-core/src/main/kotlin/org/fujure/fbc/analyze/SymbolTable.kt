package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Module
import org.fujure.fbc.ast.ValueReference

class SymbolTable(private val modules: Map<Module, ModuleSymbols>) {
    fun find(module: Module): Boolean {
        return modules.containsKey(module)
    }

    fun lookup(module: Module, ref: ValueReference): LookupResult {
        return modules[module]!!.lookup(ref, module, this)
    }

    data class LookupResult(val qualifiedType: QualifiedType, val module: Module)
}

class ModuleSymbols(private val imports: Map<String, Module?>,
        private val simpleValues: Map<String, QualifiedType>) {
    fun lookup(ref: ValueReference, module: Module, symbolTable: SymbolTable): SymbolTable.LookupResult {
        return when (ref.ids.size) {
            1 -> {
                SymbolTable.LookupResult(simpleValues[ref.ids[0]]!!, module)
            }
            else -> {
                val importedModule = imports[ref.ids[0]] ?: if (ref.ids[0] == module.moduleName) module else null
                symbolTable.lookup(importedModule!!, ValueReference(ref.ids.subList(1, ref.size)))
            }
        }
    }
}
