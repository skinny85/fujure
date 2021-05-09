package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.InputFile

class ModulesAnalysisSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Semantic Analysis of modules") {
        it.describes("when a new module has the same name as one of the built-in modules, but a different package") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            package example
                            
                            def a = true
                        """)
                        .named("Int")
                        .file("""
                            import example.Int
                            
                            def b: Bool = Int.a
                        """.trimIndent())
                        .analyzed()
            }

            it.should("succeed - that shadowing is allowed") {
                assertAnalysisSucceeded()
            }
        }

        it.describes("when a new module shadows one of the built-in modules") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            package fujure
                            
                            def a = true
                        """)
                        .named("Int.fjr")
                        .analyzed()
            }

            it.should("report a ConflictsWithBuiltInModule error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.ConflictsWithBuiltInModule("fujure", "Int",
                            InputFile("Int.fjr")))
            }
        }
    }
}}
