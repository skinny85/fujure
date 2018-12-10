package org.fujure.fbc.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile
import java.io.File
import java.io.IOException

interface CodeGenerator {
    fun generate(compileOptions: CompileOptions,
                 parsedFile: ParsedFile, symbolTable: SymbolTable): CodeGenResult
}

sealed class CodeGenResult(open val inputPath: InputFile, open val destinationFile: File) {
    data class Failure(override val inputPath: InputFile,
                       override val destinationFile: File,
                       val error: Throwable) :
            CodeGenResult(inputPath, destinationFile)

    data class Success(override val inputPath: InputFile,
                       override val destinationFile: File) :
            CodeGenResult(inputPath, destinationFile)
}

object JavaPoetCodeGenerator : CodeGenerator {
    override fun generate(compileOptions: CompileOptions, parsedFile: ParsedFile, symbolTable: SymbolTable): CodeGenResult {
        val javaFile = FileContentsCodeGen.generate(parsedFile, symbolTable)

        val inputFile = parsedFile.inputFile
        val destFile = File(compileOptions.outputDir, "${inputFile.moduleName}.java")
        return try {
            javaFile.writeTo(destFile.parentFile)
            CodeGenResult.Success(inputFile, destFile)
        } catch (e: IOException) {
            CodeGenResult.Failure(inputFile, destFile, e)
        }
    }
}
