package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.TypeName
import org.fujure.fbc.ast.TypeReference

class GenericTypesSpec : AbstractSemanticAnalysisSpec() { init {
    describes("Type checker") {
        it.describes("for a value typed with a parameter for a type that doesn't have any") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: String<Int> = "a"
                        """)
                        .analyzed()
            }

            it.should("report a TypeParametersMismatch error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeParametersMismatch(
                                ErrorContext.ValueDefinition("a"),
                                TypeReference.SimpleType(
                                        TypeName("String"),
                                        listOf(TypeReference.SimpleType("Int"))),
                                BuiltInTypeFamilies.String))
            }
        }

        it.describes("for a value with a type missing a type parameter") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: IO = 1
                        """)
                        .analyzed()
            }

            it.should("report a TypeParametersMismatch error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeParametersMismatch(
                                ErrorContext.ValueDefinition("a"),
                                TypeReference.SimpleType("IO"),
                                BuiltInTypeFamilies.IO))
            }
        }

        it.describes("for a value with a type with an extra type parameter") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: IO<String, Int> = IO.putStrLn("a")
                        """)
                        .analyzed()
            }

            it.should("report a TypeParametersMismatch error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeParametersMismatch(
                                ErrorContext.ValueDefinition("a"),
                                TypeReference.SimpleType(
                                        TypeName("IO"),
                                        listOf(TypeReference.SimpleType("String"), TypeReference.SimpleType("Int"))
                                ),
                                BuiltInTypeFamilies.IO))
            }
        }

        it.describes("for an unknown type used as a type parameter") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: IO<DoesNotExist> = true
                        """)
                        .analyzed()
            }

            it.should("report a TypeNotFound error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeNotFound(
                                ErrorContext.ValueDefinition("a"),
                                TypeName("DoesNotExist")))
            }
        }

        it.describes("for an unknown type used as a generic type") {
            it.beginsAll {
                AnalysisBuilder
                        .file("""
                            def a: DoesNotExist<Unit> = unit
                        """)
                        .analyzed()
            }

            it.should("report a TypeNotFound error") {
                assertThat(file1Errors()).containsExactly(
                        SemanticError.TypeNotFound(
                                ErrorContext.ValueDefinition("a"),
                                TypeName("DoesNotExist")))
            }
        }
    }
}}
