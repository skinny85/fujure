package org.fujure.fbc.read

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.fujure.fbc.ProblematicFile.BasicFileIssue
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.file.NoSuchFileException

interface FileOpener {
    fun open(filePath: String): FileOpenResult
}

sealed class FileOpenResult {
    data class Failure(val cause: BasicFileIssue) : FileOpenResult()

    data class Success(val openedFile: OpenedFile) : FileOpenResult()
}

data class OpenedFile(val userProvidedFilePath: String, val stream: CharStream)

object SimpleFileOpener : FileOpener {
    override fun open(filePath: String): FileOpenResult {
        if (!filePath.endsWith(".fjr"))
            return FileOpenResult.Failure(
                    BasicFileIssue.InvalidFileExtension(filePath))

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
        return FileOpenResult.Success(OpenedFile(filePath, stream))
    }
}
