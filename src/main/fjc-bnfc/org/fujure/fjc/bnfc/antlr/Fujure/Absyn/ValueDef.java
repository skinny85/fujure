package org.fujure.fjc.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class ValueDef implements java.io.Serializable {
  public abstract <R,A> R accept(ValueDef.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fjc.bnfc.antlr.Fujure.Absyn.VDef p, A arg);

  }

}