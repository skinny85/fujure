package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class FileInDefaultPackage extends FileContents {
  public final Imports imports_;
  public final Defs defs_;
  public FileInDefaultPackage(Imports p1, Defs p2) { imports_ = p1; defs_ = p2; }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage) {
      org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage x = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage)o;
      return this.imports_.equals(x.imports_) && this.defs_.equals(x.defs_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.imports_.hashCode())+this.defs_.hashCode();
  }


}
