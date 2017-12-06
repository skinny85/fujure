package org.fujure.fbc.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.MissingRequiredPositionalArgumentException
import com.xenomachina.argparser.OptionMissingRequiredArgumentException
import com.xenomachina.argparser.ShowHelpException
import com.xenomachina.argparser.UnrecognizedOptionException
import org.fujure.fbc.CompilationResults
import org.fujure.fbc.CompileOptions
import org.fujure.fbc.Compiler
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.analyze.TypeErrorContext

/**
 * This class encapsulates invoking the (bootstrap) compiler
 * through the command-line interface.
 */
class CompilerCli(private val log: Logger, private val compiler: Compiler) {
    fun invokeCompiler(cliArgs: Array<String>): Int {
        if (cliArgs.isEmpty()) {
            printHelp()
            return 2
        }

        val compilerCliArgs = CompilerCliArgs(ArgParser(cliArgs))
        val files: List<String>
        try {
            files = compilerCliArgs.sourceFiles
        } catch (_: ShowHelpException) {
            printHelp()
            return 0
        } catch (_: MissingRequiredPositionalArgumentException) {
            // no source files provided
            log.error("fbc: No source files provided")
            printUsageAndHelpTip()
            return 2
        } catch (e: OptionMissingRequiredArgumentException) {
            // no value provided to eg. -o
            log.error("fbc: ${e.message}")
            printUsageAndHelpTip()
            return 2
        } catch (e: UnrecognizedOptionException) {
            log.error("fbc: ${e.message}")
            printUsageAndHelpTip()
            return 2
        }
        val compileOptions = CompileOptions(compilerCliArgs.output)

        val compilationResults = compiler.compile(compileOptions, files)

        val exitCode = when (compilationResults) {
            is CompilationResults.CompilationNotAttempted -> {
                var ret = 1
                for (problematicFile in compilationResults.problematicFiles) {
                    ret = when (problematicFile) {
                        is ProblematicFile.BasicFileIssue.InvalidFileExtension -> {
                            log.error("Invalid file name: '${problematicFile.userProvidedFilePath}'. Fujure source files must have the .fjr extension")
                            1
                        }
                        is ProblematicFile.BasicFileIssue.InvalidFileName -> {
                            log.error("Invalid file name: '${problematicFile.userProvidedFilePath}'. " +
                                    "Fujure files names must be non-empty sequences of underscores, letter and digits, " +
                                    "starting with a letter. A single underscore name is also forbidden, as are some keywords")
                            1
                        }
                        is ProblematicFile.BasicFileIssue.FileNotFound -> {
                            log.error("Error opening ${problematicFile.userProvidedFilePath}: file not found")
                            1
                        }
                        is ProblematicFile.BasicFileIssue.CouldNotOpenFile -> {
                            log.error("Error opening ${problematicFile.userProvidedFilePath}: ${problematicFile.error.message}")
                            1
                        }
                        is ProblematicFile.ParsingFileIssue -> {
                            for ((line, column, msg) in problematicFile.errors)
                                log.error("${problematicFile.userProvidedFilePath}:($line:$column): $msg")
                            1
                        }
                        is ProblematicFile.SemanticFileIssue -> {
                            for (semanticError in problematicFile.errors) {
                                log.error("${problematicFile.userProvidedFilePath}: ${semanticErrorMessage(semanticError)}")
                            }
                            1
                        }
                    }
                }
                ret
            }
            is CompilationResults.CompilationAttempted -> {
                if (compilationResults.encounteredFailures()) {
                    for (failure in compilationResults.failures) {
                        log.error("Error generating code for ${failure.inputPath.userProvidedFilePath}: ${failure.error.message}")
                    }
                    1
                } else {
                    0
                }
            }
        }

        return exitCode
    }

    private fun semanticErrorMessage(semanticFileIssue: SemanticError): String = when (semanticFileIssue) {
        is SemanticError.DuplicateModule -> {
            val prefix = if (semanticFileIssue.packageName.isEmpty()) "" else "${semanticFileIssue.packageName}."
            "Error: module ${prefix}${semanticFileIssue.moduleName} is defined twice, in " +
                    "${semanticFileIssue.firstOccurence.userProvidedFilePath} and " +
                    semanticFileIssue.secondOccurance.userProvidedFilePath
        }
        is SemanticError.DuplicateDefinition ->
            "${semanticFileIssue.name} is already defined"
        is SemanticError.TypeNotFound ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Unresolved type reference ${semanticFileIssue.typeReference.inStringForm()}"
        is SemanticError.UnresolvedReference ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Unresolved reference '${semanticFileIssue.valueReference.inStringForm()}'"
        is SemanticError.IllegalForwardReference ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Illegal forward reference to '${semanticFileIssue.name}'"
        is SemanticError.IllegalSelfReference ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Illegal self reference"
        is SemanticError.CyclicDefinition ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Cycle detected, ${semanticFileIssue.cycle.map { it.inStringForm() }.joinToString(" -> ")}"
        is SemanticError.TypeMismatch ->
            "Error ${contextMessage(semanticFileIssue.context)}: " +
                    "Type mismatch, expected: ${semanticFileIssue.expected.inStringForm()} " +
                    "but got: ${semanticFileIssue.actual.inStringForm()}"
    }

    private fun contextMessage(context: TypeErrorContext): String {
        return when (context) {
            is TypeErrorContext.VariableDefinition ->
                "in declaration of ${context.name}"
        }
    }

    private fun printHelp() {
        log.error(USAGE_STRING)
        log.error("\nOptions:")
        log.error("""
                    |   -o, --output = OUTPUT_DIR    The directory that the output files should be generated to
                    |   -h, --help                   Print this help and exit
                    |""".trimMargin())
    }

    private fun printUsageAndHelpTip() {
        log.error(USAGE_STRING)
        log.error(HELP_TIP_MSG)
    }

    companion object {
        val USAGE_STRING = "Usage: fbc <options> file1.fjr file2.fjr ..."
        val HELP_TIP_MSG = "Use the -h (or --help) option for more information"
    }
}
