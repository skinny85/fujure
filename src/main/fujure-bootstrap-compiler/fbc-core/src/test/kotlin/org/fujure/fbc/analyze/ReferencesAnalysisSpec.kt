package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.TypeErrorContext.VariableDefinition
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueCoordinates
import org.fujure.fbc.ast.ValueReference

class ReferencesAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Reference Semantic Analysis") {
            it.describes("called with values referencing previously defined variables") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def x: Int = 42
                                def y: Bool = false
                                def a: Int = x
                                def b: Bool = File1.y
                                def u = unit
                                def v: Unit = u
                                def c: Char = '\n'
                                def d = c
                                def s = "string\t\""
                                def empty = ""
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("called with a value referencing an undefined variable") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = x
                            """)
                            .analyzed()
                }

                it.should("report an UnresolvedReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    VariableDefinition("a"),
                                    ValueReference("x")))
                }
            }

            it.describes("called with a value qualified with a file name that doesn't exist") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def x: Int = 42
                                def a: Int = DoesNotExist.x
                            """)
                            .analyzed()
                }

                it.should("report an UnresolvedReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    VariableDefinition("a"),
                                    ValueReference("DoesNotExist", "x")))
                }
            }

            it.describes("called with a value declared as Int but initialized as a reference to a type-inferred Bool value") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = true
                                def x: Int = a
                            """)
                            .analyzed()
                }

                it.should("report a TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    VariableDefinition("x"),
                                    BuiltInTypes.Int, BuiltInTypes.Bool))
                }
            }

            it.describes("called with a value declared with a non-existent type and referencing a non-existent variable") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: DoesNotExist = x
                            """)
                            .analyzed()
                }

                it.should("report both an UnresolvedReference and a TypeNotFound errors") {
                    assertThat(file1Errors()).containsOnly(
                            SemanticError.UnresolvedReference(
                                    VariableDefinition("a"),
                                    ValueReference("x")),
                            SemanticError.TypeNotFound(
                                    VariableDefinition("a"),
                                    TypeReference("DoesNotExist")))
                }
            }

            it.describes("called with values referencing previously incorrectly defined variables") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def x: Bool = 1
                                def y: a.B.C = true

                                def a: Bool = x
                                def b: Bool = y
                            """)
                            .analyzed()
                }

                it.should("take the incorrectly defined variables into account during analysis") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    VariableDefinition("x"),
                                    BuiltInTypes.Bool, BuiltInTypes.Int),
                            SemanticError.TypeNotFound(
                                    VariableDefinition("y"),
                                    TypeReference("a", "B", "C")))
                }
            }

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

                it.should("analyze the imported file correctly") {
                    assertFile1IsCorrect()
                }

                it.should("report an UnresolvedReference error for the importing file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    VariableDefinition("x"),
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

            it.describes("called with a value referencing a forward-declared variable") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = x
                                def x: Bool = true
                            """)
                            .analyzed()
                }

                it.should("report an IllegalForwardReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.IllegalForwardReference(
                                    VariableDefinition("a"), "x"))
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
                                    VariableDefinition("a"),
                                    listOf(
                                            ValueCoordinates("", "File1", "a"),
                                            ValueCoordinates("", "File2", "x"),
                                            ValueCoordinates("", "File1", "a"))))
                }

                it.should("detect the cycle in the second file") {
                    assertThat(file2Errors()).containsExactly(
                            SemanticError.CyclicDefinition(
                                    VariableDefinition("x"),
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

            it.describes("called with a value referencing itself in its initializer") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = a
                            """)
                            .analyzed()
                }

                it.should("report an IllegalSelfReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.IllegalSelfReference(VariableDefinition("a")))
                }
            }

            it.describes("called with a value referencing itself qualified with the module name in its initializer") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = File1.a
                            """)
                            .analyzed()
                }

                it.should("report an IllegalSelfReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.IllegalSelfReference(VariableDefinition("a")))
                }
            }
        }
    }
}