package org.fujure.fbc.parser.bnfc.antlr.Fujure;

import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* FileContents */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg) {
      R r = leaf(arg);
      r = combine(p.pkgname_.accept(this, arg), r, arg);
      r = combine(p.imports_.accept(this, arg), r, arg);
      r = combine(p.defs_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg) {
      R r = leaf(arg);
      r = combine(p.imports_.accept(this, arg), r, arg);
      r = combine(p.defs_.accept(this, arg), r, arg);
      return r;
    }

/* PkgName */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName p, A arg) {
      R r = leaf(arg);
      for (PkgFragm x : p.listpkgfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* PkgFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Imports */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts p, A arg) {
      R r = leaf(arg);
      for (Import x : p.listimport_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Import */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt p, A arg) {
      R r = leaf(arg);
      for (ImportFragm x : p.listimportfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* ImportFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Defs */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions p, A arg) {
      R r = leaf(arg);
      for (Def x : p.listdef_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg) {
      R r = leaf(arg);
      r = combine(p.binding_.accept(this, arg), r, arg);
      return r;
    }

/* Binding */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.typespec_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding p, A arg) {
      R r = leaf(arg);
      r = combine(p.typespec_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* TypeSpec */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg) {
      R r = leaf(arg);
      for (TypeSpecFragm x : p.listtypespecfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* TypeSpecFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Expr */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.valref_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.literal_.accept(this, arg), r, arg);
      return r;
    }

/* ValRef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef p, A arg) {
      R r = leaf(arg);
      for (ValRefFragm x : p.listvalreffragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* ValRefFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Literal */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
