package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class Defs implements java.io.Serializable {
  public abstract <R,A> R accept(Defs.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs p, A arg);

  }

}
