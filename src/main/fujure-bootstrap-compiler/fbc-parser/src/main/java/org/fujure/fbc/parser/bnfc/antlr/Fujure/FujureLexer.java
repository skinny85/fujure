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
		Surrogate_id_SYMB_8=9, JID=10, JCHAR=11, INTEGER=12, WS=13, ErrorToken=14, 
		STRING=15, STRINGESC=16;
	public static final int
		STRESCAPE=1, STRINGMODE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "STRESCAPE", "STRINGMODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", 
		"JCHAR", "STRING", "INTEGER", "WS", "Escapable", "ErrorToken", "STRESCAPED", 
		"STRINGESC", "STRINGEND", "STRINGTEXT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'", null, null, null, null, null, "'\"'", "'\\'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "JCHAR", "INTEGER", 
		"WS", "ErrorToken", "STRING", "STRINGESC"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00a5\b\1\b\1"+
		"\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4"+
		"\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t"+
		"\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t"+
		"\30\4\31\t\31\3\2\3\2\5\28\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\5\17k\n\17\3\17\3\17\3\17\7\17p\n\17\f"+
		"\17\16\17s\13\17\3\20\3\20\7\20w\n\20\f\20\16\20z\13\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\6\22\u0084\n\22\r\22\16\22\u0085\3\23\6\23\u0089"+
		"\n\23\r\23\16\23\u008a\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\2\2\32\5\2\7\2\t\2\13\2\r\3\17\4\21\5\23\6\25\7\27\b\31\t\33"+
		"\n\35\13\37\f!\r#\21%\16\'\17)\2+\20-\2/\22\61\2\63\2\5\2\3\4\n\5\2C\\"+
		"\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&&a"+
		"a\3\2))\5\2\13\f\17\17\"\"\7\2$$^^ppttvv\4\2$$^^\2\u00a5\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\4/\3\2\2\2\4\61\3\2\2\2\4"+
		"\63\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r?\3\2\2\2"+
		"\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25I\3\2\2\2\27O\3\2\2\2\31V\3\2\2"+
		"\2\33^\3\2\2\2\35c\3\2\2\2\37j\3\2\2\2!t\3\2\2\2#}\3\2\2\2%\u0083\3\2"+
		"\2\2\'\u0088\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2-\u0092\3\2\2\2/\u0097"+
		"\3\2\2\2\61\u009c\3\2\2\2\63\u00a1\3\2\2\2\658\5\7\3\2\668\5\t\4\2\67"+
		"\65\3\2\2\2\67\66\3\2\2\28\6\3\2\2\29:\t\2\2\2:\b\3\2\2\2;<\t\3\2\2<\n"+
		"\3\2\2\2=>\t\4\2\2>\f\3\2\2\2?@\7\60\2\2@\16\3\2\2\2AB\7?\2\2B\20\3\2"+
		"\2\2CD\7<\2\2D\22\3\2\2\2EF\7f\2\2FG\7g\2\2GH\7h\2\2H\24\3\2\2\2IJ\7h"+
		"\2\2JK\7c\2\2KL\7n\2\2LM\7u\2\2MN\7g\2\2N\26\3\2\2\2OP\7k\2\2PQ\7o\2\2"+
		"QR\7r\2\2RS\7q\2\2ST\7t\2\2TU\7v\2\2U\30\3\2\2\2VW\7r\2\2WX\7c\2\2XY\7"+
		"e\2\2YZ\7m\2\2Z[\7c\2\2[\\\7i\2\2\\]\7g\2\2]\32\3\2\2\2^_\7v\2\2_`\7t"+
		"\2\2`a\7w\2\2ab\7g\2\2b\34\3\2\2\2cd\7w\2\2de\7p\2\2ef\7k\2\2fg\7v\2\2"+
		"g\36\3\2\2\2hk\t\5\2\2ik\5\5\2\2jh\3\2\2\2ji\3\2\2\2kq\3\2\2\2lp\t\5\2"+
		"\2mp\5\5\2\2np\5\13\5\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2ps\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2r \3\2\2\2sq\3\2\2\2tx\7)\2\2uw\n\6\2\2vu\3\2\2\2wz\3\2"+
		"\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7)\2\2|\"\3\2\2\2}~\7$"+
		"\2\2~\177\3\2\2\2\177\u0080\b\21\2\2\u0080\u0081\b\21\3\2\u0081$\3\2\2"+
		"\2\u0082\u0084\5\13\5\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086&\3\2\2\2\u0087\u0089\t\7\2\2"+
		"\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\23\4\2\u008d(\3\2\2\2\u008e"+
		"\u008f\t\b\2\2\u008f*\3\2\2\2\u0090\u0091\13\2\2\2\u0091,\3\2\2\2\u0092"+
		"\u0093\5)\24\2\u0093\u0094\3\2\2\2\u0094\u0095\b\26\2\2\u0095\u0096\b"+
		"\26\5\2\u0096.\3\2\2\2\u0097\u0098\7^\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\b\27\2\2\u009a\u009b\b\27\6\2\u009b\60\3\2\2\2\u009c\u009d\7$\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\b\30\7\2\u009f\u00a0\b\30\b\2\u00a0\62\3\2"+
		"\2\2\u00a1\u00a2\n\t\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\b\31\2\2\u00a4"+
		"\64\3\2\2\2\f\2\3\4\67joqx\u0085\u008a\t\5\2\2\4\4\2\b\2\2\6\2\2\7\3\2"+
		"\t\21\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}