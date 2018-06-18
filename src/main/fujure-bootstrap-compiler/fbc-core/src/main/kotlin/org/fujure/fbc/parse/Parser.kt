package org.fujure.fbc.parse

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.read.OpenedFile
import org.funktionale.either.Disjunction

interface Parser {
    fun parse(openedFile: OpenedFile):
            Disjunction<ProblematicFile.ParsingFileIssue, ParsedFile>
}
