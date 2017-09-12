package org.fujure.fbc.ast

data class TypeReference(val ids: List<String>) {
    constructor(id: String, vararg ids: String) : this(listOf(id, *ids))

    fun inStringForm(): String = ids.joinToString(".")
}
