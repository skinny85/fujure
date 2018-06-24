package org.fujure.truffle

import org.fujure.fbc.ast.Def
import org.fujure.fbc.parse.ParsedFile

class FujureTruffleBindings {
    private val filesBindings = mutableMapOf<String, List<String>>()

    fun register(parsedFile: ParsedFile) {
        val moduleName = parsedFile.inputFile.moduleName
        val packageName = parsedFile.ast.packageName
        val fqn = if (packageName.isEmpty())
            moduleName
        else
            "$packageName.$moduleName"
        filesBindings[fqn] = parsedFile.ast.defs
                .map { def ->
                    when (def) {
                        is Def.ValueDef.SimpleValueDef -> def.id
                    }
                }
    }

    fun fileNames(): Set<String> = filesBindings.keys

    fun bindingsFor(fileName: String): List<String>? = filesBindings[fileName]
}
