package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.pass_01.SymbolsGatheringAnalysis
import org.fujure.fbc.analyze.pass_01.SymbolsGatheringResult
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile

interface SemanticAnalyzer {
    fun analyze(parsedFiles: List<ParsedFile>): SemanticAnalysisResult
}

sealed class SemanticAnalysisResult {
    data class Failure(val issues: List<ProblematicFile.SemanticFileIssue>) :
            SemanticAnalysisResult()

    data class Success(val analyzedProgram: AnalyzedProgram):
            SemanticAnalysisResult()
}

class SemanticError

data class AnalyzedProgram(val asts: List<AstRoot>,
                           val symbolTable: SymbolTable)

class SymbolTableBuilder {
    fun build(): SymbolTable {
        return SymbolTable()
    }
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: List<ParsedFile>): SemanticAnalysisResult {
        val symbolsGatheringResult = SymbolsGatheringAnalysis.analyze(parsedFiles)
        return when (symbolsGatheringResult) {
            is SymbolsGatheringResult.Failure -> {
                SemanticAnalysisResult.Failure(symbolsGatheringResult.issues)
            }
            is SymbolsGatheringResult.Success -> {
                VerificationAnalysis.analyze(parsedFiles, symbolsGatheringResult.symbolTable)
            }
        }
    }
}
