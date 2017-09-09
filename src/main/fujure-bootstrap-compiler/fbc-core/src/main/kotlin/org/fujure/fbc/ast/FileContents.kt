package org.fujure.fbc.ast

data class FileContents(val packageName: String,
                        val defs: List<Def>)
