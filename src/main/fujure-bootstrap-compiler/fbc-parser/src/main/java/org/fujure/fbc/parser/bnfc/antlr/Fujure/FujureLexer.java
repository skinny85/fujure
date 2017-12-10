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
		Surrogate_id_SYMB_8=9, JID=10, INTEGER=11, WS=12, ErrorToken=13, CHAR=14;
	public static final int
		CHARMODE=1, ESCAPE=2, CHAREND=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "CHARMODE", "ESCAPE", "CHAREND"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", 
		"CHAR", "INTEGER", "WS", "Escapable", "ErrorToken", "CHARANY", "CHARESC", 
		"ESCAPED", "CHARENDC"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'", null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "INTEGER", "WS", 
		"ErrorToken", "CHAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u009f\b\1\b\1"+
		"\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\3\2\3\2\5\2\67\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\5\17j\n\17\3\17\3\17\3\17\7\17o\n\17\f\17\16"+
		"\17r\13\17\3\20\3\20\3\20\3\20\3\20\3\21\6\21z\n\21\r\21\16\21{\3\22\6"+
		"\22\177\n\22\r\22\16\22\u0080\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\5\27\u0096\n\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\2\2\31\6\2\b\2\n\2\f\2\16\3\20"+
		"\4\22\5\24\6\26\7\30\b\32\t\34\n\36\13 \f\"\20$\r&\16(\2*\17,\2.\2\60"+
		"\2\62\2\6\2\3\4\5\t\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa"+
		"\u0101\3\2\62;\4\2&&aa\5\2\13\f\17\17\"\"\7\2$$^^ppttvv\4\2))^^\2\u009e"+
		"\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30"+
		"\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2"+
		"\2$\3\2\2\2\2&\3\2\2\2\2*\3\2\2\2\3,\3\2\2\2\3.\3\2\2\2\4\60\3\2\2\2\5"+
		"\62\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\f<\3\2\2\2\16>\3\2\2\2"+
		"\20@\3\2\2\2\22B\3\2\2\2\24D\3\2\2\2\26H\3\2\2\2\30N\3\2\2\2\32U\3\2\2"+
		"\2\34]\3\2\2\2\36b\3\2\2\2 i\3\2\2\2\"s\3\2\2\2$y\3\2\2\2&~\3\2\2\2(\u0084"+
		"\3\2\2\2*\u0086\3\2\2\2,\u0088\3\2\2\2.\u008d\3\2\2\2\60\u0095\3\2\2\2"+
		"\62\u009a\3\2\2\2\64\67\5\b\3\2\65\67\5\n\4\2\66\64\3\2\2\2\66\65\3\2"+
		"\2\2\67\7\3\2\2\289\t\2\2\29\t\3\2\2\2:;\t\3\2\2;\13\3\2\2\2<=\t\4\2\2"+
		"=\r\3\2\2\2>?\7\60\2\2?\17\3\2\2\2@A\7?\2\2A\21\3\2\2\2BC\7<\2\2C\23\3"+
		"\2\2\2DE\7f\2\2EF\7g\2\2FG\7h\2\2G\25\3\2\2\2HI\7h\2\2IJ\7c\2\2JK\7n\2"+
		"\2KL\7u\2\2LM\7g\2\2M\27\3\2\2\2NO\7k\2\2OP\7o\2\2PQ\7r\2\2QR\7q\2\2R"+
		"S\7t\2\2ST\7v\2\2T\31\3\2\2\2UV\7r\2\2VW\7c\2\2WX\7e\2\2XY\7m\2\2YZ\7"+
		"c\2\2Z[\7i\2\2[\\\7g\2\2\\\33\3\2\2\2]^\7v\2\2^_\7t\2\2_`\7w\2\2`a\7g"+
		"\2\2a\35\3\2\2\2bc\7w\2\2cd\7p\2\2de\7k\2\2ef\7v\2\2f\37\3\2\2\2gj\t\5"+
		"\2\2hj\5\6\2\2ig\3\2\2\2ih\3\2\2\2jp\3\2\2\2ko\t\5\2\2lo\5\6\2\2mo\5\f"+
		"\5\2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q!\3\2"+
		"\2\2rp\3\2\2\2st\7)\2\2tu\3\2\2\2uv\b\20\2\2vw\b\20\3\2w#\3\2\2\2xz\5"+
		"\f\5\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|%\3\2\2\2}\177\t\6\2\2"+
		"~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\b\22\4\2\u0083\'\3\2\2\2\u0084\u0085\t\7\2"+
		"\2\u0085)\3\2\2\2\u0086\u0087\13\2\2\2\u0087+\3\2\2\2\u0088\u0089\n\b"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\25\2\2\u008b\u008c\b\25\5\2\u008c"+
		"-\3\2\2\2\u008d\u008e\7^\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\26\2\2"+
		"\u0090\u0091\b\26\6\2\u0091\u0092\b\26\7\2\u0092/\3\2\2\2\u0093\u0096"+
		"\5(\23\2\u0094\u0096\7)\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\b\27\2\2\u0098\u0099\b\27\b\2\u0099\61\3\2"+
		"\2\2\u009a\u009b\7)\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\30\t\2\u009d"+
		"\u009e\b\30\n\2\u009e\63\3\2\2\2\r\2\3\4\5\66inp{\u0080\u0095\13\5\2\2"+
		"\4\3\2\b\2\2\4\5\2\7\5\2\7\4\2\6\2\2\t\20\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}