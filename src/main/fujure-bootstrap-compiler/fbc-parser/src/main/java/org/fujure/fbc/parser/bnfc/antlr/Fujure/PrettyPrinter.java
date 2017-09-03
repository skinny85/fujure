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
  public static String print(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef foo)
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
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage _fileinnamedpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("package");
       pp(_fileinnamedpackage.pkgname_, 0);
       pp(_fileinnamedpackage.defs_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage _fileindefaultpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage) foo;
       if (_i_ > 0) render(_L_PAREN);
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
       pp(_packagefragment.ident_, 0);
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
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef _valuedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_valuedef.valdef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef foo, int _i_)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef _untypedvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("def");
       pp(_untypedvaluedef.ident_, 0);
       render("=");
       pp(_untypedvaluedef.integer_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef _typedvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("def");
       pp(_typedvaluedef.ident_, 0);
       render(":");
       pp(_typedvaluedef.typespec_, 0);
       render("=");
       pp(_typedvaluedef.integer_, 0);
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
       pp(_typespecfragment.ident_, 0);
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
       sh(_fileinnamedpackage.defs_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage _fileindefaultpackage = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage) foo;
       render("(");
       render("FileInDefaultPackage");
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
       sh(_packagefragment.ident_);
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
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef _valuedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef) foo;
       render("(");
       render("ValueDef");
       sh(_valuedef.valdef_);
       render(")");
    }
  }

  private static void sh(org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef foo)
  {
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef _untypedvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef) foo;
       render("(");
       render("UntypedValueDef");
       sh(_untypedvaluedef.ident_);
       sh(_untypedvaluedef.integer_);
       render(")");
    }
    if (foo instanceof org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef)
    {
       org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef _typedvaluedef = (org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef) foo;
       render("(");
       render("TypedValueDef");
       sh(_typedvaluedef.ident_);
       sh(_typedvaluedef.typespec_);
       sh(_typedvaluedef.integer_);
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
       sh(_typespecfragment.ident_);
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
