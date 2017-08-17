package org.fujure.fbc.internal

import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import java.io.File
import java.io.IOException
import javax.lang.model.element.Modifier

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

        val typeSpec = parsedFile.ast.accept({ valueDef, _ ->
            TypeSpec.classBuilder(className)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addField(FieldSpec.builder(Integer.TYPE, valueDef.ident_,
                            Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                            .initializer("\$L", valueDef.integer_)
                            .build())
                    .build()
        }, "")

        val javaFile = JavaFile.builder("", typeSpec).build()
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
