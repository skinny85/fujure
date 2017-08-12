package org.fujure.fjc.internal

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.file.NoSuchFileException

sealed class ArgumentFile(val userProvidedFile: String) {
    companion object {
        fun openFile(userProvidedFile: String): ArgumentFile {
            if (!userProvidedFile.endsWith(".fjr"))
                return InvalidFilename(userProvidedFile)

            val stream: CharStream
            try {
                stream = CharStreams.fromFileName(userProvidedFile)
            } catch (e: FileNotFoundException) {
                return MissingFile(userProvidedFile)
            } catch (e: NoSuchFileException) {
                return MissingFile(userProvidedFile)
            } catch (e: IOException) {
                return FailedFile(userProvidedFile, e)
            }
            return OpenedFile(userProvidedFile, stream)
        }
    }

    class InvalidFilename(userProvidedFile: String) :
            ArgumentFile(userProvidedFile)
    class MissingFile(userProvidedFile: String) :
            ArgumentFile(userProvidedFile)
    class FailedFile(userProvidedFile: String, val error: Throwable) :
            ArgumentFile(userProvidedFile)
    class OpenedFile(userProvidedFile: String, val stream: CharStream) :
            ArgumentFile(userProvidedFile)

}
