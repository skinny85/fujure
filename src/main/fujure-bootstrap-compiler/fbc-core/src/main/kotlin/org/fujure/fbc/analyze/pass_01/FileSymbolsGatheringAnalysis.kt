package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.AstRoot
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.FileContents
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parse.ParsedFile
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef
import org.funktionale.either.Either
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents as AbsynFileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef as AbsynValueDef

object FileSymbolsGatheringAnalysis {
    fun analyze(parsedFile: ParsedFile): FileSymbolsGatheringResult {
        val packageName = parsedFile.parseTree.accept(PackageNameExtractor, Unit)
        val fileSymbolTableBuilder = FileSymbolTableBuilder()

        val eitherFailureOrListOfDefs = parsedFile.parseTree.accept(DefsGatherVisitor, fileSymbolTableBuilder)
        return when (eitherFailureOrListOfDefs) {
            is Either.Left -> eitherFailureOrListOfDefs.l
            is Either.Right -> FileSymbolsGatheringResult.Success(
                    AstRoot(parsedFile.userProvidedFilePath,
                            FileContents(packageName, eitherFailureOrListOfDefs.r)),
                    fileSymbolTableBuilder.build())
        }
    }
}

sealed class FileSymbolsGatheringResult {
    data class Failure(val errors: List<SemanticError>) :
            FileSymbolsGatheringResult()

    data class Success(val astRoot: AstRoot, val fileSymbolTable: FileSymbolTable) :
            FileSymbolsGatheringResult()
}

object DefsGatherVisitor :
        AbsynFileContents.Visitor<
                Either<FileSymbolsGatheringResult.Failure, List<Def>>,
                FileSymbolTableBuilder>,
        Defs.Visitor<
                Either<FileSymbolsGatheringResult.Failure, List<Def>>,
                FileSymbolTableBuilder>,
        AbsynDef.Visitor<
                Either<SemanticError, Def>,
                FileSymbolTableBuilder>,
        ValDef.Visitor<
                Either<SemanticError.DuplicateDefintion, Def.ValueDef>,
                FileSymbolTableBuilder> {
    override fun visit(fileContents: FileInNamedPackage, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<FileSymbolsGatheringResult.Failure, List<Def>> {
        return fileContents.defs_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(fileContents: FileInDefaultPackage, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<FileSymbolsGatheringResult.Failure, List<Def>> {
        return fileContents.defs_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(definitions: Definitions, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<FileSymbolsGatheringResult.Failure, List<Def>> {
        val defs = mutableListOf<Def>()
        val errors = mutableListOf<SemanticError>()

        for (def in definitions.listdef_) {
            val valueDefOrError = def.accept(this, fileSymbolTableBuilder)
            when (valueDefOrError) {
                is Either.Left -> errors.add(valueDefOrError.l)
                is Either.Right -> defs.add(valueDefOrError.r)
            }
        }

        return if (errors.isEmpty())
            Either.Right(defs)
        else
            Either.Left(FileSymbolsGatheringResult.Failure(errors))
    }

    override fun visit(valueDef: AbsynValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError, Def.ValueDef> {
        return valueDef.valdef_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(untypedValueDef: UntypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError.DuplicateDefintion, Def.ValueDef> {
        return visitValueDef(untypedValueDef.ident_, null, untypedValueDef.integer_, fileSymbolTableBuilder)
    }

    override fun visit(typedValueDef: TypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError.DuplicateDefintion, Def.ValueDef> {
        val declaredType = typedValueDef.typespec_.accept(TypeSpec2TypeReference, Unit)
        return visitValueDef(typedValueDef.ident_, declaredType, typedValueDef.integer_, fileSymbolTableBuilder)
    }

    private fun visitValueDef(id: String, declaredType: TypeReference?, value: Int, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError.DuplicateDefintion, Def.ValueDef> {
        return if (fileSymbolTableBuilder.addSimpleValueDeclaration(id, declaredType))
            Either.Right(Def.ValueDef.SimpleValueDef(id, declaredType, value))
        else
            Either.Left(SemanticError.DuplicateDefintion(id))
    }
}

object TypeSpec2TypeReference : TypeSpec.Visitor<TypeReference, Unit> {
    override fun visit(typeSpecifier: TypeSpecifier, arg: Unit): TypeReference {
        return TypeReference(typeSpecifier.listtypespecfragm_.map { typeSpecFragm ->
            typeSpecFragm.accept({ typeSpecFragment, _ -> typeSpecFragment.ident_ }, Unit)
        })
    }
}
