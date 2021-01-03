package org.fujure.fbc.aast

import org.fujure.fbc.analyze.CompleteType
import org.fujure.fbc.analyze.PartialType
import org.fujure.fbc.analyze.TypeVariables

sealed class ADef {
    sealed class AValueDef : ADef() {
        data class ASimpleValueDef(val id: String, val type: CompleteType, val initializer: AExpr) : AValueDef()

        data class AFunctionValueDef(val id: String, val typeVariables: TypeVariables, val arguments: List<AArgument>, val returnType: PartialType,
                val body: AExpr) : AValueDef()
    }
}

data class AArgument(val name: String, val type: PartialType)
