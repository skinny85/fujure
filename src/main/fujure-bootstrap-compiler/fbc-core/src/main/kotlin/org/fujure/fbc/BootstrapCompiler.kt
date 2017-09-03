package org.fujure.fbc

import org.fujure.fbc.CompilationResults.CompilationAttempted
import org.fujure.fbc.internal.ArgumentFile
import org.fujure.fbc.internal.codegen.CodeGenerator
import org.fujure.fbc.parse.Parser
import org.fujure.fbc.parse.ParsingResult

class BootstrapCompiler(private val fileOpener: FileOpener,
                        private val parser: Parser,
                        private val codeGenerator: CodeGenerator) : Compiler {
    override fun compile(compileOptions: CompileOptions, files: List<String>): CompilationResults {
        val unparsableFiles = mutableListOf<ProblematicFile.BasicFileIssue>()
        val parsableFiles = mutableListOf<ArgumentFile.OpenedFile>()

        for (file in files) {
            val argFile = fileOpener.open(file)
            val problematicFile: ProblematicFile.BasicFileIssue? = when (argFile) {
                is ArgumentFile.InvalidFilename -> {
                    ProblematicFile.BasicFileIssue.InvalidFileExtension(argFile.userProvidedFile)
                }
                is ArgumentFile.MissingFile -> {
                    ProblematicFile.BasicFileIssue.FileNotFound(argFile.userProvidedFile)
                }
                is ArgumentFile.FailedFile -> {
                    ProblematicFile.BasicFileIssue.CouldNotOpenFile(argFile.userProvidedFile, argFile.error)
                }
                is ArgumentFile.OpenedFile -> {
                    parsableFiles.add(argFile)
                    null
                }
            }

            if (problematicFile != null)
                unparsableFiles.add(problematicFile)
        }

        return if (unparsableFiles.isEmpty())
            compileOpenFiles(compileOptions, parsableFiles)
        else
            CompilationResults.CompilationNotAttempted(unparsableFiles)
    }

    fun compileOpenFiles(compileOptions: CompileOptions, openFiles: List<ArgumentFile.OpenedFile>): CompilationResults {
        val failedParsingFiles = mutableListOf<ProblematicFile.ParsingFileIssue>()
        val parsedFiles = mutableListOf<ParsingResult.ParsingSucceeded>()
        for (openFile in openFiles) {
            val parsingResult = parser.parse(openFile)
            val problematicFile: ProblematicFile.ParsingFileIssue? = when (parsingResult) {
                is ParsingResult.ParsingFailed -> {
                    ProblematicFile.ParsingFileIssue(openFile.userProvidedFile, parsingResult.errors)
                }
                is ParsingResult.ParsingSucceeded -> {
                    parsedFiles.add(parsingResult)
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

    private fun generateCode(compileOptions: CompileOptions, parsedFiles: List<ParsingResult.ParsingSucceeded>): CompilationAttempted {
        val builder = CompilationAttempted.Builder()
        for (parsedFile in parsedFiles) {
            val codeGenResult = codeGenerator.generate(compileOptions, parsedFile)
            builder.add(codeGenResult)
        }
        return builder.build()
    }
}
