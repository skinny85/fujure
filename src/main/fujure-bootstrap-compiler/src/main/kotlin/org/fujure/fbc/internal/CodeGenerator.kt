package org.fujure.fbc.internal

import org.fujure.fbc.internal.codegen.FileContentsCodegenVisitor
import java.io.File
import java.io.IOException

class CodeGenerator(private val parsedFiles: List<ReadFile.ParsedFile>,
                    private val outputDir: String) {
    fun generate(): List<CodeGenResult> {
        val ret = mutableListOf<CodeGenResult>()
        for (parsedFile in parsedFiles) {
            ret.add(generate(parsedFile))
        }
        return ret
    }

    private fun generate(parsedFile: ReadFile.ParsedFile): CodeGenResult {
        val file = File(parsedFile.userProvidedFile)
        val className = file.nameWithoutExtension

        val javaFile = parsedFile.ast.accept(FileContentsCodegenVisitor, className)

        val destFile = File(outputDir, "$className.java")

        return try {
            javaFile.writeTo(destFile.parentFile)
            CodeGenResult.Success(parsedFile.userProvidedFile, destFile)
        } catch (e: IOException) {
            CodeGenResult.Failure(parsedFile.userProvidedFile, destFile, e)
        }
    }
}

sealed class CodeGenResult(val userProvidedFile: String, val destinationFile: File) {
    class Success(userProvidedFile: String, destinationFile: File) :
            CodeGenResult(userProvidedFile, destinationFile)
    class Failure(userProvidedFile: String, destinationFile: File, val error: Throwable) :
            CodeGenResult(userProvidedFile, destinationFile)
}
