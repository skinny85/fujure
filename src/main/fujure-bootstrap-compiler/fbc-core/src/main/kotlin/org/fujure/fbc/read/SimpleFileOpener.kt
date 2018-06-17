package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.common.NameValidator
import org.funktionale.either.Disjunction
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.io.Reader
import java.nio.file.NoSuchFileException

object SimpleFileOpener : FileOpener {
    override fun open(filePath: String): Disjunction<ProblematicFile.BasicFileIssue, OpenedFile> {
        if (!filePath.endsWith(".fjr"))
            return Disjunction.left(
                    ProblematicFile.BasicFileIssue.InvalidFileExtension(filePath))

        val inputFile = InputFile(filePath)
        if (!NameValidator.validModuleName(inputFile.moduleName))
            return Disjunction.left(
                    ProblematicFile.BasicFileIssue.InvalidFileName(filePath))

        val stream: Reader
        try {
            stream = FileReader(filePath)
        } catch (e: FileNotFoundException) {
            return Disjunction.left(
                    ProblematicFile.BasicFileIssue.FileNotFound(filePath))
        } catch (e: NoSuchFileException) {
            return Disjunction.left(
                    ProblematicFile.BasicFileIssue.FileNotFound(filePath))
        } catch (e: IOException) {
            return Disjunction.left(
                    ProblematicFile.BasicFileIssue.CouldNotOpenFile(filePath, e))
        }
        return Disjunction.right(OpenedFile(inputFile, stream))
    }
}
