package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.parse.ParsedFile

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): FileSymbolsGatheringResult {
        throw UnsupportedOperationException()
    }
}

sealed class FileSymbolsGatheringResult {
    data class Failure(val errors: List<SemanticError>) :
            FileSymbolsGatheringResult()

    data class Success(val fileSymbolTable: FileSymbolsTable) :
            FileSymbolsGatheringResult()
}

class FileSymbolsTable
