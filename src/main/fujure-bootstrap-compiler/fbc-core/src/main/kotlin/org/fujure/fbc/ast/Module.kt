package org.fujure.fbc.ast

data class Module(val packageName: String, val moduleName: String) {
    val fullyQualifiedName = if (packageName.isEmpty()) moduleName else "$packageName.$moduleName"
}
