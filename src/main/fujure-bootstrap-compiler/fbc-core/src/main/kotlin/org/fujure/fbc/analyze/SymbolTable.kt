package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Module

class SymbolTable(private val modules: Map<Module, ModuleSymbols>) {
    fun find(module: Module): Boolean {
        return modules.containsKey(module)
    }

    fun lookup(targetModule: Module, name: String): QualifiedType {
        return modules[targetModule]!!.lookup(name)
    }

    fun merge(symbolTable: SymbolTable): SymbolTable {
        return SymbolTable(modules + symbolTable.modules)
    }

    data class LookupResult(val qualifiedType: QualifiedType, val module: Module)
}

class ModuleSymbols(private val simpleValues: Map<String, QualifiedType>) {
    fun lookup(name: String): QualifiedType {
        return simpleValues[name]!!
    }
}
