package org.fujure.truffle

import org.apache.commons.text.StringEscapeUtils
import org.fujure.fbc.aast.ADef
import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.aast.AFileContents
import org.fujure.truffle.nodes.BoolLiteralExprNode
import org.fujure.truffle.nodes.CharLiteralExprNode
import org.fujure.truffle.nodes.DefNode
import org.fujure.truffle.nodes.ExprNode
import org.fujure.truffle.nodes.IntLiteralExprNode
import org.fujure.truffle.nodes.ModuleNonRootNode
import org.fujure.truffle.nodes.ReferenceExprNode
import org.fujure.truffle.nodes.SimpleValueDefNode
import org.fujure.truffle.nodes.StringLiteralExprNode
import org.fujure.truffle.nodes.UnitLiteralExprNode

object Aast2TruffleNodes {
    fun translate(annotatedAst: AFileContents, fujureTruffleLanguage: FujureTruffleLanguage): ModuleNonRootNode {
        return ModuleNonRootNode(annotatedAst.module,
                annotatedAst.defs.map { translate(it, fujureTruffleLanguage) })
    }

    private fun translate(aDef: ADef, fujureTruffleLanguage: FujureTruffleLanguage): DefNode {
        return when (aDef) {
            is ADef.AValueDef.ASimpleValueDef -> SimpleValueDefNode(
                    aDef.id, translateExpr(aDef.initializer, fujureTruffleLanguage))
        }
    }

    private fun translateExpr(aExpr: AExpr, fujureTruffleLanguage: FujureTruffleLanguage): ExprNode {
        return when (aExpr) {
            is AExpr.AUnitLiteral -> UnitLiteralExprNode()
            is AExpr.ABoolLiteral -> BoolLiteralExprNode(when (aExpr) {
                is AExpr.ABoolLiteral.True -> true
                is AExpr.ABoolLiteral.False -> false
            })
            is AExpr.ACharLiteral -> CharLiteralExprNode(parseCharaLiteral(aExpr.value))
            is AExpr.AIntLiteral -> IntLiteralExprNode(aExpr.value)
            is AExpr.AStringLiteral -> StringLiteralExprNode(aExpr.value)
            is AExpr.AValueReferenceExpr -> ReferenceExprNode(aExpr.targetModule, aExpr.reference, fujureTruffleLanguage)
        }
    }

    private fun parseCharaLiteral(string: String): Char {
        // first, strip the surrounding single quotes
        val character = string.substring(1, string.length - 1)
        return StringEscapeUtils.unescapeJava(character)[0]
    }
}
