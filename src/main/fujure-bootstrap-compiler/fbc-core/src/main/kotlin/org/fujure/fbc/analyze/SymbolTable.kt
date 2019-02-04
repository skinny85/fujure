package org.fujure.fbc.analyze

import org.fujure.fbc.ast.Module

class SymbolTable(private val modules: Map<Module, ModuleSymbols>) {
    fun hasModule(module: Module): Boolean {
        return modules.containsKey(module)
    }

    fun lookup(targetModule: Module, name: String): QualifiedType {
        return modules[targetModule]!!.lookup(name)
    }

    fun merge(symbolTable: SymbolTable): SymbolTable {
        return SymbolTable(modules + symbolTable.modules)
    }
}

class ModuleSymbols(private val simpleValues: Map<String, QualifiedType>) {
    fun lookup(name: String): QualifiedType {
        return simpleValues[name]!!
    }
}
