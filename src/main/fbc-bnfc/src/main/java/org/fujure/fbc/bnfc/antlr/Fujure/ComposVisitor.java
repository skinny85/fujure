package org.fujure.fbc.bnfc.antlr.Fujure;
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpec.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpec,A>,
  org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragm.Visitor<org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragm,A>
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
    public ValDef visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.UntypedValueDef(ident_, integer_);
    }    public ValDef visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg)
    {
      String ident_ = p.ident_;
      TypeSpec typespec_ = p.typespec_.accept(this, arg);
      Integer integer_ = p.integer_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef(ident_, typespec_, integer_);
    }
/* TypeSpec */
    public TypeSpec visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg)
    {
      ListTypeSpecFragm listtypespecfragm_ = new ListTypeSpecFragm();
      for (TypeSpecFragm x : p.listtypespecfragm_)
      {
        listtypespecfragm_.add(x.accept(this,arg));
      }
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecifier(listtypespecfragm_);
    }
/* TypeSpecFragm */
    public TypeSpecFragm visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg)
    {
      String ident_ = p.ident_;
      return new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragment(ident_);
    }
}