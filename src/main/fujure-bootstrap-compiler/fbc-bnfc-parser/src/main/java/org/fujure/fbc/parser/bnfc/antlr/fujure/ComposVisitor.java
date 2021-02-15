package org.fujure.fbc.parser.bnfc.antlr.fujure;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg,A>,
  org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal.Visitor<org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal,A>
{
    /* FileContents */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName pkgname_ = p.pkgname_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports imports_ = p.imports_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage(pkgname_, imports_, defs_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports imports_ = p.imports_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs defs_ = p.defs_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage(imports_, defs_);
    }

    /* PkgName */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm listpkgfragm_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm x : p.listpkgfragm_)
      {
        listpkgfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName(listpkgfragm_);
    }

    /* PkgFragm */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment(jid_);
    }

    /* Imports */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport listimport_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import x : p.listimport_)
      {
        listimport_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts(listimport_);
    }

    /* Import */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm listimportfragm_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm x : p.listimportfragm_)
      {
        listimportfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt(listimportfragm_);
    }

    /* ImportFragm */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment(jid_);
    }

    /* Defs */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef listdef_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs(listdef_);
    }

    /* Def */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef(binding_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl funcdecl_ = p.funcdecl_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef(funcdecl_);
    }

    /* FuncDecl */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam listparam_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl(jid_, listparam_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam listparam_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl(jid_, listparam_, typedesc_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam listparam_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl(jid_, listparam_, expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam listparam_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        listparam_.add(x.accept(this,arg));
      }
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl(jid_, listparam_, typedesc_, expr_);
    }

    /* Param */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam(binding_);
    }

    /* Binding */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding(jid_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding(jid_, typedesc_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding(jid_, expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding p, A arg)
    {
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding(jid_, typedesc_, expr_);
    }

    /* TypeDesc */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType simpletype_ = p.simpletype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc(simpletype_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType functype_ = p.functype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc(functype_);
    }

    /* FuncType */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm functypefragm_ = p.functypefragm_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType(functypefragm_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm functypefragm_ = p.functypefragm_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm listfunctypefragm_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm x : p.listfunctypefragm_)
      {
        listfunctypefragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType(functypefragm_, listfunctypefragm_);
    }

    /* FuncTypeFragm */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType simpletype_ = p.simpletype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm(simpletype_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType functype_ = p.functype_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm(functype_);
    }

    /* SimpleType */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm listsimpletypefragm_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x : p.listsimpletypefragm_)
      {
        listsimpletypefragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType(listsimpletypefragm_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm listsimpletypefragm_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x : p.listsimpletypefragm_)
      {
        listsimpletypefragm_.add(x.accept(this,arg));
      }
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue listgenerictypevalue_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue x : p.listgenerictypevalue_)
      {
        listgenerictypevalue_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType(listsimpletypefragm_, listgenerictypevalue_);
    }

    /* SimpleTypeFragm */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm(jid_);
    }

    /* GenericTypeValue */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc typedesc_ = p.typedesc_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue(typedesc_);
    }

    /* Expr */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_3 = p.expr_3.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr(expr_1, expr_2, expr_3);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef listletdef_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef x : p.listletdef_)
      {
        listletdef_.add(x.accept(this,arg));
      }
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr(listletdef_, expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_1 = p.expr_1.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_2 = p.expr_2.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr(expr_1, expr_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr(expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr(expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr(expr_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr p, A arg)
    {
      String jid_1 = p.jid_1;
      String jid_2 = p.jid_2;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr(jid_1, jid_2);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      String jid_ = p.jid_;
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg listcallarg_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x : p.listcallarg_)
      {
        listcallarg_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr(expr_, jid_, listcallarg_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg listcallarg_ = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg();
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x : p.listcallarg_)
      {
        listcallarg_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr(expr_, listcallarg_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr p, A arg)
    {
      String jid_ = p.jid_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr(jid_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal literal_ = p.literal_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr(literal_);
    }

    /* LetDef */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding binding_ = p.binding_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition(binding_);
    }

    /* CallArg */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg p, A arg)
    {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr expr_ = p.expr_.accept(this, arg);
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg(expr_);
    }

    /* Literal */
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral p, A arg)
    {
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral(integer_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral();
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral();
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral p, A arg)
    {
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral();
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral p, A arg)
    {
      String jchar_ = p.jchar_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral(jchar_);
    }
    public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral p, A arg)
    {
      String jstring_ = p.jstring_;
      return new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral(jstring_);
    }
}
