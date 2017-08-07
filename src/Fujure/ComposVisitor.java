package Fujure;
import Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  Fujure.Absyn.ValueDef.Visitor<Fujure.Absyn.ValueDef,A>
{
/* ValueDef */
    public ValueDef visit(Fujure.Absyn.VDef p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;
      return new Fujure.Absyn.VDef(ident_, integer_);
    }
}