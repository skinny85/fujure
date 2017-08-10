// Generated from org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.7
package org.fujure.fjc.bnfc.antlr.Fujure;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FujureParser}.
 */
public interface FujureParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code VDef}
	 * labeled alternative in {@link FujureParser#valueDef}.
	 * @param ctx the parse tree
	 */
	void enterVDef(FujureParser.VDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VDef}
	 * labeled alternative in {@link FujureParser#valueDef}.
	 * @param ctx the parse tree
	 */
	void exitVDef(FujureParser.VDefContext ctx);
}