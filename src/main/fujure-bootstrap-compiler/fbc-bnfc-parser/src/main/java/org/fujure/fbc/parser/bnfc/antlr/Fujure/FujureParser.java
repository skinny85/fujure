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
		Surrogate_id_SYMB_8=9, JID=10, JCHAR=11, JSTRING=12, INTEGER=13, WS=14, 
		ErrorToken=15;
	public static final int
		RULE_fileContents = 0, RULE_pkgName = 1, RULE_listPkgFragm = 2, RULE_pkgFragm = 3, 
		RULE_imports = 4, RULE_listImport = 5, RULE_import_ = 6, RULE_listImportFragm = 7, 
		RULE_importFragm = 8, RULE_defs = 9, RULE_listDef = 10, RULE_def = 11, 
		RULE_binding = 12, RULE_typeSpec = 13, RULE_listTypeSpecFragm = 14, RULE_typeSpecFragm = 15, 
		RULE_expr = 16, RULE_valRef = 17, RULE_listValRefFragm = 18, RULE_valRefFragm = 19, 
		RULE_literal = 20;
	public static final String[] ruleNames = {
		"fileContents", "pkgName", "listPkgFragm", "pkgFragm", "imports", "listImport", 
		"import_", "listImportFragm", "importFragm", "defs", "listDef", "def", 
		"binding", "typeSpec", "listTypeSpecFragm", "typeSpecFragm", "expr", "valRef", 
		"listValRefFragm", "valRefFragm", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "'def'", "'false'", "'import'", "'package'", 
		"'true'", "'unit'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
		"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", "Surrogate_id_SYMB_6", 
		"Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", "JID", "JCHAR", "JSTRING", 
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
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
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
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(Surrogate_id_SYMB_6);
				setState(43);
				((FileInNamedPackageContext)_localctx).p_1_2 = pkgName();
				setState(44);
				((FileInNamedPackageContext)_localctx).p_1_3 = imports();
				setState(45);
				((FileInNamedPackageContext)_localctx).p_1_4 = defs();
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result,((FileInNamedPackageContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				((FileInDefaultPackageContext)_localctx).p_2_1 = imports();
				setState(49);
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
			setState(54);
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
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(61);
				match(Surrogate_id_SYMB_0);
				setState(62);
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
			setState(67);
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
			setState(70);
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
			setState(82);
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
					setState(76);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(77);
					((ListImport_PrependFirstContext)_localctx).p_2_2 = import_();
					 ((ListImport_PrependFirstContext)_localctx).result =  ((ListImport_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImport_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(84);
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
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
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
			setState(85);
			match(Surrogate_id_SYMB_5);
			setState(86);
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
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ListImportFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((ListImportFragm_AppendLastContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListImportFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_1 = importFragm();
				setState(93);
				match(Surrogate_id_SYMB_0);
				setState(94);
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
			setState(99);
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
			setState(102);
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
			setState(114);
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
					setState(108);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(109);
					((ListDef_PrependFirstContext)_localctx).p_2_2 = def();
					 ((ListDef_PrependFirstContext)_localctx).result =  ((ListDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(116);
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
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
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
			setState(117);
			match(Surrogate_id_SYMB_3);
			setState(118);
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
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OnlyNameBindingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((OnlyNameBindingContext)_localctx).p_1_1 = match(JID);
				 ((OnlyNameBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(((OnlyNameBindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				_localctx = new NameTypeBindingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				((NameTypeBindingContext)_localctx).p_2_1 = match(JID);
				setState(124);
				match(Surrogate_id_SYMB_1);
				setState(125);
				((NameTypeBindingContext)_localctx).p_2_3 = typeSpec();
				 ((NameTypeBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(((NameTypeBindingContext)_localctx).p_2_1.getText(),((NameTypeBindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				_localctx = new NameInitBindingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				((NameInitBindingContext)_localctx).p_3_1 = match(JID);
				setState(129);
				match(Surrogate_id_SYMB_2);
				setState(130);
				((NameInitBindingContext)_localctx).p_3_3 = expr();
				 ((NameInitBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(((NameInitBindingContext)_localctx).p_3_1.getText(),((NameInitBindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new FullBindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				((FullBindingContext)_localctx).p_4_1 = match(JID);
				setState(134);
				match(Surrogate_id_SYMB_1);
				setState(135);
				((FullBindingContext)_localctx).p_4_3 = typeSpec();
				setState(136);
				match(Surrogate_id_SYMB_2);
				setState(137);
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
			setState(142);
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
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListTypeSpecFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1 = typeSpecFragm();
				 ((ListTypeSpecFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); _localctx.result.addLast(((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListTypeSpecFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_1 = typeSpecFragm();
				setState(149);
				match(Surrogate_id_SYMB_0);
				setState(150);
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
			setState(155);
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
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext p_2_1;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitLiteralExpr(this);
		}
	}
	public static class VariableExprContext extends ExprContext {
		public ValRefContext p_1_1;
		public ValRefContext valRef() {
			return getRuleContext(ValRefContext.class,0);
		}
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FujureParserListener ) ((FujureParserListener)listener).exitVariableExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case JID:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((VariableExprContext)_localctx).p_1_1 = valRef();
				 ((VariableExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(((VariableExprContext)_localctx).p_1_1.result); 
				}
				break;
			case Surrogate_id_SYMB_4:
			case Surrogate_id_SYMB_7:
			case Surrogate_id_SYMB_8:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				((LiteralExprContext)_localctx).p_2_1 = literal();
				 ((LiteralExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(((LiteralExprContext)_localctx).p_2_1.result); 
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
		enterRule(_localctx, 34, RULE_valRef);
		try {
			_localctx = new ValueRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
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
		enterRule(_localctx, 36, RULE_listValRefFragm);
		try {
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ListValRefFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((ListValRefFragm_AppendLastContext)_localctx).p_1_1 = valRefFragm();
				 ((ListValRefFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); _localctx.result.addLast(((ListValRefFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListValRefFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_1 = valRefFragm();
				setState(173);
				match(Surrogate_id_SYMB_0);
				setState(174);
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
		enterRule(_localctx, 38, RULE_valRefFragm);
		try {
			_localctx = new ValueRefFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(FujureParser.Surrogate_id_SYMB_7, 0); }
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
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
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
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(FujureParser.Surrogate_id_SYMB_8, 0); }
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
		enterRule(_localctx, 40, RULE_literal);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				((IntLiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((IntLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt(((IntLiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_8:
				_localctx = new UnitLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(Surrogate_id_SYMB_8);
				 ((UnitLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_7:
				_localctx = new BoolTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(Surrogate_id_SYMB_7);
				 ((BoolTrueLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_4:
				_localctx = new BoolFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				match(Surrogate_id_SYMB_4);
				 ((BoolFalseLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				((CharLiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((CharLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(((CharLiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\u00c7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2\67\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"D\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7\f\7"+
		"\16\7V\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fs\n\f\f\f\16"+
		"\fv\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008f\n\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009c\n\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a7\n\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b4\n\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00c5"+
		"\n\26\3\26\2\4\f\26\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2"+
		"\2\u00c1\2\66\3\2\2\2\48\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nH\3\2\2\2\fK\3"+
		"\2\2\2\16W\3\2\2\2\20c\3\2\2\2\22e\3\2\2\2\24h\3\2\2\2\26k\3\2\2\2\30"+
		"w\3\2\2\2\32\u008e\3\2\2\2\34\u0090\3\2\2\2\36\u009b\3\2\2\2 \u009d\3"+
		"\2\2\2\"\u00a6\3\2\2\2$\u00a8\3\2\2\2&\u00b3\3\2\2\2(\u00b5\3\2\2\2*\u00c4"+
		"\3\2\2\2,-\7\t\2\2-.\5\4\3\2./\5\n\6\2/\60\5\24\13\2\60\61\b\2\1\2\61"+
		"\67\3\2\2\2\62\63\5\n\6\2\63\64\5\24\13\2\64\65\b\2\1\2\65\67\3\2\2\2"+
		"\66,\3\2\2\2\66\62\3\2\2\2\67\3\3\2\2\289\5\6\4\29:\b\3\1\2:\5\3\2\2\2"+
		";<\5\b\5\2<=\b\4\1\2=D\3\2\2\2>?\5\b\5\2?@\7\3\2\2@A\5\6\4\2AB\b\4\1\2"+
		"BD\3\2\2\2C;\3\2\2\2C>\3\2\2\2D\7\3\2\2\2EF\7\f\2\2FG\b\5\1\2G\t\3\2\2"+
		"\2HI\5\f\7\2IJ\b\6\1\2J\13\3\2\2\2KL\b\7\1\2LM\b\7\1\2MT\3\2\2\2NO\f\3"+
		"\2\2OP\5\16\b\2PQ\b\7\1\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3"+
		"\2\2\2U\r\3\2\2\2VT\3\2\2\2WX\7\b\2\2XY\5\20\t\2YZ\b\b\1\2Z\17\3\2\2\2"+
		"[\\\5\22\n\2\\]\b\t\1\2]d\3\2\2\2^_\5\22\n\2_`\7\3\2\2`a\5\20\t\2ab\b"+
		"\t\1\2bd\3\2\2\2c[\3\2\2\2c^\3\2\2\2d\21\3\2\2\2ef\7\f\2\2fg\b\n\1\2g"+
		"\23\3\2\2\2hi\5\26\f\2ij\b\13\1\2j\25\3\2\2\2kl\b\f\1\2lm\b\f\1\2mt\3"+
		"\2\2\2no\f\3\2\2op\5\30\r\2pq\b\f\1\2qs\3\2\2\2rn\3\2\2\2sv\3\2\2\2tr"+
		"\3\2\2\2tu\3\2\2\2u\27\3\2\2\2vt\3\2\2\2wx\7\6\2\2xy\5\32\16\2yz\b\r\1"+
		"\2z\31\3\2\2\2{|\7\f\2\2|\u008f\b\16\1\2}~\7\f\2\2~\177\7\4\2\2\177\u0080"+
		"\5\34\17\2\u0080\u0081\b\16\1\2\u0081\u008f\3\2\2\2\u0082\u0083\7\f\2"+
		"\2\u0083\u0084\7\5\2\2\u0084\u0085\5\"\22\2\u0085\u0086\b\16\1\2\u0086"+
		"\u008f\3\2\2\2\u0087\u0088\7\f\2\2\u0088\u0089\7\4\2\2\u0089\u008a\5\34"+
		"\17\2\u008a\u008b\7\5\2\2\u008b\u008c\5\"\22\2\u008c\u008d\b\16\1\2\u008d"+
		"\u008f\3\2\2\2\u008e{\3\2\2\2\u008e}\3\2\2\2\u008e\u0082\3\2\2\2\u008e"+
		"\u0087\3\2\2\2\u008f\33\3\2\2\2\u0090\u0091\5\36\20\2\u0091\u0092\b\17"+
		"\1\2\u0092\35\3\2\2\2\u0093\u0094\5 \21\2\u0094\u0095\b\20\1\2\u0095\u009c"+
		"\3\2\2\2\u0096\u0097\5 \21\2\u0097\u0098\7\3\2\2\u0098\u0099\5\36\20\2"+
		"\u0099\u009a\b\20\1\2\u009a\u009c\3\2\2\2\u009b\u0093\3\2\2\2\u009b\u0096"+
		"\3\2\2\2\u009c\37\3\2\2\2\u009d\u009e\7\f\2\2\u009e\u009f\b\21\1\2\u009f"+
		"!\3\2\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2\b\22\1\2\u00a2\u00a7\3\2\2\2"+
		"\u00a3\u00a4\5*\26\2\u00a4\u00a5\b\22\1\2\u00a5\u00a7\3\2\2\2\u00a6\u00a0"+
		"\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7#\3\2\2\2\u00a8\u00a9\5&\24\2\u00a9"+
		"\u00aa\b\23\1\2\u00aa%\3\2\2\2\u00ab\u00ac\5(\25\2\u00ac\u00ad\b\24\1"+
		"\2\u00ad\u00b4\3\2\2\2\u00ae\u00af\5(\25\2\u00af\u00b0\7\3\2\2\u00b0\u00b1"+
		"\5&\24\2\u00b1\u00b2\b\24\1\2\u00b2\u00b4\3\2\2\2\u00b3\u00ab\3\2\2\2"+
		"\u00b3\u00ae\3\2\2\2\u00b4\'\3\2\2\2\u00b5\u00b6\7\f\2\2\u00b6\u00b7\b"+
		"\25\1\2\u00b7)\3\2\2\2\u00b8\u00b9\7\17\2\2\u00b9\u00c5\b\26\1\2\u00ba"+
		"\u00bb\7\13\2\2\u00bb\u00c5\b\26\1\2\u00bc\u00bd\7\n\2\2\u00bd\u00c5\b"+
		"\26\1\2\u00be\u00bf\7\7\2\2\u00bf\u00c5\b\26\1\2\u00c0\u00c1\7\r\2\2\u00c1"+
		"\u00c5\b\26\1\2\u00c2\u00c3\7\16\2\2\u00c3\u00c5\b\26\1\2\u00c4\u00b8"+
		"\3\2\2\2\u00c4\u00ba\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4"+
		"\u00c0\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5+\3\2\2\2\f\66CTct\u008e\u009b"+
		"\u00a6\u00b3\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}