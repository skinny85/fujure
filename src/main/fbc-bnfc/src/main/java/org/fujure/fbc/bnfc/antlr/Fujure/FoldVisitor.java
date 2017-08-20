package org.fujure.fbc.bnfc.antlr.Fujure;

import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* FileContents */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg) {
      R r = leaf(arg);
      for (PkgFragm x : p.listpkgfragm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.valdef_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg) {
      R r = leaf(arg);
      r = combine(p.valdef_.accept(this, arg), r, arg);
      return r;
    }

/* PkgFragm */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* ValDef */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
