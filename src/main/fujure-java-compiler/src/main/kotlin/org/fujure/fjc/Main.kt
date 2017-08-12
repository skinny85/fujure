package org.fujure.fjc

import org.fujure.fjc.internal.ArgumentFile
import org.fujure.fjc.internal.ReadFile

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Usage: fjc file1.fjr file2.fjr ...")
        } else {
            compileFiles(*args)
        }
    }

    private fun compileFiles(vararg files: String) {
        val openFiles = openFiles(*files)
        if (openFiles.size != files.size)
            return

        val parsedFiles = parseFiles(openFiles)
        if (parsedFiles.size != files.size)
            return

        for (parsedFile in parsedFiles) {
            val result = parsedFile.ast.accept({ valueDef, str ->
                "def ${valueDef.ident_} = ${valueDef.integer_} (input: $str)"
            }, "5")
            println("Result for ${parsedFile.userProvidedFile}:\n$result")
        }
    }

    private fun openFiles(vararg files: String): List<ArgumentFile.OpenedFile> {
        val openFiles = mutableListOf<ArgumentFile.OpenedFile>()
        for (file in files) {
            val tryOpenFile = ArgumentFile.openFile(file)
            when (tryOpenFile) {
                is ArgumentFile.InvalidFilename -> {
                    println("Invalid file name: $file. Fujure source files must have the .fjr extension")
                }
                is ArgumentFile.MissingFile -> {
                    println("Error opening $file: file not found")
                }
                is ArgumentFile.FailedFile -> {
                    println("Error opening $file: ${tryOpenFile.error.message}")
                }
                is ArgumentFile.OpenedFile -> {
                    openFiles.add(tryOpenFile)
                }
            }
        }
        return openFiles
    }

    private fun parseFiles(openFiles: List<ArgumentFile.OpenedFile>): List<ReadFile.ParsedFile> {
        val parsedFiles = mutableListOf<ReadFile.ParsedFile>()
        for (openFile in openFiles) {
            val tryParseFile = ReadFile.parse(openFile)
            when (tryParseFile) {
                is ReadFile.UnparsedFile -> {
                    println("Couldn't parse ${tryParseFile.userProvidedFile}:")
                    for ((line, column, msg) in tryParseFile.errors) {
                        println("${tryParseFile.userProvidedFile}:${line},${column}: ${msg}")
                    }
                }
                is ReadFile.ParsedFile -> {
                    parsedFiles.add(tryParseFile)
                }
            }
        }
        return parsedFiles
    }
}
