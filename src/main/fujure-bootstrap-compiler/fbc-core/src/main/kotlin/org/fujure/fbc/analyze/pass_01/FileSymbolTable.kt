package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.TypeReference

class FileSymbolTable

class FileSymbolTableBuilder {
    private val simpleValues = mutableListOf<Pair<String, TypeReference?>>()

    fun addSimpleValueDeclaration(id: String, declaredType: TypeReference?): Boolean {
        return if (simpleValues.any { it.first == id }) {
            false
        } else {
            simpleValues.add(Pair(id, declaredType))
            true
        }
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable()
    }
}
