package org.fujure.fjc.bnfc.antlr.Fujure;
import org.fujure.fjc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef.Visitor<org.fujure.fjc.bnfc.antlr.Fujure.Absyn.ValueDef,A>
{
/* ValueDef */
    public ValueDef visit(org.fujure.fjc.bnfc.antlr.Fujure.Absyn.VDef p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;
      return new org.fujure.fjc.bnfc.antlr.Fujure.Absyn.VDef(ident_, integer_);
    }
}