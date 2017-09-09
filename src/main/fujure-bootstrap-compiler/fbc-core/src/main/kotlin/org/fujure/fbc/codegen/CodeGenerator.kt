package org.fujure.fbc.codegen

import org.fujure.fbc.CompileOptions
import org.fujure.fbc.codegen.ast.FileContentsCodegenVisitor
import org.fujure.fbc.parse.ParsedFile
import java.io.File
import java.io.IOException

interface CodeGenerator {
    fun generate(compileOptions: CompileOptions,
                 parsedFile: ParsedFile): CodeGenResult
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
    override fun generate(compileOptions: CompileOptions, parsedFile: ParsedFile): CodeGenResult {
        val file = File(parsedFile.userProvidedFilePath)
        val className = file.nameWithoutExtension

        val javaFile = parsedFile.parseTree.accept(FileContentsCodegenVisitor, className)

        val destFile = File(compileOptions.outputDir, "$className.java")

        return try {
            javaFile.writeTo(destFile.parentFile)
            CodeGenResult.Success(parsedFile.userProvidedFilePath, destFile)
        } catch (e: IOException) {
            CodeGenResult.Failure(parsedFile.userProvidedFilePath, destFile, e)
        }
    }
}
