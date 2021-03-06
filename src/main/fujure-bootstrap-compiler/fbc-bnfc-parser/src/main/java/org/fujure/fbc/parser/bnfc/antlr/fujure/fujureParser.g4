// -*- Java -*- This ANTLRv4 file was machine-generated by BNFC
parser grammar fujureParser;

options {
  tokenVocab = fujureLexer;
}

@members {
}

start_FileContents returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents result ]
  : x=fileContents EOF
    { $result = $x.result; }
  ;

fileContents returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents result ]
  : Surrogate_id_SYMB_31 p_1_2=pkgName p_1_3=imports p_1_4=defs
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage($p_1_2.result,$p_1_3.result,$p_1_4.result); }
  | p_2_1=imports p_2_2=defs
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage($p_2_1.result,$p_2_2.result); }
  ;
pkgName returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName result ]
  : p_1_1=listPkgFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName($p_1_1.result); }
  ;
listPkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm result ]
  : p_1_1=pkgFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm(); $result.addLast($p_1_1.result); }
  | p_2_1=pkgFragm Surrogate_id_SYMB_0 p_2_3=listPkgFragm
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
pkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm result ]
  : p_1_1=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment($p_1_1.getText()); }
  ;
imports returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports result ]
  : p_1_1=listImport
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts($p_1_1.result); }
  ;
listImport returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport result ]
  :  /* empty */
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport(); }
  | p_2_1=listImport p_2_2=import_
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
import_ returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import result ]
  : Surrogate_id_SYMB_28 p_1_2=listImportFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt($p_1_2.result); }
  ;
listImportFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm result ]
  : p_1_1=importFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm(); $result.addLast($p_1_1.result); }
  | p_2_1=importFragm Surrogate_id_SYMB_0 p_2_3=listImportFragm
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
importFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm result ]
  : p_1_1=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment($p_1_1.getText()); }
  ;
defs returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs result ]
  : p_1_1=listDef
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs($p_1_1.result); }
  ;
listDef returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef result ]
  :  /* empty */
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef(); }
  | p_2_1=listDef p_2_2=def
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
def returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def result ]
  : Surrogate_id_SYMB_24 p_1_2=binding
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef($p_1_2.result); }
  | Surrogate_id_SYMB_24 p_2_2=funcDecl
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef($p_2_2.result); }
  ;
funcDecl returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl result ]
  : p_1_1=JID Surrogate_id_SYMB_1 p_1_3=listParam Surrogate_id_SYMB_2
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl($p_1_1.getText(),$p_1_3.result); }
  | p_2_1=JID Surrogate_id_SYMB_1 p_2_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_3 p_2_6=typeDesc
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl($p_2_1.getText(),$p_2_3.result,$p_2_6.result); }
  | p_3_1=JID Surrogate_id_SYMB_1 p_3_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_4 p_3_6=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl($p_3_1.getText(),$p_3_3.result,$p_3_6.result); }
  | p_4_1=JID Surrogate_id_SYMB_1 p_4_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_3 p_4_6=typeDesc Surrogate_id_SYMB_4 p_4_8=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl($p_4_1.getText(),$p_4_3.result,$p_4_6.result,$p_4_8.result); }
  ;
listParam returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam result ]
  :  /* empty */
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam(); }
  | p_2_1=param
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam(); $result.addLast($p_2_1.result); }
  | p_3_1=param Surrogate_id_SYMB_5 p_3_3=listParam
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
param returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param result ]
  : p_1_1=binding
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam($p_1_1.result); }
  ;
binding returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding result ]
  : p_1_1=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding($p_1_1.getText()); }
  | p_2_1=JID Surrogate_id_SYMB_3 p_2_3=typeDesc
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding($p_2_1.getText(),$p_2_3.result); }
  | p_3_1=JID Surrogate_id_SYMB_4 p_3_3=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding($p_3_1.getText(),$p_3_3.result); }
  | p_4_1=JID Surrogate_id_SYMB_3 p_4_3=typeDesc Surrogate_id_SYMB_4 p_4_5=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding($p_4_1.getText(),$p_4_3.result,$p_4_5.result); }
  ;
typeDesc returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc result ]
  : p_1_1=simpleType
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc($p_1_1.result); }
  | p_2_1=funcType
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc($p_2_1.result); }
  ;
funcType returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType result ]
  : Surrogate_id_SYMB_1 Surrogate_id_SYMB_2 Surrogate_id_SYMB_6 p_1_4=funcTypeFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType($p_1_4.result); }
  | p_2_1=funcTypeFragm Surrogate_id_SYMB_6 p_2_3=listFuncTypeFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType($p_2_1.result,$p_2_3.result); }
  ;
listFuncTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm result ]
  : p_1_1=funcTypeFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm(); $result.addLast($p_1_1.result); }
  | p_2_1=funcTypeFragm Surrogate_id_SYMB_6 p_2_3=listFuncTypeFragm
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
funcTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm result ]
  : p_1_1=simpleType
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm($p_1_1.result); }
  | Surrogate_id_SYMB_1 p_2_2=funcType Surrogate_id_SYMB_2
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm($p_2_2.result); }
  ;
simpleType returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType result ]
  : p_1_1=listSimpleTypeFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType($p_1_1.result); }
  | p_2_1=listSimpleTypeFragm Surrogate_id_SYMB_7 p_2_3=listGenericTypeValue Surrogate_id_SYMB_8
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType($p_2_1.result,$p_2_3.result); }
  ;
listSimpleTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm result ]
  : p_1_1=simpleTypeFragm
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm(); $result.addLast($p_1_1.result); }
  | p_2_1=simpleTypeFragm Surrogate_id_SYMB_0 p_2_3=listSimpleTypeFragm
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
simpleTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm result ]
  : p_1_1=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm($p_1_1.getText()); }
  ;
