// Generated from org/fujure/fbc/parser/bnfc/antlr/fujure/fujureParser.g4 by ANTLR 4.5.1
package org.fujure.fbc.parser.bnfc.antlr.fujure;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fujureParser extends Parser {
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
		Surrogate_id_SYMB_32=33, Surrogate_id_SYMB_33=34, Surrogate_id_SYMB_34=35, 
		JID=36, JCHAR=37, JSTRING=38, INTEGER=39, WS=40, ErrorToken=41;
	public static final int
		RULE_start_FileContents = 0, RULE_fileContents = 1, RULE_pkgName = 2, 
		RULE_listPkgFragm = 3, RULE_pkgFragm = 4, RULE_imports = 5, RULE_listImport = 6, 
		RULE_import_ = 7, RULE_listImportFragm = 8, RULE_importFragm = 9, RULE_defs = 10, 
		RULE_listDef = 11, RULE_def = 12, RULE_funcDecl = 13, RULE_listParam = 14, 
		RULE_param = 15, RULE_binding = 16, RULE_typeDesc = 17, RULE_funcType = 18, 
		RULE_listFuncTypeFragm = 19, RULE_funcTypeFragm = 20, RULE_simpleType = 21, 
		RULE_listSimpleTypeFragm = 22, RULE_simpleTypeFragm = 23, RULE_listGenericTypeValue = 24, 
		RULE_genericTypeValue = 25, RULE_expr = 26, RULE_letDef = 27, RULE_listLetDef = 28, 
		RULE_listStmt = 29, RULE_stmt = 30, RULE_expr1 = 31, RULE_expr2 = 32, 
		RULE_expr3 = 33, RULE_expr4 = 34, RULE_expr5 = 35, RULE_expr6 = 36, RULE_expr7 = 37, 
		RULE_expr8 = 38, RULE_expr9 = 39, RULE_callArg = 40, RULE_listCallArg = 41, 
		RULE_literal = 42;
	public static final String[] ruleNames = {
		"start_FileContents", "fileContents", "pkgName", "listPkgFragm", "pkgFragm", 
		"imports", "listImport", "import_", "listImportFragm", "importFragm", 
		"defs", "listDef", "def", "funcDecl", "listParam", "param", "binding", 
		"typeDesc", "funcType", "listFuncTypeFragm", "funcTypeFragm", "simpleType", 
		"listSimpleTypeFragm", "simpleTypeFragm", "listGenericTypeValue", "genericTypeValue", 
		"expr", "letDef", "listLetDef", "listStmt", "stmt", "expr1", "expr2", 
		"expr3", "expr4", "expr5", "expr6", "expr7", "expr8", "expr9", "callArg", 
		"listCallArg", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "':'", "'='", "','", "'->'", "'<'", "'>'", 
		"'{'", "'}'", "';'", "'||'", "'&&'", "'=='", "'!='", "'<='", "'>='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'!'", "'def'", "'else'", "'false'", "'if'", 
		"'import'", "'in'", "'let'", "'package'", "'then'", "'true'", "'unit'"
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
		"Surrogate_id_SYMB_32", "Surrogate_id_SYMB_33", "Surrogate_id_SYMB_34", 
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

	@Override
	public String getGrammarFileName() { return "fujureParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public fujureParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Start_FileContentsContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents result;
		public FileContentsContext x;
		public TerminalNode EOF() { return getToken(fujureParser.EOF, 0); }
		public FileContentsContext fileContents() {
			return getRuleContext(FileContentsContext.class,0);
		}
		public Start_FileContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_FileContents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterStart_FileContents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitStart_FileContents(this);
		}
	}

	public final Start_FileContentsContext start_FileContents() throws RecognitionException {
		Start_FileContentsContext _localctx = new Start_FileContentsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_FileContents);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((Start_FileContentsContext)_localctx).x = fileContents();
			setState(87);
			match(EOF);
			 ((Start_FileContentsContext)_localctx).result =  ((Start_FileContentsContext)_localctx).x.result; 
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

	public static class FileContentsContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileContents result;
		public PkgNameContext p_1_2;
		public ImportsContext p_1_3;
		public DefsContext p_1_4;
		public ImportsContext p_2_1;
		public DefsContext p_2_2;
		public TerminalNode Surrogate_id_SYMB_31() { return getToken(fujureParser.Surrogate_id_SYMB_31, 0); }
		public PkgNameContext pkgName() {
			return getRuleContext(PkgNameContext.class,0);
		}
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public FileContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileContents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterFileContents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitFileContents(this);
		}
	}

	public final FileContentsContext fileContents() throws RecognitionException {
		FileContentsContext _localctx = new FileContentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fileContents);
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(Surrogate_id_SYMB_31);
				setState(91);
				((FileContentsContext)_localctx).p_1_2 = pkgName();
				setState(92);
				((FileContentsContext)_localctx).p_1_3 = imports();
				setState(93);
				((FileContentsContext)_localctx).p_1_4 = defs();
				 ((FileContentsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInNamedPackage(((FileContentsContext)_localctx).p_1_2.result,((FileContentsContext)_localctx).p_1_3.result,((FileContentsContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				((FileContentsContext)_localctx).p_2_1 = imports();
				setState(97);
				((FileContentsContext)_localctx).p_2_2 = defs();
				 ((FileContentsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FileInDefaultPackage(((FileContentsContext)_localctx).p_2_1.result,((FileContentsContext)_localctx).p_2_2.result); 
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

	public static class PkgNameContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgName result;
		public ListPkgFragmContext p_1_1;
		public ListPkgFragmContext listPkgFragm() {
			return getRuleContext(ListPkgFragmContext.class,0);
		}
		public PkgNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkgName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterPkgName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitPkgName(this);
		}
	}

	public final PkgNameContext pkgName() throws RecognitionException {
		PkgNameContext _localctx = new PkgNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pkgName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((PkgNameContext)_localctx).p_1_1 = listPkgFragm();
			 ((PkgNameContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageName(((PkgNameContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm result;
		public PkgFragmContext p_1_1;
		public PkgFragmContext p_2_1;
		public ListPkgFragmContext p_2_3;
		public PkgFragmContext pkgFragm() {
			return getRuleContext(PkgFragmContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(fujureParser.Surrogate_id_SYMB_0, 0); }
		public ListPkgFragmContext listPkgFragm() {
			return getRuleContext(ListPkgFragmContext.class,0);
		}
		public ListPkgFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPkgFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListPkgFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListPkgFragm(this);
		}
	}

	public final ListPkgFragmContext listPkgFragm() throws RecognitionException {
		ListPkgFragmContext _localctx = new ListPkgFragmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listPkgFragm);
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				((ListPkgFragmContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				((ListPkgFragmContext)_localctx).p_2_1 = pkgFragm();
				setState(109);
				match(Surrogate_id_SYMB_0);
				setState(110);
				((ListPkgFragmContext)_localctx).p_2_3 = listPkgFragm();
				 ((ListPkgFragmContext)_localctx).result =  ((ListPkgFragmContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListPkgFragmContext)_localctx).p_2_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PkgFragm result;
		public Token p_1_1;
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public PkgFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkgFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterPkgFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitPkgFragm(this);
		}
	}

	public final PkgFragmContext pkgFragm() throws RecognitionException {
		PkgFragmContext _localctx = new PkgFragmContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pkgFragm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			((PkgFragmContext)_localctx).p_1_1 = match(JID);
			 ((PkgFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PackageFragment(((PkgFragmContext)_localctx).p_1_1.getText()); 
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

	public static class ImportsContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Imports result;
		public ListImportContext p_1_1;
		public ListImportContext listImport() {
			return getRuleContext(ListImportContext.class,0);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitImports(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((ImportsContext)_localctx).p_1_1 = listImport(0);
			 ((ImportsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmts(((ImportsContext)_localctx).p_1_1.result); 
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

	public static class ListImportContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport result;
		public ListImportContext p_2_1;
		public Import_Context p_2_2;
		public ListImportContext listImport() {
			return getRuleContext(ListImportContext.class,0);
		}
		public Import_Context import_() {
			return getRuleContext(Import_Context.class,0);
		}
		public ListImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListImport(this);
		}
	}

	public final ListImportContext listImport() throws RecognitionException {
		return listImport(0);
	}

	private ListImportContext listImport(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListImportContext _localctx = new ListImportContext(_ctx, _parentState);
		ListImportContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_listImport, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListImportContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImport(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListImportContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listImport);
					setState(124);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(125);
					((ListImportContext)_localctx).p_2_2 = import_();
					 ((ListImportContext)_localctx).result =  ((ListImportContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImportContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(132);
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

	public static class Import_Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Import result;
		public ListImportFragmContext p_1_2;
		public TerminalNode Surrogate_id_SYMB_28() { return getToken(fujureParser.Surrogate_id_SYMB_28, 0); }
		public ListImportFragmContext listImportFragm() {
			return getRuleContext(ListImportFragmContext.class,0);
		}
		public Import_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterImport_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitImport_(this);
		}
	}

	public final Import_Context import_() throws RecognitionException {
		Import_Context _localctx = new Import_Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_import_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(Surrogate_id_SYMB_28);
			setState(134);
			((Import_Context)_localctx).p_1_2 = listImportFragm();
			 ((Import_Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportStmt(((Import_Context)_localctx).p_1_2.result); 
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

	public static class ListImportFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm result;
		public ImportFragmContext p_1_1;
		public ImportFragmContext p_2_1;
		public ListImportFragmContext p_2_3;
		public ImportFragmContext importFragm() {
			return getRuleContext(ImportFragmContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(fujureParser.Surrogate_id_SYMB_0, 0); }
		public ListImportFragmContext listImportFragm() {
			return getRuleContext(ListImportFragmContext.class,0);
		}
		public ListImportFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listImportFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListImportFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListImportFragm(this);
		}
	}

	public final ListImportFragmContext listImportFragm() throws RecognitionException {
		ListImportFragmContext _localctx = new ListImportFragmContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listImportFragm);
		try {
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				((ListImportFragmContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				((ListImportFragmContext)_localctx).p_2_1 = importFragm();
				setState(141);
				match(Surrogate_id_SYMB_0);
				setState(142);
				((ListImportFragmContext)_localctx).p_2_3 = listImportFragm();
				 ((ListImportFragmContext)_localctx).result =  ((ListImportFragmContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListImportFragmContext)_localctx).p_2_1.result); 
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

	public static class ImportFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragm result;
		public Token p_1_1;
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public ImportFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterImportFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitImportFragm(this);
		}
	}

	public final ImportFragmContext importFragm() throws RecognitionException {
		ImportFragmContext _localctx = new ImportFragmContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_importFragm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((ImportFragmContext)_localctx).p_1_1 = match(JID);
			 ((ImportFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ImportFragment(((ImportFragmContext)_localctx).p_1_1.getText()); 
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

	public static class DefsContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Defs result;
		public ListDefContext p_1_1;
		public ListDefContext listDef() {
			return getRuleContext(ListDefContext.class,0);
		}
		public DefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitDefs(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_defs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((DefsContext)_localctx).p_1_1 = listDef(0);
			 ((DefsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DefListDefs(((DefsContext)_localctx).p_1_1.result); 
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

	public static class ListDefContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef result;
		public ListDefContext p_2_1;
		public DefContext p_2_2;
		public ListDefContext listDef() {
			return getRuleContext(ListDefContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public ListDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListDef(this);
		}
	}

	public final ListDefContext listDef() throws RecognitionException {
		return listDef(0);
	}

	private ListDefContext listDef(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListDefContext _localctx = new ListDefContext(_ctx, _parentState);
		ListDefContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_listDef, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListDef(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListDefContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listDef);
					setState(156);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(157);
					((ListDefContext)_localctx).p_2_2 = def();
					 ((ListDefContext)_localctx).result =  ((ListDefContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDefContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class DefContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Def result;
		public BindingContext p_1_2;
		public FuncDeclContext p_2_2;
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(fujureParser.Surrogate_id_SYMB_24, 0); }
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitDef(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_def);
		try {
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(Surrogate_id_SYMB_24);
				setState(166);
				((DefContext)_localctx).p_1_2 = binding();
				 ((DefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleValueDef(((DefContext)_localctx).p_1_2.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(Surrogate_id_SYMB_24);
				setState(170);
				((DefContext)_localctx).p_2_2 = funcDecl();
				 ((DefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FunctionValueDef(((DefContext)_localctx).p_2_2.result); 
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

	public static class FuncDeclContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncDecl result;
		public Token p_1_1;
		public ListParamContext p_1_3;
		public Token p_2_1;
		public ListParamContext p_2_3;
		public TypeDescContext p_2_6;
		public Token p_3_1;
		public ListParamContext p_3_3;
		public ExprContext p_3_6;
		public Token p_4_1;
		public ListParamContext p_4_3;
		public TypeDescContext p_4_6;
		public ExprContext p_4_8;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(fujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(fujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(fujureParser.Surrogate_id_SYMB_3, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(fujureParser.Surrogate_id_SYMB_4, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitFuncDecl(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcDecl);
		try {
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				((FuncDeclContext)_localctx).p_1_1 = match(JID);
				setState(176);
				match(Surrogate_id_SYMB_1);
				setState(177);
				((FuncDeclContext)_localctx).p_1_3 = listParam();
				setState(178);
				match(Surrogate_id_SYMB_2);
				 ((FuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypelessFuncDecl(((FuncDeclContext)_localctx).p_1_1.getText(),((FuncDeclContext)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				((FuncDeclContext)_localctx).p_2_1 = match(JID);
				setState(182);
				match(Surrogate_id_SYMB_1);
				setState(183);
				((FuncDeclContext)_localctx).p_2_3 = listParam();
				setState(184);
				match(Surrogate_id_SYMB_2);
				setState(185);
				match(Surrogate_id_SYMB_3);
				setState(186);
				((FuncDeclContext)_localctx).p_2_6 = typeDesc();
				 ((FuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AbstractTypedFuncDecl(((FuncDeclContext)_localctx).p_2_1.getText(),((FuncDeclContext)_localctx).p_2_3.result,((FuncDeclContext)_localctx).p_2_6.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				((FuncDeclContext)_localctx).p_3_1 = match(JID);
				setState(190);
				match(Surrogate_id_SYMB_1);
				setState(191);
				((FuncDeclContext)_localctx).p_3_3 = listParam();
				setState(192);
				match(Surrogate_id_SYMB_2);
				setState(193);
				match(Surrogate_id_SYMB_4);
				setState(194);
				((FuncDeclContext)_localctx).p_3_6 = expr();
				 ((FuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypelessFuncDecl(((FuncDeclContext)_localctx).p_3_1.getText(),((FuncDeclContext)_localctx).p_3_3.result,((FuncDeclContext)_localctx).p_3_6.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				((FuncDeclContext)_localctx).p_4_1 = match(JID);
				setState(198);
				match(Surrogate_id_SYMB_1);
				setState(199);
				((FuncDeclContext)_localctx).p_4_3 = listParam();
				setState(200);
				match(Surrogate_id_SYMB_2);
				setState(201);
				match(Surrogate_id_SYMB_3);
				setState(202);
				((FuncDeclContext)_localctx).p_4_6 = typeDesc();
				setState(203);
				match(Surrogate_id_SYMB_4);
				setState(204);
				((FuncDeclContext)_localctx).p_4_8 = expr();
				 ((FuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ConcreteTypedFuncDecl(((FuncDeclContext)_localctx).p_4_1.getText(),((FuncDeclContext)_localctx).p_4_3.result,((FuncDeclContext)_localctx).p_4_6.result,((FuncDeclContext)_localctx).p_4_8.result); 
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

	public static class ListParamContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam result;
		public ParamContext p_2_1;
		public ParamContext p_3_1;
		public ListParamContext p_3_3;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(fujureParser.Surrogate_id_SYMB_5, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public ListParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListParam(this);
		}
	}

	public final ListParamContext listParam() throws RecognitionException {
		ListParamContext _localctx = new ListParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_listParam);
		try {
			setState(218);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ListParamContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				((ListParamContext)_localctx).p_2_1 = param();
				 ((ListParamContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListParam(); _localctx.result.addLast(((ListParamContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				((ListParamContext)_localctx).p_3_1 = param();
				setState(214);
				match(Surrogate_id_SYMB_5);
				setState(215);
				((ListParamContext)_localctx).p_3_3 = listParam();
				 ((ListParamContext)_localctx).result =  ((ListParamContext)_localctx).p_3_3.result; _localctx.result.addFirst(((ListParamContext)_localctx).p_3_1.result); 
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

	public static class ParamContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Param result;
		public BindingContext p_1_1;
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((ParamContext)_localctx).p_1_1 = binding();
			 ((ParamContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BindingParam(((ParamContext)_localctx).p_1_1.result); 
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

	public static class BindingContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Binding result;
		public Token p_1_1;
		public Token p_2_1;
		public TypeDescContext p_2_3;
		public Token p_3_1;
		public ExprContext p_3_3;
		public Token p_4_1;
		public TypeDescContext p_4_3;
		public ExprContext p_4_5;
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(fujureParser.Surrogate_id_SYMB_3, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(fujureParser.Surrogate_id_SYMB_4, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binding);
		try {
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				((BindingContext)_localctx).p_1_1 = match(JID);
				 ((BindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OnlyNameBinding(((BindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				((BindingContext)_localctx).p_2_1 = match(JID);
				setState(226);
				match(Surrogate_id_SYMB_3);
				setState(227);
				((BindingContext)_localctx).p_2_3 = typeDesc();
				 ((BindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameTypeBinding(((BindingContext)_localctx).p_2_1.getText(),((BindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				((BindingContext)_localctx).p_3_1 = match(JID);
				setState(231);
				match(Surrogate_id_SYMB_4);
				setState(232);
				((BindingContext)_localctx).p_3_3 = expr();
				 ((BindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NameInitBinding(((BindingContext)_localctx).p_3_1.getText(),((BindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				((BindingContext)_localctx).p_4_1 = match(JID);
				setState(236);
				match(Surrogate_id_SYMB_3);
				setState(237);
				((BindingContext)_localctx).p_4_3 = typeDesc();
				setState(238);
				match(Surrogate_id_SYMB_4);
				setState(239);
				((BindingContext)_localctx).p_4_5 = expr();
				 ((BindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FullBinding(((BindingContext)_localctx).p_4_1.getText(),((BindingContext)_localctx).p_4_3.result,((BindingContext)_localctx).p_4_5.result); 
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

	public static class TypeDescContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.TypeDesc result;
		public SimpleTypeContext p_1_1;
		public FuncTypeContext p_2_1;
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TypeDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDesc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterTypeDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitTypeDesc(this);
		}
	}

	public final TypeDescContext typeDesc() throws RecognitionException {
		TypeDescContext _localctx = new TypeDescContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeDesc);
		try {
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				((TypeDescContext)_localctx).p_1_1 = simpleType();
				 ((TypeDescContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeDesc(((TypeDescContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				((TypeDescContext)_localctx).p_2_1 = funcType();
				 ((TypeDescContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeDesc(((TypeDescContext)_localctx).p_2_1.result); 
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

	public static class FuncTypeContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncType result;
		public FuncTypeFragmContext p_1_4;
		public FuncTypeFragmContext p_2_1;
		public ListFuncTypeFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(fujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(fujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(fujureParser.Surrogate_id_SYMB_6, 0); }
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragmContext listFuncTypeFragm() {
			return getRuleContext(ListFuncTypeFragmContext.class,0);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitFuncType(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcType);
		try {
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(Surrogate_id_SYMB_1);
				setState(253);
				match(Surrogate_id_SYMB_2);
				setState(254);
				match(Surrogate_id_SYMB_6);
				setState(255);
				((FuncTypeContext)_localctx).p_1_4 = funcTypeFragm();
				 ((FuncTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ZeroArgFuncType(((FuncTypeContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				((FuncTypeContext)_localctx).p_2_1 = funcTypeFragm();
				setState(259);
				match(Surrogate_id_SYMB_6);
				setState(260);
				((FuncTypeContext)_localctx).p_2_3 = listFuncTypeFragm();
				 ((FuncTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiArgFuncType(((FuncTypeContext)_localctx).p_2_1.result,((FuncTypeContext)_localctx).p_2_3.result); 
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

	public static class ListFuncTypeFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm result;
		public FuncTypeFragmContext p_1_1;
		public FuncTypeFragmContext p_2_1;
		public ListFuncTypeFragmContext p_2_3;
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(fujureParser.Surrogate_id_SYMB_6, 0); }
		public ListFuncTypeFragmContext listFuncTypeFragm() {
			return getRuleContext(ListFuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFuncTypeFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListFuncTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListFuncTypeFragm(this);
		}
	}

	public final ListFuncTypeFragmContext listFuncTypeFragm() throws RecognitionException {
		ListFuncTypeFragmContext _localctx = new ListFuncTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_listFuncTypeFragm);
		try {
			setState(273);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				((ListFuncTypeFragmContext)_localctx).p_1_1 = funcTypeFragm();
				 ((ListFuncTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListFuncTypeFragm(); _localctx.result.addLast(((ListFuncTypeFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				((ListFuncTypeFragmContext)_localctx).p_2_1 = funcTypeFragm();
				setState(269);
				match(Surrogate_id_SYMB_6);
				setState(270);
				((ListFuncTypeFragmContext)_localctx).p_2_3 = listFuncTypeFragm();
				 ((ListFuncTypeFragmContext)_localctx).result =  ((ListFuncTypeFragmContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListFuncTypeFragmContext)_localctx).p_2_1.result); 
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

	public static class FuncTypeFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncTypeFragm result;
		public SimpleTypeContext p_1_1;
		public FuncTypeContext p_2_2;
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(fujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(fujureParser.Surrogate_id_SYMB_2, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public FuncTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcTypeFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterFuncTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitFuncTypeFragm(this);
		}
	}

	public final FuncTypeFragmContext funcTypeFragm() throws RecognitionException {
		FuncTypeFragmContext _localctx = new FuncTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcTypeFragm);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case JID:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((FuncTypeFragmContext)_localctx).p_1_1 = simpleType();
				 ((FuncTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleFuncTypeFragm(((FuncTypeFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(Surrogate_id_SYMB_1);
				setState(279);
				((FuncTypeFragmContext)_localctx).p_2_2 = funcType();
				setState(280);
				match(Surrogate_id_SYMB_2);
				 ((FuncTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncFuncTypeFragm(((FuncTypeFragmContext)_localctx).p_2_2.result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SimpleTypeContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleType result;
		public ListSimpleTypeFragmContext p_1_1;
		public ListSimpleTypeFragmContext p_2_1;
		public ListGenericTypeValueContext p_2_3;
		public ListSimpleTypeFragmContext listSimpleTypeFragm() {
			return getRuleContext(ListSimpleTypeFragmContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(fujureParser.Surrogate_id_SYMB_7, 0); }
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(fujureParser.Surrogate_id_SYMB_8, 0); }
		public ListGenericTypeValueContext listGenericTypeValue() {
			return getRuleContext(ListGenericTypeValueContext.class,0);
		}
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitSimpleType(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simpleType);
		try {
			setState(294);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				((SimpleTypeContext)_localctx).p_1_1 = listSimpleTypeFragm();
				 ((SimpleTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FragmSimpleType(((SimpleTypeContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				((SimpleTypeContext)_localctx).p_2_1 = listSimpleTypeFragm();
				setState(289);
				match(Surrogate_id_SYMB_7);
				setState(290);
				((SimpleTypeContext)_localctx).p_2_3 = listGenericTypeValue();
				setState(291);
				match(Surrogate_id_SYMB_8);
				 ((SimpleTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericSimpleType(((SimpleTypeContext)_localctx).p_2_1.result,((SimpleTypeContext)_localctx).p_2_3.result); 
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

	public static class ListSimpleTypeFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm result;
		public SimpleTypeFragmContext p_1_1;
		public SimpleTypeFragmContext p_2_1;
		public ListSimpleTypeFragmContext p_2_3;
		public SimpleTypeFragmContext simpleTypeFragm() {
			return getRuleContext(SimpleTypeFragmContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(fujureParser.Surrogate_id_SYMB_0, 0); }
		public ListSimpleTypeFragmContext listSimpleTypeFragm() {
			return getRuleContext(ListSimpleTypeFragmContext.class,0);
		}
		public ListSimpleTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listSimpleTypeFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListSimpleTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListSimpleTypeFragm(this);
		}
	}

	public final ListSimpleTypeFragmContext listSimpleTypeFragm() throws RecognitionException {
		ListSimpleTypeFragmContext _localctx = new ListSimpleTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_listSimpleTypeFragm);
		try {
			setState(304);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((ListSimpleTypeFragmContext)_localctx).p_1_1 = simpleTypeFragm();
				 ((ListSimpleTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListSimpleTypeFragm(); _localctx.result.addLast(((ListSimpleTypeFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				((ListSimpleTypeFragmContext)_localctx).p_2_1 = simpleTypeFragm();
				setState(300);
				match(Surrogate_id_SYMB_0);
				setState(301);
				((ListSimpleTypeFragmContext)_localctx).p_2_3 = listSimpleTypeFragm();
				 ((ListSimpleTypeFragmContext)_localctx).result =  ((ListSimpleTypeFragmContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListSimpleTypeFragmContext)_localctx).p_2_1.result); 
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

	public static class SimpleTypeFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleTypeFragm result;
		public Token p_1_1;
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public SimpleTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeFragm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterSimpleTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitSimpleTypeFragm(this);
		}
	}

	public final SimpleTypeFragmContext simpleTypeFragm() throws RecognitionException {
		SimpleTypeFragmContext _localctx = new SimpleTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_simpleTypeFragm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			((SimpleTypeFragmContext)_localctx).p_1_1 = match(JID);
			 ((SimpleTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IdSimpleTypeFragm(((SimpleTypeFragmContext)_localctx).p_1_1.getText()); 
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

	public static class ListGenericTypeValueContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue result;
		public GenericTypeValueContext p_2_1;
		public GenericTypeValueContext p_3_1;
		public ListGenericTypeValueContext p_3_3;
		public GenericTypeValueContext genericTypeValue() {
			return getRuleContext(GenericTypeValueContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(fujureParser.Surrogate_id_SYMB_5, 0); }
		public ListGenericTypeValueContext listGenericTypeValue() {
			return getRuleContext(ListGenericTypeValueContext.class,0);
		}
		public ListGenericTypeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listGenericTypeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListGenericTypeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListGenericTypeValue(this);
		}
	}

	public final ListGenericTypeValueContext listGenericTypeValue() throws RecognitionException {
		ListGenericTypeValueContext _localctx = new ListGenericTypeValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_listGenericTypeValue);
		try {
			setState(318);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ListGenericTypeValueContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				((ListGenericTypeValueContext)_localctx).p_2_1 = genericTypeValue();
				 ((ListGenericTypeValueContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListGenericTypeValue(); _localctx.result.addLast(((ListGenericTypeValueContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				((ListGenericTypeValueContext)_localctx).p_3_1 = genericTypeValue();
				setState(314);
				match(Surrogate_id_SYMB_5);
				setState(315);
				((ListGenericTypeValueContext)_localctx).p_3_3 = listGenericTypeValue();
				 ((ListGenericTypeValueContext)_localctx).result =  ((ListGenericTypeValueContext)_localctx).p_3_3.result; _localctx.result.addFirst(((ListGenericTypeValueContext)_localctx).p_3_1.result); 
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

	public static class GenericTypeValueContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeValue result;
		public TypeDescContext p_1_1;
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public GenericTypeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterGenericTypeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitGenericTypeValue(this);
		}
	}

	public final GenericTypeValueContext genericTypeValue() throws RecognitionException {
		GenericTypeValueContext _localctx = new GenericTypeValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_genericTypeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			((GenericTypeValueContext)_localctx).p_1_1 = typeDesc();
			 ((GenericTypeValueContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GenericTypeDescValue(((GenericTypeValueContext)_localctx).p_1_1.result); 
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

	public static class ExprContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public ExprContext p_1_2;
		public ExprContext p_1_4;
		public ExprContext p_1_6;
		public ListLetDefContext p_2_2;
		public ExprContext p_2_4;
		public ListStmtContext p_3_2;
		public Expr1Context p_4_1;
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(fujureParser.Surrogate_id_SYMB_27, 0); }
		public TerminalNode Surrogate_id_SYMB_32() { return getToken(fujureParser.Surrogate_id_SYMB_32, 0); }
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(fujureParser.Surrogate_id_SYMB_25, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Surrogate_id_SYMB_30() { return getToken(fujureParser.Surrogate_id_SYMB_30, 0); }
		public TerminalNode Surrogate_id_SYMB_29() { return getToken(fujureParser.Surrogate_id_SYMB_29, 0); }
		public ListLetDefContext listLetDef() {
			return getRuleContext(ListLetDefContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(fujureParser.Surrogate_id_SYMB_9, 0); }
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(fujureParser.Surrogate_id_SYMB_10, 0); }
		public ListStmtContext listStmt() {
			return getRuleContext(ListStmtContext.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr);
		try {
			setState(345);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_27:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				match(Surrogate_id_SYMB_27);
				setState(324);
				((ExprContext)_localctx).p_1_2 = expr();
				setState(325);
				match(Surrogate_id_SYMB_32);
				setState(326);
				((ExprContext)_localctx).p_1_4 = expr();
				setState(327);
				match(Surrogate_id_SYMB_25);
				setState(328);
				((ExprContext)_localctx).p_1_6 = expr();
				 ((ExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IfExpr(((ExprContext)_localctx).p_1_2.result,((ExprContext)_localctx).p_1_4.result,((ExprContext)_localctx).p_1_6.result); 
				}
				break;
			case Surrogate_id_SYMB_30:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				match(Surrogate_id_SYMB_30);
				setState(332);
				((ExprContext)_localctx).p_2_2 = listLetDef();
				setState(333);
				match(Surrogate_id_SYMB_29);
				setState(334);
				((ExprContext)_localctx).p_2_4 = expr();
				 ((ExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetExpr(((ExprContext)_localctx).p_2_2.result,((ExprContext)_localctx).p_2_4.result); 
				}
				break;
			case Surrogate_id_SYMB_9:
				enterOuterAlt(_localctx, 3);
				{
				setState(337);
				match(Surrogate_id_SYMB_9);
				setState(338);
				((ExprContext)_localctx).p_3_2 = listStmt();
				setState(339);
				match(Surrogate_id_SYMB_10);
				 ((ExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StmtBlockExpr(((ExprContext)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
			case Surrogate_id_SYMB_18:
			case Surrogate_id_SYMB_19:
			case Surrogate_id_SYMB_23:
			case Surrogate_id_SYMB_26:
			case Surrogate_id_SYMB_33:
			case Surrogate_id_SYMB_34:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				((ExprContext)_localctx).p_4_1 = expr1(0);
				 ((ExprContext)_localctx).result =  ((ExprContext)_localctx).p_4_1.result; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LetDefContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDef result;
		public BindingContext p_1_1;
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public LetDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterLetDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitLetDef(this);
		}
	}

	public final LetDefContext letDef() throws RecognitionException {
		LetDefContext _localctx = new LetDefContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_letDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			((LetDefContext)_localctx).p_1_1 = binding();
			 ((LetDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LetDefinition(((LetDefContext)_localctx).p_1_1.result); 
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

	public static class ListLetDefContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef result;
		public LetDefContext p_1_1;
		public LetDefContext p_2_1;
		public ListLetDefContext p_2_3;
		public LetDefContext letDef() {
			return getRuleContext(LetDefContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(fujureParser.Surrogate_id_SYMB_5, 0); }
		public ListLetDefContext listLetDef() {
			return getRuleContext(ListLetDefContext.class,0);
		}
		public ListLetDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLetDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListLetDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListLetDef(this);
		}
	}

	public final ListLetDefContext listLetDef() throws RecognitionException {
		ListLetDefContext _localctx = new ListLetDefContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_listLetDef);
		try {
			setState(358);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				((ListLetDefContext)_localctx).p_1_1 = letDef();
				 ((ListLetDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListLetDef(); _localctx.result.addLast(((ListLetDefContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				((ListLetDefContext)_localctx).p_2_1 = letDef();
				setState(354);
				match(Surrogate_id_SYMB_5);
				setState(355);
				((ListLetDefContext)_localctx).p_2_3 = listLetDef();
				 ((ListLetDefContext)_localctx).result =  ((ListLetDefContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListLetDefContext)_localctx).p_2_1.result); 
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

	public static class ListStmtContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListStmt result;
		public StmtContext p_1_1;
		public StmtContext p_2_1;
		public ListStmtContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(fujureParser.Surrogate_id_SYMB_11, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ListStmtContext listStmt() {
			return getRuleContext(ListStmtContext.class,0);
		}
		public ListStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListStmt(this);
		}
	}

	public final ListStmtContext listStmt() throws RecognitionException {
		ListStmtContext _localctx = new ListStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_listStmt);
		try {
			setState(369);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				((ListStmtContext)_localctx).p_1_1 = stmt();
				setState(361);
				match(Surrogate_id_SYMB_11);
				 ((ListStmtContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListStmt(); _localctx.result.addLast(((ListStmtContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				((ListStmtContext)_localctx).p_2_1 = stmt();
				setState(365);
				match(Surrogate_id_SYMB_11);
				setState(366);
				((ListStmtContext)_localctx).p_2_3 = listStmt();
				 ((ListStmtContext)_localctx).result =  ((ListStmtContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListStmtContext)_localctx).p_2_1.result); 
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

	public static class StmtContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Stmt result;
		public ExprContext p_1_1;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			((StmtContext)_localctx).p_1_1 = expr();
			 ((StmtContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprStmt(((StmtContext)_localctx).p_1_1.result); 
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

	public static class Expr1Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr1Context p_1_1;
		public Expr2Context p_2_1;
		public Expr2Context p_1_3;
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(fujureParser.Surrogate_id_SYMB_12, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr1(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(375);
			((Expr1Context)_localctx).p_2_1 = expr2(0);
			 ((Expr1Context)_localctx).result =  ((Expr1Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr1Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(378);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(379);
					match(Surrogate_id_SYMB_12);
					setState(380);
					((Expr1Context)_localctx).p_1_3 = expr2(0);
					 ((Expr1Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.OrExpr(((Expr1Context)_localctx).p_1_1.result,((Expr1Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class Expr2Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr2Context p_1_1;
		public Expr3Context p_2_1;
		public Expr3Context p_1_3;
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(fujureParser.Surrogate_id_SYMB_13, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		return expr2(0);
	}

	private Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState);
		Expr2Context _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(389);
			((Expr2Context)_localctx).p_2_1 = expr3(0);
			 ((Expr2Context)_localctx).result =  ((Expr2Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(399);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr2Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(392);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(393);
					match(Surrogate_id_SYMB_13);
					setState(394);
					((Expr2Context)_localctx).p_1_3 = expr3(0);
					 ((Expr2Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AndExpr(((Expr2Context)_localctx).p_1_1.result,((Expr2Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class Expr3Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr3Context p_1_1;
		public Expr3Context p_2_1;
		public Expr4Context p_3_1;
		public Expr4Context p_1_3;
		public Expr4Context p_2_3;
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(fujureParser.Surrogate_id_SYMB_14, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(fujureParser.Surrogate_id_SYMB_15, 0); }
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr3(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		return expr3(0);
	}

	private Expr3Context expr3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr3Context _localctx = new Expr3Context(_ctx, _parentState);
		Expr3Context _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expr3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(403);
			((Expr3Context)_localctx).p_3_1 = expr4(0);
			 ((Expr3Context)_localctx).result =  ((Expr3Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(416);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new Expr3Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(406);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(407);
						match(Surrogate_id_SYMB_14);
						setState(408);
						((Expr3Context)_localctx).p_1_3 = expr4(0);
						 ((Expr3Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.EqualityExpr(((Expr3Context)_localctx).p_1_1.result,((Expr3Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Expr3Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(411);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(412);
						match(Surrogate_id_SYMB_15);
						setState(413);
						((Expr3Context)_localctx).p_2_3 = expr4(0);
						 ((Expr3Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.InequalityExpr(((Expr3Context)_localctx).p_2_1.result,((Expr3Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class Expr4Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr4Context p_1_1;
		public Expr4Context p_2_1;
		public Expr4Context p_3_1;
		public Expr4Context p_4_1;
		public Expr5Context p_5_1;
		public Expr5Context p_1_3;
		public Expr5Context p_2_3;
		public Expr5Context p_3_3;
		public Expr5Context p_4_3;
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(fujureParser.Surrogate_id_SYMB_7, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(fujureParser.Surrogate_id_SYMB_16, 0); }
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(fujureParser.Surrogate_id_SYMB_8, 0); }
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(fujureParser.Surrogate_id_SYMB_17, 0); }
		public Expr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr4(this);
		}
	}

	public final Expr4Context expr4() throws RecognitionException {
		return expr4(0);
	}

	private Expr4Context expr4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr4Context _localctx = new Expr4Context(_ctx, _parentState);
		Expr4Context _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(422);
			((Expr4Context)_localctx).p_5_1 = expr5(0);
			 ((Expr4Context)_localctx).result =  ((Expr4Context)_localctx).p_5_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(445);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new Expr4Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(425);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(426);
						match(Surrogate_id_SYMB_7);
						setState(427);
						((Expr4Context)_localctx).p_1_3 = expr5(0);
						 ((Expr4Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserExpr(((Expr4Context)_localctx).p_1_1.result,((Expr4Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Expr4Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(430);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(431);
						match(Surrogate_id_SYMB_16);
						setState(432);
						((Expr4Context)_localctx).p_2_3 = expr5(0);
						 ((Expr4Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LesserEqualExpr(((Expr4Context)_localctx).p_2_1.result,((Expr4Context)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new Expr4Context(_parentctx, _parentState);
						_localctx.p_3_1 = _prevctx;
						_localctx.p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(435);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(436);
						match(Surrogate_id_SYMB_8);
						setState(437);
						((Expr4Context)_localctx).p_3_3 = expr5(0);
						 ((Expr4Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterExpr(((Expr4Context)_localctx).p_3_1.result,((Expr4Context)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new Expr4Context(_parentctx, _parentState);
						_localctx.p_4_1 = _prevctx;
						_localctx.p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(440);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(441);
						match(Surrogate_id_SYMB_17);
						setState(442);
						((Expr4Context)_localctx).p_4_3 = expr5(0);
						 ((Expr4Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.GreaterEqualExpr(((Expr4Context)_localctx).p_4_1.result,((Expr4Context)_localctx).p_4_3.result); 
						}
						break;
					}
					} 
				}
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class Expr5Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr5Context p_1_1;
		public Expr5Context p_2_1;
		public Expr6Context p_3_1;
		public Expr6Context p_1_3;
		public Expr6Context p_2_3;
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(fujureParser.Surrogate_id_SYMB_18, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(fujureParser.Surrogate_id_SYMB_19, 0); }
		public Expr5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr5(this);
		}
	}

	public final Expr5Context expr5() throws RecognitionException {
		return expr5(0);
	}

	private Expr5Context expr5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr5Context _localctx = new Expr5Context(_ctx, _parentState);
		Expr5Context _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(451);
			((Expr5Context)_localctx).p_3_1 = expr6(0);
			 ((Expr5Context)_localctx).result =  ((Expr5Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(464);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new Expr5Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(454);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(455);
						match(Surrogate_id_SYMB_18);
						setState(456);
						((Expr5Context)_localctx).p_1_3 = expr6(0);
						 ((Expr5Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.AdditionExpr(((Expr5Context)_localctx).p_1_1.result,((Expr5Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Expr5Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(459);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(460);
						match(Surrogate_id_SYMB_19);
						setState(461);
						((Expr5Context)_localctx).p_2_3 = expr6(0);
						 ((Expr5Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SubtractionExpr(((Expr5Context)_localctx).p_2_1.result,((Expr5Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class Expr6Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr6Context p_1_1;
		public Expr6Context p_2_1;
		public Expr6Context p_3_1;
		public Expr7Context p_4_1;
		public Expr7Context p_1_3;
		public Expr7Context p_2_3;
		public Expr7Context p_3_3;
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(fujureParser.Surrogate_id_SYMB_20, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(fujureParser.Surrogate_id_SYMB_21, 0); }
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(fujureParser.Surrogate_id_SYMB_22, 0); }
		public Expr6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr6(this);
		}
	}

	public final Expr6Context expr6() throws RecognitionException {
		return expr6(0);
	}

	private Expr6Context expr6(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr6Context _localctx = new Expr6Context(_ctx, _parentState);
		Expr6Context _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expr6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(470);
			((Expr6Context)_localctx).p_4_1 = expr7();
			 ((Expr6Context)_localctx).result =  ((Expr6Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(488);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new Expr6Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(473);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(474);
						match(Surrogate_id_SYMB_20);
						setState(475);
						((Expr6Context)_localctx).p_1_3 = expr7();
						 ((Expr6Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MultiplicationExpr(((Expr6Context)_localctx).p_1_1.result,((Expr6Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Expr6Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(478);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(479);
						match(Surrogate_id_SYMB_21);
						setState(480);
						((Expr6Context)_localctx).p_2_3 = expr7();
						 ((Expr6Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.DivisionExpr(((Expr6Context)_localctx).p_2_1.result,((Expr6Context)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new Expr6Context(_parentctx, _parentState);
						_localctx.p_3_1 = _prevctx;
						_localctx.p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(483);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(484);
						match(Surrogate_id_SYMB_22);
						setState(485);
						((Expr6Context)_localctx).p_3_3 = expr7();
						 ((Expr6Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ModuloExpr(((Expr6Context)_localctx).p_3_1.result,((Expr6Context)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class Expr7Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr8Context p_1_2;
		public Expr8Context p_2_2;
		public Expr8Context p_3_2;
		public Expr8Context p_4_1;
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(fujureParser.Surrogate_id_SYMB_23, 0); }
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(fujureParser.Surrogate_id_SYMB_19, 0); }
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(fujureParser.Surrogate_id_SYMB_18, 0); }
		public Expr7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr7(this);
		}
	}

	public final Expr7Context expr7() throws RecognitionException {
		Expr7Context _localctx = new Expr7Context(_ctx, getState());
		enterRule(_localctx, 74, RULE_expr7);
		try {
			setState(508);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_23:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				match(Surrogate_id_SYMB_23);
				setState(494);
				((Expr7Context)_localctx).p_1_2 = expr8(0);
				 ((Expr7Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NotExpr(((Expr7Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_19:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				match(Surrogate_id_SYMB_19);
				setState(498);
				((Expr7Context)_localctx).p_2_2 = expr8(0);
				 ((Expr7Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.NegateExpr(((Expr7Context)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_18:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(Surrogate_id_SYMB_18);
				setState(502);
				((Expr7Context)_localctx).p_3_2 = expr8(0);
				 ((Expr7Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.PositateExpr(((Expr7Context)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
			case Surrogate_id_SYMB_26:
			case Surrogate_id_SYMB_33:
			case Surrogate_id_SYMB_34:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(505);
				((Expr7Context)_localctx).p_4_1 = expr8(0);
				 ((Expr7Context)_localctx).result =  ((Expr7Context)_localctx).p_4_1.result; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Expr8Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr8Context p_2_1;
		public Token p_1_1;
		public Token p_1_3;
		public Expr9Context p_3_1;
		public Token p_2_3;
		public ListCallArgContext p_2_5;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(fujureParser.Surrogate_id_SYMB_0, 0); }
		public List<TerminalNode> JID() { return getTokens(fujureParser.JID); }
		public TerminalNode JID(int i) {
			return getToken(fujureParser.JID, i);
		}
		public Expr9Context expr9() {
			return getRuleContext(Expr9Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(fujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(fujureParser.Surrogate_id_SYMB_2, 0); }
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public ListCallArgContext listCallArg() {
			return getRuleContext(ListCallArgContext.class,0);
		}
		public Expr8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr8(this);
		}
	}

	public final Expr8Context expr8() throws RecognitionException {
		return expr8(0);
	}

	private Expr8Context expr8(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr8Context _localctx = new Expr8Context(_ctx, _parentState);
		Expr8Context _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expr8, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(511);
				((Expr8Context)_localctx).p_1_1 = match(JID);
				setState(512);
				match(Surrogate_id_SYMB_0);
				setState(513);
				((Expr8Context)_localctx).p_1_3 = match(JID);
				 ((Expr8Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ComplexRefExpr(((Expr8Context)_localctx).p_1_1.getText(),((Expr8Context)_localctx).p_1_3.getText()); 
				}
				break;
			case 2:
				{
				setState(515);
				((Expr8Context)_localctx).p_3_1 = expr9(0);
				 ((Expr8Context)_localctx).result =  ((Expr8Context)_localctx).p_3_1.result; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr8Context(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr8);
					setState(520);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(521);
					match(Surrogate_id_SYMB_0);
					setState(522);
					((Expr8Context)_localctx).p_2_3 = match(JID);
					setState(523);
					match(Surrogate_id_SYMB_1);
					setState(524);
					((Expr8Context)_localctx).p_2_5 = listCallArg();
					setState(525);
					match(Surrogate_id_SYMB_2);
					 ((Expr8Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.MethCallExpr(((Expr8Context)_localctx).p_2_1.result,((Expr8Context)_localctx).p_2_3.getText(),((Expr8Context)_localctx).p_2_5.result); 
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class Expr9Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Expr result;
		public Expr9Context p_1_1;
		public Token p_2_1;
		public LiteralContext p_3_1;
		public ExprContext p_4_2;
		public ListCallArgContext p_1_3;
		public TerminalNode JID() { return getToken(fujureParser.JID, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(fujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(fujureParser.Surrogate_id_SYMB_2, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr9Context expr9() {
			return getRuleContext(Expr9Context.class,0);
		}
		public ListCallArgContext listCallArg() {
			return getRuleContext(ListCallArgContext.class,0);
		}
		public Expr9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr9; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterExpr9(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitExpr9(this);
		}
	}

	public final Expr9Context expr9() throws RecognitionException {
		return expr9(0);
	}

	private Expr9Context expr9(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr9Context _localctx = new Expr9Context(_ctx, _parentState);
		Expr9Context _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expr9, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			switch (_input.LA(1)) {
			case JID:
				{
				setState(534);
				((Expr9Context)_localctx).p_2_1 = match(JID);
				 ((Expr9Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.SimpleRefExpr(((Expr9Context)_localctx).p_2_1.getText()); 
				}
				break;
			case Surrogate_id_SYMB_26:
			case Surrogate_id_SYMB_33:
			case Surrogate_id_SYMB_34:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				{
				setState(536);
				((Expr9Context)_localctx).p_3_1 = literal();
				 ((Expr9Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.LiteralExpr(((Expr9Context)_localctx).p_3_1.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
				{
				setState(539);
				match(Surrogate_id_SYMB_1);
				setState(540);
				((Expr9Context)_localctx).p_4_2 = expr();
				setState(541);
				match(Surrogate_id_SYMB_2);
				 ((Expr9Context)_localctx).result =  ((Expr9Context)_localctx).p_4_2.result; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr9Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr9);
					setState(546);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(547);
					match(Surrogate_id_SYMB_1);
					setState(548);
					((Expr9Context)_localctx).p_1_3 = listCallArg();
					setState(549);
					match(Surrogate_id_SYMB_2);
					 ((Expr9Context)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.FuncCallExpr(((Expr9Context)_localctx).p_1_1.result,((Expr9Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class CallArgContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CallArg result;
		public ExprContext p_1_1;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CallArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterCallArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitCallArg(this);
		}
	}

	public final CallArgContext callArg() throws RecognitionException {
		CallArgContext _localctx = new CallArgContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_callArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			((CallArgContext)_localctx).p_1_1 = expr();
			 ((CallArgContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ExprCallArg(((CallArgContext)_localctx).p_1_1.result); 
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

	public static class ListCallArgContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg result;
		public CallArgContext p_2_1;
		public CallArgContext p_3_1;
		public ListCallArgContext p_3_3;
		public CallArgContext callArg() {
			return getRuleContext(CallArgContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(fujureParser.Surrogate_id_SYMB_5, 0); }
		public ListCallArgContext listCallArg() {
			return getRuleContext(ListCallArgContext.class,0);
		}
		public ListCallArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCallArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterListCallArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitListCallArg(this);
		}
	}

	public final ListCallArgContext listCallArg() throws RecognitionException {
		ListCallArgContext _localctx = new ListCallArgContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_listCallArg);
		try {
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ListCallArgContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(561);
				((ListCallArgContext)_localctx).p_2_1 = callArg();
				 ((ListCallArgContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.ListCallArg(); _localctx.result.addLast(((ListCallArgContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(564);
				((ListCallArgContext)_localctx).p_3_1 = callArg();
				setState(565);
				match(Surrogate_id_SYMB_5);
				setState(566);
				((ListCallArgContext)_localctx).p_3_3 = listCallArg();
				 ((ListCallArgContext)_localctx).result =  ((ListCallArgContext)_localctx).p_3_3.result; _localctx.result.addFirst(((ListCallArgContext)_localctx).p_3_1.result); 
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

	public static class LiteralContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.Literal result;
		public Token p_1_1;
		public Token p_5_1;
		public Token p_6_1;
		public TerminalNode INTEGER() { return getToken(fujureParser.INTEGER, 0); }
		public TerminalNode Surrogate_id_SYMB_34() { return getToken(fujureParser.Surrogate_id_SYMB_34, 0); }
		public TerminalNode Surrogate_id_SYMB_33() { return getToken(fujureParser.Surrogate_id_SYMB_33, 0); }
		public TerminalNode Surrogate_id_SYMB_26() { return getToken(fujureParser.Surrogate_id_SYMB_26, 0); }
		public TerminalNode JCHAR() { return getToken(fujureParser.JCHAR, 0); }
		public TerminalNode JSTRING() { return getToken(fujureParser.JSTRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fujureParserListener ) ((fujureParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_literal);
		try {
			setState(583);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				((LiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.IntLiteral(Integer.parseInt(((LiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_34:
				enterOuterAlt(_localctx, 2);
				{
				setState(573);
				match(Surrogate_id_SYMB_34);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_33:
				enterOuterAlt(_localctx, 3);
				{
				setState(575);
				match(Surrogate_id_SYMB_33);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_26:
				enterOuterAlt(_localctx, 4);
				{
				setState(577);
				match(Surrogate_id_SYMB_26);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(579);
				((LiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.CharLiteral(((LiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(581);
				((LiteralContext)_localctx).p_6_1 = match(JSTRING);
				 ((LiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.fujure.Absyn.StringLiteral(((LiteralContext)_localctx).p_6_1.getText()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		case 6:
			return listImport_sempred((ListImportContext)_localctx, predIndex);
		case 11:
			return listDef_sempred((ListDefContext)_localctx, predIndex);
		case 31:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 32:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 33:
			return expr3_sempred((Expr3Context)_localctx, predIndex);
		case 34:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 35:
			return expr5_sempred((Expr5Context)_localctx, predIndex);
		case 36:
			return expr6_sempred((Expr6Context)_localctx, predIndex);
		case 38:
			return expr8_sempred((Expr8Context)_localctx, predIndex);
		case 39:
			return expr9_sempred((Expr9Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean listImport_sempred(ListImportContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean listDef_sempred(ListDefContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr3_sempred(Expr3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr4_sempred(Expr4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr5_sempred(Expr5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr6_sempred(Expr6Context _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr8_sempred(Expr8Context _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr9_sempred(Expr9Context _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u024c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3g\n\3"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5t\n\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0083\n\b\f\b\16\b\u0086\13\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0094\n\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a3\n\r\f\r\16"+
		"\r\u00a6\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b0\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00d2\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00dd\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00f5\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fd\n\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u010a\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0114\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u011e\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0129\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0133"+
		"\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u0141\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u015c\n\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0169\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0174\n"+
		"\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0182\n!\f!\16!\u0185\13!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0190\n\"\f\"\16\"\u0193\13\"\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u01a3\n#\f#\16#\u01a6\13#"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\7$\u01c0\n$\f$\16$\u01c3\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\7%\u01d3\n%\f%\16%\u01d6\13%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\7&\u01eb\n&\f&\16&\u01ee\13&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01ff\n\'\3(\3(\3(\3(\3("+
		"\3(\3(\3(\5(\u0209\n(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0213\n(\f(\16(\u0216"+
		"\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0223\n)\3)\3)\3)\3)\3)\3)\7"+
		")\u022b\n)\f)\16)\u022e\13)\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u023c"+
		"\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u024a\n,\3,\2\f\16\30@BDFH"+
		"JNP-\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BDFHJLNPRTV\2\2\u0257\2X\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\bs\3\2\2\2\nu\3"+
		"\2\2\2\fx\3\2\2\2\16{\3\2\2\2\20\u0087\3\2\2\2\22\u0093\3\2\2\2\24\u0095"+
		"\3\2\2\2\26\u0098\3\2\2\2\30\u009b\3\2\2\2\32\u00af\3\2\2\2\34\u00d1\3"+
		"\2\2\2\36\u00dc\3\2\2\2 \u00de\3\2\2\2\"\u00f4\3\2\2\2$\u00fc\3\2\2\2"+
		"&\u0109\3\2\2\2(\u0113\3\2\2\2*\u011d\3\2\2\2,\u0128\3\2\2\2.\u0132\3"+
		"\2\2\2\60\u0134\3\2\2\2\62\u0140\3\2\2\2\64\u0142\3\2\2\2\66\u015b\3\2"+
		"\2\28\u015d\3\2\2\2:\u0168\3\2\2\2<\u0173\3\2\2\2>\u0175\3\2\2\2@\u0178"+
		"\3\2\2\2B\u0186\3\2\2\2D\u0194\3\2\2\2F\u01a7\3\2\2\2H\u01c4\3\2\2\2J"+
		"\u01d7\3\2\2\2L\u01fe\3\2\2\2N\u0208\3\2\2\2P\u0222\3\2\2\2R\u022f\3\2"+
		"\2\2T\u023b\3\2\2\2V\u0249\3\2\2\2XY\5\4\3\2YZ\7\2\2\3Z[\b\2\1\2[\3\3"+
		"\2\2\2\\]\7\"\2\2]^\5\6\4\2^_\5\f\7\2_`\5\26\f\2`a\b\3\1\2ag\3\2\2\2b"+
		"c\5\f\7\2cd\5\26\f\2de\b\3\1\2eg\3\2\2\2f\\\3\2\2\2fb\3\2\2\2g\5\3\2\2"+
		"\2hi\5\b\5\2ij\b\4\1\2j\7\3\2\2\2kl\5\n\6\2lm\b\5\1\2mt\3\2\2\2no\5\n"+
		"\6\2op\7\3\2\2pq\5\b\5\2qr\b\5\1\2rt\3\2\2\2sk\3\2\2\2sn\3\2\2\2t\t\3"+
		"\2\2\2uv\7&\2\2vw\b\6\1\2w\13\3\2\2\2xy\5\16\b\2yz\b\7\1\2z\r\3\2\2\2"+
		"{|\b\b\1\2|}\b\b\1\2}\u0084\3\2\2\2~\177\f\3\2\2\177\u0080\5\20\t\2\u0080"+
		"\u0081\b\b\1\2\u0081\u0083\3\2\2\2\u0082~\3\2\2\2\u0083\u0086\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u0088\7\37\2\2\u0088\u0089\5\22\n\2\u0089\u008a\b\t\1\2"+
		"\u008a\21\3\2\2\2\u008b\u008c\5\24\13\2\u008c\u008d\b\n\1\2\u008d\u0094"+
		"\3\2\2\2\u008e\u008f\5\24\13\2\u008f\u0090\7\3\2\2\u0090\u0091\5\22\n"+
		"\2\u0091\u0092\b\n\1\2\u0092\u0094\3\2\2\2\u0093\u008b\3\2\2\2\u0093\u008e"+
		"\3\2\2\2\u0094\23\3\2\2\2\u0095\u0096\7&\2\2\u0096\u0097\b\13\1\2\u0097"+
		"\25\3\2\2\2\u0098\u0099\5\30\r\2\u0099\u009a\b\f\1\2\u009a\27\3\2\2\2"+
		"\u009b\u009c\b\r\1\2\u009c\u009d\b\r\1\2\u009d\u00a4\3\2\2\2\u009e\u009f"+
		"\f\3\2\2\u009f\u00a0\5\32\16\2\u00a0\u00a1\b\r\1\2\u00a1\u00a3\3\2\2\2"+
		"\u00a2\u009e\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\33\2\2\u00a8"+
		"\u00a9\5\"\22\2\u00a9\u00aa\b\16\1\2\u00aa\u00b0\3\2\2\2\u00ab\u00ac\7"+
		"\33\2\2\u00ac\u00ad\5\34\17\2\u00ad\u00ae\b\16\1\2\u00ae\u00b0\3\2\2\2"+
		"\u00af\u00a7\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\33\3\2\2\2\u00b1\u00b2"+
		"\7&\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b4\5\36\20\2\u00b4\u00b5\7\5\2\2"+
		"\u00b5\u00b6\b\17\1\2\u00b6\u00d2\3\2\2\2\u00b7\u00b8\7&\2\2\u00b8\u00b9"+
		"\7\4\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7\5\2\2\u00bb\u00bc\7\6\2\2"+
		"\u00bc\u00bd\5$\23\2\u00bd\u00be\b\17\1\2\u00be\u00d2\3\2\2\2\u00bf\u00c0"+
		"\7&\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c2\5\36\20\2\u00c2\u00c3\7\5\2\2"+
		"\u00c3\u00c4\7\7\2\2\u00c4\u00c5\5\66\34\2\u00c5\u00c6\b\17\1\2\u00c6"+
		"\u00d2\3\2\2\2\u00c7\u00c8\7&\2\2\u00c8\u00c9\7\4\2\2\u00c9\u00ca\5\36"+
		"\20\2\u00ca\u00cb\7\5\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\5$\23\2\u00cd"+
		"\u00ce\7\7\2\2\u00ce\u00cf\5\66\34\2\u00cf\u00d0\b\17\1\2\u00d0\u00d2"+
		"\3\2\2\2\u00d1\u00b1\3\2\2\2\u00d1\u00b7\3\2\2\2\u00d1\u00bf\3\2\2\2\u00d1"+
		"\u00c7\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00dd\b\20\1\2\u00d4\u00d5\5 \21"+
		"\2\u00d5\u00d6\b\20\1\2\u00d6\u00dd\3\2\2\2\u00d7\u00d8\5 \21\2\u00d8"+
		"\u00d9\7\b\2\2\u00d9\u00da\5\36\20\2\u00da\u00db\b\20\1\2\u00db\u00dd"+
		"\3\2\2\2\u00dc\u00d3\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd"+
		"\37\3\2\2\2\u00de\u00df\5\"\22\2\u00df\u00e0\b\21\1\2\u00e0!\3\2\2\2\u00e1"+
		"\u00e2\7&\2\2\u00e2\u00f5\b\22\1\2\u00e3\u00e4\7&\2\2\u00e4\u00e5\7\6"+
		"\2\2\u00e5\u00e6\5$\23\2\u00e6\u00e7\b\22\1\2\u00e7\u00f5\3\2\2\2\u00e8"+
		"\u00e9\7&\2\2\u00e9\u00ea\7\7\2\2\u00ea\u00eb\5\66\34\2\u00eb\u00ec\b"+
		"\22\1\2\u00ec\u00f5\3\2\2\2\u00ed\u00ee\7&\2\2\u00ee\u00ef\7\6\2\2\u00ef"+
		"\u00f0\5$\23\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\5\66\34\2\u00f2\u00f3\b"+
		"\22\1\2\u00f3\u00f5\3\2\2\2\u00f4\u00e1\3\2\2\2\u00f4\u00e3\3\2\2\2\u00f4"+
		"\u00e8\3\2\2\2\u00f4\u00ed\3\2\2\2\u00f5#\3\2\2\2\u00f6\u00f7\5,\27\2"+
		"\u00f7\u00f8\b\23\1\2\u00f8\u00fd\3\2\2\2\u00f9\u00fa\5&\24\2\u00fa\u00fb"+
		"\b\23\1\2\u00fb\u00fd\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f9\3\2\2\2"+
		"\u00fd%\3\2\2\2\u00fe\u00ff\7\4\2\2\u00ff\u0100\7\5\2\2\u0100\u0101\7"+
		"\t\2\2\u0101\u0102\5*\26\2\u0102\u0103\b\24\1\2\u0103\u010a\3\2\2\2\u0104"+
		"\u0105\5*\26\2\u0105\u0106\7\t\2\2\u0106\u0107\5(\25\2\u0107\u0108\b\24"+
		"\1\2\u0108\u010a\3\2\2\2\u0109\u00fe\3\2\2\2\u0109\u0104\3\2\2\2\u010a"+
		"\'\3\2\2\2\u010b\u010c\5*\26\2\u010c\u010d\b\25\1\2\u010d\u0114\3\2\2"+
		"\2\u010e\u010f\5*\26\2\u010f\u0110\7\t\2\2\u0110\u0111\5(\25\2\u0111\u0112"+
		"\b\25\1\2\u0112\u0114\3\2\2\2\u0113\u010b\3\2\2\2\u0113\u010e\3\2\2\2"+
		"\u0114)\3\2\2\2\u0115\u0116\5,\27\2\u0116\u0117\b\26\1\2\u0117\u011e\3"+
		"\2\2\2\u0118\u0119\7\4\2\2\u0119\u011a\5&\24\2\u011a\u011b\7\5\2\2\u011b"+
		"\u011c\b\26\1\2\u011c\u011e\3\2\2\2\u011d\u0115\3\2\2\2\u011d\u0118\3"+
		"\2\2\2\u011e+\3\2\2\2\u011f\u0120\5.\30\2\u0120\u0121\b\27\1\2\u0121\u0129"+
		"\3\2\2\2\u0122\u0123\5.\30\2\u0123\u0124\7\n\2\2\u0124\u0125\5\62\32\2"+
		"\u0125\u0126\7\13\2\2\u0126\u0127\b\27\1\2\u0127\u0129\3\2\2\2\u0128\u011f"+
		"\3\2\2\2\u0128\u0122\3\2\2\2\u0129-\3\2\2\2\u012a\u012b\5\60\31\2\u012b"+
		"\u012c\b\30\1\2\u012c\u0133\3\2\2\2\u012d\u012e\5\60\31\2\u012e\u012f"+
		"\7\3\2\2\u012f\u0130\5.\30\2\u0130\u0131\b\30\1\2\u0131\u0133\3\2\2\2"+
		"\u0132\u012a\3\2\2\2\u0132\u012d\3\2\2\2\u0133/\3\2\2\2\u0134\u0135\7"+
		"&\2\2\u0135\u0136\b\31\1\2\u0136\61\3\2\2\2\u0137\u0141\b\32\1\2\u0138"+
		"\u0139\5\64\33\2\u0139\u013a\b\32\1\2\u013a\u0141\3\2\2\2\u013b\u013c"+
		"\5\64\33\2\u013c\u013d\7\b\2\2\u013d\u013e\5\62\32\2\u013e\u013f\b\32"+
		"\1\2\u013f\u0141\3\2\2\2\u0140\u0137\3\2\2\2\u0140\u0138\3\2\2\2\u0140"+
		"\u013b\3\2\2\2\u0141\63\3\2\2\2\u0142\u0143\5$\23\2\u0143\u0144\b\33\1"+
		"\2\u0144\65\3\2\2\2\u0145\u0146\7\36\2\2\u0146\u0147\5\66\34\2\u0147\u0148"+
		"\7#\2\2\u0148\u0149\5\66\34\2\u0149\u014a\7\34\2\2\u014a\u014b\5\66\34"+
		"\2\u014b\u014c\b\34\1\2\u014c\u015c\3\2\2\2\u014d\u014e\7!\2\2\u014e\u014f"+
		"\5:\36\2\u014f\u0150\7 \2\2\u0150\u0151\5\66\34\2\u0151\u0152\b\34\1\2"+
		"\u0152\u015c\3\2\2\2\u0153\u0154\7\f\2\2\u0154\u0155\5<\37\2\u0155\u0156"+
		"\7\r\2\2\u0156\u0157\b\34\1\2\u0157\u015c\3\2\2\2\u0158\u0159\5@!\2\u0159"+
		"\u015a\b\34\1\2\u015a\u015c\3\2\2\2\u015b\u0145\3\2\2\2\u015b\u014d\3"+
		"\2\2\2\u015b\u0153\3\2\2\2\u015b\u0158\3\2\2\2\u015c\67\3\2\2\2\u015d"+
		"\u015e\5\"\22\2\u015e\u015f\b\35\1\2\u015f9\3\2\2\2\u0160\u0161\58\35"+
		"\2\u0161\u0162\b\36\1\2\u0162\u0169\3\2\2\2\u0163\u0164\58\35\2\u0164"+
		"\u0165\7\b\2\2\u0165\u0166\5:\36\2\u0166\u0167\b\36\1\2\u0167\u0169\3"+
		"\2\2\2\u0168\u0160\3\2\2\2\u0168\u0163\3\2\2\2\u0169;\3\2\2\2\u016a\u016b"+
		"\5> \2\u016b\u016c\7\16\2\2\u016c\u016d\b\37\1\2\u016d\u0174\3\2\2\2\u016e"+
		"\u016f\5> \2\u016f\u0170\7\16\2\2\u0170\u0171\5<\37\2\u0171\u0172\b\37"+
		"\1\2\u0172\u0174\3\2\2\2\u0173\u016a\3\2\2\2\u0173\u016e\3\2\2\2\u0174"+
		"=\3\2\2\2\u0175\u0176\5\66\34\2\u0176\u0177\b \1\2\u0177?\3\2\2\2\u0178"+
		"\u0179\b!\1\2\u0179\u017a\5B\"\2\u017a\u017b\b!\1\2\u017b\u0183\3\2\2"+
		"\2\u017c\u017d\f\4\2\2\u017d\u017e\7\17\2\2\u017e\u017f\5B\"\2\u017f\u0180"+
		"\b!\1\2\u0180\u0182\3\2\2\2\u0181\u017c\3\2\2\2\u0182\u0185\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184A\3\2\2\2\u0185\u0183\3\2\2\2"+
		"\u0186\u0187\b\"\1\2\u0187\u0188\5D#\2\u0188\u0189\b\"\1\2\u0189\u0191"+
		"\3\2\2\2\u018a\u018b\f\4\2\2\u018b\u018c\7\20\2\2\u018c\u018d\5D#\2\u018d"+
		"\u018e\b\"\1\2\u018e\u0190\3\2\2\2\u018f\u018a\3\2\2\2\u0190\u0193\3\2"+
		"\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192C\3\2\2\2\u0193\u0191"+
		"\3\2\2\2\u0194\u0195\b#\1\2\u0195\u0196\5F$\2\u0196\u0197\b#\1\2\u0197"+
		"\u01a4\3\2\2\2\u0198\u0199\f\5\2\2\u0199\u019a\7\21\2\2\u019a\u019b\5"+
		"F$\2\u019b\u019c\b#\1\2\u019c\u01a3\3\2\2\2\u019d\u019e\f\4\2\2\u019e"+
		"\u019f\7\22\2\2\u019f\u01a0\5F$\2\u01a0\u01a1\b#\1\2\u01a1\u01a3\3\2\2"+
		"\2\u01a2\u0198\3\2\2\2\u01a2\u019d\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5E\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7"+
		"\u01a8\b$\1\2\u01a8\u01a9\5H%\2\u01a9\u01aa\b$\1\2\u01aa\u01c1\3\2\2\2"+
		"\u01ab\u01ac\f\7\2\2\u01ac\u01ad\7\n\2\2\u01ad\u01ae\5H%\2\u01ae\u01af"+
		"\b$\1\2\u01af\u01c0\3\2\2\2\u01b0\u01b1\f\6\2\2\u01b1\u01b2\7\23\2\2\u01b2"+
		"\u01b3\5H%\2\u01b3\u01b4\b$\1\2\u01b4\u01c0\3\2\2\2\u01b5\u01b6\f\5\2"+
		"\2\u01b6\u01b7\7\13\2\2\u01b7\u01b8\5H%\2\u01b8\u01b9\b$\1\2\u01b9\u01c0"+
		"\3\2\2\2\u01ba\u01bb\f\4\2\2\u01bb\u01bc\7\24\2\2\u01bc\u01bd\5H%\2\u01bd"+
		"\u01be\b$\1\2\u01be\u01c0\3\2\2\2\u01bf\u01ab\3\2\2\2\u01bf\u01b0\3\2"+
		"\2\2\u01bf\u01b5\3\2\2\2\u01bf\u01ba\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1"+
		"\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2G\3\2\2\2\u01c3\u01c1\3\2\2\2"+
		"\u01c4\u01c5\b%\1\2\u01c5\u01c6\5J&\2\u01c6\u01c7\b%\1\2\u01c7\u01d4\3"+
		"\2\2\2\u01c8\u01c9\f\5\2\2\u01c9\u01ca\7\25\2\2\u01ca\u01cb\5J&\2\u01cb"+
		"\u01cc\b%\1\2\u01cc\u01d3\3\2\2\2\u01cd\u01ce\f\4\2\2\u01ce\u01cf\7\26"+
		"\2\2\u01cf\u01d0\5J&\2\u01d0\u01d1\b%\1\2\u01d1\u01d3\3\2\2\2\u01d2\u01c8"+
		"\3\2\2\2\u01d2\u01cd\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5I\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8\b&\1\2\u01d8"+
		"\u01d9\5L\'\2\u01d9\u01da\b&\1\2\u01da\u01ec\3\2\2\2\u01db\u01dc\f\6\2"+
		"\2\u01dc\u01dd\7\27\2\2\u01dd\u01de\5L\'\2\u01de\u01df\b&\1\2\u01df\u01eb"+
		"\3\2\2\2\u01e0\u01e1\f\5\2\2\u01e1\u01e2\7\30\2\2\u01e2\u01e3\5L\'\2\u01e3"+
		"\u01e4\b&\1\2\u01e4\u01eb\3\2\2\2\u01e5\u01e6\f\4\2\2\u01e6\u01e7\7\31"+
		"\2\2\u01e7\u01e8\5L\'\2\u01e8\u01e9\b&\1\2\u01e9\u01eb\3\2\2\2\u01ea\u01db"+
		"\3\2\2\2\u01ea\u01e0\3\2\2\2\u01ea\u01e5\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01edK\3\2\2\2\u01ee\u01ec\3\2\2\2"+
		"\u01ef\u01f0\7\32\2\2\u01f0\u01f1\5N(\2\u01f1\u01f2\b\'\1\2\u01f2\u01ff"+
		"\3\2\2\2\u01f3\u01f4\7\26\2\2\u01f4\u01f5\5N(\2\u01f5\u01f6\b\'\1\2\u01f6"+
		"\u01ff\3\2\2\2\u01f7\u01f8\7\25\2\2\u01f8\u01f9\5N(\2\u01f9\u01fa\b\'"+
		"\1\2\u01fa\u01ff\3\2\2\2\u01fb\u01fc\5N(\2\u01fc\u01fd\b\'\1\2\u01fd\u01ff"+
		"\3\2\2\2\u01fe\u01ef\3\2\2\2\u01fe\u01f3\3\2\2\2\u01fe\u01f7\3\2\2\2\u01fe"+
		"\u01fb\3\2\2\2\u01ffM\3\2\2\2\u0200\u0201\b(\1\2\u0201\u0202\7&\2\2\u0202"+
		"\u0203\7\3\2\2\u0203\u0204\7&\2\2\u0204\u0209\b(\1\2\u0205\u0206\5P)\2"+
		"\u0206\u0207\b(\1\2\u0207\u0209\3\2\2\2\u0208\u0200\3\2\2\2\u0208\u0205"+
		"\3\2\2\2\u0209\u0214\3\2\2\2\u020a\u020b\f\4\2\2\u020b\u020c\7\3\2\2\u020c"+
		"\u020d\7&\2\2\u020d\u020e\7\4\2\2\u020e\u020f\5T+\2\u020f\u0210\7\5\2"+
		"\2\u0210\u0211\b(\1\2\u0211\u0213\3\2\2\2\u0212\u020a\3\2\2\2\u0213\u0216"+
		"\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215O\3\2\2\2\u0216"+
		"\u0214\3\2\2\2\u0217\u0218\b)\1\2\u0218\u0219\7&\2\2\u0219\u0223\b)\1"+
		"\2\u021a\u021b\5V,\2\u021b\u021c\b)\1\2\u021c\u0223\3\2\2\2\u021d\u021e"+
		"\7\4\2\2\u021e\u021f\5\66\34\2\u021f\u0220\7\5\2\2\u0220\u0221\b)\1\2"+
		"\u0221\u0223\3\2\2\2\u0222\u0217\3\2\2\2\u0222\u021a\3\2\2\2\u0222\u021d"+
		"\3\2\2\2\u0223\u022c\3\2\2\2\u0224\u0225\f\6\2\2\u0225\u0226\7\4\2\2\u0226"+
		"\u0227\5T+\2\u0227\u0228\7\5\2\2\u0228\u0229\b)\1\2\u0229\u022b\3\2\2"+
		"\2\u022a\u0224\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d"+
		"\3\2\2\2\u022dQ\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0230\5\66\34\2\u0230"+
		"\u0231\b*\1\2\u0231S\3\2\2\2\u0232\u023c\b+\1\2\u0233\u0234\5R*\2\u0234"+
		"\u0235\b+\1\2\u0235\u023c\3\2\2\2\u0236\u0237\5R*\2\u0237\u0238\7\b\2"+
		"\2\u0238\u0239\5T+\2\u0239\u023a\b+\1\2\u023a\u023c\3\2\2\2\u023b\u0232"+
		"\3\2\2\2\u023b\u0233\3\2\2\2\u023b\u0236\3\2\2\2\u023cU\3\2\2\2\u023d"+
		"\u023e\7)\2\2\u023e\u024a\b,\1\2\u023f\u0240\7%\2\2\u0240\u024a\b,\1\2"+
		"\u0241\u0242\7$\2\2\u0242\u024a\b,\1\2\u0243\u0244\7\35\2\2\u0244\u024a"+
		"\b,\1\2\u0245\u0246\7\'\2\2\u0246\u024a\b,\1\2\u0247\u0248\7(\2\2\u0248"+
		"\u024a\b,\1\2\u0249\u023d\3\2\2\2\u0249\u023f\3\2\2\2\u0249\u0241\3\2"+
		"\2\2\u0249\u0243\3\2\2\2\u0249\u0245\3\2\2\2\u0249\u0247\3\2\2\2\u024a"+
		"W\3\2\2\2&fs\u0084\u0093\u00a4\u00af\u00d1\u00dc\u00f4\u00fc\u0109\u0113"+
		"\u011d\u0128\u0132\u0140\u015b\u0168\u0173\u0183\u0191\u01a2\u01a4\u01bf"+
		"\u01c1\u01d2\u01d4\u01ea\u01ec\u01fe\u0208\u0214\u0222\u022c\u023b\u0249";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}