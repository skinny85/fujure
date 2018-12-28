package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.pass01.SymbolsGatheringAnalysis
import org.fujure.fbc.analyze.pass02.ImportsGatheringAnalysis
import org.fujure.fbc.analyze.pass03.Pass03ModuleSymbols
import org.fujure.fbc.analyze.pass03.Pass03SymbolTable
import org.fujure.fbc.analyze.pass03.VerificationAnalysis
import org.fujure.fbc.ast.Module
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
        val (secondPassSymbolTable, firstPassErrors) = SymbolsGatheringAnalysis.analyze(parsedFiles)
        val (thirdPassSymbolTable, secondPassErrors) = ImportsGatheringAnalysis.analyze(parsedFiles, secondPassSymbolTable)
        val thirdPassErrors = VerificationAnalysis.analyze(parsedFiles, thirdPassSymbolTable)
        val errors = combine(combine(firstPassErrors, secondPassErrors), thirdPassErrors)
        return if (errors.isEmpty())
            Disjunction.right(buildSymbolTable(thirdPassSymbolTable))
        else
            Disjunction.left(errors)
    }

    private fun buildSymbolTable(symbolTable: Pass03SymbolTable): SymbolTable {
        return SymbolTable(symbolTable.modules.mapValues { buildModuleSymbols(symbolTable, it.key, it.value) })
    }

    private fun buildModuleSymbols(symbolTable: Pass03SymbolTable, module: Module,
            moduleSymbols: Pass03ModuleSymbols): ModuleSymbols {
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
