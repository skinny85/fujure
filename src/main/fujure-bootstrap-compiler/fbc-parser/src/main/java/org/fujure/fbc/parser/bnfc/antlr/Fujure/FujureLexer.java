// Generated from org/fujure/fbc/parser/bnfc/antlr/Fujure/FujureLexer.g4 by ANTLR 4.7
package org.fujure.fbc.parser.bnfc.antlr.Fujure;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FujureLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, Surrogate_id_SYMB_2=3, Surrogate_id_SYMB_3=4, 
		Surrogate_id_SYMB_4=5, Surrogate_id_SYMB_5=6, Surrogate_id_SYMB_6=7, Surrogate_id_SYMB_7=8, 
		Surrogate_id_SYMB_8=9, JID=10, INTEGER=11, WS=12, ErrorToken=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", 
		"INTEGER", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "INTEGER", "WS", 
		"ErrorToken"
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


	public FujureLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FujureLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2*\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\5\17]\n\17\3\17\3\17\3\17\7\17b\n\17\f\17"+
		"\16\17e\13\17\3\20\6\20h\n\20\r\20\16\20i\3\21\6\21m\n\21\r\21\16\21n"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\2\2\24\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21"+
		"\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\2%\17\3\2\b\5\2C\\\u00c2\u00d8"+
		"\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&&aa\5\2\13\f\17"+
		"\17\"\"\7\2$$^^ppttvv\2w\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2\2\2\3)\3\2\2\2\5+\3\2\2"+
		"\2\7-\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21\67"+
		"\3\2\2\2\23;\3\2\2\2\25A\3\2\2\2\27H\3\2\2\2\31P\3\2\2\2\33U\3\2\2\2\35"+
		"\\\3\2\2\2\37g\3\2\2\2!l\3\2\2\2#r\3\2\2\2%t\3\2\2\2\'*\5\5\3\2(*\5\7"+
		"\4\2)\'\3\2\2\2)(\3\2\2\2*\4\3\2\2\2+,\t\2\2\2,\6\3\2\2\2-.\t\3\2\2.\b"+
		"\3\2\2\2/\60\t\4\2\2\60\n\3\2\2\2\61\62\7\60\2\2\62\f\3\2\2\2\63\64\7"+
		"?\2\2\64\16\3\2\2\2\65\66\7<\2\2\66\20\3\2\2\2\678\7f\2\289\7g\2\29:\7"+
		"h\2\2:\22\3\2\2\2;<\7h\2\2<=\7c\2\2=>\7n\2\2>?\7u\2\2?@\7g\2\2@\24\3\2"+
		"\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7q\2\2EF\7t\2\2FG\7v\2\2G\26\3\2\2\2"+
		"HI\7r\2\2IJ\7c\2\2JK\7e\2\2KL\7m\2\2LM\7c\2\2MN\7i\2\2NO\7g\2\2O\30\3"+
		"\2\2\2PQ\7v\2\2QR\7t\2\2RS\7w\2\2ST\7g\2\2T\32\3\2\2\2UV\7w\2\2VW\7p\2"+
		"\2WX\7k\2\2XY\7v\2\2Y\34\3\2\2\2Z]\t\5\2\2[]\5\3\2\2\\Z\3\2\2\2\\[\3\2"+
		"\2\2]c\3\2\2\2^b\t\5\2\2_b\5\3\2\2`b\5\t\5\2a^\3\2\2\2a_\3\2\2\2a`\3\2"+
		"\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\36\3\2\2\2ec\3\2\2\2fh\5\t\5\2gf\3"+
		"\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j \3\2\2\2km\t\6\2\2lk\3\2\2\2mn\3"+
		"\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\b\21\2\2q\"\3\2\2\2rs\t\7\2\2s"+
		"$\3\2\2\2tu\13\2\2\2u&\3\2\2\2\t\2)\\acin\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}