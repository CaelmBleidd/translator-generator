// Generated from /Users/CaelmBleidd/Programming/translator-generator/src/GrammarTemplate.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarTemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARROW=1, SEMICOLON=2, ATTR=3, NODE=4, ATTRIBUTE_VALUE=5, NODE_VALUE=6, 
		SEMANTIC_RULE=7, TOKEN_NAME=8, RULE_NAME=9, LITERAL=10, WS=11;
	public static final int
		RULE_file = 0, RULE_attributes = 1, RULE_nodeValues = 2, RULE_myRules = 3, 
		RULE_myRule = 4, RULE_myTokens = 5, RULE_myToken = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "attributes", "nodeValues", "myRules", "myRule", "myTokens", 
			"myToken"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "';'", "'Attr'", "'Node'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ARROW", "SEMICOLON", "ATTR", "NODE", "ATTRIBUTE_VALUE", "NODE_VALUE", 
			"SEMANTIC_RULE", "TOKEN_NAME", "RULE_NAME", "LITERAL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "GrammarTemplate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarTemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public MyRulesContext myRules() {
			return getRuleContext(MyRulesContext.class,0);
		}
		public MyTokensContext myTokens() {
			return getRuleContext(MyTokensContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarTemplateParser.EOF, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public NodeValuesContext nodeValues() {
			return getRuleContext(NodeValuesContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(14);
				attributes();
				}
			}

			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NODE) {
				{
				setState(17);
				nodeValues();
				}
			}

			setState(20);
			myRules();
			setState(21);
			myTokens();
			setState(22);
			match(EOF);
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

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode ATTR() { return getToken(GrammarTemplateParser.ATTR, 0); }
		public TerminalNode ATTRIBUTE_VALUE() { return getToken(GrammarTemplateParser.ATTRIBUTE_VALUE, 0); }
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_attributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(ATTR);
			setState(25);
			match(ATTRIBUTE_VALUE);
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

	public static class NodeValuesContext extends ParserRuleContext {
		public TerminalNode NODE() { return getToken(GrammarTemplateParser.NODE, 0); }
		public TerminalNode NODE_VALUE() { return getToken(GrammarTemplateParser.NODE_VALUE, 0); }
		public NodeValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterNodeValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitNodeValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitNodeValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeValuesContext nodeValues() throws RecognitionException {
		NodeValuesContext _localctx = new NodeValuesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nodeValues);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(NODE);
			setState(28);
			match(NODE_VALUE);
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

	public static class MyRulesContext extends ParserRuleContext {
		public List<MyRuleContext> myRule() {
			return getRuleContexts(MyRuleContext.class);
		}
		public MyRuleContext myRule(int i) {
			return getRuleContext(MyRuleContext.class,i);
		}
		public MyRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterMyRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitMyRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitMyRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MyRulesContext myRules() throws RecognitionException {
		MyRulesContext _localctx = new MyRulesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_myRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				myRule();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RULE_NAME );
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

	public static class MyRuleContext extends ParserRuleContext {
		public List<TerminalNode> RULE_NAME() { return getTokens(GrammarTemplateParser.RULE_NAME); }
		public TerminalNode RULE_NAME(int i) {
			return getToken(GrammarTemplateParser.RULE_NAME, i);
		}
		public TerminalNode ARROW() { return getToken(GrammarTemplateParser.ARROW, 0); }
		public TerminalNode SEMICOLON() { return getToken(GrammarTemplateParser.SEMICOLON, 0); }
		public List<TerminalNode> TOKEN_NAME() { return getTokens(GrammarTemplateParser.TOKEN_NAME); }
		public TerminalNode TOKEN_NAME(int i) {
			return getToken(GrammarTemplateParser.TOKEN_NAME, i);
		}
		public List<TerminalNode> SEMANTIC_RULE() { return getTokens(GrammarTemplateParser.SEMANTIC_RULE); }
		public TerminalNode SEMANTIC_RULE(int i) {
			return getToken(GrammarTemplateParser.SEMANTIC_RULE, i);
		}
		public MyRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterMyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitMyRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitMyRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MyRuleContext myRule() throws RecognitionException {
		MyRuleContext _localctx = new MyRuleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_myRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(RULE_NAME);
			setState(36);
			match(ARROW);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEMANTIC_RULE) | (1L << TOKEN_NAME) | (1L << RULE_NAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEMANTIC_RULE) | (1L << TOKEN_NAME) | (1L << RULE_NAME))) != 0) );
			setState(42);
			match(SEMICOLON);
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

	public static class MyTokensContext extends ParserRuleContext {
		public List<MyTokenContext> myToken() {
			return getRuleContexts(MyTokenContext.class);
		}
		public MyTokenContext myToken(int i) {
			return getRuleContext(MyTokenContext.class,i);
		}
		public MyTokensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myTokens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterMyTokens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitMyTokens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitMyTokens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MyTokensContext myTokens() throws RecognitionException {
		MyTokensContext _localctx = new MyTokensContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_myTokens);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				myToken();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN_NAME );
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

	public static class MyTokenContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(GrammarTemplateParser.TOKEN_NAME, 0); }
		public TerminalNode ARROW() { return getToken(GrammarTemplateParser.ARROW, 0); }
		public TerminalNode LITERAL() { return getToken(GrammarTemplateParser.LITERAL, 0); }
		public TerminalNode SEMICOLON() { return getToken(GrammarTemplateParser.SEMICOLON, 0); }
		public MyTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).enterMyToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarTemplateListener ) ((GrammarTemplateListener)listener).exitMyToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarTemplateVisitor ) return ((GrammarTemplateVisitor<? extends T>)visitor).visitMyToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MyTokenContext myToken() throws RecognitionException {
		MyTokenContext _localctx = new MyTokenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_myToken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TOKEN_NAME);
			setState(50);
			match(ARROW);
			setState(51);
			match(LITERAL);
			setState(52);
			match(SEMICOLON);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r9\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\5\2\22\n\2\3\2\5\2\25\n"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\6\5\"\n\5\r\5\16\5#\3\6"+
		"\3\6\3\6\6\6)\n\6\r\6\16\6*\3\6\3\6\3\7\6\7\60\n\7\r\7\16\7\61\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\3\3\2\t\13\2\66\2\21\3\2\2\2\4"+
		"\32\3\2\2\2\6\35\3\2\2\2\b!\3\2\2\2\n%\3\2\2\2\f/\3\2\2\2\16\63\3\2\2"+
		"\2\20\22\5\4\3\2\21\20\3\2\2\2\21\22\3\2\2\2\22\24\3\2\2\2\23\25\5\6\4"+
		"\2\24\23\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27\5\b\5\2\27\30\5\f\7"+
		"\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\7\5\2\2\33\34\7\7\2\2\34\5\3\2\2\2"+
		"\35\36\7\6\2\2\36\37\7\b\2\2\37\7\3\2\2\2 \"\5\n\6\2! \3\2\2\2\"#\3\2"+
		"\2\2#!\3\2\2\2#$\3\2\2\2$\t\3\2\2\2%&\7\13\2\2&(\7\3\2\2\')\t\2\2\2(\'"+
		"\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\4\2\2-\13\3\2\2\2"+
		".\60\5\16\b\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\r\3"+
		"\2\2\2\63\64\7\n\2\2\64\65\7\3\2\2\65\66\7\f\2\2\66\67\7\4\2\2\67\17\3"+
		"\2\2\2\7\21\24#*\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}