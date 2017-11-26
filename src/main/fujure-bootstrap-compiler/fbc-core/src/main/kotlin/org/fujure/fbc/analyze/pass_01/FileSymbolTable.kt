package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference

class FileSymbolTable(val inputFile: InputFile, private val simpleValues: LinkedHashMap<String, TypeReference>,
                      val packageName: String) {
    fun lookup(id: String, anchor: String?): LookupResult {
        if (id == anchor)
            return LookupResult.SelfReference

        var seenAnchor = false
        var ret: LookupResult = LookupResult.RefNotFound

        for ((valName, typeRef) in simpleValues) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                ret = if (seenAnchor)
                    LookupResult.ForwardReference
                else
                    LookupResult.RefFound(typeRef)
            }
        }

        return ret
    }

    sealed class LookupResult {
        object RefNotFound : LookupResult()
        object ForwardReference : LookupResult()
        object SelfReference : LookupResult()
        data class RefFound(val typeReference: TypeReference) : LookupResult()
    }
}

class FileSymbolTableBuilder(val inputFile: InputFile, val packageName: String) {
    private val simpleValues = linkedMapOf<String, TypeReference>()

    fun noteSimpleValueDeclaration(id: String, declaredType: TypeReference): Boolean {
        return simpleValues.putIfAbsent(id, declaredType) == null
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues, packageName)
    }
}
