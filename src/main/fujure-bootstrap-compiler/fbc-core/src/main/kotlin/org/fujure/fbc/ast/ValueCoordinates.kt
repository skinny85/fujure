package org.fujure.fbc.ast

data class ValueCoordinates(val packageName: String, val moduleName: String, val valueName: String) {
    fun inStringForm(): String {
        val prefix = if (packageName.isEmpty()) "" else "${packageName}."
        return "${prefix}${moduleName}.${valueName}"
    }
}
