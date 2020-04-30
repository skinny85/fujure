package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage _fileinnamedpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("package");
       pp(_fileinnamedpackage.pkgname_, 0);
       pp(_fileinnamedpackage.imports_, 0);
       pp(_fileinnamedpackage.defs_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage _fileindefaultpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_fileindefaultpackage.imports_, 0);
       pp(_fileindefaultpackage.defs_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName _packagename = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_packagename.listpkgfragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm foo, int _i_)
  {
     for (java.util.Iterator<PkgFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(".");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment _packagefragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_packagefragment.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts _importstmts = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_importstmts.listimport_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport foo, int _i_)
  {
     for (java.util.Iterator<Import> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt _importstmt = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("import");
       pp(_importstmt.listimportfragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm foo, int _i_)
  {
     for (java.util.Iterator<ImportFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(".");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment _importfragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_importfragment.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs _deflistdefs = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_deflistdefs.listdef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef foo, int _i_)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef _simplevaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("def");
       pp(_simplevaluedef.binding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef _functionvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("def");
       pp(_functionvaluedef.funcdecl_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl _abstracttypelessfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_abstracttypelessfuncdecl.jid_, 0);
       render("(");
       pp(_abstracttypelessfuncdecl.listparam_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl _abstracttypedfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_abstracttypedfuncdecl.jid_, 0);
       render("(");
       pp(_abstracttypedfuncdecl.listparam_, 0);
       render(")");
       render(":");
       pp(_abstracttypedfuncdecl.typedesc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl _concretetypelessfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_concretetypelessfuncdecl.jid_, 0);
       render("(");
       pp(_concretetypelessfuncdecl.listparam_, 0);
       render(")");
       render("=");
       pp(_concretetypelessfuncdecl.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl _concretetypedfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_concretetypedfuncdecl.jid_, 0);
       render("(");
       pp(_concretetypedfuncdecl.listparam_, 0);
       render(")");
       render(":");
       pp(_concretetypedfuncdecl.typedesc_, 0);
       render("=");
       pp(_concretetypedfuncdecl.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam foo, int _i_)
  {
     for (java.util.Iterator<Param> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam _bindingparam = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_bindingparam.binding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding _onlynamebinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_onlynamebinding.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding _nametypebinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_nametypebinding.jid_, 0);
       render(":");
       pp(_nametypebinding.typedesc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding _nameinitbinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_nameinitbinding.jid_, 0);
       render("=");
       pp(_nameinitbinding.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding _fullbinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_fullbinding.jid_, 0);
       render(":");
       pp(_fullbinding.typedesc_, 0);
       render("=");
       pp(_fullbinding.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc _simpletypedesc = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_simpletypedesc.simpletype_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc _functypedesc = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_functypedesc.functype_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType _zeroargfunctype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       render(")");
       render("->");
       pp(_zeroargfunctype.functypefragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType _multiargfunctype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_multiargfunctype.functypefragm_, 0);
       render("->");
       pp(_multiargfunctype.listfunctypefragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm foo, int _i_)
  {
     for (java.util.Iterator<FuncTypeFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("->");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm _simplefunctypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_simplefunctypefragm.simpletype_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm _funcfunctypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       pp(_funcfunctypefragm.functype_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType _fragmsimpletype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_fragmsimpletype.listsimpletypefragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm foo, int _i_)
  {
     for (java.util.Iterator<SimpleTypeFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(".");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm _idsimpletypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_idsimpletypefragm.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr _ifexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       pp(_ifexpr.expr_1, 0);
       render("then");
       pp(_ifexpr.expr_2, 0);
       render("else");
       pp(_ifexpr.expr_3, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr _letexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("let");
       pp(_letexpr.listletdef_, 0);
       render("in");
       pp(_letexpr.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr _orexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_orexpr.expr_1, 1);
       render("||");
       pp(_orexpr.expr_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr _andexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_andexpr.expr_1, 2);
       render("&&");
       pp(_andexpr.expr_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr _equalityexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_equalityexpr.expr_1, 3);
       render("==");
       pp(_equalityexpr.expr_2, 4);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr _inequalityexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_inequalityexpr.expr_1, 3);
       render("!=");
       pp(_inequalityexpr.expr_2, 4);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr _lesserexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_lesserexpr.expr_1, 4);
       render("<");
       pp(_lesserexpr.expr_2, 5);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr _lesserequalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_lesserequalexpr.expr_1, 4);
       render("<=");
       pp(_lesserequalexpr.expr_2, 5);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr _greaterexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_greaterexpr.expr_1, 4);
       render(">");
       pp(_greaterexpr.expr_2, 5);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr _greaterequalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_greaterequalexpr.expr_1, 4);
       render(">=");
       pp(_greaterequalexpr.expr_2, 5);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr _additionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr) foo;
       if (_i_ > 5) render(_L_PAREN);
       pp(_additionexpr.expr_1, 5);
       render("+");
       pp(_additionexpr.expr_2, 6);
       if (_i_ > 5) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr _subtractionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr) foo;
       if (_i_ > 5) render(_L_PAREN);
       pp(_subtractionexpr.expr_1, 5);
       render("-");
       pp(_subtractionexpr.expr_2, 6);
       if (_i_ > 5) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr _multiplicationexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_multiplicationexpr.expr_1, 6);
       render("*");
       pp(_multiplicationexpr.expr_2, 7);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr _divisionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_divisionexpr.expr_1, 6);
       render("/");
       pp(_divisionexpr.expr_2, 7);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr _moduloexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr) foo;
       if (_i_ > 6) render(_L_PAREN);
       pp(_moduloexpr.expr_1, 6);
       render("%");
       pp(_moduloexpr.expr_2, 7);
       if (_i_ > 6) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr _notexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr) foo;
       if (_i_ > 7) render(_L_PAREN);
       render("!");
       pp(_notexpr.expr_, 8);
       if (_i_ > 7) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr _negateexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr) foo;
       if (_i_ > 7) render(_L_PAREN);
       render("-");
       pp(_negateexpr.expr_, 8);
       if (_i_ > 7) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr _positateexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr) foo;
       if (_i_ > 7) render(_L_PAREN);
       render("+");
       pp(_positateexpr.expr_, 8);
       if (_i_ > 7) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr _complexrefexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr) foo;
       if (_i_ > 8) render(_L_PAREN);
       pp(_complexrefexpr.jid_1, 0);
       render(".");
       pp(_complexrefexpr.jid_2, 0);
       if (_i_ > 8) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr _funccallexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_funccallexpr.expr_, 9);
       render("(");
       pp(_funccallexpr.listcallarg_, 0);
       render(")");
       if (_i_ > 9) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr _methcallexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_methcallexpr.expr_, 9);
       render(".");
       pp(_methcallexpr.jid_, 0);
       render("(");
       pp(_methcallexpr.listcallarg_, 0);
       render(")");
       if (_i_ > 9) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr _simplerefexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_simplerefexpr.jid_, 0);
       if (_i_ > 9) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr _literalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_literalexpr.literal_, 0);
       if (_i_ > 9) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition _letdefinition = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_letdefinition.binding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef foo, int _i_)
  {
     for (java.util.Iterator<LetDef> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg _exprcallarg = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_exprcallarg.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg foo, int _i_)
  {
     for (java.util.Iterator<CallArg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral _intliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_intliteral.integer_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral _unitliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("unit");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral _booltrueliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral _boolfalseliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral _charliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_charliteral.jchar_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral _stringliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_stringliteral.jstring_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage _fileinnamedpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage) foo;
       render("(");
       render("FileInNamedPackage");
       sh(_fileinnamedpackage.pkgname_);
       sh(_fileinnamedpackage.imports_);
       sh(_fileinnamedpackage.defs_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage _fileindefaultpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage) foo;
       render("(");
       render("FileInDefaultPackage");
       sh(_fileindefaultpackage.imports_);
       sh(_fileindefaultpackage.defs_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName _packagename = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName) foo;
       render("(");
       render("PackageName");
       render("[");
       sh(_packagename.listpkgfragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm foo)
  {
     for (java.util.Iterator<PkgFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment _packagefragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment) foo;
       render("(");
       render("PackageFragment");
       sh(_packagefragment.jid_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts _importstmts = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts) foo;
       render("(");
       render("ImportStmts");
       render("[");
       sh(_importstmts.listimport_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport foo)
  {
     for (java.util.Iterator<Import> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt _importstmt = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt) foo;
       render("(");
       render("ImportStmt");
       render("[");
       sh(_importstmt.listimportfragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm foo)
  {
     for (java.util.Iterator<ImportFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment _importfragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment) foo;
       render("(");
       render("ImportFragment");
       sh(_importfragment.jid_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs _deflistdefs = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs) foo;
       render("(");
       render("DefListDefs");
       render("[");
       sh(_deflistdefs.listdef_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef foo)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef _simplevaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef) foo;
       render("(");
       render("SimpleValueDef");
       sh(_simplevaluedef.binding_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef _functionvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef) foo;
       render("(");
       render("FunctionValueDef");
       sh(_functionvaluedef.funcdecl_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl _abstracttypelessfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl) foo;
       render("(");
       render("AbstractTypelessFuncDecl");
       sh(_abstracttypelessfuncdecl.jid_);
       render("[");
       sh(_abstracttypelessfuncdecl.listparam_);
       render("]");
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl _abstracttypedfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl) foo;
       render("(");
       render("AbstractTypedFuncDecl");
       sh(_abstracttypedfuncdecl.jid_);
       render("[");
       sh(_abstracttypedfuncdecl.listparam_);
       render("]");
       sh(_abstracttypedfuncdecl.typedesc_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl _concretetypelessfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl) foo;
       render("(");
       render("ConcreteTypelessFuncDecl");
       sh(_concretetypelessfuncdecl.jid_);
       render("[");
       sh(_concretetypelessfuncdecl.listparam_);
       render("]");
       sh(_concretetypelessfuncdecl.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl _concretetypedfuncdecl = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl) foo;
       render("(");
       render("ConcreteTypedFuncDecl");
       sh(_concretetypedfuncdecl.jid_);
       render("[");
       sh(_concretetypedfuncdecl.listparam_);
       render("]");
       sh(_concretetypedfuncdecl.typedesc_);
       sh(_concretetypedfuncdecl.expr_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam foo)
  {
     for (java.util.Iterator<Param> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam _bindingparam = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam) foo;
       render("(");
       render("BindingParam");
       sh(_bindingparam.binding_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding _onlynamebinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding) foo;
       render("(");
       render("OnlyNameBinding");
       sh(_onlynamebinding.jid_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding _nametypebinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding) foo;
       render("(");
       render("NameTypeBinding");
       sh(_nametypebinding.jid_);
       sh(_nametypebinding.typedesc_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding _nameinitbinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding) foo;
       render("(");
       render("NameInitBinding");
       sh(_nameinitbinding.jid_);
       sh(_nameinitbinding.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding _fullbinding = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding) foo;
       render("(");
       render("FullBinding");
       sh(_fullbinding.jid_);
       sh(_fullbinding.typedesc_);
       sh(_fullbinding.expr_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc _simpletypedesc = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc) foo;
       render("(");
       render("SimpleTypeDesc");
       sh(_simpletypedesc.simpletype_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc _functypedesc = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc) foo;
       render("(");
       render("FuncTypeDesc");
       sh(_functypedesc.functype_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType _zeroargfunctype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType) foo;
       render("(");
       render("ZeroArgFuncType");
       sh(_zeroargfunctype.functypefragm_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType _multiargfunctype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType) foo;
       render("(");
       render("MultiArgFuncType");
       sh(_multiargfunctype.functypefragm_);
       render("[");
       sh(_multiargfunctype.listfunctypefragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm foo)
  {
     for (java.util.Iterator<FuncTypeFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm _simplefunctypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm) foo;
       render("(");
       render("SimpleFuncTypeFragm");
       sh(_simplefunctypefragm.simpletype_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm _funcfunctypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm) foo;
       render("(");
       render("FuncFuncTypeFragm");
       sh(_funcfunctypefragm.functype_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType _fragmsimpletype = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType) foo;
       render("(");
       render("FragmSimpleType");
       render("[");
       sh(_fragmsimpletype.listsimpletypefragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm foo)
  {
     for (java.util.Iterator<SimpleTypeFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm _idsimpletypefragm = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm) foo;
       render("(");
       render("IdSimpleTypeFragm");
       sh(_idsimpletypefragm.jid_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr _ifexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr) foo;
       render("(");
       render("IfExpr");
       sh(_ifexpr.expr_1);
       sh(_ifexpr.expr_2);
       sh(_ifexpr.expr_3);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr _letexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr) foo;
       render("(");
       render("LetExpr");
       render("[");
       sh(_letexpr.listletdef_);
       render("]");
       sh(_letexpr.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr _orexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr) foo;
       render("(");
       render("OrExpr");
       sh(_orexpr.expr_1);
       sh(_orexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr _andexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr) foo;
       render("(");
       render("AndExpr");
       sh(_andexpr.expr_1);
       sh(_andexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr _equalityexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr) foo;
       render("(");
       render("EqualityExpr");
       sh(_equalityexpr.expr_1);
       sh(_equalityexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr _inequalityexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr) foo;
       render("(");
       render("InequalityExpr");
       sh(_inequalityexpr.expr_1);
       sh(_inequalityexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr _lesserexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr) foo;
       render("(");
       render("LesserExpr");
       sh(_lesserexpr.expr_1);
       sh(_lesserexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr _lesserequalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr) foo;
       render("(");
       render("LesserEqualExpr");
       sh(_lesserequalexpr.expr_1);
       sh(_lesserequalexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr _greaterexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr) foo;
       render("(");
       render("GreaterExpr");
       sh(_greaterexpr.expr_1);
       sh(_greaterexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr _greaterequalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr) foo;
       render("(");
       render("GreaterEqualExpr");
       sh(_greaterequalexpr.expr_1);
       sh(_greaterequalexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr _additionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr) foo;
       render("(");
       render("AdditionExpr");
       sh(_additionexpr.expr_1);
       sh(_additionexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr _subtractionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr) foo;
       render("(");
       render("SubtractionExpr");
       sh(_subtractionexpr.expr_1);
       sh(_subtractionexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr _multiplicationexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr) foo;
       render("(");
       render("MultiplicationExpr");
       sh(_multiplicationexpr.expr_1);
       sh(_multiplicationexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr _divisionexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr) foo;
       render("(");
       render("DivisionExpr");
       sh(_divisionexpr.expr_1);
       sh(_divisionexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr _moduloexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr) foo;
       render("(");
       render("ModuloExpr");
       sh(_moduloexpr.expr_1);
       sh(_moduloexpr.expr_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr _notexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr) foo;
       render("(");
       render("NotExpr");
       sh(_notexpr.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr _negateexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr) foo;
       render("(");
       render("NegateExpr");
       sh(_negateexpr.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr _positateexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr) foo;
       render("(");
       render("PositateExpr");
       sh(_positateexpr.expr_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr _complexrefexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ComplexRefExpr) foo;
       render("(");
       render("ComplexRefExpr");
       sh(_complexrefexpr.jid_1);
       sh(_complexrefexpr.jid_2);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr _funccallexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncCallExpr) foo;
       render("(");
       render("FuncCallExpr");
       sh(_funccallexpr.expr_);
       render("[");
       sh(_funccallexpr.listcallarg_);
       render("]");
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr _methcallexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MethCallExpr) foo;
       render("(");
       render("MethCallExpr");
       sh(_methcallexpr.expr_);
       sh(_methcallexpr.jid_);
       render("[");
       sh(_methcallexpr.listcallarg_);
       render("]");
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr _simplerefexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleRefExpr) foo;
       render("(");
       render("SimpleRefExpr");
       sh(_simplerefexpr.jid_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr _literalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr) foo;
       render("(");
       render("LiteralExpr");
       sh(_literalexpr.literal_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition _letdefinition = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition) foo;
       render("(");
       render("LetDefinition");
       sh(_letdefinition.binding_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef foo)
  {
     for (java.util.Iterator<LetDef> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg _exprcallarg = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg) foo;
       render("(");
       render("ExprCallArg");
       sh(_exprcallarg.expr_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg foo)
  {
     for (java.util.Iterator<CallArg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral _intliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral) foo;
       render("(");
       render("IntLiteral");
       sh(_intliteral.integer_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral _unitliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral) foo;
       render("UnitLiteral");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral _booltrueliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral) foo;
       render("BoolTrueLiteral");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral _boolfalseliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral) foo;
       render("BoolFalseLiteral");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral _charliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral) foo;
       render("(");
       render("CharLiteral");
       sh(_charliteral.jchar_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral _stringliteral = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral) foo;
       render("(");
       render("StringLiteral");
       sh(_stringliteral.jstring_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

