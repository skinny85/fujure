package org.fujure.fbc.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.SymbolTable
import java.io.File
import java.io.IOException

interface CodeGenerator {
    fun generate(compileOptions: CompileOptions,
                 astRoot: AstRoot, symbolTable: SymbolTable): CodeGenResult
}

sealed class CodeGenResult(open val userProvidedFilePath: String, open val destinationFile: File) {
    data class Failure(override val userProvidedFilePath: String,
                       override val destinationFile: File,
                       val error: Throwable) :
            CodeGenResult(userProvidedFilePath, destinationFile)

    data class Success(override val userProvidedFilePath: String,
                       override val destinationFile: File) :
            CodeGenResult(userProvidedFilePath, destinationFile)
}

object JavaPoetCodeGenerator : CodeGenerator {
    override fun generate(compileOptions: CompileOptions, astRoot: AstRoot, symbolTable: SymbolTable): CodeGenResult {
        val file = File(astRoot.userProvidedFilePath)
        val className = file.nameWithoutExtension

        val javaFile = FileContentsCodeGen.generate(astRoot.fileContents, className, symbolTable)

        val destFile = File(compileOptions.outputDir, "$className.java")

        return try {
            javaFile.writeTo(destFile.parentFile)
            CodeGenResult.Success(astRoot.userProvidedFilePath, destFile)
        } catch (e: IOException) {
            CodeGenResult.Failure(astRoot.userProvidedFilePath, destFile, e)
        }
    }
}
