package org.fujure.fjc.bnfc.antlr.Fujure;
import org.fujure.fjc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* ValueDef */
    public R visit(org.fujure.fjc.bnfc.antlr.Fujure.Absyn.VDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
