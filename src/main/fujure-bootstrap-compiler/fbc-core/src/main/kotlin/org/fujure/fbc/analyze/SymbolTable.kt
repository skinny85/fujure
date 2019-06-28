package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Module

class SymbolTable(private val modules: Map<Module, ModuleSymbols>) {
    fun hasModule(module: Module): Boolean {
        return modules.containsKey(module)
    }

    fun lookup(targetModule: Module, name: String): QualifiedType {
        val moduleSymbols = modules[targetModule]
        if (moduleSymbols != null) {
            val qualifiedType = moduleSymbols.lookup(name)
            if (qualifiedType != null)
                return qualifiedType
        }
        throw NotFound(targetModule, name)
    }

    fun merge(symbolTable: SymbolTable): SymbolTable {
        return SymbolTable(modules + symbolTable.modules)
    }

    class NotFound(val targetModule: Module, val name: String) :
            Exception("Name '$name' not found in target module: $targetModule")
}

class ModuleSymbols(private val simpleValues: Map<String, QualifiedType>) {
    fun lookup(name: String): QualifiedType? {
        return simpleValues[name]
    }
}
