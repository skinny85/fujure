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
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm foo)
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
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm foo)
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
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions _definitions = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_definitions.listdef_, 0);
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
       pp(_nametypebinding.typespec_, 0);
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
       pp(_fullbinding.typespec_, 0);
       render("=");
       pp(_fullbinding.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier _typespecifier = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_typespecifier.listtypespecfragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm foo, int _i_)
  {
     for (java.util.Iterator<TypeSpecFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(".");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment _typespecfragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_typespecfragment.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr _variableexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_variableexpr.valref_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr _literalexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_literalexpr.literal_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef _valueref = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_valueref.listvalreffragm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm foo, int _i_)
  {
     for (java.util.Iterator<ValRefFragm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(".");
       } else {
         render("");
       }
     }  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment _valuereffragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_valuereffragment.jid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

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
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions _definitions = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions) foo;
       render("(");
       render("Definitions");
       render("[");
       sh(_definitions.listdef_);
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
       sh(_nametypebinding.typespec_);
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
       sh(_fullbinding.typespec_);
       sh(_fullbinding.expr_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier _typespecifier = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier) foo;
       render("(");
       render("TypeSpecifier");
       render("[");
       sh(_typespecifier.listtypespecfragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm foo)
  {
     for (java.util.Iterator<TypeSpecFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment _typespecfragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment) foo;
       render("(");
       render("TypeSpecFragment");
       sh(_typespecfragment.jid_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr _variableexpr = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr) foo;
       render("(");
       render("VariableExpr");
       sh(_variableexpr.valref_);
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

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef _valueref = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef) foo;
       render("(");
       render("ValueRef");
       render("[");
       sh(_valueref.listvalreffragm_);
       render("]");
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm foo)
  {
     for (java.util.Iterator<ValRefFragm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment _valuereffragment = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment) foo;
       render("(");
       render("ValueRefFragment");
       sh(_valuereffragment.jid_);
       render(")");
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

