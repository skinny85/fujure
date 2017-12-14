package org.fujure.fbc.ast

data class Import(private val fragments: List<String>) {
    constructor(firstFragment: String, vararg remainingFragments: String) :
            this(listOf(firstFragment, *remainingFragments))

    val size = fragments.size

    fun inStringForm() = fragments.joinToString(".")

    fun allButLastFragments() = fragments.subList(0, size - 1).joinToString(".")
    fun lastFragment() = fragments.last()
}
