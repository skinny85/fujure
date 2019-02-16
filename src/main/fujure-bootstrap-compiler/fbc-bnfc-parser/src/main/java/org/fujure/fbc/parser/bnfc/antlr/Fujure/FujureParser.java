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
		JID=24, JCHAR=25, JSTRING=26, INTEGER=27, WS=28, ErrorToken=29;
	public static final int
		RULE_fileContents = 0, RULE_pkgName = 1, RULE_listPkgFragm = 2, RULE_pkgFragm = 3, 
		RULE_imports = 4, RULE_listImport = 5, RULE_import_ = 6, RULE_listImportFragm = 7, 
		RULE_importFragm = 8, RULE_defs = 9, RULE_listDef = 10, RULE_def = 11, 
		RULE_binding = 12, RULE_typeSpec = 13, RULE_listTypeSpecFragm = 14, RULE_typeSpecFragm = 15, 
		RULE_expr = 16, RULE_expr1 = 17, RULE_expr2 = 18, RULE_expr3 = 19, RULE_expr4 = 20, 
		RULE_expr5 = 21, RULE_valRef = 22, RULE_listValRefFragm = 23, RULE_valRefFragm = 24, 
		RULE_literal = 25;
	public static final String[] ruleNames = {
		"fileContents", "pkgName", "listPkgFragm", "pkgFragm", "imports", "listImport", 
		"import_", "listImportFragm", "importFragm", "defs", "listDef", "def", 
		"binding", "typeSpec", "listTypeSpecFragm", "typeSpecFragm", "expr", "expr1", 
		"expr2", "expr3", "expr4", "expr5", "valRef", "listValRefFragm", "valRefFragm", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'('", "')'", "'def'", "'false'", 
		"'import'", "'package'", "'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", 
		"Surrogate_id_SYMB_11", "Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", 
		"Surrogate_id_SYMB_14", "Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", 
		"Surrogate_id_SYMB_17", "Surrogate_id_SYMB_18", "Surrogate_id_SYMB_19", 
		"Surrogate_id_SYMB_20", "Surrogate_id_SYMB_21", "Surrogate_id_SYMB_22", 
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
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(FujureParser.Surrogate_id_SYMB_20, 0); }
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
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(Surrogate_id_SYMB_20);
				setState(53);
				((FileInNamedPackageContext)_localctx).p_1_2 = pkgName();
				setState(54);
				((FileInNamedPackageContext)_localctx).p_1_3 = imports();
				setState(55);
				((FileInNamedPackageContext)_localctx).p_1_4 = defs();
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result,((FileInNamedPackageContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				((FileInDefaultPackageContext)_localctx).p_2_1 = imports();
				setState(59);
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
			setState(64);
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
			setState(75);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(71);
				match(Surrogate_id_SYMB_0);
				setState(72);
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
			setState(77);
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
			setState(80);
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
			setState(92);
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
					setState(86);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(87);
					((ListImport_PrependFirstContext)_localctx).p_2_2 = import_();
					 ((ListImport_PrependFirstContext)_localctx).result =  ((ListImport_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImport_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(94);
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
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(FujureParser.Surrogate_id_SYMB_19, 0); }
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
			setState(95);
			match(Surrogate_id_SYMB_19);
			setState(96);
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
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ListImportFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((ListImportFragm_AppendLastContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListImportFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_1 = importFragm();
				setState(103);
				match(Surrogate_id_SYMB_0);
				setState(104);
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
			setState(109);
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
			setState(112);
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
			setState(124);
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
					setState(118);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(119);
					((ListDef_PrependFirstContext)_localctx).p_2_2 = def();
					 ((ListDef_PrependFirstContext)_localctx).result =  ((ListDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(126);
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
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(FujureParser.Surrogate_id_SYMB_17, 0); }
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
			setState(127);
			match(Surrogate_id_SYMB_17);
			setState(128);
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
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OnlyNameBindingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				((OnlyNameBindingContext)_localctx).p_1_1 = match(JID);
				 ((OnlyNameBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(((OnlyNameBindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				_localctx = new NameTypeBindingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((NameTypeBindingContext)_localctx).p_2_1 = match(JID);
				setState(134);
				match(Surrogate_id_SYMB_1);
				setState(135);
				((NameTypeBindingContext)_localctx).p_2_3 = typeSpec();
				 ((NameTypeBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(((NameTypeBindingContext)_localctx).p_2_1.getText(),((NameTypeBindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				_localctx = new NameInitBindingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				((NameInitBindingContext)_localctx).p_3_1 = match(JID);
				setState(139);
				match(Surrogate_id_SYMB_2);
				setState(140);
				((NameInitBindingContext)_localctx).p_3_3 = expr(0);
				 ((NameInitBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(((NameInitBindingContext)_localctx).p_3_1.getText(),((NameInitBindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new FullBindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				((FullBindingContext)_localctx).p_4_1 = match(JID);
				setState(144);
				match(Surrogate_id_SYMB_1);
				setState(145);
				((FullBindingContext)_localctx).p_4_3 = typeSpec();
				setState(146);
				match(Surrogate_id_SYMB_2);
				setState(147);
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
			setState(152);
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
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListTypeSpecFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1 = typeSpecFragm();
				 ((ListTypeSpecFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); _localctx.result.addLast(((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListTypeSpecFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_1 = typeSpecFragm();
				setState(159);
				match(Surrogate_id_SYMB_0);
				setState(160);
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
			setState(165);
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

			setState(169);
			((Coercion_ExprContext)_localctx).p_2_1 = expr1(0);
			 ((Coercion_ExprContext)_localctx).result =  ((Coercion_ExprContext)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
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
					setState(172);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(173);
					match(Surrogate_id_SYMB_3);
					setState(174);
					((OrExprContext)_localctx).p_1_3 = expr1(0);
					 ((OrExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr(((OrExprContext)_localctx).p_1_1.result,((OrExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(181);
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

			setState(183);
			((Coercion_Expr1Context)_localctx).p_2_1 = expr2(0);
			 ((Coercion_Expr1Context)_localctx).result =  ((Coercion_Expr1Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
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
					setState(186);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(187);
					match(Surrogate_id_SYMB_4);
					setState(188);
					((AndExprContext)_localctx).p_1_3 = expr2(0);
					 ((AndExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr(((AndExprContext)_localctx).p_1_1.result,((AndExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(195);
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
	public static class LesserEqualExprContext extends Expr2Context {
		public Expr2Context p_2_1;
		public Expr3Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public LesserEqualExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserEqualExpr(this);
		}
	}
	public static class GreaterExprContext extends Expr2Context {
		public Expr2Context p_3_1;
		public Expr3Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(FujureParser.Surrogate_id_SYMB_7, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public GreaterExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterExpr(this);
		}
	}
	public static class LesserExprContext extends Expr2Context {
		public Expr2Context p_1_1;
		public Expr3Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public LesserExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLesserExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLesserExpr(this);
		}
	}
	public static class GreaterEqualExprContext extends Expr2Context {
		public Expr2Context p_4_1;
		public Expr3Context p_4_3;
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(FujureParser.Surrogate_id_SYMB_8, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public GreaterEqualExprContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterGreaterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitGreaterEqualExpr(this);
		}
	}
	public static class Coercion_Expr2Context extends Expr2Context {
		public Expr3Context p_5_1;
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

			setState(197);
			((Coercion_Expr2Context)_localctx).p_5_1 = expr3(0);
			 ((Coercion_Expr2Context)_localctx).result =  ((Coercion_Expr2Context)_localctx).p_5_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(220);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new LesserExprContext(new Expr2Context(_parentctx, _parentState));
						((LesserExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(200);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(201);
						match(Surrogate_id_SYMB_5);
						setState(202);
						((LesserExprContext)_localctx).p_1_3 = expr3(0);
						 ((LesserExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr(((LesserExprContext)_localctx).p_1_1.result,((LesserExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new LesserEqualExprContext(new Expr2Context(_parentctx, _parentState));
						((LesserEqualExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(205);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(206);
						match(Surrogate_id_SYMB_6);
						setState(207);
						((LesserEqualExprContext)_localctx).p_2_3 = expr3(0);
						 ((LesserEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr(((LesserEqualExprContext)_localctx).p_2_1.result,((LesserEqualExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new GreaterExprContext(new Expr2Context(_parentctx, _parentState));
						((GreaterExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(210);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(211);
						match(Surrogate_id_SYMB_7);
						setState(212);
						((GreaterExprContext)_localctx).p_3_3 = expr3(0);
						 ((GreaterExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr(((GreaterExprContext)_localctx).p_3_1.result,((GreaterExprContext)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new GreaterEqualExprContext(new Expr2Context(_parentctx, _parentState));
						((GreaterEqualExprContext)_localctx).p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(215);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(216);
						match(Surrogate_id_SYMB_8);
						setState(217);
						((GreaterEqualExprContext)_localctx).p_4_3 = expr3(0);
						 ((GreaterEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr(((GreaterEqualExprContext)_localctx).p_4_1.result,((GreaterEqualExprContext)_localctx).p_4_3.result); 
						}
						break;
					}
					} 
				}
				setState(224);
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
	public static class AdditionExprContext extends Expr3Context {
		public Expr3Context p_1_1;
		public Expr4Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(FujureParser.Surrogate_id_SYMB_9, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public AdditionExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterAdditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitAdditionExpr(this);
		}
	}
	public static class SubtractionExprContext extends Expr3Context {
		public Expr3Context p_2_1;
		public Expr4Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(FujureParser.Surrogate_id_SYMB_10, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public SubtractionExprContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterSubtractionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitSubtractionExpr(this);
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

			setState(226);
			((Coercion_Expr3Context)_localctx).p_3_1 = expr4(0);
			 ((Coercion_Expr3Context)_localctx).result =  ((Coercion_Expr3Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(239);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionExprContext(new Expr3Context(_parentctx, _parentState));
						((AdditionExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(229);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(230);
						match(Surrogate_id_SYMB_9);
						setState(231);
						((AdditionExprContext)_localctx).p_1_3 = expr4(0);
						 ((AdditionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr(((AdditionExprContext)_localctx).p_1_1.result,((AdditionExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new SubtractionExprContext(new Expr3Context(_parentctx, _parentState));
						((SubtractionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235);
						match(Surrogate_id_SYMB_10);
						setState(236);
						((SubtractionExprContext)_localctx).p_2_3 = expr4(0);
						 ((SubtractionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr(((SubtractionExprContext)_localctx).p_2_1.result,((SubtractionExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(243);
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
	public static class ModuloExprContext extends Expr4Context {
		public Expr4Context p_3_1;
		public Expr5Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(FujureParser.Surrogate_id_SYMB_13, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public ModuloExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterModuloExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitModuloExpr(this);
		}
	}
	public static class DivisionExprContext extends Expr4Context {
		public Expr4Context p_2_1;
		public Expr5Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(FujureParser.Surrogate_id_SYMB_12, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public DivisionExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterDivisionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitDivisionExpr(this);
		}
	}
	public static class Coercion_Expr4Context extends Expr4Context {
		public Expr5Context p_4_1;
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
	public static class MultiplicationExprContext extends Expr4Context {
		public Expr4Context p_1_1;
		public Expr5Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(FujureParser.Surrogate_id_SYMB_11, 0); }
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public MultiplicationExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitMultiplicationExpr(this);
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

			setState(245);
			((Coercion_Expr4Context)_localctx).p_4_1 = expr5();
			 ((Coercion_Expr4Context)_localctx).result =  ((Coercion_Expr4Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(263);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new Expr4Context(_parentctx, _parentState));
						((MultiplicationExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(248);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(249);
						match(Surrogate_id_SYMB_11);
						setState(250);
						((MultiplicationExprContext)_localctx).p_1_3 = expr5();
						 ((MultiplicationExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr(((MultiplicationExprContext)_localctx).p_1_1.result,((MultiplicationExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new DivisionExprContext(new Expr4Context(_parentctx, _parentState));
						((DivisionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(253);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(254);
						match(Surrogate_id_SYMB_12);
						setState(255);
						((DivisionExprContext)_localctx).p_2_3 = expr5();
						 ((DivisionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr(((DivisionExprContext)_localctx).p_2_1.result,((DivisionExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new ModuloExprContext(new Expr4Context(_parentctx, _parentState));
						((ModuloExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(258);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(259);
						match(Surrogate_id_SYMB_13);
						setState(260);
						((ModuloExprContext)_localctx).p_3_3 = expr5();
						 ((ModuloExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr(((ModuloExprContext)_localctx).p_3_1.result,((ModuloExprContext)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(267);
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
	public static class LiteralExprContext extends Expr5Context {
		public LiteralContext p_3_1;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLiteralExpr(this);
		}
	}
	public static class VariableExprContext extends Expr5Context {
		public ValRefContext p_2_1;
		public ValRefContext valRef() {
			return getRuleContext(ValRefContext.class,0);
		}
		public VariableExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitVariableExpr(this);
		}
	}
	public static class NotExprContext extends Expr5Context {
		public Expr5Context p_1_2;
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(FujureParser.Surrogate_id_SYMB_14, 0); }
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public NotExprContext(Expr5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitNotExpr(this);
		}
	}
	public static class Coercion_Expr5Context extends Expr5Context {
		public ExprContext p_4_2;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(FujureParser.Surrogate_id_SYMB_15, 0); }
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(FujureParser.Surrogate_id_SYMB_16, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		Expr5Context _localctx = new Expr5Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr5);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_14:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(Surrogate_id_SYMB_14);
				setState(269);
				((NotExprContext)_localctx).p_1_2 = expr5();
				 ((NotExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr(((NotExprContext)_localctx).p_1_2.result); 
				}
				break;
			case JID:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				((VariableExprContext)_localctx).p_2_1 = valRef();
				 ((VariableExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(((VariableExprContext)_localctx).p_2_1.result); 
				}
				break;
			case Surrogate_id_SYMB_18:
			case Surrogate_id_SYMB_21:
			case Surrogate_id_SYMB_22:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				((LiteralExprContext)_localctx).p_3_1 = literal();
				 ((LiteralExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(((LiteralExprContext)_localctx).p_3_1.result); 
				}
				break;
			case Surrogate_id_SYMB_15:
				_localctx = new Coercion_Expr5Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
				match(Surrogate_id_SYMB_15);
				setState(279);
				((Coercion_Expr5Context)_localctx).p_4_2 = expr(0);
				setState(280);
				match(Surrogate_id_SYMB_16);
				 ((Coercion_Expr5Context)_localctx).result =  ((Coercion_Expr5Context)_localctx).p_4_2.result; 
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
		enterRule(_localctx, 44, RULE_valRef);
		try {
			_localctx = new ValueRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		enterRule(_localctx, 46, RULE_listValRefFragm);
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new ListValRefFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				((ListValRefFragm_AppendLastContext)_localctx).p_1_1 = valRefFragm();
				 ((ListValRefFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); _localctx.result.addLast(((ListValRefFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListValRefFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_1 = valRefFragm();
				setState(292);
				match(Surrogate_id_SYMB_0);
				setState(293);
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
		enterRule(_localctx, 48, RULE_valRefFragm);
		try {
			_localctx = new ValueRefFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
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
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(FujureParser.Surrogate_id_SYMB_21, 0); }
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
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(FujureParser.Surrogate_id_SYMB_18, 0); }
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
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(FujureParser.Surrogate_id_SYMB_22, 0); }
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
		enterRule(_localctx, 50, RULE_literal);
		try {
			setState(313);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				((IntLiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((IntLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt(((IntLiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_22:
				_localctx = new UnitLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(Surrogate_id_SYMB_22);
				 ((UnitLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_21:
				_localctx = new BoolTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(Surrogate_id_SYMB_21);
				 ((BoolTrueLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_18:
				_localctx = new BoolFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				match(Surrogate_id_SYMB_18);
				 ((BoolFalseLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(309);
				((CharLiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((CharLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(((CharLiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
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
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr3_sempred(Expr3Context _localctx, int predIndex) {
		switch (predIndex) {
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
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u013e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2A\n\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f}\n\f\f\f\16\f\u0080\13\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0099\n\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a6\n\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00b4\n\22\f\22\16\22\u00b7"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c2\n\23\f"+
		"\23\16\23\u00c5\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u00df\n\24\f\24\16\24\u00e2\13\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f2\n\25\f\25\16\25\u00f5"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u010a\n\26\f\26\16\26\u010d\13\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u011e\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u012b\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u013c\n\33\3\33\2\t\f\26\"$&(*\34\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\2\u0140\2@\3\2\2"+
		"\2\4B\3\2\2\2\6M\3\2\2\2\bO\3\2\2\2\nR\3\2\2\2\fU\3\2\2\2\16a\3\2\2\2"+
		"\20m\3\2\2\2\22o\3\2\2\2\24r\3\2\2\2\26u\3\2\2\2\30\u0081\3\2\2\2\32\u0098"+
		"\3\2\2\2\34\u009a\3\2\2\2\36\u00a5\3\2\2\2 \u00a7\3\2\2\2\"\u00aa\3\2"+
		"\2\2$\u00b8\3\2\2\2&\u00c6\3\2\2\2(\u00e3\3\2\2\2*\u00f6\3\2\2\2,\u011d"+
		"\3\2\2\2.\u011f\3\2\2\2\60\u012a\3\2\2\2\62\u012c\3\2\2\2\64\u013b\3\2"+
		"\2\2\66\67\7\27\2\2\678\5\4\3\289\5\n\6\29:\5\24\13\2:;\b\2\1\2;A\3\2"+
		"\2\2<=\5\n\6\2=>\5\24\13\2>?\b\2\1\2?A\3\2\2\2@\66\3\2\2\2@<\3\2\2\2A"+
		"\3\3\2\2\2BC\5\6\4\2CD\b\3\1\2D\5\3\2\2\2EF\5\b\5\2FG\b\4\1\2GN\3\2\2"+
		"\2HI\5\b\5\2IJ\7\3\2\2JK\5\6\4\2KL\b\4\1\2LN\3\2\2\2ME\3\2\2\2MH\3\2\2"+
		"\2N\7\3\2\2\2OP\7\32\2\2PQ\b\5\1\2Q\t\3\2\2\2RS\5\f\7\2ST\b\6\1\2T\13"+
		"\3\2\2\2UV\b\7\1\2VW\b\7\1\2W^\3\2\2\2XY\f\3\2\2YZ\5\16\b\2Z[\b\7\1\2"+
		"[]\3\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\r\3\2\2\2`^\3\2"+
		"\2\2ab\7\26\2\2bc\5\20\t\2cd\b\b\1\2d\17\3\2\2\2ef\5\22\n\2fg\b\t\1\2"+
		"gn\3\2\2\2hi\5\22\n\2ij\7\3\2\2jk\5\20\t\2kl\b\t\1\2ln\3\2\2\2me\3\2\2"+
		"\2mh\3\2\2\2n\21\3\2\2\2op\7\32\2\2pq\b\n\1\2q\23\3\2\2\2rs\5\26\f\2s"+
		"t\b\13\1\2t\25\3\2\2\2uv\b\f\1\2vw\b\f\1\2w~\3\2\2\2xy\f\3\2\2yz\5\30"+
		"\r\2z{\b\f\1\2{}\3\2\2\2|x\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2"+
		"\2\177\27\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\24\2\2\u0082\u0083\5\32"+
		"\16\2\u0083\u0084\b\r\1\2\u0084\31\3\2\2\2\u0085\u0086\7\32\2\2\u0086"+
		"\u0099\b\16\1\2\u0087\u0088\7\32\2\2\u0088\u0089\7\4\2\2\u0089\u008a\5"+
		"\34\17\2\u008a\u008b\b\16\1\2\u008b\u0099\3\2\2\2\u008c\u008d\7\32\2\2"+
		"\u008d\u008e\7\5\2\2\u008e\u008f\5\"\22\2\u008f\u0090\b\16\1\2\u0090\u0099"+
		"\3\2\2\2\u0091\u0092\7\32\2\2\u0092\u0093\7\4\2\2\u0093\u0094\5\34\17"+
		"\2\u0094\u0095\7\5\2\2\u0095\u0096\5\"\22\2\u0096\u0097\b\16\1\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0085\3\2\2\2\u0098\u0087\3\2\2\2\u0098\u008c\3\2"+
		"\2\2\u0098\u0091\3\2\2\2\u0099\33\3\2\2\2\u009a\u009b\5\36\20\2\u009b"+
		"\u009c\b\17\1\2\u009c\35\3\2\2\2\u009d\u009e\5 \21\2\u009e\u009f\b\20"+
		"\1\2\u009f\u00a6\3\2\2\2\u00a0\u00a1\5 \21\2\u00a1\u00a2\7\3\2\2\u00a2"+
		"\u00a3\5\36\20\2\u00a3\u00a4\b\20\1\2\u00a4\u00a6\3\2\2\2\u00a5\u009d"+
		"\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a6\37\3\2\2\2\u00a7\u00a8\7\32\2\2\u00a8"+
		"\u00a9\b\21\1\2\u00a9!\3\2\2\2\u00aa\u00ab\b\22\1\2\u00ab\u00ac\5$\23"+
		"\2\u00ac\u00ad\b\22\1\2\u00ad\u00b5\3\2\2\2\u00ae\u00af\f\4\2\2\u00af"+
		"\u00b0\7\6\2\2\u00b0\u00b1\5$\23\2\u00b1\u00b2\b\22\1\2\u00b2\u00b4\3"+
		"\2\2\2\u00b3\u00ae\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6#\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\b\23\1\2"+
		"\u00b9\u00ba\5&\24\2\u00ba\u00bb\b\23\1\2\u00bb\u00c3\3\2\2\2\u00bc\u00bd"+
		"\f\4\2\2\u00bd\u00be\7\7\2\2\u00be\u00bf\5&\24\2\u00bf\u00c0\b\23\1\2"+
		"\u00c0\u00c2\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4%\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c7\b\24\1\2\u00c7\u00c8\5(\25\2\u00c8\u00c9\b\24\1\2\u00c9\u00e0\3"+
		"\2\2\2\u00ca\u00cb\f\7\2\2\u00cb\u00cc\7\b\2\2\u00cc\u00cd\5(\25\2\u00cd"+
		"\u00ce\b\24\1\2\u00ce\u00df\3\2\2\2\u00cf\u00d0\f\6\2\2\u00d0\u00d1\7"+
		"\t\2\2\u00d1\u00d2\5(\25\2\u00d2\u00d3\b\24\1\2\u00d3\u00df\3\2\2\2\u00d4"+
		"\u00d5\f\5\2\2\u00d5\u00d6\7\n\2\2\u00d6\u00d7\5(\25\2\u00d7\u00d8\b\24"+
		"\1\2\u00d8\u00df\3\2\2\2\u00d9\u00da\f\4\2\2\u00da\u00db\7\13\2\2\u00db"+
		"\u00dc\5(\25\2\u00dc\u00dd\b\24\1\2\u00dd\u00df\3\2\2\2\u00de\u00ca\3"+
		"\2\2\2\u00de\u00cf\3\2\2\2\u00de\u00d4\3\2\2\2\u00de\u00d9\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\'\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e3\u00e4\b\25\1\2\u00e4\u00e5\5*\26\2\u00e5\u00e6"+
		"\b\25\1\2\u00e6\u00f3\3\2\2\2\u00e7\u00e8\f\5\2\2\u00e8\u00e9\7\f\2\2"+
		"\u00e9\u00ea\5*\26\2\u00ea\u00eb\b\25\1\2\u00eb\u00f2\3\2\2\2\u00ec\u00ed"+
		"\f\4\2\2\u00ed\u00ee\7\r\2\2\u00ee\u00ef\5*\26\2\u00ef\u00f0\b\25\1\2"+
		"\u00f0\u00f2\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2\u00f5"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4)\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\b\26\1\2\u00f7\u00f8\5,\27\2\u00f8\u00f9\b"+
		"\26\1\2\u00f9\u010b\3\2\2\2\u00fa\u00fb\f\6\2\2\u00fb\u00fc\7\16\2\2\u00fc"+
		"\u00fd\5,\27\2\u00fd\u00fe\b\26\1\2\u00fe\u010a\3\2\2\2\u00ff\u0100\f"+
		"\5\2\2\u0100\u0101\7\17\2\2\u0101\u0102\5,\27\2\u0102\u0103\b\26\1\2\u0103"+
		"\u010a\3\2\2\2\u0104\u0105\f\4\2\2\u0105\u0106\7\20\2\2\u0106\u0107\5"+
		",\27\2\u0107\u0108\b\26\1\2\u0108\u010a\3\2\2\2\u0109\u00fa\3\2\2\2\u0109"+
		"\u00ff\3\2\2\2\u0109\u0104\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c+\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f"+
		"\7\21\2\2\u010f\u0110\5,\27\2\u0110\u0111\b\27\1\2\u0111\u011e\3\2\2\2"+
		"\u0112\u0113\5.\30\2\u0113\u0114\b\27\1\2\u0114\u011e\3\2\2\2\u0115\u0116"+
		"\5\64\33\2\u0116\u0117\b\27\1\2\u0117\u011e\3\2\2\2\u0118\u0119\7\22\2"+
		"\2\u0119\u011a\5\"\22\2\u011a\u011b\7\23\2\2\u011b\u011c\b\27\1\2\u011c"+
		"\u011e\3\2\2\2\u011d\u010e\3\2\2\2\u011d\u0112\3\2\2\2\u011d\u0115\3\2"+
		"\2\2\u011d\u0118\3\2\2\2\u011e-\3\2\2\2\u011f\u0120\5\60\31\2\u0120\u0121"+
		"\b\30\1\2\u0121/\3\2\2\2\u0122\u0123\5\62\32\2\u0123\u0124\b\31\1\2\u0124"+
		"\u012b\3\2\2\2\u0125\u0126\5\62\32\2\u0126\u0127\7\3\2\2\u0127\u0128\5"+
		"\60\31\2\u0128\u0129\b\31\1\2\u0129\u012b\3\2\2\2\u012a\u0122\3\2\2\2"+
		"\u012a\u0125\3\2\2\2\u012b\61\3\2\2\2\u012c\u012d\7\32\2\2\u012d\u012e"+
		"\b\32\1\2\u012e\63\3\2\2\2\u012f\u0130\7\35\2\2\u0130\u013c\b\33\1\2\u0131"+
		"\u0132\7\31\2\2\u0132\u013c\b\33\1\2\u0133\u0134\7\30\2\2\u0134\u013c"+
		"\b\33\1\2\u0135\u0136\7\25\2\2\u0136\u013c\b\33\1\2\u0137\u0138\7\33\2"+
		"\2\u0138\u013c\b\33\1\2\u0139\u013a\7\34\2\2\u013a\u013c\b\33\1\2\u013b"+
		"\u012f\3\2\2\2\u013b\u0131\3\2\2\2\u013b\u0133\3\2\2\2\u013b\u0135\3\2"+
		"\2\2\u013b\u0137\3\2\2\2\u013b\u0139\3\2\2\2\u013c\65\3\2\2\2\24@M^m~"+
		"\u0098\u00a5\u00b5\u00c3\u00de\u00e0\u00f1\u00f3\u0109\u010b\u011d\u012a"+
		"\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}