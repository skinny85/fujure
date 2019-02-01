package org.fujure.fbc.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.MissingRequiredPositionalArgumentException
import com.xenomachina.argparser.OptionMissingRequiredArgumentException
import com.xenomachina.argparser.ShowHelpException
import com.xenomachina.argparser.UnrecognizedOptionException
import org.fujure.fbc.CompilationResults
import org.fujure.fbc.CompileOptions
import org.fujure.fbc.Compiler

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
                for (problematicFile in compilationResults.problematicFiles) {
                    log.error(problematicFile.humanReadableMsg())
                }
                1
            }
            is CompilationResults.CompilationAttempted -> {
                if (compilationResults.encounteredFailures()) {
                    for (failure in compilationResults.failures) {
                        log.error("Error generating code for ${failure.inputFile.userProvidedFilePath}: ${failure.error.message}")
                    }
                    1
                } else {
                    0
                }
            }
        }

        return exitCode
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
