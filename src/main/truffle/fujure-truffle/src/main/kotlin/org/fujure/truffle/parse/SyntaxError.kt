package org.fujure.truffle.parse

data class SyntaxError(val line: Int, val column: Int, val msg: String)
