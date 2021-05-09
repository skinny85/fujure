package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.TypeName
import org.fujure.fbc.ast.ValueReference

class SingleFileReferencesAnalysisSpec : AbstractSemanticAnalysisSpec() {
    init {
        describes("Semantic Analysis of references in the same file") {
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
                                    ErrorContext.ValueDefinition("a"),
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
                                    ErrorContext.ValueDefinition("a"),
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
                                    ErrorContext.ValueDefinition("x"),
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
                                    ErrorContext.ValueDefinition("a"),
                                    ValueReference("x")),
                            SemanticError.TypeNotFound(
                                    ErrorContext.ValueDefinition("a"),
                                    TypeName("DoesNotExist")))
                }
            }

            it.describes("called with values referencing previously incorrectly defined variables") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def x: Bool = 1
                                def y: a.B.C = true
                                def z = ! 2

                                def a: String = x
                                def b: Char = y
                                def c: Int = z
                            """)
                            .analyzed()
                }

                it.should("take the incorrectly defined variables into account during analysis") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("x"),
                                    BuiltInTypes.Bool, BuiltInTypes.Int),
                            SemanticError.TypeNotFound(
                                    ErrorContext.ValueDefinition("y"),
                                    TypeName("a", "B", "C")),
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("z"),
                                    BuiltInTypes.Bool, BuiltInTypes.Int),
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("a"),
                                    BuiltInTypes.String, BuiltInTypes.Bool),
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("c"),
                                    BuiltInTypes.Int, BuiltInTypes.Bool))
                }
            }

            it.describes("called with an invalid name and referencing that invalid name in a definition of a different type") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def interface = 2

                                def c: Char = interface
                            """)
                            .analyzed()
                }

                it.should("report an InvalidName error") {
                    assertThat(file1Errors()).contains(
                            SemanticError.InvalidName("interface"))
                }

                it.should("also report a TypeMismatch error") {
                    assertThat(file1Errors()).contains(
                            SemanticError.TypeMismatch(
                                    ErrorContext.ValueDefinition("c"),
                                    BuiltInTypes.Char, BuiltInTypes.Int))
                }
            }

            it.describes("called with a value referencing a forward-declared variable") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = x
                                def x: Bool = true || false
                            """)
                            .analyzed()
                }

                it.should("report an IllegalForwardReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.IllegalForwardReference(
                                    ErrorContext.ValueDefinition("a"), "x"))
                }
            }

            it.describes("called with a value referencing itself in its initializer") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Bool = a && true
                            """)
                            .analyzed()
                }

                it.should("report an IllegalSelfReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.IllegalSelfReference(ErrorContext.ValueDefinition("a")))
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
                            SemanticError.IllegalSelfReference(ErrorContext.ValueDefinition("a")))
                }
            }

            it.describes("called with a module referencing a value of a non-existent type and without an initializer") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: DoesNotExist
                                def b = a
                            """)
                            .analyzed()
                }

                it.should("report only TypeNotFound and CannotBeAbstract errors") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeNotFound(
                                    ErrorContext.ValueDefinition("a"),
                                    TypeName("DoesNotExist")),
                            SemanticError.CannotBeAbstract(
                                    ErrorContext.ValueDefinition("a")))
                }
            }

            it.describes("called with a module referencing built-in values of the Int type") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = Int.minInt + Int.maxInt
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
