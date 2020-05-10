package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueReference

class MethodCallsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Method calls Semantic Analysis") {
        it.describes("for a call to an int literal method from the Int module") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int = (-1).abs().abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a local module function called as a method on an int literal") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def abs(i: Int): String = "abs"
                            def a: String = (-1).abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a method call on a module-qualified value") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int = Int.maxInt.abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a method call on a variable") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def x = 0
                            def a: Int = x.abs()
                        """)
                        .analyzed()
            }

            it.should("be analyzed correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a simple value in a built-in module called as a method") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int = 1.maxInt()
                        """)
                        .analyzed()
            }

            it.should("fail with a NotInvokable error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.NotInvokable(
                                ErrorContext.ValueDefinition("a"),
                                BuiltInTypes.Int))
            }
        }
    }
}}
