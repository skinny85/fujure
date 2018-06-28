package org.fujure.truffle

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.ExprNode
import org.fujure.truffle.nodes.IntLiteralExprNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.StringLiteralExprNode

object Ast2TruffleNodes {
    fun translate(def: Def): DefNode {
        return when (def) {
            is Def.ValueDef.SimpleValueDef -> SimpleValueDefNode(def.id, translateExpr(def.initializer))
        }
    }

    private fun translateExpr(expr: Expr): ExprNode {
        return when (expr) {
            is Expr.IntLiteral -> IntLiteralExprNode(expr.value)
            is Expr.StringLiteral -> StringLiteralExprNode(expr.value)
            else -> throw UnsupportedOperationException()
        }
    }
}
