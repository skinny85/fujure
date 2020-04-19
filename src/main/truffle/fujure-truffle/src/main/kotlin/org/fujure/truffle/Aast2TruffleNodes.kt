package org.fujure.truffle

import com.oracle.truffle.api.frame.FrameDescriptor
import com.oracle.truffle.api.frame.FrameSlot
import org.apache.commons.text.StringEscapeUtils
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.ModuleNonRootNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.TemporarySimpleVariableDeclNode
import org.fujure.truffle.nodes.TemporaryVariableDeclNode
import org.fujure.truffle.nodes.ValueDefNode
import org.fujure.truffle.nodes.exprs.AdditionOrConcatenationExprNode
import org.fujure.truffle.nodes.exprs.BoolLiteralExprNode
import org.fujure.truffle.nodes.exprs.CallExprNode
import org.fujure.truffle.nodes.exprs.CharLiteralExprNode
import org.fujure.truffle.nodes.exprs.ComplementExprNode
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
import org.fujure.truffle.nodes.exprs.ModulusExprNode
import org.fujure.truffle.nodes.exprs.MultiplicationExprNode
import org.fujure.truffle.nodes.exprs.NegationExprNode
import org.fujure.truffle.nodes.exprs.PositationExprNode
import org.fujure.truffle.nodes.exprs.StringLiteralExprNode
import org.fujure.truffle.nodes.exprs.SubtractionExprNode
import org.fujure.truffle.nodes.exprs.TemporaryVarReferenceExprNode
import org.fujure.truffle.nodes.exprs.UnitLiteralExprNode
import org.fujure.truffle.nodes.exprs.ValueReferenceExprNode

class Aast2TruffleNodes(
        private val fujureTruffleLanguage: FujureTruffleLanguage,
        private val frameDescriptor: FrameDescriptor) {
    private var depth: Int = 0
    private val tempVars2Slots = mutableMapOf<String, FrameSlot>()

    fun translate(aFileContents: AFileContents): ModuleNonRootNode {
        return ModuleNonRootNode(aFileContents.module, aFileContents.defs.map { translateDef(it) })
    }

    private fun translateDef(aDef: ADef): DefNode {
        return when (aDef) {
            is ADef.AValueDef -> translateValueDef(aDef)
        }
    }

    private fun translateValueDef(aDef: ADef.AValueDef): ValueDefNode {
        return when (aDef) {
            is ADef.AValueDef.ASimpleValueDef ->
                SimpleValueDefNode(aDef.id, translateExpr(aDef.initializer))
            is ADef.AValueDef.AFunctionValueDef ->
                TODO()
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
            is AExpr.AComplement -> ComplementExprNode.of(translateExpr(aExpr.operand))
            is AExpr.ANegation -> NegationExprNode.of(translateExpr(aExpr.operand))
            is AExpr.APositation -> PositationExprNode.of(translateExpr(aExpr.operand))
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
                val temporaryDeclarations = aExpr.declarations.map { translateTemporaryDeclaration(it) }
                val deeperThis = this.deeperCopy()
                val expr = deeperThis.translateExpr(aExpr.expr)
                LetExprNode(temporaryDeclarations, expr)
            }
            is AExpr.ATemporaryVarReference -> {
                TemporaryVarReferenceExprNode.create(this.frameSlotFor(aExpr.variable))
            }
            is AExpr.AValueReference -> {
                ValueReferenceExprNode(aExpr.targetModule, aExpr.reference, fujureTruffleLanguage)
            }
            is AExpr.ACall -> {
                CallExprNode(
                        ValueReferenceExprNode(aExpr.function.targetModule,
                                aExpr.function.reference, fujureTruffleLanguage),
                        aExpr.arguments.map { translateExpr(it) }
                )
            }
        }
    }

    private fun translateTemporaryDeclaration(aDeclaration: ADef.AValueDef): TemporaryVariableDeclNode {
        return when (aDeclaration) {
            is ADef.AValueDef.ASimpleValueDef -> {
                val deeperThis = this.deeperCopy()
                val initializer = deeperThis.translateExpr(aDeclaration.initializer)
                val slotName = aDeclaration.id + (if (this.depth == 0) "" else this.depth)
                val frameSlot = this.frameDescriptor.findOrAddFrameSlot(slotName)
                this.tempVars2Slots[aDeclaration.id] = frameSlot
                TemporarySimpleVariableDeclNode.create(initializer, frameSlot)
            }
            is ADef.AValueDef.AFunctionValueDef -> {
                throw IllegalStateException("Local function declarations in 'let' expressions are not supported (yet) in Truffle")
            }
        }
    }

    private fun deeperCopy(): Aast2TruffleNodes {
        val ret = Aast2TruffleNodes(this.fujureTruffleLanguage, this.frameDescriptor)
        ret.depth = this.depth + 1
        ret.tempVars2Slots.putAll(this.tempVars2Slots)
        return ret
    }

    private fun frameSlotFor(id: String): FrameSlot {
        return this.tempVars2Slots[id]!!
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
