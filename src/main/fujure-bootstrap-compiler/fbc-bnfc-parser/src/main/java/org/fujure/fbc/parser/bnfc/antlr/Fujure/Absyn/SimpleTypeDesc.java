package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class SimpleTypeDesc extends TypeDesc {
  public final SimpleType simpletype_;
  public SimpleTypeDesc(SimpleType p1) { simpletype_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc) {
      org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc x = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc)o;
      return this.simpletype_.equals(x.simpletype_);
    }
    return false;
  }

  public int hashCode() {
    return this.simpletype_.hashCode();
  }


}
