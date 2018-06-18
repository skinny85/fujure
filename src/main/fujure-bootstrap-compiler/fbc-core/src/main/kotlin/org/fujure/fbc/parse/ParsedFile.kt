package org.fujure.fbc.parse

import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.InputFile

class ParsedFile(val inputFile: InputFile, val ast: FileContents) {
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        return inputFile == (other as ParsedFile).inputFile
    }

    override fun hashCode(): Int {
        return inputFile.hashCode()
    }

    override fun toString() = "ParsedFile('${inputFile.userProvidedFilePath}')"
}
