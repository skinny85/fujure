package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class FuncCallExpr  extends Expr {
  public final Expr expr_;
  public final ListCallArg listcallarg_;
  public FuncCallExpr(Expr p1, ListCallArg p2) { expr_ = p1; listcallarg_ = p2; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr)o;
      return this.expr_.equals(x.expr_) && this.listcallarg_.equals(x.listcallarg_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.expr_.hashCode())+this.listcallarg_.hashCode();
  }


}
