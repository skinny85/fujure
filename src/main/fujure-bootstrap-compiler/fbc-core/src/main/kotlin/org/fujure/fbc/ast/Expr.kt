package org.fujure.fbc.ast

sealed class Expr {
    data class ValueReferenceExpr(val ref: ValueReference): Expr()

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
}
