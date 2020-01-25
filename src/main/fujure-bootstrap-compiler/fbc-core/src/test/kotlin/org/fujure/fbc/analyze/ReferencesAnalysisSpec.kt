package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.ErrorContext.ValueDefinition
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
                                    ValueDefinition("a"),
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
                                    ValueDefinition("a"),
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
                                    ValueDefinition("x"),
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
                                    ValueDefinition("a"),
                                    ValueReference("x")),
                            SemanticError.TypeNotFound(
                                    ValueDefinition("a"),
                                    TypeReference.SimpleType("DoesNotExist")))
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
                                    ValueDefinition("x"),
                                    BuiltInTypes.Bool, BuiltInTypes.Int),
                            SemanticError.TypeNotFound(
                                    ValueDefinition("y"),
                                    TypeReference.SimpleType("a", "B", "C")),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("z"),
                                    BuiltInTypes.Bool, BuiltInTypes.Int),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.String, BuiltInTypes.Bool),
                            SemanticError.TypeMismatch(
                                    ValueDefinition("c"),
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
                                    ValueDefinition("c"),
                                    BuiltInTypes.Char, BuiltInTypes.Int))
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
                                    ValueDefinition("a"), "x"))
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
                            SemanticError.IllegalSelfReference(ValueDefinition("a")))
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
                            SemanticError.IllegalSelfReference(ValueDefinition("a")))
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
                                    ValueDefinition("a"),
                                    TypeReference.SimpleType("DoesNotExist")),
                            SemanticError.CannotBeAbstract(
                                    ValueDefinition("a")))
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

            it.describes("when calling a built-in function of the Int module") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a: Int = Int.abs(11)
                            """)
                            .analyzed()
                }

                it.should("succeed") {
                    assertAnalysisSucceeded()
                }
            }

            it.describes("when calling a function with too many arguments") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs(11, "11")
                                def b: Int = a
                            """)
                            .analyzed()
                }

                it.should("report an ArgumentCountMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.ArgumentCountMismatch(
                                    ValueDefinition("a"),
                                    1, 2))
                }
            }

            it.describes("when calling a one-argument function with a String instead of the correct Int") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs("11")
                                def b: Int = a
                            """)
                            .analyzed()
                }

                it.should("report a TypeMismatch error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.TypeMismatch(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int, BuiltInTypes.String))
                }
            }

            it.describes("when calling a function that does not exist") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.doesNotExist("11")
                            """)
                            .analyzed()
                }

                it.should("report an UnresolvedReference error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.UnresolvedReference(
                                    ValueDefinition("a"),
                                    ValueReference("Int", "doesNotExist")))
                }
            }

            it.describes("when calling a reference that is not a function") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.maxInt("11")
                            """)
                            .analyzed()
                }

                it.should("report a NotInvokable error") {
                    assertThat(file1Errors()).containsExactly(
                            SemanticError.NotInvokable(
                                    ValueDefinition("a"),
                                    BuiltInTypes.Int))
                }
            }

            it.describes("when assigning a function to a value, and then calling that value") {
                it.beginsAll {
                    AnalysisBuilder
                            .file("""
                                def a = Int.abs
                                def b: Int = a(3)
                                def c: Int -> Int = a
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
