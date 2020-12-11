package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.TypeName
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference

class FunctionsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Functions Semantic Analysis") {
        it.describes("for a function without a return type or body") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a()
                        """)
                        .analyzed()
            }

            it.should("report TypeRequired.FunctionReturn and CannotBeAbstract errors") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeRequired.FunctionReturn(
                                ErrorContext.ValueDefinition("a")),
                        SemanticError.CannotBeAbstract(
                                ErrorContext.ValueDefinition("a")))
            }
        }

        it.describes("for a function with arguments without a type, repeated name and with a default, incorrect value") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def f(a: Int, a = x): Int = 1
                        """)
                        .analyzed()
            }

            it.should("report only DuplicateDefinition, TypeRequired.FunctionArgument and DefaultArgumentValueUnsupported errors") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.DuplicateDefinition(
                                "a", ErrorContext.ValueDefinition("f")),
                        SemanticError.TypeRequired.FunctionArgument(
                                ErrorContext.ValueDefinition("f"), "a"),
                        SemanticError.DefaultArgumentValueUnsupported(
                                ErrorContext.ValueDefinition("f"), "a"))
            }
        }

        it.describes("for a function that has: an argument with a function type containing an unknown type, and an unknown return type") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def f(a: Int -> B -> String): B = 1
                        """)
                        .analyzed()
            }

            it.should("report a TypeNotFound error for each instance of providing an unknown type (even if they're the same)") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeNotFound(
                                ErrorContext.ValueDefinition("f"), TypeName("B")),
                        SemanticError.TypeNotFound(
                                ErrorContext.ValueDefinition("f"), TypeName("B")))
            }
        }

        it.describes("for a function with an invalid body") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def f(): Bool = 1 / a
                        """)
                        .analyzed()
            }

            it.should("report the errors in the body, but still use the invalid body's available type information") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.UnresolvedReference(
                                ErrorContext.ValueDefinition("f"), ValueReference("a")),
                        SemanticError.TypeMismatch(
                                ErrorContext.ValueDefinition("f"), BuiltInTypes.Bool, BuiltInTypes.Int))
            }
        }

        it.describes("for a function that references a forward-declared function") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def odd(n: Int): Bool = if n == 0 then false else even(n - 1)
                            
                            def even(n: Int): Bool = if n == 0 then true else odd(n - 1)
                        """)
                        .analyzed()
            }

            it.should("analyze both functions correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a recursive function") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def fact(n: Int): Int = if n > 1
                                then n * fact(n - 1)
                                else 1
                        """)
                        .analyzed()
            }

            it.should("analyze the recursive function correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("for a function that references a forward-declared simple value") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def f(): Int = v
                            def v = f()
                        """)
                        .analyzed()
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }
    }
}}
