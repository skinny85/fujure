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
		INTEGER=5, IDENT=6, WS=7, ErrorToken=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "CAPITAL", "SMALL", "DIGIT", "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", 
		"Surrogate_id_SYMB_2", "Surrogate_id_SYMB_3", "INTEGER", "IDENTIFIER_FIRST", 
		"IDENT", "WS", "Escapable", "ErrorToken"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'='", "'def'", "'package'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "INTEGER", "IDENT", "WS", "ErrorToken"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nU\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2\"\n\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\6\n;\n\n\r\n\16\n<\3\13\3\13\5\13A\n\13\3\f\3\f\3\f\7\fF\n"+
		"\f\f\f\16\fI\13\f\3\r\6\rL\n\r\r\r\16\rM\3\r\3\r\3\16\3\16\3\17\3\17\2"+
		"\2\20\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\2\27\b\31\t\33\2\35\n"+
		"\3\2\7\5\2C\\\u00c2\u00d8\u00da\u00e0\5\2c|\u00e1\u00f8\u00fa\u0101\3"+
		"\2\62;\5\2\13\f\17\17\"\"\7\2$$^^ppttvv\2T\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\35\3"+
		"\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r+\3\2"+
		"\2\2\17-\3\2\2\2\21\61\3\2\2\2\23:\3\2\2\2\25@\3\2\2\2\27B\3\2\2\2\31"+
		"K\3\2\2\2\33Q\3\2\2\2\35S\3\2\2\2\37\"\5\5\3\2 \"\5\7\4\2!\37\3\2\2\2"+
		"! \3\2\2\2\"\4\3\2\2\2#$\t\2\2\2$\6\3\2\2\2%&\t\3\2\2&\b\3\2\2\2\'(\t"+
		"\4\2\2(\n\3\2\2\2)*\7\60\2\2*\f\3\2\2\2+,\7?\2\2,\16\3\2\2\2-.\7f\2\2"+
		"./\7g\2\2/\60\7h\2\2\60\20\3\2\2\2\61\62\7r\2\2\62\63\7c\2\2\63\64\7e"+
		"\2\2\64\65\7m\2\2\65\66\7c\2\2\66\67\7i\2\2\678\7g\2\28\22\3\2\2\29;\5"+
		"\t\5\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\24\3\2\2\2>A\5\3\2\2?"+
		"A\7a\2\2@>\3\2\2\2@?\3\2\2\2A\26\3\2\2\2BG\5\25\13\2CF\5\25\13\2DF\5\t"+
		"\5\2EC\3\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\30\3\2\2\2IG\3"+
		"\2\2\2JL\t\5\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b"+
		"\r\2\2P\32\3\2\2\2QR\t\6\2\2R\34\3\2\2\2ST\13\2\2\2T\36\3\2\2\2\t\2!<"+
		"@EGM\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}