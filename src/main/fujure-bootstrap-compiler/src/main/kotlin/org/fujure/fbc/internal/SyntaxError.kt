package org.fujure.fbc.internal

data class SyntaxError(val line: Int, val column: Int, val msg: String)
