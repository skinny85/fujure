package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class FuncFuncTypeFragm  extends FuncTypeFragm {
  public final FuncType functype_;
  public FuncFuncTypeFragm(FuncType p1) { functype_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm)o;
      return this.functype_.equals(x.functype_);
    }
    return false;
  }

  public int hashCode() {
    return this.functype_.hashCode();
  }


}
