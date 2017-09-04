package org.fujure.fbc

import org.fujure.fbc.CompilationResults.CompilationAttempted
import org.fujure.fbc.codegen.CodeGenerator
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.Parser
import org.fujure.fbc.parse.ParsingResult
import org.fujure.fbc.read.FileOpenResult
import org.fujure.fbc.read.FileOpener
import org.fujure.fbc.read.OpenedFile

class BootstrapCompiler(private val fileOpener: FileOpener,
                        private val parser: Parser,
                        private val codeGenerator: CodeGenerator) : Compiler {
    override fun compile(compileOptions: CompileOptions, files: List<String>): CompilationResults {
        val unparsableFiles = mutableListOf<ProblematicFile.BasicFileIssue>()
        val parsableFiles = mutableListOf<OpenedFile>()

        for (file in files) {
            val fileOpenResult = fileOpener.open(file)
            val problematicFile: ProblematicFile.BasicFileIssue? = when (fileOpenResult) {
                is FileOpenResult.Failure -> fileOpenResult.cause
                is FileOpenResult.Success -> {
                    parsableFiles.add(fileOpenResult.openedFile)
                    null
                }
            }

            if (problematicFile != null)
                unparsableFiles.add(problematicFile)
        }

        return if (unparsableFiles.isEmpty())
            compileOpenedFiles(compileOptions, parsableFiles)
        else
            CompilationResults.CompilationNotAttempted(unparsableFiles)
    }

    fun compileOpenedFiles(compileOptions: CompileOptions, openedFiles: List<OpenedFile>): CompilationResults {
        val failedParsingFiles = mutableListOf<ProblematicFile.ParsingFileIssue>()
        val parsedFiles = mutableListOf<ParsedFile>()

        for (openedFile in openedFiles) {
            val parsingResult = parser.parse(openedFile)
            val problematicFile: ProblematicFile.ParsingFileIssue? = when (parsingResult) {
                is ParsingResult.Failure -> {
                    parsingResult.cause
                }
                is ParsingResult.Success -> {
                    parsedFiles.add(parsingResult.parsedFile)
                    null
                }
            }

            if (problematicFile != null)
                failedParsingFiles.add(problematicFile)
        }

        return if (failedParsingFiles.isEmpty())
            generateCode(compileOptions, parsedFiles)
        else
            CompilationResults.CompilationNotAttempted(failedParsingFiles)
    }

    fun generateCode(compileOptions: CompileOptions, parsedFiles: List<ParsedFile>): CompilationAttempted {
        val builder = CompilationAttempted.Builder()
        for (parsedFile in parsedFiles) {
            val codeGenResult = codeGenerator.generate(compileOptions, parsedFile)
            builder.add(codeGenResult)
        }
        return builder.build()
    }
}
