package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class PositateExpr  extends Expr {
  public final Expr expr_;
  public PositateExpr(Expr p1) { expr_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
