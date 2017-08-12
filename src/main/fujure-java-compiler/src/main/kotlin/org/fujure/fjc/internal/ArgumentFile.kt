package org.fujure.fjc.internal

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import java.io.IOException

sealed class ArgumentFile(val userProvidedFile: String) {
    companion object {
        fun openFile(userProvidedFile: String): ArgumentFile {
            val stream: CharStream
            try {
                stream = CharStreams.fromFileName(userProvidedFile)
            } catch (e: IOException) {
                return FailedFile(userProvidedFile, e)
            }
            return OpenedFile(userProvidedFile, stream)
        }
    }

    class FailedFile(userProvidedFile: String, val error: Throwable) :
            ArgumentFile(userProvidedFile)
    class OpenedFile(userProvidedFile: String, val stream: CharStream) :
            ArgumentFile(userProvidedFile)
}
