package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.ParsingResult
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume

object AnalysisHelper {
    fun analyzeProgram(program: String): SemanticAnalysisResult {
        return analyzePrograms(program)
    }

    fun analyzePrograms(firstProgram: String, vararg remainingPrograms: String):
            SemanticAnalysisResult {
        return SimpleSemanticAnalyzer.analyze(parsePrograms(firstProgram, *remainingPrograms))
    }

    private fun parsePrograms(firstProgram: String, vararg remainingPrograms: String): List<ParsedFile> {
        val ret = mutableListOf<ParsedFile>()
        for (i in 1.until(remainingPrograms.size + 2)) {
            val openedFile = OpenedFile("File$i.fjr", CharStreams.fromString(
                    if (i == 1) firstProgram else remainingPrograms[i - 2]))
            val parsingResult = BnfcParser.parse(openedFile)
            val success = assume(parsingResult).isA<ParsingResult.Success>()
            ret.add(success.parsedFile)
        }
        return ret
    }
}
