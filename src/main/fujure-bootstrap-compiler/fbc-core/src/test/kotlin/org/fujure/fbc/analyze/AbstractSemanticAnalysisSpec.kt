package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.SymbolTable
import org.funktionale.either.Disjunction
import org.junit.runner.RunWith
import org.specnaz.kotlin.SpecnazKotlin
import org.specnaz.kotlin.junit.SpecnazKotlinJUnitRunner

@RunWith(SpecnazKotlinJUnitRunner::class)
abstract class AbstractSemanticAnalysisSpec : SpecnazKotlin {
    lateinit var errors: List<ProblematicFile.SemanticFileIssue>

    fun AnalysisBuilder.analyzed() {
        val result = this.analyze()
        errors = if (result is Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, SymbolTable>) {
            result.value
        } else {
            emptyList()
        }
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
        return fileErrors(1)
    }

    fun file2Errors(): List<SemanticError> {
        return fileErrors(2)
    }

    fun fileErrors(i: Int): List<SemanticError> {
        return fileErrors("File$i.fjr")
    }

    fun fileErrors(file: String): List<SemanticError> {
        return errors.find { it.userProvidedFilePath == file }?.errors ?: emptyList()
    }

    private fun assertNoErrors(errors: List<*>) {
        assertThat(errors).isEmpty()
    }
}
