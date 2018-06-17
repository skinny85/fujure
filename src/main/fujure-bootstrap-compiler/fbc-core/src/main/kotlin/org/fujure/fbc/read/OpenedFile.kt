package org.fujure.fbc.read

import org.fujure.fbc.ast.InputFile
import java.io.Reader

class OpenedFile(val inputFile: InputFile, val stream: Reader) {
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (javaClass != other?.javaClass)
            return false

        other as OpenedFile

        return inputFile == other.inputFile
    }

    override fun hashCode(): Int {
        return inputFile.hashCode()
    }

    override fun toString() = "OpenedFile('${inputFile.userProvidedFilePath}')"
}
