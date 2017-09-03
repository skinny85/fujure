package org.fujure.fbc.cli

import org.assertj.core.api.Assertions

class AppendingLogger : Logger {
    private val output = StringBuilder()

    override fun error(msg: String) {
       output.append(msg).append('\n')
    }

    fun verifyLogged(msgFragment: String) {
        Assertions.assertThat(output).contains(msgFragment)
    }
}
