package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.codegen.ast.PackageNameExtractor
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

sealed class FileAnalysisResult {
    data class Failure(val errors: List<SemanticError>) :
            FileAnalysisResult()

    data class Success(val ast: AstRoot) :
            FileAnalysisResult()
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: List<ParsedFile>): SemanticAnalysisResult {
        val symbolTableBuilder = SymbolTableBuilder()
        val asts = mutableListOf<AstRoot>()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (parsedFile in parsedFiles) {
            val fileAnalysisResult = analyze(parsedFile, symbolTableBuilder)
            when (fileAnalysisResult) {
                is FileAnalysisResult.Failure -> {
                    issues.add(ProblematicFile.SemanticFileIssue(parsedFile.userProvidedFilePath,
                            fileAnalysisResult.errors))
                }
                is FileAnalysisResult.Success -> {
                    asts.add(fileAnalysisResult.ast)
                }
            }
        }
        return if (issues.isEmpty())
            SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTableBuilder.build()))
        else
            SemanticAnalysisResult.Failure(issues)
    }

    fun analyze(parsedFile: ParsedFile, symbolTableBuilder: SymbolTableBuilder): FileAnalysisResult {
        val packageName = parsedFile.ast.accept(PackageNameExtractor, Unit)
        return FileAnalysisResult.Success(AstRoot(parsedFile.userProvidedFilePath, FileContents(packageName)))
    }
}
