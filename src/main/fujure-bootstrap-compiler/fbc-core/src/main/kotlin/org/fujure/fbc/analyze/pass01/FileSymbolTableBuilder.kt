package org.fujure.fbc.analyze.pass01

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference

class FileSymbolTableBuilder(val inputFile: InputFile, val packageName: String) {
    private val simpleValues = linkedMapOf<String, Pair<TypeReference?, Expr>>()

    fun noteSimpleValueDeclaration(id: String, declaredType: TypeReference?, initializer: Expr): Boolean {
        return simpleValues.putIfAbsent(id, Pair(declaredType, initializer)) == null
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues, packageName)
    }
}
