package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference
import org.fujure.test.utils.Assumption.Companion.assume
import org.funktionale.either.Disjunction
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class DoubleFileSemanticAnalysisSpec : SpecnazKotlinJUnit("Double file Semantic Analysis", {
    // for analyzeProgramsSuccessfully
    lateinit var firstFileContents: FileContents
    lateinit var secondFileContents: FileContents

    fun analyzeProgramsSuccessfully(firstProgram: String, secondProgram: String) {
        val analysisResult = AnalysisHelper.analyzePrograms(firstProgram, secondProgram)
        val success = assume(analysisResult).isA<Disjunction.Right<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram>>()
        Assertions.assertThat(success.value.asts).hasSize(2)
        firstFileContents = success.value.asts[0].fileContents
        secondFileContents = success.value.asts[1].fileContents
    }

    // for analyzeProgramsExpectingErrors
    lateinit var firstFileErrors: List<SemanticError>
    lateinit var secondFileErrors: List<SemanticError>

    fun analyzeProgramsExpectingErrors(firstProgram: String, secondProgram: String) {
        val analysisResult = AnalysisHelper.analyzePrograms(firstProgram, secondProgram)
        val failure = assume(analysisResult).isA<Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram>>()

        firstFileErrors = AnalysisHelper.findFileErrors(1, failure)
        secondFileErrors = AnalysisHelper.findFileErrors(2, failure)
    }

    fun assertFirstProgramIsCorrect() {
        assertThat(firstFileErrors).isEmpty()
    }

    it.describes("called with a program referencing a value from another file") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       def a: Int = 42
                    """,
                    """
                        def x: Int = File1.a
                    """)
        }

        it.should("parse the first program correctly") {
            assertThat(firstFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.IntLiteral(42)))
        }

        it.should("parse the second program correctly") {
            assertThat(secondFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File1", "a"))))
        }
    }

    it.describes("called with a program referencing a value from another package without an import") {
        it.beginsAll {
            analyzeProgramsExpectingErrors(
                    """
                       package com.example

                       def a: Int = 42
                    """,
                    """
                        package com.example.inner

                        def x: Int = File1.a
                    """)
        }

        it.should("parse the first program correctly") {
            assertFirstProgramIsCorrect()
        }

        it.should("return an UnresolvedReference error for the second file") {
            assertThat(secondFileErrors).containsExactly(
                    SemanticError.UnresolvedReference(
                            TypeErrorContext.VariableDefinition("x"),
                            ValueReference("File1", "a")))
        }
    }

    it.describes("called with a program referencing a value from a forward file") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       def a: Int = File2.x
                    """,
                    """
                        def x: Int = 42
                    """)
        }

        it.should("parse the first program correctly") {
            assertThat(firstFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File2", "x"))))
        }

        it.should("parse the second program correctly") {
            assertThat(secondFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.IntLiteral(42)))
        }
    }

    it.describes("called with a program referencing a value from a forward file with an inferred type") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       def a: Int = File2.x
                    """,
                    """
                        def x = 42
                    """)
        }

        it.should("parse the first program correctly") {
            assertThat(firstFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File2", "x"))))
        }

        it.should("parse the second program correctly") {
            assertThat(secondFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", null, Expr.IntLiteral(42)))
        }
    }

    it.describes("called with a cycle of 2 values without declared types") {
        it.beginsAll {
            analyzeProgramsExpectingErrors(
                    """
                       def a = File2.x
                    """,
                    """
                       def x = File1.a
                    """)
        }

        it.should("detect the cycle in the first file") {
            assertThat(firstFileErrors).containsExactly(
                    SemanticError.CyclicDefinition(
                            TypeErrorContext.VariableDefinition("a"),
                            listOf(
                                    ValueCoordinates("", "File1", "a"),
                                    ValueCoordinates("", "File2", "x"),
                                    ValueCoordinates("", "File1", "a"))))
        }

        it.should("detect the cycle in the second file") {
            assertThat(secondFileErrors).containsExactly(
                    SemanticError.CyclicDefinition(
                            TypeErrorContext.VariableDefinition("x"),
                            listOf(
                                    ValueCoordinates("", "File2", "x"),
                                    ValueCoordinates("", "File1", "a"),
                                    ValueCoordinates("", "File2", "x"))))
        }
    }

    it.describes("called with a cycle of 2 values in which one has a declared type") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       def a: Int = File2.x
                    """,
                    """
                       def x = File1.a
                    """)
        }

        it.should("parse the value with the declared type correctly") {
            assertThat(firstFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File2", "x"))))
        }

        it.should("parse the value without the declared type correctly") {
            assertThat(secondFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", null, Expr.ValueReferenceExpr(ValueReference("File1", "a"))))
        }
    }

    it.describes("called with an import from the default package") {
        it.beginsAll {
            analyzeProgramsExpectingErrors(
                    """
                        def a = 1
                    """,
                    """
                        package inner

                        import File1

                        def x = File1.a
                    """)
        }

        it.should("parse the file in the default package correctly") {
            assertFirstProgramIsCorrect()
        }

        it.should("report an UnresolvedImport error for the importing file") {
            assertThat(secondFileErrors).contains(
                    SemanticError.UnresolvedImport(Import("File1")))
        }
    }

    it.describes("called with a program referencing a value from another package with an import") {
        it.beginsAll {
            analyzeProgramsSuccessfully(
                    """
                       package com.example

                       def a: Int = 42
                    """,
                    """
                        package com.example.inner

                        import com.example.File1

                        def x: Int = File1.a
                    """)
        }

        it.should("parse the imported program correctly") {
            assertThat(firstFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.IntLiteral(42)))
        }

        it.should("parse the importing program correctly") {
            assertThat(secondFileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.ValueReferenceExpr(
                            ValueReference("File1", "a"))))
        }
    }
})
