package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.AstRoot
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

    fun analyzedSuccess(result: SemanticAnalysisResult): AstRoot {
        val success = assume(result).isA<SemanticAnalysisResult.Success>()
        return success.analyzedProgram.asts[0]
    }

    val result = Deferred<SemanticAnalysisResult>()

    it.describes("called with an empty program") {
        it.beginsAll {
            result.v = analyzeProgram("""
                """)
        }

        it.should("parse an empty package name") {
            val astRoot = analyzedSuccess(result.v)

            assertThat(astRoot.fileContents.packageName).isEmpty()
        }
    }

    it.describes("called with just a package name") {
        it.beginsAll {
            result.v = analyzeProgram("""
                package com.example
                """)
        }

        it.should("parse the package name") {
            val astRoot = analyzedSuccess(result.v)

            assertThat(astRoot.fileContents.packageName).isEqualTo("com.example")
        }
    }

    it.describes("called with one simple value definition") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = 42
                """)
        }

        it.should("parse the one definition") {
            val fileContents = analyzedSuccess(result.v).fileContents

            assertThat(fileContents.defs).hasSize(1)
        }
    }
})
