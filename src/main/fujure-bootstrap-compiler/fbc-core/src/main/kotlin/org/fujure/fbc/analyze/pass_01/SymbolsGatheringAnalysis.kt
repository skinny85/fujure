package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: List<ParsedFile>):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram> {
        val asts = mutableListOf<AstRoot>()
        val fileSymbolTables = mutableListOf<FileSymbolTable>()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()

        for (parsedFile in parsedFiles) {
            val fileSymbolsGatheringResult = FileSymbolsGatheringAnalysis.analyze(parsedFile)
            when (fileSymbolsGatheringResult) {
                is FileSymbolsGatheringResult.Failure -> {
                    issues.add(ProblematicFile.SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath,
                            fileSymbolsGatheringResult.errors))
                }
                is FileSymbolsGatheringResult.Success -> {
                    asts.add(fileSymbolsGatheringResult.astRoot)
                    fileSymbolTables.add(fileSymbolsGatheringResult.fileSymbolTable)
                }
            }
        }

        return if (issues.isEmpty())
            Disjunction.Right(AnalyzedProgram(asts, SymbolTable(fileSymbolTables)))
        else
            Disjunction.Left(issues)
    }
}
