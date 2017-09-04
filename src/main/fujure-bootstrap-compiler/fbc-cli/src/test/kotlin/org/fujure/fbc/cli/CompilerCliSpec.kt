package org.fujure.fbc.cli

import com.nhaarman.mockito_kotlin.any
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.CompilationResults
import org.fujure.fbc.CompileOptions
import org.mockito.Mockito
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred
import org.fujure.fbc.Compiler
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.codegen.CodeGenResult
import org.fujure.fbc.parse.SyntaxError
import java.io.File
import java.io.IOException

class CompilerCliSpec : SpecnazKotlinJUnit("CompilerCli#compile", {
    val appendingLogger = object : Deferred<AppendingLogger>() {
        fun verifyLogged(msgFragment: String) {
            v.verifyLogged(msgFragment)
        }
    }
    val compilerCli = object : Deferred<CompilerCli>() {
        fun invokeCompiler(args: Array<String>): Int = v.invokeCompiler(args)
    }
    val mockCompiler = Deferred<Compiler>()

    it.beginsAll {
        appendingLogger.v = AppendingLogger()
        mockCompiler.v = Mockito.mock(Compiler::class.java)
        compilerCli.v = CompilerCli(appendingLogger.v, mockCompiler.v)
    }

    it.describes("called with no arguments") {
        var result = -479

        it.beginsAll {
            result = compilerCli.invokeCompiler(emptyArray())
        }

        it.should("return 2") {
            assertThat(result).isEqualTo(2)
        }

        it.should("display the help info") {
            appendingLogger.v.verifyHelpInfoLogged()
        }
    }

    it.describes("called with 'random_file -h'") {
        var result = -479

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("random_file", "-h"))
        }

        it.should("return 0") {
            assertThat(result).isZero()
        }

        it.should("display the help info") {
            appendingLogger.v.verifyHelpInfoLogged()
        }
    }

    it.describes("called without giving any source files") {
        var result = -3

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("-o", "whatever"))
        }

        it.should("return 2") {
            assertThat(result).isEqualTo(2)
        }

        it.should("warn about not providing any source files") {
            appendingLogger.verifyLogged("No source files provided")
        }

        it.should("display the usage string") {
            appendingLogger.v.verifyUsageStringLogged()
        }

        it.should("display the help tip") {
            appendingLogger.v.verifyHelpTipLogged()
        }
    }

    it.describes("called without providing an argument to -o") {
        var result = -3

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("whatever", "-o"))
        }

        it.should("return 2") {
            assertThat(result).isEqualTo(2)
        }

        it.should("display the usage and help tip") {
            appendingLogger.v.verifyUsageAndHelpTipLogged()
        }
    }

    it.describes("called with an unknown option") {
        var result = -3

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("-x"))
        }

        it.should("return 2") {
            assertThat(result).isEqualTo(2)
        }

        it.should("display the usage and help tip") {
            appendingLogger.v.verifyUsageAndHelpTipLogged()
        }

        it.should("display the name of the unrecognized option") {
            appendingLogger.verifyLogged("-x")
        }
    }

    it.describes("called with correct arguments") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationAttempted(
                            emptyList(), emptyList()))
        }

        var result = -3

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("whatever.fjr", "--output", "dest"))
        }

        it.should("return 0") {
            assertThat(result).isZero()
        }

        it.should("call the compiler passing the parsed arguments") {
            Mockito.verify(mockCompiler.v).compile(
                    CompileOptions("dest"),
                    listOf("whatever.fjr"))
        }
    }

    it.describes("receiving an InvalidFileExtension response from the compiler") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationNotAttempted(listOf(
                            ProblematicFile.BasicFileIssue.InvalidFileExtension("../whatever.java"))))
        }

        var result = -100

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("../whatever.java"))
        }

        it.should("return 1") {
            assertThat(result).isOne()
        }

        it.should("display the path of the incorrect file") {
            appendingLogger.verifyLogged("../whatever.java")
        }

        it.should("display the extension message") {
            appendingLogger.verifyLogged(".fjr extension")
        }
    }

    it.describes("receiving a FileNotFound response from the compiler") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationNotAttempted(listOf(
                            ProblematicFile.BasicFileIssue.FileNotFound("../whatever.fjr"))))
        }

        var result = -100

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("../whatever.fjr"))
        }

        it.should("return 1") {
            assertThat(result).isOne()
        }

        it.should("display the path of the incorrect file") {
            appendingLogger.verifyLogged("../whatever.fjr")
        }

        it.should("display the 'file not found' message") {
            appendingLogger.verifyLogged("file not found")
        }
    }

    it.describes("receiving a CouldNotOpenFile response from the compiler") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationNotAttempted(listOf(
                            ProblematicFile.BasicFileIssue.CouldNotOpenFile("../whatever.fjr",
                                    IOException("test exception message")))))
        }

        var result = -100

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("../whatever.fjr"))
        }

        it.should("return 1") {
            assertThat(result).isOne()
        }

        it.should("display the path of the incorrect file") {
            appendingLogger.verifyLogged("../whatever.fjr")
        }

        it.should("display the exception message") {
            appendingLogger.verifyLogged("test exception message")
        }
    }

    it.describes("receiving a ParsingFileIssue response from the compiler") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationNotAttempted(listOf(
                            ProblematicFile.ParsingFileIssue("../whatever.fjr", listOf(
                                    SyntaxError(1, 2, "expected 'def'"),
                                    SyntaxError(11, 22, "unrecognized token"))))))
        }

        var result = -100

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("../whatever.fjr"))
        }

        it.should("return 1") {
            assertThat(result).isOne()
        }

        it.should("display the path of the incorrect file along with each error line and column numbers") {
            appendingLogger.verifyLogged("../whatever.fjr:(1:2):")
            appendingLogger.verifyLogged("../whatever.fjr:(11:22):")
        }

        it.should("display all of the parsing error messages") {
            appendingLogger.verifyLogged("expected 'def'")
            appendingLogger.verifyLogged("unrecognized token")
        }
    }

    it.describes("receiving a CompilationAttempted with errors response from the compiler") {
        it.beginsAll {
            Mockito.`when`(mockCompiler.v.compile(any(), any()))
                    .thenReturn(CompilationResults.CompilationAttempted(emptyList(), listOf(
                            CodeGenResult.Failure("../whatever.fjr", File("xxx"), IOException("could not write file 'xxx'")))))

        }

        var result = -100

        it.beginsAll {
            result = compilerCli.invokeCompiler(arrayOf("../whatever.fjr"))
        }

        it.should("return 1") {
            assertThat(result).isOne()
        }

        it.should("display the path of the file that caused the generation to fail") {
            appendingLogger.verifyLogged("../whatever.fjr")
        }

        it.should("display the error message") {
            appendingLogger.verifyLogged("could not write file 'xxx'")
        }
    }
})

private fun AppendingLogger.verifyHelpInfoLogged() {
    verifyUsageStringLogged()
    this.verifyLogged("Options:")
    this.verifyLogged("--output")
}

private fun AppendingLogger.verifyUsageAndHelpTipLogged() {
    this.verifyUsageStringLogged()
    this.verifyHelpTipLogged()
}

private fun AppendingLogger.verifyUsageStringLogged() {
    this.verifyLogged(CompilerCli.USAGE_STRING)
}

private fun AppendingLogger.verifyHelpTipLogged() {
    this.verifyLogged(CompilerCli.HELP_TIP_MSG)
}
