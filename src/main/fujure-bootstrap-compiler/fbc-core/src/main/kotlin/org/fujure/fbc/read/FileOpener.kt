package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile.BasicFileIssue

interface FileOpener {
    fun open(filePath: String): FileOpenResult
}

sealed class FileOpenResult {
    data class Failure(val cause: BasicFileIssue) : FileOpenResult()

    data class Success(val openedFile: OpenedFile) : FileOpenResult()
}
