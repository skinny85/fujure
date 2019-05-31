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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def p, A arg) {
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
/* TypeSpec */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeSpecFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm p, A arg) {
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

    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunCallExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr p, A arg) { return visitDefault(p, arg); }
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
/* ValRef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ValRefFragm */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm p, A arg) {
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
