// Generated from org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.7
package org.fujure.fbc.bnfc.antlr.Fujure;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FujureParser}.
 */
public interface FujureParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void enterValueDef(FujureParser.ValueDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueDef}
	 * labeled alternative in {@link FujureParser#valDef}.
	 * @param ctx the parse tree
	 */
	void exitValueDef(FujureParser.ValueDefContext ctx);
}