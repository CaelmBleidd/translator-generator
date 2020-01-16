// Generated from /Users/CaelmBleidd/Programming/translator-generator/src/GrammarTemplate.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarTemplateLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARROW=1, SEMICOLON=2, ATTR=3, NODE=4, ATTRIBUTE_VALUE=5, NODE_VALUE=6, 
		SEMANTIC_RULE=7, TOKEN_NAME=8, RULE_NAME=9, LITERAL=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ARROW", "SEMICOLON", "ATTR", "NODE", "ATTRIBUTE_VALUE", "NODE_VALUE", 
			"SEMANTIC_RULE", "TOKEN_NAME", "RULE_NAME", "LITERAL", "WS"
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


	public GrammarTemplateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarTemplate.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\re\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7"+
		"\78\n\7\f\7\16\7;\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bC\n\b\f\b\16\bF\13\b"+
		"\3\b\3\b\3\t\3\t\6\tL\n\t\r\t\16\tM\3\n\3\n\7\nR\n\n\f\n\16\nU\13\n\3"+
		"\13\3\13\3\13\3\13\7\13[\n\13\f\13\16\13^\13\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\t\3"+
		"\2\'\'\3\2BB\3\2&&\5\2\62;C\\aa\5\2\62;C\\a|\3\2))\5\2\13\f\17\17\"\""+
		"\2n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\3\31\3\2\2\2\5\34\3\2\2\2\7\36\3\2\2\2\t#\3\2\2\2\13(\3\2\2\2\r\63"+
		"\3\2\2\2\17>\3\2\2\2\21I\3\2\2\2\23O\3\2\2\2\25V\3\2\2\2\27a\3\2\2\2\31"+
		"\32\7/\2\2\32\33\7@\2\2\33\4\3\2\2\2\34\35\7=\2\2\35\6\3\2\2\2\36\37\7"+
		"C\2\2\37 \7v\2\2 !\7v\2\2!\"\7t\2\2\"\b\3\2\2\2#$\7P\2\2$%\7q\2\2%&\7"+
		"f\2\2&\'\7g\2\2\'\n\3\2\2\2(.\7\'\2\2)*\7\'\2\2*-\7\'\2\2+-\n\2\2\2,)"+
		"\3\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2"+
		"\2\2\61\62\7\'\2\2\62\f\3\2\2\2\639\7B\2\2\64\65\7B\2\2\658\7B\2\2\66"+
		"8\n\3\2\2\67\64\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2"+
		":<\3\2\2\2;9\3\2\2\2<=\7B\2\2=\16\3\2\2\2>D\7&\2\2?@\7&\2\2@C\7&\2\2A"+
		"C\n\4\2\2B?\3\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2"+
		"FD\3\2\2\2GH\7&\2\2H\20\3\2\2\2IK\4C\\\2JL\t\5\2\2KJ\3\2\2\2LM\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2N\22\3\2\2\2OS\4c|\2PR\t\6\2\2QP\3\2\2\2RU\3\2\2\2"+
		"SQ\3\2\2\2ST\3\2\2\2T\24\3\2\2\2US\3\2\2\2V\\\7)\2\2WX\7)\2\2X[\7)\2\2"+
		"Y[\n\7\2\2ZW\3\2\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2"+
		"\2^\\\3\2\2\2_`\7)\2\2`\26\3\2\2\2ab\t\b\2\2bc\3\2\2\2cd\b\f\2\2d\30\3"+
		"\2\2\2\r\2,.\679BDMSZ\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}