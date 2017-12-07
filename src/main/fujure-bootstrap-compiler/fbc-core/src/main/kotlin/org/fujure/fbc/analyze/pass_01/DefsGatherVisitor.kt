package org.fujure.fbc.analyze.pass_01

import org.fujure.fbc.analyze.SemanticError
import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.common.NameValidator
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef
import org.funktionale.either.Either
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef

object DefsGatherVisitor :
        FileContents.Visitor<
                Either<FileSymbolsGatheringResult.Failure, List<Def>>,
                FileSymbolTableBuilder>,
        Defs.Visitor<
                Either<FileSymbolsGatheringResult.Failure, List<Def>>,
                FileSymbolTableBuilder>,
        AbsynDef.Visitor<
                Either<SemanticError, Def>,
                FileSymbolTableBuilder>,
        ValDef.Visitor<
                Either<SemanticError, Def.ValueDef>,
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

    override fun visit(valueDef: ValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError, Def.ValueDef> {
        return valueDef.valdef_.accept(this, fileSymbolTableBuilder)
    }

    override fun visit(untypedValueDef: UntypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError, Def.ValueDef> {
        return visitValueDef(untypedValueDef.jid_, null, untypedValueDef.expr_, fileSymbolTableBuilder)
    }

    override fun visit(typedValueDef: TypedValueDef, fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError, Def.ValueDef> {
        val declaredType = typedValueDef.typespec_.accept(TypeSpec2TypeReference, Unit)
        return visitValueDef(typedValueDef.jid_, declaredType, typedValueDef.expr_, fileSymbolTableBuilder)
    }

    private fun visitValueDef(id: String, declaredType: TypeReference?, initializer: Expr,
                              fileSymbolTableBuilder: FileSymbolTableBuilder):
            Either<SemanticError, Def.ValueDef> {
        if (!NameValidator.validValueName(id))
            return Either.Left(SemanticError.InvalidName(id))
        val astInitializer = initializer.accept(ParseTree2AstExprVisitor, Unit)
        return if (fileSymbolTableBuilder.noteSimpleValueDeclaration(id, declaredType, astInitializer))
            Either.Right(Def.ValueDef.SimpleValueDef(id, declaredType, astInitializer))
        else
            Either.Left(SemanticError.DuplicateDefinition(id))
    }
}
