package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions.assertThat
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
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

    it.describes("called with an empty program") {
        it.beginsAll {
            result.v = analyzeProgram("""
                """)
        }

        it.should("parse an empty package name") {
            val astRoot = analyzedSuccess(result.v)

            assertThat(astRoot.fileContents.packageName).isEmpty()
        }
    }

    it.describes("called with just a package name") {
        it.beginsAll {
            result.v = analyzeProgram("""
                package com.
                    ${'$'}example
            """)
        }

        it.should("parse the package name") {
            val astRoot = analyzedSuccess(result.v)

            assertThat(astRoot.fileContents.packageName).isEqualTo("com.\$example")
        }
    }

    it.describes("called with one simple value definition without a declared type") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = 42
            """)
        }

        it.should("parse the one definition") {
            val fileContents = analyzedSuccess(result.v).fileContents

            assertThat(fileContents.defs).hasSize(1)
            val def = fileContents.defs[0]

            val simpleValueDef = assume(def).isA<Def.ValueDef.SimpleValueDef>()
            assertThat(simpleValueDef.id).isEqualTo("a")
            assertThat(simpleValueDef.declaredType).isNull()
            assertThat(simpleValueDef.initializer).isEqualTo(Expr.IntLiteral(42))
        }
    }

    it.describes("called with one simple value definition with a declared type") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a: Int = 42
            """)
        }

        it.should("parse the one definition") {
            val fileContents = analyzedSuccess(result.v).fileContents

            assertThat(fileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", TypeReference("Int"), Expr.IntLiteral(42)))
        }
    }

    it.describes("called with duplicate value definition") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = 1
                def a: Int = 2
            """)
        }

        it.should("return a DuplicateDefinition error") {
            val errors = analyzedFailure(result.v)

            assertThat(errors).containsExactly(
                    SemanticError.DuplicateDefinition("a"))
        }
    }

    it.describes("called with a variable of an unknown type") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a: DoesNotExist = 1
            """)
        }

        it.should("return a TypeNotFound error") {
            val errors = analyzedFailure(result.v)

            assertThat(errors).containsExactly(
                    SemanticError.TypeNotFound(
                            TypeErrorContext.VariableDefinition("a"),
                            TypeReference("DoesNotExist")))
        }
    }

    it.describes("called with a variable declared as Bool but initialized as an Int") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a: Bool = 1
            """)
        }

        it.should("return a TypeMismatch error") {
            val errors = analyzedFailure(result.v)

            assertThat(errors).containsExactly(
                    SemanticError.TypeMismatch(
                            TypeErrorContext.VariableDefinition("a"),
                            BuiltInTypes.Bool, BuiltInTypes.Int))
        }
    }

    it.describes("called with 2 simple Boolean value definitions") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a = true
                def b: Bool = false
            """)
        }

        it.should("parse the one definition") {
            val fileContents = analyzedSuccess(result.v).fileContents

            assertThat(fileContents.defs).containsExactly(
                    Def.ValueDef.SimpleValueDef("a", null, Expr.BoolLiteral.True),
                    Def.ValueDef.SimpleValueDef("b", TypeReference("Bool"), Expr.BoolLiteral.False))
        }
    }

    it.describes("called with a variable declared as Int but initialized as a Bool") {
        it.beginsAll {
            result.v = analyzeProgram("""
                def a: Int = false
            """)
        }

        it.should("return a TypeMismatch error") {
            val errors = analyzedFailure(result.v)

            assertThat(errors).containsExactly(
                    SemanticError.TypeMismatch(
                            TypeErrorContext.VariableDefinition("a"),
                            BuiltInTypes.Int, BuiltInTypes.Bool))
        }
    }
})
