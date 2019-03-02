package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.ErrorContext.ValueDefinition

class BaseCasesAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Base cases Semantic Analysis") {
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

            it.describes("called with duplicate value definitions") {
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

            it.describes("called with a variable declared as Int but initialized as Bool") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = false
                            """)
                            .analyzed()
                }

                it.should("report a TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Bool))
                }
            }

            it.describes("when comparing a Char and a String with the 'less' operator") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = 'a' < "a"
                            """)
                            .analyzed()
                }

                it.should("report 2 TypeMismatch errors") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Char),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }

            it.describes("when adding a String to a Char") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = 'a' + "a"
                            """)
                            .analyzed()
                }

                it.should("report 2 TypeMismatch errors") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Char),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }
        }
    }
}
