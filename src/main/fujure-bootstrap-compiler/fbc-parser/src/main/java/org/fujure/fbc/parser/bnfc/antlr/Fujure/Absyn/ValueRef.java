package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class ValueRef extends ValRef {
  public final ListValRefFragm listvalreffragm_;
  public ValueRef(ListValRefFragm p1) { listvalreffragm_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef) {
      org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef x = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef)o;
      return this.listvalreffragm_.equals(x.listvalreffragm_);
    }
    return false;
  }

  public int hashCode() {
    return this.listvalreffragm_.hashCode();
  }


}