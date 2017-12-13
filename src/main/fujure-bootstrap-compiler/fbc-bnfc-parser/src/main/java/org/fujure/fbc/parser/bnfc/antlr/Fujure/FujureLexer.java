// Generated from org/fujure/fbc/parser/bnfc/antlr/Fujure/FujureLexer.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, Surrogate_id_SYMB_2=3, Surrogate_id_SYMB_3=4, 
		Surrogate_id_SYMB_4=5, Surrogate_id_SYMB_5=6, Surrogate_id_SYMB_6=7, Surrogate_id_SYMB_7=8, 
		Surrogate_id_SYMB_8=9, JID=10, JCHAR=11, JSTRING=12, INTEGER=13, WS=14, 
		ErrorToken=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", 
		"JCHAR", "JSTRING", "INTEGER", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "JCHAR", "JSTRING", 
		"INTEGER", "WS", "ErrorToken"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\5\2.\n\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\5\17a\n\17\3\17"+
		"\3\17\3\17\7\17f\n\17\f\17\16\17i\13\17\3\20\3\20\3\20\3\20\5\20o\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\7\21w\n\21\f\21\16\21z\13\21\3\21\3\21"+
		"\3\22\6\22\177\n\22\r\22\16\22\u0080\3\23\6\23\u0084\n\23\r\23\16\23\u0085"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\2\2\26\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21"+
		"\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\2)\21\3\2\f\5\2C"+
		"\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&"+
		"&aa\4\2))^^\6\2))^^ppvv\4\2$$^^\6\2$$^^ppvv\5\2\13\f\17\17\"\"\7\2$$^"+
		"^ppttvv\u0091\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\3-\3\2\2"+
		"\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\17"+
		"9\3\2\2\2\21;\3\2\2\2\23?\3\2\2\2\25E\3\2\2\2\27L\3\2\2\2\31T\3\2\2\2"+
		"\33Y\3\2\2\2\35`\3\2\2\2\37j\3\2\2\2!r\3\2\2\2#~\3\2\2\2%\u0083\3\2\2"+
		"\2\'\u0089\3\2\2\2)\u008b\3\2\2\2+.\5\5\3\2,.\5\7\4\2-+\3\2\2\2-,\3\2"+
		"\2\2.\4\3\2\2\2/\60\t\2\2\2\60\6\3\2\2\2\61\62\t\3\2\2\62\b\3\2\2\2\63"+
		"\64\t\4\2\2\64\n\3\2\2\2\65\66\7\60\2\2\66\f\3\2\2\2\678\7?\2\28\16\3"+
		"\2\2\29:\7<\2\2:\20\3\2\2\2;<\7f\2\2<=\7g\2\2=>\7h\2\2>\22\3\2\2\2?@\7"+
		"h\2\2@A\7c\2\2AB\7n\2\2BC\7u\2\2CD\7g\2\2D\24\3\2\2\2EF\7k\2\2FG\7o\2"+
		"\2GH\7r\2\2HI\7q\2\2IJ\7t\2\2JK\7v\2\2K\26\3\2\2\2LM\7r\2\2MN\7c\2\2N"+
		"O\7e\2\2OP\7m\2\2PQ\7c\2\2QR\7i\2\2RS\7g\2\2S\30\3\2\2\2TU\7v\2\2UV\7"+
		"t\2\2VW\7w\2\2WX\7g\2\2X\32\3\2\2\2YZ\7w\2\2Z[\7p\2\2[\\\7k\2\2\\]\7v"+
		"\2\2]\34\3\2\2\2^a\t\5\2\2_a\5\3\2\2`^\3\2\2\2`_\3\2\2\2ag\3\2\2\2bf\t"+
		"\5\2\2cf\5\3\2\2df\5\t\5\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2fi\3\2\2\2ge\3"+
		"\2\2\2gh\3\2\2\2h\36\3\2\2\2ig\3\2\2\2jn\7)\2\2ko\n\6\2\2lm\7^\2\2mo\t"+
		"\7\2\2nk\3\2\2\2nl\3\2\2\2op\3\2\2\2pq\7)\2\2q \3\2\2\2rx\7$\2\2sw\n\b"+
		"\2\2tu\7^\2\2uw\t\t\2\2vs\3\2\2\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2"+
		"\2\2y{\3\2\2\2zx\3\2\2\2{|\7$\2\2|\"\3\2\2\2}\177\5\t\5\2~}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081$\3\2\2\2\u0082"+
		"\u0084\t\n\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\23\2\2\u0088"+
		"&\3\2\2\2\u0089\u008a\t\13\2\2\u008a(\3\2\2\2\u008b\u008c\13\2\2\2\u008c"+
		"*\3\2\2\2\f\2-`egnvx\u0080\u0085\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}