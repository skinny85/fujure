package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class Def implements java.io.Serializable {
  public abstract <R,A> R accept(Def.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef p, A arg);

  }

}
