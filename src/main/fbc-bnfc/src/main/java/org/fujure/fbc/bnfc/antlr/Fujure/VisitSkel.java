package org.fujure.fbc.bnfc.antlr.Fujure;
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ValDefVisitor<R,A> implements ValDef.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg)
    { /* Code For ValueDef Goes Here */
      //p.ident_;
      //p.integer_;
      return null;
    }
  }
}