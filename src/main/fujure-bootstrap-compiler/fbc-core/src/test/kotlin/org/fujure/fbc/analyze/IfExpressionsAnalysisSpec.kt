package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat

class IfExpressionsAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Semantic Analysis of 'if' expressions") {
        it.describes("with a simple correct 'if' statement") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a = if true then 1 else 2
                        """)
                        .analyzed();
            }

            it.should("analyze correctly") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("with an 'if' expression that has a non-boolean condition") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a = if 1 then "a" else "b"
                        """)
                        .analyzed()
            }

            it.should("report a TypeMismatch error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeMismatch(
                                ErrorContext.ValueDefinition("a"),
                                BuiltInTypes.Bool, BuiltInTypes.Int))
            }
        }

        it.describes("with an 'if' expression that has different types in their 'then' and 'else' branches") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a = if true then 'a' else unit
                        """)
                        .analyzed()
            }

            it.should("report a TypeMismatch error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeMismatch(
                                ErrorContext.ValueDefinition("a"),
                                BuiltInTypes.Char, BuiltInTypes.Unit))
            }
        }
    }
}}
