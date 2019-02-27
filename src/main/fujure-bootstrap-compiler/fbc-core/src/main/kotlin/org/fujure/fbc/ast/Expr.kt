package org.fujure.fbc.ast

sealed class Expr {
    data class ValueReference(val ref: org.fujure.fbc.ast.ValueReference): Expr()

    data class IntLiteral(val value: Int) : Expr()

    object UnitLiteral : Expr()

    sealed class BoolLiteral : Expr() {
        object True : BoolLiteral()
        object False : BoolLiteral()
    }

    data class CharLiteral(val value: String) : Expr()
    data class StringLiteral(val value: String) : Expr()

    data class Disjunction(val leftDisjunct: Expr, val rightDisjunct: Expr) : Expr()
    data class Conjunction(val leftConjunct: Expr, val rightConjunct: Expr) : Expr()
    data class Negation(val operand: Expr) : Expr()

    data class Lesser(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class LesserEqual(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class Greater(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class GreaterEqual(val leftOperand: Expr, val rightOperand: Expr) : Expr()
}
