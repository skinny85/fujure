package org.fujure.fbc

import org.fujure.fbc.internal.ArgumentFile

object SimpleFileOpener : FileOpener {
    override fun open(filePath: String): ArgumentFile {
        return ArgumentFile.openFile(filePath)
    }
}
