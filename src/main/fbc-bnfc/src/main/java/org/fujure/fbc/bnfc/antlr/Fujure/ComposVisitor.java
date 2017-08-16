package org.fujure.fbc.bnfc.antlr.Fujure;
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef,A>
{
/* ValDef */
    public ValDef visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef(ident_, integer_);
    }
}