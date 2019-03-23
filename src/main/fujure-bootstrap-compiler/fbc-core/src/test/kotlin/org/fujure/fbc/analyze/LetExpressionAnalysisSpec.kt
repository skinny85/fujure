package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueCoordinates

class LetExpressionAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Let expressions in Semantic Analysis") {
        it.describes("with a simple, correct one-variable variant without using the new variable") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a =
                                let
                                    b = 1
                                in
                                    2
                        """)
                        .analyzed()
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("with a cycle in the let declaration") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a = File2.b
                        """)
                        .file("""
                            def b =
                                let
                                    x = File1.a
                                in
                                    2
                        """)
                        .analyzed()
            }

            it.should("detect the cycle in referenced file") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.CyclicDefinition(
                                ErrorContext.ValueDefinition("a"),
                                listOf(
                                        ValueCoordinates("", "File1", "a"),
                                        ValueCoordinates("", "File2", "b"),
                                        ValueCoordinates("", "File1", "a"))))
            }

            it.should("detect the cycle in the file with the 'let' expression") {
                assertThat(file2Errors()).containsExactly(
                        SemanticError.CyclicDefinition(
                                ErrorContext.ValueDefinition("b"),
                                listOf(
                                        ValueCoordinates("", "File2", "b"),
                                        ValueCoordinates("", "File1", "a"),
                                        ValueCoordinates("", "File2", "b"))))
            }
        }

        it.describes("when the local value does not have an initializer") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a = let b in 2
                        """)
                        .analyzed()
            }

            it.should("report a MissingInitializer error in the top-level declaration") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.MissingInitializer(
                                ErrorContext.ValueDefinition("a")))
            }
        }

        it.describes("with a simple, correct one-variable variant, using the new variable") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a =
                                let
                                    b = 1
                                in
                                    b  + 2
                        """)
                        .analyzed()
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }
    }
}}
