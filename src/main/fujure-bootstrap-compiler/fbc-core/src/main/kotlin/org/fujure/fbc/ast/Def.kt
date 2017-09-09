package org.fujure.fbc.ast

sealed class Def {
    sealed class ValueDef : Def() {
        class SimpleValueDef : ValueDef()
    }
}
