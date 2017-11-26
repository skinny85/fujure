package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference

class FileSymbolTableBuilder(val inputFile: InputFile, val packageName: String) {
    private val simpleValues = linkedMapOf<String, TypeReference>()

    fun noteSimpleValueDeclaration(id: String, declaredType: TypeReference): Boolean {
        return simpleValues.putIfAbsent(id, declaredType) == null
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues, packageName)
    }
}
