package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class ValRefFragm implements java.io.Serializable {
  public abstract <R,A> R accept(ValRefFragm.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment p, A arg);

  }

}