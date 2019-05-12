package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat

class IfExpressionAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("If expressions in Semantic Analysis") {
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

        it.describes("with an 'if' expression that has different types in their 'then' and 'else' branch") {
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
