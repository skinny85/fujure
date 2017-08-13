package org.fujure.fjc

import org.fujure.fjc.internal.ArgumentFile
import org.fujure.fjc.internal.CodeGenResult
import org.fujure.fjc.internal.CodeGenerator
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

        val codeGenerator = CodeGenerator(parsedFiles)
        val codeGenResults = codeGenerator.generate()
        for (codeGenResult in codeGenResults) {
            if (codeGenResult is CodeGenResult.Failure) {
                println("Error compiling ${codeGenResult.userProvidedFile}: ${codeGenResult.error.message}")
            }
        }
    }

    private fun openFiles(vararg files: String): List<ArgumentFile.OpenedFile> {
        val openFiles = mutableListOf<ArgumentFile.OpenedFile?>()
        for (file in files) {
            val tryOpenFile = ArgumentFile.openFile(file)
            openFiles.add(when (tryOpenFile) {
                is ArgumentFile.InvalidFilename -> {
                    println("Invalid file name: '$file'. Fujure source files must have the .fjr extension")
                    null
                }
                is ArgumentFile.MissingFile -> {
                    println("Error opening $file: file not found")
                    null
                }
                is ArgumentFile.FailedFile -> {
                    println("Error opening $file: ${tryOpenFile.error.message}")
                    null
                }
                is ArgumentFile.OpenedFile -> {
                    tryOpenFile
                }
            })
        }
        return openFiles.filterNotNull()
    }

    private fun parseFiles(openFiles: List<ArgumentFile.OpenedFile>): List<ReadFile.ParsedFile> {
        val parsedFiles = mutableListOf<ReadFile.ParsedFile?>()
        for (openFile in openFiles) {
            val tryParseFile = ReadFile.parse(openFile)
            parsedFiles.add(when (tryParseFile) {
                is ReadFile.UnparsedFile -> {
                    println("Couldn't parse ${tryParseFile.userProvidedFile}:")
                    for ((line, column, msg) in tryParseFile.errors) {
                        println("${tryParseFile.userProvidedFile}:${line},${column}: ${msg}")
                    }
                    null
                }
                is ReadFile.ParsedFile -> {
                    tryParseFile
                }
            })
        }
        return parsedFiles.filterNotNull()
    }
}
