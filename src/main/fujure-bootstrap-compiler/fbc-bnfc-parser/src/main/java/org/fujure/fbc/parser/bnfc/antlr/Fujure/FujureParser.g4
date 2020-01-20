// -*- Java -*- This ANTLRv4 file was machine-generated by BNFC
parser grammar FujureParser;

options {
  tokenVocab = FujureLexer;
}

fileContents returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents result ] : Surrogate_id_SYMB_28 p_1_2=pkgName p_1_3=imports p_1_4=defs  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage($p_1_2.result,$p_1_3.result,$p_1_4.result); } # FileInNamedPackage 
  | p_2_1=imports p_2_2=defs  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage($p_2_1.result,$p_2_2.result); } # FileInDefaultPackage
;
pkgName returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName result ] : p_1_1=listPkgFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName($p_1_1.result); } # PackageName 
;
listPkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm result ] : p_1_1=pkgFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); $result.addLast($p_1_1.result); } # ListPkgFragm_AppendLast 
  | p_2_1=pkgFragm Surrogate_id_SYMB_0 p_2_3=listPkgFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListPkgFragm_PrependFirst
;
pkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment($p_1_1.getText()); } # PackageFragment 
;
imports returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports result ] : p_1_1=listImport  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts($p_1_1.result); } # ImportStmts 
;
listImport returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport(); } # ListImport_Empty 
  | p_2_1=listImport p_2_2=import_  { $result = $p_2_1.result; $result.addLast($p_2_2.result); } # ListImport_PrependFirst
;
import_ returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import result ] : Surrogate_id_SYMB_25 p_1_2=listImportFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt($p_1_2.result); } # ImportStmt 
;
listImportFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm result ] : p_1_1=importFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); $result.addLast($p_1_1.result); } # ListImportFragm_AppendLast 
  | p_2_1=importFragm Surrogate_id_SYMB_0 p_2_3=listImportFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListImportFragm_PrependFirst
;
importFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment($p_1_1.getText()); } # ImportFragment 
;
defs returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs result ] : p_1_1=listDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs($p_1_1.result); } # DefListDefs 
;
listDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef(); } # ListDef_Empty 
  | p_2_1=listDef p_2_2=def  { $result = $p_2_1.result; $result.addLast($p_2_2.result); } # ListDef_PrependFirst
;
def returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def result ] : Surrogate_id_SYMB_21 p_1_2=binding  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef($p_1_2.result); } # SimpleValueDef 
  | Surrogate_id_SYMB_21 p_2_2=funcDecl  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef($p_2_2.result); } # FunctionValueDef
;
funcDecl returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl result ] : p_1_1=JID Surrogate_id_SYMB_1 p_1_3=listParam Surrogate_id_SYMB_2  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl($p_1_1.getText(),$p_1_3.result); } # AbstractTypelessFuncDecl 
  | p_2_1=JID Surrogate_id_SYMB_1 p_2_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_3 p_2_6=typeDesc  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl($p_2_1.getText(),$p_2_3.result,$p_2_6.result); } # AbstractTypedFuncDecl
  | p_3_1=JID Surrogate_id_SYMB_1 p_3_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_4 p_3_6=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl($p_3_1.getText(),$p_3_3.result,$p_3_6.result); } # ConcreteTypelessFuncDecl
  | p_4_1=JID Surrogate_id_SYMB_1 p_4_3=listParam Surrogate_id_SYMB_2 Surrogate_id_SYMB_3 p_4_6=typeDesc Surrogate_id_SYMB_4 p_4_8=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl($p_4_1.getText(),$p_4_3.result,$p_4_6.result,$p_4_8.result); } # ConcreteTypedFuncDecl
;
listParam returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam(); } # ListParam_Empty 
  | p_2_1=param  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam(); $result.addLast($p_2_1.result); } # ListParam_AppendLast
  | p_3_1=param Surrogate_id_SYMB_5 p_3_3=listParam  { $result = $p_3_3.result; $result.addFirst($p_3_1.result); } # ListParam_PrependFirst
