// Generated from Fujure/FujureParser.g4 by ANTLR 4.7
package Fujure;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FujureParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, INTEGER=3, IDENT=4, WS=5, 
		ErrorToken=6;
	public static final int
		RULE_valueDef = 0;
	public static final String[] ruleNames = {
		"valueDef"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'def'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "INTEGER", "IDENT", 
		"WS", "ErrorToken"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FujureParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FujureParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ValueDefContext extends ParserRuleContext {
		public Fujure.Absyn.ValueDef result;
		public ValueDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueDef; }
	 
		public ValueDefContext() { }
		public void copyFrom(ValueDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class VDefContext extends ValueDefContext {
		public Token p_1_2;
		public Token p_1_4;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode IDENT() { return getToken(FujureParser.IDENT, 0); }
		public TerminalNode INTEGER() { return getToken(FujureParser.INTEGER, 0); }
		public VDefContext(ValueDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterVDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitVDef(this);
		}
	}

	public final ValueDefContext valueDef() throws RecognitionException {
		ValueDefContext _localctx = new ValueDefContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_valueDef);
		try {
			_localctx = new VDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(Surrogate_id_SYMB_1);
			setState(3);
			((VDefContext)_localctx).p_1_2 = match(IDENT);
			setState(4);
			match(Surrogate_id_SYMB_0);
			setState(5);
			((VDefContext)_localctx).p_1_4 = match(INTEGER);
			 ((VDefContext)_localctx).result =  new Fujure.Absyn.VDef(((VDefContext)_localctx).p_1_2.getText(),Integer.parseInt(((VDefContext)_localctx).p_1_4.getText())); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\13\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\2\2\3\2\2\2\2\t\2\4\3\2\2\2\4\5\7\4\2\2\5\6\7"+
		"\6\2\2\6\7\7\3\2\2\7\b\7\5\2\2\b\t\b\2\1\2\t\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}