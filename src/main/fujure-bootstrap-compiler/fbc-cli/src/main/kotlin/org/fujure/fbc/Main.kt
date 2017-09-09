package org.fujure.fbc

import org.fujure.fbc.analyze.SimpleSemanticAnalyzer
import org.fujure.fbc.cli.CompilerCli
import org.fujure.fbc.cli.ConsoleLogger
import org.fujure.fbc.codegen.JavaPoetCodeGenerator
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.read.SimpleFileOpener

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val ret = runCompiler(args)
        if (ret != 0) {
            System.exit(ret)
        }
    }

    @JvmStatic
    fun runCompiler(args: Array<String>): Int {
        val compiler = BootstrapCompiler(SimpleFileOpener, BnfcParser,
                SimpleSemanticAnalyzer, JavaPoetCodeGenerator)
        val compilerCli = CompilerCli(ConsoleLogger, compiler)
        return compilerCli.invokeCompiler(args)
    }
}
