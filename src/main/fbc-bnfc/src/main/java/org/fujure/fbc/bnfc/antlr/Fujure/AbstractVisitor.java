package org.fujure.fbc.bnfc.antlr.Fujure;
import org.fujure.fbc.bnfc.antlr.Fujure.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* FileContents */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PkgFragm */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ValDef */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.UntypedValueDef p, A arg) { return visitDefault(p, arg); }
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypedValueDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeSpec */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecifier p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpec p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeSpecFragm */
    public R visit(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragment p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(org.fujure.fbc.bnfc.antlr.Fujure.Absyn.TypeSpecFragm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
