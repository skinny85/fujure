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
}
