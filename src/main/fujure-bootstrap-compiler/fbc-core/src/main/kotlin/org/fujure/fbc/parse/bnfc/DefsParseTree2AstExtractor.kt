package org.fujure.fbc.parse.bnfc

import org.fujure.fbc.ast.Def
import org.fujure.fbc.ast.Def.ValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def as AbsynDef
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr as AbsynExpr

internal object DefsParseTree2AstExtractor :
        FileContents.Visitor<List<Def>, Unit>,
        Defs.Visitor<List<Def>, Unit>,
        AbsynDef.Visitor<Def, Unit>,
        FuncDecl.Visitor<ValueDef.FunctionValueDef, Unit>,
        Param.Visitor<ValueDef.SimpleValueDef, Unit>,
        Binding.Visitor<ValueDef.SimpleValueDef, Unit> {
    override fun visit(fileContents: FileInDefaultPackage, arg: Unit): List<Def> {
        return fileContents.defs_.accept(this, arg)
    }

    override fun visit(fileContents: FileInNamedPackage, arg: Unit): List<Def> {
        return fileContents.defs_.accept(this, arg)
    }

    override fun visit(defListDefs: DefListDefs, arg: Unit): List<Def> {
        return defListDefs.listdef_.map { def -> def.accept(this, arg) }
    }

    override fun visit(simpleValueDef: SimpleValueDef, arg: Unit): Def {
        return simpleValueDef.binding_.accept(this, arg)
    }

    override fun visit(functionValueDef: FunctionValueDef, arg: Unit): Def {
        return functionValueDef.funcdecl_.accept(this, arg)
    }

    override fun visit(funcDecl: AbstractTypelessFuncDecl, arg: Unit): ValueDef.FunctionValueDef {
        return toFuncAstDefinition(funcDecl.jid_, funcDecl.listparam_, null, null)
    }

    override fun visit(funcDecl: AbstractTypedFuncDecl, arg: Unit): ValueDef.FunctionValueDef {
        return toFuncAstDefinition(funcDecl.jid_, funcDecl.listparam_, funcDecl.typedesc_, null)
    }

    override fun visit(funcDecl: ConcreteTypelessFuncDecl, arg: Unit): ValueDef.FunctionValueDef {
        return toFuncAstDefinition(funcDecl.jid_, funcDecl.listparam_, null, funcDecl.expr_)
    }

    override fun visit(funcDecl: ConcreteTypedFuncDecl, arg: Unit): ValueDef.FunctionValueDef {
        return toFuncAstDefinition(funcDecl.jid_, funcDecl.listparam_, funcDecl.typedesc_, funcDecl.expr_)
    }

    private fun toFuncAstDefinition(id: String, params: List<Param>, returnType: TypeDesc?,
            body: AbsynExpr?): ValueDef.FunctionValueDef {
        val astReturnType = returnType?.accept(TypeDesc2TypeReference, Unit)
        val astBody = body?.accept(ExprParseTree2AstVisitor, Unit)
        return ValueDef.FunctionValueDef(id,
                params.map { it.accept(this, Unit) },
                astReturnType, astBody)
    }

    override fun visit(param: BindingParam, arg: Unit): ValueDef.SimpleValueDef {
        return param.binding_.accept(this, arg)
    }

    override fun visit(binding: OnlyNameBinding, arg: Unit): ValueDef.SimpleValueDef {
        return bindingToAstDefinition(binding.jid_, null, null)
    }

    override fun visit(binding: NameTypeBinding, arg: Unit): ValueDef.SimpleValueDef {
        return bindingToAstDefinition(binding.jid_, binding.typedesc_, null)
    }

    override fun visit(binding: NameInitBinding, arg: Unit): ValueDef.SimpleValueDef {
        return bindingToAstDefinition(binding.jid_, null, binding.expr_)
    }

    override fun visit(binding: FullBinding, arg: Unit): ValueDef.SimpleValueDef {
        return bindingToAstDefinition(binding.jid_, binding.typedesc_, binding.expr_)
    }

    private fun bindingToAstDefinition(id: String, declaredType: TypeDesc?, initializer: AbsynExpr?):
            ValueDef.SimpleValueDef {
        val astDeclaredType = declaredType?.accept(TypeDesc2TypeReference, Unit)
        val astInitializer = initializer?.accept(ExprParseTree2AstVisitor, Unit)
        return ValueDef.SimpleValueDef(id, astDeclaredType, astInitializer)
    }
}
