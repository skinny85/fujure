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
      r = combine(p.defs_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg) {
      R r = leaf(arg);
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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg) {
      R r = leaf(arg);
      r = combine(p.valdef_.accept(this, arg), r, arg);
      return r;
    }

/* ValDef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg) {
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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.literal_.accept(this, arg), r, arg);
      return r;
    }

/* Literal */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg) {
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


}
