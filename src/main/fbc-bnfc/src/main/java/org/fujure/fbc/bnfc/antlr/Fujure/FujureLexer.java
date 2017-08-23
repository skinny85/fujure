// Generated from org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.g4 by ANTLR 4.7
package org.fujure.fbc.bnfc.antlr.Fujure;
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
		Surrogate_id_SYMB_4=5, INTEGER=6, IDENT=7, WS=8, ErrorToken=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "INTEGER", 
		"IDENTIFIER_FIRST", "IDENT", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "':'", "'def'", "'package'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "INTEGER", "IDENT", "WS", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13Y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\5\2$\n\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13?\n\13\r\13\16\13@\3\f\3\f\5\fE\n\f\3"+
		"\r\3\r\3\r\7\rJ\n\r\f\r\16\rM\13\r\3\16\6\16P\n\16\r\16\16\16Q\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\2\2\21\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7"+
		"\25\b\27\2\31\t\33\n\35\2\37\13\3\2\7\5\2C\\\u00c2\u00d8\u00da\u00e0\5"+
		"\2c|\u00e1\u00f8\u00fa\u0101\3\2\62;\5\2\13\f\17\17\"\"\7\2$$^^ppttvv"+
		"\2X\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\3#\3\2\2\2\5%\3\2\2"+
		"\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\61\3\2"+
		"\2\2\23\65\3\2\2\2\25>\3\2\2\2\27D\3\2\2\2\31F\3\2\2\2\33O\3\2\2\2\35"+
		"U\3\2\2\2\37W\3\2\2\2!$\5\5\3\2\"$\5\7\4\2#!\3\2\2\2#\"\3\2\2\2$\4\3\2"+
		"\2\2%&\t\2\2\2&\6\3\2\2\2\'(\t\3\2\2(\b\3\2\2\2)*\t\4\2\2*\n\3\2\2\2+"+
		",\7\60\2\2,\f\3\2\2\2-.\7?\2\2.\16\3\2\2\2/\60\7<\2\2\60\20\3\2\2\2\61"+
		"\62\7f\2\2\62\63\7g\2\2\63\64\7h\2\2\64\22\3\2\2\2\65\66\7r\2\2\66\67"+
		"\7c\2\2\678\7e\2\289\7m\2\29:\7c\2\2:;\7i\2\2;<\7g\2\2<\24\3\2\2\2=?\5"+
		"\t\5\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\26\3\2\2\2BE\5\3\2\2C"+
		"E\7a\2\2DB\3\2\2\2DC\3\2\2\2E\30\3\2\2\2FK\5\27\f\2GJ\5\27\f\2HJ\5\t\5"+
		"\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\32\3\2\2\2MK\3\2"+
		"\2\2NP\t\5\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\b\16"+
		"\2\2T\34\3\2\2\2UV\t\6\2\2V\36\3\2\2\2WX\13\2\2\2X \3\2\2\2\t\2#@DIKQ"+
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