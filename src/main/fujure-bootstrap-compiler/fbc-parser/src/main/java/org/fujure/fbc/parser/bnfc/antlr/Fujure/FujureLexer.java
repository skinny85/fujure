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
		Surrogate_id_SYMB_8=9, JID=10, JCHAR=11, INTEGER=12, WS=13, ErrorToken=14;
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
		"JCHAR", "INTEGER", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "JCHAR", "INTEGER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\5\2,\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\5\17_\n\17\3\17\3\17\3\17"+
		"\7\17d\n\17\f\17\16\17g\13\17\3\20\3\20\7\20k\n\20\f\20\16\20n\13\20\3"+
		"\20\3\20\3\21\6\21s\n\21\r\21\16\21t\3\22\6\22x\n\22\r\22\16\22y\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\2\2\25\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23"+
		"\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\2\'\20\3\2\t\5\2C\\\u00c2\u00d8"+
		"\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&&aa\3\2))\5\2\13"+
		"\f\17\17\"\"\7\2$$^^ppttvv\2\u0083\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2"+
		"\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3"+
		"\2\2\2\17\67\3\2\2\2\219\3\2\2\2\23=\3\2\2\2\25C\3\2\2\2\27J\3\2\2\2\31"+
		"R\3\2\2\2\33W\3\2\2\2\35^\3\2\2\2\37h\3\2\2\2!r\3\2\2\2#w\3\2\2\2%}\3"+
		"\2\2\2\'\177\3\2\2\2),\5\5\3\2*,\5\7\4\2+)\3\2\2\2+*\3\2\2\2,\4\3\2\2"+
		"\2-.\t\2\2\2.\6\3\2\2\2/\60\t\3\2\2\60\b\3\2\2\2\61\62\t\4\2\2\62\n\3"+
		"\2\2\2\63\64\7\60\2\2\64\f\3\2\2\2\65\66\7?\2\2\66\16\3\2\2\2\678\7<\2"+
		"\28\20\3\2\2\29:\7f\2\2:;\7g\2\2;<\7h\2\2<\22\3\2\2\2=>\7h\2\2>?\7c\2"+
		"\2?@\7n\2\2@A\7u\2\2AB\7g\2\2B\24\3\2\2\2CD\7k\2\2DE\7o\2\2EF\7r\2\2F"+
		"G\7q\2\2GH\7t\2\2HI\7v\2\2I\26\3\2\2\2JK\7r\2\2KL\7c\2\2LM\7e\2\2MN\7"+
		"m\2\2NO\7c\2\2OP\7i\2\2PQ\7g\2\2Q\30\3\2\2\2RS\7v\2\2ST\7t\2\2TU\7w\2"+
		"\2UV\7g\2\2V\32\3\2\2\2WX\7w\2\2XY\7p\2\2YZ\7k\2\2Z[\7v\2\2[\34\3\2\2"+
		"\2\\_\t\5\2\2]_\5\3\2\2^\\\3\2\2\2^]\3\2\2\2_e\3\2\2\2`d\t\5\2\2ad\5\3"+
		"\2\2bd\5\t\5\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2f\36\3\2\2\2ge\3\2\2\2hl\7)\2\2ik\n\6\2\2ji\3\2\2\2kn\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7)\2\2p \3\2\2\2qs\5\t\5\2rq\3"+
		"\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\"\3\2\2\2vx\t\7\2\2wv\3\2\2\2xy"+
		"\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\22\2\2|$\3\2\2\2}~\t\b\2\2"+
		"~&\3\2\2\2\177\u0080\13\2\2\2\u0080(\3\2\2\2\n\2+^celty\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}