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
		Surrogate_id_SYMB_23=24, Surrogate_id_SYMB_24=25, JID=26, JCHAR=27, JSTRING=28, 
		INTEGER=29, WS=30, ErrorToken=31;
	public static final int
		RULE_fileContents = 0, RULE_pkgName = 1, RULE_listPkgFragm = 2, RULE_pkgFragm = 3, 
		RULE_imports = 4, RULE_listImport = 5, RULE_import_ = 6, RULE_listImportFragm = 7, 
		RULE_importFragm = 8, RULE_defs = 9, RULE_listDef = 10, RULE_def = 11, 
		RULE_binding = 12, RULE_typeSpec = 13, RULE_listTypeSpecFragm = 14, RULE_typeSpecFragm = 15, 
		RULE_expr = 16, RULE_expr1 = 17, RULE_expr2 = 18, RULE_expr3 = 19, RULE_expr4 = 20, 
		RULE_expr5 = 21, RULE_expr6 = 22, RULE_valRef = 23, RULE_listValRefFragm = 24, 
		RULE_valRefFragm = 25, RULE_literal = 26;
	public static final String[] ruleNames = {
		"fileContents", "pkgName", "listPkgFragm", "pkgFragm", "imports", "listImport", 
		"import_", "listImportFragm", "importFragm", "defs", "listDef", "def", 
		"binding", "typeSpec", "listTypeSpecFragm", "typeSpecFragm", "expr", "expr1", 
		"expr2", "expr3", "expr4", "expr5", "expr6", "valRef", "listValRefFragm", 
		"valRefFragm", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "'||'", "'&&'", "'=='", "'!='", "'<'", "'<='", 
		"'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'('", "')'", 
		"'def'", "'false'", "'import'", "'package'", "'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", 
		"Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", 
		"Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", 
		"Surrogate_id_SYMB_17", "Surrogate_id_SYMB_18", "Surrogate_id_SYMB_19", 
		"Surrogate_id_SYMB_20", "Surrogate_id_SYMB_21", "Surrogate_id_SYMB_22", 
		"Surrogate_id_SYMB_23", "Surrogate_id_SYMB_24", "JID", "JCHAR", "JSTRING", 
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
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(FujureParser.Surrogate_id_SYMB_22, 0); }
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
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(Surrogate_id_SYMB_22);
				setState(55);
				((FileInNamedPackageContext)_localctx).p_1_2 = pkgName();
				setState(56);
				((FileInNamedPackageContext)_localctx).p_1_3 = imports();
				setState(57);
				((FileInNamedPackageContext)_localctx).p_1_4 = defs();
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result,((FileInNamedPackageContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((FileInDefaultPackageContext)_localctx).p_2_1 = imports();
				setState(61);
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
			setState(66);
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
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(73);
				match(Surrogate_id_SYMB_0);
				setState(74);
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
			setState(79);
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
			setState(82);
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
			setState(94);
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
					setState(88);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(89);
					((ListImport_PrependFirstContext)_localctx).p_2_2 = import_();
					 ((ListImport_PrependFirstContext)_localctx).result =  ((ListImport_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImport_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(96);
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
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(FujureParser.Surrogate_id_SYMB_21, 0); }
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
			setState(97);
			match(Surrogate_id_SYMB_21);
			setState(98);
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
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ListImportFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				((ListImportFragm_AppendLastContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListImportFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_1 = importFragm();
				setState(105);
				match(Surrogate_id_SYMB_0);
				setState(106);
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
			setState(111);
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
	public static class DefinitionsContext extends DefsContext {
		public ListDefContext p_1_1;
		public ListDefContext listDef() {
			return getRuleContext(ListDefContext.class,0);
		}
		public DefinitionsContext(DefsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitDefinitions(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defs);
		try {
			_localctx = new DefinitionsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			((DefinitionsContext)_localctx).p_1_1 = listDef(0);
			 ((DefinitionsContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.Definitions(((DefinitionsContext)_localctx).p_1_1.result); 
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
			setState(126);
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
					setState(120);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(121);
					((ListDef_PrependFirstContext)_localctx).p_2_2 = def();
					 ((ListDef_PrependFirstContext)_localctx).result =  ((ListDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(128);
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
	public static class SimpleValueDefContext extends DefContext {
		public BindingContext p_1_2;
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(FujureParser.Surrogate_id_SYMB_19, 0); }
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
			_localctx = new SimpleValueDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(Surrogate_id_SYMB_19);
			setState(130);
			((SimpleValueDefContext)_localctx).p_1_2 = binding();
			 ((SimpleValueDefContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SimpleValueDef(((SimpleValueDefContext)_localctx).p_1_2.result); 
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
		public TypeSpecContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
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
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
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
		public TypeSpecContext p_4_3;
		public ExprContext p_4_5;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(FujureParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(FujureParser.Surrogate_id_SYMB_2, 0); }
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
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
		enterRule(_localctx, 24, RULE_binding);
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OnlyNameBindingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				((OnlyNameBindingContext)_localctx).p_1_1 = match(JID);
				 ((OnlyNameBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(((OnlyNameBindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				_localctx = new NameTypeBindingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				((NameTypeBindingContext)_localctx).p_2_1 = match(JID);
				setState(136);
				match(Surrogate_id_SYMB_1);
				setState(137);
				((NameTypeBindingContext)_localctx).p_2_3 = typeSpec();
				 ((NameTypeBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(((NameTypeBindingContext)_localctx).p_2_1.getText(),((NameTypeBindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				_localctx = new NameInitBindingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				((NameInitBindingContext)_localctx).p_3_1 = match(JID);
				setState(141);
				match(Surrogate_id_SYMB_2);
				setState(142);
				((NameInitBindingContext)_localctx).p_3_3 = expr(0);
				 ((NameInitBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(((NameInitBindingContext)_localctx).p_3_1.getText(),((NameInitBindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new FullBindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				((FullBindingContext)_localctx).p_4_1 = match(JID);
				setState(146);
				match(Surrogate_id_SYMB_1);
				setState(147);
				((FullBindingContext)_localctx).p_4_3 = typeSpec();
				setState(148);
				match(Surrogate_id_SYMB_2);
				setState(149);
				((FullBindingContext)_localctx).p_4_5 = expr(0);
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

	public static class TypeSpecContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpec result;
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
	 
		public TypeSpecContext() { }
		public void copyFrom(TypeSpecContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class TypeSpecifierContext extends TypeSpecContext {
		public ListTypeSpecFragmContext p_1_1;
		public ListTypeSpecFragmContext listTypeSpecFragm() {
			return getRuleContext(ListTypeSpecFragmContext.class,0);
		}
		public TypeSpecifierContext(TypeSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeSpec);
		try {
			_localctx = new TypeSpecifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((TypeSpecifierContext)_localctx).p_1_1 = listTypeSpecFragm();
			 ((TypeSpecifierContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecifier(((TypeSpecifierContext)_localctx).p_1_1.result); 
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

	public static class ListTypeSpecFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm result;
		public ListTypeSpecFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listTypeSpecFragm; }
	 
		public ListTypeSpecFragmContext() { }
		public void copyFrom(ListTypeSpecFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class ListTypeSpecFragm_AppendLastContext extends ListTypeSpecFragmContext {
		public TypeSpecFragmContext p_1_1;
		public TypeSpecFragmContext typeSpecFragm() {
			return getRuleContext(TypeSpecFragmContext.class,0);
		}
		public ListTypeSpecFragm_AppendLastContext(ListTypeSpecFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListTypeSpecFragm_AppendLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListTypeSpecFragm_AppendLast(this);
		}
	}
	public static class ListTypeSpecFragm_PrependFirstContext extends ListTypeSpecFragmContext {
		public TypeSpecFragmContext p_2_1;
		public ListTypeSpecFragmContext p_2_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(FujureParser.Surrogate_id_SYMB_0, 0); }
		public TypeSpecFragmContext typeSpecFragm() {
			return getRuleContext(TypeSpecFragmContext.class,0);
		}
		public ListTypeSpecFragmContext listTypeSpecFragm() {
			return getRuleContext(ListTypeSpecFragmContext.class,0);
		}
		public ListTypeSpecFragm_PrependFirstContext(ListTypeSpecFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterListTypeSpecFragm_PrependFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitListTypeSpecFragm_PrependFirst(this);
		}
	}

	public final ListTypeSpecFragmContext listTypeSpecFragm() throws RecognitionException {
		ListTypeSpecFragmContext _localctx = new ListTypeSpecFragmContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_listTypeSpecFragm);
		try {
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListTypeSpecFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1 = typeSpecFragm();
				 ((ListTypeSpecFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); _localctx.result.addLast(((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListTypeSpecFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_1 = typeSpecFragm();
				setState(161);
				match(Surrogate_id_SYMB_0);
				setState(162);
				((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_3 = listTypeSpecFragm();
				 ((ListTypeSpecFragm_PrependFirstContext)_localctx).result =  ((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_1.result); 
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

	public static class TypeSpecFragmContext extends ParserRuleContext {
		public org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragm result;
		public TypeSpecFragmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecFragm; }
	 
		public TypeSpecFragmContext() { }
		public void copyFrom(TypeSpecFragmContext ctx) {
			super.copyFrom(ctx);
			this.result = ctx.result;
		}
	}
	public static class TypeSpecFragmentContext extends TypeSpecFragmContext {
		public Token p_1_1;
		public TerminalNode JID() { return getToken(FujureParser.JID, 0); }
		public TypeSpecFragmentContext(TypeSpecFragmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterTypeSpecFragment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitTypeSpecFragment(this);
		}
	}

	public final TypeSpecFragmContext typeSpecFragm() throws RecognitionException {
		TypeSpecFragmContext _localctx = new TypeSpecFragmContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpecFragm);
		try {
			_localctx = new TypeSpecFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			((TypeSpecFragmentContext)_localctx).p_1_1 = match(JID);
			 ((TypeSpecFragmentContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.TypeSpecFragment(((TypeSpecFragmentContext)_localctx).p_1_1.getText()); 
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
		public Expr1Context p_2_1;
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
	public static class OrExprContext extends ExprContext {
		public ExprContext p_1_1;
		public Expr1Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitOrExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_ExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(171);
			((Coercion_ExprContext)_localctx).p_2_1 = expr1(0);
			 ((Coercion_ExprContext)_localctx).result =  ((Coercion_ExprContext)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
					((OrExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(174);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(175);
					match(Surrogate_id_SYMB_3);
					setState(176);
					((OrExprContext)_localctx).p_1_3 = expr1(0);
					 ((OrExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr(((OrExprContext)_localctx).p_1_1.result,((OrExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class AndExprContext extends Expr1Context {
		public Expr1Context p_1_1;
		public Expr2Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public AndExprContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAndExpr(this);
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

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr1Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(185);
			((Coercion_Expr1Context)_localctx).p_2_1 = expr2(0);
			 ((Coercion_Expr1Context)_localctx).result =  ((Coercion_Expr1Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(new Expr1Context(_parentctx, _parentState));
					((AndExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(188);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(189);
					match(Surrogate_id_SYMB_4);
					setState(190);
					((AndExprContext)_localctx).p_1_3 = expr2(0);
					 ((AndExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr(((AndExprContext)_localctx).p_1_1.result,((AndExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
	public static class EqualityExprContext extends Expr2Context {
		public Expr2Context p_1_1;
		public Expr3Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public EqualityExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitEqualityExpr(this);
		}
	}
	public static class InequalityExprContext extends Expr2Context {
		public Expr2Context p_2_1;
		public Expr3Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public InequalityExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterInequalityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitInequalityExpr(this);
		}
	}
	public static class Coercion_Expr2Context extends Expr2Context {
		public Expr3Context p_3_1;
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(199);
			((Coercion_Expr2Context)_localctx).p_3_1 = expr3(0);
			 ((Coercion_Expr2Context)_localctx).result =  ((Coercion_Expr2Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(212);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExprContext(new Expr2Context(_parentctx, _parentState));
						((EqualityExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(202);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(203);
						match(Surrogate_id_SYMB_5);
						setState(204);
						((EqualityExprContext)_localctx).p_1_3 = expr3(0);
						 ((EqualityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr(((EqualityExprContext)_localctx).p_1_1.result,((EqualityExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new InequalityExprContext(new Expr2Context(_parentctx, _parentState));
						((InequalityExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(207);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(208);
						match(Surrogate_id_SYMB_6);
						setState(209);
						((InequalityExprContext)_localctx).p_2_3 = expr3(0);
						 ((InequalityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr(((InequalityExprContext)_localctx).p_2_1.result,((InequalityExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class LesserEqualExprContext extends Expr3Context {
		public Expr3Context p_2_1;
		public Expr4Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(FujureParser.Surrogate_id_SYMB_8, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public LesserEqualExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserEqualExpr(this);
		}
	}
	public static class GreaterExprContext extends Expr3Context {
		public Expr3Context p_3_1;
		public Expr4Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(FujureParser.Surrogate_id_SYMB_9, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public GreaterExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterExpr(this);
		}
	}
	public static class LesserExprContext extends Expr3Context {
		public Expr3Context p_1_1;
		public Expr4Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(FujureParser.Surrogate_id_SYMB_7, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public LesserExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserExpr(this);
		}
	}
	public static class GreaterEqualExprContext extends Expr3Context {
		public Expr3Context p_4_1;
		public Expr4Context p_4_3;
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(FujureParser.Surrogate_id_SYMB_10, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public GreaterEqualExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterEqualExpr(this);
		}
	}
	public static class Coercion_Expr3Context extends Expr3Context {
		public Expr4Context p_5_1;
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr3Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(218);
			((Coercion_Expr3Context)_localctx).p_5_1 = expr4(0);
			 ((Coercion_Expr3Context)_localctx).result =  ((Coercion_Expr3Context)_localctx).p_5_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new LesserExprContext(new Expr3Context(_parentctx, _parentState));
						((LesserExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(221);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(222);
						match(Surrogate_id_SYMB_7);
						setState(223);
						((LesserExprContext)_localctx).p_1_3 = expr4(0);
						 ((LesserExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr(((LesserExprContext)_localctx).p_1_1.result,((LesserExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new LesserEqualExprContext(new Expr3Context(_parentctx, _parentState));
						((LesserEqualExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(226);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(227);
						match(Surrogate_id_SYMB_8);
						setState(228);
						((LesserEqualExprContext)_localctx).p_2_3 = expr4(0);
						 ((LesserEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr(((LesserEqualExprContext)_localctx).p_2_1.result,((LesserEqualExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new GreaterExprContext(new Expr3Context(_parentctx, _parentState));
						((GreaterExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						match(Surrogate_id_SYMB_9);
						setState(233);
						((GreaterExprContext)_localctx).p_3_3 = expr4(0);
						 ((GreaterExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr(((GreaterExprContext)_localctx).p_3_1.result,((GreaterExprContext)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new GreaterEqualExprContext(new Expr3Context(_parentctx, _parentState));
						((GreaterEqualExprContext)_localctx).p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(236);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(237);
						match(Surrogate_id_SYMB_10);
						setState(238);
						((GreaterEqualExprContext)_localctx).p_4_3 = expr4(0);
						 ((GreaterEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr(((GreaterEqualExprContext)_localctx).p_4_1.result,((GreaterEqualExprContext)_localctx).p_4_3.result); 
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class AdditionExprContext extends Expr4Context {
		public Expr4Context p_1_1;
		public Expr5Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(FujureParser.Surrogate_id_SYMB_11, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public AdditionExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAdditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAdditionExpr(this);
		}
	}
	public static class SubtractionExprContext extends Expr4Context {
		public Expr4Context p_2_1;
		public Expr5Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(FujureParser.Surrogate_id_SYMB_12, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public SubtractionExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSubtractionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSubtractionExpr(this);
		}
	}
	public static class Coercion_Expr4Context extends Expr4Context {
		public Expr5Context p_3_1;
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr4Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(247);
			((Coercion_Expr4Context)_localctx).p_3_1 = expr5(0);
			 ((Coercion_Expr4Context)_localctx).result =  ((Coercion_Expr4Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(260);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionExprContext(new Expr4Context(_parentctx, _parentState));
						((AdditionExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(250);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(251);
						match(Surrogate_id_SYMB_11);
						setState(252);
						((AdditionExprContext)_localctx).p_1_3 = expr5(0);
						 ((AdditionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr(((AdditionExprContext)_localctx).p_1_1.result,((AdditionExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new SubtractionExprContext(new Expr4Context(_parentctx, _parentState));
						((SubtractionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(255);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(256);
						match(Surrogate_id_SYMB_12);
						setState(257);
						((SubtractionExprContext)_localctx).p_2_3 = expr5(0);
						 ((SubtractionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr(((SubtractionExprContext)_localctx).p_2_1.result,((SubtractionExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class ModuloExprContext extends Expr5Context {
		public Expr5Context p_3_1;
		public Expr6Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(FujureParser.Surrogate_id_SYMB_15, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public ModuloExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterModuloExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitModuloExpr(this);
		}
	}
	public static class DivisionExprContext extends Expr5Context {
		public Expr5Context p_2_1;
		public Expr6Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(FujureParser.Surrogate_id_SYMB_14, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public DivisionExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterDivisionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitDivisionExpr(this);
		}
	}
	public static class MultiplicationExprContext extends Expr5Context {
		public Expr5Context p_1_1;
		public Expr6Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(FujureParser.Surrogate_id_SYMB_13, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public MultiplicationExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitMultiplicationExpr(this);
		}
	}
	public static class Coercion_Expr5Context extends Expr5Context {
		public Expr6Context p_4_1;
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr5Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(266);
			((Coercion_Expr5Context)_localctx).p_4_1 = expr6();
			 ((Coercion_Expr5Context)_localctx).result =  ((Coercion_Expr5Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(284);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new Expr5Context(_parentctx, _parentState));
						((MultiplicationExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(269);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(270);
						match(Surrogate_id_SYMB_13);
						setState(271);
						((MultiplicationExprContext)_localctx).p_1_3 = expr6();
						 ((MultiplicationExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr(((MultiplicationExprContext)_localctx).p_1_1.result,((MultiplicationExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new DivisionExprContext(new Expr5Context(_parentctx, _parentState));
						((DivisionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(274);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(275);
						match(Surrogate_id_SYMB_14);
						setState(276);
						((DivisionExprContext)_localctx).p_2_3 = expr6();
						 ((DivisionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr(((DivisionExprContext)_localctx).p_2_1.result,((DivisionExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new ModuloExprContext(new Expr5Context(_parentctx, _parentState));
						((ModuloExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(279);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(280);
						match(Surrogate_id_SYMB_15);
						setState(281);
						((ModuloExprContext)_localctx).p_3_3 = expr6();
						 ((ModuloExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr(((ModuloExprContext)_localctx).p_3_1.result,((ModuloExprContext)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(288);
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
	public static class Coercion_Expr6Context extends Expr6Context {
		public ExprContext p_4_2;
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(FujureParser.Surrogate_id_SYMB_17, 0); }
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(FujureParser.Surrogate_id_SYMB_18, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
	public static class LiteralExprContext extends Expr6Context {
		public LiteralContext p_3_1;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLiteralExpr(this);
		}
	}
	public static class VariableExprContext extends Expr6Context {
		public ValRefContext p_2_1;
		public ValRefContext valRef() {
			return getRuleContext(ValRefContext.class,0);
		}
		public VariableExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitVariableExpr(this);
		}
	}
	public static class NotExprContext extends Expr6Context {
		public Expr6Context p_1_2;
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(FujureParser.Surrogate_id_SYMB_16, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public NotExprContext(Expr6Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNotExpr(this);
		}
	}

	public final Expr6Context expr6() throws RecognitionException {
		Expr6Context _localctx = new Expr6Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr6);
		try {
			setState(304);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_16:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(Surrogate_id_SYMB_16);
				setState(290);
				((NotExprContext)_localctx).p_1_2 = expr6();
				 ((NotExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr(((NotExprContext)_localctx).p_1_2.result); 
				}
				break;
			case JID:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				((VariableExprContext)_localctx).p_2_1 = valRef();
				 ((VariableExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(((VariableExprContext)_localctx).p_2_1.result); 
				}
				break;
			case Surrogate_id_SYMB_20:
			case Surrogate_id_SYMB_23:
			case Surrogate_id_SYMB_24:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				((LiteralExprContext)_localctx).p_3_1 = literal();
				 ((LiteralExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(((LiteralExprContext)_localctx).p_3_1.result); 
				}
				break;
			case Surrogate_id_SYMB_17:
				_localctx = new Coercion_Expr6Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				match(Surrogate_id_SYMB_17);
				setState(300);
				((Coercion_Expr6Context)_localctx).p_4_2 = expr(0);
				setState(301);
				match(Surrogate_id_SYMB_18);
				 ((Coercion_Expr6Context)_localctx).result =  ((Coercion_Expr6Context)_localctx).p_4_2.result; 
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
		enterRule(_localctx, 46, RULE_valRef);
		try {
			_localctx = new ValueRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
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
		enterRule(_localctx, 48, RULE_listValRefFragm);
		try {
			setState(317);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ListValRefFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				((ListValRefFragm_AppendLastContext)_localctx).p_1_1 = valRefFragm();
				 ((ListValRefFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); _localctx.result.addLast(((ListValRefFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListValRefFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_1 = valRefFragm();
				setState(313);
				match(Surrogate_id_SYMB_0);
				setState(314);
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
		enterRule(_localctx, 50, RULE_valRefFragm);
		try {
			_localctx = new ValueRefFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
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
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(FujureParser.Surrogate_id_SYMB_23, 0); }
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
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(FujureParser.Surrogate_id_SYMB_20, 0); }
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
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(FujureParser.Surrogate_id_SYMB_24, 0); }
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
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(334);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				((IntLiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((IntLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt(((IntLiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_24:
				_localctx = new UnitLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(Surrogate_id_SYMB_24);
				 ((UnitLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_23:
				_localctx = new BoolTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				match(Surrogate_id_SYMB_23);
				 ((BoolTrueLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_20:
				_localctx = new BoolFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				match(Surrogate_id_SYMB_20);
				 ((BoolFalseLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				((CharLiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((CharLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(((CharLiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(332);
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
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 17:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 18:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 19:
			return expr3_sempred((Expr3Context)_localctx, predIndex);
		case 20:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 21:
			return expr5_sempred((Expr5Context)_localctx, predIndex);
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
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr3_sempred(Expr3Context _localctx, int predIndex) {
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
	private boolean expr4_sempred(Expr4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr5_sempred(Expr5Context _localctx, int predIndex) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0153\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2C\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\177\n\f\f\f\16\f\u0082\13"+
		"\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009b\n\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a8\n\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00b6\n\22\f\22"+
		"\16\22\u00b9\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c4"+
		"\n\23\f\23\16\23\u00c7\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d7\n\24\f\24\16\24\u00da\13\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f4\n\25\f\25"+
		"\16\25\u00f7\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\7\26\u0107\n\26\f\26\16\26\u010a\13\26\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\7\27\u011f\n\27\f\27\16\27\u0122\13\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0133"+
		"\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0140"+
		"\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u0151\n\34\3\34\2\n\f\26\"$&(*,\35\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\2\u0156\2B\3\2\2\2\4D\3\2\2"+
		"\2\6O\3\2\2\2\bQ\3\2\2\2\nT\3\2\2\2\fW\3\2\2\2\16c\3\2\2\2\20o\3\2\2\2"+
		"\22q\3\2\2\2\24t\3\2\2\2\26w\3\2\2\2\30\u0083\3\2\2\2\32\u009a\3\2\2\2"+
		"\34\u009c\3\2\2\2\36\u00a7\3\2\2\2 \u00a9\3\2\2\2\"\u00ac\3\2\2\2$\u00ba"+
		"\3\2\2\2&\u00c8\3\2\2\2(\u00db\3\2\2\2*\u00f8\3\2\2\2,\u010b\3\2\2\2."+
		"\u0132\3\2\2\2\60\u0134\3\2\2\2\62\u013f\3\2\2\2\64\u0141\3\2\2\2\66\u0150"+
		"\3\2\2\289\7\31\2\29:\5\4\3\2:;\5\n\6\2;<\5\24\13\2<=\b\2\1\2=C\3\2\2"+
		"\2>?\5\n\6\2?@\5\24\13\2@A\b\2\1\2AC\3\2\2\2B8\3\2\2\2B>\3\2\2\2C\3\3"+
		"\2\2\2DE\5\6\4\2EF\b\3\1\2F\5\3\2\2\2GH\5\b\5\2HI\b\4\1\2IP\3\2\2\2JK"+
		"\5\b\5\2KL\7\3\2\2LM\5\6\4\2MN\b\4\1\2NP\3\2\2\2OG\3\2\2\2OJ\3\2\2\2P"+
		"\7\3\2\2\2QR\7\34\2\2RS\b\5\1\2S\t\3\2\2\2TU\5\f\7\2UV\b\6\1\2V\13\3\2"+
		"\2\2WX\b\7\1\2XY\b\7\1\2Y`\3\2\2\2Z[\f\3\2\2[\\\5\16\b\2\\]\b\7\1\2]_"+
		"\3\2\2\2^Z\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\r\3\2\2\2b`\3\2\2\2"+
		"cd\7\30\2\2de\5\20\t\2ef\b\b\1\2f\17\3\2\2\2gh\5\22\n\2hi\b\t\1\2ip\3"+
		"\2\2\2jk\5\22\n\2kl\7\3\2\2lm\5\20\t\2mn\b\t\1\2np\3\2\2\2og\3\2\2\2o"+
		"j\3\2\2\2p\21\3\2\2\2qr\7\34\2\2rs\b\n\1\2s\23\3\2\2\2tu\5\26\f\2uv\b"+
		"\13\1\2v\25\3\2\2\2wx\b\f\1\2xy\b\f\1\2y\u0080\3\2\2\2z{\f\3\2\2{|\5\30"+
		"\r\2|}\b\f\1\2}\177\3\2\2\2~z\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\27\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084"+
		"\7\26\2\2\u0084\u0085\5\32\16\2\u0085\u0086\b\r\1\2\u0086\31\3\2\2\2\u0087"+
		"\u0088\7\34\2\2\u0088\u009b\b\16\1\2\u0089\u008a\7\34\2\2\u008a\u008b"+
		"\7\4\2\2\u008b\u008c\5\34\17\2\u008c\u008d\b\16\1\2\u008d\u009b\3\2\2"+
		"\2\u008e\u008f\7\34\2\2\u008f\u0090\7\5\2\2\u0090\u0091\5\"\22\2\u0091"+
		"\u0092\b\16\1\2\u0092\u009b\3\2\2\2\u0093\u0094\7\34\2\2\u0094\u0095\7"+
		"\4\2\2\u0095\u0096\5\34\17\2\u0096\u0097\7\5\2\2\u0097\u0098\5\"\22\2"+
		"\u0098\u0099\b\16\1\2\u0099\u009b\3\2\2\2\u009a\u0087\3\2\2\2\u009a\u0089"+
		"\3\2\2\2\u009a\u008e\3\2\2\2\u009a\u0093\3\2\2\2\u009b\33\3\2\2\2\u009c"+
		"\u009d\5\36\20\2\u009d\u009e\b\17\1\2\u009e\35\3\2\2\2\u009f\u00a0\5 "+
		"\21\2\u00a0\u00a1\b\20\1\2\u00a1\u00a8\3\2\2\2\u00a2\u00a3\5 \21\2\u00a3"+
		"\u00a4\7\3\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\b\20\1\2\u00a6\u00a8"+
		"\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a8\37\3\2\2\2\u00a9"+
		"\u00aa\7\34\2\2\u00aa\u00ab\b\21\1\2\u00ab!\3\2\2\2\u00ac\u00ad\b\22\1"+
		"\2\u00ad\u00ae\5$\23\2\u00ae\u00af\b\22\1\2\u00af\u00b7\3\2\2\2\u00b0"+
		"\u00b1\f\4\2\2\u00b1\u00b2\7\6\2\2\u00b2\u00b3\5$\23\2\u00b3\u00b4\b\22"+
		"\1\2\u00b4\u00b6\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8#\3\2\2\2\u00b9\u00b7\3\2\2\2"+
		"\u00ba\u00bb\b\23\1\2\u00bb\u00bc\5&\24\2\u00bc\u00bd\b\23\1\2\u00bd\u00c5"+
		"\3\2\2\2\u00be\u00bf\f\4\2\2\u00bf\u00c0\7\7\2\2\u00c0\u00c1\5&\24\2\u00c1"+
		"\u00c2\b\23\1\2\u00c2\u00c4\3\2\2\2\u00c3\u00be\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6%\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00c9\b\24\1\2\u00c9\u00ca\5(\25\2\u00ca\u00cb\b\24\1\2"+
		"\u00cb\u00d8\3\2\2\2\u00cc\u00cd\f\5\2\2\u00cd\u00ce\7\b\2\2\u00ce\u00cf"+
		"\5(\25\2\u00cf\u00d0\b\24\1\2\u00d0\u00d7\3\2\2\2\u00d1\u00d2\f\4\2\2"+
		"\u00d2\u00d3\7\t\2\2\u00d3\u00d4\5(\25\2\u00d4\u00d5\b\24\1\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00cc\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\'\3\2\2\2\u00da\u00d8\3\2\2\2"+
		"\u00db\u00dc\b\25\1\2\u00dc\u00dd\5*\26\2\u00dd\u00de\b\25\1\2\u00de\u00f5"+
		"\3\2\2\2\u00df\u00e0\f\7\2\2\u00e0\u00e1\7\n\2\2\u00e1\u00e2\5*\26\2\u00e2"+
		"\u00e3\b\25\1\2\u00e3\u00f4\3\2\2\2\u00e4\u00e5\f\6\2\2\u00e5\u00e6\7"+
		"\13\2\2\u00e6\u00e7\5*\26\2\u00e7\u00e8\b\25\1\2\u00e8\u00f4\3\2\2\2\u00e9"+
		"\u00ea\f\5\2\2\u00ea\u00eb\7\f\2\2\u00eb\u00ec\5*\26\2\u00ec\u00ed\b\25"+
		"\1\2\u00ed\u00f4\3\2\2\2\u00ee\u00ef\f\4\2\2\u00ef\u00f0\7\r\2\2\u00f0"+
		"\u00f1\5*\26\2\u00f1\u00f2\b\25\1\2\u00f2\u00f4\3\2\2\2\u00f3\u00df\3"+
		"\2\2\2\u00f3\u00e4\3\2\2\2\u00f3\u00e9\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6)\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f8\u00f9\b\26\1\2\u00f9\u00fa\5,\27\2\u00fa\u00fb"+
		"\b\26\1\2\u00fb\u0108\3\2\2\2\u00fc\u00fd\f\5\2\2\u00fd\u00fe\7\16\2\2"+
		"\u00fe\u00ff\5,\27\2\u00ff\u0100\b\26\1\2\u0100\u0107\3\2\2\2\u0101\u0102"+
		"\f\4\2\2\u0102\u0103\7\17\2\2\u0103\u0104\5,\27\2\u0104\u0105\b\26\1\2"+
		"\u0105\u0107\3\2\2\2\u0106\u00fc\3\2\2\2\u0106\u0101\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109+\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010c\b\27\1\2\u010c\u010d\5.\30\2\u010d\u010e\b"+
		"\27\1\2\u010e\u0120\3\2\2\2\u010f\u0110\f\6\2\2\u0110\u0111\7\20\2\2\u0111"+
		"\u0112\5.\30\2\u0112\u0113\b\27\1\2\u0113\u011f\3\2\2\2\u0114\u0115\f"+
		"\5\2\2\u0115\u0116\7\21\2\2\u0116\u0117\5.\30\2\u0117\u0118\b\27\1\2\u0118"+
		"\u011f\3\2\2\2\u0119\u011a\f\4\2\2\u011a\u011b\7\22\2\2\u011b\u011c\5"+
		".\30\2\u011c\u011d\b\27\1\2\u011d\u011f\3\2\2\2\u011e\u010f\3\2\2\2\u011e"+
		"\u0114\3\2\2\2\u011e\u0119\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121-\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124"+
		"\7\23\2\2\u0124\u0125\5.\30\2\u0125\u0126\b\30\1\2\u0126\u0133\3\2\2\2"+
		"\u0127\u0128\5\60\31\2\u0128\u0129\b\30\1\2\u0129\u0133\3\2\2\2\u012a"+
		"\u012b\5\66\34\2\u012b\u012c\b\30\1\2\u012c\u0133\3\2\2\2\u012d\u012e"+
		"\7\24\2\2\u012e\u012f\5\"\22\2\u012f\u0130\7\25\2\2\u0130\u0131\b\30\1"+
		"\2\u0131\u0133\3\2\2\2\u0132\u0123\3\2\2\2\u0132\u0127\3\2\2\2\u0132\u012a"+
		"\3\2\2\2\u0132\u012d\3\2\2\2\u0133/\3\2\2\2\u0134\u0135\5\62\32\2\u0135"+
		"\u0136\b\31\1\2\u0136\61\3\2\2\2\u0137\u0138\5\64\33\2\u0138\u0139\b\32"+
		"\1\2\u0139\u0140\3\2\2\2\u013a\u013b\5\64\33\2\u013b\u013c\7\3\2\2\u013c"+
		"\u013d\5\62\32\2\u013d\u013e\b\32\1\2\u013e\u0140\3\2\2\2\u013f\u0137"+
		"\3\2\2\2\u013f\u013a\3\2\2\2\u0140\63\3\2\2\2\u0141\u0142\7\34\2\2\u0142"+
		"\u0143\b\33\1\2\u0143\65\3\2\2\2\u0144\u0145\7\37\2\2\u0145\u0151\b\34"+
		"\1\2\u0146\u0147\7\33\2\2\u0147\u0151\b\34\1\2\u0148\u0149\7\32\2\2\u0149"+
		"\u0151\b\34\1\2\u014a\u014b\7\27\2\2\u014b\u0151\b\34\1\2\u014c\u014d"+
		"\7\35\2\2\u014d\u0151\b\34\1\2\u014e\u014f\7\36\2\2\u014f\u0151\b\34\1"+
		"\2\u0150\u0144\3\2\2\2\u0150\u0146\3\2\2\2\u0150\u0148\3\2\2\2\u0150\u014a"+
		"\3\2\2\2\u0150\u014c\3\2\2\2\u0150\u014e\3\2\2\2\u0151\67\3\2\2\2\26B"+
		"O`o\u0080\u009a\u00a7\u00b7\u00c5\u00d6\u00d8\u00f3\u00f5\u0106\u0108"+
		"\u011e\u0120\u0132\u013f\u0150";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}