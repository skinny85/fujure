package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class PackageFragment extends PkgFragm {
  public final String jid_;
  public PackageFragment(String p1) { jid_ = p1; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment) {
      org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment x = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment)o;
      return this.jid_.equals(x.jid_);
    }
    return false;
  }

  public int hashCode() {
    return this.jid_.hashCode();
  }


}
