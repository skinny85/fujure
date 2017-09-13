package org.fujure.fbc.ast

sealed class Expr {
    data class IntLiteral(val value: Int) : Expr()

    sealed class BoolLiteral : Expr() {
        object True : BoolLiteral()
        object False : BoolLiteral()
    }
}
