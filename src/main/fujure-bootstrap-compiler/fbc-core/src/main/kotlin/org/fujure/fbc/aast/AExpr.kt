package org.fujure.fbc.aast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.Module

sealed class AExpr {
    abstract val type: QualifiedType

    data class AValueReference(val targetModule: Module,
            val reference: String, override val type: QualifiedType): AExpr()

    data class AIntLiteral(val value: Int) : AExpr() {
        override val type = BuiltInTypes.Int
    }

    object AUnitLiteral : AExpr() {
        override val type = BuiltInTypes.Unit
    }

    sealed class ABoolLiteral : AExpr() {
        object True : ABoolLiteral()
        object False : ABoolLiteral()

        override val type = BuiltInTypes.Bool
    }

    data class ACharLiteral(val value: String) : AExpr() {
        override val type = BuiltInTypes.Char
    }
    data class AStringLiteral(val value: String) : AExpr() {
        override val type = BuiltInTypes.String
    }

    data class AComplement(val operand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class ANegation(val operand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class APositation(val operand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class AConjunction(val leftConjunct: AExpr, val rightConjunct: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class ADisjunction(val leftDisjunct: AExpr, val rightDisjunct: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }

    data class ALesser(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class ALesserEqual(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class AGreater(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class AGreaterEqual(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }

    data class AAddition(val augend: AExpr, val addend: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class AStringConcatenation(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.String
    }
    data class ASubtraction(val minuend: AExpr, val subtrahend: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class AMultiplication(val multiplicand: AExpr, val multiplier: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class ADivision(val dividend: AExpr, val divisor: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }
    data class AModulus(val dividend: AExpr, val divisor: AExpr) : AExpr() {
        override val type = BuiltInTypes.Int
    }

    data class APrimitiveEquality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class AStringEquality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class APrimitiveInequality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }
    data class AStringInequality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr() {
        override val type = BuiltInTypes.Bool
    }

    data class ALet(val declarations: List<ADef.AValueDef>, val expr: AExpr) : AExpr() {
        override val type = expr.type
    }
    data class AIf(val conditionExpr: AExpr, val thenExpr: AExpr, val elseExpr: AExpr) : AExpr() {
        override val type = thenExpr.type
    }

    data class ACall(val function: AFunctionReference, val arguments: List<AExpr>) : AExpr() {
        override val type = function.type.returnType
    }
}

data class AFunctionReference(val targetModule: Module, val reference: String, val type: QualifiedType.FunctionType)
