package org.fujure.truffle.parse

import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA

import java.util.BitSet
import java.util.Collections
import java.util.LinkedList

class FujureTruffleAntlrErrorListener : ANTLRErrorListener {
    private val errors = LinkedList<SyntaxError>()

    override fun syntaxError(recognizer: Recognizer<*, *>, offendingSymbol: Any, line: Int,
            charPositionInLine: Int, msg: String, e: RecognitionException) {
        errors.add(SyntaxError(line, charPositionInLine, msg))
    }

    fun hasErrors(): Boolean {
        return !errors.isEmpty()
    }

    fun errors(): List<SyntaxError> {
        return Collections.unmodifiableList(errors)
    }

    override fun reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int,
            exact: Boolean, ambigAlts: BitSet, configs: ATNConfigSet) {
        // do nothing
    }

    override fun reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int,
            stopIndex: Int, conflictingAlts: BitSet, configs: ATNConfigSet) {
        // do nothing
    }

    override fun reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int,
            stopIndex: Int, prediction: Int, configs: ATNConfigSet) {
        // do nothing
    }
}
