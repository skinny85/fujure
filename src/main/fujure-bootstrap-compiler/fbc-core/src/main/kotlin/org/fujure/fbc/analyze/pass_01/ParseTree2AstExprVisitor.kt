package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.ValueReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr as AbsynExpr

object ParseTree2AstExprVisitor :
        AbsynExpr.Visitor<Expr, Unit>,
        ValRef.Visitor<List<String>, Unit>,
        Literal.Visitor<Expr, Unit> {
    override fun visit(variableExpr: VariableExpr, arg: Unit): Expr {
        return Expr.ValueReferenceExpr(ValueReference(
                variableExpr.valref_.accept(this, Unit)))
    }

    override fun visit(valueRef: ValueRef, arg: Unit): List<String> {
        return valueRef.listvalreffragm_.map { valRefFragm ->
            valRefFragm.accept({ valueRefFragment, _ ->
                valueRefFragment.jid_}, Unit)
        }
    }

    override fun visit(exprLiteral: ExprLiteral, arg: Unit): Expr {
        return exprLiteral.literal_.accept(this, Unit)
    }

    override fun visit(intLiteral: IntLiteral, arg: Unit): Expr {
        return Expr.IntLiteral(intLiteral.integer_)
    }

    override fun visit(trueLiteral: BoolTrueLiteral, arg: Unit): Expr {
        return Expr.BoolLiteral.True
    }

    override fun visit(falseLiteral: BoolFalseLiteral, arg: Unit): Expr {
        return Expr.BoolLiteral.False
    }
}