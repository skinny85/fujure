package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
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

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): FileSymbolsGatheringResult {
        val fileSymbolTableBuilder = FileSymbolTableBuilder()
        return FileSymbolsGatheringResult.Success(
                parsedFile.parseTree.accept(DefsGatherVisitor, fileSymbolTableBuilder))
    }
}

sealed class FileSymbolsGatheringResult {
    data class Failure(val errors: List<SemanticError>) :
            FileSymbolsGatheringResult()

    data class Success(val fileSymbolTable: FileSymbolTable) :
            FileSymbolsGatheringResult()
}

class FileSymbolTableBuilder {
    fun build(): FileSymbolTable {
        return FileSymbolTable()
    }
}

class FileSymbolTable

object DefsGatherVisitor :
        AbsynFileContents.Visitor<FileSymbolTable, FileSymbolTableBuilder>,
        Defs.Visitor<FileSymbolTable, FileSymbolTableBuilder>,
        AbsynDef.Visitor<Unit, FileSymbolTableBuilder>,
        ValDef.Visitor<Unit, FileSymbolTableBuilder> {
    override fun visit(fileContents: FileInNamedPackage, fileSymbolTableBuilder: FileSymbolTableBuilder): FileSymbolTable {
        return fileContents.defs_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(fileContents: FileInDefaultPackage, fileSymbolTableBuilder: FileSymbolTableBuilder): FileSymbolTable {
        return fileContents.defs_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(defs: Definitions, fileSymbolTableBuilder: FileSymbolTableBuilder): FileSymbolTable {
        for (def in defs.listdef_) {
            def.accept(this, fileSymbolTableBuilder)
        }
        return fileSymbolTableBuilder.build()
    }

    override fun visit(valueDef: ValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder) {
        return valueDef.valdef_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(untypedValueDef: UntypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder) {
    }

    override fun visit(typedValueDef: TypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder) {
    }
}
