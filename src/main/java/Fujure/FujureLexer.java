// Generated from Fujure/FujureLexer.g4 by ANTLR 4.7
package Fujure;
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
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, INTEGER=3, IDENT=4, WS=5, 
		ErrorToken=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"INTEGER", "IDENTIFIER_FIRST", "IDENT", "WS", "Escapable", "ErrorToken"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bG\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\5\2\36\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\b\6\b-\n\b\r\b\16\b.\3\t\3\t\5\t\63\n\t\3\n\3\n\3\n"+
		"\7\n8\n\n\f\n\16\n;\13\n\3\13\6\13>\n\13\r\13\16\13?\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\2\2\16\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\2\23\6\25\7\27\2\31\b"+
		"\3\2\7\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3"+
		"\2\62;\5\2\13\f\17\17\"\"\7\2$$^^ppttvv\2F\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\3\35\3\2\2\2\5\37\3"+
		"\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17,\3\2\2\2\21\62"+
		"\3\2\2\2\23\64\3\2\2\2\25=\3\2\2\2\27C\3\2\2\2\31E\3\2\2\2\33\36\5\5\3"+
		"\2\34\36\5\7\4\2\35\33\3\2\2\2\35\34\3\2\2\2\36\4\3\2\2\2\37 \t\2\2\2"+
		" \6\3\2\2\2!\"\t\3\2\2\"\b\3\2\2\2#$\t\4\2\2$\n\3\2\2\2%&\7?\2\2&\f\3"+
		"\2\2\2\'(\7f\2\2()\7g\2\2)*\7h\2\2*\16\3\2\2\2+-\5\t\5\2,+\3\2\2\2-.\3"+
		"\2\2\2.,\3\2\2\2./\3\2\2\2/\20\3\2\2\2\60\63\5\3\2\2\61\63\7a\2\2\62\60"+
		"\3\2\2\2\62\61\3\2\2\2\63\22\3\2\2\2\649\5\21\t\2\658\5\21\t\2\668\5\t"+
		"\5\2\67\65\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\24\3"+
		"\2\2\2;9\3\2\2\2<>\t\5\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3"+
		"\2\2\2AB\b\13\2\2B\26\3\2\2\2CD\t\6\2\2D\30\3\2\2\2EF\13\2\2\2F\32\3\2"+
		"\2\2\t\2\35.\62\679?\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}