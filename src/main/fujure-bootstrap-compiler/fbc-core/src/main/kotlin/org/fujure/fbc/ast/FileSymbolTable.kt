package org.fujure.fbc.ast

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
