package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.ParsingResult
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit
import org.specnaz.kotlin.utils.Deferred

class SemanticAnalyzerSpec : SpecnazKotlinJUnit("SemanticAnalysis", {
    fun parseProgram(program: String): ParsedFile {
        val openedFile = OpenedFile("whatever.fjr", CharStreams.fromString(program))
        val parsingResult = BnfcParser.parse(openedFile)
        val success = assume(parsingResult).isA<ParsingResult.Success>()
        return success.parsedFile
    }

    val analyzer: SemanticAnalyzer = SimpleSemanticAnalyzer

    fun analyzeProgram(program: String): SemanticAnalysisResult {
        return analyzer.analyze(listOf(parseProgram(program)))
    }

    fun analyzedSuccess(result: SemanticAnalysisResult): AstRoot {
        val success = assume(result).isA<SemanticAnalysisResult.Success>()
        assertThat(success.analyzedProgram.asts).hasSize(1)
        return success.analyzedProgram.asts[0]
    }

    fun analyzedFailure(result: SemanticAnalysisResult): List<SemanticError> {
        val failure = assume(result).isA<SemanticAnalysisResult.Failure>()
        assertThat(failure.issues).hasSize(1)
        return failure.issues[0].errors
    }

    val result = Deferred<SemanticAnalysisResult>()

    // for analyzedSuccess
    val fileContents = Deferred<FileContents>()

    // for analyzedFailure
    val errors = Deferred<List<SemanticError>>()

    it.describes("called with an empty program") {
        it.beginsAll {
            result.v = analyzeProgram("""
                """)

            fileContents.v = analyzedSuccess(result.v).fileContents
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
            result.v = analyzeProgram("""
                package com.
                    ${'$'}example
            """)
            fileContents.v = analyzedSuccess(result.v).fileContents
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
            result.v = analyzeProgram("""
                def x = 42
                def y: Bool = false
                def a: Int = x
                def b = y
            """)

            fileContents.v = analyzedSuccess(result.v).fileContents
        }

        it.should("parse all 4 definitions correctly") {
            assertThat(fileContents.v.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("x", null, Expr.IntLiteral(42)),
                    Def.ValueDef.SimpleValueDef("y", TypeReference("Bool"), Expr.BoolLiteral.False),
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.VariableExpr("x")),
                    Def.ValueDef.SimpleValueDef("b", null, Expr.VariableExpr("y")))
        }
    }

    it.describes("called with duplicate value definition") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = true
                def a: Int = 2
            """)

            errors.v = analyzedFailure(result.v)
        }

        it.should("return a DuplicateDefinition error") {
            assertThat(errors.v).containsExactly(
                    SemanticError.DuplicateDefinition("a"))
        }
    }

    it.describes("called with a variable declared as Int but initialized as a Bool") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a: Int = false
            """)

            errors.v = analyzedFailure(result.v)
        }

        it.should("return a TypeMismatch error") {
            assertThat(errors.v).containsExactly(
                    SemanticError.TypeMismatch(
                            TypeErrorContext.VariableDefinition("a"),
                            BuiltInTypes.Int, BuiltInTypes.Bool))
        }
    }

    it.describes("called with a value referencing an undefined variable") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = x
            """)

            errors.v = analyzedFailure(result.v)
        }

        it.should("return a VariableNotFound error") {
            assertThat(errors.v).containsExactly(
                    SemanticError.VariableNotFound(TypeErrorContext.VariableDefinition("a"), "x"))
        }
    }

    it.describes("called with a value referencing a forward-declared variable") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = x
                def x = true
            """)

            errors.v = analyzedFailure(result.v)
        }

        it.should("return a VariableNotFound error") {
            assertThat(errors.v).containsExactly(
                    SemanticError.VariableNotFound(TypeErrorContext.VariableDefinition("a"), "x"))
        }
    }

    it.describes("called with values referencing previously incorrectly defined variables") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def x: Bool = 1
                def y: a.B.C = true

                def a: Int = x
                def b: Bool = y
            """)

            errors.v = analyzedFailure(result.v)
        }

        it.should("take the incorrectly defined variables into account during analysis") {
            assertThat(errors.v).containsExactly(
                    SemanticError.TypeMismatch(
                            TypeErrorContext.VariableDefinition("x"),
                            BuiltInTypes.Bool, BuiltInTypes.Int),
                    SemanticError.TypeNotFound(
                            TypeErrorContext.VariableDefinition("y"),
                            TypeReference("a", "B", "C")
                    )
            )
        }
    }
})
