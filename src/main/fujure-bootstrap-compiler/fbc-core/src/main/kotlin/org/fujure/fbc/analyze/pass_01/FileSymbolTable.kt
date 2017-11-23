package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference

class FileSymbolTable(val inputFile: InputFile, val simpleValues: Map<String, TypeReference>,
                      val packageName: String) {
    fun lookup(id: String): TypeReference? {
        return simpleValues[id]
    }
}

class FileSymbolTableBuilder(val inputFile: InputFile, val packageName: String) {
    private val simpleValues = mutableMapOf<String, TypeReference>()

    fun noteSimpleValueDeclaration(id: String, declaredType: TypeReference): Boolean {
        return simpleValues.putIfAbsent(id, declaredType) == null
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues, packageName)
    }
}
