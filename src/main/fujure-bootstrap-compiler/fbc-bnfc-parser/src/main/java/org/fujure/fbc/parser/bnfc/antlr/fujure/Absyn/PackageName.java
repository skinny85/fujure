package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public class PackageName  extends PkgName {
  public final ListPkgFragm listpkgfragm_;
  public PackageName(ListPkgFragm p1) { listpkgfragm_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName) {
      org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName x = (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName)o;
      return this.listpkgfragm_.equals(x.listpkgfragm_);
    }
    return false;
  }

  public int hashCode() {
    return this.listpkgfragm_.hashCode();
  }


}
