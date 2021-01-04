package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.analyze.CompleteType
import org.fujure.fbc.analyze.SemanticError

sealed class ExprVerificationResult(val completeType: CompleteType?) {
    class Success(completeType: CompleteType?, val aExpr: AExpr?) :
            ExprVerificationResult(completeType)

    class Failure(completeType: CompleteType?, val errors: List<SemanticError>) :
            ExprVerificationResult(completeType) {
        constructor(error: SemanticError) : this(null, listOf(error))
    }
}
