package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class FuncDecl implements java.io.Serializable {
  public abstract <R,A> R accept(FuncDecl.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl p, A arg);

  }

}
