package org.fujure.fbc.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.aast.AFileContents
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.InputFile
import org.funktionale.collections.tail
import java.io.File
import java.io.IOException

interface CodeGenerator {
    fun generate(compileOptions: CompileOptions,
                 annotatedAst: AFileContents, symbolTable: SymbolTable): CodeGenResult
}

sealed class CodeGenResult(open val inputFile: InputFile, open val destinationFile: File) {
    data class Failure(override val inputFile: InputFile,
                       override val destinationFile: File,
                       val error: Throwable) :
            CodeGenResult(inputFile, destinationFile)

    data class Success(override val inputFile: InputFile,
                       override val destinationFile: File) :
            CodeGenResult(inputFile, destinationFile)
}

object JavaPoetCodeGenerator : CodeGenerator {
    override fun generate(compileOptions: CompileOptions, annotatedAst: AFileContents, symbolTable: SymbolTable):
            CodeGenResult {
        val javaFile = FileContentsCodeGen().generate(annotatedAst)

        val destDir = File(compileOptions.outputDir)
        val fileName = "${annotatedAst.module.moduleName}.java"
        val path = if (annotatedAst.module.packageName.isEmpty())
            listOf(fileName)
        else
            annotatedAst.module.packageName.split("\\.") + fileName
        val destFile = joinPaths(destDir, path)

        try {
            javaFile.writeTo(destDir)
        } catch (e: IOException) {
            return CodeGenResult.Failure(annotatedAst.inputFile, destFile, e)
        }
        return CodeGenResult.Success(annotatedAst.inputFile, destFile)
    }

    private fun joinPaths(base: File, path: List<String>): File {
        return if (path.isEmpty()) base else joinPaths(File(base, path.first()), path.tail())
    }
}
