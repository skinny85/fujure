package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class GenericSimpleType  extends SimpleType {
  public final ListSimpleTypeFragm listsimpletypefragm_;
  public final ListGenericTypeValue listgenerictypevalue_;
  public GenericSimpleType(ListSimpleTypeFragm p1, ListGenericTypeValue p2) { listsimpletypefragm_ = p1; listgenerictypevalue_ = p2; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType)o;
      return this.listsimpletypefragm_.equals(x.listsimpletypefragm_) && this.listgenerictypevalue_.equals(x.listgenerictypevalue_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.listsimpletypefragm_.hashCode())+this.listgenerictypevalue_.hashCode();
  }


}
