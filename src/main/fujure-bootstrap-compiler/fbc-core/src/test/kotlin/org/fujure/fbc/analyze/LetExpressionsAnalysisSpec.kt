package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

class LetExpressionsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Semantic Analysis of 'let' expressions") {
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

        it.describes("with a cycle in the 'let' declaration") {
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

            it.should("report a CannotBeAbstract error in the top-level declaration with the name of the abstract 'let' binding") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.CannotBeAbstract(
                                ErrorContext.ValueDefinition("a"), "b"))
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
                                    b + 2
                        """)
                        .analyzed()
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("with 2 nested 'let's, declaring the same variable") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int =
                                let
                                    b = true
                                in
                                    let b = 2 in b
                        """)
                        .analyzed()
            }

            it.should("analyze correctly - the second 'let' shadows the first's variable") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("when a 'let' variable has an illegal name") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int =
                                let
                                    ${'$'}b = 1, class = 2
                                in
                                    3
                        """)
                        .analyzed()
            }

            it.should("report an InvalidName error for each variable with an illegal name") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.InvalidName("\$b"),
                        SemanticError.InvalidName("class"))
            }
        }

        it.describes("with duplicate variable names in the same 'let'") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int =
                                let
                                    b = 1, b: Bool = x
                                in
                                    b
                        """)
                        .analyzed()
            }

            it.should("report a DuplicateDefinition error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.UnresolvedReference(ErrorContext.ValueDefinition("a"), ValueReference("x")),
                        SemanticError.DuplicateDefinition("b", ErrorContext.ValueDefinition("a")))
            }
        }

        it.describes("when 'let' variables have the same name as top-level definitions") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def b = true

                            def a: Bool =
                                let
                                    a = 1,
                                    b = a
                                in
                                    a > b
                        """)
                        .analyzed()
            }

            it.should("analyze correctly - the 'let' variables shadow the top-level definitions") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("when an inner 'let' refers to the identically named variable in its initializer") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Bool =
                                let
                                    a = 1
                                in
                                    let a = a > 1 in a
                        """)
                        .analyzed()
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("when a 'let' variable refers to itself in the definition") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int =
                                let
                                    b = b
                                in
                                    b
                        """)
                        .analyzed()
            }

            it.should("report an UnresolvedReference error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.UnresolvedReference(ErrorContext.ValueDefinition("a"), ValueReference("b")))
            }
        }
    }
}}
