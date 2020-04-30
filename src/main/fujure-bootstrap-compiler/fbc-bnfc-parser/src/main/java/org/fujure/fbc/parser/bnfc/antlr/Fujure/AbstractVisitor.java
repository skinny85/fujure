package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* FileContents */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PkgName */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PkgFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Imports */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Import */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ImportFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Defs */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* FuncDecl */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Param */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Binding */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeDesc */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* FuncType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* FuncTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* SimpleType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* SimpleTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Expr */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr p, A arg) { return visitDefault(p, arg); }

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* LetDef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* CallArg */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Literal */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
