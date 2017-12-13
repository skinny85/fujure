package org.fujure.fbc.parse

import org.antlr.v4.runtime.ANTLRInputStream
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class ParserSpec : SpecnazKotlinJUnit("Parser", {
    val parser: Parser = BnfcParser
    lateinit var result: ParsingResult

    it.describes("called with a file containing 'def xxx'") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def xxx
                """)))
        }

        it.should("return a ParsingResult\$Failure") {
            val parsingFailure = assume(result).isA<ParsingResult.Failure>()
            assertThat(parsingFailure.cause.errors).isNotEmpty()
        }
    }

    it.describes("called with a file containing just a hash") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                #
                """)))
        }

        it.should("fail parsing") {
            assume(result).isA<ParsingResult.Failure>()
        }
    }

    it.describes("called with a value with the name 'package'") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def package = 1
                """)))
        }

        it.should("fail parsing") {
            val parsingFailure = assume(result).isA<ParsingResult.Failure>()
            assertThat(parsingFailure.cause.errors).isNotEmpty()
        }
    }

    it.describes("called with a Char value") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = 'a'
                """)))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result).isA<ParsingResult.Success>()
        }
    }

    it.describes("called with correctly escaped Char values") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c1 = '\''
                def c2 = '\\'
                """)))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result).isA<ParsingResult.Success>()
        }
    }

    it.describes("called with an unescaped backslash in a Char value") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = '\'
                """)))
        }

        it.should("fail parsing") {
            assume(result).isA<ParsingResult.Failure>()
        }
    }

    it.describes("called with an unescaped quote in a Char value") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = '''
                """)))
        }

        it.should("fail parsing") {
            assume(result).isA<ParsingResult.Failure>()
        }
    }

    it.describes("called with an empty Char literal value") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = ''
                """)))
        }

        it.should("fail parsing") {
            assume(result).isA<ParsingResult.Failure>()
        }
    }

    it.describes("called with a String value") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = "a"
                """)))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result).isA<ParsingResult.Success>()
        }
    }

    it.describes("called with a String value containing some escaped characters") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def c = "\n\\"
                """)))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result).isA<ParsingResult.Success>()
        }
    }

    it.describes("called with a String value containing only a backslash") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"), ANTLRInputStream("""
                def s = "\"
                """)))
        }

        it.should("return a ParsingResult\$Failure") {
            assume(result).isA<ParsingResult.Failure>()
        }
    }

    it.describes("called with a String value containing only a double quote") {
        it.beginsAll {
            result = parser.parse(OpenedFile(InputFile("whatever.fjr"),
                    ANTLRInputStream("def s = \"\"\"")))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result).isA<ParsingResult.Success>()
        }
    }
})
