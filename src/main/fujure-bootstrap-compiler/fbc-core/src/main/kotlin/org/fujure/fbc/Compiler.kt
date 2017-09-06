package org.fujure.fbc

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.codegen.CodeGenResult
import org.fujure.fbc.parse.SyntaxError

interface Compiler {
    fun compile(compileOptions: CompileOptions, files: List<String>): CompilationResults
}

data class CompileOptions(val outputDir: String = ".")

sealed class CompilationResults {
    data class CompilationNotAttempted(val problematicFiles: List<ProblematicFile>) : CompilationResults()
    data class CompilationAttempted(val successes: List<CodeGenResult.Success>,
                                    val failures: List<CodeGenResult.Failure>) : CompilationResults() {
        class Builder {
            private val successes = mutableListOf<CodeGenResult.Success>()
            private val failures = mutableListOf<CodeGenResult.Failure>()

            fun add(result: CodeGenResult) {
                when (result) {
                    is CodeGenResult.Success -> successes.add(result)
                    is CodeGenResult.Failure -> failures.add(result)
                }
            }

            fun build(): CompilationAttempted {
                return CompilationAttempted(successes, failures)
            }
        }

        fun encounteredFailures() = failures.isNotEmpty()
    }
}

sealed class ProblematicFile(open val userProvidedFilePath: String) {
    sealed class BasicFileIssue(userProvidedFilePath: String) : ProblematicFile(userProvidedFilePath) {
        data class InvalidFileExtension(override val userProvidedFilePath: String) :
                BasicFileIssue(userProvidedFilePath)

        data class FileNotFound(override val userProvidedFilePath: String) :
                BasicFileIssue(userProvidedFilePath)

        data class CouldNotOpenFile(override val userProvidedFilePath: String, val error: Throwable) :
                BasicFileIssue(userProvidedFilePath)
    }

    data class ParsingFileIssue(override val userProvidedFilePath: String, val errors: List<SyntaxError>) :
            ProblematicFile(userProvidedFilePath)

    data class SemanticFileIssue(override val userProvidedFilePath: String, val errors: List<SemanticError>) :
            ProblematicFile(userProvidedFilePath)
}
