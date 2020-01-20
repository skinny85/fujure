// Generated from org/fujure/fbc/parser/bnfc/antlr/Fujure/FujureParser.g4 by ANTLR 4.5.1
package org.fujure.fbc.parser.bnfc.antlr.Fujure;
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
	public static final int
		RULE_fileContents = 0, RULE_pkgName = 1, RULE_listPkgFragm = 2, RULE_pkgFragm = 3, 
		RULE_imports = 4, RULE_listImport = 5, RULE_import_ = 6, RULE_listImportFragm = 7, 
		RULE_importFragm = 8, RULE_defs = 9, RULE_listDef = 10, RULE_def = 11, 
		RULE_funcDecl = 12, RULE_listParam = 13, RULE_param = 14, RULE_binding = 15, 
		RULE_typeDesc = 16, RULE_funcType = 17, RULE_listFuncTypeFragm = 18, RULE_funcTypeFragm = 19, 
		RULE_simpleType = 20, RULE_listSimpleTypeFragm = 21, RULE_simpleTypeFragm = 22, 
		RULE_expr = 23, RULE_letDef = 24, RULE_listLetDef = 25, RULE_expr1 = 26, 
		RULE_expr2 = 27, RULE_expr3 = 28, RULE_expr4 = 29, RULE_expr5 = 30, RULE_expr6 = 31, 
		RULE_expr7 = 32, RULE_expr8 = 33, RULE_callArg = 34, RULE_listCallArg = 35, 
		RULE_valRef = 36, RULE_listValRefFragm = 37, RULE_valRefFragm = 38, RULE_literal = 39;
	public static final String[] ruleNames = {
		"fileContents", "pkgName", "listPkgFragm", "pkgFragm", "imports", "listImport", 
		"import_", "listImportFragm", "importFragm", "defs", "listDef", "def", 
		"funcDecl", "listParam", "param", "binding", "typeDesc", "funcType", "listFuncTypeFragm", 
		"funcTypeFragm", "simpleType", "listSimpleTypeFragm", "simpleTypeFragm", 
		"expr", "letDef", "listLetDef", "expr1", "expr2", "expr3", "expr4", "expr5", 
		"expr6", "expr7", "expr8", "callArg", "listCallArg", "valRef", "listValRefFragm", 
		"valRefFragm", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'('", "')'", "':'", "'='", "','", "'->'", "'||'", "'&&'", 
		"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents result;
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
		public ImportsContext p_2_1;
		public DefsContext p_2_2;
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
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
		public PkgNameContext p_1_2;
		public ImportsContext p_1_3;
		public DefsContext p_1_4;
		public TerminalNode Surrogate_id_SYMB_28() { return getToken(FujureParser.Surrogate_id_SYMB_28, 0); }
		public PkgNameContext pkgName() {
			return getRuleContext(PkgNameContext.class,0);
		}
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
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
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(Surrogate_id_SYMB_28);
				setState(81);
				((FileInNamedPackageContext)_localctx).p_1_2 = pkgName();
				setState(82);
				((FileInNamedPackageContext)_localctx).p_1_3 = imports();
				setState(83);
				((FileInNamedPackageContext)_localctx).p_1_4 = defs();
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result,((FileInNamedPackageContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((FileInDefaultPackageContext)_localctx).p_2_1 = imports();
				setState(87);
				((FileInDefaultPackageContext)_localctx).p_2_2 = defs();
				 ((FileInDefaultPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage(((FileInDefaultPackageContext)_localctx).p_2_1.result,((FileInDefaultPackageContext)_localctx).p_2_2.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgName result;
		public PkgNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkgName; }
	 
		public PkgNameContext() { }
		public void copyFrom(PkgNameContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class PackageNameContext extends PkgNameContext {
		public ListPkgFragmContext p_1_1;
		public ListPkgFragmContext listPkgFragm() {
			return getRuleContext(ListPkgFragmContext.class,0);
		}
		public PackageNameContext(PkgNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitPackageName(this);
		}
	}

	public final PkgNameContext pkgName() throws RecognitionException {
		PkgNameContext _localctx = new PkgNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pkgName);
		try {
			_localctx = new PackageNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((PackageNameContext)_localctx).p_1_1 = listPkgFragm();
			 ((PackageNameContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageName(((PackageNameContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm result;
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
		enterRule(_localctx, 4, RULE_listPkgFragm);
		try {
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(99);
				match(Surrogate_id_SYMB_0);
				setState(100);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PkgFragm result;
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
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
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
		enterRule(_localctx, 6, RULE_pkgFragm);
		try {
			_localctx = new PackageFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((PackageFragmentContext)_localctx).p_1_1 = match(JID);
			 ((PackageFragmentContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PackageFragment(((PackageFragmentContext)_localctx).p_1_1.getText()); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Imports result;
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
	 
		public ImportsContext() { }
		public void copyFrom(ImportsContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ImportStmtsContext extends ImportsContext {
		public ListImportContext p_1_1;
		public ListImportContext listImport() {
			return getRuleContext(ListImportContext.class,0);
		}
		public ImportStmtsContext(ImportsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterImportStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitImportStmts(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_imports);
		try {
			_localctx = new ImportStmtsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((ImportStmtsContext)_localctx).p_1_1 = listImport(0);
			 ((ImportStmtsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmts(((ImportStmtsContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport result;
		public ListImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listImport; }
	 
		public ListImportContext() { }
		public void copyFrom(ListImportContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListImport_EmptyContext extends ListImportContext {
		public ListImport_EmptyContext(ListImportContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListImport_Empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListImport_Empty(this);
		}
	}
	public static class ListImport_PrependFirstContext extends ListImportContext {
		public ListImportContext p_2_1;
		public Import_Context p_2_2;
		public ListImportContext listImport() {
			return getRuleContext(ListImportContext.class,0);
		}
		public Import_Context import_() {
			return getRuleContext(Import_Context.class,0);
		}
		public ListImport_PrependFirstContext(ListImportContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListImport_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListImport_PrependFirst(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_listImport, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ListImport_EmptyContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			 ((ListImport_EmptyContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImport(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListImport_PrependFirstContext(new ListImportContext(_parentctx, _parentState));
					((ListImport_PrependFirstContext)_localctx).p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listImport);
					setState(114);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(115);
					((ListImport_PrependFirstContext)_localctx).p_2_2 = import_();
					 ((ListImport_PrependFirstContext)_localctx).result =  ((ListImport_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImport_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(122);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Import result;
		public Import_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_; }
	 
		public Import_Context() { }
		public void copyFrom(Import_Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ImportStmtContext extends Import_Context {
		public ListImportFragmContext p_1_2;
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(FujureParser.Surrogate_id_SYMB_25, 0); }
		public ListImportFragmContext listImportFragm() {
			return getRuleContext(ListImportFragmContext.class,0);
		}
		public ImportStmtContext(Import_Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterImportStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitImportStmt(this);
		}
	}

	public final Import_Context import_() throws RecognitionException {
		Import_Context _localctx = new Import_Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_import_);
		try {
			_localctx = new ImportStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(Surrogate_id_SYMB_25);
			setState(124);
			((ImportStmtContext)_localctx).p_1_2 = listImportFragm();
			 ((ImportStmtContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportStmt(((ImportStmtContext)_localctx).p_1_2.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm result;
		public ListImportFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listImportFragm; }
	 
		public ListImportFragmContext() { }
		public void copyFrom(ListImportFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListImportFragm_PrependFirstContext extends ListImportFragmContext {
		public ImportFragmContext p_2_1;
		public ListImportFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public ImportFragmContext importFragm() {
			return getRuleContext(ImportFragmContext.class,0);
		}
		public ListImportFragmContext listImportFragm() {
			return getRuleContext(ListImportFragmContext.class,0);
		}
		public ListImportFragm_PrependFirstContext(ListImportFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListImportFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListImportFragm_PrependFirst(this);
		}
	}
	public static class ListImportFragm_AppendLastContext extends ListImportFragmContext {
		public ImportFragmContext p_1_1;
		public ImportFragmContext importFragm() {
			return getRuleContext(ImportFragmContext.class,0);
		}
		public ListImportFragm_AppendLastContext(ListImportFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListImportFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListImportFragm_AppendLast(this);
		}
	}

	public final ListImportFragmContext listImportFragm() throws RecognitionException {
		ListImportFragmContext _localctx = new ListImportFragmContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listImportFragm);
		try {
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ListImportFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((ListImportFragm_AppendLastContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListImportFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_1 = importFragm();
				setState(131);
				match(Surrogate_id_SYMB_0);
				setState(132);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_3 = listImportFragm();
				 ((ListImportFragm_PrependFirstContext)_localctx).result =  ((ListImportFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListImportFragm_PrependFirstContext)_localctx).p_2_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragm result;
		public ImportFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFragm; }
	 
		public ImportFragmContext() { }
		public void copyFrom(ImportFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ImportFragmentContext extends ImportFragmContext {
		public Token p_1_1;
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ImportFragmentContext(ImportFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterImportFragment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitImportFragment(this);
		}
	}

	public final ImportFragmContext importFragm() throws RecognitionException {
		ImportFragmContext _localctx = new ImportFragmContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importFragm);
		try {
			_localctx = new ImportFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((ImportFragmentContext)_localctx).p_1_1 = match(JID);
			 ((ImportFragmentContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ImportFragment(((ImportFragmentContext)_localctx).p_1_1.getText()); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Defs result;
		public DefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defs; }
	 
		public DefsContext() { }
		public void copyFrom(DefsContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class DefListDefsContext extends DefsContext {
		public ListDefContext p_1_1;
		public ListDefContext listDef() {
			return getRuleContext(ListDefContext.class,0);
		}
		public DefListDefsContext(DefsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterDefListDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitDefListDefs(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defs);
		try {
			_localctx = new DefListDefsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((DefListDefsContext)_localctx).p_1_1 = listDef(0);
			 ((DefListDefsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DefListDefs(((DefListDefsContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef result;
		public ListDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDef; }
	 
		public ListDefContext() { }
		public void copyFrom(ListDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListDef_EmptyContext extends ListDefContext {
		public ListDef_EmptyContext(ListDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListDef_Empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListDef_Empty(this);
		}
	}
	public static class ListDef_PrependFirstContext extends ListDefContext {
		public ListDefContext p_2_1;
		public DefContext p_2_2;
		public ListDefContext listDef() {
			return getRuleContext(ListDefContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public ListDef_PrependFirstContext(ListDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListDef_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListDef_PrependFirst(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_listDef, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ListDef_EmptyContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			 ((ListDef_EmptyContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListDef(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListDef_PrependFirstContext(new ListDefContext(_parentctx, _parentState));
					((ListDef_PrependFirstContext)_localctx).p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listDef);
					setState(146);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(147);
					((ListDef_PrependFirstContext)_localctx).p_2_2 = def();
					 ((ListDef_PrependFirstContext)_localctx).result =  ((ListDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(154);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Def result;
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	 
		public DefContext() { }
		public void copyFrom(DefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class FunctionValueDefContext extends DefContext {
		public FuncDeclContext p_2_2;
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(FujureParser.Surrogate_id_SYMB_21, 0); }
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public FunctionValueDefContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFunctionValueDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFunctionValueDef(this);
		}
	}
	public static class SimpleValueDefContext extends DefContext {
		public BindingContext p_1_2;
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(FujureParser.Surrogate_id_SYMB_21, 0); }
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public SimpleValueDefContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSimpleValueDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSimpleValueDef(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_def);
		try {
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SimpleValueDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(Surrogate_id_SYMB_21);
				setState(156);
				((SimpleValueDefContext)_localctx).p_1_2 = binding();
				 ((SimpleValueDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef(((SimpleValueDefContext)_localctx).p_1_2.result); 
				}
				break;
			case 2:
				_localctx = new FunctionValueDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(Surrogate_id_SYMB_21);
				setState(160);
				((FunctionValueDefContext)_localctx).p_2_2 = funcDecl();
				 ((FunctionValueDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunctionValueDef(((FunctionValueDefContext)_localctx).p_2_2.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncDecl result;
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	 
		public FuncDeclContext() { }
		public void copyFrom(FuncDeclContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ConcreteTypelessFuncDeclContext extends FuncDeclContext {
		public Token p_3_1;
		public ListParamContext p_3_3;
		public ExprContext p_3_6;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConcreteTypelessFuncDeclContext(FuncDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterConcreteTypelessFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitConcreteTypelessFuncDecl(this);
		}
	}
	public static class AbstractTypedFuncDeclContext extends FuncDeclContext {
		public Token p_2_1;
		public ListParamContext p_2_3;
		public TypeDescContext p_2_6;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public AbstractTypedFuncDeclContext(FuncDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAbstractTypedFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAbstractTypedFuncDecl(this);
		}
	}
	public static class AbstractTypelessFuncDeclContext extends FuncDeclContext {
		public Token p_1_1;
		public ListParamContext p_1_3;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public AbstractTypelessFuncDeclContext(FuncDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAbstractTypelessFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAbstractTypelessFuncDecl(this);
		}
	}
	public static class ConcreteTypedFuncDeclContext extends FuncDeclContext {
		public Token p_4_1;
		public ListParamContext p_4_3;
		public TypeDescContext p_4_6;
		public ExprContext p_4_8;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConcreteTypedFuncDeclContext(FuncDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterConcreteTypedFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitConcreteTypedFuncDecl(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcDecl);
		try {
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AbstractTypelessFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				((AbstractTypelessFuncDeclContext)_localctx).p_1_1 = match(JID);
				setState(166);
				match(Surrogate_id_SYMB_1);
				setState(167);
				((AbstractTypelessFuncDeclContext)_localctx).p_1_3 = listParam();
				setState(168);
				match(Surrogate_id_SYMB_2);
				 ((AbstractTypelessFuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypelessFuncDecl(((AbstractTypelessFuncDeclContext)_localctx).p_1_1.getText(),((AbstractTypelessFuncDeclContext)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				_localctx = new AbstractTypedFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				((AbstractTypedFuncDeclContext)_localctx).p_2_1 = match(JID);
				setState(172);
				match(Surrogate_id_SYMB_1);
				setState(173);
				((AbstractTypedFuncDeclContext)_localctx).p_2_3 = listParam();
				setState(174);
				match(Surrogate_id_SYMB_2);
				setState(175);
				match(Surrogate_id_SYMB_3);
				setState(176);
				((AbstractTypedFuncDeclContext)_localctx).p_2_6 = typeDesc();
				 ((AbstractTypedFuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AbstractTypedFuncDecl(((AbstractTypedFuncDeclContext)_localctx).p_2_1.getText(),((AbstractTypedFuncDeclContext)_localctx).p_2_3.result,((AbstractTypedFuncDeclContext)_localctx).p_2_6.result); 
				}
				break;
			case 3:
				_localctx = new ConcreteTypelessFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				((ConcreteTypelessFuncDeclContext)_localctx).p_3_1 = match(JID);
				setState(180);
				match(Surrogate_id_SYMB_1);
				setState(181);
				((ConcreteTypelessFuncDeclContext)_localctx).p_3_3 = listParam();
				setState(182);
				match(Surrogate_id_SYMB_2);
				setState(183);
				match(Surrogate_id_SYMB_4);
				setState(184);
				((ConcreteTypelessFuncDeclContext)_localctx).p_3_6 = expr();
				 ((ConcreteTypelessFuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypelessFuncDecl(((ConcreteTypelessFuncDeclContext)_localctx).p_3_1.getText(),((ConcreteTypelessFuncDeclContext)_localctx).p_3_3.result,((ConcreteTypelessFuncDeclContext)_localctx).p_3_6.result); 
				}
				break;
			case 4:
				_localctx = new ConcreteTypedFuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				((ConcreteTypedFuncDeclContext)_localctx).p_4_1 = match(JID);
				setState(188);
				match(Surrogate_id_SYMB_1);
				setState(189);
				((ConcreteTypedFuncDeclContext)_localctx).p_4_3 = listParam();
				setState(190);
				match(Surrogate_id_SYMB_2);
				setState(191);
				match(Surrogate_id_SYMB_3);
				setState(192);
				((ConcreteTypedFuncDeclContext)_localctx).p_4_6 = typeDesc();
				setState(193);
				match(Surrogate_id_SYMB_4);
				setState(194);
				((ConcreteTypedFuncDeclContext)_localctx).p_4_8 = expr();
				 ((ConcreteTypedFuncDeclContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ConcreteTypedFuncDecl(((ConcreteTypedFuncDeclContext)_localctx).p_4_1.getText(),((ConcreteTypedFuncDeclContext)_localctx).p_4_3.result,((ConcreteTypedFuncDeclContext)_localctx).p_4_6.result,((ConcreteTypedFuncDeclContext)_localctx).p_4_8.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam result;
		public ListParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listParam; }
	 
		public ListParamContext() { }
		public void copyFrom(ListParamContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListParam_PrependFirstContext extends ListParamContext {
		public ParamContext p_3_1;
		public ListParamContext p_3_3;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ListParamContext listParam() {
			return getRuleContext(ListParamContext.class,0);
		}
		public ListParam_PrependFirstContext(ListParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListParam_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListParam_PrependFirst(this);
		}
	}
	public static class ListParam_AppendLastContext extends ListParamContext {
		public ParamContext p_2_1;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ListParam_AppendLastContext(ListParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListParam_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListParam_AppendLast(this);
		}
	}
	public static class ListParam_EmptyContext extends ListParamContext {
		public ListParam_EmptyContext(ListParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListParam_Empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListParam_Empty(this);
		}
	}

	public final ListParamContext listParam() throws RecognitionException {
		ListParamContext _localctx = new ListParamContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listParam);
		try {
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ListParam_EmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				 ((ListParam_EmptyContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam(); 
				}
				break;
			case 2:
				_localctx = new ListParam_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				((ListParam_AppendLastContext)_localctx).p_2_1 = param();
				 ((ListParam_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListParam(); _localctx.result.addLast(((ListParam_AppendLastContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				_localctx = new ListParam_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				((ListParam_PrependFirstContext)_localctx).p_3_1 = param();
				setState(204);
				match(Surrogate_id_SYMB_5);
				setState(205);
				((ListParam_PrependFirstContext)_localctx).p_3_3 = listParam();
				 ((ListParam_PrependFirstContext)_localctx).result =  ((ListParam_PrependFirstContext)_localctx).p_3_3.result; _localctx.result.addFirst(((ListParam_PrependFirstContext)_localctx).p_3_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Param result;
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class BindingParamContext extends ParamContext {
		public BindingContext p_1_1;
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public BindingParamContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterBindingParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitBindingParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param);
		try {
			_localctx = new BindingParamContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((BindingParamContext)_localctx).p_1_1 = binding();
			 ((BindingParamContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BindingParam(((BindingParamContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Binding result;
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
	 
		public BindingContext() { }
		public void copyFrom(BindingContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class NameTypeBindingContext extends BindingContext {
		public Token p_2_1;
		public TypeDescContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public NameTypeBindingContext(BindingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNameTypeBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNameTypeBinding(this);
		}
	}
	public static class NameInitBindingContext extends BindingContext {
		public Token p_3_1;
		public ExprContext p_3_3;
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NameInitBindingContext(BindingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNameInitBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNameInitBinding(this);
		}
	}
	public static class FullBindingContext extends BindingContext {
		public Token p_4_1;
		public TypeDescContext p_4_3;
		public ExprContext p_4_5;
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public TypeDescContext typeDesc() {
			return getRuleContext(TypeDescContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FullBindingContext(BindingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFullBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFullBinding(this);
		}
	}
	public static class OnlyNameBindingContext extends BindingContext {
		public Token p_1_1;
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public OnlyNameBindingContext(BindingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterOnlyNameBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitOnlyNameBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binding);
		try {
			setState(232);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new OnlyNameBindingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				((OnlyNameBindingContext)_localctx).p_1_1 = match(JID);
				 ((OnlyNameBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(((OnlyNameBindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				_localctx = new NameTypeBindingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				((NameTypeBindingContext)_localctx).p_2_1 = match(JID);
				setState(216);
				match(Surrogate_id_SYMB_3);
				setState(217);
				((NameTypeBindingContext)_localctx).p_2_3 = typeDesc();
				 ((NameTypeBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(((NameTypeBindingContext)_localctx).p_2_1.getText(),((NameTypeBindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				_localctx = new NameInitBindingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				((NameInitBindingContext)_localctx).p_3_1 = match(JID);
				setState(221);
				match(Surrogate_id_SYMB_4);
				setState(222);
				((NameInitBindingContext)_localctx).p_3_3 = expr();
				 ((NameInitBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(((NameInitBindingContext)_localctx).p_3_1.getText(),((NameInitBindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new FullBindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				((FullBindingContext)_localctx).p_4_1 = match(JID);
				setState(226);
				match(Surrogate_id_SYMB_3);
				setState(227);
				((FullBindingContext)_localctx).p_4_3 = typeDesc();
				setState(228);
				match(Surrogate_id_SYMB_4);
				setState(229);
				((FullBindingContext)_localctx).p_4_5 = expr();
				 ((FullBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FullBinding(((FullBindingContext)_localctx).p_4_1.getText(),((FullBindingContext)_localctx).p_4_3.result,((FullBindingContext)_localctx).p_4_5.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeDesc result;
		public TypeDescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDesc; }
	 
		public TypeDescContext() { }
		public void copyFrom(TypeDescContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class SimpleTypeDescContext extends TypeDescContext {
		public SimpleTypeContext p_1_1;
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public SimpleTypeDescContext(TypeDescContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSimpleTypeDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSimpleTypeDesc(this);
		}
	}
	public static class FuncTypeDescContext extends TypeDescContext {
		public FuncTypeContext p_2_1;
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public FuncTypeDescContext(TypeDescContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFuncTypeDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFuncTypeDesc(this);
		}
	}

	public final TypeDescContext typeDesc() throws RecognitionException {
		TypeDescContext _localctx = new TypeDescContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeDesc);
		try {
			setState(240);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeDescContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				((SimpleTypeDescContext)_localctx).p_1_1 = simpleType();
				 ((SimpleTypeDescContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeDesc(((SimpleTypeDescContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new FuncTypeDescContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				((FuncTypeDescContext)_localctx).p_2_1 = funcType();
				 ((FuncTypeDescContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeDesc(((FuncTypeDescContext)_localctx).p_2_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncType result;
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
	 
		public FuncTypeContext() { }
		public void copyFrom(FuncTypeContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ZeroArgFuncTypeContext extends FuncTypeContext {
		public FuncTypeFragmContext p_1_4;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public ZeroArgFuncTypeContext(FuncTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterZeroArgFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitZeroArgFuncType(this);
		}
	}
	public static class MultiArgFuncTypeContext extends FuncTypeContext {
		public FuncTypeFragmContext p_2_1;
		public ListFuncTypeFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragmContext listFuncTypeFragm() {
			return getRuleContext(ListFuncTypeFragmContext.class,0);
		}
		public MultiArgFuncTypeContext(FuncTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterMultiArgFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitMultiArgFuncType(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funcType);
		try {
			setState(253);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ZeroArgFuncTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(Surrogate_id_SYMB_1);
				setState(243);
				match(Surrogate_id_SYMB_2);
				setState(244);
				match(Surrogate_id_SYMB_6);
				setState(245);
				((ZeroArgFuncTypeContext)_localctx).p_1_4 = funcTypeFragm();
				 ((ZeroArgFuncTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ZeroArgFuncType(((ZeroArgFuncTypeContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new MultiArgFuncTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				((MultiArgFuncTypeContext)_localctx).p_2_1 = funcTypeFragm();
				setState(249);
				match(Surrogate_id_SYMB_6);
				setState(250);
				((MultiArgFuncTypeContext)_localctx).p_2_3 = listFuncTypeFragm();
				 ((MultiArgFuncTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiArgFuncType(((MultiArgFuncTypeContext)_localctx).p_2_1.result,((MultiArgFuncTypeContext)_localctx).p_2_3.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm result;
		public ListFuncTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFuncTypeFragm; }
	 
		public ListFuncTypeFragmContext() { }
		public void copyFrom(ListFuncTypeFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListFuncTypeFragm_AppendLastContext extends ListFuncTypeFragmContext {
		public FuncTypeFragmContext p_1_1;
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragm_AppendLastContext(ListFuncTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListFuncTypeFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListFuncTypeFragm_AppendLast(this);
		}
	}
	public static class ListFuncTypeFragm_PrependFirstContext extends ListFuncTypeFragmContext {
		public FuncTypeFragmContext p_2_1;
		public ListFuncTypeFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
		public FuncTypeFragmContext funcTypeFragm() {
			return getRuleContext(FuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragmContext listFuncTypeFragm() {
			return getRuleContext(ListFuncTypeFragmContext.class,0);
		}
		public ListFuncTypeFragm_PrependFirstContext(ListFuncTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListFuncTypeFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListFuncTypeFragm_PrependFirst(this);
		}
	}

	public final ListFuncTypeFragmContext listFuncTypeFragm() throws RecognitionException {
		ListFuncTypeFragmContext _localctx = new ListFuncTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listFuncTypeFragm);
		try {
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ListFuncTypeFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				((ListFuncTypeFragm_AppendLastContext)_localctx).p_1_1 = funcTypeFragm();
				 ((ListFuncTypeFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListFuncTypeFragm(); _localctx.result.addLast(((ListFuncTypeFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListFuncTypeFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				((ListFuncTypeFragm_PrependFirstContext)_localctx).p_2_1 = funcTypeFragm();
				setState(259);
				match(Surrogate_id_SYMB_6);
				setState(260);
				((ListFuncTypeFragm_PrependFirstContext)_localctx).p_2_3 = listFuncTypeFragm();
				 ((ListFuncTypeFragm_PrependFirstContext)_localctx).result =  ((ListFuncTypeFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListFuncTypeFragm_PrependFirstContext)_localctx).p_2_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncTypeFragm result;
		public FuncTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcTypeFragm; }
	 
		public FuncTypeFragmContext() { }
		public void copyFrom(FuncTypeFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class SimpleFuncTypeFragmContext extends FuncTypeFragmContext {
		public SimpleTypeContext p_1_1;
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public SimpleFuncTypeFragmContext(FuncTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSimpleFuncTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSimpleFuncTypeFragm(this);
		}
	}
	public static class FuncFuncTypeFragmContext extends FuncTypeFragmContext {
		public FuncTypeContext p_2_2;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public FuncFuncTypeFragmContext(FuncTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFuncFuncTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFuncFuncTypeFragm(this);
		}
	}

	public final FuncTypeFragmContext funcTypeFragm() throws RecognitionException {
		FuncTypeFragmContext _localctx = new FuncTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcTypeFragm);
		try {
			setState(273);
			switch (_input.LA(1)) {
			case JID:
				_localctx = new SimpleFuncTypeFragmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				((SimpleFuncTypeFragmContext)_localctx).p_1_1 = simpleType();
				 ((SimpleFuncTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleFuncTypeFragm(((SimpleFuncTypeFragmContext)_localctx).p_1_1.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
				_localctx = new FuncFuncTypeFragmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(Surrogate_id_SYMB_1);
				setState(269);
				((FuncFuncTypeFragmContext)_localctx).p_2_2 = funcType();
				setState(270);
				match(Surrogate_id_SYMB_2);
				 ((FuncFuncTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FuncFuncTypeFragm(((FuncFuncTypeFragmContext)_localctx).p_2_2.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleType result;
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
	 
		public SimpleTypeContext() { }
		public void copyFrom(SimpleTypeContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class FragmSimpleTypeContext extends SimpleTypeContext {
		public ListSimpleTypeFragmContext p_1_1;
		public ListSimpleTypeFragmContext listSimpleTypeFragm() {
			return getRuleContext(ListSimpleTypeFragmContext.class,0);
		}
		public FragmSimpleTypeContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFragmSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFragmSimpleType(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_simpleType);
		try {
			_localctx = new FragmSimpleTypeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			((FragmSimpleTypeContext)_localctx).p_1_1 = listSimpleTypeFragm();
			 ((FragmSimpleTypeContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FragmSimpleType(((FragmSimpleTypeContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm result;
		public ListSimpleTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listSimpleTypeFragm; }
	 
		public ListSimpleTypeFragmContext() { }
		public void copyFrom(ListSimpleTypeFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListSimpleTypeFragm_AppendLastContext extends ListSimpleTypeFragmContext {
		public SimpleTypeFragmContext p_1_1;
		public SimpleTypeFragmContext simpleTypeFragm() {
			return getRuleContext(SimpleTypeFragmContext.class,0);
		}
		public ListSimpleTypeFragm_AppendLastContext(ListSimpleTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListSimpleTypeFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListSimpleTypeFragm_AppendLast(this);
		}
	}
	public static class ListSimpleTypeFragm_PrependFirstContext extends ListSimpleTypeFragmContext {
		public SimpleTypeFragmContext p_2_1;
		public ListSimpleTypeFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public SimpleTypeFragmContext simpleTypeFragm() {
			return getRuleContext(SimpleTypeFragmContext.class,0);
		}
		public ListSimpleTypeFragmContext listSimpleTypeFragm() {
			return getRuleContext(ListSimpleTypeFragmContext.class,0);
		}
		public ListSimpleTypeFragm_PrependFirstContext(ListSimpleTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListSimpleTypeFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListSimpleTypeFragm_PrependFirst(this);
		}
	}

	public final ListSimpleTypeFragmContext listSimpleTypeFragm() throws RecognitionException {
		ListSimpleTypeFragmContext _localctx = new ListSimpleTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_listSimpleTypeFragm);
		try {
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ListSimpleTypeFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				((ListSimpleTypeFragm_AppendLastContext)_localctx).p_1_1 = simpleTypeFragm();
				 ((ListSimpleTypeFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListSimpleTypeFragm(); _localctx.result.addLast(((ListSimpleTypeFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListSimpleTypeFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				((ListSimpleTypeFragm_PrependFirstContext)_localctx).p_2_1 = simpleTypeFragm();
				setState(282);
				match(Surrogate_id_SYMB_0);
				setState(283);
				((ListSimpleTypeFragm_PrependFirstContext)_localctx).p_2_3 = listSimpleTypeFragm();
				 ((ListSimpleTypeFragm_PrependFirstContext)_localctx).result =  ((ListSimpleTypeFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListSimpleTypeFragm_PrependFirstContext)_localctx).p_2_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleTypeFragm result;
		public SimpleTypeFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeFragm; }
	 
		public SimpleTypeFragmContext() { }
		public void copyFrom(SimpleTypeFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class IdSimpleTypeFragmContext extends SimpleTypeFragmContext {
		public Token p_1_1;
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public IdSimpleTypeFragmContext(SimpleTypeFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterIdSimpleTypeFragm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitIdSimpleTypeFragm(this);
		}
	}

	public final SimpleTypeFragmContext simpleTypeFragm() throws RecognitionException {
		SimpleTypeFragmContext _localctx = new SimpleTypeFragmContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_simpleTypeFragm);
		try {
			_localctx = new IdSimpleTypeFragmContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			((IdSimpleTypeFragmContext)_localctx).p_1_1 = match(JID);
			 ((IdSimpleTypeFragmContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IdSimpleTypeFragm(((IdSimpleTypeFragmContext)_localctx).p_1_1.getText()); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class Coercion_ExprContext extends ExprContext {
		public Expr1Context p_3_1;
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Coercion_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr(this);
		}
	}
	public static class IfExprContext extends ExprContext {
		public ExprContext p_1_2;
		public ExprContext p_1_4;
		public ExprContext p_1_6;
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(FujureParser.Surrogate_id_SYMB_24, 0); }
		public TerminalNode Surrogate_id_SYMB_29() { return getToken(FujureParser.Surrogate_id_SYMB_29, 0); }
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(FujureParser.Surrogate_id_SYMB_22, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitIfExpr(this);
		}
	}
	public static class LetExprContext extends ExprContext {
		public ListLetDefContext p_2_2;
		public ExprContext p_2_4;
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(FujureParser.Surrogate_id_SYMB_27, 0); }
		public TerminalNode Surrogate_id_SYMB_26() { return getToken(FujureParser.Surrogate_id_SYMB_26, 0); }
		public ListLetDefContext listLetDef() {
			return getRuleContext(ListLetDefContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLetExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr);
		try {
			setState(308);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_24:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(Surrogate_id_SYMB_24);
				setState(292);
				((IfExprContext)_localctx).p_1_2 = expr();
				setState(293);
				match(Surrogate_id_SYMB_29);
				setState(294);
				((IfExprContext)_localctx).p_1_4 = expr();
				setState(295);
				match(Surrogate_id_SYMB_22);
				setState(296);
				((IfExprContext)_localctx).p_1_6 = expr();
				 ((IfExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr(((IfExprContext)_localctx).p_1_2.result,((IfExprContext)_localctx).p_1_4.result,((IfExprContext)_localctx).p_1_6.result); 
				}
				break;
			case Surrogate_id_SYMB_27:
				_localctx = new LetExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(Surrogate_id_SYMB_27);
				setState(300);
				((LetExprContext)_localctx).p_2_2 = listLetDef();
				setState(301);
				match(Surrogate_id_SYMB_26);
				setState(302);
				((LetExprContext)_localctx).p_2_4 = expr();
				 ((LetExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr(((LetExprContext)_localctx).p_2_2.result,((LetExprContext)_localctx).p_2_4.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
			case Surrogate_id_SYMB_15:
			case Surrogate_id_SYMB_16:
			case Surrogate_id_SYMB_20:
			case Surrogate_id_SYMB_23:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_31:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new Coercion_ExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				((Coercion_ExprContext)_localctx).p_3_1 = expr1(0);
				 ((Coercion_ExprContext)_localctx).result =  ((Coercion_ExprContext)_localctx).p_3_1.result; 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDef result;
		public LetDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDef; }
	 
		public LetDefContext() { }
		public void copyFrom(LetDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class LetDefinitionContext extends LetDefContext {
		public BindingContext p_1_1;
		public BindingContext binding() {
			return getRuleContext(BindingContext.class,0);
		}
		public LetDefinitionContext(LetDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLetDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLetDefinition(this);
		}
	}

	public final LetDefContext letDef() throws RecognitionException {
		LetDefContext _localctx = new LetDefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_letDef);
		try {
			_localctx = new LetDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			((LetDefinitionContext)_localctx).p_1_1 = binding();
			 ((LetDefinitionContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetDefinition(((LetDefinitionContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef result;
		public ListLetDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLetDef; }
	 
		public ListLetDefContext() { }
		public void copyFrom(ListLetDefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListLetDef_AppendLastContext extends ListLetDefContext {
		public LetDefContext p_1_1;
		public LetDefContext letDef() {
			return getRuleContext(LetDefContext.class,0);
		}
		public ListLetDef_AppendLastContext(ListLetDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListLetDef_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListLetDef_AppendLast(this);
		}
	}
	public static class ListLetDef_PrependFirstContext extends ListLetDefContext {
		public LetDefContext p_2_1;
		public ListLetDefContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
		public LetDefContext letDef() {
			return getRuleContext(LetDefContext.class,0);
		}
		public ListLetDefContext listLetDef() {
			return getRuleContext(ListLetDefContext.class,0);
		}
		public ListLetDef_PrependFirstContext(ListLetDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListLetDef_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListLetDef_PrependFirst(this);
		}
	}

	public final ListLetDefContext listLetDef() throws RecognitionException {
		ListLetDefContext _localctx = new ListLetDefContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_listLetDef);
		try {
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ListLetDef_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				((ListLetDef_AppendLastContext)_localctx).p_1_1 = letDef();
				 ((ListLetDef_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef(); _localctx.result.addLast(((ListLetDef_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListLetDef_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				((ListLetDef_PrependFirstContext)_localctx).p_2_1 = letDef();
				setState(317);
				match(Surrogate_id_SYMB_5);
				setState(318);
				((ListLetDef_PrependFirstContext)_localctx).p_2_3 = listLetDef();
				 ((ListLetDef_PrependFirstContext)_localctx).result =  ((ListLetDef_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListLetDef_PrependFirstContext)_localctx).p_2_1.result); 
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

	public static class Expr1Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class Coercion_Expr1Context extends Expr1Context {
		public Expr2Context p_2_1;
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Coercion_Expr1Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr1(this);
		}
	}
	public static class OrExprContext extends Expr1Context {
		public Expr1Context p_1_1;
		public Expr2Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(FujureParser.Surrogate_id_SYMB_7, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public OrExprContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitOrExpr(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr1Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(324);
			((Coercion_Expr1Context)_localctx).p_2_1 = expr2(0);
			 ((Coercion_Expr1Context)_localctx).result =  ((Coercion_Expr1Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(new Expr1Context(_parentctx, _parentState));
					((OrExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(327);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(328);
					match(Surrogate_id_SYMB_7);
					setState(329);
					((OrExprContext)_localctx).p_1_3 = expr2(0);
					 ((OrExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr(((OrExprContext)_localctx).p_1_1.result,((OrExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
	 
		public Expr2Context() { }
		public void copyFrom(Expr2Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class AndExprContext extends Expr2Context {
		public Expr2Context p_1_1;
		public Expr3Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(FujureParser.Surrogate_id_SYMB_8, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public AndExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAndExpr(this);
		}
	}
	public static class Coercion_Expr2Context extends Expr2Context {
		public Expr3Context p_2_1;
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Coercion_Expr2Context(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr2(this);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(338);
			((Coercion_Expr2Context)_localctx).p_2_1 = expr3(0);
			 ((Coercion_Expr2Context)_localctx).result =  ((Coercion_Expr2Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(new Expr2Context(_parentctx, _parentState));
					((AndExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(341);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(342);
					match(Surrogate_id_SYMB_8);
					setState(343);
					((AndExprContext)_localctx).p_1_3 = expr3(0);
					 ((AndExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr(((AndExprContext)_localctx).p_1_1.result,((AndExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	 
		public Expr3Context() { }
		public void copyFrom(Expr3Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class EqualityExprContext extends Expr3Context {
		public Expr3Context p_1_1;
		public Expr4Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(FujureParser.Surrogate_id_SYMB_9, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public EqualityExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitEqualityExpr(this);
		}
	}
	public static class InequalityExprContext extends Expr3Context {
		public Expr3Context p_2_1;
		public Expr4Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(FujureParser.Surrogate_id_SYMB_10, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public InequalityExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterInequalityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitInequalityExpr(this);
		}
	}
	public static class Coercion_Expr3Context extends Expr3Context {
		public Expr4Context p_3_1;
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Coercion_Expr3Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr3(this);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expr3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr3Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(352);
			((Coercion_Expr3Context)_localctx).p_3_1 = expr4(0);
			 ((Coercion_Expr3Context)_localctx).result =  ((Coercion_Expr3Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(365);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExprContext(new Expr3Context(_parentctx, _parentState));
						((EqualityExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(355);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(356);
						match(Surrogate_id_SYMB_9);
						setState(357);
						((EqualityExprContext)_localctx).p_1_3 = expr4(0);
						 ((EqualityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr(((EqualityExprContext)_localctx).p_1_1.result,((EqualityExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new InequalityExprContext(new Expr3Context(_parentctx, _parentState));
						((InequalityExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361);
						match(Surrogate_id_SYMB_10);
						setState(362);
						((InequalityExprContext)_localctx).p_2_3 = expr4(0);
						 ((InequalityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr(((InequalityExprContext)_localctx).p_2_1.result,((InequalityExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(369);
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

	public static class Expr4Context extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr4; }
	 
		public Expr4Context() { }
		public void copyFrom(Expr4Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class LesserEqualExprContext extends Expr4Context {
		public Expr4Context p_2_1;
		public Expr5Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(FujureParser.Surrogate_id_SYMB_12, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public LesserEqualExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserEqualExpr(this);
		}
	}
	public static class GreaterExprContext extends Expr4Context {
		public Expr4Context p_3_1;
		public Expr5Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(FujureParser.Surrogate_id_SYMB_13, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public GreaterExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterExpr(this);
		}
	}
	public static class LesserExprContext extends Expr4Context {
		public Expr4Context p_1_1;
		public Expr5Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(FujureParser.Surrogate_id_SYMB_11, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public LesserExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserExpr(this);
		}
	}
	public static class GreaterEqualExprContext extends Expr4Context {
		public Expr4Context p_4_1;
		public Expr5Context p_4_3;
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(FujureParser.Surrogate_id_SYMB_14, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public GreaterEqualExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterEqualExpr(this);
		}
	}
	public static class Coercion_Expr4Context extends Expr4Context {
		public Expr5Context p_5_1;
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Coercion_Expr4Context(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr4(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr4Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(371);
			((Coercion_Expr4Context)_localctx).p_5_1 = expr5(0);
			 ((Coercion_Expr4Context)_localctx).result =  ((Coercion_Expr4Context)_localctx).p_5_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(394);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new LesserExprContext(new Expr4Context(_parentctx, _parentState));
						((LesserExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(374);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(375);
						match(Surrogate_id_SYMB_11);
						setState(376);
						((LesserExprContext)_localctx).p_1_3 = expr5(0);
						 ((LesserExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr(((LesserExprContext)_localctx).p_1_1.result,((LesserExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new LesserEqualExprContext(new Expr4Context(_parentctx, _parentState));
						((LesserEqualExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(379);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(380);
						match(Surrogate_id_SYMB_12);
						setState(381);
						((LesserEqualExprContext)_localctx).p_2_3 = expr5(0);
						 ((LesserEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr(((LesserEqualExprContext)_localctx).p_2_1.result,((LesserEqualExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new GreaterExprContext(new Expr4Context(_parentctx, _parentState));
						((GreaterExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(384);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(385);
						match(Surrogate_id_SYMB_13);
						setState(386);
						((GreaterExprContext)_localctx).p_3_3 = expr5(0);
						 ((GreaterExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr(((GreaterExprContext)_localctx).p_3_1.result,((GreaterExprContext)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new GreaterEqualExprContext(new Expr4Context(_parentctx, _parentState));
						((GreaterEqualExprContext)_localctx).p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(389);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(390);
						match(Surrogate_id_SYMB_14);
						setState(391);
						((GreaterEqualExprContext)_localctx).p_4_3 = expr5(0);
						 ((GreaterEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr(((GreaterEqualExprContext)_localctx).p_4_1.result,((GreaterEqualExprContext)_localctx).p_4_3.result); 
						}
						break;
					}
					} 
				}
				setState(398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr5; }
	 
		public Expr5Context() { }
		public void copyFrom(Expr5Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class AdditionExprContext extends Expr5Context {
		public Expr5Context p_1_1;
		public Expr6Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(FujureParser.Surrogate_id_SYMB_15, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public AdditionExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAdditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAdditionExpr(this);
		}
	}
	public static class SubtractionExprContext extends Expr5Context {
		public Expr5Context p_2_1;
		public Expr6Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(FujureParser.Surrogate_id_SYMB_16, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public SubtractionExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSubtractionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSubtractionExpr(this);
		}
	}
	public static class Coercion_Expr5Context extends Expr5Context {
		public Expr6Context p_3_1;
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public Coercion_Expr5Context(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr5(this);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr5Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(400);
			((Coercion_Expr5Context)_localctx).p_3_1 = expr6(0);
			 ((Coercion_Expr5Context)_localctx).result =  ((Coercion_Expr5Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(413);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionExprContext(new Expr5Context(_parentctx, _parentState));
						((AdditionExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(403);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(404);
						match(Surrogate_id_SYMB_15);
						setState(405);
						((AdditionExprContext)_localctx).p_1_3 = expr6(0);
						 ((AdditionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr(((AdditionExprContext)_localctx).p_1_1.result,((AdditionExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new SubtractionExprContext(new Expr5Context(_parentctx, _parentState));
						((SubtractionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(408);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(409);
						match(Surrogate_id_SYMB_16);
						setState(410);
						((SubtractionExprContext)_localctx).p_2_3 = expr6(0);
						 ((SubtractionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr(((SubtractionExprContext)_localctx).p_2_1.result,((SubtractionExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr6; }
	 
		public Expr6Context() { }
		public void copyFrom(Expr6Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ModuloExprContext extends Expr6Context {
		public Expr6Context p_3_1;
		public Expr7Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(FujureParser.Surrogate_id_SYMB_19, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public ModuloExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterModuloExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitModuloExpr(this);
		}
	}
	public static class Coercion_Expr6Context extends Expr6Context {
		public Expr7Context p_4_1;
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Coercion_Expr6Context(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr6(this);
		}
	}
	public static class DivisionExprContext extends Expr6Context {
		public Expr6Context p_2_1;
		public Expr7Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(FujureParser.Surrogate_id_SYMB_18, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public DivisionExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterDivisionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitDivisionExpr(this);
		}
	}
	public static class MultiplicationExprContext extends Expr6Context {
		public Expr6Context p_1_1;
		public Expr7Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(FujureParser.Surrogate_id_SYMB_17, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public MultiplicationExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitMultiplicationExpr(this);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expr6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr6Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(419);
			((Coercion_Expr6Context)_localctx).p_4_1 = expr7();
			 ((Coercion_Expr6Context)_localctx).result =  ((Coercion_Expr6Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(437);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new Expr6Context(_parentctx, _parentState));
						((MultiplicationExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(422);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(423);
						match(Surrogate_id_SYMB_17);
						setState(424);
						((MultiplicationExprContext)_localctx).p_1_3 = expr7();
						 ((MultiplicationExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr(((MultiplicationExprContext)_localctx).p_1_1.result,((MultiplicationExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new DivisionExprContext(new Expr6Context(_parentctx, _parentState));
						((DivisionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(427);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(428);
						match(Surrogate_id_SYMB_18);
						setState(429);
						((DivisionExprContext)_localctx).p_2_3 = expr7();
						 ((DivisionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr(((DivisionExprContext)_localctx).p_2_1.result,((DivisionExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new ModuloExprContext(new Expr6Context(_parentctx, _parentState));
						((ModuloExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(432);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(433);
						match(Surrogate_id_SYMB_19);
						setState(434);
						((ModuloExprContext)_localctx).p_3_3 = expr7();
						 ((ModuloExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr(((ModuloExprContext)_localctx).p_3_1.result,((ModuloExprContext)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr7; }
	 
		public Expr7Context() { }
		public void copyFrom(Expr7Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class Coercion_Expr7Context extends Expr7Context {
		public Expr8Context p_4_1;
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public Coercion_Expr7Context(Expr7Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr7(this);
		}
	}
	public static class NotExprContext extends Expr7Context {
		public Expr8Context p_1_2;
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(FujureParser.Surrogate_id_SYMB_20, 0); }
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public NotExprContext(Expr7Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNotExpr(this);
		}
	}
	public static class PositateExprContext extends Expr7Context {
		public Expr8Context p_3_2;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(FujureParser.Surrogate_id_SYMB_15, 0); }
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public PositateExprContext(Expr7Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterPositateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitPositateExpr(this);
		}
	}
	public static class NegateExprContext extends Expr7Context {
		public Expr8Context p_2_2;
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(FujureParser.Surrogate_id_SYMB_16, 0); }
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public NegateExprContext(Expr7Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNegateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNegateExpr(this);
		}
	}

	public final Expr7Context expr7() throws RecognitionException {
		Expr7Context _localctx = new Expr7Context(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr7);
		try {
			setState(457);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_20:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				match(Surrogate_id_SYMB_20);
				setState(443);
				((NotExprContext)_localctx).p_1_2 = expr8();
				 ((NotExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr(((NotExprContext)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_16:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
				match(Surrogate_id_SYMB_16);
				setState(447);
				((NegateExprContext)_localctx).p_2_2 = expr8();
				 ((NegateExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr(((NegateExprContext)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_15:
				_localctx = new PositateExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(Surrogate_id_SYMB_15);
				setState(451);
				((PositateExprContext)_localctx).p_3_2 = expr8();
				 ((PositateExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr(((PositateExprContext)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_1:
			case Surrogate_id_SYMB_23:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_31:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new Coercion_Expr7Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(454);
				((Coercion_Expr7Context)_localctx).p_4_1 = expr8();
				 ((Coercion_Expr7Context)_localctx).result =  ((Coercion_Expr7Context)_localctx).p_4_1.result; 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Expr result;
		public Expr8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr8; }
	 
		public Expr8Context() { }
		public void copyFrom(Expr8Context ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class Coercion_Expr8Context extends Expr8Context {
		public ExprContext p_4_2;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Coercion_Expr8Context(Expr8Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCoercion_Expr8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCoercion_Expr8(this);
		}
	}
	public static class FunCallExprContext extends Expr8Context {
		public ValRefContext p_3_1;
		public ListCallArgContext p_3_3;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public ValRefContext valRef() {
			return getRuleContext(ValRefContext.class,0);
		}
		public ListCallArgContext listCallArg() {
			return getRuleContext(ListCallArgContext.class,0);
		}
		public FunCallExprContext(Expr8Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterFunCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitFunCallExpr(this);
		}
	}
	public static class LiteralExprContext extends Expr8Context {
		public LiteralContext p_1_1;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(Expr8Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLiteralExpr(this);
		}
	}
	public static class VariableExprContext extends Expr8Context {
		public ValRefContext p_2_1;
		public ValRefContext valRef() {
			return getRuleContext(ValRefContext.class,0);
		}
		public VariableExprContext(Expr8Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitVariableExpr(this);
		}
	}

	public final Expr8Context expr8() throws RecognitionException {
		Expr8Context _localctx = new Expr8Context(_ctx, getState());
		enterRule(_localctx, 66, RULE_expr8);
		try {
			setState(476);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				((LiteralExprContext)_localctx).p_1_1 = literal();
				 ((LiteralExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(((LiteralExprContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				((VariableExprContext)_localctx).p_2_1 = valRef();
				 ((VariableExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(((VariableExprContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				_localctx = new FunCallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(465);
				((FunCallExprContext)_localctx).p_3_1 = valRef();
				setState(466);
				match(Surrogate_id_SYMB_1);
				setState(467);
				((FunCallExprContext)_localctx).p_3_3 = listCallArg();
				setState(468);
				match(Surrogate_id_SYMB_2);
				 ((FunCallExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunCallExpr(((FunCallExprContext)_localctx).p_3_1.result,((FunCallExprContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new Coercion_Expr8Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(471);
				match(Surrogate_id_SYMB_1);
				setState(472);
				((Coercion_Expr8Context)_localctx).p_4_2 = expr();
				setState(473);
				match(Surrogate_id_SYMB_2);
				 ((Coercion_Expr8Context)_localctx).result =  ((Coercion_Expr8Context)_localctx).p_4_2.result; 
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

	public static class CallArgContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CallArg result;
		public CallArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArg; }
	 
		public CallArgContext() { }
		public void copyFrom(CallArgContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ExprCallArgContext extends CallArgContext {
		public ExprContext p_1_1;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprCallArgContext(CallArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterExprCallArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitExprCallArg(this);
		}
	}

	public final CallArgContext callArg() throws RecognitionException {
		CallArgContext _localctx = new CallArgContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_callArg);
		try {
			_localctx = new ExprCallArgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			((ExprCallArgContext)_localctx).p_1_1 = expr();
			 ((ExprCallArgContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ExprCallArg(((ExprCallArgContext)_localctx).p_1_1.result); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg result;
		public ListCallArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCallArg; }
	 
		public ListCallArgContext() { }
		public void copyFrom(ListCallArgContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListCallArg_AppendLastContext extends ListCallArgContext {
		public CallArgContext p_2_1;
		public CallArgContext callArg() {
			return getRuleContext(CallArgContext.class,0);
		}
		public ListCallArg_AppendLastContext(ListCallArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListCallArg_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListCallArg_AppendLast(this);
		}
	}
	public static class ListCallArg_PrependFirstContext extends ListCallArgContext {
		public CallArgContext p_3_1;
		public ListCallArgContext p_3_3;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
		public CallArgContext callArg() {
			return getRuleContext(CallArgContext.class,0);
		}
		public ListCallArgContext listCallArg() {
			return getRuleContext(ListCallArgContext.class,0);
		}
		public ListCallArg_PrependFirstContext(ListCallArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListCallArg_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListCallArg_PrependFirst(this);
		}
	}
	public static class ListCallArg_EmptyContext extends ListCallArgContext {
		public ListCallArg_EmptyContext(ListCallArgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListCallArg_Empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListCallArg_Empty(this);
		}
	}

	public final ListCallArgContext listCallArg() throws RecognitionException {
		ListCallArgContext _localctx = new ListCallArgContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_listCallArg);
		try {
			setState(490);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ListCallArg_EmptyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				 ((ListCallArg_EmptyContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg(); 
				}
				break;
			case 2:
				_localctx = new ListCallArg_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				((ListCallArg_AppendLastContext)_localctx).p_2_1 = callArg();
				 ((ListCallArg_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg(); _localctx.result.addLast(((ListCallArg_AppendLastContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				_localctx = new ListCallArg_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(485);
				((ListCallArg_PrependFirstContext)_localctx).p_3_1 = callArg();
				setState(486);
				match(Surrogate_id_SYMB_5);
				setState(487);
				((ListCallArg_PrependFirstContext)_localctx).p_3_3 = listCallArg();
				 ((ListCallArg_PrependFirstContext)_localctx).result =  ((ListCallArg_PrependFirstContext)_localctx).p_3_3.result; _localctx.result.addFirst(((ListCallArg_PrependFirstContext)_localctx).p_3_1.result); 
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

	public static class ValRefContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRef result;
		public ValRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valRef; }
	 
		public ValRefContext() { }
		public void copyFrom(ValRefContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ValueRefContext extends ValRefContext {
		public ListValRefFragmContext p_1_1;
		public ListValRefFragmContext listValRefFragm() {
			return getRuleContext(ListValRefFragmContext.class,0);
		}
		public ValueRefContext(ValRefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterValueRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitValueRef(this);
		}
	}

	public final ValRefContext valRef() throws RecognitionException {
		ValRefContext _localctx = new ValRefContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_valRef);
		try {
			_localctx = new ValueRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			((ValueRefContext)_localctx).p_1_1 = listValRefFragm();
			 ((ValueRefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRef(((ValueRefContext)_localctx).p_1_1.result); 
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

	public static class ListValRefFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm result;
		public ListValRefFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValRefFragm; }
	 
		public ListValRefFragmContext() { }
		public void copyFrom(ListValRefFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListValRefFragm_PrependFirstContext extends ListValRefFragmContext {
		public ValRefFragmContext p_2_1;
		public ListValRefFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public ValRefFragmContext valRefFragm() {
			return getRuleContext(ValRefFragmContext.class,0);
		}
		public ListValRefFragmContext listValRefFragm() {
			return getRuleContext(ListValRefFragmContext.class,0);
		}
		public ListValRefFragm_PrependFirstContext(ListValRefFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListValRefFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListValRefFragm_PrependFirst(this);
		}
	}
	public static class ListValRefFragm_AppendLastContext extends ListValRefFragmContext {
		public ValRefFragmContext p_1_1;
		public ValRefFragmContext valRefFragm() {
			return getRuleContext(ValRefFragmContext.class,0);
		}
		public ListValRefFragm_AppendLastContext(ListValRefFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListValRefFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListValRefFragm_AppendLast(this);
		}
	}

	public final ListValRefFragmContext listValRefFragm() throws RecognitionException {
		ListValRefFragmContext _localctx = new ListValRefFragmContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_listValRefFragm);
		try {
			setState(503);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new ListValRefFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				((ListValRefFragm_AppendLastContext)_localctx).p_1_1 = valRefFragm();
				 ((ListValRefFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); _localctx.result.addLast(((ListValRefFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListValRefFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(498);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_1 = valRefFragm();
				setState(499);
				match(Surrogate_id_SYMB_0);
				setState(500);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_3 = listValRefFragm();
				 ((ListValRefFragm_PrependFirstContext)_localctx).result =  ((ListValRefFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListValRefFragm_PrependFirstContext)_localctx).p_2_1.result); 
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

	public static class ValRefFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValRefFragm result;
		public ValRefFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valRefFragm; }
	 
		public ValRefFragmContext() { }
		public void copyFrom(ValRefFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ValueRefFragmentContext extends ValRefFragmContext {
		public Token p_1_1;
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public ValueRefFragmentContext(ValRefFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterValueRefFragment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitValueRefFragment(this);
		}
	}

	public final ValRefFragmContext valRefFragm() throws RecognitionException {
		ValRefFragmContext _localctx = new ValRefFragmContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_valRefFragm);
		try {
			_localctx = new ValueRefFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			((ValueRefFragmentContext)_localctx).p_1_1 = match(JID);
			 ((ValueRefFragmentContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ValueRefFragment(((ValueRefFragmentContext)_localctx).p_1_1.getText()); 
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
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Literal result;
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class CharLiteralContext extends LiteralContext {
		public Token p_5_1;
		public TerminalNode JCHAR() { return getToken(FujureParser.JCHAR, 0); }
		public CharLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitCharLiteral(this);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public Token p_6_1;
		public TerminalNode JSTRING() { return getToken(FujureParser.JSTRING, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitStringLiteral(this);
		}
	}
	public static class BoolTrueLiteralContext extends LiteralContext {
		public TerminalNode Surrogate_id_SYMB_30() { return getToken(FujureParser.Surrogate_id_SYMB_30, 0); }
		public BoolTrueLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterBoolTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitBoolTrueLiteral(this);
		}
	}
	public static class BoolFalseLiteralContext extends LiteralContext {
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(FujureParser.Surrogate_id_SYMB_23, 0); }
		public BoolFalseLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterBoolFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitBoolFalseLiteral(this);
		}
	}
	public static class IntLiteralContext extends LiteralContext {
		public Token p_1_1;
		public TerminalNode INTEGER() { return getToken(FujureParser.INTEGER, 0); }
		public IntLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitIntLiteral(this);
		}
	}
	public static class UnitLiteralContext extends LiteralContext {
		public TerminalNode Surrogate_id_SYMB_31() { return getToken(FujureParser.Surrogate_id_SYMB_31, 0); }
		public UnitLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterUnitLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitUnitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_literal);
		try {
			setState(520);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				((IntLiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((IntLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt(((IntLiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_31:
				_localctx = new UnitLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				match(Surrogate_id_SYMB_31);
				 ((UnitLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_30:
				_localctx = new BoolTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(512);
				match(Surrogate_id_SYMB_30);
				 ((BoolTrueLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_23:
				_localctx = new BoolFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(514);
				match(Surrogate_id_SYMB_23);
				 ((BoolFalseLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(516);
				((CharLiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((CharLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(((CharLiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
				((StringLiteralContext)_localctx).p_6_1 = match(JSTRING);
				 ((StringLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.StringLiteral(((StringLiteralContext)_localctx).p_6_1.getText()); 
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
		case 5:
			return listImport_sempred((ListImportContext)_localctx, predIndex);
		case 10:
			return listDef_sempred((ListDefContext)_localctx, predIndex);
		case 26:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 27:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 28:
			return expr3_sempred((Expr3Context)_localctx, predIndex);
		case 29:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 30:
			return expr5_sempred((Expr5Context)_localctx, predIndex);
		case 31:
			return expr6_sempred((Expr6Context)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u020d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2]\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4j\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7y\n\7\f\7\16\7|\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u008a\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00a6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c8\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00d3\n\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00eb\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f3\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0100"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u010a\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0114\n\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0121\n\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0137\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u0144\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34"+
		"\u014f\n\34\f\34\16\34\u0152\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\7\35\u015d\n\35\f\35\16\35\u0160\13\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0170\n\36\f\36"+
		"\16\36\u0173\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7"+
		"\37\u018d\n\37\f\37\16\37\u0190\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \7 \u01a0\n \f \16 \u01a3\13 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u01b8\n!\f!\16!\u01bb\13!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01cc\n\"\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01df\n#\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\5%\u01ed\n%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\5\'\u01fa\n\'\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u020b"+
		"\n)\3)\2\n\f\26\668:<>@*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNP\2\2\u0215\2\\\3\2\2\2\4^\3\2\2\2\6i\3\2\2"+
		"\2\bk\3\2\2\2\nn\3\2\2\2\fq\3\2\2\2\16}\3\2\2\2\20\u0089\3\2\2\2\22\u008b"+
		"\3\2\2\2\24\u008e\3\2\2\2\26\u0091\3\2\2\2\30\u00a5\3\2\2\2\32\u00c7\3"+
		"\2\2\2\34\u00d2\3\2\2\2\36\u00d4\3\2\2\2 \u00ea\3\2\2\2\"\u00f2\3\2\2"+
		"\2$\u00ff\3\2\2\2&\u0109\3\2\2\2(\u0113\3\2\2\2*\u0115\3\2\2\2,\u0120"+
		"\3\2\2\2.\u0122\3\2\2\2\60\u0136\3\2\2\2\62\u0138\3\2\2\2\64\u0143\3\2"+
		"\2\2\66\u0145\3\2\2\28\u0153\3\2\2\2:\u0161\3\2\2\2<\u0174\3\2\2\2>\u0191"+
		"\3\2\2\2@\u01a4\3\2\2\2B\u01cb\3\2\2\2D\u01de\3\2\2\2F\u01e0\3\2\2\2H"+
		"\u01ec\3\2\2\2J\u01ee\3\2\2\2L\u01f9\3\2\2\2N\u01fb\3\2\2\2P\u020a\3\2"+
		"\2\2RS\7\37\2\2ST\5\4\3\2TU\5\n\6\2UV\5\24\13\2VW\b\2\1\2W]\3\2\2\2XY"+
		"\5\n\6\2YZ\5\24\13\2Z[\b\2\1\2[]\3\2\2\2\\R\3\2\2\2\\X\3\2\2\2]\3\3\2"+
		"\2\2^_\5\6\4\2_`\b\3\1\2`\5\3\2\2\2ab\5\b\5\2bc\b\4\1\2cj\3\2\2\2de\5"+
		"\b\5\2ef\7\3\2\2fg\5\6\4\2gh\b\4\1\2hj\3\2\2\2ia\3\2\2\2id\3\2\2\2j\7"+
		"\3\2\2\2kl\7#\2\2lm\b\5\1\2m\t\3\2\2\2no\5\f\7\2op\b\6\1\2p\13\3\2\2\2"+
		"qr\b\7\1\2rs\b\7\1\2sz\3\2\2\2tu\f\3\2\2uv\5\16\b\2vw\b\7\1\2wy\3\2\2"+
		"\2xt\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\r\3\2\2\2|z\3\2\2\2}~\7\34"+
		"\2\2~\177\5\20\t\2\177\u0080\b\b\1\2\u0080\17\3\2\2\2\u0081\u0082\5\22"+
		"\n\2\u0082\u0083\b\t\1\2\u0083\u008a\3\2\2\2\u0084\u0085\5\22\n\2\u0085"+
		"\u0086\7\3\2\2\u0086\u0087\5\20\t\2\u0087\u0088\b\t\1\2\u0088\u008a\3"+
		"\2\2\2\u0089\u0081\3\2\2\2\u0089\u0084\3\2\2\2\u008a\21\3\2\2\2\u008b"+
		"\u008c\7#\2\2\u008c\u008d\b\n\1\2\u008d\23\3\2\2\2\u008e\u008f\5\26\f"+
		"\2\u008f\u0090\b\13\1\2\u0090\25\3\2\2\2\u0091\u0092\b\f\1\2\u0092\u0093"+
		"\b\f\1\2\u0093\u009a\3\2\2\2\u0094\u0095\f\3\2\2\u0095\u0096\5\30\r\2"+
		"\u0096\u0097\b\f\1\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\27\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7\30\2\2\u009e\u009f\5 \21\2\u009f\u00a0\b"+
		"\r\1\2\u00a0\u00a6\3\2\2\2\u00a1\u00a2\7\30\2\2\u00a2\u00a3\5\32\16\2"+
		"\u00a3\u00a4\b\r\1\2\u00a4\u00a6\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a1"+
		"\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a8\7#\2\2\u00a8\u00a9\7\4\2\2\u00a9"+
		"\u00aa\5\34\17\2\u00aa\u00ab\7\5\2\2\u00ab\u00ac\b\16\1\2\u00ac\u00c8"+
		"\3\2\2\2\u00ad\u00ae\7#\2\2\u00ae\u00af\7\4\2\2\u00af\u00b0\5\34\17\2"+
		"\u00b0\u00b1\7\5\2\2\u00b1\u00b2\7\6\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4"+
		"\b\16\1\2\u00b4\u00c8\3\2\2\2\u00b5\u00b6\7#\2\2\u00b6\u00b7\7\4\2\2\u00b7"+
		"\u00b8\5\34\17\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\7\7\2\2\u00ba\u00bb\5"+
		"\60\31\2\u00bb\u00bc\b\16\1\2\u00bc\u00c8\3\2\2\2\u00bd\u00be\7#\2\2\u00be"+
		"\u00bf\7\4\2\2\u00bf\u00c0\5\34\17\2\u00c0\u00c1\7\5\2\2\u00c1\u00c2\7"+
		"\6\2\2\u00c2\u00c3\5\"\22\2\u00c3\u00c4\7\7\2\2\u00c4\u00c5\5\60\31\2"+
		"\u00c5\u00c6\b\16\1\2\u00c6\u00c8\3\2\2\2\u00c7\u00a7\3\2\2\2\u00c7\u00ad"+
		"\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00bd\3\2\2\2\u00c8\33\3\2\2\2\u00c9"+
		"\u00d3\b\17\1\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc\b\17\1\2\u00cc\u00d3"+
		"\3\2\2\2\u00cd\u00ce\5\36\20\2\u00ce\u00cf\7\b\2\2\u00cf\u00d0\5\34\17"+
		"\2\u00d0\u00d1\b\17\1\2\u00d1\u00d3\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2"+
		"\u00ca\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d3\35\3\2\2\2\u00d4\u00d5\5 \21"+
		"\2\u00d5\u00d6\b\20\1\2\u00d6\37\3\2\2\2\u00d7\u00d8\7#\2\2\u00d8\u00eb"+
		"\b\21\1\2\u00d9\u00da\7#\2\2\u00da\u00db\7\6\2\2\u00db\u00dc\5\"\22\2"+
		"\u00dc\u00dd\b\21\1\2\u00dd\u00eb\3\2\2\2\u00de\u00df\7#\2\2\u00df\u00e0"+
		"\7\7\2\2\u00e0\u00e1\5\60\31\2\u00e1\u00e2\b\21\1\2\u00e2\u00eb\3\2\2"+
		"\2\u00e3\u00e4\7#\2\2\u00e4\u00e5\7\6\2\2\u00e5\u00e6\5\"\22\2\u00e6\u00e7"+
		"\7\7\2\2\u00e7\u00e8\5\60\31\2\u00e8\u00e9\b\21\1\2\u00e9\u00eb\3\2\2"+
		"\2\u00ea\u00d7\3\2\2\2\u00ea\u00d9\3\2\2\2\u00ea\u00de\3\2\2\2\u00ea\u00e3"+
		"\3\2\2\2\u00eb!\3\2\2\2\u00ec\u00ed\5*\26\2\u00ed\u00ee\b\22\1\2\u00ee"+
		"\u00f3\3\2\2\2\u00ef\u00f0\5$\23\2\u00f0\u00f1\b\22\1\2\u00f1\u00f3\3"+
		"\2\2\2\u00f2\u00ec\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3#\3\2\2\2\u00f4\u00f5"+
		"\7\4\2\2\u00f5\u00f6\7\5\2\2\u00f6\u00f7\7\t\2\2\u00f7\u00f8\5(\25\2\u00f8"+
		"\u00f9\b\23\1\2\u00f9\u0100\3\2\2\2\u00fa\u00fb\5(\25\2\u00fb\u00fc\7"+
		"\t\2\2\u00fc\u00fd\5&\24\2\u00fd\u00fe\b\23\1\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00f4\3\2\2\2\u00ff\u00fa\3\2\2\2\u0100%\3\2\2\2\u0101\u0102\5(\25\2"+
		"\u0102\u0103\b\24\1\2\u0103\u010a\3\2\2\2\u0104\u0105\5(\25\2\u0105\u0106"+
		"\7\t\2\2\u0106\u0107\5&\24\2\u0107\u0108\b\24\1\2\u0108\u010a\3\2\2\2"+
		"\u0109\u0101\3\2\2\2\u0109\u0104\3\2\2\2\u010a\'\3\2\2\2\u010b\u010c\5"+
		"*\26\2\u010c\u010d\b\25\1\2\u010d\u0114\3\2\2\2\u010e\u010f\7\4\2\2\u010f"+
		"\u0110\5$\23\2\u0110\u0111\7\5\2\2\u0111\u0112\b\25\1\2\u0112\u0114\3"+
		"\2\2\2\u0113\u010b\3\2\2\2\u0113\u010e\3\2\2\2\u0114)\3\2\2\2\u0115\u0116"+
		"\5,\27\2\u0116\u0117\b\26\1\2\u0117+\3\2\2\2\u0118\u0119\5.\30\2\u0119"+
		"\u011a\b\27\1\2\u011a\u0121\3\2\2\2\u011b\u011c\5.\30\2\u011c\u011d\7"+
		"\3\2\2\u011d\u011e\5,\27\2\u011e\u011f\b\27\1\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0118\3\2\2\2\u0120\u011b\3\2\2\2\u0121-\3\2\2\2\u0122\u0123\7#\2\2\u0123"+
		"\u0124\b\30\1\2\u0124/\3\2\2\2\u0125\u0126\7\33\2\2\u0126\u0127\5\60\31"+
		"\2\u0127\u0128\7 \2\2\u0128\u0129\5\60\31\2\u0129\u012a\7\31\2\2\u012a"+
		"\u012b\5\60\31\2\u012b\u012c\b\31\1\2\u012c\u0137\3\2\2\2\u012d\u012e"+
		"\7\36\2\2\u012e\u012f\5\64\33\2\u012f\u0130\7\35\2\2\u0130\u0131\5\60"+
		"\31\2\u0131\u0132\b\31\1\2\u0132\u0137\3\2\2\2\u0133\u0134\5\66\34\2\u0134"+
		"\u0135\b\31\1\2\u0135\u0137\3\2\2\2\u0136\u0125\3\2\2\2\u0136\u012d\3"+
		"\2\2\2\u0136\u0133\3\2\2\2\u0137\61\3\2\2\2\u0138\u0139\5 \21\2\u0139"+
		"\u013a\b\32\1\2\u013a\63\3\2\2\2\u013b\u013c\5\62\32\2\u013c\u013d\b\33"+
		"\1\2\u013d\u0144\3\2\2\2\u013e\u013f\5\62\32\2\u013f\u0140\7\b\2\2\u0140"+
		"\u0141\5\64\33\2\u0141\u0142\b\33\1\2\u0142\u0144\3\2\2\2\u0143\u013b"+
		"\3\2\2\2\u0143\u013e\3\2\2\2\u0144\65\3\2\2\2\u0145\u0146\b\34\1\2\u0146"+
		"\u0147\58\35\2\u0147\u0148\b\34\1\2\u0148\u0150\3\2\2\2\u0149\u014a\f"+
		"\4\2\2\u014a\u014b\7\n\2\2\u014b\u014c\58\35\2\u014c\u014d\b\34\1\2\u014d"+
		"\u014f\3\2\2\2\u014e\u0149\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\67\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154"+
		"\b\35\1\2\u0154\u0155\5:\36\2\u0155\u0156\b\35\1\2\u0156\u015e\3\2\2\2"+
		"\u0157\u0158\f\4\2\2\u0158\u0159\7\13\2\2\u0159\u015a\5:\36\2\u015a\u015b"+
		"\b\35\1\2\u015b\u015d\3\2\2\2\u015c\u0157\3\2\2\2\u015d\u0160\3\2\2\2"+
		"\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f9\3\2\2\2\u0160\u015e\3"+
		"\2\2\2\u0161\u0162\b\36\1\2\u0162\u0163\5<\37\2\u0163\u0164\b\36\1\2\u0164"+
		"\u0171\3\2\2\2\u0165\u0166\f\5\2\2\u0166\u0167\7\f\2\2\u0167\u0168\5<"+
		"\37\2\u0168\u0169\b\36\1\2\u0169\u0170\3\2\2\2\u016a\u016b\f\4\2\2\u016b"+
		"\u016c\7\r\2\2\u016c\u016d\5<\37\2\u016d\u016e\b\36\1\2\u016e\u0170\3"+
		"\2\2\2\u016f\u0165\3\2\2\2\u016f\u016a\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172;\3\2\2\2\u0173\u0171\3\2\2\2"+
		"\u0174\u0175\b\37\1\2\u0175\u0176\5> \2\u0176\u0177\b\37\1\2\u0177\u018e"+
		"\3\2\2\2\u0178\u0179\f\7\2\2\u0179\u017a\7\16\2\2\u017a\u017b\5> \2\u017b"+
		"\u017c\b\37\1\2\u017c\u018d\3\2\2\2\u017d\u017e\f\6\2\2\u017e\u017f\7"+
		"\17\2\2\u017f\u0180\5> \2\u0180\u0181\b\37\1\2\u0181\u018d\3\2\2\2\u0182"+
		"\u0183\f\5\2\2\u0183\u0184\7\20\2\2\u0184\u0185\5> \2\u0185\u0186\b\37"+
		"\1\2\u0186\u018d\3\2\2\2\u0187\u0188\f\4\2\2\u0188\u0189\7\21\2\2\u0189"+
		"\u018a\5> \2\u018a\u018b\b\37\1\2\u018b\u018d\3\2\2\2\u018c\u0178\3\2"+
		"\2\2\u018c\u017d\3\2\2\2\u018c\u0182\3\2\2\2\u018c\u0187\3\2\2\2\u018d"+
		"\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f=\3\2\2\2"+
		"\u0190\u018e\3\2\2\2\u0191\u0192\b \1\2\u0192\u0193\5@!\2\u0193\u0194"+
		"\b \1\2\u0194\u01a1\3\2\2\2\u0195\u0196\f\5\2\2\u0196\u0197\7\22\2\2\u0197"+
		"\u0198\5@!\2\u0198\u0199\b \1\2\u0199\u01a0\3\2\2\2\u019a\u019b\f\4\2"+
		"\2\u019b\u019c\7\23\2\2\u019c\u019d\5@!\2\u019d\u019e\b \1\2\u019e\u01a0"+
		"\3\2\2\2\u019f\u0195\3\2\2\2\u019f\u019a\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2?\3\2\2\2\u01a3\u01a1\3\2\2\2"+
		"\u01a4\u01a5\b!\1\2\u01a5\u01a6\5B\"\2\u01a6\u01a7\b!\1\2\u01a7\u01b9"+
		"\3\2\2\2\u01a8\u01a9\f\6\2\2\u01a9\u01aa\7\24\2\2\u01aa\u01ab\5B\"\2\u01ab"+
		"\u01ac\b!\1\2\u01ac\u01b8\3\2\2\2\u01ad\u01ae\f\5\2\2\u01ae\u01af\7\25"+
		"\2\2\u01af\u01b0\5B\"\2\u01b0\u01b1\b!\1\2\u01b1\u01b8\3\2\2\2\u01b2\u01b3"+
		"\f\4\2\2\u01b3\u01b4\7\26\2\2\u01b4\u01b5\5B\"\2\u01b5\u01b6\b!\1\2\u01b6"+
		"\u01b8\3\2\2\2\u01b7\u01a8\3\2\2\2\u01b7\u01ad\3\2\2\2\u01b7\u01b2\3\2"+
		"\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"A\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd\7\27\2\2\u01bd\u01be\5D#\2\u01be"+
		"\u01bf\b\"\1\2\u01bf\u01cc\3\2\2\2\u01c0\u01c1\7\23\2\2\u01c1\u01c2\5"+
		"D#\2\u01c2\u01c3\b\"\1\2\u01c3\u01cc\3\2\2\2\u01c4\u01c5\7\22\2\2\u01c5"+
		"\u01c6\5D#\2\u01c6\u01c7\b\"\1\2\u01c7\u01cc\3\2\2\2\u01c8\u01c9\5D#\2"+
		"\u01c9\u01ca\b\"\1\2\u01ca\u01cc\3\2\2\2\u01cb\u01bc\3\2\2\2\u01cb\u01c0"+
		"\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cb\u01c8\3\2\2\2\u01ccC\3\2\2\2\u01cd"+
		"\u01ce\5P)\2\u01ce\u01cf\b#\1\2\u01cf\u01df\3\2\2\2\u01d0\u01d1\5J&\2"+
		"\u01d1\u01d2\b#\1\2\u01d2\u01df\3\2\2\2\u01d3\u01d4\5J&\2\u01d4\u01d5"+
		"\7\4\2\2\u01d5\u01d6\5H%\2\u01d6\u01d7\7\5\2\2\u01d7\u01d8\b#\1\2\u01d8"+
		"\u01df\3\2\2\2\u01d9\u01da\7\4\2\2\u01da\u01db\5\60\31\2\u01db\u01dc\7"+
		"\5\2\2\u01dc\u01dd\b#\1\2\u01dd\u01df\3\2\2\2\u01de\u01cd\3\2\2\2\u01de"+
		"\u01d0\3\2\2\2\u01de\u01d3\3\2\2\2\u01de\u01d9\3\2\2\2\u01dfE\3\2\2\2"+
		"\u01e0\u01e1\5\60\31\2\u01e1\u01e2\b$\1\2\u01e2G\3\2\2\2\u01e3\u01ed\b"+
		"%\1\2\u01e4\u01e5\5F$\2\u01e5\u01e6\b%\1\2\u01e6\u01ed\3\2\2\2\u01e7\u01e8"+
		"\5F$\2\u01e8\u01e9\7\b\2\2\u01e9\u01ea\5H%\2\u01ea\u01eb\b%\1\2\u01eb"+
		"\u01ed\3\2\2\2\u01ec\u01e3\3\2\2\2\u01ec\u01e4\3\2\2\2\u01ec\u01e7\3\2"+
		"\2\2\u01edI\3\2\2\2\u01ee\u01ef\5L\'\2\u01ef\u01f0\b&\1\2\u01f0K\3\2\2"+
		"\2\u01f1\u01f2\5N(\2\u01f2\u01f3\b\'\1\2\u01f3\u01fa\3\2\2\2\u01f4\u01f5"+
		"\5N(\2\u01f5\u01f6\7\3\2\2\u01f6\u01f7\5L\'\2\u01f7\u01f8\b\'\1\2\u01f8"+
		"\u01fa\3\2\2\2\u01f9\u01f1\3\2\2\2\u01f9\u01f4\3\2\2\2\u01faM\3\2\2\2"+
		"\u01fb\u01fc\7#\2\2\u01fc\u01fd\b(\1\2\u01fdO\3\2\2\2\u01fe\u01ff\7&\2"+
		"\2\u01ff\u020b\b)\1\2\u0200\u0201\7\"\2\2\u0201\u020b\b)\1\2\u0202\u0203"+
		"\7!\2\2\u0203\u020b\b)\1\2\u0204\u0205\7\32\2\2\u0205\u020b\b)\1\2\u0206"+
		"\u0207\7$\2\2\u0207\u020b\b)\1\2\u0208\u0209\7%\2\2\u0209\u020b\b)\1\2"+
		"\u020a\u01fe\3\2\2\2\u020a\u0200\3\2\2\2\u020a\u0202\3\2\2\2\u020a\u0204"+
		"\3\2\2\2\u020a\u0206\3\2\2\2\u020a\u0208\3\2\2\2\u020bQ\3\2\2\2!\\iz\u0089"+
		"\u009a\u00a5\u00c7\u00d2\u00ea\u00f2\u00ff\u0109\u0113\u0120\u0136\u0143"+
		"\u0150\u015e\u016f\u0171\u018c\u018e\u019f\u01a1\u01b7\u01b9\u01cb\u01de"+
		"\u01ec\u01f9\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}