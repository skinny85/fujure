package org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn; // Java Package generated by the BNF Converter.

public abstract class SimpleType implements java.io.Serializable {
  public abstract <R,A> R accept(SimpleType.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType p, A arg);
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType p, A arg);

  }

}
