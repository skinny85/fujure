package org.fujure.fjc

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.MissingRequiredPositionalArgumentException
import com.xenomachina.argparser.OptionMissingRequiredArgumentException
import com.xenomachina.argparser.ShowHelpException
import com.xenomachina.argparser.default
import org.fujure.fjc.internal.ArgumentFile
import org.fujure.fjc.internal.CodeGenResult
import org.fujure.fjc.internal.CodeGenerator
import org.fujure.fjc.internal.ReadFile

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val ret = mainReturningExitCode(args)
        if (ret != 0) {
            System.exit(ret)
        }
    }

    fun mainReturningExitCode(args: Array<String>): Int {
        val compilerArgs = CompilerArgs(ArgParser(args))

        if (args.isEmpty()) {
            compilerArgs.printHelp()
            return 2
        } else {
            val files: List<String>
            try {
                files = compilerArgs.sourceFiles
            } catch (_: ShowHelpException) {
                compilerArgs.printHelp()
                return 0
            } catch (_: MissingRequiredPositionalArgumentException) {
                // no source files provided
                println("fjc: No source files provided")
                compilerArgs.printUsageAndHelpTip()
                return 2
            } catch (e: OptionMissingRequiredArgumentException) {
                // no value provided to eg. -o
                println("fjc: ${e.message}")
                compilerArgs.printUsageAndHelpTip()
                return 2
            }
            return compileFiles(files)
        }
    }

    private fun compileFiles(files: List<String>): Int {
        val openFiles = openFiles(files)
        if (openFiles.size != files.size)
            return 3

        val parsedFiles = parseFiles(openFiles)
        if (parsedFiles.size != files.size)
            return 4

        val codeGenerator = CodeGenerator(parsedFiles)
        val codeGenResults = codeGenerator.generate()
        for (codeGenResult in codeGenResults) {
            if (codeGenResult is CodeGenResult.Failure) {
                println("Error compiling ${codeGenResult.userProvidedFile}: ${codeGenResult.error.message}")
                return 5
            }
        }
        return 0
    }

    private fun openFiles(files: List<String>): List<ArgumentFile.OpenedFile> {
        val openFiles = mutableListOf<ArgumentFile.OpenedFile?>()
        for (file in files) {
            val tryOpenFile = ArgumentFile.openFile(file)
            openFiles.add(when (tryOpenFile) {
                is ArgumentFile.InvalidFilename -> {
                    println("Invalid file name: '$file'. Fujure source files must have the .fjr extension")
                    null
                }
                is ArgumentFile.MissingFile -> {
                    println("Error opening $file: file not found")
                    null
                }
                is ArgumentFile.FailedFile -> {
                    println("Error opening $file: ${tryOpenFile.error.message}")
                    null
                }
                is ArgumentFile.OpenedFile -> {
                    tryOpenFile
                }
            })
        }
        return openFiles.filterNotNull()
    }

    private fun parseFiles(openFiles: List<ArgumentFile.OpenedFile>): List<ReadFile.ParsedFile> {
        val parsedFiles = mutableListOf<ReadFile.ParsedFile?>()
        for (openFile in openFiles) {
            val tryParseFile = ReadFile.parse(openFile)
            parsedFiles.add(when (tryParseFile) {
                is ReadFile.UnparsedFile -> {
                    println("Couldn't parse ${tryParseFile.userProvidedFile}:")
                    for ((line, column, msg) in tryParseFile.errors) {
                        println("${tryParseFile.userProvidedFile}:${line},${column}: ${msg}")
                    }
                    null
                }
                is ReadFile.ParsedFile -> {
                    tryParseFile
                }
            })
        }
        return parsedFiles.filterNotNull()
    }
}

class CompilerArgs(parser: ArgParser) {
    val output by parser
            .storing("-o", "--output",
                    help = "The directory that the output files should be generated to")
            .default(".")

    val sourceFiles by parser
            .positionalList("SOURCE",
                    help = "Source files (with the .fjr extension) to compile")

    fun printHelp() {
        println(USAGE_STRING)
        println("\nOptions:")
        println("""
                |   -o, --output = OUTPUT_DIR    The directory that the output files should be generated to
                |   -h, --help                   Print this help and exit
                |""".trimMargin())
    }

    fun printUsageAndHelpTip() {
        println(CompilerArgs.USAGE_STRING)
        println("Use the -h (or --help) option for more information")
    }

    companion object {
        private val USAGE_STRING = "Usage: fjc <options> file1.fjr file2.fjr ..."
    }
}
