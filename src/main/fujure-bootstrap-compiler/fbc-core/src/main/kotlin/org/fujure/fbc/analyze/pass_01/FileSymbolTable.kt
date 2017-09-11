package org.fujure.fbc.analyze.pass_01

class FileSymbolTable

class FileSymbolTableBuilder {
    private val simpleValues = mutableListOf<Pair<String, String?>>()

    fun addSimpleValueDeclaration(id: String, declaredType: String?): Boolean {
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
