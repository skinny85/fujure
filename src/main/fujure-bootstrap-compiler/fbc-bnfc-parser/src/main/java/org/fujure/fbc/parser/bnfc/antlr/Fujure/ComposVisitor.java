package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal,A>
{
/* FileContents */
    public FileContents visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg)
    {
      PkgName pkgname_ = p.pkgname_.accept(this, arg);
      Imports imports_ = p.imports_.accept(this, arg);
      Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(pkgname_, imports_, defs_);
    }    public FileContents visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg)
    {
      Imports imports_ = p.imports_.accept(this, arg);
      Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage(imports_, defs_);
    }
/* PkgName */
    public PkgName visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName p, A arg)
    {
      ListPkgFragm listpkgfragm_ = new ListPkgFragm();
      for (PkgFragm x : p.listpkgfragm_)
      {
        listpkgfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName(listpkgfragm_);
    }
/* PkgFragm */
    public PkgFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment(jid_);
    }
/* Imports */
    public Imports visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts p, A arg)
    {
      ListImport listimport_ = new ListImport();
      for (Import x : p.listimport_)
      {
        listimport_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts(listimport_);
    }
/* Import */
    public Import visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt p, A arg)
    {
      ListImportFragm listimportfragm_ = new ListImportFragm();
      for (ImportFragm x : p.listimportfragm_)
      {
        listimportfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt(listimportfragm_);
    }
/* ImportFragm */
    public ImportFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment(jid_);
    }
/* Defs */
    public Defs visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions p, A arg)
    {
      ListDef listdef_ = new ListDef();
      for (Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions(listdef_);
    }
/* Def */
    public Def visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg)
    {
      Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef(binding_);
    }
/* Binding */
    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(jid_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding p, A arg)
    {
      String jid_ = p.jid_;
      TypeSpec typespec_ = p.typespec_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(jid_, typespec_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding p, A arg)
    {
      String jid_ = p.jid_;
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(jid_, expr_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding p, A arg)
    {
      String jid_ = p.jid_;
      TypeSpec typespec_ = p.typespec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding(jid_, typespec_, expr_);
    }
/* TypeSpec */
    public TypeSpec visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg)
    {
      ListTypeSpecFragm listtypespecfragm_ = new ListTypeSpecFragm();
      for (TypeSpecFragm x : p.listtypespecfragm_)
      {
        listtypespecfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier(listtypespecfragm_);
    }
/* TypeSpecFragm */
    public TypeSpecFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment(jid_);
    }
/* Expr */
    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr p, A arg)
    {
      ListLetDef listletdef_ = new ListLetDef();
      for (LetDef x : p.listletdef_)
      {
        listletdef_.add(x.accept(this,arg));
      }
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr(listletdef_, expr_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr(expr_1, expr_2, expr_3);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr(expr_1, expr_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr(expr_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr p, A arg)
    {
      ValRef valref_ = p.valref_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(valref_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr p, A arg)
    {
      Literal literal_ = p.literal_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(literal_);
    }
/* LetDef */
    public LetDef visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition p, A arg)
    {
      Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition(binding_);
    }
/* ValRef */
    public ValRef visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef p, A arg)
    {
      ListValRefFragm listvalreffragm_ = new ListValRefFragm();
      for (ValRefFragm x : p.listvalreffragm_)
      {
        listvalreffragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef(listvalreffragm_);
    }
/* ValRefFragm */
    public ValRefFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment(jid_);
    }
/* Literal */
    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg)
    {
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(integer_);
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral();
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral();
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral();
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral p, A arg)
    {
      String jchar_ = p.jchar_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(jchar_);
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral p, A arg)
    {
      String jstring_ = p.jstring_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral(jstring_);
    }
}