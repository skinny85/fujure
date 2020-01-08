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
		Surrogate_id_SYMB_29=30, Surrogate_id_SYMB_30=31, JID=32, JCHAR=33, JSTRING=34, 
		INTEGER=35, WS=36, ErrorToken=37;
	public static final int
		RULE_fileContents = 0, RULE_pkgName = 1, RULE_listPkgFragm = 2, RULE_pkgFragm = 3, 
		RULE_imports = 4, RULE_listImport = 5, RULE_import_ = 6, RULE_listImportFragm = 7, 
		RULE_importFragm = 8, RULE_defs = 9, RULE_listDef = 10, RULE_def = 11, 
		RULE_binding = 12, RULE_typeSpec = 13, RULE_listTypeSpecFragm = 14, RULE_typeSpecFragm = 15, 
		RULE_expr = 16, RULE_letDef = 17, RULE_listLetDef = 18, RULE_expr1 = 19, 
		RULE_expr2 = 20, RULE_expr3 = 21, RULE_expr4 = 22, RULE_expr5 = 23, RULE_expr6 = 24, 
		RULE_expr7 = 25, RULE_expr8 = 26, RULE_callArg = 27, RULE_listCallArg = 28, 
		RULE_valRef = 29, RULE_listValRefFragm = 30, RULE_valRefFragm = 31, RULE_literal = 32;
	public static final String[] ruleNames = {
		"fileContents", "pkgName", "listPkgFragm", "pkgFragm", "imports", "listImport", 
		"import_", "listImportFragm", "importFragm", "defs", "listDef", "def", 
		"binding", "typeSpec", "listTypeSpecFragm", "typeSpecFragm", "expr", "letDef", 
		"listLetDef", "expr1", "expr2", "expr3", "expr4", "expr5", "expr6", "expr7", 
		"expr8", "callArg", "listCallArg", "valRef", "listValRefFragm", "valRefFragm", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':'", "'='", "','", "'||'", "'&&'", "'=='", "'!='", "'<'", 
		"'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'('", 
		"')'", "'def'", "'else'", "'false'", "'if'", "'import'", "'in'", "'let'", 
		"'package'", "'then'", "'true'", "'unit'"
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
		"Surrogate_id_SYMB_29", "Surrogate_id_SYMB_30", "JID", "JCHAR", "JSTRING", 
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
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(FujureParser.Surrogate_id_SYMB_27, 0); }
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
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new FileInNamedPackageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(Surrogate_id_SYMB_27);
				setState(67);
				((FileInNamedPackageContext)_localctx).p_1_2 = pkgName();
				setState(68);
				((FileInNamedPackageContext)_localctx).p_1_3 = imports();
				setState(69);
				((FileInNamedPackageContext)_localctx).p_1_4 = defs();
				 ((FileInNamedPackageContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage(((FileInNamedPackageContext)_localctx).p_1_2.result,((FileInNamedPackageContext)_localctx).p_1_3.result,((FileInNamedPackageContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				_localctx = new FileInDefaultPackageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((FileInDefaultPackageContext)_localctx).p_2_1 = imports();
				setState(73);
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
			setState(78);
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
			setState(89);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ListPkgFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((ListPkgFragm_AppendLastContext)_localctx).p_1_1 = pkgFragm();
				 ((ListPkgFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListPkgFragm(); _localctx.result.addLast(((ListPkgFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListPkgFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((ListPkgFragm_PrependFirstContext)_localctx).p_2_1 = pkgFragm();
				setState(85);
				match(Surrogate_id_SYMB_0);
				setState(86);
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
			setState(91);
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
			setState(94);
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
			setState(106);
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
					setState(100);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(101);
					((ListImport_PrependFirstContext)_localctx).p_2_2 = import_();
					 ((ListImport_PrependFirstContext)_localctx).result =  ((ListImport_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListImport_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(108);
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
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(FujureParser.Surrogate_id_SYMB_24, 0); }
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
			setState(109);
			match(Surrogate_id_SYMB_24);
			setState(110);
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
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ListImportFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				((ListImportFragm_AppendLastContext)_localctx).p_1_1 = importFragm();
				 ((ListImportFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListImportFragm(); _localctx.result.addLast(((ListImportFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListImportFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((ListImportFragm_PrependFirstContext)_localctx).p_2_1 = importFragm();
				setState(117);
				match(Surrogate_id_SYMB_0);
				setState(118);
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
			setState(123);
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
			setState(126);
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
			setState(138);
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
					setState(132);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(133);
					((ListDef_PrependFirstContext)_localctx).p_2_2 = def();
					 ((ListDef_PrependFirstContext)_localctx).result =  ((ListDef_PrependFirstContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDef_PrependFirstContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(140);
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
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(FujureParser.Surrogate_id_SYMB_20, 0); }
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
			setState(141);
			match(Surrogate_id_SYMB_20);
			setState(142);
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
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OnlyNameBindingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((OnlyNameBindingContext)_localctx).p_1_1 = match(JID);
				 ((OnlyNameBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OnlyNameBinding(((OnlyNameBindingContext)_localctx).p_1_1.getText()); 
				}
				break;
			case 2:
				_localctx = new NameTypeBindingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				((NameTypeBindingContext)_localctx).p_2_1 = match(JID);
				setState(148);
				match(Surrogate_id_SYMB_1);
				setState(149);
				((NameTypeBindingContext)_localctx).p_2_3 = typeSpec();
				 ((NameTypeBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameTypeBinding(((NameTypeBindingContext)_localctx).p_2_1.getText(),((NameTypeBindingContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				_localctx = new NameInitBindingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				((NameInitBindingContext)_localctx).p_3_1 = match(JID);
				setState(153);
				match(Surrogate_id_SYMB_2);
				setState(154);
				((NameInitBindingContext)_localctx).p_3_3 = expr();
				 ((NameInitBindingContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NameInitBinding(((NameInitBindingContext)_localctx).p_3_1.getText(),((NameInitBindingContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new FullBindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				((FullBindingContext)_localctx).p_4_1 = match(JID);
				setState(158);
				match(Surrogate_id_SYMB_1);
				setState(159);
				((FullBindingContext)_localctx).p_4_3 = typeSpec();
				setState(160);
				match(Surrogate_id_SYMB_2);
				setState(161);
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
			setState(166);
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
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ListTypeSpecFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1 = typeSpecFragm();
				 ((ListTypeSpecFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListTypeSpecFragm(); _localctx.result.addLast(((ListTypeSpecFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListTypeSpecFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				((ListTypeSpecFragm_PrependFirstContext)_localctx).p_2_1 = typeSpecFragm();
				setState(173);
				match(Surrogate_id_SYMB_0);
				setState(174);
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
			setState(179);
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
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(FujureParser.Surrogate_id_SYMB_23, 0); }
		public TerminalNode Surrogate_id_SYMB_28() { return getToken(FujureParser.Surrogate_id_SYMB_28, 0); }
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(FujureParser.Surrogate_id_SYMB_21, 0); }
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
		public TerminalNode Surrogate_id_SYMB_26() { return getToken(FujureParser.Surrogate_id_SYMB_26, 0); }
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(FujureParser.Surrogate_id_SYMB_25, 0); }
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
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(199);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_23:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(Surrogate_id_SYMB_23);
				setState(183);
				((IfExprContext)_localctx).p_1_2 = expr();
				setState(184);
				match(Surrogate_id_SYMB_28);
				setState(185);
				((IfExprContext)_localctx).p_1_4 = expr();
				setState(186);
				match(Surrogate_id_SYMB_21);
				setState(187);
				((IfExprContext)_localctx).p_1_6 = expr();
				 ((IfExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IfExpr(((IfExprContext)_localctx).p_1_2.result,((IfExprContext)_localctx).p_1_4.result,((IfExprContext)_localctx).p_1_6.result); 
				}
				break;
			case Surrogate_id_SYMB_26:
				_localctx = new LetExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(Surrogate_id_SYMB_26);
				setState(191);
				((LetExprContext)_localctx).p_2_2 = listLetDef();
				setState(192);
				match(Surrogate_id_SYMB_25);
				setState(193);
				((LetExprContext)_localctx).p_2_4 = expr();
				 ((LetExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LetExpr(((LetExprContext)_localctx).p_2_2.result,((LetExprContext)_localctx).p_2_4.result); 
				}
				break;
			case Surrogate_id_SYMB_12:
			case Surrogate_id_SYMB_13:
			case Surrogate_id_SYMB_17:
			case Surrogate_id_SYMB_18:
			case Surrogate_id_SYMB_22:
			case Surrogate_id_SYMB_29:
			case Surrogate_id_SYMB_30:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new Coercion_ExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
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
		enterRule(_localctx, 34, RULE_letDef);
		try {
			_localctx = new LetDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
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
		enterRule(_localctx, 36, RULE_listLetDef);
		try {
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new ListLetDef_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((ListLetDef_AppendLastContext)_localctx).p_1_1 = letDef();
				 ((ListLetDef_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListLetDef(); _localctx.result.addLast(((ListLetDef_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListLetDef_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				((ListLetDef_PrependFirstContext)_localctx).p_2_1 = letDef();
				setState(208);
				match(Surrogate_id_SYMB_3);
				setState(209);
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
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(FujureParser.Surrogate_id_SYMB_4, 0); }
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr1Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(215);
			((Coercion_Expr1Context)_localctx).p_2_1 = expr2(0);
			 ((Coercion_Expr1Context)_localctx).result =  ((Coercion_Expr1Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(new Expr1Context(_parentctx, _parentState));
					((OrExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(218);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(219);
					match(Surrogate_id_SYMB_4);
					setState(220);
					((OrExprContext)_localctx).p_1_3 = expr2(0);
					 ((OrExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.OrExpr(((OrExprContext)_localctx).p_1_1.result,((OrExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(FujureParser.Surrogate_id_SYMB_5, 0); }
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(229);
			((Coercion_Expr2Context)_localctx).p_2_1 = expr3(0);
			 ((Coercion_Expr2Context)_localctx).result =  ((Coercion_Expr2Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(new Expr2Context(_parentctx, _parentState));
					((AndExprContext)_localctx).p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(232);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(233);
					match(Surrogate_id_SYMB_5);
					setState(234);
					((AndExprContext)_localctx).p_1_3 = expr3(0);
					 ((AndExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AndExpr(((AndExprContext)_localctx).p_1_1.result,((AndExprContext)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(241);
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
	public static class EqualityExprContext extends Expr3Context {
		public Expr3Context p_1_1;
		public Expr4Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(FujureParser.Surrogate_id_SYMB_6, 0); }
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
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(FujureParser.Surrogate_id_SYMB_7, 0); }
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr3Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(243);
			((Coercion_Expr3Context)_localctx).p_3_1 = expr4(0);
			 ((Coercion_Expr3Context)_localctx).result =  ((Coercion_Expr3Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExprContext(new Expr3Context(_parentctx, _parentState));
						((EqualityExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(246);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(247);
						match(Surrogate_id_SYMB_6);
						setState(248);
						((EqualityExprContext)_localctx).p_1_3 = expr4(0);
						 ((EqualityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.EqualityExpr(((EqualityExprContext)_localctx).p_1_1.result,((EqualityExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new InequalityExprContext(new Expr3Context(_parentctx, _parentState));
						((InequalityExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(251);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(252);
						match(Surrogate_id_SYMB_7);
						setState(253);
						((InequalityExprContext)_localctx).p_2_3 = expr4(0);
						 ((InequalityExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.InequalityExpr(((InequalityExprContext)_localctx).p_2_1.result,((InequalityExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(260);
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
	public static class LesserEqualExprContext extends Expr4Context {
		public Expr4Context p_2_1;
		public Expr5Context p_2_3;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(FujureParser.Surrogate_id_SYMB_9, 0); }
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
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(FujureParser.Surrogate_id_SYMB_10, 0); }
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
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(FujureParser.Surrogate_id_SYMB_8, 0); }
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
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(FujureParser.Surrogate_id_SYMB_11, 0); }
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr4Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(262);
			((Coercion_Expr4Context)_localctx).p_5_1 = expr5(0);
			 ((Coercion_Expr4Context)_localctx).result =  ((Coercion_Expr4Context)_localctx).p_5_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(285);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new LesserExprContext(new Expr4Context(_parentctx, _parentState));
						((LesserExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(265);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(266);
						match(Surrogate_id_SYMB_8);
						setState(267);
						((LesserExprContext)_localctx).p_1_3 = expr5(0);
						 ((LesserExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserExpr(((LesserExprContext)_localctx).p_1_1.result,((LesserExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new LesserEqualExprContext(new Expr4Context(_parentctx, _parentState));
						((LesserEqualExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(270);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(271);
						match(Surrogate_id_SYMB_9);
						setState(272);
						((LesserEqualExprContext)_localctx).p_2_3 = expr5(0);
						 ((LesserEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LesserEqualExpr(((LesserEqualExprContext)_localctx).p_2_1.result,((LesserEqualExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new GreaterExprContext(new Expr4Context(_parentctx, _parentState));
						((GreaterExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(275);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(276);
						match(Surrogate_id_SYMB_10);
						setState(277);
						((GreaterExprContext)_localctx).p_3_3 = expr5(0);
						 ((GreaterExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterExpr(((GreaterExprContext)_localctx).p_3_1.result,((GreaterExprContext)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new GreaterEqualExprContext(new Expr4Context(_parentctx, _parentState));
						((GreaterEqualExprContext)_localctx).p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr4);
						setState(280);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(281);
						match(Surrogate_id_SYMB_11);
						setState(282);
						((GreaterEqualExprContext)_localctx).p_4_3 = expr5(0);
						 ((GreaterEqualExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.GreaterEqualExpr(((GreaterEqualExprContext)_localctx).p_4_1.result,((GreaterEqualExprContext)_localctx).p_4_3.result); 
						}
						break;
					}
					} 
				}
				setState(289);
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
	public static class AdditionExprContext extends Expr5Context {
		public Expr5Context p_1_1;
		public Expr6Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(FujureParser.Surrogate_id_SYMB_12, 0); }
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
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(FujureParser.Surrogate_id_SYMB_13, 0); }
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr5Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(291);
			((Coercion_Expr5Context)_localctx).p_3_1 = expr6(0);
			 ((Coercion_Expr5Context)_localctx).result =  ((Coercion_Expr5Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(304);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionExprContext(new Expr5Context(_parentctx, _parentState));
						((AdditionExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(294);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(295);
						match(Surrogate_id_SYMB_12);
						setState(296);
						((AdditionExprContext)_localctx).p_1_3 = expr6(0);
						 ((AdditionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.AdditionExpr(((AdditionExprContext)_localctx).p_1_1.result,((AdditionExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new SubtractionExprContext(new Expr5Context(_parentctx, _parentState));
						((SubtractionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr5);
						setState(299);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(300);
						match(Surrogate_id_SYMB_13);
						setState(301);
						((SubtractionExprContext)_localctx).p_2_3 = expr6(0);
						 ((SubtractionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.SubtractionExpr(((SubtractionExprContext)_localctx).p_2_1.result,((SubtractionExprContext)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(308);
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
	public static class ModuloExprContext extends Expr6Context {
		public Expr6Context p_3_1;
		public Expr7Context p_3_3;
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(FujureParser.Surrogate_id_SYMB_16, 0); }
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
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(FujureParser.Surrogate_id_SYMB_15, 0); }
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
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(FujureParser.Surrogate_id_SYMB_14, 0); }
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Coercion_Expr6Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(310);
			((Coercion_Expr6Context)_localctx).p_4_1 = expr7();
			 ((Coercion_Expr6Context)_localctx).result =  ((Coercion_Expr6Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new Expr6Context(_parentctx, _parentState));
						((MultiplicationExprContext)_localctx).p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(313);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(314);
						match(Surrogate_id_SYMB_14);
						setState(315);
						((MultiplicationExprContext)_localctx).p_1_3 = expr7();
						 ((MultiplicationExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.MultiplicationExpr(((MultiplicationExprContext)_localctx).p_1_1.result,((MultiplicationExprContext)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new DivisionExprContext(new Expr6Context(_parentctx, _parentState));
						((DivisionExprContext)_localctx).p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(318);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(319);
						match(Surrogate_id_SYMB_15);
						setState(320);
						((DivisionExprContext)_localctx).p_2_3 = expr7();
						 ((DivisionExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.DivisionExpr(((DivisionExprContext)_localctx).p_2_1.result,((DivisionExprContext)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new ModuloExprContext(new Expr6Context(_parentctx, _parentState));
						((ModuloExprContext)_localctx).p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr6);
						setState(323);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(324);
						match(Surrogate_id_SYMB_16);
						setState(325);
						((ModuloExprContext)_localctx).p_3_3 = expr7();
						 ((ModuloExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ModuloExpr(((ModuloExprContext)_localctx).p_3_1.result,((ModuloExprContext)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(FujureParser.Surrogate_id_SYMB_17, 0); }
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
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(FujureParser.Surrogate_id_SYMB_12, 0); }
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
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(FujureParser.Surrogate_id_SYMB_13, 0); }
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
		enterRule(_localctx, 50, RULE_expr7);
		try {
			setState(348);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_17:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				match(Surrogate_id_SYMB_17);
				setState(334);
				((NotExprContext)_localctx).p_1_2 = expr8();
				 ((NotExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NotExpr(((NotExprContext)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_13:
				_localctx = new NegateExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				match(Surrogate_id_SYMB_13);
				setState(338);
				((NegateExprContext)_localctx).p_2_2 = expr8();
				 ((NegateExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.NegateExpr(((NegateExprContext)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_12:
				_localctx = new PositateExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(Surrogate_id_SYMB_12);
				setState(342);
				((PositateExprContext)_localctx).p_3_2 = expr8();
				 ((PositateExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.PositateExpr(((PositateExprContext)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_18:
			case Surrogate_id_SYMB_22:
			case Surrogate_id_SYMB_29:
			case Surrogate_id_SYMB_30:
			case JID:
			case JCHAR:
			case JSTRING:
			case INTEGER:
				_localctx = new Coercion_Expr7Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
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
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(FujureParser.Surrogate_id_SYMB_18, 0); }
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(FujureParser.Surrogate_id_SYMB_19, 0); }
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
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(FujureParser.Surrogate_id_SYMB_18, 0); }
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(FujureParser.Surrogate_id_SYMB_19, 0); }
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
		enterRule(_localctx, 52, RULE_expr8);
		try {
			setState(367);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				((LiteralExprContext)_localctx).p_1_1 = literal();
				 ((LiteralExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.LiteralExpr(((LiteralExprContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new VariableExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				((VariableExprContext)_localctx).p_2_1 = valRef();
				 ((VariableExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.VariableExpr(((VariableExprContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				_localctx = new FunCallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(356);
				((FunCallExprContext)_localctx).p_3_1 = valRef();
				setState(357);
				match(Surrogate_id_SYMB_18);
				setState(358);
				((FunCallExprContext)_localctx).p_3_3 = listCallArg();
				setState(359);
				match(Surrogate_id_SYMB_19);
				 ((FunCallExprContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FunCallExpr(((FunCallExprContext)_localctx).p_3_1.result,((FunCallExprContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				_localctx = new Coercion_Expr8Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				match(Surrogate_id_SYMB_18);
				setState(363);
				((Coercion_Expr8Context)_localctx).p_4_2 = expr();
				setState(364);
				match(Surrogate_id_SYMB_19);
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
		enterRule(_localctx, 54, RULE_callArg);
		try {
			_localctx = new ExprCallArgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
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
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(FujureParser.Surrogate_id_SYMB_3, 0); }
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
		enterRule(_localctx, 56, RULE_listCallArg);
		try {
			setState(381);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
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
				setState(373);
				((ListCallArg_AppendLastContext)_localctx).p_2_1 = callArg();
				 ((ListCallArg_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListCallArg(); _localctx.result.addLast(((ListCallArg_AppendLastContext)_localctx).p_2_1.result); 
				}
				break;
			case 3:
				_localctx = new ListCallArg_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				((ListCallArg_PrependFirstContext)_localctx).p_3_1 = callArg();
				setState(377);
				match(Surrogate_id_SYMB_3);
				setState(378);
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
		enterRule(_localctx, 58, RULE_valRef);
		try {
			_localctx = new ValueRefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
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
		enterRule(_localctx, 60, RULE_listValRefFragm);
		try {
			setState(394);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ListValRefFragm_AppendLastContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				((ListValRefFragm_AppendLastContext)_localctx).p_1_1 = valRefFragm();
				 ((ListValRefFragm_AppendLastContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.ListValRefFragm(); _localctx.result.addLast(((ListValRefFragm_AppendLastContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				_localctx = new ListValRefFragm_PrependFirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				((ListValRefFragm_PrependFirstContext)_localctx).p_2_1 = valRefFragm();
				setState(390);
				match(Surrogate_id_SYMB_0);
				setState(391);
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
		enterRule(_localctx, 62, RULE_valRefFragm);
		try {
			_localctx = new ValueRefFragmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
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
		public TerminalNode Surrogate_id_SYMB_29() { return getToken(FujureParser.Surrogate_id_SYMB_29, 0); }
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
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(FujureParser.Surrogate_id_SYMB_22, 0); }
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
		public TerminalNode Surrogate_id_SYMB_30() { return getToken(FujureParser.Surrogate_id_SYMB_30, 0); }
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
		enterRule(_localctx, 64, RULE_literal);
		try {
			setState(411);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				((IntLiteralContext)_localctx).p_1_1 = match(INTEGER);
				 ((IntLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.IntLiteral(Integer.parseInt(((IntLiteralContext)_localctx).p_1_1.getText())); 
				}
				break;
			case Surrogate_id_SYMB_30:
				_localctx = new UnitLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(Surrogate_id_SYMB_30);
				 ((UnitLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.UnitLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_29:
				_localctx = new BoolTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(Surrogate_id_SYMB_29);
				 ((BoolTrueLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolTrueLiteral(); 
				}
				break;
			case Surrogate_id_SYMB_22:
				_localctx = new BoolFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
				match(Surrogate_id_SYMB_22);
				 ((BoolFalseLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.BoolFalseLiteral(); 
				}
				break;
			case JCHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
				((CharLiteralContext)_localctx).p_5_1 = match(JCHAR);
				 ((CharLiteralContext)_localctx).result =  new org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.CharLiteral(((CharLiteralContext)_localctx).p_5_1.getText()); 
				}
				break;
			case JSTRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(409);
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
		case 19:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 20:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 21:
			return expr3_sempred((Expr3Context)_localctx, predIndex);
		case 22:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 23:
			return expr5_sempred((Expr5Context)_localctx, predIndex);
		case 24:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u01a0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2O\n\2\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\\\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7k\n\7\f\7\16\7n\13\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u008b\n\f\f\f\16\f\u008e\13\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a7\n\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b4\n\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00ca\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00d7\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u00e2\n\25\f\25\16\25\u00e5\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u00f0\n\26\f\26\16\26\u00f3\13\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0103\n\27\f\27"+
		"\16\27\u0106\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7"+
		"\30\u0120\n\30\f\30\16\30\u0123\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0133\n\31\f\31\16\31\u0136"+
		"\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u014b\n\32\f\32\16\32\u014e\13\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u015f\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0172\n\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0180\n\36\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u018d\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u019e\n\"\3\"\2\n\f\26(*,.\60\62#\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\2\u01a5\2"+
		"N\3\2\2\2\4P\3\2\2\2\6[\3\2\2\2\b]\3\2\2\2\n`\3\2\2\2\fc\3\2\2\2\16o\3"+
		"\2\2\2\20{\3\2\2\2\22}\3\2\2\2\24\u0080\3\2\2\2\26\u0083\3\2\2\2\30\u008f"+
		"\3\2\2\2\32\u00a6\3\2\2\2\34\u00a8\3\2\2\2\36\u00b3\3\2\2\2 \u00b5\3\2"+
		"\2\2\"\u00c9\3\2\2\2$\u00cb\3\2\2\2&\u00d6\3\2\2\2(\u00d8\3\2\2\2*\u00e6"+
		"\3\2\2\2,\u00f4\3\2\2\2.\u0107\3\2\2\2\60\u0124\3\2\2\2\62\u0137\3\2\2"+
		"\2\64\u015e\3\2\2\2\66\u0171\3\2\2\28\u0173\3\2\2\2:\u017f\3\2\2\2<\u0181"+
		"\3\2\2\2>\u018c\3\2\2\2@\u018e\3\2\2\2B\u019d\3\2\2\2DE\7\36\2\2EF\5\4"+
		"\3\2FG\5\n\6\2GH\5\24\13\2HI\b\2\1\2IO\3\2\2\2JK\5\n\6\2KL\5\24\13\2L"+
		"M\b\2\1\2MO\3\2\2\2ND\3\2\2\2NJ\3\2\2\2O\3\3\2\2\2PQ\5\6\4\2QR\b\3\1\2"+
		"R\5\3\2\2\2ST\5\b\5\2TU\b\4\1\2U\\\3\2\2\2VW\5\b\5\2WX\7\3\2\2XY\5\6\4"+
		"\2YZ\b\4\1\2Z\\\3\2\2\2[S\3\2\2\2[V\3\2\2\2\\\7\3\2\2\2]^\7\"\2\2^_\b"+
		"\5\1\2_\t\3\2\2\2`a\5\f\7\2ab\b\6\1\2b\13\3\2\2\2cd\b\7\1\2de\b\7\1\2"+
		"el\3\2\2\2fg\f\3\2\2gh\5\16\b\2hi\b\7\1\2ik\3\2\2\2jf\3\2\2\2kn\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2m\r\3\2\2\2nl\3\2\2\2op\7\33\2\2pq\5\20\t\2qr\b"+
		"\b\1\2r\17\3\2\2\2st\5\22\n\2tu\b\t\1\2u|\3\2\2\2vw\5\22\n\2wx\7\3\2\2"+
		"xy\5\20\t\2yz\b\t\1\2z|\3\2\2\2{s\3\2\2\2{v\3\2\2\2|\21\3\2\2\2}~\7\""+
		"\2\2~\177\b\n\1\2\177\23\3\2\2\2\u0080\u0081\5\26\f\2\u0081\u0082\b\13"+
		"\1\2\u0082\25\3\2\2\2\u0083\u0084\b\f\1\2\u0084\u0085\b\f\1\2\u0085\u008c"+
		"\3\2\2\2\u0086\u0087\f\3\2\2\u0087\u0088\5\30\r\2\u0088\u0089\b\f\1\2"+
		"\u0089\u008b\3\2\2\2\u008a\u0086\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\27\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0090\7\27\2\2\u0090\u0091\5\32\16\2\u0091\u0092\b\r\1\2\u0092\31\3\2"+
		"\2\2\u0093\u0094\7\"\2\2\u0094\u00a7\b\16\1\2\u0095\u0096\7\"\2\2\u0096"+
		"\u0097\7\4\2\2\u0097\u0098\5\34\17\2\u0098\u0099\b\16\1\2\u0099\u00a7"+
		"\3\2\2\2\u009a\u009b\7\"\2\2\u009b\u009c\7\5\2\2\u009c\u009d\5\"\22\2"+
		"\u009d\u009e\b\16\1\2\u009e\u00a7\3\2\2\2\u009f\u00a0\7\"\2\2\u00a0\u00a1"+
		"\7\4\2\2\u00a1\u00a2\5\34\17\2\u00a2\u00a3\7\5\2\2\u00a3\u00a4\5\"\22"+
		"\2\u00a4\u00a5\b\16\1\2\u00a5\u00a7\3\2\2\2\u00a6\u0093\3\2\2\2\u00a6"+
		"\u0095\3\2\2\2\u00a6\u009a\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\33\3\2\2"+
		"\2\u00a8\u00a9\5\36\20\2\u00a9\u00aa\b\17\1\2\u00aa\35\3\2\2\2\u00ab\u00ac"+
		"\5 \21\2\u00ac\u00ad\b\20\1\2\u00ad\u00b4\3\2\2\2\u00ae\u00af\5 \21\2"+
		"\u00af\u00b0\7\3\2\2\u00b0\u00b1\5\36\20\2\u00b1\u00b2\b\20\1\2\u00b2"+
		"\u00b4\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4\37\3\2\2"+
		"\2\u00b5\u00b6\7\"\2\2\u00b6\u00b7\b\21\1\2\u00b7!\3\2\2\2\u00b8\u00b9"+
		"\7\32\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7\37\2\2\u00bb\u00bc\5\"\22"+
		"\2\u00bc\u00bd\7\30\2\2\u00bd\u00be\5\"\22\2\u00be\u00bf\b\22\1\2\u00bf"+
		"\u00ca\3\2\2\2\u00c0\u00c1\7\35\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3\7"+
		"\34\2\2\u00c3\u00c4\5\"\22\2\u00c4\u00c5\b\22\1\2\u00c5\u00ca\3\2\2\2"+
		"\u00c6\u00c7\5(\25\2\u00c7\u00c8\b\22\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00b8"+
		"\3\2\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca#\3\2\2\2\u00cb"+
		"\u00cc\5\32\16\2\u00cc\u00cd\b\23\1\2\u00cd%\3\2\2\2\u00ce\u00cf\5$\23"+
		"\2\u00cf\u00d0\b\24\1\2\u00d0\u00d7\3\2\2\2\u00d1\u00d2\5$\23\2\u00d2"+
		"\u00d3\7\6\2\2\u00d3\u00d4\5&\24\2\u00d4\u00d5\b\24\1\2\u00d5\u00d7\3"+
		"\2\2\2\u00d6\u00ce\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d7\'\3\2\2\2\u00d8\u00d9"+
		"\b\25\1\2\u00d9\u00da\5*\26\2\u00da\u00db\b\25\1\2\u00db\u00e3\3\2\2\2"+
		"\u00dc\u00dd\f\4\2\2\u00dd\u00de\7\7\2\2\u00de\u00df\5*\26\2\u00df\u00e0"+
		"\b\25\1\2\u00e0\u00e2\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\u00e5\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4)\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e6\u00e7\b\26\1\2\u00e7\u00e8\5,\27\2\u00e8\u00e9\b\26\1\2\u00e9"+
		"\u00f1\3\2\2\2\u00ea\u00eb\f\4\2\2\u00eb\u00ec\7\b\2\2\u00ec\u00ed\5,"+
		"\27\2\u00ed\u00ee\b\26\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2+\3\2\2\2"+
		"\u00f3\u00f1\3\2\2\2\u00f4\u00f5\b\27\1\2\u00f5\u00f6\5.\30\2\u00f6\u00f7"+
		"\b\27\1\2\u00f7\u0104\3\2\2\2\u00f8\u00f9\f\5\2\2\u00f9\u00fa\7\t\2\2"+
		"\u00fa\u00fb\5.\30\2\u00fb\u00fc\b\27\1\2\u00fc\u0103\3\2\2\2\u00fd\u00fe"+
		"\f\4\2\2\u00fe\u00ff\7\n\2\2\u00ff\u0100\5.\30\2\u0100\u0101\b\27\1\2"+
		"\u0101\u0103\3\2\2\2\u0102\u00f8\3\2\2\2\u0102\u00fd\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105-\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\b\30\1\2\u0108\u0109\5\60\31\2\u0109\u010a"+
		"\b\30\1\2\u010a\u0121\3\2\2\2\u010b\u010c\f\7\2\2\u010c\u010d\7\13\2\2"+
		"\u010d\u010e\5\60\31\2\u010e\u010f\b\30\1\2\u010f\u0120\3\2\2\2\u0110"+
		"\u0111\f\6\2\2\u0111\u0112\7\f\2\2\u0112\u0113\5\60\31\2\u0113\u0114\b"+
		"\30\1\2\u0114\u0120\3\2\2\2\u0115\u0116\f\5\2\2\u0116\u0117\7\r\2\2\u0117"+
		"\u0118\5\60\31\2\u0118\u0119\b\30\1\2\u0119\u0120\3\2\2\2\u011a\u011b"+
		"\f\4\2\2\u011b\u011c\7\16\2\2\u011c\u011d\5\60\31\2\u011d\u011e\b\30\1"+
		"\2\u011e\u0120\3\2\2\2\u011f\u010b\3\2\2\2\u011f\u0110\3\2\2\2\u011f\u0115"+
		"\3\2\2\2\u011f\u011a\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122/\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\b\31\1\2"+
		"\u0125\u0126\5\62\32\2\u0126\u0127\b\31\1\2\u0127\u0134\3\2\2\2\u0128"+
		"\u0129\f\5\2\2\u0129\u012a\7\17\2\2\u012a\u012b\5\62\32\2\u012b\u012c"+
		"\b\31\1\2\u012c\u0133\3\2\2\2\u012d\u012e\f\4\2\2\u012e\u012f\7\20\2\2"+
		"\u012f\u0130\5\62\32\2\u0130\u0131\b\31\1\2\u0131\u0133\3\2\2\2\u0132"+
		"\u0128\3\2\2\2\u0132\u012d\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\61\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138"+
		"\b\32\1\2\u0138\u0139\5\64\33\2\u0139\u013a\b\32\1\2\u013a\u014c\3\2\2"+
		"\2\u013b\u013c\f\6\2\2\u013c\u013d\7\21\2\2\u013d\u013e\5\64\33\2\u013e"+
		"\u013f\b\32\1\2\u013f\u014b\3\2\2\2\u0140\u0141\f\5\2\2\u0141\u0142\7"+
		"\22\2\2\u0142\u0143\5\64\33\2\u0143\u0144\b\32\1\2\u0144\u014b\3\2\2\2"+
		"\u0145\u0146\f\4\2\2\u0146\u0147\7\23\2\2\u0147\u0148\5\64\33\2\u0148"+
		"\u0149\b\32\1\2\u0149\u014b\3\2\2\2\u014a\u013b\3\2\2\2\u014a\u0140\3"+
		"\2\2\2\u014a\u0145\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\63\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7\24\2"+
		"\2\u0150\u0151\5\66\34\2\u0151\u0152\b\33\1\2\u0152\u015f\3\2\2\2\u0153"+
		"\u0154\7\20\2\2\u0154\u0155\5\66\34\2\u0155\u0156\b\33\1\2\u0156\u015f"+
		"\3\2\2\2\u0157\u0158\7\17\2\2\u0158\u0159\5\66\34\2\u0159\u015a\b\33\1"+
		"\2\u015a\u015f\3\2\2\2\u015b\u015c\5\66\34\2\u015c\u015d\b\33\1\2\u015d"+
		"\u015f\3\2\2\2\u015e\u014f\3\2\2\2\u015e\u0153\3\2\2\2\u015e\u0157\3\2"+
		"\2\2\u015e\u015b\3\2\2\2\u015f\65\3\2\2\2\u0160\u0161\5B\"\2\u0161\u0162"+
		"\b\34\1\2\u0162\u0172\3\2\2\2\u0163\u0164\5<\37\2\u0164\u0165\b\34\1\2"+
		"\u0165\u0172\3\2\2\2\u0166\u0167\5<\37\2\u0167\u0168\7\25\2\2\u0168\u0169"+
		"\5:\36\2\u0169\u016a\7\26\2\2\u016a\u016b\b\34\1\2\u016b\u0172\3\2\2\2"+
		"\u016c\u016d\7\25\2\2\u016d\u016e\5\"\22\2\u016e\u016f\7\26\2\2\u016f"+
		"\u0170\b\34\1\2\u0170\u0172\3\2\2\2\u0171\u0160\3\2\2\2\u0171\u0163\3"+
		"\2\2\2\u0171\u0166\3\2\2\2\u0171\u016c\3\2\2\2\u0172\67\3\2\2\2\u0173"+
		"\u0174\5\"\22\2\u0174\u0175\b\35\1\2\u01759\3\2\2\2\u0176\u0180\b\36\1"+
		"\2\u0177\u0178\58\35\2\u0178\u0179\b\36\1\2\u0179\u0180\3\2\2\2\u017a"+
		"\u017b\58\35\2\u017b\u017c\7\6\2\2\u017c\u017d\5:\36\2\u017d\u017e\b\36"+
		"\1\2\u017e\u0180\3\2\2\2\u017f\u0176\3\2\2\2\u017f\u0177\3\2\2\2\u017f"+
		"\u017a\3\2\2\2\u0180;\3\2\2\2\u0181\u0182\5> \2\u0182\u0183\b\37\1\2\u0183"+
		"=\3\2\2\2\u0184\u0185\5@!\2\u0185\u0186\b \1\2\u0186\u018d\3\2\2\2\u0187"+
		"\u0188\5@!\2\u0188\u0189\7\3\2\2\u0189\u018a\5> \2\u018a\u018b\b \1\2"+
		"\u018b\u018d\3\2\2\2\u018c\u0184\3\2\2\2\u018c\u0187\3\2\2\2\u018d?\3"+
		"\2\2\2\u018e\u018f\7\"\2\2\u018f\u0190\b!\1\2\u0190A\3\2\2\2\u0191\u0192"+
		"\7%\2\2\u0192\u019e\b\"\1\2\u0193\u0194\7!\2\2\u0194\u019e\b\"\1\2\u0195"+
		"\u0196\7 \2\2\u0196\u019e\b\"\1\2\u0197\u0198\7\31\2\2\u0198\u019e\b\""+
		"\1\2\u0199\u019a\7#\2\2\u019a\u019e\b\"\1\2\u019b\u019c\7$\2\2\u019c\u019e"+
		"\b\"\1\2\u019d\u0191\3\2\2\2\u019d\u0193\3\2\2\2\u019d\u0195\3\2\2\2\u019d"+
		"\u0197\3\2\2\2\u019d\u0199\3\2\2\2\u019d\u019b\3\2\2\2\u019eC\3\2\2\2"+
		"\32N[l{\u008c\u00a6\u00b3\u00c9\u00d6\u00e3\u00f1\u0102\u0104\u011f\u0121"+
		"\u0132\u0134\u014a\u014c\u015e\u0171\u017f\u018c\u019d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}