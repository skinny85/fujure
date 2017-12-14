package org.fujure.fbc.ast

data class Import(val fragments: List<String>) {
    constructor(firstFragment: String, vararg remainingFragments: String) :
            this(listOf(firstFragment, *remainingFragments))

    fun inStringForm() = fragments.joinToString(".")
}
