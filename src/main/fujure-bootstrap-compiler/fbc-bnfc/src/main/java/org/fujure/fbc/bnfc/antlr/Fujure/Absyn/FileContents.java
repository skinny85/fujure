package org.fujure.fbc.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class FileContents implements java.io.Serializable {
  public abstract <R,A> R accept(FileContents.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg);
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg);

  }

}