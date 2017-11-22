package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.analyze.ConstructContext.VariableDefinition
import org.fujure.fbc.analyze.SemanticError.ConstructLevelError
import org.fujure.fbc.analyze.SemanticError.ModuleLevelError
import org.fujure.fbc.analyze.SemanticProblem.ConstructLevelProblem.*
import org.fujure.fbc.analyze.SemanticProblem.ModuleLevelProblem.DuplicateDefinition
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class SingleFileSemanticAnalysisSpec : SpecnazKotlinJUnit("Single file Semantic Analysis", {
    // for analyzeProgramSuccessfully
    val fileContents = Deferred<FileContents>()

    fun analyzeProgramSuccessfully(program: String) {
        val analysisResult = AnalysisHelper.analyzeProgram(program)
        val success = assume(analysisResult).isA<SemanticAnalysisResult.Success>()
        assertThat(success.analyzedProgram.asts).hasSize(1)
        fileContents.v = success.analyzedProgram.asts[0].fileContents
    }

    // for analyzeProgramExpectingErrors
    val errors = Deferred<List<SemanticError>>()

    fun analyzeProgramExpectingErrors(program: String) {
        val analysisResult = AnalysisHelper.analyzeProgram(program)
        val failure = assume(analysisResult).isA<SemanticAnalysisResult.Failure>()
        assertThat(failure.issues).hasSize(1)
        errors.v = failure.issues[0].errors
    }

    it.describes("called with an empty program") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
            """)
        }

        it.should("parse an empty package name") {
            assertThat(fileContents.v.packageName).isEmpty()
        }

        it.should("parse an empty list of definitions") {
            assertThat(fileContents.v.defs).isEmpty()
        }
    }

    it.describes("called with just a package name") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                package com.
                    ${'$'}example
            """)
        }

        it.should("parse the package name") {
            assertThat(fileContents.v.packageName).isEqualTo("com.\$example")
        }

        it.should("parse an empty list of definitions") {
            assertThat(fileContents.v.defs).isEmpty()
        }
    }

    it.describes("called with values referencing previously defined variables") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                def x = 42
                def y: Bool = false
                def a: Int = x
                def b = y
            """)
        }

        it.should("parse all 4 definitions correctly") {
            assertThat(fileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", null, Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef("y", TypeReference("Bool"), Expr.BoolLiteral.False),
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.ValueReferenceExpr(ValueReference("x"))),
                    Def.ValueDef.SimpleValueDef("b", null, Expr.ValueReferenceExpr(ValueReference("y"))))
        }
    }

    it.describes("called with duplicate value definition") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a = true
                def a: Int = 2
            """)
        }

        it.should("return a DuplicateDefinition error") {
            assertThat(errors.v).containsExactly(
                    ModuleLevelError(DuplicateDefinition("a")))
        }
    }

    it.describes("called with a variable declared as Int but initialized as Bool") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Int = false
            """)
        }

        it.should("return a TypeMismatch error") {
            assertThat(errors.v).containsExactly(
                    ConstructLevelError(
                            VariableDefinition("a"),
                            TypeMismatch(BuiltInTypes.Int, BuiltInTypes.Bool)))
        }
    }

    it.describes("called with a value referencing an undefined variable") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a = x
            """)
        }

        it.should("return an UnresolvedReference error") {
            assertThat(errors.v).containsExactly(
                    ConstructLevelError(
                            VariableDefinition("a"),
                            UnresolvedReference(ValueReference("x"))))
        }
    }

    it.describes("called with a value referencing a forward-declared variable") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a = x
                def x = true
            """)
        }

        it.should("return an UnresolvedReference error") {
            assertThat(errors.v).containsExactly(
                    ConstructLevelError(
                            VariableDefinition("a"),
                            UnresolvedReference(ValueReference("x"))))
        }
    }

    it.describes("called with values referencing previously incorrectly defined variables") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def x: Bool = 1
                def y: a.B.C = true

                def a: Bool = x
                def b: Bool = y
            """)
        }

        it.should("take the incorrectly defined variables into account during analysis") {
            assertThat(errors.v).containsExactly(
                    ConstructLevelError(
                            VariableDefinition("x"),
                            TypeMismatch(BuiltInTypes.Bool, BuiltInTypes.Int)),
                    ConstructLevelError(
                            VariableDefinition("y"),
                            TypeNotFound(TypeReference("a", "B", "C"))))
        }
    }

    it.describes("called with value referencing a previous value qualified with the file name") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                def x = 42
                def a: Int = File1.x
            """)
        }

        it.should("parse all definitions correctly") {
            assertThat(fileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", null, Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef(
                            "a",
                            TypeReference("Int"),
                            Expr.ValueReferenceExpr(ValueReference("File1", "x"))))
        }
    }

    it.describes("called with a value reference qualified with the file name") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def x = 42
                def a: Int = DoesNotExist.x
            """)
        }

        it.should("return an UnresolvedReference error") {
            assertThat(errors.v).containsExactly(
                    SemanticError.ConstructLevelError(
                            VariableDefinition("a"),
                            UnresolvedReference(ValueReference("DoesNotExist", "x"))))
        }
    }

    it.describes("called with an import statement") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                import a.b.c
                import d.e.
                  f
            """)
        }

        it.should("parse all import statements correctly") {
            assertThat(fileContents.v.imports).containsExactly(
                    Import("a", "b", "c"),
                    Import("d", "e", "f"))
        }
    }
})
