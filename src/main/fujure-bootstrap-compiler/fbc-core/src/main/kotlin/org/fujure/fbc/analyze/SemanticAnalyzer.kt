package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile.SemanticFileIssue
import org.fujure.fbc.analyze.pass01.SymbolsGatheringAnalysis
import org.fujure.fbc.analyze.pass02.ImportsGatheringAnalysis
import org.fujure.fbc.analyze.pass03.Pass03ModuleSymbols
import org.fujure.fbc.analyze.pass03.Pass03SymbolTable
import org.fujure.fbc.analyze.pass03.VerificationAnalysis
import org.fujure.fbc.ast.Module
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction

interface SemanticAnalyzer {
    fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: SymbolTable? = null):
        Disjunction<List<SemanticFileIssue>, SymbolTable>
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: Set<ParsedFile>, symbolTable: SymbolTable?):
            Disjunction<List<SemanticFileIssue>, SymbolTable> {
        val (secondPassSymbolTable, firstPassErrors) = SymbolsGatheringAnalysis.analyze(parsedFiles, symbolTable)
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

    private fun combine(list1: List<SemanticFileIssue>, list2: List<SemanticFileIssue>):
            List<SemanticFileIssue> {
        val result = mutableListOf<SemanticFileIssue>()

        for (fileIssue in list1) {
            val otherFileIssue = list2.findSameFile(fileIssue)
            result.add(
                    if (otherFileIssue == null)
                        fileIssue
                    else
                        SemanticFileIssue(otherFileIssue.userProvidedFilePath,
                                fileIssue.errors + otherFileIssue.errors))
        }

        for (fileIssue in list2) {
            if (result.findSameFile(fileIssue) == null)
                result.add(fileIssue)
        }

        return result
    }

    private fun List<SemanticFileIssue>.findSameFile(fileIssue: SemanticFileIssue):
            SemanticFileIssue? {
        return this.find { it.userProvidedFilePath == fileIssue.userProvidedFilePath }
    }
}
