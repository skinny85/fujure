package org.fujure.fbc.aast

import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.Module

sealed class AExpr {
    data class AValueReference(val targetModule: Module,
            val reference: String, val type: QualifiedType): AExpr()

    data class AIntLiteral(val value: Int) : AExpr()

    object AUnitLiteral : AExpr()

    sealed class ABoolLiteral : AExpr() {
        object True : ABoolLiteral()
        object False : ABoolLiteral()
    }

    data class ACharLiteral(val value: String) : AExpr()
    data class AStringLiteral(val value: String) : AExpr()

    data class ANegation(val operand: AExpr) : AExpr()
    data class AConjunction(val leftConjunct: AExpr, val rightConjunct: AExpr) : AExpr()
    data class ADisjunction(val leftDisjunct: AExpr, val rightDisjunct: AExpr) : AExpr()

    data class ALesser(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class ALesserEqual(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class AGreater(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class AGreaterEqual(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()

    data class AAddition(val augend: AExpr, val addend: AExpr) : AExpr()
    data class AStringConcatenation(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class ASubtraction(val minuend: AExpr, val subtrahend: AExpr) : AExpr()
    data class AMultiplication(val multiplicand: AExpr, val multiplier: AExpr) : AExpr()
    data class ADivision(val dividend: AExpr, val divisor: AExpr) : AExpr()
    data class AModulus(val dividend: AExpr, val divisor: AExpr) : AExpr()

    data class APrimitiveEquality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class AStringEquality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class APrimitiveInequality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
    data class AStringInequality(val leftOperand: AExpr, val rightOperand: AExpr) : AExpr()
}
