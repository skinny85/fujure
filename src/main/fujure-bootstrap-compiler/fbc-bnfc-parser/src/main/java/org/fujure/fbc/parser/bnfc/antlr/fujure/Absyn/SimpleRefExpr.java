package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class SimpleRefExpr  extends Expr {
  public final String jid_;
  public SimpleRefExpr(String p1) { jid_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr)o;
      return this.jid_.equals(x.jid_);
    }
    return false;
  }

  public int hashCode() {
    return this.jid_.hashCode();
  }


}
