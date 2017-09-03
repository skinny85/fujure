package org.fujure.fbc

import org.fujure.fbc.internal.ArgumentFile

interface FileOpener {
    fun open(filePath: String): ArgumentFile
}
