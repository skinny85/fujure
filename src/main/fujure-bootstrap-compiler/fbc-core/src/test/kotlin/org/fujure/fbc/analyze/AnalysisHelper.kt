package org.fujure.fbc.analyze

import org.antlr.v4.runtime.CharStreams
import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parse.ParsingResult
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption.Companion.assume
import org.funktionale.either.Disjunction

object AnalysisHelper {
    fun analyzeProgram(program: String):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram> {
        return analyzePrograms(program)
    }

    fun analyzePrograms(firstProgram: String, vararg remainingPrograms: String):
            Disjunction<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram> {
        return SimpleSemanticAnalyzer.analyze(parsePrograms(firstProgram, *remainingPrograms))
    }

    private fun parsePrograms(firstProgram: String, vararg remainingPrograms: String): Set<ParsedFile> {
        val ret = linkedSetOf<ParsedFile>()
        for (i in 1.until(remainingPrograms.size + 2)) {
            val openedFile = OpenedFile(InputFile("File$i.fjr"), CharStreams.fromString(
                    if (i == 1) firstProgram else remainingPrograms[i - 2]))
            val parsingResult = BnfcParser.parse(openedFile)
            val success = assume(parsingResult).isA<ParsingResult.Success>()
            ret.add(success.parsedFile)
        }
        return ret
    }

    fun findFileErrors(index: Int, failure: Disjunction.Left<List<ProblematicFile.SemanticFileIssue>, AnalyzedProgram>):
            List<SemanticError> {
        return failure.value.find { it.userProvidedFilePath == "File$index.fjr" }?.errors ?: emptyList()
    }
}
