// Generated from org/fujure/fbc/parser/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.5.1
package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FujureParser}.
 */
public interface FujureParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code FileInNamedPackage}
	 * labeled alternative in {@link FujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void enterFileInNamedPackage(FujureParser.FileInNamedPackageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FileInNamedPackage}
	 * labeled alternative in {@link FujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void exitFileInNamedPackage(FujureParser.FileInNamedPackageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FileInDefaultPackage}
	 * labeled alternative in {@link FujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void enterFileInDefaultPackage(FujureParser.FileInDefaultPackageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FileInDefaultPackage}
	 * labeled alternative in {@link FujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void exitFileInDefaultPackage(FujureParser.FileInDefaultPackageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PackageName}
	 * labeled alternative in {@link FujureParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(FujureParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PackageName}
	 * labeled alternative in {@link FujureParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(FujureParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListPkgFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void enterListPkgFragm_AppendLast(FujureParser.ListPkgFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListPkgFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void exitListPkgFragm_AppendLast(FujureParser.ListPkgFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListPkgFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void enterListPkgFragm_PrependFirst(FujureParser.ListPkgFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListPkgFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void exitListPkgFragm_PrependFirst(FujureParser.ListPkgFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PackageFragment}
	 * labeled alternative in {@link FujureParser#pkgFragm}.
	 * @param ctx the parse tree
	 */
	void enterPackageFragment(FujureParser.PackageFragmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PackageFragment}
	 * labeled alternative in {@link FujureParser#pkgFragm}.
	 * @param ctx the parse tree
	 */
	void exitPackageFragment(FujureParser.PackageFragmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStmts}
	 * labeled alternative in {@link FujureParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImportStmts(FujureParser.ImportStmtsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStmts}
	 * labeled alternative in {@link FujureParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImportStmts(FujureParser.ImportStmtsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListImport_Empty}
	 * labeled alternative in {@link FujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void enterListImport_Empty(FujureParser.ListImport_EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListImport_Empty}
	 * labeled alternative in {@link FujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void exitListImport_Empty(FujureParser.ListImport_EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListImport_PrependFirst}
	 * labeled alternative in {@link FujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void enterListImport_PrependFirst(FujureParser.ListImport_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListImport_PrependFirst}
	 * labeled alternative in {@link FujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void exitListImport_PrependFirst(FujureParser.ListImport_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link FujureParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(FujureParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStmt}
	 * labeled alternative in {@link FujureParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(FujureParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListImportFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void enterListImportFragm_AppendLast(FujureParser.ListImportFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListImportFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void exitListImportFragm_AppendLast(FujureParser.ListImportFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListImportFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void enterListImportFragm_PrependFirst(FujureParser.ListImportFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListImportFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void exitListImportFragm_PrependFirst(FujureParser.ListImportFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportFragment}
	 * labeled alternative in {@link FujureParser#importFragm}.
	 * @param ctx the parse tree
	 */
	void enterImportFragment(FujureParser.ImportFragmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportFragment}
	 * labeled alternative in {@link FujureParser#importFragm}.
	 * @param ctx the parse tree
	 */
	void exitImportFragment(FujureParser.ImportFragmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefListDefs}
	 * labeled alternative in {@link FujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefListDefs(FujureParser.DefListDefsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefListDefs}
	 * labeled alternative in {@link FujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefListDefs(FujureParser.DefListDefsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListDef_Empty}
	 * labeled alternative in {@link FujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void enterListDef_Empty(FujureParser.ListDef_EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListDef_Empty}
	 * labeled alternative in {@link FujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void exitListDef_Empty(FujureParser.ListDef_EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void enterListDef_PrependFirst(FujureParser.ListDef_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void exitListDef_PrependFirst(FujureParser.ListDef_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void enterSimpleValueDef(FujureParser.SimpleValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void exitSimpleValueDef(FujureParser.SimpleValueDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void enterFunctionValueDef(FujureParser.FunctionValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void exitFunctionValueDef(FujureParser.FunctionValueDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbstractTypelessFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterAbstractTypelessFuncDecl(FujureParser.AbstractTypelessFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbstractTypelessFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitAbstractTypelessFuncDecl(FujureParser.AbstractTypelessFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbstractTypedFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterAbstractTypedFuncDecl(FujureParser.AbstractTypedFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbstractTypedFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitAbstractTypedFuncDecl(FujureParser.AbstractTypedFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcreteTypelessFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterConcreteTypelessFuncDecl(FujureParser.ConcreteTypelessFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcreteTypelessFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitConcreteTypelessFuncDecl(FujureParser.ConcreteTypelessFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcreteTypedFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterConcreteTypedFuncDecl(FujureParser.ConcreteTypedFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcreteTypedFuncDecl}
	 * labeled alternative in {@link FujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitConcreteTypedFuncDecl(FujureParser.ConcreteTypedFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListParam_Empty}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void enterListParam_Empty(FujureParser.ListParam_EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListParam_Empty}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void exitListParam_Empty(FujureParser.ListParam_EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListParam_AppendLast}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void enterListParam_AppendLast(FujureParser.ListParam_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListParam_AppendLast}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void exitListParam_AppendLast(FujureParser.ListParam_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListParam_PrependFirst}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void enterListParam_PrependFirst(FujureParser.ListParam_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListParam_PrependFirst}
	 * labeled alternative in {@link FujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void exitListParam_PrependFirst(FujureParser.ListParam_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BindingParam}
	 * labeled alternative in {@link FujureParser#param}.
	 * @param ctx the parse tree
	 */
	void enterBindingParam(FujureParser.BindingParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BindingParam}
	 * labeled alternative in {@link FujureParser#param}.
	 * @param ctx the parse tree
	 */
	void exitBindingParam(FujureParser.BindingParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OnlyNameBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterOnlyNameBinding(FujureParser.OnlyNameBindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OnlyNameBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitOnlyNameBinding(FujureParser.OnlyNameBindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NameTypeBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterNameTypeBinding(FujureParser.NameTypeBindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NameTypeBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitNameTypeBinding(FujureParser.NameTypeBindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NameInitBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterNameInitBinding(FujureParser.NameInitBindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NameInitBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitNameInitBinding(FujureParser.NameInitBindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterFullBinding(FujureParser.FullBindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullBinding}
	 * labeled alternative in {@link FujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitFullBinding(FujureParser.FullBindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleTypeDesc}
	 * labeled alternative in {@link FujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeDesc(FujureParser.SimpleTypeDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleTypeDesc}
	 * labeled alternative in {@link FujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeDesc(FujureParser.SimpleTypeDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncTypeDesc}
	 * labeled alternative in {@link FujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void enterFuncTypeDesc(FujureParser.FuncTypeDescContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncTypeDesc}
	 * labeled alternative in {@link FujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void exitFuncTypeDesc(FujureParser.FuncTypeDescContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ZeroArgFuncType}
	 * labeled alternative in {@link FujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterZeroArgFuncType(FujureParser.ZeroArgFuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ZeroArgFuncType}
	 * labeled alternative in {@link FujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitZeroArgFuncType(FujureParser.ZeroArgFuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiArgFuncType}
	 * labeled alternative in {@link FujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterMultiArgFuncType(FujureParser.MultiArgFuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiArgFuncType}
	 * labeled alternative in {@link FujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitMultiArgFuncType(FujureParser.MultiArgFuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListFuncTypeFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListFuncTypeFragm_AppendLast(FujureParser.ListFuncTypeFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListFuncTypeFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListFuncTypeFragm_AppendLast(FujureParser.ListFuncTypeFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListFuncTypeFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListFuncTypeFragm_PrependFirst(FujureParser.ListFuncTypeFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListFuncTypeFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListFuncTypeFragm_PrependFirst(FujureParser.ListFuncTypeFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleFuncTypeFragm}
	 * labeled alternative in {@link FujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFuncTypeFragm(FujureParser.SimpleFuncTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleFuncTypeFragm}
	 * labeled alternative in {@link FujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFuncTypeFragm(FujureParser.SimpleFuncTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncFuncTypeFragm}
	 * labeled alternative in {@link FujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterFuncFuncTypeFragm(FujureParser.FuncFuncTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncFuncTypeFragm}
	 * labeled alternative in {@link FujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitFuncFuncTypeFragm(FujureParser.FuncFuncTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FragmSimpleType}
	 * labeled alternative in {@link FujureParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterFragmSimpleType(FujureParser.FragmSimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FragmSimpleType}
	 * labeled alternative in {@link FujureParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitFragmSimpleType(FujureParser.FragmSimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListSimpleTypeFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListSimpleTypeFragm_AppendLast(FujureParser.ListSimpleTypeFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListSimpleTypeFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListSimpleTypeFragm_AppendLast(FujureParser.ListSimpleTypeFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListSimpleTypeFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListSimpleTypeFragm_PrependFirst(FujureParser.ListSimpleTypeFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListSimpleTypeFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListSimpleTypeFragm_PrependFirst(FujureParser.ListSimpleTypeFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdSimpleTypeFragm}
	 * labeled alternative in {@link FujureParser#simpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterIdSimpleTypeFragm(FujureParser.IdSimpleTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdSimpleTypeFragm}
	 * labeled alternative in {@link FujureParser#simpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitIdSimpleTypeFragm(FujureParser.IdSimpleTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(FujureParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(FujureParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(FujureParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(FujureParser.LetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr(FujureParser.Coercion_ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr(FujureParser.Coercion_ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetDefinition}
	 * labeled alternative in {@link FujureParser#letDef}.
	 * @param ctx the parse tree
	 */
	void enterLetDefinition(FujureParser.LetDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetDefinition}
	 * labeled alternative in {@link FujureParser#letDef}.
	 * @param ctx the parse tree
	 */
	void exitLetDefinition(FujureParser.LetDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListLetDef_AppendLast}
	 * labeled alternative in {@link FujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void enterListLetDef_AppendLast(FujureParser.ListLetDef_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListLetDef_AppendLast}
	 * labeled alternative in {@link FujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void exitListLetDef_AppendLast(FujureParser.ListLetDef_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListLetDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void enterListLetDef_PrependFirst(FujureParser.ListLetDef_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListLetDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void exitListLetDef_PrependFirst(FujureParser.ListLetDef_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr1}
	 * labeled alternative in {@link FujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr1(FujureParser.Coercion_Expr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr1}
	 * labeled alternative in {@link FujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr1(FujureParser.Coercion_Expr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link FujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(FujureParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link FujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(FujureParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link FujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(FujureParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link FujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(FujureParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr2}
	 * labeled alternative in {@link FujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr2(FujureParser.Coercion_Expr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr2}
	 * labeled alternative in {@link FujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr2(FujureParser.Coercion_Expr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(FujureParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(FujureParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InequalityExpr}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterInequalityExpr(FujureParser.InequalityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InequalityExpr}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitInequalityExpr(FujureParser.InequalityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr3}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr3(FujureParser.Coercion_Expr3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr3}
	 * labeled alternative in {@link FujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr3(FujureParser.Coercion_Expr3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code LesserEqualExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterLesserEqualExpr(FujureParser.LesserEqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LesserEqualExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitLesserEqualExpr(FujureParser.LesserEqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterGreaterExpr(FujureParser.GreaterExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitGreaterExpr(FujureParser.GreaterExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LesserExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterLesserExpr(FujureParser.LesserExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LesserExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitLesserExpr(FujureParser.LesserExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterEqualExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqualExpr(FujureParser.GreaterEqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterEqualExpr}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqualExpr(FujureParser.GreaterEqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr4}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr4(FujureParser.Coercion_Expr4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr4}
	 * labeled alternative in {@link FujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr4(FujureParser.Coercion_Expr4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionExpr}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpr(FujureParser.AdditionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionExpr}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpr(FujureParser.AdditionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractionExpr}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionExpr(FujureParser.SubtractionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractionExpr}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionExpr(FujureParser.SubtractionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr5}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr5(FujureParser.Coercion_Expr5Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr5}
	 * labeled alternative in {@link FujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr5(FujureParser.Coercion_Expr5Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ModuloExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterModuloExpr(FujureParser.ModuloExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModuloExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitModuloExpr(FujureParser.ModuloExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr6}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr6(FujureParser.Coercion_Expr6Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr6}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr6(FujureParser.Coercion_Expr6Context ctx);
	/**
	 * Enter a parse tree produced by the {@code DivisionExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpr(FujureParser.DivisionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivisionExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpr(FujureParser.DivisionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(FujureParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationExpr}
	 * labeled alternative in {@link FujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(FujureParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(FujureParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(FujureParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegateExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterNegateExpr(FujureParser.NegateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegateExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitNegateExpr(FujureParser.NegateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PositateExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterPositateExpr(FujureParser.PositateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PositateExpr}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitPositateExpr(FujureParser.PositateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr7}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr7(FujureParser.Coercion_Expr7Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr7}
	 * labeled alternative in {@link FujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr7(FujureParser.Coercion_Expr7Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ComplexRefExpr}
	 * labeled alternative in {@link FujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterComplexRefExpr(FujureParser.ComplexRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComplexRefExpr}
	 * labeled alternative in {@link FujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitComplexRefExpr(FujureParser.ComplexRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr8}
	 * labeled alternative in {@link FujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr8(FujureParser.Coercion_Expr8Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr8}
	 * labeled alternative in {@link FujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr8(FujureParser.Coercion_Expr8Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleRefExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterSimpleRefExpr(FujureParser.SimpleRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleRefExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitSimpleRefExpr(FujureParser.SimpleRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coercion_Expr9}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterCoercion_Expr9(FujureParser.Coercion_Expr9Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Coercion_Expr9}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitCoercion_Expr9(FujureParser.Coercion_Expr9Context ctx);
	/**
	 * Enter a parse tree produced by the {@code MethCallExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterMethCallExpr(FujureParser.MethCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethCallExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitMethCallExpr(FujureParser.MethCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(FujureParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(FujureParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(FujureParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link FujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(FujureParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCallArg}
	 * labeled alternative in {@link FujureParser#callArg}.
	 * @param ctx the parse tree
	 */
	void enterExprCallArg(FujureParser.ExprCallArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCallArg}
	 * labeled alternative in {@link FujureParser#callArg}.
	 * @param ctx the parse tree
	 */
	void exitExprCallArg(FujureParser.ExprCallArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListCallArg_Empty}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void enterListCallArg_Empty(FujureParser.ListCallArg_EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListCallArg_Empty}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void exitListCallArg_Empty(FujureParser.ListCallArg_EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListCallArg_AppendLast}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void enterListCallArg_AppendLast(FujureParser.ListCallArg_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListCallArg_AppendLast}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void exitListCallArg_AppendLast(FujureParser.ListCallArg_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListCallArg_PrependFirst}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void enterListCallArg_PrependFirst(FujureParser.ListCallArg_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListCallArg_PrependFirst}
	 * labeled alternative in {@link FujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void exitListCallArg_PrependFirst(FujureParser.ListCallArg_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(FujureParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(FujureParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnitLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterUnitLiteral(FujureParser.UnitLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnitLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitUnitLiteral(FujureParser.UnitLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrueLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrueLiteral(FujureParser.BoolTrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrueLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrueLiteral(FujureParser.BoolTrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalseLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalseLiteral(FujureParser.BoolFalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalseLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalseLiteral(FujureParser.BoolFalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(FujureParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(FujureParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(FujureParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link FujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(FujureParser.StringLiteralContext ctx);
}