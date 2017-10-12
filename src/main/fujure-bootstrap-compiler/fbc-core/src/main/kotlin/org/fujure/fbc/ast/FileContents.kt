package org.fujure.fbc.ast

data class FileContents(val packageName: String,
                        val imports: List<Import>,
                        val defs: List<Def>)
