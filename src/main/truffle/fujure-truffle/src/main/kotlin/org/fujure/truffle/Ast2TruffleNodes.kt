package org.fujure.truffle

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.truffle.nodes.CharLiteralExprNode
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.ExprNode
import org.fujure.truffle.nodes.IntLiteralExprNode
import org.fujure.truffle.nodes.ReferenceExprNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.StringLiteralExprNode

object Ast2TruffleNodes {
    fun translate(def: Def, fujureTruffleLanguage: FujureTruffleLanguage): DefNode {
        return when (def) {
            is Def.ValueDef.SimpleValueDef -> SimpleValueDefNode(def.id, translateExpr(def.initializer, fujureTruffleLanguage))
        }
    }

    private fun translateExpr(expr: Expr, fujureTruffleLanguage: FujureTruffleLanguage): ExprNode {
        return when (expr) {
            is Expr.ValueReferenceExpr -> {
                if (expr.ref.size != 1)
                    throw UnsupportedOperationException()
                else
                    ReferenceExprNode(expr.ref.ids[0], fujureTruffleLanguage)
            }
            is Expr.IntLiteral -> IntLiteralExprNode(expr.value)
            is Expr.StringLiteral -> StringLiteralExprNode(expr.value)
            is Expr.CharLiteral -> CharLiteralExprNode(expr.value)
            else -> throw UnsupportedOperationException()
        }
    }
}
