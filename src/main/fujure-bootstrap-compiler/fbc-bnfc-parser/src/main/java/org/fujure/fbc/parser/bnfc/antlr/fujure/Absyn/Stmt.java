package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class Stmt implements java.io.Serializable {
  public abstract <R,A> R accept(Stmt.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprStmt p, A arg);

  }

}
