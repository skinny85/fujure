package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class ValDef implements java.io.Serializable {
  public abstract <R,A> R accept(ValDef.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg);

  }

}
