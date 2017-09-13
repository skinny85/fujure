package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal,A>
{
/* FileContents */
    public FileContents visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg)
    {
      PkgName pkgname_ = p.pkgname_.accept(this, arg);
      Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(pkgname_, defs_);
    }    public FileContents visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg)
    {
      Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage(defs_);
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
      String ident_ = p.ident_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment(ident_);
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
    public Def visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg)
    {
      ValDef valdef_ = p.valdef_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef(valdef_);
    }
/* ValDef */
    public ValDef visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg)
    {
      String ident_ = p.ident_;
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef(ident_, expr_);
    }    public ValDef visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg)
    {
      String ident_ = p.ident_;
      TypeSpec typespec_ = p.typespec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef(ident_, typespec_, expr_);
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
      String ident_ = p.ident_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment(ident_);
    }
/* Expr */
    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral p, A arg)
    {
      Literal literal_ = p.literal_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral(literal_);
    }
/* Literal */
    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg)
    {
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(integer_);
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral();
    }    public Literal visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral();
    }
}