package org.fujure.fjc.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class ValueDef extends ValDef {
  public final String ident_;
  public final Integer integer_;
  public ValueDef(String p1, Integer p2) { ident_ = p1; integer_ = p2; }

  public <R,A> R accept(org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef) {
      org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef x = (org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef)o;
      return this.ident_.equals(x.ident_) && this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.ident_.hashCode())+this.integer_.hashCode();
  }


}
