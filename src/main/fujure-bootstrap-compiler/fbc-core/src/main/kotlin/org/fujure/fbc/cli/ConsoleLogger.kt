package org.fujure.fbc.cli

object ConsoleLogger : Logger {
    override fun error(msg: String) {
        println(msg)
    }
}
