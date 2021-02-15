package org.fujure.fbc.parser.bnfc.antlr.fujure;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* FileContents */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage p, A arg) {
      R r = leaf(arg);
      r = combine(p.pkgname_.accept(this, arg), r, arg);
      r = combine(p.imports_.accept(this, arg), r, arg);
      r = combine(p.defs_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage p, A arg) {
      R r = leaf(arg);
      r = combine(p.imports_.accept(this, arg), r, arg);
      r = combine(p.defs_.accept(this, arg), r, arg);
      return r;
    }

/* PkgName */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm x : p.listpkgfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* PkgFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Imports */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import x : p.listimport_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Import */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm x : p.listimportfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* ImportFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Defs */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def x : p.listdef_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef p, A arg) {
      R r = leaf(arg);
      r = combine(p.binding_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef p, A arg) {
      R r = leaf(arg);
      r = combine(p.funcdecl_.accept(this, arg), r, arg);
      return r;
    }

/* FuncDecl */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.typedesc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x : p.listparam_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.typedesc_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* Param */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam p, A arg) {
      R r = leaf(arg);
      r = combine(p.binding_.accept(this, arg), r, arg);
      return r;
    }

/* Binding */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.typedesc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.typedesc_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* TypeDesc */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc p, A arg) {
      R r = leaf(arg);
      r = combine(p.simpletype_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc p, A arg) {
      R r = leaf(arg);
      r = combine(p.functype_.accept(this, arg), r, arg);
      return r;
    }

/* FuncType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType p, A arg) {
      R r = leaf(arg);
      r = combine(p.functypefragm_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType p, A arg) {
      R r = leaf(arg);
      r = combine(p.functypefragm_.accept(this, arg), r, arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm x : p.listfunctypefragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* FuncTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm p, A arg) {
      R r = leaf(arg);
      r = combine(p.simpletype_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm p, A arg) {
      R r = leaf(arg);
      r = combine(p.functype_.accept(this, arg), r, arg);
      return r;
    }

/* SimpleType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x : p.listsimpletypefragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x : p.listsimpletypefragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue x : p.listgenerictypevalue_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* SimpleTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* GenericTypeValue */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue p, A arg) {
      R r = leaf(arg);
      r = combine(p.typedesc_.accept(this, arg), r, arg);
      return r;
    }

/* Expr */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      r = combine(p.expr_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr p, A arg) {
      R r = leaf(arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef x : p.listletdef_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x : p.listcallarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x : p.listcallarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.literal_.accept(this, arg), r, arg);
      return r;
    }

/* LetDef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition p, A arg) {
      R r = leaf(arg);
      r = combine(p.binding_.accept(this, arg), r, arg);
      return r;
    }

/* CallArg */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* Literal */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
