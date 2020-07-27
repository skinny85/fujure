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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs p, A arg)
    { /* Code For DefListDefs Goes Here */
      for (Def x: p.listdef_)
      { /* ... */ }
      return null;
    }
  }
  public class DefVisitor<R,A> implements Def.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg)
    { /* Code For SimpleValueDef Goes Here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef p, A arg)
    { /* Code For FunctionValueDef Goes Here */
      p.funcdecl_.accept(new FuncDeclVisitor<R,A>(), arg);
      return null;
    }
  }
  public class FuncDeclVisitor<R,A> implements FuncDecl.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl p, A arg)
    { /* Code For AbstractTypelessFuncDecl Goes Here */
      //p.jid_;
      for (Param x: p.listparam_)
      { /* ... */ }
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl p, A arg)
    { /* Code For AbstractTypedFuncDecl Goes Here */
      //p.jid_;
      for (Param x: p.listparam_)
      { /* ... */ }
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl p, A arg)
    { /* Code For ConcreteTypelessFuncDecl Goes Here */
      //p.jid_;
      for (Param x: p.listparam_)
      { /* ... */ }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl p, A arg)
    { /* Code For ConcreteTypedFuncDecl Goes Here */
      //p.jid_;
      for (Param x: p.listparam_)
      { /* ... */ }
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ParamVisitor<R,A> implements Param.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam p, A arg)
    { /* Code For BindingParam Goes Here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }
  }
  public class BindingVisitor<R,A> implements Binding.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding p, A arg)
    { /* Code For OnlyNameBinding Goes Here */
      //p.jid_;
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding p, A arg)
    { /* Code For NameTypeBinding Goes Here */
      //p.jid_;
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding p, A arg)
    { /* Code For NameInitBinding Goes Here */
      //p.jid_;
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding p, A arg)
    { /* Code For FullBinding Goes Here */
      //p.jid_;
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeDescVisitor<R,A> implements TypeDesc.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc p, A arg)
    { /* Code For SimpleTypeDesc Goes Here */
      p.simpletype_.accept(new SimpleTypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc p, A arg)
    { /* Code For FuncTypeDesc Goes Here */
      p.functype_.accept(new FuncTypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class FuncTypeVisitor<R,A> implements FuncType.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType p, A arg)
    { /* Code For ZeroArgFuncType Goes Here */
      p.functypefragm_.accept(new FuncTypeFragmVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType p, A arg)
    { /* Code For MultiArgFuncType Goes Here */
      p.functypefragm_.accept(new FuncTypeFragmVisitor<R,A>(), arg);
      for (FuncTypeFragm x: p.listfunctypefragm_)
      { /* ... */ }
      return null;
    }
  }
  public class FuncTypeFragmVisitor<R,A> implements FuncTypeFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm p, A arg)
    { /* Code For SimpleFuncTypeFragm Goes Here */
      p.simpletype_.accept(new SimpleTypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm p, A arg)
    { /* Code For FuncFuncTypeFragm Goes Here */
      p.functype_.accept(new FuncTypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class SimpleTypeVisitor<R,A> implements SimpleType.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType p, A arg)
    { /* Code For FragmSimpleType Goes Here */
      for (SimpleTypeFragm x: p.listsimpletypefragm_)
      { /* ... */ }
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GenericSimpleType p, A arg)
    { /* Code For GenericSimpleType Goes Here */
      for (SimpleTypeFragm x: p.listsimpletypefragm_)
      { /* ... */ }
      for (GenericTypeValue x: p.listgenerictypevalue_)
      { /* ... */ }
      return null;
    }
  }
  public class SimpleTypeFragmVisitor<R,A> implements SimpleTypeFragm.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm p, A arg)
    { /* Code For IdSimpleTypeFragm Goes Here */
      //p.jid_;
      return null;
    }
  }
  public class GenericTypeValueVisitor<R,A> implements GenericTypeValue.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GenericTypeDescValue p, A arg)
    { /* Code For GenericTypeDescValue Goes Here */
      p.typedesc_.accept(new TypeDescVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr p, A arg)
    { /* Code For IfExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr p, A arg)
    { /* Code For LetExpr Goes Here */
      for (LetDef x: p.listletdef_)
      { /* ... */ }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr p, A arg)
    { /* Code For OrExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr p, A arg)
    { /* Code For AndExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr p, A arg)
    { /* Code For EqualityExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr p, A arg)
    { /* Code For InequalityExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr p, A arg)
    { /* Code For LesserExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr p, A arg)
    { /* Code For LesserEqualExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr p, A arg)
    { /* Code For GreaterExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr p, A arg)
    { /* Code For GreaterEqualExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr p, A arg)
    { /* Code For AdditionExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr p, A arg)
    { /* Code For SubtractionExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr p, A arg)
    { /* Code For MultiplicationExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr p, A arg)
    { /* Code For DivisionExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr p, A arg)
    { /* Code For ModuloExpr Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr p, A arg)
    { /* Code For NotExpr Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr p, A arg)
    { /* Code For NegateExpr Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr p, A arg)
    { /* Code For PositateExpr Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr p, A arg)
    { /* Code For ComplexRefExpr Goes Here */
      //p.jid_1;
      //p.jid_2;
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr p, A arg)
    { /* Code For MethCallExpr Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      //p.jid_;
      for (CallArg x: p.listcallarg_)
      { /* ... */ }
      return null;
    }        public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr p, A arg)
    { /* Code For FuncCallExpr Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      for (CallArg x: p.listcallarg_)
      { /* ... */ }
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr p, A arg)
    { /* Code For SimpleRefExpr Goes Here */
      //p.jid_;
      return null;
    }    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr p, A arg)
    { /* Code For LiteralExpr Goes Here */
      p.literal_.accept(new LiteralVisitor<R,A>(), arg);
      return null;
    }    
  }
  public class LetDefVisitor<R,A> implements LetDef.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition p, A arg)
    { /* Code For LetDefinition Goes Here */
      p.binding_.accept(new BindingVisitor<R,A>(), arg);
      return null;
    }
  }
  public class CallArgVisitor<R,A> implements CallArg.Visitor<R,A>
  {
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg p, A arg)
    { /* Code For ExprCallArg Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
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