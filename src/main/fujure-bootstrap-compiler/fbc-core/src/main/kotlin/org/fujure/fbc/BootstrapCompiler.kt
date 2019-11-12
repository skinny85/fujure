package org.fujure.fbc

import org.fujure.fbc.CompilationResults.CompilationAttempted
import org.fujure.fbc.aast.AFileContents
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.analyze.SemanticAnalyzer
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.codegen.CodeGenerator
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.Parser
import org.fujure.fbc.read.FileOpener
import org.fujure.fbc.read.OpenedFile
import org.funktionale.either.Disjunction

class BootstrapCompiler(private val fileOpener: FileOpener,
                        private val parser: Parser,
                        private val semanticAnalyzer: SemanticAnalyzer,
                        private val codeGenerator: CodeGenerator) : Compiler {
    override fun compile(compileOptions: CompileOptions, files: List<String>): CompilationResults {
        return appyFailingTransformation(files, { file -> fileOpener.open(file) }, { openedFiles ->
            compileOpenFiles(compileOptions, openedFiles)
        })
    }

    fun compileOpenFiles(compileOptions: CompileOptions, openedFiles: Set<OpenedFile>):
            CompilationResults {
        return appyFailingTransformation(openedFiles, { openedFile -> parser.parse(openedFile) }, { parsedFiles ->
            compileParsedFiles(compileOptions, parsedFiles)
        })
    }

    fun compileParsedFiles(compileOptions: CompileOptions, parsedFiles: Set<ParsedFile>): CompilationResults {
        val semanticAnalysisResult = semanticAnalyzer.analyze(parsedFiles, SymbolTable())
        return when (semanticAnalysisResult) {
            is SemanticAnalysisResult.Failure ->
                    CompilationResults.CompilationNotAttempted(semanticAnalysisResult.issues)
            is SemanticAnalysisResult.Success ->
                    generateCode(compileOptions, semanticAnalysisResult.aasts, semanticAnalysisResult.symbolTable)
        }
    }

    fun generateCode(compileOptions: CompileOptions, annotatedAsts: List<AFileContents>, symbolTable: SymbolTable):
            CompilationAttempted {
        val builder = CompilationAttempted.Builder()
        for (annotatedAst in annotatedAsts) {
            val codeGenResult = codeGenerator.generate(compileOptions, annotatedAst, symbolTable)
            builder.add(codeGenResult)
        }
        return builder.build()
    }

    private fun <I, O> appyFailingTransformation(
            inputs: Iterable<I>,
            transform: (I) -> Disjunction<ProblematicFile, O>,
            successCallback: (Set<O>) -> CompilationResults): CompilationResults {
        val (succeededFiles, failedFiles) = inputs
                .map { input -> transform.invoke(input) }
                .partition { result -> result.isRight() }

        return if (failedFiles.isEmpty())
            successCallback.invoke(succeededFiles
                    .map { (it as Disjunction.Right).value }
                    .toSet())
        else
            CompilationResults.CompilationNotAttempted(failedFiles
                    .map { (it as Disjunction.Left).value })
    }
}
