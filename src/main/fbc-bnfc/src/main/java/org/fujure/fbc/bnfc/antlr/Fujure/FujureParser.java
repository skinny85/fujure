// Generated from org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.7
package org.fujure.fbc.bnfc.antlr.Fujure;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FujureParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, Surrogate_id_SYMB_2=3, Surrogate_id_SYMB_3=4, 
		INTEGER=5, IDENT=6, WS=7, ErrorToken=8;
	public static final int
		RULE_fileContents = 0, RULE_listPkgFragm = 1, RULE_pkgFragm = 2, RULE_listValDef = 3, 
		RULE_valDef = 4;
	public static final String[] ruleNames = {
		"fileContents", "listPkgFragm", "pkgFragm", "listValDef", "valDef"
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

	@Override
	public String getGrammarFileName() { return "FujureParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FujureParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContentsContext extends ParserRuleContext {
		public org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileContents result;
		public FileContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileContents; }
	 
		public FileContentsContext() { }
		public void copyFrom(FileContentsContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class FileInDefaultPackageContext extends FileContentsContext {
		public ListValDefContext p_2_1;
		public ListValDefContext listValDef() {
			return getRuleContext(ListValDefContext.class,0);
		}
		public FileInDefaultPackageContext(FileContentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFileInDefaultPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFileInDefaultPackage(this);
		}
	}
	public static class FileInNamedPackageContext extends FileContentsContext {
		public ListPkgFragmContext p_1_2;
		public ListValDefContext p_1_3;
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public ListPkgFragmContext listPkgFragm() {
			return getRuleContext(ListPkgFragmContext.class,0);
		}
		public ListValDefContext listValDef() {
			return getRuleContext(ListValDefContext.class,0);
		}
		public FileInNamedPackageContext(FileContentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFileInNamedPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFileInNamedPackage(this);
		}
	}

	public final FileContentsContext fileContents() throws RecognitionException {
		FileContentsContext _localctx = new FileContentsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fileContents);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				match(Surrogate_id_SYMB_3);
				setState(11);
				((FileInNamedPackageContext)_localctx).p_1_2 = listPkgFragm();
				setState(12);
				((FileInNamedPackageContext)_localctx).p_1_3 = listValDef(0);
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				((FileInDefaultPackageContext)_localctx).p_2_1 = listValDef(0);
				 ((FileInDefaultPackageContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage(((FileInDefaultPackageContext)_localctx).p_2_1.result); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListPkgFragmContext extends ParserRuleContext {
		public org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ListPkgFragm result;
		public ListPkgFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPkgFragm; }
	 
		public ListPkgFragmContext() { }
		public void copyFrom(ListPkgFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListPkgFragm_AppendLastContext extends ListPkgFragmContext {
		public PkgFragmContext p_1_1;
		public PkgFragmContext pkgFragm() {
			return getRuleContext(PkgFragmContext.class,0);
		}
		public ListPkgFragm_AppendLastContext(ListPkgFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListPkgFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListPkgFragm_AppendLast(this);
		}
	}
	public static class ListPkgFragm_PrependFirstContext extends ListPkgFragmContext {
		public PkgFragmContext p_2_1;
		public ListPkgFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public PkgFragmContext pkgFragm() {
			return getRuleContext(PkgFragmContext.class,0);
		}
		public ListPkgFragmContext listPkgFragm() {
			return getRuleContext(ListPkgFragmContext.class,0);
		}
		public ListPkgFragm_PrependFirstContext(ListPkgFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListPkgFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListPkgFragm_PrependFirst(this);
		}
	}

	public final ListPkgFragmContext listPkgFragm() throws RecognitionException {
		ListPkgFragmContext _localctx = new ListPkgFragmContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listPkgFragm);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(24);
				match(Surrogate_id_SYMB_0);
				setState(25);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_3 = listPkgFragm();
				 ((ListPkgFragm_PrependFirstContext)_localctx).result =  ((ListPkgFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListPkgFragm_PrependFirstContext)_localctx).p_2_1.result); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PkgFragmContext extends ParserRuleContext {
		public org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PkgFragm result;
		public PkgFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkgFragm; }
	 
		public PkgFragmContext() { }
		public void copyFrom(PkgFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class PackageFragmentContext extends PkgFragmContext {
		public Token p_1_1;
		public TerminalNode IDENT() { return getToken(FujureParser.IDENT, 0); }
		public PackageFragmentContext(PkgFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterPackageFragment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitPackageFragment(this);
		}
	}

	public final PkgFragmContext pkgFragm() throws RecognitionException {
		PkgFragmContext _localctx = new PkgFragmContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pkgFragm);
		try {
			_localctx = new PackageFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((PackageFragmentContext)_localctx).p_1_1 = match(IDENT);
			 ((PackageFragmentContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.PackageFragment(((PackageFragmentContext)_localctx).p_1_1.getText()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListValDefContext extends ParserRuleContext {
		public org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ListValDef result;
		public ListValDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValDef; }
	 
		public ListValDefContext() { }
		public void copyFrom(ListValDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListValDef_EmptyContext extends ListValDefContext {
		public ListValDef_EmptyContext(ListValDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListValDef_Empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListValDef_Empty(this);
		}
	}
	public static class ListValDef_PrependFirstContext extends ListValDefContext {
		public ListValDefContext p_2_1;
		public ValDefContext p_2_2;
		public ListValDefContext listValDef() {
			return getRuleContext(ListValDefContext.class,0);
		}
		public ValDefContext valDef() {
			return getRuleContext(ValDefContext.class,0);
		}
		public ListValDef_PrependFirstContext(ListValDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListValDef_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListValDef_PrependFirst(this);
		}
	}

	public final ListValDefContext listValDef() throws RecognitionException {
		return listValDef(0);
	}

	private ListValDefContext listValDef(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListValDefContext _localctx = new ListValDefContext(_ctx, _parentState);
		ListValDefContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_listValDef, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ListValDef_EmptyContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			 ((ListValDef_EmptyContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ListValDef(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListValDef_PrependFirstContext(new ListValDefContext(_parentctx, _parentState));
					((ListValDef_PrependFirstContext)_localctx).p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listValDef);
					setState(36);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(37);
					((ListValDef_PrependFirstContext)_localctx).p_2_2 = valDef();
					 ((ListValDef_PrependFirstContext)_localctx).result =  ((ListValDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListValDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValDefContext extends ParserRuleContext {
		public org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValDef result;
		public ValDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valDef; }
	 
		public ValDefContext() { }
		public void copyFrom(ValDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ValueDefContext extends ValDefContext {
		public Token p_1_2;
		public Token p_1_4;
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode IDENT() { return getToken(FujureParser.IDENT, 0); }
		public TerminalNode INTEGER() { return getToken(FujureParser.INTEGER, 0); }
		public ValueDefContext(ValDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterValueDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitValueDef(this);
		}
	}

	public final ValDefContext valDef() throws RecognitionException {
		ValDefContext _localctx = new ValDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valDef);
		try {
			_localctx = new ValueDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(Surrogate_id_SYMB_2);
			setState(46);
			((ValueDefContext)_localctx).p_1_2 = match(IDENT);
			setState(47);
			match(Surrogate_id_SYMB_1);
			setState(48);
			((ValueDefContext)_localctx).p_1_4 = match(INTEGER);
			 ((ValueDefContext)_localctx).result =  new org.fujure.fbc.bnfc.antlr.Fujure.Absyn.ValueDef(((ValueDefContext)_localctx).p_1_2.getText(),Integer.parseInt(((ValueDefContext)_localctx).p_1_4.getText())); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return listValDef_sempred((ListValDefContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean listValDef_sempred(ListValDefContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\25\n"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\2"+
		"\3\b\7\2\4\6\b\n\2\2\2\63\2\24\3\2\2\2\4\36\3\2\2\2\6 \3\2\2\2\b#\3\2"+
		"\2\2\n/\3\2\2\2\f\r\7\6\2\2\r\16\5\4\3\2\16\17\5\b\5\2\17\20\b\2\1\2\20"+
		"\25\3\2\2\2\21\22\5\b\5\2\22\23\b\2\1\2\23\25\3\2\2\2\24\f\3\2\2\2\24"+
		"\21\3\2\2\2\25\3\3\2\2\2\26\27\5\6\4\2\27\30\b\3\1\2\30\37\3\2\2\2\31"+
		"\32\5\6\4\2\32\33\7\3\2\2\33\34\5\4\3\2\34\35\b\3\1\2\35\37\3\2\2\2\36"+
		"\26\3\2\2\2\36\31\3\2\2\2\37\5\3\2\2\2 !\7\b\2\2!\"\b\4\1\2\"\7\3\2\2"+
		"\2#$\b\5\1\2$%\b\5\1\2%,\3\2\2\2&\'\f\3\2\2\'(\5\n\6\2()\b\5\1\2)+\3\2"+
		"\2\2*&\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\t\3\2\2\2.,\3\2\2\2/\60"+
		"\7\5\2\2\60\61\7\b\2\2\61\62\7\4\2\2\62\63\7\7\2\2\63\64\b\6\1\2\64\13"+
		"\3\2\2\2\5\24\36,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}