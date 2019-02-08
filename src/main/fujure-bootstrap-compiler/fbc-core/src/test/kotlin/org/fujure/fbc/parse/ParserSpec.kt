package org.fujure.fbc.parse

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.funktionale.either.Disjunction
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import java.io.StringReader

class ParserSpec : SpecnazKotlinJUnit("Parser#parse", {
    val parser: Parser = BnfcParser
    lateinit var result: Disjunction<ProblematicFile.ParsingFileIssue, ParsedFile>

    fun parse(program: String) {
        result = parser.parse(OpenedFile(InputFile("whatever.fjr"), StringReader(program)))
    }

    fun assertParsingFailed() {
        val parsingFailure = assume(result).isA<Disjunction.Left<ProblematicFile.ParsingFileIssue, ParsedFile>>()
        assertThat(parsingFailure.value.errors).isNotEmpty
    }

    fun assertParsingSucceeded() {
        assume(result).isA<Disjunction.Right<ProblematicFile.ParsingFileIssue, ParsedFile>>()
    }

    it.describes("called with a file containing just the word 'def'") {
        it.beginsAll {
            parse("""
                def
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with a file containing just a hash") {
        it.beginsAll {
            parse("""
                #
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with a simple value definition without an initializer expression") {
        it.beginsAll {
            parse("""
                def xxx
            """)
        }

        it.should("parse the program correctly") {
            assertParsingSucceeded()
        }
    }

    it.describes("called with a simple value definition with the name 'package'") {
        it.beginsAll {
            parse("""
                def package = 1
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with a Char value") {
        it.beginsAll {
            parse("""
                def c = 'a'
            """)
        }

        it.should("parse the program correctly") {
            assertParsingSucceeded()
        }
    }

    it.describes("called with correctly escaped Char values") {
        it.beginsAll {
            parse("""
                def c1 = '\''
                def c2 = '\\'
            """)
        }

        it.should("parse the program correctly") {
            assertParsingSucceeded()
        }
    }

    it.describes("called with an unescaped backslash in a Char value") {
        it.beginsAll {
            parse("""
                def c = '\'
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with an unescaped quote in a Char value") {
        it.beginsAll {
            parse("""
                def c = '''
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with an empty Char literal value") {
        it.beginsAll {
            parse("""
                def c = ''
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with a String value") {
        it.beginsAll {
            parse("""
                def c = "a"
            """)
        }

        it.should("parse the program correctly") {
            assertParsingSucceeded()
        }
    }

    it.describes("called with a String value containing some escaped characters") {
        it.beginsAll {
            parse("""
                def c = "\n\\"
            """)
        }

        it.should("parse the program correctly") {
            assertParsingSucceeded()
        }
    }

    it.describes("called with a String value containing only a backslash") {
        it.beginsAll {
            parse("""
                def s = "\"
            """)
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with a String value containing only a double quote") {
        it.beginsAll {
            parse(
                    "def s = \"\"\""
            )
        }

        it.should("fail parsing") {
            assertParsingFailed()
        }
    }

    it.describes("called with import statements") {
        it.beginsAll {
            parse("""
                import a.b.c
                import d.e.
                  f
            """)
        }

        it.should("parse all import statements correctly") {
            assertParsingSucceeded()
        }
    }
})
