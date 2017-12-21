package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

class CrossFileReferencesAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Cross-file Semantic Analysis") {
            it.describes("called with a module referencing a value from another module in the default package") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = 42
                            """)
                            .file("""
                                def x: Int = File1.a
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with a module referencing a value from a module from another package without an import") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                def a: Int = 42
                            """)
                            .file("""
                                package com.example.inner

                                def x: Int = File1.a
                            """)
                            .analyzed()
                }

                it.should("fail") {
                    assertAnalysisFailed()
                }

                it.should("analyze the imported file correctly") {
                    assertFile1IsCorrect()
                }

                it.should("report an UnresolvedReference error for the importing file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    TypeErrorContext.VariableDefinition("x"),
                                    ValueReference("File1", "a")))
                }
            }

            it.describes("called with a module referencing a value from a forward module, both in the default package") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = File2.x
                            """)
                            .file("""
                                def x: Int = 42
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with a program referencing a value from a forward file with an inferred type") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = File2.x
                            """)
                            .file("""
                                def x = 42
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with a cycle of 2 values without declared types") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = File2.x
                            """)
                            .file("""
                                def x = File1.a
                            """)
                            .analyzed()
                }

                it.should("fail") {
                    assertAnalysisFailed()
                }

                it.should("detect the cycle in the first file") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    TypeErrorContext.VariableDefinition("a"),
                                    listOf(
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"))))
                }

                it.should("detect the cycle in the second file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    TypeErrorContext.VariableDefinition("x"),
                                    listOf(
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"))))
                }
            }

            it.describes("called with a cycle of 2 values in which one has a declared type") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = File2.x
                            """)
                            .file("""
                                def x = File1.a
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }
        }
    }
}
