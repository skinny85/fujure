package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class SimpleFuncTypeFragm  extends FuncTypeFragm {
  public final SimpleType simpletype_;
  public SimpleFuncTypeFragm(SimpleType p1) { simpletype_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm)o;
      return this.simpletype_.equals(x.simpletype_);
    }
    return false;
  }

  public int hashCode() {
    return this.simpletype_.hashCode();
  }


}
