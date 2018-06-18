package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.TypeReference
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
import org.fujure.fbc.ast.FileContents as AstFileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef

internal object DefsParseTree2AstExtractor :
        FileContents.Visitor<List<Def>, Unit>,
        Defs.Visitor<List<Def>, Unit>,
        AbsynDef.Visitor<Def, Unit>,
        ValDef.Visitor<Def, Unit> {
    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): List<Def> {
        return visitDefs(fileContents.defs_)
    }

    override fun visit(fileContents: FileInNamedPackage, arg: Unit): List<Def>? {
        return visitDefs(fileContents.defs_)
    }

    private fun visitDefs(defs: Defs) = defs.accept(this, Unit)

    override fun visit(definitions: Definitions, arg: Unit): List<Def> {
        return definitions.listdef_.map { def -> def.accept(this, arg) }
    }

    override fun visit(valueDef: ValueDef, arg: Unit): Def {
        return valueDef.valdef_.accept(this, arg)
    }

    override fun visit(untypedValueDef: UntypedValueDef, arg: Unit): Def {
        return visitValueDef(untypedValueDef.jid_, null, untypedValueDef.expr_, arg)
    }

    override fun visit(typedValueDef: TypedValueDef, arg: Unit): Def {
        val declaredType = typedValueDef.typespec_.accept(TypeSpec2TypeReference, Unit)
        return visitValueDef(typedValueDef.jid_, declaredType, typedValueDef.expr_, arg)
    }

    private fun visitValueDef(id: String, declaredType: TypeReference?, initializer: Expr, arg: Unit): Def {
        val astInitializer = initializer.accept(ExprParseTree2AstVisitor, arg)
        return Def.ValueDef.SimpleValueDef(id, declaredType, astInitializer)
    }
}
