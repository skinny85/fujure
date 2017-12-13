package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;
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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg)
    { /* Code For FileInNamedPackage Goes Here */
      p.pkgname_.accept(new PkgNameVisitor<R,A>(), arg);
      p.imports_.accept(new ImportsVisitor<R,A>(), arg);
      p.defs_.accept(new DefsVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg)
    { /* Code For FileInDefaultPackage Goes Here */
      p.imports_.accept(new ImportsVisitor<R,A>(), arg);
      p.defs_.accept(new DefsVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PkgNameVisitor<R,A> implements PkgName.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName p, A arg)
    { /* Code For PackageName Goes Here */
      for (PkgFragm x: p.listpkgfragm_)
      { /* ... */ }
      return null;
    }
  }
  public class PkgFragmVisitor<R,A> implements PkgFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg)
    { /* Code For PackageFragment Goes Here */
      //p.jid_;
      return null;
    }
  }
  public class ImportsVisitor<R,A> implements Imports.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts p, A arg)
    { /* Code For ImportStmts Goes Here */
      for (Import x: p.listimport_)
      { /* ... */ }
      return null;
    }
  }
  public class ImportVisitor<R,A> implements Import.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt p, A arg)
    { /* Code For ImportStmt Goes Here */
      for (ImportFragm x: p.listimportfragm_)
      { /* ... */ }
      return null;
    }
  }
  public class ImportFragmVisitor<R,A> implements ImportFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment p, A arg)
    { /* Code For ImportFragment Goes Here */
      //p.jid_;
      return null;
    }
  }
  public class DefsVisitor<R,A> implements Defs.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions p, A arg)
    { /* Code For Definitions Goes Here */
      for (Def x: p.listdef_)
      { /* ... */ }
      return null;
    }
  }
  public class DefVisitor<R,A> implements Def.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg)
    { /* Code For ValueDef Goes Here */
      p.valdef_.accept(new ValDefVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ValDefVisitor<R,A> implements ValDef.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg)
    { /* Code For UntypedValueDef Goes Here */
      //p.jid_;
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg)
    { /* Code For TypedValueDef Goes Here */
      //p.jid_;
      p.typespec_.accept(new TypeSpecVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeSpecVisitor<R,A> implements TypeSpec.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg)
    { /* Code For TypeSpecifier Goes Here */
      for (TypeSpecFragm x: p.listtypespecfragm_)
      { /* ... */ }
      return null;
    }
  }
  public class TypeSpecFragmVisitor<R,A> implements TypeSpecFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg)
    { /* Code For TypeSpecFragment Goes Here */
      //p.jid_;
      return null;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr p, A arg)
    { /* Code For VariableExpr Goes Here */
      p.valref_.accept(new ValRefVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr p, A arg)
    { /* Code For LiteralExpr Goes Here */
      p.literal_.accept(new LiteralVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ValRefVisitor<R,A> implements ValRef.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef p, A arg)
    { /* Code For ValueRef Goes Here */
      for (ValRefFragm x: p.listvalreffragm_)
      { /* ... */ }
      return null;
    }
  }
  public class ValRefFragmVisitor<R,A> implements ValRefFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment p, A arg)
    { /* Code For ValueRefFragment Goes Here */
      //p.jid_;
      return null;
    }
  }
  public class LiteralVisitor<R,A> implements Literal.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg)
    { /* Code For IntLiteral Goes Here */
      //p.integer_;
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral p, A arg)
    { /* Code For UnitLiteral Goes Here */
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg)
    { /* Code For BoolTrueLiteral Goes Here */
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg)
    { /* Code For BoolFalseLiteral Goes Here */
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral p, A arg)
    { /* Code For CharLiteral Goes Here */
      //p.jchar_;
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral p, A arg)
    { /* Code For StringLiteral Goes Here */
      //p.jstring_;
      return null;
    }
  }
}