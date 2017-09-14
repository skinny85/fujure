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
		Surrogate_id_SYMB_4=5, Surrogate_id_SYMB_5=6, Surrogate_id_SYMB_6=7, JID=8, 
		INTEGER=9, WS=10, ErrorToken=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "JID", "INTEGER", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'package'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"JID", "INTEGER", "WS", "ErrorToken"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rf\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\5"+
		"\2&\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\5\rM\n\r\3\r\3\r\3\r\7\rR\n\r\f\r\16\rU\13\r"+
		"\3\16\6\16X\n\16\r\16\16\16Y\3\17\6\17]\n\17\r\17\16\17^\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\2\2\22\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\27"+
		"\t\31\n\33\13\35\f\37\2!\r\3\2\b\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|"+
		"\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&&aa\5\2\13\f\17\17\"\"\7\2$$^^pp"+
		"ttvv\2g\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"!\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/"+
		"\3\2\2\2\17\61\3\2\2\2\21\63\3\2\2\2\23\67\3\2\2\2\25=\3\2\2\2\27E\3\2"+
		"\2\2\31L\3\2\2\2\33W\3\2\2\2\35\\\3\2\2\2\37b\3\2\2\2!d\3\2\2\2#&\5\5"+
		"\3\2$&\5\7\4\2%#\3\2\2\2%$\3\2\2\2&\4\3\2\2\2\'(\t\2\2\2(\6\3\2\2\2)*"+
		"\t\3\2\2*\b\3\2\2\2+,\t\4\2\2,\n\3\2\2\2-.\7\60\2\2.\f\3\2\2\2/\60\7?"+
		"\2\2\60\16\3\2\2\2\61\62\7<\2\2\62\20\3\2\2\2\63\64\7f\2\2\64\65\7g\2"+
		"\2\65\66\7h\2\2\66\22\3\2\2\2\678\7h\2\289\7c\2\29:\7n\2\2:;\7u\2\2;<"+
		"\7g\2\2<\24\3\2\2\2=>\7r\2\2>?\7c\2\2?@\7e\2\2@A\7m\2\2AB\7c\2\2BC\7i"+
		"\2\2CD\7g\2\2D\26\3\2\2\2EF\7v\2\2FG\7t\2\2GH\7w\2\2HI\7g\2\2I\30\3\2"+
		"\2\2JM\t\5\2\2KM\5\3\2\2LJ\3\2\2\2LK\3\2\2\2MS\3\2\2\2NR\t\5\2\2OR\5\3"+
		"\2\2PR\5\t\5\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2"+
		"\2\2T\32\3\2\2\2US\3\2\2\2VX\5\t\5\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3"+
		"\2\2\2Z\34\3\2\2\2[]\t\6\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2"+
		"_`\3\2\2\2`a\b\17\2\2a\36\3\2\2\2bc\t\7\2\2c \3\2\2\2de\13\2\2\2e\"\3"+
		"\2\2\2\t\2%LQSY^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}