package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: List<ParsedFile>): SymbolsGatheringResult {
        throw UnsupportedOperationException()
    }
}

sealed class SymbolsGatheringResult {
    data class Failure(val issues: List<ProblematicFile.SemanticFileIssue>):
            SymbolsGatheringResult()

    data class Success(val symbolTable: SymbolTable):
            SymbolsGatheringResult()
}
