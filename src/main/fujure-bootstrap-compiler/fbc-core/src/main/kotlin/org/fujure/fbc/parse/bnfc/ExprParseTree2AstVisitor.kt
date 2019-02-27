package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.ValueReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr as AbsynExpr

internal object ExprParseTree2AstVisitor :
        AbsynExpr.Visitor<Expr, Unit>,
        ValRef.Visitor<List<String>, Unit>,
        Literal.Visitor<Expr, Unit> {
    override fun visit(orExpr: OrExpr, arg: Unit): Expr {
        return Expr.Disjunction(
                orExpr.expr_1.accept(this, arg),
                orExpr.expr_2.accept(this, arg))
    }

    override fun visit(andExpr: AndExpr, arg: Unit): Expr {
        return Expr.Conjunction(
                andExpr.expr_1.accept(this, arg),
                andExpr.expr_2.accept(this, arg))
    }

    override fun visit(lesserExpr: LesserExpr, arg: Unit): Expr {
        return Expr.Lesser(
                lesserExpr.expr_1.accept(this, arg),
                lesserExpr.expr_2.accept(this, arg))
    }

    override fun visit(lesserEqualExpr: LesserEqualExpr, arg: Unit): Expr {
        return Expr.LesserEqual(
                lesserEqualExpr.expr_1.accept(this, arg),
                lesserEqualExpr.expr_2.accept(this, arg))
    }

    override fun visit(greaterExpr: GreaterExpr, arg: Unit): Expr {
        return Expr.Greater(
                greaterExpr.expr_1.accept(this, arg),
                greaterExpr.expr_2.accept(this, arg))
    }

    override fun visit(greaterEqualExpr: GreaterEqualExpr, arg: Unit): Expr {
        return Expr.GreaterEqual(
                greaterEqualExpr.expr_1.accept(this, arg),
                greaterEqualExpr.expr_2.accept(this, arg))
    }

    override fun visit(notExpr: NotExpr, arg: Unit): Expr {
        return Expr.Negation(notExpr.expr_.accept(this, arg))
    }

    override fun visit(variableExpr: VariableExpr, arg: Unit): Expr {
        return Expr.ValueReference(ValueReference(
                variableExpr.valref_.accept(this, arg)))
    }

    override fun visit(valueRef: ValueRef, arg: Unit): List<String> {
        return valueRef.listvalreffragm_.map { valRefFragm ->
            valRefFragm.accept({ valueRefFragment, _ ->
                valueRefFragment.jid_}, arg)
        }
    }

    override fun visit(exprLiteral: LiteralExpr, arg: Unit): Expr {
        return exprLiteral.literal_.accept(this, arg)
    }

    override fun visit(intLiteral: IntLiteral, arg: Unit): Expr {
        return Expr.IntLiteral(intLiteral.integer_)
    }

    override fun visit(unitLiteral: UnitLiteral, arg: Unit): Expr {
        return Expr.UnitLiteral
    }

    override fun visit(trueLiteral: BoolTrueLiteral, arg: Unit): Expr {
        return Expr.BoolLiteral.True
    }

    override fun visit(falseLiteral: BoolFalseLiteral, arg: Unit): Expr {
        return Expr.BoolLiteral.False
    }

    override fun visit(charLiteral: CharLiteral, arg: Unit): Expr {
        return Expr.CharLiteral(charLiteral.jchar_)
    }

    override fun visit(stringLiteral: StringLiteral, arg: Unit): Expr {
        // we need to remove the leading and trailing quotes from the String literal
        return Expr.StringLiteral(stringLiteral.jstring_.substring(1, stringLiteral.jstring_.length - 1))
    }
}
