package org.fujure.fbc

import org.fujure.fbc.CompilationResults.CompilationAttempted
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
            compileOpenedFiles(compileOptions, openedFiles)
        })
    }

    fun compileOpenedFiles(compileOptions: CompileOptions, openedFiles: Set<OpenedFile>):
            CompilationResults {
        return appyFailingTransformation(openedFiles, { openedFile -> parser.parse(openedFile) }, { parsedFiles ->
            compileParsedFiles(compileOptions, parsedFiles)
        })
    }

    fun compileParsedFiles(compileOptions: CompileOptions, parsedFiles: Set<ParsedFile>): CompilationResults {
        val semanticAnalysisResult = semanticAnalyzer.analyze(parsedFiles)
        return when (semanticAnalysisResult) {
            is Disjunction.Left ->
                    CompilationResults.CompilationNotAttempted(semanticAnalysisResult.value)
            is Disjunction.Right ->
                    generateCode(compileOptions, parsedFiles, semanticAnalysisResult.value)
        }
    }

    fun generateCode(compileOptions: CompileOptions, parsedFiles: Set<ParsedFile>, symbolTable: SymbolTable): CompilationAttempted {
        val builder = CompilationAttempted.Builder()
        for (parsedFile in parsedFiles) {
            val codeGenResult = codeGenerator.generate(compileOptions, parsedFile, symbolTable)
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
