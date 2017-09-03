package org.fujure.fbc.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CompilerCliArgs(parser: ArgParser) {
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
        println(CompilerCliArgs.USAGE_STRING)
        println("Use the -h (or --help) option for more information")
    }

    companion object {
        private val USAGE_STRING = "Usage: fbc <options> file1.fjr file2.fjr ..."
    }
}
