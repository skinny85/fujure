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
		Surrogate_id_SYMB_17=18, Surrogate_id_SYMB_18=19, Surrogate_id_SYMB_19=20, 
		Surrogate_id_SYMB_20=21, Surrogate_id_SYMB_21=22, Surrogate_id_SYMB_22=23, 
		Surrogate_id_SYMB_23=24, Surrogate_id_SYMB_24=25, Surrogate_id_SYMB_25=26, 
		Surrogate_id_SYMB_26=27, Surrogate_id_SYMB_27=28, Surrogate_id_SYMB_28=29, 
		Surrogate_id_SYMB_29=30, Surrogate_id_SYMB_30=31, Surrogate_id_SYMB_31=32, 
		JID=33, JCHAR=34, JSTRING=35, INTEGER=36, WS=37, ErrorToken=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
		"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", 
		"Surrogate_id_SYMB_10", "Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", 
		"Surrogate_id_SYMB_13", "Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", 
		"Surrogate_id_SYMB_16", "Surrogate_id_SYMB_17", "Surrogate_id_SYMB_18", 
		"Surrogate_id_SYMB_19", "Surrogate_id_SYMB_20", "Surrogate_id_SYMB_21", 
		"Surrogate_id_SYMB_22", "Surrogate_id_SYMB_23", "Surrogate_id_SYMB_24", 
		"Surrogate_id_SYMB_25", "Surrogate_id_SYMB_26", "Surrogate_id_SYMB_27", 
		"Surrogate_id_SYMB_28", "Surrogate_id_SYMB_29", "Surrogate_id_SYMB_30", 
		"Surrogate_id_SYMB_31", "JID", "JCHAR", "JSTRING", "INTEGER", "WS", "Escapable", 
		"ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "':'", "'='", "','", "'->'", "'<'", "'>'", 
		"'||'", "'&&'", "'=='", "'!='", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'!'", "'def'", "'else'", "'false'", "'if'", "'import'", "'in'", 
		"'let'", "'package'", "'then'", "'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", 
		"Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", 
		"Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", 
		"Surrogate_id_SYMB_17", "Surrogate_id_SYMB_18", "Surrogate_id_SYMB_19", 
		"Surrogate_id_SYMB_20", "Surrogate_id_SYMB_21", "Surrogate_id_SYMB_22", 
		"Surrogate_id_SYMB_23", "Surrogate_id_SYMB_24", "Surrogate_id_SYMB_25", 
		"Surrogate_id_SYMB_26", "Surrogate_id_SYMB_27", "Surrogate_id_SYMB_28", 
		"Surrogate_id_SYMB_29", "Surrogate_id_SYMB_30", "Surrogate_id_SYMB_31", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u00fa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\5\2\\\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3&\3&\5&\u00ce\n&\3&\3&\3&\7&\u00d3\n&\f&\16&\u00d6\13&\3\'"+
		"\3\'\3\'\3\'\5\'\u00dc\n\'\3\'\3\'\3(\3(\3(\3(\7(\u00e4\n(\f(\16(\u00e7"+
		"\13(\3(\3(\3)\6)\u00ec\n)\r)\16)\u00ed\3*\6*\u00f1\n*\r*\16*\u00f2\3*"+
		"\3*\3+\3+\3,\3,\2\2-\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\27\t"+
		"\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63\27\65"+
		"\30\67\319\32;\33=\34?\35A\36C\37E G!I\"K#M$O%Q&S\'U\2W(\3\2\f\5\2C\\"+
		"\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\4\2&&a"+
		"a\4\2))^^\6\2))^^ppvv\4\2$$^^\6\2$$^^ppvv\5\2\13\f\17\17\"\"\7\2$$^^p"+
		"pttvv\u00fe\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2W\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3"+
		"\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23k\3"+
		"\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31r\3\2\2\2\33t\3\2\2\2\35v\3\2\2\2\37"+
		"y\3\2\2\2!|\3\2\2\2#\177\3\2\2\2%\u0082\3\2\2\2\'\u0085\3\2\2\2)\u0088"+
		"\3\2\2\2+\u008a\3\2\2\2-\u008c\3\2\2\2/\u008e\3\2\2\2\61\u0090\3\2\2\2"+
		"\63\u0092\3\2\2\2\65\u0094\3\2\2\2\67\u0098\3\2\2\29\u009d\3\2\2\2;\u00a3"+
		"\3\2\2\2=\u00a6\3\2\2\2?\u00ad\3\2\2\2A\u00b0\3\2\2\2C\u00b4\3\2\2\2E"+
		"\u00bc\3\2\2\2G\u00c1\3\2\2\2I\u00c6\3\2\2\2K\u00cd\3\2\2\2M\u00d7\3\2"+
		"\2\2O\u00df\3\2\2\2Q\u00eb\3\2\2\2S\u00f0\3\2\2\2U\u00f6\3\2\2\2W\u00f8"+
		"\3\2\2\2Y\\\5\5\3\2Z\\\5\7\4\2[Y\3\2\2\2[Z\3\2\2\2\\\4\3\2\2\2]^\t\2\2"+
		"\2^\6\3\2\2\2_`\t\3\2\2`\b\3\2\2\2ab\t\4\2\2b\n\3\2\2\2cd\7\60\2\2d\f"+
		"\3\2\2\2ef\7*\2\2f\16\3\2\2\2gh\7+\2\2h\20\3\2\2\2ij\7<\2\2j\22\3\2\2"+
		"\2kl\7?\2\2l\24\3\2\2\2mn\7.\2\2n\26\3\2\2\2op\7/\2\2pq\7@\2\2q\30\3\2"+
		"\2\2rs\7>\2\2s\32\3\2\2\2tu\7@\2\2u\34\3\2\2\2vw\7~\2\2wx\7~\2\2x\36\3"+
		"\2\2\2yz\7(\2\2z{\7(\2\2{ \3\2\2\2|}\7?\2\2}~\7?\2\2~\"\3\2\2\2\177\u0080"+
		"\7#\2\2\u0080\u0081\7?\2\2\u0081$\3\2\2\2\u0082\u0083\7>\2\2\u0083\u0084"+
		"\7?\2\2\u0084&\3\2\2\2\u0085\u0086\7@\2\2\u0086\u0087\7?\2\2\u0087(\3"+
		"\2\2\2\u0088\u0089\7-\2\2\u0089*\3\2\2\2\u008a\u008b\7/\2\2\u008b,\3\2"+
		"\2\2\u008c\u008d\7,\2\2\u008d.\3\2\2\2\u008e\u008f\7\61\2\2\u008f\60\3"+
		"\2\2\2\u0090\u0091\7\'\2\2\u0091\62\3\2\2\2\u0092\u0093\7#\2\2\u0093\64"+
		"\3\2\2\2\u0094\u0095\7f\2\2\u0095\u0096\7g\2\2\u0096\u0097\7h\2\2\u0097"+
		"\66\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b"+
		"\u009c\7g\2\2\u009c8\3\2\2\2\u009d\u009e\7h\2\2\u009e\u009f\7c\2\2\u009f"+
		"\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2:\3\2\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5<\3\2\2\2\u00a6\u00a7\7k\2\2\u00a7"+
		"\u00a8\7o\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2"+
		"\u00ab\u00ac\7v\2\2\u00ac>\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7p\2"+
		"\2\u00af@\3\2\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7"+
		"v\2\2\u00b3B\3\2\2\2\u00b4\u00b5\7r\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7"+
		"\7e\2\2\u00b7\u00b8\7m\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7i\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bbD\3\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7j\2\2\u00be"+
		"\u00bf\7g\2\2\u00bf\u00c0\7p\2\2\u00c0F\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7t\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7g\2\2\u00c5H\3\2\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7v\2\2"+
		"\u00caJ\3\2\2\2\u00cb\u00ce\t\5\2\2\u00cc\u00ce\5\3\2\2\u00cd\u00cb\3"+
		"\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d4\3\2\2\2\u00cf\u00d3\t\5\2\2\u00d0"+
		"\u00d3\5\3\2\2\u00d1\u00d3\5\t\5\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5L\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00db\7)\2\2\u00d8"+
		"\u00dc\n\6\2\2\u00d9\u00da\7^\2\2\u00da\u00dc\t\7\2\2\u00db\u00d8\3\2"+
		"\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7)\2\2\u00de"+
		"N\3\2\2\2\u00df\u00e5\7$\2\2\u00e0\u00e4\n\b\2\2\u00e1\u00e2\7^\2\2\u00e2"+
		"\u00e4\t\t\2\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00e9\7$\2\2\u00e9P\3\2\2\2\u00ea\u00ec\5\t\5\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00eeR\3\2\2\2\u00ef\u00f1\t\n\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\b*\2\2\u00f5T\3\2\2\2\u00f6\u00f7\t\13\2\2\u00f7V\3\2\2\2\u00f8"+
		"\u00f9\13\2\2\2\u00f9X\3\2\2\2\f\2[\u00cd\u00d2\u00d4\u00db\u00e3\u00e5"+
		"\u00ed\u00f2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}