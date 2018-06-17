package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.common.NameValidator
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.io.Reader
import java.nio.file.NoSuchFileException

object SimpleFileOpener : FileOpener {
    override fun open(filePath: String): FileOpenResult {
        if (!filePath.endsWith(".fjr"))
            return FileOpenResult.Failure(
                    ProblematicFile.BasicFileIssue.InvalidFileExtension(filePath))

        val inputFile = InputFile(filePath)
        if (!NameValidator.validModuleName(inputFile.moduleName))
            return FileOpenResult.Failure(
                    ProblematicFile.BasicFileIssue.InvalidFileName(filePath))

        val stream: Reader
        try {
            stream = FileReader(filePath)
        } catch (e: FileNotFoundException) {
            return FileOpenResult.Failure(
                    ProblematicFile.BasicFileIssue.FileNotFound(filePath))
        } catch (e: NoSuchFileException) {
            return FileOpenResult.Failure(
                    ProblematicFile.BasicFileIssue.FileNotFound(filePath))
        } catch (e: IOException) {
            return FileOpenResult.Failure(
                    ProblematicFile.BasicFileIssue.CouldNotOpenFile(filePath, e))
        }
        return FileOpenResult.Success(OpenedFile(inputFile, stream))
    }
}
