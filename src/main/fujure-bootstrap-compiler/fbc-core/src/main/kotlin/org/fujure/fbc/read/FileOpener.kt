package org.fujure.fbc.read

import org.fujure.fbc.ProblematicFile.BasicFileIssue
import org.funktionale.either.Disjunction

interface FileOpener {
    fun open(filePath: String): Disjunction<BasicFileIssue, OpenedFile>
}