;
param returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param result ] : p_1_1=binding  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam($p_1_1.result); } # BindingParam 
;
binding returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding($p_1_1.getText()); } # OnlyNameBinding 
  | p_2_1=JID Surrogate_id_SYMB_3 p_2_3=typeDesc  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding($p_2_1.getText(),$p_2_3.result); } # NameTypeBinding
  | p_3_1=JID Surrogate_id_SYMB_4 p_3_3=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding($p_3_1.getText(),$p_3_3.result); } # NameInitBinding
  | p_4_1=JID Surrogate_id_SYMB_3 p_4_3=typeDesc Surrogate_id_SYMB_4 p_4_5=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding($p_4_1.getText(),$p_4_3.result,$p_4_5.result); } # FullBinding
;
typeDesc returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc result ] : p_1_1=simpleType  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc($p_1_1.result); } # SimpleTypeDesc 
  | p_2_1=funcType  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc($p_2_1.result); } # FuncTypeDesc
;
funcType returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType result ] : Surrogate_id_SYMB_1 Surrogate_id_SYMB_2 Surrogate_id_SYMB_6 p_1_4=funcTypeFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType($p_1_4.result); } # ZeroArgFuncType 
  | p_2_1=funcTypeFragm Surrogate_id_SYMB_6 p_2_3=listFuncTypeFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType($p_2_1.result,$p_2_3.result); } # MultiArgFuncType
;
listFuncTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm result ] : p_1_1=funcTypeFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm(); $result.addLast($p_1_1.result); } # ListFuncTypeFragm_AppendLast 
  | p_2_1=funcTypeFragm Surrogate_id_SYMB_6 p_2_3=listFuncTypeFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListFuncTypeFragm_PrependFirst
;
funcTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm result ] : p_1_1=simpleType  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm($p_1_1.result); } # SimpleFuncTypeFragm 
  | Surrogate_id_SYMB_1 p_2_2=funcType Surrogate_id_SYMB_2  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm($p_2_2.result); } # FuncFuncTypeFragm
;
simpleType returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType result ] : p_1_1=listSimpleTypeFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType($p_1_1.result); } # FragmSimpleType 
;
listSimpleTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm result ] : p_1_1=simpleTypeFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm(); $result.addLast($p_1_1.result); } # ListSimpleTypeFragm_AppendLast 
  | p_2_1=simpleTypeFragm Surrogate_id_SYMB_0 p_2_3=listSimpleTypeFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListSimpleTypeFragm_PrependFirst
;
simpleTypeFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm($p_1_1.getText()); } # IdSimpleTypeFragm 
;
expr returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : Surrogate_id_SYMB_24 p_1_2=expr Surrogate_id_SYMB_29 p_1_4=expr Surrogate_id_SYMB_22 p_1_6=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr($p_1_2.result,$p_1_4.result,$p_1_6.result); } # IfExpr 
  | Surrogate_id_SYMB_27 p_2_2=listLetDef Surrogate_id_SYMB_26 p_2_4=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr($p_2_2.result,$p_2_4.result); } # LetExpr
  | p_3_1=expr1  { $result = $p_3_1.result; } # Coercion_Expr
;
letDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef result ] : p_1_1=binding  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition($p_1_1.result); } # LetDefinition 
;
listLetDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef result ] : p_1_1=letDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef(); $result.addLast($p_1_1.result); } # ListLetDef_AppendLast 
  | p_2_1=letDef Surrogate_id_SYMB_5 p_2_3=listLetDef  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListLetDef_PrependFirst
;
expr1 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr1 Surrogate_id_SYMB_7 p_1_3=expr2  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr($p_1_1.result,$p_1_3.result); } # OrExpr 
  | p_2_1=expr2  { $result = $p_2_1.result; } # Coercion_Expr1
;
expr2 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr2 Surrogate_id_SYMB_8 p_1_3=expr3  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr($p_1_1.result,$p_1_3.result); } # AndExpr 
  | p_2_1=expr3  { $result = $p_2_1.result; } # Coercion_Expr2
;
expr3 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr3 Surrogate_id_SYMB_9 p_1_3=expr4  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr($p_1_1.result,$p_1_3.result); } # EqualityExpr 
  | p_2_1=expr3 Surrogate_id_SYMB_10 p_2_3=expr4  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr($p_2_1.result,$p_2_3.result); } # InequalityExpr
  | p_3_1=expr4  { $result = $p_3_1.result; } # Coercion_Expr3
