// Generated from org/fujure/fbc/parser/bnfc/antlr/fujure/fujureParser.g4 by ANTLR 4.5.1
package org.fujure.fbc.parser.bnfc.antlr.fujure;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fujureParser}.
 */
public interface fujureParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fujureParser#start_FileContents}.
	 * @param ctx the parse tree
	 */
	void enterStart_FileContents(fujureParser.Start_FileContentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#start_FileContents}.
	 * @param ctx the parse tree
	 */
	void exitStart_FileContents(fujureParser.Start_FileContentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void enterFileContents(fujureParser.FileContentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#fileContents}.
	 * @param ctx the parse tree
	 */
	void exitFileContents(fujureParser.FileContentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void enterPkgName(fujureParser.PkgNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void exitPkgName(fujureParser.PkgNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void enterListPkgFragm(fujureParser.ListPkgFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listPkgFragm}.
	 * @param ctx the parse tree
	 */
	void exitListPkgFragm(fujureParser.ListPkgFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#pkgFragm}.
	 * @param ctx the parse tree
	 */
	void enterPkgFragm(fujureParser.PkgFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#pkgFragm}.
	 * @param ctx the parse tree
	 */
	void exitPkgFragm(fujureParser.PkgFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(fujureParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(fujureParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void enterListImport(fujureParser.ListImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listImport}.
	 * @param ctx the parse tree
	 */
	void exitListImport(fujureParser.ListImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(fujureParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(fujureParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void enterListImportFragm(fujureParser.ListImportFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listImportFragm}.
	 * @param ctx the parse tree
	 */
	void exitListImportFragm(fujureParser.ListImportFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#importFragm}.
	 * @param ctx the parse tree
	 */
	void enterImportFragm(fujureParser.ImportFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#importFragm}.
	 * @param ctx the parse tree
	 */
	void exitImportFragm(fujureParser.ImportFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefs(fujureParser.DefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefs(fujureParser.DefsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void enterListDef(fujureParser.ListDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listDef}.
	 * @param ctx the parse tree
	 */
	void exitListDef(fujureParser.ListDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(fujureParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(fujureParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(fujureParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(fujureParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void enterListParam(fujureParser.ListParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listParam}.
	 * @param ctx the parse tree
	 */
	void exitListParam(fujureParser.ListParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(fujureParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(fujureParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(fujureParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(fujureParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void enterTypeDesc(fujureParser.TypeDescContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#typeDesc}.
	 * @param ctx the parse tree
	 */
	void exitTypeDesc(fujureParser.TypeDescContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(fujureParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(fujureParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListFuncTypeFragm(fujureParser.ListFuncTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listFuncTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListFuncTypeFragm(fujureParser.ListFuncTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterFuncTypeFragm(fujureParser.FuncTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#funcTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitFuncTypeFragm(fujureParser.FuncTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(fujureParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(fujureParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterListSimpleTypeFragm(fujureParser.ListSimpleTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listSimpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitListSimpleTypeFragm(fujureParser.ListSimpleTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#simpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeFragm(fujureParser.SimpleTypeFragmContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#simpleTypeFragm}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeFragm(fujureParser.SimpleTypeFragmContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listGenericTypeValue}.
	 * @param ctx the parse tree
	 */
	void enterListGenericTypeValue(fujureParser.ListGenericTypeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listGenericTypeValue}.
	 * @param ctx the parse tree
	 */
	void exitListGenericTypeValue(fujureParser.ListGenericTypeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#genericTypeValue}.
	 * @param ctx the parse tree
	 */
	void enterGenericTypeValue(fujureParser.GenericTypeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#genericTypeValue}.
	 * @param ctx the parse tree
	 */
	void exitGenericTypeValue(fujureParser.GenericTypeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(fujureParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(fujureParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#letDef}.
	 * @param ctx the parse tree
	 */
	void enterLetDef(fujureParser.LetDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#letDef}.
	 * @param ctx the parse tree
	 */
	void exitLetDef(fujureParser.LetDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void enterListLetDef(fujureParser.ListLetDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listLetDef}.
	 * @param ctx the parse tree
	 */
	void exitListLetDef(fujureParser.ListLetDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listStmt}.
	 * @param ctx the parse tree
	 */
	void enterListStmt(fujureParser.ListStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listStmt}.
	 * @param ctx the parse tree
	 */
	void exitListStmt(fujureParser.ListStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(fujureParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(fujureParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1(fujureParser.Expr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1(fujureParser.Expr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(fujureParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(fujureParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr3(fujureParser.Expr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr3(fujureParser.Expr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterExpr4(fujureParser.Expr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitExpr4(fujureParser.Expr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterExpr5(fujureParser.Expr5Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitExpr5(fujureParser.Expr5Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterExpr6(fujureParser.Expr6Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitExpr6(fujureParser.Expr6Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterExpr7(fujureParser.Expr7Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitExpr7(fujureParser.Expr7Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterExpr8(fujureParser.Expr8Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitExpr8(fujureParser.Expr8Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void enterExpr9(fujureParser.Expr9Context ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#expr9}.
	 * @param ctx the parse tree
	 */
	void exitExpr9(fujureParser.Expr9Context ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#callArg}.
	 * @param ctx the parse tree
	 */
	void enterCallArg(fujureParser.CallArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#callArg}.
	 * @param ctx the parse tree
	 */
	void exitCallArg(fujureParser.CallArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void enterListCallArg(fujureParser.ListCallArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#listCallArg}.
	 * @param ctx the parse tree
	 */
	void exitListCallArg(fujureParser.ListCallArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link fujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(fujureParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link fujureParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(fujureParser.LiteralContext ctx);
}