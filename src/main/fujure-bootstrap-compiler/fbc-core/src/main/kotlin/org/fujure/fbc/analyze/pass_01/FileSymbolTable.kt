package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.TypeReference
import org.funktionale.option.Option

class FileSymbolTable(val inputFile: InputFile, private val simpleValues: LinkedHashMap<String, TypeReference>,
                      val packageName: String) {
    /**
     * Looks up the value of the variable [id] in this compilation unit.
     * If [anchor] is not `null`, then [id] must be in the file
     * *before* [anchor].
     *
     * @return
     *  * [Option.None] if [id] was not found in this compilation unit
     *  * [Option.Some] if [id] was found. The value inside will be `null`
     *   if [anchor] is not `null` and [id] was not found before [anchor] was,
     *   non-`null` otherwise
     */
    fun lookup(id: String, anchor: String?): Option<TypeReference?> {
        var seenAnchor = false
        var typeReference: TypeReference?
        var ret: Option<TypeReference?> = Option.None

        for ((valName, typeRef) in simpleValues) {
            if (valName == anchor) {
                seenAnchor = true
            }
            if (valName == id) {
                typeReference = if (seenAnchor) null else typeRef
                ret = Option.Some(typeReference)
            }
        }

        return ret
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
