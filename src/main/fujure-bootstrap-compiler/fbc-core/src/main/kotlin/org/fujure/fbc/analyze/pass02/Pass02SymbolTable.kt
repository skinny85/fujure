package org.fujure.fbc.analyze.pass02

import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.Module

class Pass02SymbolTable(internal val modules: Map<Module, Pass02ModuleSymbols>,
        internal val symbolTable: SymbolTable) {
    fun hasModule(module: Module): Boolean {
        return modules.containsKey(module) ||
                symbolTable.hasModule(module)
    }
}

class Pass02ModuleSymbols(val inputFile: InputFile, val values: Map<String, Def.ValueDef>)
