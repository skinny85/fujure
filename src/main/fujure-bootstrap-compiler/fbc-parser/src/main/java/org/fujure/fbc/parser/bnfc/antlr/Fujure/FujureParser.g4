// -*- Java -*- This ANTLRv4 file was machine-generated by BNFC
parser grammar FujureParser;

options {
  tokenVocab = FujureLexer;
}

fileContents returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents result ] : Surrogate_id_SYMB_4 p_1_2=pkgName p_1_3=defs  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage($p_1_2.result,$p_1_3.result); } # FileInNamedPackage 
  | p_2_1=defs  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage($p_2_1.result); } # FileInDefaultPackage
;
pkgName returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName result ] : p_1_1=listPkgFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName($p_1_1.result); } # PackageName 
;
listPkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm result ] : p_1_1=pkgFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); $result.addLast($p_1_1.result); } # ListPkgFragm_AppendLast 
  | p_2_1=pkgFragm Surrogate_id_SYMB_0 p_2_3=listPkgFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListPkgFragm_PrependFirst
;
pkgFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm result ] : p_1_1=IDENT  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment($p_1_1.getText()); } # PackageFragment 
;
defs returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs result ] : p_1_1=listDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions($p_1_1.result); } # Definitions 
;
listDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef result ] :  /* empty */  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef(); } # ListDef_Empty 
  | p_2_1=listDef p_2_2=def  { $result = $p_2_1.result; $result.addLast($p_2_2.result); } # ListDef_PrependFirst
;
def returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def result ] : p_1_1=valDef  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueDef($p_1_1.result); } # ValueDef 
;
valDef returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValDef result ] : Surrogate_id_SYMB_3 p_1_2=IDENT Surrogate_id_SYMB_1 p_1_4=INTEGER  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UntypedValueDef($p_1_2.getText(),Integer.parseInt($p_1_4.getText())); } # UntypedValueDef 
  | Surrogate_id_SYMB_3 p_2_2=IDENT Surrogate_id_SYMB_2 p_2_4=typeSpec Surrogate_id_SYMB_1 p_2_6=INTEGER  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypedValueDef($p_2_2.getText(),$p_2_4.result,Integer.parseInt($p_2_6.getText())); } # TypedValueDef
;
typeSpec returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec result ] : p_1_1=listTypeSpecFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier($p_1_1.result); } # TypeSpecifier 
;
listTypeSpecFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm result ] : p_1_1=typeSpecFragm  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); $result.addLast($p_1_1.result); } # ListTypeSpecFragm_AppendLast 
  | p_2_1=typeSpecFragm Surrogate_id_SYMB_0 p_2_3=listTypeSpecFragm  { $result = $p_2_3.result; $result.addFirst($p_2_1.result); } # ListTypeSpecFragm_PrependFirst
;
typeSpecFragm returns [ org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm result ] : p_1_1=IDENT  { $result = new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment($p_1_1.getText()); } # TypeSpecFragment 
;

