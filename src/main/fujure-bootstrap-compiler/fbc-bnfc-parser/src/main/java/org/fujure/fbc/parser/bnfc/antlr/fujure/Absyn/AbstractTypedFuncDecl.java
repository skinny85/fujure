package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class AbstractTypedFuncDecl  extends FuncDecl {
  public final String jid_;
  public final ListParam listparam_;
  public final TypeDesc typedesc_;
  public AbstractTypedFuncDecl(String p1, ListParam p2, TypeDesc p3) { jid_ = p1; listparam_ = p2; typedesc_ = p3; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl)o;
      return this.jid_.equals(x.jid_) && this.listparam_.equals(x.listparam_) && this.typedesc_.equals(x.typedesc_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.jid_.hashCode())+this.listparam_.hashCode())+this.typedesc_.hashCode();
  }


}
