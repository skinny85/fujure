package org.fujure.fbc.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class TypedValueDef extends ValDef {
  public final String ident_;
  public final TypeSpec typespec_;
  public final Integer integer_;
  public TypedValueDef(String p1, TypeSpec p2, Integer p3) { ident_ = p1; typespec_ = p2; integer_ = p3; }

  public <R,A> R accept(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef) {
      org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef x = (org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef)o;
      return this.ident_.equals(x.ident_) && this.typespec_.equals(x.typespec_) && this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_.hashCode())+this.typespec_.hashCode())+this.integer_.hashCode();
  }


}
