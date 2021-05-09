package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.ErrorContext.ValueDefinition
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

class MultiFileReferencesAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Semantic Analysis of references between different files") {
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

                it.should("analyze the referenced file correctly") {
                    assertFile1IsCorrect()
                }

                it.should("report an UnresolvedReference error for the referencing file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    ValueDefinition("x"),
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

                it.should("detect the cycle in the first file") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    ValueDefinition("a"),
                                    listOf(
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"))))
                }

                it.should("detect the cycle in the second file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    ValueDefinition("x"),
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

            it.describes("called with a definition containing multiple cycles") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = File2.x || File2.y
                            """)
                            .file("""
                                def x = File1.a
                                def y = File1.a
                            """)
                            .analyzed()
                }

                it.should("detect all cycles in the first file") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    ValueDefinition("a"),
                                    listOf(
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"))),
                            SemanticError.CyclicDefinition(
                                    ValueDefinition("a"),
                                    listOf(
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "y"),
                                            ValueCoordinates("", "File1", "a"))))
                }

                it.should("detect all cycles in the second file") {
                    assertThat(file2Errors()).hasSize(2)

                    assertThat(file2Errors()[0]).isEqualTo(
                            SemanticError.CyclicDefinition(
                                    ValueDefinition("x"),
                                    listOf(
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"))))

                    val yCycle = file2Errors()[1]
                    assertThat(yCycle).isInstanceOf(SemanticError.CyclicDefinition::class.java)
                    yCycle as SemanticError.CyclicDefinition
                    assertThat(yCycle.context).isEqualTo(ValueDefinition("y"))
                    assertThat(yCycle.cycle.size).isGreaterThan(1)
                    assertThat(yCycle.cycle[0]).isEqualTo(ValueCoordinates("", "File2", "y"))
                }
            }

            it.describes("called with a module referencing a value from another module, " +
                    "both in the same non-default package, analyzed incrementally") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                package com.example

                                def a = 42
                            """)
                            .file("""
                                package com.example

                                def x: Int = File1.a
                            """)
                            .file("""
                                package com.example

                                def i1: Int = File2.x
                                def i2: Int = File1.a
                            """)
                            .incrementallyAnalyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }
        }
    }
}
