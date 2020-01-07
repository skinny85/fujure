package org.fujure.truffle

import org.apache.commons.text.StringEscapeUtils
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.LocalSimpleValueDefNode
import org.fujure.truffle.nodes.LocalValueDefNode
import org.fujure.truffle.nodes.ModuleNonRootNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.ValueDefNode
import org.fujure.truffle.nodes.exprs.AdditionOrConcatenationExprNode
import org.fujure.truffle.nodes.exprs.BoolLiteralExprNode
import org.fujure.truffle.nodes.exprs.CallExprNode
import org.fujure.truffle.nodes.exprs.CharLiteralExprNode
import org.fujure.truffle.nodes.exprs.ConjunctionExprNode
import org.fujure.truffle.nodes.exprs.DisjunctionExprNode
import org.fujure.truffle.nodes.exprs.DivisionExprNode
import org.fujure.truffle.nodes.exprs.EqualityExprNode
import org.fujure.truffle.nodes.exprs.ExprNode
import org.fujure.truffle.nodes.exprs.GreaterEqualExprNode
import org.fujure.truffle.nodes.exprs.GreaterExprNode
import org.fujure.truffle.nodes.exprs.IfExprNode
import org.fujure.truffle.nodes.exprs.InequalityExprNode
import org.fujure.truffle.nodes.exprs.IntLiteralExprNode
import org.fujure.truffle.nodes.exprs.LesserEqualExprNode
import org.fujure.truffle.nodes.exprs.LesserExprNode
import org.fujure.truffle.nodes.exprs.LetExprNode
import org.fujure.truffle.nodes.exprs.LocalReferenceExprNode
import org.fujure.truffle.nodes.exprs.ModulusExprNode
import org.fujure.truffle.nodes.exprs.MultiplicationExprNode
import org.fujure.truffle.nodes.exprs.NegationExprNode
import org.fujure.truffle.nodes.exprs.ReferenceExprNode
import org.fujure.truffle.nodes.exprs.StringLiteralExprNode
import org.fujure.truffle.nodes.exprs.SubtractionExprNode
import org.fujure.truffle.nodes.exprs.UnitLiteralExprNode

class Aast2TruffleNodes(
        private val aFileContents: AFileContents,
        private val fujureTruffleLanguage: FujureTruffleLanguage) {
    private val module = aFileContents.module

    fun translate(): ModuleNonRootNode {
        return ModuleNonRootNode(module, aFileContents.defs.map { translate(it) })
    }

    private fun translate(aDef: ADef): DefNode {
        return when (aDef) {
            is ADef.AValueDef -> translate(aDef)
        }
    }

    private fun translate(aDef: ADef.AValueDef): ValueDefNode {
        return when (aDef) {
            is ADef.AValueDef.ASimpleValueDef ->
                SimpleValueDefNode(aDef.id, translateExpr(aDef.initializer))
        }
    }

    private fun translateExpr(aExpr: AExpr): ExprNode {
        return when (aExpr) {
            is AExpr.AUnitLiteral -> UnitLiteralExprNode()
            is AExpr.ABoolLiteral -> BoolLiteralExprNode(when (aExpr) {
                is AExpr.ABoolLiteral.True -> true
                is AExpr.ABoolLiteral.False -> false
            })
            is AExpr.ACharLiteral -> CharLiteralExprNode(parseCharaLiteral(aExpr.value))
            is AExpr.AIntLiteral -> IntLiteralExprNode(aExpr.value)
            is AExpr.AStringLiteral -> StringLiteralExprNode(aExpr.value)
            is AExpr.ANegation -> NegationExprNode.of(translateExpr(aExpr.operand))
            is AExpr.ADisjunction -> DisjunctionExprNode(
                    translateExpr(aExpr.leftDisjunct),
                    translateExpr(aExpr.rightDisjunct))
            is AExpr.AConjunction -> ConjunctionExprNode(
                    translateExpr(aExpr.leftConjunct),
                    translateExpr(aExpr.rightConjunct))
            is AExpr.ALesser -> LesserExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.ALesserEqual -> LesserEqualExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AGreater -> GreaterExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AGreaterEqual -> GreaterEqualExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AAddition -> AdditionOrConcatenationExprNode.of(
                    translateExpr(aExpr.augend),
                    translateExpr(aExpr.addend))
            is AExpr.AStringConcatenation -> AdditionOrConcatenationExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.ASubtraction -> SubtractionExprNode.of(
                    translateExpr(aExpr.minuend),
                    translateExpr(aExpr.subtrahend))
            is AExpr.AMultiplication -> MultiplicationExprNode.of(
                    translateExpr(aExpr.multiplicand),
                    translateExpr(aExpr.multiplier))
            is AExpr.ADivision -> DivisionExprNode.of(
                    translateExpr(aExpr.dividend),
                    translateExpr(aExpr.divisor))
            is AExpr.AModulus -> ModulusExprNode.of(
                    translateExpr(aExpr.dividend),
                    translateExpr(aExpr.divisor))
            is AExpr.APrimitiveEquality -> EqualityExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AStringEquality -> EqualityExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.APrimitiveInequality -> InequalityExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AStringInequality -> InequalityExprNode.of(
                    translateExpr(aExpr.leftOperand),
                    translateExpr(aExpr.rightOperand))
            is AExpr.AIf -> IfExprNode(
                    translateExpr(aExpr.conditionExpr),
                    translateExpr(aExpr.thenExpr),
                    translateExpr(aExpr.elseExpr))
            is AExpr.ALet -> {
                val bindings = FujureTruffleBindings.ModuleBindings()
                val context = fujureTruffleLanguage.contextReference.get()
                context.enterNewLocalScope(bindings)

                val localValues = aExpr.declarations.map { translateLocalDeclaration(it, bindings) }

                val expr = translateExpr(aExpr.expr)

                context.leaveLatestLocalScope()

                LetExprNode(localValues, expr)
            }
            is AExpr.AValueReference -> {
                if (aExpr.targetModule == module) {
                    val localFind = fujureTruffleLanguage.contextReference.get().findInLocalScopes(aExpr.reference)
                    when (localFind) {
                        is FujureTruffleContext.LocalSearchResult.Hit -> {
                            LocalReferenceExprNode(aExpr.reference, localFind.bindings)
                        }
                        is FujureTruffleContext.LocalSearchResult.Miss -> {
                            ReferenceExprNode(aExpr.targetModule, aExpr.reference, fujureTruffleLanguage)
                        }
                    }
                } else {
                    ReferenceExprNode(aExpr.targetModule, aExpr.reference, fujureTruffleLanguage)
                }
            }
            is AExpr.ACall -> {
                CallExprNode(
                        ReferenceExprNode(aExpr.function.targetModule, aExpr.function.reference, fujureTruffleLanguage),
                        aExpr.arguments.map { translateExpr(it) }
                )
            }
        }
    }

    private fun translateLocalDeclaration(aDeclaration: ADef.AValueDef,
            bindings: FujureTruffleBindings.ModuleBindings): LocalValueDefNode {
        return when (aDeclaration) {
            is ADef.AValueDef.ASimpleValueDef -> {
                val initializer = translateExpr(aDeclaration.initializer)
                bindings.reserve(aDeclaration.id)
                LocalSimpleValueDefNode(aDeclaration.id, bindings, initializer)
            }
        }
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
