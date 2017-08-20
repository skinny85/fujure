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
  public class FileContentsVisitor<R,A> implements FileContents.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg)
    { /* Code For FileInNamedPackage Goes Here */
      for (PkgFragm x: p.listpkgfragm_)
      { /* ... */ }
      p.valdef_.accept(new ValDefVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg)
    { /* Code For FileInDefaultPackage Goes Here */
      p.valdef_.accept(new ValDefVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PkgFragmVisitor<R,A> implements PkgFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg)
    { /* Code For PackageFragment Goes Here */
      //p.ident_;
      return null;
    }
  }
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