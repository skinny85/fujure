package org.fujure.fbc.analyze.pass03

import org.fujure.fbc.aast.AExpr
import org.fujure.fbc.analyze.PartialType
import org.fujure.fbc.analyze.SemanticError

sealed class ExprVerificationResult(val partialType: PartialType?) {
    class Success(partialType: PartialType?, val aExpr: AExpr?) :
            ExprVerificationResult(partialType)

    class Failure(partialType: PartialType?, val errors: List<SemanticError>) :
            ExprVerificationResult(partialType) {
        constructor(error: SemanticError) : this(null, listOf(error))
    }
}
