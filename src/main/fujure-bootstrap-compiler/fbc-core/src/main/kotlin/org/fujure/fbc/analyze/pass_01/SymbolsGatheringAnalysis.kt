package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.FileSymbolTable
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile

object SymbolsGatheringAnalysis {
    fun analyze(parsedFiles: Set<ParsedFile>):
            Pair<SymbolTable, List<ProblematicFile.SemanticFileIssue>> {
        val fileSymbolTables = mutableSetOf<FileSymbolTable>()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()

        for (parsedFile in parsedFiles) {
            val fileSymbolsGatheringResult = FileSymbolsGatheringAnalysis.analyze(parsedFile)

            val semanticErrors = mutableListOf<SemanticError>()
            semanticErrors.addAll(fileSymbolsGatheringResult.second)

            if (!fileSymbolTables.add(fileSymbolsGatheringResult.first)) {
                val previous = fileSymbolTables.find { it == fileSymbolsGatheringResult.first }!!
                semanticErrors.add(SemanticError.DuplicateModule(
                    previous.packageName, previous.inputFile.moduleName, previous.inputFile, parsedFile.inputFile))
            }

            if (semanticErrors.isNotEmpty()) {
                issues.add(ProblematicFile.SemanticFileIssue(parsedFile.inputFile.userProvidedFilePath, semanticErrors))
            }
        }

        return Pair(SymbolTable(fileSymbolTables), issues)
    }
}
