package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Expr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral
import org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr as AbsynExpr

internal object ExprParseTree2AstVisitor :
        AbsynExpr.Visitor<Expr, Unit>,
        LetDef.Visitor<Def.ValueDef, Unit>,
        CallArg.Visitor<Expr, Unit>,
        Literal.Visitor<Expr, Unit> {
    override fun visit(ifExpr: IfExpr, arg: Unit): Expr {
        return Expr.If(ifExpr.expr_1.accept(this, arg),
            ifExpr.expr_2.accept(this, arg),
            ifExpr.expr_3.accept(this, arg))
    }

    override fun visit(letExpr: LetExpr, arg: Unit): Expr {
        return Expr.Let(letExpr.listletdef_.map { letDef ->
            letDef.accept(this, arg)
        }, letExpr.expr_.accept(this, arg))
    }

    override fun visit(letDefinition: LetDefinition, arg: Unit): Def.ValueDef {
        return letDefinition.binding_.accept(DefsParseTree2AstExtractor, arg)
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

    override fun visit(notExpr: NotExpr, arg: Unit): Expr {
        return Expr.Complement(notExpr.expr_.accept(this, arg))
    }

    override fun visit(negateExpr: NegateExpr, arg: Unit): Expr {
        return Expr.Negation(negateExpr.expr_.accept(this, arg))
    }

    override fun visit(positateExpr: PositateExpr, arg: Unit): Expr {
        return Expr.Positation(positateExpr.expr_.accept(this, arg))
    }

    override fun visit(simpleRefExpr: SimpleRefExpr, arg: Unit): Expr {
        return Expr.UnqualifiedReference(simpleRefExpr.jid_)
    }

    override fun visit(complexRefExpr: ComplexRefExpr, arg: Unit): Expr {
        return Expr.QualifiedReference(complexRefExpr.jid_1, complexRefExpr.jid_2)
    }

    override fun visit(funcCallExpr: FuncCallExpr, arg: Unit): Expr {
        return Expr.FunctionCall(
                funcCallExpr.expr_.accept(this, arg),
                funcCallExpr.listcallarg_.map { callArg -> callArg.accept(this, arg) }
        )
    }

    override fun visit(methCallExpr: MethCallExpr, arg: Unit): Expr {
        return Expr.MethodCall(
                methCallExpr.expr_.accept(this, arg),
                methCallExpr.jid_,
                methCallExpr.listcallarg_.map { callArg -> callArg.accept(this, arg) }
        )
    }

    override fun visit(exprCallArg: ExprCallArg, arg: Unit): Expr {
        return exprCallArg.expr_.accept(this, arg)
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
