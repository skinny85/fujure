package org.fujure.fbc.analyze.pass_02

import org.fujure.fbc.analyze.AnalyzedProgram
import org.fujure.fbc.analyze.SemanticAnalysisResult
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

object VerificationAnalysis {
    fun analyze(parsedFiles: List<ParsedFile>, symbolTable: SymbolTable): SemanticAnalysisResult {
        val asts = mutableListOf<AstRoot>()
        for (parsedFile in parsedFiles) {
            val packageName = parsedFile.parseTree.accept(PackageNameExtractor, Unit)
            val defs = parsedFile.parseTree.accept(DefsVerificationVisitor, symbolTable)
            asts.add(AstRoot(parsedFile.userProvidedFilePath, FileContents(packageName, defs)))
        }
        return SemanticAnalysisResult.Success(AnalyzedProgram(asts, symbolTable))
    }
}

object DefsVerificationVisitor :
        AbsynFileContents.Visitor<List<Def>, SymbolTable>,
        Defs.Visitor<List<Def>, SymbolTable>,
        AbsynDef.Visitor<Def, SymbolTable>,
        ValDef.Visitor<Def, SymbolTable> {
    override fun visit(fileContents: FileInNamedPackage, symbolTable: SymbolTable): List<Def> {
        return fileContents.defs_.accept(this, symbolTable)
    }

    override fun visit(fileContents: FileInDefaultPackage, symbolTable: SymbolTable): List<Def> {
        return fileContents.defs_.accept(this, symbolTable)
    }

    override fun visit(defs: Definitions, symbolTable: SymbolTable): List<Def> {
        return defs.listdef_.map { def -> def.accept(this, symbolTable) }
    }

    override fun visit(valueDef: ValueDef, symbolTable: SymbolTable): Def {
        return valueDef.valdef_.accept(this, symbolTable)
    }

    override fun visit(untypedValueDef: UntypedValueDef, symbolTable: SymbolTable): Def {
        return Def.ValueDef.SimpleValueDef(untypedValueDef.ident_, untypedValueDef.integer_)
    }

    override fun visit(typedValueDef: TypedValueDef, symbolTable: SymbolTable): Def {
        return Def.ValueDef.SimpleValueDef(typedValueDef.ident_, typedValueDef.integer_)
    }
}
