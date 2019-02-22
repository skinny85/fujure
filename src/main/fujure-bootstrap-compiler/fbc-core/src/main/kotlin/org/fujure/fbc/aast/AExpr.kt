package org.fujure.fbc.aast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.Module

sealed class AExpr {
    data class AValueReferenceExpr(val targetModule: Module,
            val reference: String, val type: QualifiedType): AExpr()

    data class AIntLiteral(val value: Int) : AExpr()

    object AUnitLiteral : AExpr()

    sealed class ABoolLiteral : AExpr() {
        object True : ABoolLiteral()
        object False : ABoolLiteral()
    }

    data class ACharLiteral(val value: String) : AExpr()
    data class AStringLiteral(val value: String) : AExpr()

    data class ANegation(val operand: AExpr) : AExpr()
    data class AConjunction(val leftConjunct: AExpr, val rightConjunct: AExpr) : AExpr()
    data class ADisjunction(val leftDisjunct: AExpr, val rightDisjunct: AExpr) : AExpr()

    fun type(): QualifiedType = when (this) {
        is AIntLiteral -> BuiltInTypes.Int
        is AUnitLiteral -> BuiltInTypes.Unit
        is ABoolLiteral -> BuiltInTypes.Bool
        is ACharLiteral -> BuiltInTypes.Char
        is AStringLiteral -> BuiltInTypes.String
        is AValueReferenceExpr -> this.type
        is ANegation -> BuiltInTypes.Bool
        is AConjunction -> BuiltInTypes.Bool
        is ADisjunction -> BuiltInTypes.Bool
    }

    val precedence: Int get() = when (this) {
        is ADisjunction -> 0
        is AConjunction -> 1
        is ANegation -> 2
        is AIntLiteral -> 2
        is AUnitLiteral -> 2
        is ABoolLiteral -> 2
        is ACharLiteral -> 2
        is AStringLiteral -> 2
        is AValueReferenceExpr -> 2
    }
}
