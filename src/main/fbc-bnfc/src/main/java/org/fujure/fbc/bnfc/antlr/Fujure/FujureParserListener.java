// Generated from org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.7
package org.fujure.fbc.bnfc.antlr.Fujure;
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
	 * Enter a parse tree produced by the {@code ListValDef_Empty}
	 * labeled alternative in {@link FujureParser#listValDef}.
	 * @param ctx the parse tree
	 */
	void enterListValDef_Empty(FujureParser.ListValDef_EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValDef_Empty}
	 * labeled alternative in {@link FujureParser#listValDef}.
	 * @param ctx the parse tree
	 */
	void exitListValDef_Empty(FujureParser.ListValDef_EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listValDef}.
	 * @param ctx the parse tree
	 */
	void enterListValDef_PrependFirst(FujureParser.ListValDef_PrependFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValDef_PrependFirst}
	 * labeled alternative in {@link FujureParser#listValDef}.
	 * @param ctx the parse tree
	 */
	void exitListValDef_PrependFirst(FujureParser.ListValDef_PrependFirstContext ctx);
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
}