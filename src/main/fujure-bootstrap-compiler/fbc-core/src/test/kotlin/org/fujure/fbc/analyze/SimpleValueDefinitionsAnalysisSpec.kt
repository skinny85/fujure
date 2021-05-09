package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat

class SimpleValueDefinitionsAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Semantic Analysis of simple value definitions") {
            it.describes("called with an empty file") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                            """)
                            .analyzed()
                }

                it.should("not find any errors in the empty file") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with just a package name including a $ character") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.
                                    ${'$'}example
                            """)
                            .analyzed()
                }

                it.should("analyze the file with only the package correctly") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with invalid value names") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def _: Bool = true
                                def ${'$'}a: Int = 2
                                def class = 3
                            """)
                            .analyzed()
                }

                it.should("report an InvalidName error for each of them") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.InvalidName("_"),
                            SemanticError.InvalidName("\$a"),
                            SemanticError.InvalidName("class"))
                }
            }

            it.describes("called with duplicate simple value definitions") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = true
                                def a: Int = 2
                            """)
                            .analyzed()
                }

                it.should("report a DuplicateDefinition error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.DuplicateDefinition("a"))
                }
            }
        }
    }
}