;
expr4 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr4 Surrogate_id_SYMB_11 p_1_3=expr5  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr($p_1_1.result,$p_1_3.result); } # LesserExpr 
  | p_2_1=expr4 Surrogate_id_SYMB_12 p_2_3=expr5  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr($p_2_1.result,$p_2_3.result); } # LesserEqualExpr
  | p_3_1=expr4 Surrogate_id_SYMB_13 p_3_3=expr5  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr($p_3_1.result,$p_3_3.result); } # GreaterExpr
  | p_4_1=expr4 Surrogate_id_SYMB_14 p_4_3=expr5  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr($p_4_1.result,$p_4_3.result); } # GreaterEqualExpr
  | p_5_1=expr5  { $result = $p_5_1.result; } # Coercion_Expr4
;
expr5 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr5 Surrogate_id_SYMB_15 p_1_3=expr6  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr($p_1_1.result,$p_1_3.result); } # AdditionExpr 
  | p_2_1=expr5 Surrogate_id_SYMB_16 p_2_3=expr6  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr($p_2_1.result,$p_2_3.result); } # SubtractionExpr
  | p_3_1=expr6  { $result = $p_3_1.result; } # Coercion_Expr5
;
expr6 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=expr6 Surrogate_id_SYMB_17 p_1_3=expr7  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr($p_1_1.result,$p_1_3.result); } # MultiplicationExpr 
  | p_2_1=expr6 Surrogate_id_SYMB_18 p_2_3=expr7  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr($p_2_1.result,$p_2_3.result); } # DivisionExpr
  | p_3_1=expr6 Surrogate_id_SYMB_19 p_3_3=expr7  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr($p_3_1.result,$p_3_3.result); } # ModuloExpr
  | p_4_1=expr7  { $result = $p_4_1.result; } # Coercion_Expr6
;
expr7 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : Surrogate_id_SYMB_20 p_1_2=expr8  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr($p_1_2.result); } # NotExpr 
  | Surrogate_id_SYMB_16 p_2_2=expr8  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr($p_2_2.result); } # NegateExpr
  | Surrogate_id_SYMB_15 p_3_2=expr8  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr($p_3_2.result); } # PositateExpr
  | p_4_1=expr8  { $result = $p_4_1.result; } # Coercion_Expr7
;
expr8 returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=literal  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr($p_1_1.result); } # LiteralExpr 
  | p_2_1=valRef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr($p_2_1.result); } # VariableExpr
  | p_3_1=valRef Surrogate_id_SYMB_1 p_3_3=listCallArg Surrogate_id_SYMB_2  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunCallExpr($p_3_1.result,$p_3_3.result); } # FunCallExpr
  | Surrogate_id_SYMB_1 p_4_2=expr Surrogate_id_SYMB_2  { $result = $p_4_2.result; } # Coercion_Expr8
;
callArg returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg result ] : p_1_1=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg($p_1_1.result); } # ExprCallArg 
;
listCallArg returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg(); } # ListCallArg_Empty 
  | p_2_1=callArg  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg(); $result.addLast($p_2_1.result); } # ListCallArg_AppendLast
  | p_3_1=callArg Surrogate_id_SYMB_5 p_3_3=listCallArg  { $result = $p_3_3.result; $result.addFirst($p_3_1.result); } # ListCallArg_PrependFirst
;
valRef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef result ] : p_1_1=listValRefFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef($p_1_1.result); } # ValueRef 
;
listValRefFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm result ] : p_1_1=valRefFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); $result.addLast($p_1_1.result); } # ListValRefFragm_AppendLast 
  | p_2_1=valRefFragm Surrogate_id_SYMB_0 p_2_3=listValRefFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListValRefFragm_PrependFirst
;
valRefFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment($p_1_1.getText()); } # ValueRefFragment 
;
literal returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal result ] : p_1_1=INTEGER  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt($p_1_1.getText())); } # IntLiteral 
  | Surrogate_id_SYMB_31  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); } # UnitLiteral
  | Surrogate_id_SYMB_30  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); } # BoolTrueLiteral
  | Surrogate_id_SYMB_23  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); } # BoolFalseLiteral
  | p_5_1=JCHAR  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral($p_5_1.getText()); } # CharLiteral
  | p_6_1=JSTRING  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral($p_6_1.getText()); } # StringLiteral
;

