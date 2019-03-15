package org.fujure.truffle

import org.apache.commons.text.StringEscapeUtils
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.truffle.nodes.AdditionOrConcatenationExprNode
import org.fujure.truffle.nodes.BoolLiteralExprNode
import org.fujure.truffle.nodes.CharLiteralExprNode
import org.fujure.truffle.nodes.ConjunctionExprNode
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.DisjunctionExprNode
import org.fujure.truffle.nodes.DivisionExprNode
import org.fujure.truffle.nodes.EqualityExprNode
import org.fujure.truffle.nodes.ExprNode
import org.fujure.truffle.nodes.GreaterEqualExprNode
import org.fujure.truffle.nodes.GreaterExprNode
import org.fujure.truffle.nodes.InequalityExprNode
import org.fujure.truffle.nodes.IntLiteralExprNode
import org.fujure.truffle.nodes.LesserEqualExprNode
import org.fujure.truffle.nodes.LesserExprNode
import org.fujure.truffle.nodes.ModuleNonRootNode
import org.fujure.truffle.nodes.ModulusExprNode
import org.fujure.truffle.nodes.MultiplicationExprNode
import org.fujure.truffle.nodes.NegationExprNode
import org.fujure.truffle.nodes.ReferenceExprNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.StringLiteralExprNode
import org.fujure.truffle.nodes.SubtractionExprNode
import org.fujure.truffle.nodes.UnitLiteralExprNode

object Aast2TruffleNodes {
    fun translate(annotatedAst: AFileContents, fujureTruffleLanguage: FujureTruffleLanguage): ModuleNonRootNode {
        return ModuleNonRootNode(annotatedAst.module,
                annotatedAst.defs.map { translate(it, fujureTruffleLanguage) })
    }

    private fun translate(aDef: ADef, fujureTruffleLanguage: FujureTruffleLanguage): DefNode {
        return when (aDef) {
            is ADef.AValueDef.ASimpleValueDef -> SimpleValueDefNode(
                    aDef.id, translateExpr(aDef.initializer, fujureTruffleLanguage))
        }
    }

    private fun translateExpr(aExpr: AExpr, fujureTruffleLanguage: FujureTruffleLanguage): ExprNode {
        return when (aExpr) {
            is AExpr.AUnitLiteral -> UnitLiteralExprNode()
            is AExpr.ABoolLiteral -> BoolLiteralExprNode(when (aExpr) {
                is AExpr.ABoolLiteral.True -> true
                is AExpr.ABoolLiteral.False -> false
            })
            is AExpr.ACharLiteral -> CharLiteralExprNode(parseCharaLiteral(aExpr.value))
            is AExpr.AIntLiteral -> IntLiteralExprNode(aExpr.value)
            is AExpr.AStringLiteral -> StringLiteralExprNode(aExpr.value)
            is AExpr.AValueReference -> ReferenceExprNode(aExpr.targetModule, aExpr.reference, fujureTruffleLanguage)
            is AExpr.ANegation -> NegationExprNode.of(translateExpr(aExpr.operand, fujureTruffleLanguage))
            is AExpr.ADisjunction -> DisjunctionExprNode(
                    translateExpr(aExpr.leftDisjunct, fujureTruffleLanguage),
                    translateExpr(aExpr.rightDisjunct, fujureTruffleLanguage))
            is AExpr.AConjunction -> ConjunctionExprNode(
                    translateExpr(aExpr.leftConjunct, fujureTruffleLanguage),
                    translateExpr(aExpr.rightConjunct, fujureTruffleLanguage))
            is AExpr.ALesser -> LesserExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.ALesserEqual -> LesserEqualExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.AGreater -> GreaterExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.AGreaterEqual -> GreaterEqualExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.AAddition -> AdditionOrConcatenationExprNode.of(
                    translateExpr(aExpr.augend, fujureTruffleLanguage),
                    translateExpr(aExpr.addend, fujureTruffleLanguage))
            is AExpr.AStringConcatenation -> AdditionOrConcatenationExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.ASubtraction -> SubtractionExprNode.of(
                    translateExpr(aExpr.minuend, fujureTruffleLanguage),
                    translateExpr(aExpr.subtrahend, fujureTruffleLanguage))
            is AExpr.AMultiplication -> MultiplicationExprNode.of(
                    translateExpr(aExpr.multiplicand, fujureTruffleLanguage),
                    translateExpr(aExpr.multiplier, fujureTruffleLanguage))
            is AExpr.ADivision -> DivisionExprNode.of(
                    translateExpr(aExpr.dividend, fujureTruffleLanguage),
                    translateExpr(aExpr.divisor, fujureTruffleLanguage))
            is AExpr.AModulus -> ModulusExprNode.of(
                    translateExpr(aExpr.dividend, fujureTruffleLanguage),
                    translateExpr(aExpr.divisor, fujureTruffleLanguage))
            is AExpr.APrimitiveEquality -> EqualityExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.AStringEquality -> EqualityExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.APrimitiveInequality -> InequalityExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
            is AExpr.AStringInequality -> InequalityExprNode.of(
                    translateExpr(aExpr.leftOperand, fujureTruffleLanguage),
                    translateExpr(aExpr.rightOperand, fujureTruffleLanguage))
        }
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
