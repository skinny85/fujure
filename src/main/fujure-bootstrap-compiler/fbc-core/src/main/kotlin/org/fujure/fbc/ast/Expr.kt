package org.fujure.fbc.ast

sealed class Expr {
    data class UnqualifiedReference(val ref: String): Expr()
    data class QualifiedReference(val module: String, val ref: String): Expr()

    data class IntLiteral(val value: Int) : Expr()

    object UnitLiteral : Expr()

    sealed class BoolLiteral : Expr() {
        object True : BoolLiteral()
        object False : BoolLiteral()
    }

    data class CharLiteral(val value: String) : Expr()
    data class StringLiteral(val value: String) : Expr()

    data class Disjunction(val leftDisjunct: Expr, val rightDisjunct: Expr) : Expr()
    data class Conjunction(val leftConjunct: Expr, val rightConjunct: Expr) : Expr()
    data class Complement(val operand: Expr) : Expr()
    data class Negation(val operand: Expr) : Expr()
    data class Positation(val operand: Expr) : Expr()

    data class Equality(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class Inequality(val leftOperand: Expr, val rightOperand: Expr) : Expr()

    data class Lesser(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class LesserEqual(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class Greater(val leftOperand: Expr, val rightOperand: Expr) : Expr()
    data class GreaterEqual(val leftOperand: Expr, val rightOperand: Expr) : Expr()

    data class Addition(val augend: Expr, val addend: Expr) : Expr()
    data class Subtraction(val minuend: Expr, val subtrahend: Expr) : Expr()
    data class Multiplication(val multiplicand: Expr, val multiplier: Expr) : Expr()
    data class Division(val dividend: Expr, val divisor: Expr) : Expr()
    data class Modulus(val dividend: Expr, val divisor: Expr) : Expr()

    data class Let(val declarations: List<Def.ValueDef>, val expr: Expr) : Expr()
    data class If(val conditionExpr: Expr, val thenExpr: Expr, val elseExpr: Expr) : Expr()

    data class FunctionCall(val target: Expr, val arguments: List<Expr>) : Expr()
    data class MethodCall(val receiver: Expr, val methodName: String, val arguments: List<Expr>) : Expr()

    data class StatementBlock(val statements: List<Stmt>) : Expr()
}

sealed class Stmt {
    data class Expression(val expr: Expr) : Stmt()
}
