// -*- Java -*- This ANTLRv4 file was machine-generated by BNFC
parser grammar FujureParser;

options {
  tokenVocab = FujureLexer;
}

fileContents returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents result ] : Surrogate_id_SYMB_6 p_1_2=pkgName p_1_3=imports p_1_4=defs  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage($p_1_2.result,$p_1_3.result,$p_1_4.result); } # FileInNamedPackage 
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
import_ returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import result ] : Surrogate_id_SYMB_5 p_1_2=listImportFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt($p_1_2.result); } # ImportStmt 
;
listImportFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm result ] : p_1_1=importFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); $result.addLast($p_1_1.result); } # ListImportFragm_AppendLast 
  | p_2_1=importFragm Surrogate_id_SYMB_0 p_2_3=listImportFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListImportFragm_PrependFirst
;
importFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment($p_1_1.getText()); } # ImportFragment 
;
defs returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs result ] : p_1_1=listDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions($p_1_1.result); } # Definitions 
;
listDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef(); } # ListDef_Empty 
  | p_2_1=listDef p_2_2=def  { $result = $p_2_1.result; $result.addLast($p_2_2.result); } # ListDef_PrependFirst
;
def returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def result ] : p_1_1=valDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef($p_1_1.result); } # ValueDef 
;
valDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef result ] : Surrogate_id_SYMB_3 p_1_2=JID Surrogate_id_SYMB_1 p_1_4=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef($p_1_2.getText(),$p_1_4.result); } # UntypedValueDef 
  | Surrogate_id_SYMB_3 p_2_2=JID Surrogate_id_SYMB_2 p_2_4=typeSpec Surrogate_id_SYMB_1 p_2_6=expr  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef($p_2_2.getText(),$p_2_4.result,$p_2_6.result); } # TypedValueDef
;
typeSpec returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec result ] : p_1_1=listTypeSpecFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier($p_1_1.result); } # TypeSpecifier 
;
listTypeSpecFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm result ] : p_1_1=typeSpecFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); $result.addLast($p_1_1.result); } # ListTypeSpecFragm_AppendLast 
  | p_2_1=typeSpecFragm Surrogate_id_SYMB_0 p_2_3=listTypeSpecFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListTypeSpecFragm_PrependFirst
;
typeSpecFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment($p_1_1.getText()); } # TypeSpecFragment 
;
expr returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result ] : p_1_1=valRef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr($p_1_1.result); } # VariableExpr 
  | p_2_1=literal  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprLiteral($p_2_1.result); } # ExprLiteral
;
valRef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef result ] : p_1_1=listValRefFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef($p_1_1.result); } # ValueRef 
;
listValRefFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm result ] : p_1_1=valRefFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); $result.addLast($p_1_1.result); } # ListValRefFragm_AppendLast 
  | p_2_1=valRefFragm Surrogate_id_SYMB_0 p_2_3=listValRefFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListValRefFragm_PrependFirst
;
valRefFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm result ] : p_1_1=JID  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment($p_1_1.getText()); } # ValueRefFragment 
;
literal returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal result ] : p_1_1=INTEGER  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt($p_1_1.getText())); } # IntLiteral 
  | Surrogate_id_SYMB_8  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); } # UnitLiteral
  | Surrogate_id_SYMB_7  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); } # BoolTrueLiteral
  | Surrogate_id_SYMB_4  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); } # BoolFalseLiteral
  | p_5_1=CHAR  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral($p_5_1.getText().charAt(1)); } # CharLiteral
;

