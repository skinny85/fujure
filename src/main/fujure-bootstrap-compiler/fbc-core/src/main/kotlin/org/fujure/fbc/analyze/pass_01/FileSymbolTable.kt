package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.InputFile

class FileSymbolTable(val inputFile: InputFile, simpleValues: Set<String>) {
    private class QualifiedTypeHolder {
        var qualifiedType: QualifiedType? = null

        fun flipTo(qualifiedType: QualifiedType) {
            if (this.qualifiedType != null)
                throw IllegalStateException("already given a type: ${this.qualifiedType}")
            this.qualifiedType = qualifiedType
        }
    }

    private val simpleValueTypes: Map<String, QualifiedTypeHolder> =
            simpleValues.associate { Pair(it, QualifiedTypeHolder()) }

    fun fillInTypeFor(id: String, qualifiedType: QualifiedType) {
        val holder = simpleValueTypes[id]!!
        holder.flipTo(qualifiedType)
    }

    fun lookup(id: String): QualifiedType? {
        val holder = simpleValueTypes[id]
        return if (holder == null) {
            null
        } else {
            // if qualifiedType is null, this means a forward-reference,
            // which we don't allow, so a not-found error
            // from the clients of this is fine with us
            holder.qualifiedType
        }
    }
}

class FileSymbolTableBuilder(val inputFile: InputFile) {
    private val simpleValues = mutableSetOf<String>()

    fun noteSimpleValueDeclaration(id: String): Boolean {
        return simpleValues.add(id)
    }

    fun build(): FileSymbolTable {
        return FileSymbolTable(inputFile, simpleValues)
    }
}
