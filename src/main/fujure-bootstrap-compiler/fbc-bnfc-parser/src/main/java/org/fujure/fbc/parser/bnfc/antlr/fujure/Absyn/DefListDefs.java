package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class DefListDefs  extends Defs {
  public final ListDef listdef_;
  public DefListDefs(ListDef p1) { listdef_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs)o;
      return this.listdef_.equals(x.listdef_);
    }
    return false;
  }

  public int hashCode() {
    return this.listdef_.hashCode();
  }


}
