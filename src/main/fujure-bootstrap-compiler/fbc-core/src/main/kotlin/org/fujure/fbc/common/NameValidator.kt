package org.fujure.fbc.common

import javax.lang.model.SourceVersion

object NameValidator {
    fun validModuleName(moduleName: String): Boolean {
        return validFujureName(moduleName)
    }

    fun validValueName(name: String): Boolean {
        return validFujureName(name)
    }

    private fun validFujureName(name: String): Boolean {
        return SourceVersion.isIdentifier(name) &&
                SourceVersion.isName(name) &&
                !name.contains("$") &&
                "_" != name &&
                !isFujureKeyword(name)
    }

    private val fujureOnlyKeywords = setOf("def")

    private fun isFujureKeyword(moduleName: String): Boolean {
        return fujureOnlyKeywords.contains(moduleName)
    }
}
