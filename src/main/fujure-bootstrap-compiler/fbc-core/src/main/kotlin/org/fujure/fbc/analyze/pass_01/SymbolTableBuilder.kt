package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.SymbolTable

class SymbolTableBuilder {
    val fileSymbolTables = mutableListOf<FileSymbolTable>()

    fun add(fileSymbolTable: FileSymbolTable) {
        fileSymbolTables.add(fileSymbolTable)
    }

    fun build(): SymbolTable {
        return SymbolTable(fileSymbolTables)
    }
}
