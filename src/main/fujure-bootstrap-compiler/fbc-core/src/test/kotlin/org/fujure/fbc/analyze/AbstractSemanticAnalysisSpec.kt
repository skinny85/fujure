package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ProblematicFile
import org.funktionale.either.Disjunction
import org.junit.runner.RunWith
import org.specnaz.kotlin.SpecnazKotlin
import org.specnaz.kotlin.junit.SpecnazKotlinJUnitRunner

@RunWith(SpecnazKotlinJUnitRunner::class)
abstract class AbstractSemanticAnalysisSpec : SpecnazKotlin {
    lateinit var errors: List<ProblematicFile.SemanticFileIssue>
    lateinit var analysisBuilder: AnalysisBuilder

    fun AnalysisBuilder.analyzed() {
        val result = this.analyze()
        errors = if (result is Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, SymbolTable>) {
            result.value
        } else {
            emptyList()
        }
        analysisBuilder = this
    }

    fun AnalysisBuilder.incrementallyAnalyzed() {
        val result = this.incrementallyAnalyze()
        errors = when (result) {
            is Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, SymbolTable> -> result.value
            else -> emptyList()
        }
        analysisBuilder = this
    }

    fun assertAnalysisSucceeded() {
        assertNoErrors(errors)
    }

    fun assertAnalysisFailed() {
        assertThat(errors).isNotEmpty
    }

    fun assertFile1IsCorrect() {
        assertNoErrors(file1Errors())
    }

    fun assertFileIsCorrect(file: String) {
        assertNoErrors(fileErrors(file))
    }

    fun file1Errors(): List<SemanticError> {
        return fileErrors(0)
    }

    fun file2Errors(): List<SemanticError> {
        return fileErrors(1)
    }

    private fun fileErrors(i: Int): List<SemanticError> {
        return fileErrors(analysisBuilder.fileName(i))
    }

    fun fileErrors(file: String): List<SemanticError> {
        return errors.find { it.userProvidedFilePath == file }?.errors ?: emptyList()
    }

    private fun assertNoErrors(errors: List<*>) {
        assertThat(errors).isEmpty()
    }
}
