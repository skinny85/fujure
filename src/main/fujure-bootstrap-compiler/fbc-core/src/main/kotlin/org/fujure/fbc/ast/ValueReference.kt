package org.fujure.fbc.ast

data class ValueReference(val ids: List<String>) {
    constructor(id: String, vararg ids: String) : this(listOf(id, *ids))

    fun inStringForm() = ids.joinToString(".")
    fun variable() = ids.last()
}
