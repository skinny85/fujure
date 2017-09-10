package org.fujure.fbc.analyze.pass_02

import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents

object VerificationAnalysis {
    fun analyze(asts: List<AstRoot>, symbolTable: SymbolTable): SemanticAnalysisResult {
        return SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTable))
    }
}
