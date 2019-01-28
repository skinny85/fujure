package org.fujure.fbc.aast

import org.fujure.fbc.analyze.QualifiedType

sealed class ADef {
    sealed class AValueDef : ADef() {
        data class ASimpleValueDef(val id: String, val type: QualifiedType, val initializer: AExpr) : AValueDef()
    }
}
