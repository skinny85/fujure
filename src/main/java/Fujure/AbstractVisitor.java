package Fujure;
import Fujure.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* ValueDef */
    public R visit(Fujure.Absyn.VDef p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(Fujure.Absyn.ValueDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
