package org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn; // Java Package generated by the BNF Converter.

public class BoolFalseLiteral extends Literal {
  public BoolFalseLiteral() { }

  public <R,A> R accept(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
