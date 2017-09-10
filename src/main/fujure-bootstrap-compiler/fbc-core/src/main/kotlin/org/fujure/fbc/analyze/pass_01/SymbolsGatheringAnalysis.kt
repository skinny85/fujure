package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: List<ParsedFile>): SymbolsGatheringResult {
        val asts = mutableListOf<AstRoot>()
        val symbolTableBuilder = SymbolTableBuilder()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()

        for (parsedFile in parsedFiles) {
            val fileSymbolsGatheringResult = FileSymbolsGatheringAnalysis.analyze(parsedFile)
            when (fileSymbolsGatheringResult) {
                is FileSymbolsGatheringResult.Failure -> {
                    issues.add(ProblematicFile.SemanticFileIssue(parsedFile.userProvidedFilePath,
                            fileSymbolsGatheringResult.errors))
                }
                is FileSymbolsGatheringResult.Success -> {
                    asts.add(fileSymbolsGatheringResult.astRoot)
                    symbolTableBuilder.add(fileSymbolsGatheringResult.fileSymbolTable)
                }
            }
        }

        return if (issues.isEmpty())
            SymbolsGatheringResult.Success(asts, symbolTableBuilder.build())
        else
            SymbolsGatheringResult.Failure(issues)
    }
}

sealed class SymbolsGatheringResult {
    data class Failure(val issues: List<ProblematicFile.SemanticFileIssue>) :
            SymbolsGatheringResult()

    data class Success(val asts: List<AstRoot>, val symbolTable: SymbolTable) :
            SymbolsGatheringResult()
}

class SymbolTableBuilder {
    fun build(): SymbolTable {
        return SymbolTable()
    }

    fun add(fileSymbolTable: FileSymbolTable) {
    }
}
