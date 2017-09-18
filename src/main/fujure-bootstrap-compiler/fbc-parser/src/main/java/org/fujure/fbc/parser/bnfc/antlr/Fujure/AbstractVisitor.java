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
/* Defs */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Def */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ValDef */
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef p, A arg) {
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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr p, A arg) {
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
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
