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
		JID=15, JCHAR=16, JSTRING=17, INTEGER=18, WS=19, ErrorToken=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", 
		"Surrogate_id_SYMB_10", "Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", 
		"Surrogate_id_SYMB_13", "JID", "JCHAR", "JSTRING", "INTEGER", "WS", "Escapable", 
		"ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "'||'", "'&&'", "'!'", "'('", "')'", "'def'", 
		"'false'", "'import'", "'package'", "'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", 
		"Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", 
		"JID", "JCHAR", "JSTRING", "INTEGER", "WS", "ErrorToken"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\5\28\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\5\24w\n\24\3\24\3\24\3\24\7\24|\n"+
		"\24\f\24\16\24\177\13\24\3\25\3\25\3\25\3\25\5\25\u0085\n\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\7\26\u008d\n\26\f\26\16\26\u0090\13\26\3\26\3\26"+
		"\3\27\6\27\u0095\n\27\r\27\16\27\u0096\3\30\6\30\u009a\n\30\r\30\16\30"+
		"\u009b\3\30\3\30\3\31\3\31\3\32\3\32\2\2\33\3\2\5\2\7\2\t\2\13\3\r\4\17"+
		"\5\21\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-"+
		"\24/\25\61\2\63\26\3\2\f\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8"+
		"\u00fa\u0101\3\2\62;\4\2&&aa\4\2))^^\6\2))^^ppvv\4\2$$^^\6\2$$^^ppvv\5"+
		"\2\13\f\17\17\"\"\7\2$$^^ppttvv\u00a7\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2"+
		"\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2"+
		"\2\2\17C\3\2\2\2\21E\3\2\2\2\23H\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31O\3"+
		"\2\2\2\33Q\3\2\2\2\35U\3\2\2\2\37[\3\2\2\2!b\3\2\2\2#j\3\2\2\2%o\3\2\2"+
		"\2\'v\3\2\2\2)\u0080\3\2\2\2+\u0088\3\2\2\2-\u0094\3\2\2\2/\u0099\3\2"+
		"\2\2\61\u009f\3\2\2\2\63\u00a1\3\2\2\2\658\5\5\3\2\668\5\7\4\2\67\65\3"+
		"\2\2\2\67\66\3\2\2\28\4\3\2\2\29:\t\2\2\2:\6\3\2\2\2;<\t\3\2\2<\b\3\2"+
		"\2\2=>\t\4\2\2>\n\3\2\2\2?@\7\60\2\2@\f\3\2\2\2AB\7<\2\2B\16\3\2\2\2C"+
		"D\7?\2\2D\20\3\2\2\2EF\7~\2\2FG\7~\2\2G\22\3\2\2\2HI\7(\2\2IJ\7(\2\2J"+
		"\24\3\2\2\2KL\7#\2\2L\26\3\2\2\2MN\7*\2\2N\30\3\2\2\2OP\7+\2\2P\32\3\2"+
		"\2\2QR\7f\2\2RS\7g\2\2ST\7h\2\2T\34\3\2\2\2UV\7h\2\2VW\7c\2\2WX\7n\2\2"+
		"XY\7u\2\2YZ\7g\2\2Z\36\3\2\2\2[\\\7k\2\2\\]\7o\2\2]^\7r\2\2^_\7q\2\2_"+
		"`\7t\2\2`a\7v\2\2a \3\2\2\2bc\7r\2\2cd\7c\2\2de\7e\2\2ef\7m\2\2fg\7c\2"+
		"\2gh\7i\2\2hi\7g\2\2i\"\3\2\2\2jk\7v\2\2kl\7t\2\2lm\7w\2\2mn\7g\2\2n$"+
		"\3\2\2\2op\7w\2\2pq\7p\2\2qr\7k\2\2rs\7v\2\2s&\3\2\2\2tw\t\5\2\2uw\5\3"+
		"\2\2vt\3\2\2\2vu\3\2\2\2w}\3\2\2\2x|\t\5\2\2y|\5\3\2\2z|\5\t\5\2{x\3\2"+
		"\2\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~(\3\2\2\2\177"+
		"}\3\2\2\2\u0080\u0084\7)\2\2\u0081\u0085\n\6\2\2\u0082\u0083\7^\2\2\u0083"+
		"\u0085\t\7\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\7)\2\2\u0087*\3\2\2\2\u0088\u008e\7$\2\2\u0089\u008d"+
		"\n\b\2\2\u008a\u008b\7^\2\2\u008b\u008d\t\t\2\2\u008c\u0089\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7$\2\2\u0092"+
		",\3\2\2\2\u0093\u0095\5\t\5\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097.\3\2\2\2\u0098\u009a\t"+
		"\n\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\30\2\2\u009e\60\3\2\2"+
		"\2\u009f\u00a0\t\13\2\2\u00a0\62\3\2\2\2\u00a1\u00a2\13\2\2\2\u00a2\64"+
		"\3\2\2\2\f\2\67v{}\u0084\u008c\u008e\u0096\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}