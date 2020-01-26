package org.fujure.fbc.aast

import org.fujure.fbc.analyze.QualifiedType

sealed class ADef {
    sealed class AValueDef : ADef() {
        data class ASimpleValueDef(val id: String, val type: QualifiedType, val initializer: AExpr) : AValueDef()

        data class AFunctionValueDef(val id: String, val arguments: List<AArgument>, val returnType: QualifiedType,
                val body: AExpr) : AValueDef()
    }
}

data class AArgument(val name: String, val type: QualifiedType)
