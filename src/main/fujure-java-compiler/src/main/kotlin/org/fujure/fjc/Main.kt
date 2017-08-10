package org.fujure.fjc

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fjc.bnfc.antlr.Fujure.FujureLexer
import org.fujure.fjc.bnfc.antlr.Fujure.FujureParser
import org.fujure.fjc.internal.FjcAntlrErrorListener

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Usage: Main <file-to-compile>.fjr")
        } else {
            compileFile(args[0])
        }
    }

    private fun compileFile(file: String) {
        println("Compiling $file")

        val lexer = FujureLexer(CharStreams.fromFileName(file))

        val parser = FujureParser(CommonTokenStream(lexer))
        parser.removeErrorListeners() // remove the default console listener
        val errorListener = FjcAntlrErrorListener()
        parser.addErrorListener(errorListener)

        val valDefContext = parser.valDef()

        if (errorListener.hasSyntaxErrors) {
            println("Couldn't parse $file")
            errorListener.forEachError { syntaxError ->
                println("$file:${syntaxError.line},${syntaxError.column}: ${syntaxError.msg}")
            }
        } else {
            val valDef: ValDef = valDefContext.result
            val result = valDef.accept({ valueDef, str ->
                "def ${valueDef.ident_} = ${valueDef.integer_} (input: $str)"
            }, "5")
            println("Result is: $result")
        }
    }
}
