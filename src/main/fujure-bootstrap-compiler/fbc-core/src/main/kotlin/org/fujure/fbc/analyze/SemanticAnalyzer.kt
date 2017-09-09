package org.fujure.fbc.analyze

import org.fujure.fbc.ProblematicFile
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.SymbolTable
import org.fujure.fbc.codegen.ast.PackageNameExtractor
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents

interface SemanticAnalyzer {
    fun analyze(parsedFiles: List<ParsedFile>): SemanticAnalysisResult
}

sealed class SemanticAnalysisResult {
    data class Failure(val issues: List<ProblematicFile.SemanticFileIssue>) :
            SemanticAnalysisResult()

    data class Success(val analyzedProgram: AnalyzedProgram):
            SemanticAnalysisResult()
}

class SemanticError

data class AnalyzedProgram(val asts: List<AstRoot>,
                           val symbolTable: SymbolTable)

class SymbolTableBuilder {
    fun build(): SymbolTable {
        return SymbolTable()
    }
}

sealed class FileAnalysisResult {
    data class Failure(val errors: List<SemanticError>) :
            FileAnalysisResult()

    data class Success(val ast: AstRoot) :
            FileAnalysisResult()
}

object SimpleSemanticAnalyzer : SemanticAnalyzer {
    override fun analyze(parsedFiles: List<ParsedFile>): SemanticAnalysisResult {
        val symbolTableBuilder = SymbolTableBuilder()
        val asts = mutableListOf<AstRoot>()
        val issues = mutableListOf<ProblematicFile.SemanticFileIssue>()
        for (parsedFile in parsedFiles) {
            val fileAnalysisResult = analyze(parsedFile, symbolTableBuilder)
            when (fileAnalysisResult) {
                is FileAnalysisResult.Failure -> {
                    issues.add(ProblematicFile.SemanticFileIssue(parsedFile.userProvidedFilePath,
                            fileAnalysisResult.errors))
                }
                is FileAnalysisResult.Success -> {
                    asts.add(fileAnalysisResult.ast)
                }
            }
        }
        return if (issues.isEmpty())
            SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTableBuilder.build()))
        else
            SemanticAnalysisResult.Failure(issues)
    }

    fun analyze(parsedFile: ParsedFile, symbolTableBuilder: SymbolTableBuilder): FileAnalysisResult {
        val packageName = parsedFile.parseTree.accept(PackageNameExtractor, Unit)

        val defs = parsedFile.parseTree.accept(DefsAnalyzeVisitor, symbolTableBuilder)

        return FileAnalysisResult.Success(AstRoot(parsedFile.userProvidedFilePath, FileContents(packageName, defs)))
    }
}

object DefsAnalyzeVisitor :
        AbsynFileContents.Visitor<List<Def>, SymbolTableBuilder>,
        Defs.Visitor<List<Def>, SymbolTableBuilder>,
        AbsynDef.Visitor<Def, SymbolTableBuilder>,
        ValDef.Visitor<Def, SymbolTableBuilder> {
    override fun visit(fileContents: FileInNamedPackage, symbolTableBuilder: SymbolTableBuilder): List<Def> {
        return fileContents.defs_.accept(this, symbolTableBuilder)
    }

    override fun visit(fileContents: FileInDefaultPackage, symbolTableBuilder: SymbolTableBuilder): List<Def> {
        return fileContents.defs_.accept(this, symbolTableBuilder)
    }

    override fun visit(defs: Definitions, symbolTableBuilder: SymbolTableBuilder): List<Def> {
        return defs.listdef_.map { def -> def.accept(this, symbolTableBuilder) }
    }

    override fun visit(valueDef: ValueDef, symbolTableBuilder: SymbolTableBuilder): Def {
        return valueDef.valdef_.accept(this, symbolTableBuilder)
    }

    override fun visit(untypedValueDef: UntypedValueDef, symbolTableBuilder: SymbolTableBuilder): Def {
        return Def.ValueDef.SimpleValueDef()
    }

    override fun visit(typedValueDef: TypedValueDef, symbolTableBuilder: SymbolTableBuilder): Def {
        return Def.ValueDef.SimpleValueDef()
    }
}
