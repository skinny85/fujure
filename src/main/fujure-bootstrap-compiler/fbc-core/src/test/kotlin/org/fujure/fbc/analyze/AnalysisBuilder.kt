package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.read.OpenedFile
import org.fujure.test.utils.Assumption
import org.funktionale.either.Disjunction
import java.io.StringReader

class AnalysisBuilder private constructor() {
    private val programs = mutableListOf<Pair<String, String?>>()

    companion object {
        fun file(source: String): AnalysisBuilder {
            return AnalysisBuilder().file(source)
        }
    }

    fun file(source: String): AnalysisBuilder {
        programs.add(Pair(source, null))
        return this
    }

    fun named(name: String): AnalysisBuilder {
        val last = programs.last()
        programs[programs.size - 1] = Pair(last.first, name)
        return this
    }

    fun analyze(): Disjunction<List<ProblematicFile.SemanticFileIssue>, SymbolTable> {
        val parsedFiles = linkedSetOf<ParsedFile>()
        programs.forEachIndexed { i, pair ->
            val setName = pair.second
            val fileName: String = if (setName == null) "File${i + 1}.fjr" else setName
            val openedFile = OpenedFile(InputFile(fileName), StringReader(pair.first))
            val parsingResult = BnfcParser.parse(openedFile)
            val success = Assumption.assume(parsingResult).isA<Disjunction.Right<ProblematicFile.ParsingFileIssue, ParsedFile>>()
            if (!parsedFiles.add(success.value))
                throw IllegalStateException("Duplicate ParsedFile ${success.value} provided, " +
                        "current parsed files: $parsedFiles")
        }
        return SimpleSemanticAnalyzer.analyze(parsedFiles)
    }
}
