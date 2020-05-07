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
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef,A>,
  org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg.Visitor<org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg,A>,
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
    public Defs visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs p, A arg)
    {
      ListDef listdef_ = new ListDef();
      for (Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs(listdef_);
    }
/* Def */
    public Def visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg)
    {
      Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef(binding_);
    }    public Def visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef p, A arg)
    {
      FuncDecl funcdecl_ = p.funcdecl_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef(funcdecl_);
    }
/* FuncDecl */
    public FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      ListParam listparam_ = new ListParam();
      for (Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl(jid_, listparam_);
    }    public FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      ListParam listparam_ = new ListParam();
      for (Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl(jid_, listparam_, typedesc_);
    }    public FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      ListParam listparam_ = new ListParam();
      for (Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl(jid_, listparam_, expr_);
    }    public FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      ListParam listparam_ = new ListParam();
      for (Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl(jid_, listparam_, typedesc_, expr_);
    }
/* Param */
    public Param visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam p, A arg)
    {
      Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam(binding_);
    }
/* Binding */
    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(jid_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding p, A arg)
    {
      String jid_ = p.jid_;
      TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(jid_, typedesc_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding p, A arg)
    {
      String jid_ = p.jid_;
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(jid_, expr_);
    }    public Binding visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding p, A arg)
    {
      String jid_ = p.jid_;
      TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding(jid_, typedesc_, expr_);
    }
/* TypeDesc */
    public TypeDesc visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc p, A arg)
    {
      SimpleType simpletype_ = p.simpletype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc(simpletype_);
    }    public TypeDesc visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc p, A arg)
    {
      FuncType functype_ = p.functype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc(functype_);
    }
/* FuncType */
    public FuncType visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType p, A arg)
    {
      FuncTypeFragm functypefragm_ = p.functypefragm_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType(functypefragm_);
    }    public FuncType visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType p, A arg)
    {
      FuncTypeFragm functypefragm_ = p.functypefragm_.accept(this, arg);
      ListFuncTypeFragm listfunctypefragm_ = new ListFuncTypeFragm();
      for (FuncTypeFragm x : p.listfunctypefragm_)
      {
        listfunctypefragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType(functypefragm_, listfunctypefragm_);
    }
/* FuncTypeFragm */
    public FuncTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm p, A arg)
    {
      SimpleType simpletype_ = p.simpletype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm(simpletype_);
    }    public FuncTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm p, A arg)
    {
      FuncType functype_ = p.functype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm(functype_);
    }
/* SimpleType */
    public SimpleType visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType p, A arg)
    {
      ListSimpleTypeFragm listsimpletypefragm_ = new ListSimpleTypeFragm();
      for (SimpleTypeFragm x : p.listsimpletypefragm_)
      {
        listsimpletypefragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType(listsimpletypefragm_);
    }
/* SimpleTypeFragm */
    public SimpleTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm(jid_);
    }
/* Expr */
    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr(expr_1, expr_2, expr_3);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr p, A arg)
    {
      ListLetDef listletdef_ = new ListLetDef();
      for (LetDef x : p.listletdef_)
      {
        listletdef_.add(x.accept(this,arg));
      }
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr(listletdef_, expr_);
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
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr(expr_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr(expr_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr p, A arg)
    {
      String jid_1 = p.jid_1;
      String jid_2 = p.jid_2;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr(jid_1, jid_2);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      String jid_ = p.jid_;
      ListCallArg listcallarg_ = new ListCallArg();
      for (CallArg x : p.listcallarg_)
      {
        listcallarg_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr(expr_, jid_, listcallarg_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      ListCallArg listcallarg_ = new ListCallArg();
      for (CallArg x : p.listcallarg_)
      {
        listcallarg_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr(expr_, listcallarg_);
    }    public Expr visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr(jid_);
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
/* CallArg */
    public CallArg visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg(expr_);
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