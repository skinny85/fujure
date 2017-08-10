package org.fujure.fjc.internal

import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.BitSet

class FjcAntlrErrorListener() : ANTLRErrorListener {
    private val syntaxErrors = mutableListOf<SyntaxError>()
    val hasSyntaxErrors: Boolean get() = !syntaxErrors.isEmpty()

    fun forEachError(closure: (SyntaxError) -> Unit) {
        syntaxErrors.forEach(closure)
    }

    override fun syntaxError(recognizer: Recognizer<*, *>, offendingSymbol: Any?, line: Int,
                             charPositionInLine: Int, msg: String, e: RecognitionException?) {
//        println("FjcAntlrErrorListener.syntaxError($line, $charPositionInLine, $msg) called")
        syntaxErrors.add(SyntaxError(line, charPositionInLine, msg))
    }

    override fun reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int,
                                 exact: Boolean, ambigAlts: BitSet, configs: ATNConfigSet) {
        // do nothing
    }

    override fun reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int,
                                             conflictingAlts: BitSet, configs: ATNConfigSet) {
        // do nothing
    }

    override fun reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int,
                                          prediction: Int, configs: ATNConfigSet) {
        // do nothing
    }
}
