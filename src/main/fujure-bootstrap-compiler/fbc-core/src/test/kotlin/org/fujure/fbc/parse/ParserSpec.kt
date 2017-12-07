package org.fujure.fbc.parse

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class ParserSpec : SpecnazKotlinJUnit("Parser", {
    val parser: Parser = BnfcParser
    val result = Deferred<ParsingResult>()

    it.describes("called with a file containing 'def xxx'") {
        it.beginsAll {
            result.v = parser.parse(OpenedFile(InputFile("whatever.fjr"), CharStreams.fromString("""
                def xxx
                """)))
        }

        it.should("return a ParsingResult\$Failure") {
            val parsingFailure = assume(result.v).isA<ParsingResult.Failure>()
            assertThat(parsingFailure.cause.errors).isNotEmpty()
        }
    }

    it.describes("called with a file containing just a hash") {
        it.beginsAll {
            result.v = parser.parse(OpenedFile(InputFile("whatever.fjr"), CharStreams.fromString("""
                #
                """)))
        }

        it.should("return a ParsingResult\$Success") {
            assume(result.v).isA<ParsingResult.Success>()
        }
    }

    it.describes("called with a value with the name 'package'") {
        it.beginsAll {
            result.v = parser.parse(OpenedFile(InputFile("whatever.fjr"), CharStreams.fromString("""
                def package = 1
                """)))
        }

        it.should("fail parsing") {
            val parsingFailure = assume(result.v).isA<ParsingResult.Failure>()
            assertThat(parsingFailure.cause.errors).isNotEmpty()
        }
    }
})
