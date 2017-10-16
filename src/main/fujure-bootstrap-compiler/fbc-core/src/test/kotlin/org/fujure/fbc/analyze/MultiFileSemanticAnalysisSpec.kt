package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class MultiFileSemanticAnalysisSpec : SpecnazKotlinJUnit("Multi file Semantic Analysis", {
    // for analyzeProgramsSuccessfully
    val firstFileContents = Deferred<FileContents>()
    val secondFileContents = Deferred<FileContents>()

    fun analyzeProgramsSuccessfully(firstProgram: String, secondProgram: String) {
        val analysisResult = AnalysisHelper.analyzePrograms(firstProgram, secondProgram)
        val success = assume(analysisResult).isA<SemanticAnalysisResult.Success>()
        Assertions.assertThat(success.analyzedProgram.asts).hasSize(2)
        firstFileContents.v = success.analyzedProgram.asts[0].fileContents
        secondFileContents.v = success.analyzedProgram.asts[1].fileContents
    }

    // for analyzeProgramExpectingErrors
    val errors = Deferred<List<SemanticError>>()

    fun analyzeProgramExpectingErrors(program: String) {
        val analysisResult = AnalysisHelper.analyzeProgram(program)
        val failure = assume(analysisResult).isA<SemanticAnalysisResult.Failure>()
        assertThat(failure.issues).hasSize(1)
        errors.v = failure.issues[0].errors
    }

    it.describes("called with a program referencing a value from another file") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       def a = 42
                    """,
                    """
                        def x: Int = File1.a
                    """
            )
        }

        it.should("parse the first program correctly") {
            assertThat(firstFileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", null, Expr.IntLiteral(42)))
        }

        it.should("parse the second program correctly") {
            assertThat(secondFileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File1", "a"))))
        }
    }

    it.describes("called with a program referencing a value from another package without an import") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       package com.example

                       def a = 42
                    """,
                    """
                        package com.example.inner

                        def x: Int = File1.a
                    """
            )
        }

        it.should("parse the first program correctly") {
            assertThat(firstFileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", null, Expr.IntLiteral(42)))
        }

        it.should("parse the second program correctly") {
            assertThat(secondFileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File1", "a"))))
        }
    }
})
