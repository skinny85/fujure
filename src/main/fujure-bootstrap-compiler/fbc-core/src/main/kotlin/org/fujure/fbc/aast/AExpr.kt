package org.fujure.fbc.aast

import org.fujure.fbc.analyze.BuiltInTypes
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.ast.Module

sealed class AExpr {
    data class AValueReference(val targetModule: Module,
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
}
