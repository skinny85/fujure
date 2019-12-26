package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.analyze.QualifiedType
import org.fujure.fbc.analyze.SemanticError

sealed class ExprVerificationResult(val qualifiedType: QualifiedType?) {
    class Success(qualifiedType: QualifiedType?, val aExpr: AExpr?) :
            ExprVerificationResult(qualifiedType)

    class Failure(qualifiedType: QualifiedType?, val errors: List<SemanticError>) :
            ExprVerificationResult(qualifiedType) {
        constructor(error: SemanticError) : this(null, listOf(error))
    }
}
