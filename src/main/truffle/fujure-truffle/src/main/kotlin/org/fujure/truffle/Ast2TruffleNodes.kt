package org.fujure.truffle

import org.apache.commons.text.StringEscapeUtils
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
                    throw UnsupportedOperationException("Translating complex references like '$expr' to Truffle is not supported (yet)")
                else
                    ReferenceExprNode(expr.ref.ids[0], fujureTruffleLanguage)
            }
            is Expr.IntLiteral -> IntLiteralExprNode(expr.value)
            is Expr.StringLiteral -> StringLiteralExprNode(expr.value)
            is Expr.CharLiteral -> CharLiteralExprNode(parseCharaLiteral(expr.value))
            else -> throw UnsupportedOperationException("Translating '$expr' expressions to Truffle is not supported (yet)")
        }
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
