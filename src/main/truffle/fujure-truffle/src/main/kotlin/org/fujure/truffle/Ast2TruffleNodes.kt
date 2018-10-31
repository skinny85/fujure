package org.fujure.truffle

import org.apache.commons.text.StringEscapeUtils
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.truffle.nodes.BoolLiteralExprNode
import org.fujure.truffle.nodes.CharLiteralExprNode
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.ExprNode
import org.fujure.truffle.nodes.IntLiteralExprNode
import org.fujure.truffle.nodes.ReferenceExprNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.StringLiteralExprNode
import org.fujure.truffle.nodes.UnitLiteralExprNode

object Ast2TruffleNodes {
    fun translate(def: Def, fujureTruffleLanguage: FujureTruffleLanguage): DefNode {
        return when (def) {
            is Def.ValueDef.SimpleValueDef -> SimpleValueDefNode(
                    def.id, def.declaredType, translateExpr(def.initializer, fujureTruffleLanguage), fujureTruffleLanguage)
        }
    }

    private fun translateExpr(expr: Expr, fujureTruffleLanguage: FujureTruffleLanguage): ExprNode {
        return when (expr) {
            is Expr.UnitLiteral -> UnitLiteralExprNode()
            is Expr.BoolLiteral -> BoolLiteralExprNode(when (expr) {
                is Expr.BoolLiteral.True -> true
                is Expr.BoolLiteral.False -> false
            })
            is Expr.CharLiteral -> CharLiteralExprNode(parseCharaLiteral(expr.value))
            is Expr.IntLiteral -> IntLiteralExprNode(expr.value)
            is Expr.StringLiteral -> StringLiteralExprNode(expr.value)
            is Expr.ValueReferenceExpr -> ReferenceExprNode(expr.ref, fujureTruffleLanguage)
        }
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
