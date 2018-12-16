package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.pass01.SymbolsGatheringAnalysis
import org.fujure.fbc.analyze.pass02.VerificationAnalysis
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

interface SemanticAnalyzer {
    fun analyze(parsedFiles: Set<ParsedFile>): Disjunction<
            List<ProblematicFile.SemanticFileIssue>,
            SymbolTable>
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: Set<ParsedFile>):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, SymbolTable> {
        val (firstPassSymbolTable, firstPassErrors) = SymbolsGatheringAnalysis.analyze(parsedFiles)
        val (secondPassSymbolTable, secondPassErrors) = VerificationAnalysis.analyze(parsedFiles, firstPassSymbolTable)
        val errors = combine(firstPassErrors, secondPassErrors)
        return if (errors.isEmpty())
            Disjunction.right(secondPassSymbolTable)
        else
            Disjunction.left(errors)
    }

    private fun combine(list1: List<ProblematicFile.SemanticFileIssue>, list2: List<ProblematicFile.SemanticFileIssue>):
            List<ProblematicFile.SemanticFileIssue> {
        val result = mutableListOf<ProblematicFile.SemanticFileIssue>()

        for (fileIssue in list1) {
            val otherFileIssue = list2.findSameFile(fileIssue)
            result.add(
                    if (otherFileIssue == null)
                        fileIssue
                    else
                        ProblematicFile.SemanticFileIssue(otherFileIssue.userProvidedFilePath,
                                fileIssue.errors + otherFileIssue.errors))
        }

        for (fileIssue in list2) {
            if (result.findSameFile(fileIssue) == null)
                result.add(fileIssue)
        }

        return result
    }

    private fun List<ProblematicFile.SemanticFileIssue>.findSameFile(fileIssue: ProblematicFile.SemanticFileIssue):
            ProblematicFile.SemanticFileIssue? {
        return this.find { it.userProvidedFilePath == fileIssue.userProvidedFilePath }
    }
}
