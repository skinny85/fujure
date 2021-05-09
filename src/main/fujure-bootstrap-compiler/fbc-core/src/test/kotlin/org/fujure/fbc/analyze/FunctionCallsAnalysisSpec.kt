package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueReference

class FunctionCallsAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Function calls Semantic Analysis") {
            it.describes("when calling a built-in function of the Int module") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = Int.abs(11)
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("when calling a function with too many arguments") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs(11, "11")
                                def b: Int = a
                            """)
                            .analyzed()
                }

                it.should("report an ArgumentCountMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.ArgumentCountMismatch(
                                    ErrorContext.ValueDefinition("a"),
                                    1, 2))
                }
            }

            it.describes("when calling a one-argument function with a String instead of the correct Int") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs("11")
                                def b: Int = a
                            """)
                            .analyzed()
                }

                it.should("report a TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }

            it.describes("when calling a function that does not exist") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.doesNotExist("11")
                            """)
                            .analyzed()
                }

                it.should("report an UnresolvedReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    ErrorContext.ValueDefinition("a"),
                                    ValueReference("Int", "doesNotExist")))
                }
            }

            it.describes("when calling a reference that is not a function") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.maxInt("11")
                            """)
                            .analyzed()
                }

                it.should("report a NotInvokable error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.NotInvokable(
                                    ErrorContext.ValueDefinition("a"),
                                    BuiltInTypes.Int))
                }
            }

            it.describes("when assigning a function to a value, and then calling that value") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs
                                def b: Int = a(3)
                                def c: Int -> Int = a
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("for a call to a polymorphic function") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                import fujure.io.std.IO

                                def main(): IO<Unit> = IO.chain(
                                    IO.putStrLn("Hello, how are you?"),
                                    IO.putStrLn("I'm great, thanks for asking!"))
                            """)
                            .analyzed()
                }

                it.should("infer the type variables") {
                    assertAnalysisSucceeded()
                }
            }
        }
    }
}
