package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueReference

class MethodCallsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Method calls Semantic Analysis") {
        it.describes("for a chained method call on a literal that is a function in the module of the receiver") {
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

        it.describes("for a method call to a local function with the same name as a function in the receiver's module") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def abs(i: Int): String = "abs"
                            def a: String = (-1).abs()
                        """)
                        .analyzed()
            }

            it.should("give precedence to the local function") {
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

        it.describes("for a method call that doesn't correspond to any function, locally or in the receiver's module") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: Int = 1.doesNotExist()
                        """)
                        .analyzed()
            }

            it.should("fail with an UnresolvedReference error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.UnresolvedReference(
                                ErrorContext.ValueDefinition("a"),
                                ValueReference("doesNotExist")))
            }
        }

        it.describes("for a method call with the same name as a local function, but with different argument types") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def abs(s: String): Int = 42
                            def a: Int = 1.abs()
                        """)
                        .analyzed()
            }

            it.should("fall back to the receiver module's function with argument types matching the call") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a pseudo do-block with the IO type") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def main(): IO<String> = IO.putStrLn("Hello, how are you?")
                                .chain(IO.putStrLn("I'm great, thanks for asking!"))
                        """)
                        .analyzed()
            }

            it.should("be analyzed successfully") {
                assertAnalysisSucceeded()
            }
        }
    }
}}
