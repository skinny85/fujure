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
		Surrogate_id_SYMB_8=9, Surrogate_id_SYMB_9=10, Surrogate_id_SYMB_10=11, 
		Surrogate_id_SYMB_11=12, Surrogate_id_SYMB_12=13, Surrogate_id_SYMB_13=14, 
		Surrogate_id_SYMB_14=15, Surrogate_id_SYMB_15=16, Surrogate_id_SYMB_16=17, 
		Surrogate_id_SYMB_17=18, JID=19, JCHAR=20, JSTRING=21, INTEGER=22, WS=23, 
		ErrorToken=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", 
		"Surrogate_id_SYMB_10", "Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", 
		"Surrogate_id_SYMB_13", "Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", 
		"Surrogate_id_SYMB_16", "Surrogate_id_SYMB_17", "JID", "JCHAR", "JSTRING", 
		"INTEGER", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", 
		"'!'", "'('", "')'", "'def'", "'false'", "'import'", "'package'", "'true'", 
		"'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", 
		"Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", 
		"Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", 
		"Surrogate_id_SYMB_17", "JID", "JCHAR", "JSTRING", "INTEGER", "WS", "ErrorToken"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00b5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\5\2@\n"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\5\30\u0089\n\30"+
		"\3\30\3\30\3\30\7\30\u008e\n\30\f\30\16\30\u0091\13\30\3\31\3\31\3\31"+
		"\3\31\5\31\u0097\n\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u009f\n\32\f"+
		"\32\16\32\u00a2\13\32\3\32\3\32\3\33\6\33\u00a7\n\33\r\33\16\33\u00a8"+
		"\3\34\6\34\u00ac\n\34\r\34\16\34\u00ad\3\34\3\34\3\35\3\35\3\36\3\36\2"+
		"\2\37\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\27\t\31\n\33\13\35"+
		"\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\319\2;\32"+
		"\3\2\f\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3"+
		"\2\62;\4\2&&aa\4\2))^^\6\2))^^ppvv\4\2$$^^\6\2$$^^ppvv\5\2\13\f\17\17"+
		"\"\"\7\2$$^^ppttvv\u00b9\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2\7C\3\2"+
		"\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23P\3\2"+
		"\2\2\25S\3\2\2\2\27U\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2\35]\3\2\2\2\37_\3"+
		"\2\2\2!a\3\2\2\2#c\3\2\2\2%g\3\2\2\2\'m\3\2\2\2)t\3\2\2\2+|\3\2\2\2-\u0081"+
		"\3\2\2\2/\u0088\3\2\2\2\61\u0092\3\2\2\2\63\u009a\3\2\2\2\65\u00a6\3\2"+
		"\2\2\67\u00ab\3\2\2\29\u00b1\3\2\2\2;\u00b3\3\2\2\2=@\5\5\3\2>@\5\7\4"+
		"\2?=\3\2\2\2?>\3\2\2\2@\4\3\2\2\2AB\t\2\2\2B\6\3\2\2\2CD\t\3\2\2D\b\3"+
		"\2\2\2EF\t\4\2\2F\n\3\2\2\2GH\7\60\2\2H\f\3\2\2\2IJ\7<\2\2J\16\3\2\2\2"+
		"KL\7?\2\2L\20\3\2\2\2MN\7~\2\2NO\7~\2\2O\22\3\2\2\2PQ\7(\2\2QR\7(\2\2"+
		"R\24\3\2\2\2ST\7>\2\2T\26\3\2\2\2UV\7>\2\2VW\7?\2\2W\30\3\2\2\2XY\7@\2"+
		"\2Y\32\3\2\2\2Z[\7@\2\2[\\\7?\2\2\\\34\3\2\2\2]^\7#\2\2^\36\3\2\2\2_`"+
		"\7*\2\2` \3\2\2\2ab\7+\2\2b\"\3\2\2\2cd\7f\2\2de\7g\2\2ef\7h\2\2f$\3\2"+
		"\2\2gh\7h\2\2hi\7c\2\2ij\7n\2\2jk\7u\2\2kl\7g\2\2l&\3\2\2\2mn\7k\2\2n"+
		"o\7o\2\2op\7r\2\2pq\7q\2\2qr\7t\2\2rs\7v\2\2s(\3\2\2\2tu\7r\2\2uv\7c\2"+
		"\2vw\7e\2\2wx\7m\2\2xy\7c\2\2yz\7i\2\2z{\7g\2\2{*\3\2\2\2|}\7v\2\2}~\7"+
		"t\2\2~\177\7w\2\2\177\u0080\7g\2\2\u0080,\3\2\2\2\u0081\u0082\7w\2\2\u0082"+
		"\u0083\7p\2\2\u0083\u0084\7k\2\2\u0084\u0085\7v\2\2\u0085.\3\2\2\2\u0086"+
		"\u0089\t\5\2\2\u0087\u0089\5\3\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008f\3\2\2\2\u008a\u008e\t\5\2\2\u008b\u008e\5\3\2\2\u008c"+
		"\u008e\5\t\5\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\60\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0096\7)\2\2\u0093\u0097\n\6\2\2"+
		"\u0094\u0095\7^\2\2\u0095\u0097\t\7\2\2\u0096\u0093\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7)\2\2\u0099\62\3\2\2\2\u009a"+
		"\u00a0\7$\2\2\u009b\u009f\n\b\2\2\u009c\u009d\7^\2\2\u009d\u009f\t\t\2"+
		"\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a4\7$\2\2\u00a4\64\3\2\2\2\u00a5\u00a7\5\t\5\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\66"+
		"\3\2\2\2\u00aa\u00ac\t\n\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\34"+
		"\2\2\u00b08\3\2\2\2\u00b1\u00b2\t\13\2\2\u00b2:\3\2\2\2\u00b3\u00b4\13"+
		"\2\2\2\u00b4<\3\2\2\2\f\2?\u0088\u008d\u008f\u0096\u009e\u00a0\u00a8\u00ad"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}