package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.ErrorContext.ValueDefinition
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference

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

                it.should("report one 'expecting String, got Char' TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.String, BuiltInTypes.Char))
                }
            }

            it.describes("when adding an Int to a String") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = "a" + 3
                            """)
                            .analyzed()
                }

                it.should("report one 'expecting Int, got String' TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }

            it.describes("when adding a Char to a Bool") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = true + 'a'
                            """)
                            .analyzed()
                }

                it.should("report 2 TypeMismatch errors") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Bool),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Char))
                }
            }

            it.describes("comparing a Char to a String") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = 'a' == "a"
                            """)
                            .analyzed()
                }

                it.should("report that it expected Char but got String") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Char, BuiltInTypes.String))
                }
            }

            it.describes("negating a Char") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = -'a'
                            """)
                            .analyzed()
                }

                it.should("report that it expected Int but got Char") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.Char))
                }
            }

            it.describes("positing a String") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = +"a"
                            """)
                            .analyzed()
                }

                it.should("report that it expected Int but got String") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }

            it.describes("using nonexistent types in the declaration of a function type") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: A -> Int -> B = 3
                            """)
                            .analyzed()
                }

                it.should("first report the error for the argument type, and then the return type") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeNotFound(
                                    ValueDefinition("a"),
                                    TypeReference.SimpleType("A")),
                            SemanticError.TypeNotFound(
                                    ValueDefinition("a"),
                                    TypeReference.SimpleType("B")))
                }
            }

            it.describes("called with an invalid expression, but whose type can nevertheless be determined") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: String = b * c
                            """)
                            .analyzed()
                }

                it.should("use the type information from the incorrect expression") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    ValueDefinition("a"),
                                    ValueReference("b")),
                            SemanticError.UnresolvedReference(
                                    ValueDefinition("a"),
                                    ValueReference("c")),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.String, BuiltInTypes.Int))
                }
            }
        }
    }
}
