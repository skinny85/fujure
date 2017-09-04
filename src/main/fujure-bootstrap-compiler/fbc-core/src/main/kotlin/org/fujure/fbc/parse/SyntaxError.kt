package org.fujure.fbc.parse

data class SyntaxError(val line: Int, val column: Int, val msg: String)
