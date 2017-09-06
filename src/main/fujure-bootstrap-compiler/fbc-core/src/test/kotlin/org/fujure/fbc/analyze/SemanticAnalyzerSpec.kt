package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.ParsingResult
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class SemanticAnalyzerSpec : SpecnazKotlinJUnit("SemanticAnalysis", {
    fun parseProgram(program: String): ParsedFile {
        val openedFile = OpenedFile("whatever.fjr", CharStreams.fromString(program))
        val parsingResult = BnfcParser.parse(openedFile)
        val success = assume(parsingResult).isA<ParsingResult.Success>()
        return success.parsedFile
    }

    val analyzer: SemanticAnalyzer = SimpleSemanticAnalyzer

    fun analyzeProgram(program: String): SemanticAnalysisResult {
        return analyzer.analyze(listOf(parseProgram(program)))
    }

    val result = Deferred<SemanticAnalysisResult>()

    it.describes("called with an empty program") {
        it.beginsAll {
            result.v = analyzeProgram("""
                """)
        }

        val success = Deferred<SemanticAnalysisResult.Success>()

        it.should("return SemanticAnalysisResult\$Success") {
            success.v = assume(result.v).isA<SemanticAnalysisResult.Success>()
        }

        it.should("parse an empty package name") {
            val astRoot = success.v.analyzedProgram.asts[0]
            assertThat(astRoot.fileContents.packageName).isEmpty()
        }
    }
})
