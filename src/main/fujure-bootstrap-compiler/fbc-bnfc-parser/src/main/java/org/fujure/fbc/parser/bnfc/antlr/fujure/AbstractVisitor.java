package org.fujure.fbc.parser.bnfc.antlr.fujure;

/** BNFC-Generated Abstract Visitor */

public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
    /* FileContents */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* PkgName */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* PkgFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Imports */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Import */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* ImportFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Defs */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* FuncDecl */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Param */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Binding */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* TypeDesc */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* FuncType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* FuncTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* SimpleType */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* SimpleTypeFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* GenericTypeValue */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Expr */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* LetDef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* CallArg */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Literal */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
