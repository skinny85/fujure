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
}
