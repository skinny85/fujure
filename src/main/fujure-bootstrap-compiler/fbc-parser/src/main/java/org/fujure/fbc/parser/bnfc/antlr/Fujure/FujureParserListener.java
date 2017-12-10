// Generated from org/fujure/fbc/parser/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by the {@code Definitions}
	 * labeled alternative in {@link FujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(FujureParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Definitions}
	 * labeled alternative in {@link FujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(FujureParser.DefinitionsContext ctx);
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
	 * Enter a parse tree produced by the {@code ValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void enterValueDef(FujureParser.ValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueDef}
	 * labeled alternative in {@link FujureParser#def}.
	 * @param ctx the parse tree
	 */
	void exitValueDef(FujureParser.ValueDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UntypedValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void enterUntypedValueDef(FujureParser.UntypedValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UntypedValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void exitUntypedValueDef(FujureParser.UntypedValueDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypedValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void enterTypedValueDef(FujureParser.TypedValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypedValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void exitTypedValueDef(FujureParser.TypedValueDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSpecifier}
	 * labeled alternative in {@link FujureParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(FujureParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSpecifier}
	 * labeled alternative in {@link FujureParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(FujureParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListTypeSpecFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listTypeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void enterListTypeSpecFragm_AppendLast(FujureParser.ListTypeSpecFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListTypeSpecFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listTypeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void exitListTypeSpecFragm_AppendLast(FujureParser.ListTypeSpecFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListTypeSpecFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listTypeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void enterListTypeSpecFragm_PrependFirst(FujureParser.ListTypeSpecFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListTypeSpecFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listTypeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void exitListTypeSpecFragm_PrependFirst(FujureParser.ListTypeSpecFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSpecFragment}
	 * labeled alternative in {@link FujureParser#typeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecFragment(FujureParser.TypeSpecFragmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSpecFragment}
	 * labeled alternative in {@link FujureParser#typeSpecFragm}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecFragment(FujureParser.TypeSpecFragmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(FujureParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableExpr}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(FujureParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(FujureParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link FujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(FujureParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueRef}
	 * labeled alternative in {@link FujureParser#valRef}.
	 * @param ctx the parse tree
	 */
	void enterValueRef(FujureParser.ValueRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueRef}
	 * labeled alternative in {@link FujureParser#valRef}.
	 * @param ctx the parse tree
	 */
	void exitValueRef(FujureParser.ValueRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValRefFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listValRefFragm}.
	 * @param ctx the parse tree
	 */
	void enterListValRefFragm_AppendLast(FujureParser.ListValRefFragm_AppendLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValRefFragm_AppendLast}
	 * labeled alternative in {@link FujureParser#listValRefFragm}.
	 * @param ctx the parse tree
	 */
	void exitListValRefFragm_AppendLast(FujureParser.ListValRefFragm_AppendLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValRefFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listValRefFragm}.
	 * @param ctx the parse tree
	 */
	void enterListValRefFragm_PrependFirst(FujureParser.ListValRefFragm_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValRefFragm_PrependFirst}
	 * labeled alternative in {@link FujureParser#listValRefFragm}.
	 * @param ctx the parse tree
	 */
	void exitListValRefFragm_PrependFirst(FujureParser.ListValRefFragm_PrependFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueRefFragment}
	 * labeled alternative in {@link FujureParser#valRefFragm}.
	 * @param ctx the parse tree
	 */
	void enterValueRefFragment(FujureParser.ValueRefFragmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueRefFragment}
	 * labeled alternative in {@link FujureParser#valRefFragm}.
	 * @param ctx the parse tree
	 */
	void exitValueRefFragment(FujureParser.ValueRefFragmentContext ctx);
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