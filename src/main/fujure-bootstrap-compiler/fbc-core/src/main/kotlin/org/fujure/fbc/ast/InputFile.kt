package org.fujure.fbc.ast

import java.io.File

class InputFile(val userProvidedFilePath: String) {
    val canonicalPath: String
    val moduleName: String

    init {
        val file = File(userProvidedFilePath)
        canonicalPath = file.canonicalPath
        moduleName = file.nameWithoutExtension
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as InputFile

        return canonicalPath == other.canonicalPath
    }

    override fun hashCode(): Int {
        return canonicalPath.hashCode()
    }

    override fun toString() = "InputFile('$userProvidedFilePath')"
}
