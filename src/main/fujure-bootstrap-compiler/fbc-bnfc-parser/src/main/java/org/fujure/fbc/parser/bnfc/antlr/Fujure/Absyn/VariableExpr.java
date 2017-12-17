package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class VariableExpr extends Expr {
  public final ValRef valref_;
  public VariableExpr(ValRef p1) { valref_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr) {
      org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr x = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr)o;
      return this.valref_.equals(x.valref_);
    }
    return false;
  }

  public int hashCode() {
    return this.valref_.hashCode();
  }


}