package org.fujure.fbc.bnfc.antlr.Fujure;

import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* ValDef */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
