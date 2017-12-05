package org.fujure.fbc.read

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.fujure.fbc.ProblematicFile.BasicFileIssue
import org.fujure.fbc.ast.InputFile
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.file.NoSuchFileException
import javax.lang.model.SourceVersion

interface FileOpener {
    fun open(filePath: String): FileOpenResult
}

sealed class FileOpenResult {
    data class Failure(val cause: BasicFileIssue) : FileOpenResult()

    data class Success(val openedFile: OpenedFile) : FileOpenResult()
}

class OpenedFile(val inputFile: InputFile, val stream: CharStream) {
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as OpenedFile

        return inputFile == other.inputFile
    }

    override fun hashCode(): Int {
        return inputFile.hashCode()
    }

    override fun toString() = "OpenedFile('${inputFile.userProvidedFilePath}')"
}

object SimpleFileOpener : FileOpener {
    override fun open(filePath: String): FileOpenResult {
        if (!filePath.endsWith(".fjr"))
            return FileOpenResult.Failure(
                    BasicFileIssue.InvalidFileExtension(filePath))

        val moduleName = File(filePath).nameWithoutExtension
        if (!validModuleName(moduleName))
            return FileOpenResult.Failure(
                    BasicFileIssue.InvalidFileName(filePath))

        val stream: CharStream
        try {
            stream = CharStreams.fromFileName(filePath)
        } catch (e: FileNotFoundException) {
            return FileOpenResult.Failure(
                    BasicFileIssue.FileNotFound(filePath))
        } catch (e: NoSuchFileException) {
            return FileOpenResult.Failure(
                    BasicFileIssue.FileNotFound(filePath))
        } catch (e: IOException) {
            return FileOpenResult.Failure(
                    BasicFileIssue.CouldNotOpenFile(filePath, e))
        }
        return FileOpenResult.Success(OpenedFile(InputFile(filePath), stream))
    }

    private fun validModuleName(moduleName: String): Boolean {
        return SourceVersion.isIdentifier(moduleName) &&
                SourceVersion.isName(moduleName) &&
                !moduleName.contains("$") &&
                "_" != moduleName &&
                !isFujureKeyword(moduleName)
    }

    private val fujureOnlyKeywords = setOf("def")

    private fun isFujureKeyword(moduleName: String): Boolean {
        return fujureOnlyKeywords.contains(moduleName)
    }
}
