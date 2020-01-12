package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Def.ValueDef
import org.fujure.fbc.ast.TypeReference
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef

internal object DefsParseTree2AstExtractor :
        FileContents.Visitor<List<Def>, Unit>,
        Defs.Visitor<List<Def>, Unit>,
        AbsynDef.Visitor<Def, Unit>,
        LetDef.Visitor<ValueDef, Unit>,
        Binding.Visitor<Def, Unit> {
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

    override fun visit(simpleValueDef: SimpleValueDef, arg: Unit): Def {
        return simpleValueDef.binding_.accept(this, arg)
    }

    override fun visit(letDefinition: LetDefinition, arg: Unit): ValueDef {
        val ret = letDefinition.binding_.accept(this, arg)
        return when (ret) {
            is ValueDef -> ret
        }
    }

    override fun visit(binding: OnlyNameBinding, arg: Unit): Def {
        return toAstDefinition(binding.jid_, null, null, arg)
    }

    override fun visit(binding: NameTypeBinding, arg: Unit): Def {
        val declaredType = binding.typedesc_.accept(TypeDesc2TypeReference, arg)
        return toAstDefinition(binding.jid_, declaredType, null, arg)
    }

    override fun visit(binding: NameInitBinding, arg: Unit): Def {
        return toAstDefinition(binding.jid_, null, binding.expr_, arg)
    }

    override fun visit(binding: FullBinding, arg: Unit): Def {
        val declaredType = binding.typedesc_.accept(TypeDesc2TypeReference, arg)
        return toAstDefinition(binding.jid_, declaredType, binding.expr_, arg)
    }

    private fun toAstDefinition(id: String, declaredType: TypeReference?, initializer: Expr?, arg: Unit): Def {
        val astInitializer = initializer?.accept(ExprParseTree2AstVisitor, arg)
        return ValueDef.SimpleValueDef(id, declaredType, astInitializer)
    }
}
