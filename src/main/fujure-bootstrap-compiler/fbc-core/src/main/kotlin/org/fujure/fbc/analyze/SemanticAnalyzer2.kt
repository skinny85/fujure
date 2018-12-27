package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.pass01.SymbolsGatheringAnalysis2
import org.fujure.fbc.analyze.pass02.ImportsGatheringAnalysis
import org.fujure.fbc.analyze.pass02.Pass02ModuleSymbols
import org.fujure.fbc.analyze.pass02.Pass02SymbolTable
import org.fujure.fbc.analyze.pass03.VerificationAnalysis2
import org.fujure.fbc.ast.Module
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

interface SemanticAnalyzer2 {
    fun analyze(parsedFiles: Set<ParsedFile>): Disjunction<
            List<ProblematicFile.SemanticFileIssue>,
            SymbolTable>
}

object SimpleSemanticAnalyzer2 : SemanticAnalyzer2 {
    override fun analyze(parsedFiles: Set<ParsedFile>):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, SymbolTable> {
        val (firstPassSymbolTable, firstPassErrors) = SymbolsGatheringAnalysis2.analyze(parsedFiles)
        val (secondPassSymbolTable, secondPassErrors) = ImportsGatheringAnalysis.analyze(parsedFiles, firstPassSymbolTable)
        val thirdPassErrors = VerificationAnalysis2.analyze(parsedFiles, secondPassSymbolTable)
        val errors = combine(combine(firstPassErrors, secondPassErrors), thirdPassErrors)
        return if (errors.isEmpty())
            Disjunction.right(buildSymbolTable(secondPassSymbolTable))
        else
            Disjunction.left(errors)
    }

    private fun buildSymbolTable(symbolTable: Pass02SymbolTable): SymbolTable {
        return SymbolTable(symbolTable.modules.mapValues { buildModuleSymbols(symbolTable, it.key, it.value) })
    }

    private fun buildModuleSymbols(symbolTable: Pass02SymbolTable, module: Module,
            moduleSymbols: Pass02ModuleSymbols): ModuleSymbols {
        return ModuleSymbols(moduleSymbols.imports, moduleSymbols.values.mapValues {
            it.value.resolvedType(symbolTable, module, it.key, emptyList())!!
        })
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
