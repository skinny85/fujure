package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class FragmSimpleType  extends SimpleType {
  public final ListSimpleTypeFragm listsimpletypefragm_;
  public FragmSimpleType(ListSimpleTypeFragm p1) { listsimpletypefragm_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType)o;
      return this.listsimpletypefragm_.equals(x.listsimpletypefragm_);
    }
    return false;
  }

  public int hashCode() {
    return this.listsimpletypefragm_.hashCode();
  }


}
