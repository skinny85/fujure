package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.pass_01.SymbolsGatheringAnalysis
import org.fujure.fbc.analyze.pass_02.VerificationAnalysis
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parse.ParsedFile
import org.funktionale.either.Disjunction
import org.funktionale.either.flatMap

interface SemanticAnalyzer {
    fun analyze(parsedFiles: Set<ParsedFile>): Disjunction<
            List<ProblematicFile.SemanticFileIssue>,
            SymbolTable>
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: Set<ParsedFile>):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, SymbolTable> {
        return SymbolsGatheringAnalysis.analyze(parsedFiles).flatMap { symbolTable ->
            VerificationAnalysis.analyze(parsedFiles, symbolTable)
        }
    }
}
