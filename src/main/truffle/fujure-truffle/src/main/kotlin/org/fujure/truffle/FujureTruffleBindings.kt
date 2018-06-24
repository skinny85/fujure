package org.fujure.truffle

import org.fujure.fbc.parse.ParsedFile

class FujureTruffleBindings {
    private val filesBindings = mutableMapOf<String, FujureTruffleFileBindings>()

    fun register(parsedFile: ParsedFile) {
        val moduleName = parsedFile.inputFile.moduleName
        val packageName = parsedFile.ast.packageName
        val fqn = if (packageName.isEmpty())
            moduleName
        else
            "$packageName.$moduleName"
        filesBindings[fqn] = FujureTruffleFileBindings(parsedFile)
    }

    fun fileNames(): Set<String> = filesBindings.keys

    fun bindingsFor(fileName: String): FujureTruffleFileBindings? = filesBindings[fileName]
}
