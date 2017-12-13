package org.fujure.fbc.analyze

import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.analyze.TypeErrorContext.VariableDefinition
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.Import
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.ast.ValueReference
import org.fujure.test.utils.Assumption.Companion.assume
import org.funktionale.either.Disjunction
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class SingleFileSemanticAnalysisSpec : SpecnazKotlinJUnit("Single file Semantic Analysis", {
    // for analyzeProgramSuccessfully
    lateinit var fileContents: FileContents

    fun analyzeProgramSuccessfully(program: String) {
        val analysisResult = AnalysisHelper.analyzeProgram(program)
        val success = assume(analysisResult).isA<Disjunction.Right<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram>>()
        assertThat(success.value.asts).hasSize(1)
        fileContents = success.value.asts[0].fileContents
    }

    // for analyzeProgramExpectingErrors
    lateinit var errors: List<SemanticError>

    fun analyzeProgramExpectingErrors(program: String) {
        val analysisResult = AnalysisHelper.analyzeProgram(program)
        val failure = assume(analysisResult).isA<Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram>>()
        assertThat(failure.value).hasSize(1)
        errors = failure.value[0].errors
    }

    it.describes("called with an empty program") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
            """)
        }

        it.should("parse an empty package name") {
            assertThat(fileContents.packageName).isEmpty()
        }

        it.should("parse an empty list of definitions") {
            assertThat(fileContents.defs).isEmpty()
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
            assertThat(fileContents.packageName).isEqualTo("com.\$example")
        }

        it.should("parse an empty list of definitions") {
            assertThat(fileContents.defs).isEmpty()
        }
    }

    it.describes("called with a definition using type inference") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                def a = 42
                def x = a
            """)
        }

        it.should("should analyze all definitions correctly") {
            assertThat(fileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", null, Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef("x", null, Expr.ValueReferenceExpr(ValueReference("a"))))
        }
    }

    it.describes("called with invalid value names") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def _: Bool = true
                def ${'$'}a: Int = 2
                def class = 3
            """)
        }

        it.should("return an InvalidName error for each of them") {
            assertThat(errors).containsExactly(
                    SemanticError.InvalidName("_"),
                    SemanticError.InvalidName("\$a"),
                    SemanticError.InvalidName("class"))
        }
    }

    it.describes("called with values referencing previously defined variables") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                def x: Int = 42
                def y: Bool = false
                def a: Int = x
                def b: Bool = y
                def u = unit
                def v: Unit = u
                def c: Char = '\n'
                def d = c
                def s = "string\t\""
                def empty = ""
            """)
        }

        it.should("parse all 10 definitions correctly") {
            assertThat(fileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef("y", TypeReference("Bool"), Expr.BoolLiteral.False),
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.ValueReferenceExpr(ValueReference("x"))),
                    Def.ValueDef.SimpleValueDef("b", TypeReference("Bool"), Expr.ValueReferenceExpr(ValueReference("y"))),
                    Def.ValueDef.SimpleValueDef("u", null, Expr.UnitLiteral),
                    Def.ValueDef.SimpleValueDef("v", TypeReference("Unit"), Expr.ValueReferenceExpr(ValueReference("u"))),
                    Def.ValueDef.SimpleValueDef("c", TypeReference("Char"), Expr.CharLiteral("'\\n'")),
                    Def.ValueDef.SimpleValueDef("d", null, Expr.ValueReferenceExpr(ValueReference("c"))),
                    Def.ValueDef.SimpleValueDef("s", null, Expr.StringLiteral("string\\t\\\"")),
                    Def.ValueDef.SimpleValueDef("empty", null, Expr.StringLiteral("")))
        }
    }

    it.describes("called with duplicate value definition") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Bool = true
                def a: Int = 2
            """)
        }

        it.should("return a DuplicateDefinition error") {
            assertThat(errors).containsExactly(
                    SemanticError.DuplicateDefinition("a"))
        }
    }

    it.describes("called with a variable declared as Int but initialized as Bool") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Int = false
            """)
        }

        it.should("return a TypeMismatch error") {
            assertThat(errors).containsExactly(
                    SemanticError.TypeMismatch(
                            VariableDefinition("a"),
                            BuiltInTypes.Int, BuiltInTypes.Bool))
        }
    }

    it.describes("called with a variable declared as Int but initialized as Bool with a type-inferred value") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a = true
                def x: Int = a
            """)
        }

        it.should("return a TypeMismatch error") {
            assertThat(errors).containsExactly(
                    SemanticError.TypeMismatch(
                            VariableDefinition("x"),
                            BuiltInTypes.Int, BuiltInTypes.Bool))
        }
    }

    it.describes("called with a value referencing an undefined variable") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Int = x
            """)
        }

        it.should("return a UnresolvedReference error") {
            assertThat(errors).containsExactly(
                    SemanticError.UnresolvedReference(
                            VariableDefinition("a"),
                            ValueReference("x")))
        }
    }

    it.describes("called with a value declared with a non-existent type and referencing a non-existent variable") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: DoesNotExist = x
            """)
        }

        it.should("return both a UnresolvedReference and a TypeNotFound errors") {
            assertThat(errors).containsOnly(
                    SemanticError.UnresolvedReference(
                            VariableDefinition("a"),
                            ValueReference("x")),
                    SemanticError.TypeNotFound(
                            VariableDefinition("a"),
                            TypeReference("DoesNotExist")))
        }
    }

    it.describes("called with a value referencing a forward-declared variable") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Bool = x
                def x: Bool = true
            """)
        }

        it.should("return an IllegalForwardReference error") {
            assertThat(errors).containsExactly(
                    SemanticError.IllegalForwardReference(
                            VariableDefinition("a"), "x"))
        }
    }

    it.describes("called with a value referencing itself in its initializer") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Bool = a
            """)
        }

        it.should("return an IllegalSelfReference error") {
            assertThat(errors).containsExactly(
                    SemanticError.IllegalSelfReference(VariableDefinition("a")))
        }
    }

    it.describes("called with a value referencing itself qualified with the module name in its initializer") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def a: Bool = File1.a
            """)
        }

        it.should("return an IllegalSelfReference error") {
            assertThat(errors).containsExactly(
                    SemanticError.IllegalSelfReference(VariableDefinition("a")))
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
            assertThat(errors).containsExactly(
                    SemanticError.TypeMismatch(
                            VariableDefinition("x"),
                            BuiltInTypes.Bool, BuiltInTypes.Int),
                    SemanticError.TypeNotFound(
                            VariableDefinition("y"),
                            TypeReference("a", "B", "C")))
        }
    }

    it.describes("called with value referencing a previous value qualified with the file name") {
        it.beginsAll {
            analyzeProgramSuccessfully("""
                def x: Int = 42
                def a: Int = File1.x
            """)
        }

        it.should("parse all definitions correctly") {
            assertThat(fileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", TypeReference("Int"), Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef(
                            "a",
                            TypeReference("Int"),
                            Expr.ValueReferenceExpr(ValueReference("File1", "x"))))
        }
    }

    it.describes("called with a value reference qualified with a file name that doesn't exist") {
        it.beginsAll {
            analyzeProgramExpectingErrors("""
                def x: Int = 42
                def a: Int = DoesNotExist.x
            """)
        }

        it.should("return an UnresolvedReference error") {
            assertThat(errors).containsExactly(
                    SemanticError.UnresolvedReference(
                            VariableDefinition("a"),
                            ValueReference("DoesNotExist", "x")))
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
            assertThat(fileContents.imports).containsExactly(
                    Import("a", "b", "c"),
                    Import("d", "e", "f"))
        }
    }
})
