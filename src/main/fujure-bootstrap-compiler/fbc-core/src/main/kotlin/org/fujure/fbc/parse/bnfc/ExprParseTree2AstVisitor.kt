package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Expr
import org.fujure.fbc.ast.ValueReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunCallExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr as AbsynExpr

internal object ExprParseTree2AstVisitor :
        AbsynExpr.Visitor<Expr, Unit>,
        CallArg.Visitor<Expr, Unit>,
        ValRef.Visitor<ValueReference, Unit>,
        Literal.Visitor<Expr, Unit> {
    override fun visit(ifExpr: IfExpr, arg: Unit): Expr {
        return Expr.If(ifExpr.expr_1.accept(this, arg),
            ifExpr.expr_2.accept(this, arg),
            ifExpr.expr_3.accept(this, arg))
    }

    override fun visit(letExpr: LetExpr, arg: Unit): Expr {
        return Expr.Let(letExpr.listletdef_.map { letDef ->
            letDef.accept(DefsParseTree2AstExtractor, arg)
        }, letExpr.expr_.accept(this, arg))
    }

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

    override fun visit(equalityExpr: EqualityExpr, arg: Unit): Expr {
        return Expr.Equality(
                equalityExpr.expr_1.accept(this, arg),
                equalityExpr.expr_2.accept(this, arg))
    }

    override fun visit(inequalityExpr: InequalityExpr, arg: Unit): Expr {
        return Expr.Inequality(
                inequalityExpr.expr_1.accept(this, arg),
                inequalityExpr.expr_2.accept(this, arg))
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

    override fun visit(additionExpr: AdditionExpr, arg: Unit): Expr {
        return Expr.Addition(
                additionExpr.expr_1.accept(this, arg),
                additionExpr.expr_2.accept(this, arg))
    }

    override fun visit(subtractionExpr: SubtractionExpr, arg: Unit): Expr {
        return Expr.Subtraction(
                subtractionExpr.expr_1.accept(this, arg),
                subtractionExpr.expr_2.accept(this, arg))
    }

    override fun visit(multiplicationExpr: MultiplicationExpr, arg: Unit): Expr {
        return Expr.Multiplication(
                multiplicationExpr.expr_1.accept(this, arg),
                multiplicationExpr.expr_2.accept(this, arg))
    }

    override fun visit(divisionExpr: DivisionExpr, arg: Unit): Expr {
        return Expr.Division(
                divisionExpr.expr_1.accept(this, arg),
                divisionExpr.expr_2.accept(this, arg))
    }

    override fun visit(moduloExpr: ModuloExpr, arg: Unit): Expr {
        return Expr.Modulus(
                moduloExpr.expr_1.accept(this, arg),
                moduloExpr.expr_2.accept(this, arg))
    }

    override fun visit(funCallExpr: FunCallExpr, arg: Unit): Expr {
        return Expr.FunCall(funCallExpr.valref_.accept(this, arg), funCallExpr.listcallarg_.map {
            it.accept(this, arg)
        })
    }

    override fun visit(exprCallArg: ExprCallArg, arg: Unit): Expr {
        return exprCallArg.expr_.accept(this, arg)
    }

    override fun visit(notExpr: NotExpr, arg: Unit): Expr {
        return Expr.Negation(notExpr.expr_.accept(this, arg))
    }

    override fun visit(variableExpr: VariableExpr, arg: Unit): Expr {
        return Expr.ValueReference(variableExpr.valref_.accept(this, arg))
    }

    override fun visit(valueRef: ValueRef, arg: Unit): ValueReference {
        return ValueReference(valueRef.listvalreffragm_.map { valRefFragm ->
            valRefFragm.accept({ valueRefFragment, _ ->
                valueRefFragment.jid_}, arg)
        })
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
