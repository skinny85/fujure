package org.fujure.fbc.bnfc.antlr.Fujure;
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef,A>
{
/* FileContents */
    public FileContents visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg)
    {
      ListPkgFragm listpkgfragm_ = new ListPkgFragm();
      for (PkgFragm x : p.listpkgfragm_)
      {
        listpkgfragm_.add(x.accept(this,arg));
      }
      ListValDef listvaldef_ = new ListValDef();
      for (ValDef x : p.listvaldef_)
      {
        listvaldef_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(listpkgfragm_, listvaldef_);
    }    public FileContents visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg)
    {
      ListValDef listvaldef_ = new ListValDef();
      for (ValDef x : p.listvaldef_)
      {
        listvaldef_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage(listvaldef_);
    }
/* PkgFragm */
    public PkgFragm visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg)
    {
      String ident_ = p.ident_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment(ident_);
    }
/* ValDef */
    public ValDef visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef(ident_, integer_);
    }
}