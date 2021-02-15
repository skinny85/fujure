package org.fujure.fbc.parser.bnfc.antlr.fujure;

/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class FileContentsVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage p, A arg)
    { /* Code for FileInNamedPackage goes here */
      p.pkgname_.accept(new PkgNameVisitor<R,A>(), arg);
      p.imports_.accept(new ImportsVisitor<R,A>(), arg);
      p.defs_.accept(new DefsVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage p, A arg)
    { /* Code for FileInDefaultPackage goes here */
      p.imports_.accept(new ImportsVisitor<R,A>(), arg);
      p.defs_.accept(new DefsVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PkgNameVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName p, A arg)
    { /* Code for PackageName goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm x: p.listpkgfragm_) {
        x.accept(new PkgFragmVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class PkgFragmVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment p, A arg)
    { /* Code for PackageFragment goes here */
      //p.jid_;
      return null;
    }
  }
  public class ImportsVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts p, A arg)
    { /* Code for ImportStmts goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import x: p.listimport_) {
        x.accept(new ImportVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class ImportVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt p, A arg)
    { /* Code for ImportStmt goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm x: p.listimportfragm_) {
        x.accept(new ImportFragmVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class ImportFragmVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment p, A arg)
    { /* Code for ImportFragment goes here */
      //p.jid_;
      return null;
    }
  }
  public class DefsVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs p, A arg)
    { /* Code for DefListDefs goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def x: p.listdef_) {
        x.accept(new DefVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class DefVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef p, A arg)
    { /* Code for SimpleValueDef goes here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef p, A arg)
    { /* Code for FunctionValueDef goes here */
      p.funcdecl_.accept(new FuncDeclVisitor<R,A>(), arg);
      return null;
    }
  }
  public class FuncDeclVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl p, A arg)
    { /* Code for AbstractTypelessFuncDecl goes here */
      //p.jid_;
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x: p.listparam_) {
        x.accept(new ParamVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl p, A arg)
    { /* Code for AbstractTypedFuncDecl goes here */
      //p.jid_;
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x: p.listparam_) {
        x.accept(new ParamVisitor<R,A>(), arg);
      }
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl p, A arg)
    { /* Code for ConcreteTypelessFuncDecl goes here */
      //p.jid_;
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x: p.listparam_) {
        x.accept(new ParamVisitor<R,A>(), arg);
      }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl p, A arg)
    { /* Code for ConcreteTypedFuncDecl goes here */
      //p.jid_;
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param x: p.listparam_) {
        x.accept(new ParamVisitor<R,A>(), arg);
      }
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ParamVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam p, A arg)
    { /* Code for BindingParam goes here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }
  }
  public class BindingVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding p, A arg)
    { /* Code for OnlyNameBinding goes here */
      //p.jid_;
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding p, A arg)
    { /* Code for NameTypeBinding goes here */
      //p.jid_;
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding p, A arg)
    { /* Code for NameInitBinding goes here */
      //p.jid_;
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding p, A arg)
    { /* Code for FullBinding goes here */
      //p.jid_;
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeDescVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc p, A arg)
    { /* Code for SimpleTypeDesc goes here */
      p.simpletype_.accept(new SimpleTypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc p, A arg)
    { /* Code for FuncTypeDesc goes here */
      p.functype_.accept(new FuncTypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class FuncTypeVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType p, A arg)
    { /* Code for ZeroArgFuncType goes here */
      p.functypefragm_.accept(new FuncTypeFragmVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType p, A arg)
    { /* Code for MultiArgFuncType goes here */
      p.functypefragm_.accept(new FuncTypeFragmVisitor<R,A>(), arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm x: p.listfunctypefragm_) {
        x.accept(new FuncTypeFragmVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class FuncTypeFragmVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm p, A arg)
    { /* Code for SimpleFuncTypeFragm goes here */
      p.simpletype_.accept(new SimpleTypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm p, A arg)
    { /* Code for FuncFuncTypeFragm goes here */
      p.functype_.accept(new FuncTypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class SimpleTypeVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType p, A arg)
    { /* Code for FragmSimpleType goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x: p.listsimpletypefragm_) {
        x.accept(new SimpleTypeFragmVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType p, A arg)
    { /* Code for GenericSimpleType goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm x: p.listsimpletypefragm_) {
        x.accept(new SimpleTypeFragmVisitor<R,A>(), arg);
      }
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue x: p.listgenerictypevalue_) {
        x.accept(new GenericTypeValueVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class SimpleTypeFragmVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm p, A arg)
    { /* Code for IdSimpleTypeFragm goes here */
      //p.jid_;
      return null;
    }
  }
  public class GenericTypeValueVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue p, A arg)
    { /* Code for GenericTypeDescValue goes here */
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ExprVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr p, A arg)
    { /* Code for IfExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr p, A arg)
    { /* Code for LetExpr goes here */
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef x: p.listletdef_) {
        x.accept(new LetDefVisitor<R,A>(), arg);
      }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr p, A arg)
    { /* Code for OrExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr p, A arg)
    { /* Code for AndExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr p, A arg)
    { /* Code for EqualityExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr p, A arg)
    { /* Code for InequalityExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr p, A arg)
    { /* Code for LesserExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr p, A arg)
    { /* Code for LesserEqualExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr p, A arg)
    { /* Code for GreaterExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr p, A arg)
    { /* Code for GreaterEqualExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr p, A arg)
    { /* Code for AdditionExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr p, A arg)
    { /* Code for SubtractionExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr p, A arg)
    { /* Code for MultiplicationExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr p, A arg)
    { /* Code for DivisionExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr p, A arg)
    { /* Code for ModuloExpr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr p, A arg)
    { /* Code for NotExpr goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr p, A arg)
    { /* Code for NegateExpr goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr p, A arg)
    { /* Code for PositateExpr goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr p, A arg)
    { /* Code for ComplexRefExpr goes here */
      //p.jid_1;
      //p.jid_2;
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr p, A arg)
    { /* Code for MethCallExpr goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      //p.jid_;
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x: p.listcallarg_) {
        x.accept(new CallArgVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr p, A arg)
    { /* Code for FuncCallExpr goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      for (org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg x: p.listcallarg_) {
        x.accept(new CallArgVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr p, A arg)
    { /* Code for SimpleRefExpr goes here */
      //p.jid_;
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr p, A arg)
    { /* Code for LiteralExpr goes here */
      p.literal_.accept(new LiteralVisitor<R,A>(), arg);
      return null;
    }
  }
  public class LetDefVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition p, A arg)
    { /* Code for LetDefinition goes here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }
  }
  public class CallArgVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg p, A arg)
    { /* Code for ExprCallArg goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class LiteralVisitor<R,A> implements org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral p, A arg)
    { /* Code for IntLiteral goes here */
      //p.integer_;
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral p, A arg)
    { /* Code for UnitLiteral goes here */
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral p, A arg)
    { /* Code for BoolTrueLiteral goes here */
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral p, A arg)
    { /* Code for BoolFalseLiteral goes here */
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral p, A arg)
    { /* Code for CharLiteral goes here */
      //p.jchar_;
      return null;
    }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral p, A arg)
    { /* Code for StringLiteral goes here */
      //p.jstring_;
      return null;
    }
  }
}
