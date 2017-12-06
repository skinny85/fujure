package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram> {
        val asts = mutableListOf<AstRoot>()
        val fileSymbolTables = mutableSetOf<FileSymbolTable>()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()

        for (parsedFile in parsedFiles) {
            val fileSymbolsGatheringResult = FileSymbolsGatheringAnalysis.analyze(parsedFile)
            val semanticErrors: List<SemanticError>? = when (fileSymbolsGatheringResult) {
                is FileSymbolsGatheringResult.Failure -> {
                    fileSymbolsGatheringResult.errors
                }
                is FileSymbolsGatheringResult.Success -> {
                    if (!fileSymbolTables.add(fileSymbolsGatheringResult.fileSymbolTable)) {
                        val previous = fileSymbolTables.find { it == fileSymbolsGatheringResult.fileSymbolTable }!!
                        listOf(SemanticError.DuplicateModule(
                                previous.packageName, previous.inputFile.moduleName, previous.inputFile, parsedFile.inputFile))
                    } else {
                        asts.add(fileSymbolsGatheringResult.astRoot)
                        null
                    }
                }
            }

            if (semanticErrors != null)
                issues.add(ProblematicFile.SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, semanticErrors))
        }

        return if (issues.isEmpty())
            Disjunction.Right(AnalyzedProgram(asts, SymbolTable(fileSymbolTables)))
        else
            Disjunction.Left(issues)
    }
}