listGenericTypeValue returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue result ]
  :  /* empty */
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue(); }
  | p_2_1=genericTypeValue
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue(); $result.addLast($p_2_1.result); }
  | p_3_1=genericTypeValue Surrogate_id_SYMB_5 p_3_3=listGenericTypeValue
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
genericTypeValue returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue result ]
  : p_1_1=typeDesc
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue($p_1_1.result); }
  ;
expr returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : Surrogate_id_SYMB_27 p_1_2=expr Surrogate_id_SYMB_32 p_1_4=expr Surrogate_id_SYMB_25 p_1_6=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr($p_1_2.result,$p_1_4.result,$p_1_6.result); }
  | Surrogate_id_SYMB_30 p_2_2=listLetDef Surrogate_id_SYMB_29 p_2_4=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr($p_2_2.result,$p_2_4.result); }
  | Surrogate_id_SYMB_9 p_3_2=listStmt Surrogate_id_SYMB_10
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StmtBlockExpr($p_3_2.result); }
  | p_4_1=expr1
    { $result = $p_4_1.result; }
  ;
letDef returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef result ]
  : p_1_1=binding
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition($p_1_1.result); }
  ;
listLetDef returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef result ]
  : p_1_1=letDef
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef(); $result.addLast($p_1_1.result); }
  | p_2_1=letDef Surrogate_id_SYMB_5 p_2_3=listLetDef
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
listStmt returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListStmt result ]
  : p_1_1=stmt Surrogate_id_SYMB_11
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListStmt(); $result.addLast($p_1_1.result); }
  | p_2_1=stmt Surrogate_id_SYMB_11 p_2_3=listStmt
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
stmt returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Stmt result ]
  : p_1_1=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprStmt($p_1_1.result); }
  ;
expr1 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr1 Surrogate_id_SYMB_12 p_1_3=expr2
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr2
    { $result = $p_2_1.result; }
  ;
expr2 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr2 Surrogate_id_SYMB_13 p_1_3=expr3
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr3
    { $result = $p_2_1.result; }
  ;
expr3 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr3 Surrogate_id_SYMB_14 p_1_3=expr4
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr3 Surrogate_id_SYMB_15 p_2_3=expr4
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr4
    { $result = $p_3_1.result; }
  ;
expr4 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr4 Surrogate_id_SYMB_7 p_1_3=expr5
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr4 Surrogate_id_SYMB_16 p_2_3=expr5
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr4 Surrogate_id_SYMB_8 p_3_3=expr5
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr($p_3_1.result,$p_3_3.result); }
  | p_4_1=expr4 Surrogate_id_SYMB_17 p_4_3=expr5
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr($p_4_1.result,$p_4_3.result); }
  | p_5_1=expr5
    { $result = $p_5_1.result; }
  ;
expr5 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr5 Surrogate_id_SYMB_18 p_1_3=expr6
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr5 Surrogate_id_SYMB_19 p_2_3=expr6
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr6
    { $result = $p_3_1.result; }
  ;
expr6 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr6 Surrogate_id_SYMB_20 p_1_3=expr7
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr6 Surrogate_id_SYMB_21 p_2_3=expr7
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr6 Surrogate_id_SYMB_22 p_3_3=expr7
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr($p_3_1.result,$p_3_3.result); }
  | p_4_1=expr7
    { $result = $p_4_1.result; }
  ;
expr7 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : Surrogate_id_SYMB_23 p_1_2=expr8
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr($p_1_2.result); }
  | Surrogate_id_SYMB_19 p_2_2=expr8
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr($p_2_2.result); }
  | Surrogate_id_SYMB_18 p_3_2=expr8
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr($p_3_2.result); }
  | p_4_1=expr8
    { $result = $p_4_1.result; }
  ;
expr8 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=JID Surrogate_id_SYMB_0 p_1_3=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr($p_1_1.getText(),$p_1_3.getText()); }
  | p_2_1=expr8 Surrogate_id_SYMB_0 p_2_3=JID Surrogate_id_SYMB_1 p_2_5=listCallArg Surrogate_id_SYMB_2
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr($p_2_1.result,$p_2_3.getText(),$p_2_5.result); }
  | p_3_1=expr9
    { $result = $p_3_1.result; }
  ;
expr9 returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result ]
  : p_1_1=expr9 Surrogate_id_SYMB_1 p_1_3=listCallArg Surrogate_id_SYMB_2
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr($p_1_1.result,$p_1_3.result); }
  | p_2_1=JID
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr($p_2_1.getText()); }
  | p_3_1=literal
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr($p_3_1.result); }
  | Surrogate_id_SYMB_1 p_4_2=expr Surrogate_id_SYMB_2
    { $result = $p_4_2.result; }
  ;
callArg returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg result ]
  : p_1_1=expr
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg($p_1_1.result); }
  ;
listCallArg returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg result ]
  :  /* empty */
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg(); }
  | p_2_1=callArg
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg(); $result.addLast($p_2_1.result); }
  | p_3_1=callArg Surrogate_id_SYMB_5 p_3_3=listCallArg
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
literal returns [ org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal result ]
  : p_1_1=INTEGER
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral(Integer.parseInt($p_1_1.getText())); }
  | Surrogate_id_SYMB_34
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral(); }
  | Surrogate_id_SYMB_33
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral(); }
  | Surrogate_id_SYMB_26
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral(); }
  | p_5_1=JCHAR
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral($p_5_1.getText()); }
  | p_6_1=JSTRING
    { $result = new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral($p_6_1.getText()); }
  ;

