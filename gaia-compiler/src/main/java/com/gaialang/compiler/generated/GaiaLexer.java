// Generated from /Users/lukaklacar/Projects/gaia/gaia-compiler/Gaia.g4 by ANTLR 4.9.1
package com.gaialang.compiler.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GaiaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ID=6, TIMES=7, DIV=8, PLUS=9, 
		MINUS=10, LPAREN=11, RPAREN=12, POW=13, EQ=14, EQ_EQ=15, LBRACE=16, RBRACE=17, 
		COLON=18, GT=19, LT=20, MOD=21, INT=22, DECIMAL=23, WS=24, COMMENT=25, 
		LINE_COMMENT=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "ID", "TIMES", "DIV", "PLUS", 
			"MINUS", "LPAREN", "RPAREN", "POW", "EQ", "EQ_EQ", "LBRACE", "RBRACE", 
			"COLON", "GT", "LT", "MOD", "INT", "DECIMAL", "DIGIT", "SIGN", "WS", 
			"COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'if'", "'while'", "'print'", "'i64'", null, "'*'", "'/'", 
			"'+'", "'-'", "'('", "')'", "'^'", "'='", "'=='", "'{'", "'}'", "':'", 
			"'>'", "'<'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ID", "TIMES", "DIV", "PLUS", "MINUS", 
			"LPAREN", "RPAREN", "POW", "EQ", "EQ_EQ", "LBRACE", "RBRACE", "COLON", 
			"GT", "LT", "MOD", "INT", "DECIMAL", "WS", "COMMENT", "LINE_COMMENT"
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


	public GaiaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gaia.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\6\7T\n\7\r\7\16\7U\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27~\n\27"+
		"\r\27\16\27\177\3\30\3\30\3\30\3\30\3\31\3\31\3\32\5\32\u0089\n\32\3\33"+
		"\6\33\u008c\n\33\r\33\16\33\u008d\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u0096"+
		"\n\34\f\34\16\34\u0099\13\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\7\35\u00a4\n\35\f\35\16\35\u00a7\13\35\3\35\3\35\3\u0097\2\36\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\32\67\339\34\3\2\6\4\2"+
		"C\\c|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00ae\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5?\3\2\2\2\7B\3\2\2\2\tH\3\2\2\2\13"+
		"N\3\2\2\2\rS\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27"+
		"e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37m\3\2\2\2!p\3\2\2\2#r"+
		"\3\2\2\2%t\3\2\2\2\'v\3\2\2\2)x\3\2\2\2+z\3\2\2\2-}\3\2\2\2/\u0081\3\2"+
		"\2\2\61\u0085\3\2\2\2\63\u0088\3\2\2\2\65\u008b\3\2\2\2\67\u0091\3\2\2"+
		"\29\u009f\3\2\2\2;<\7n\2\2<=\7g\2\2=>\7v\2\2>\4\3\2\2\2?@\7k\2\2@A\7h"+
		"\2\2A\6\3\2\2\2BC\7y\2\2CD\7j\2\2DE\7k\2\2EF\7n\2\2FG\7g\2\2G\b\3\2\2"+
		"\2HI\7r\2\2IJ\7t\2\2JK\7k\2\2KL\7p\2\2LM\7v\2\2M\n\3\2\2\2NO\7k\2\2OP"+
		"\78\2\2PQ\7\66\2\2Q\f\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2"+
		"UV\3\2\2\2VZ\3\2\2\2WY\5\61\31\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[\16\3\2\2\2\\Z\3\2\2\2]^\7,\2\2^\20\3\2\2\2_`\7\61\2\2`\22\3\2\2"+
		"\2ab\7-\2\2b\24\3\2\2\2cd\7/\2\2d\26\3\2\2\2ef\7*\2\2f\30\3\2\2\2gh\7"+
		"+\2\2h\32\3\2\2\2ij\7`\2\2j\34\3\2\2\2kl\7?\2\2l\36\3\2\2\2mn\7?\2\2n"+
		"o\7?\2\2o \3\2\2\2pq\7}\2\2q\"\3\2\2\2rs\7\177\2\2s$\3\2\2\2tu\7<\2\2"+
		"u&\3\2\2\2vw\7@\2\2w(\3\2\2\2xy\7>\2\2y*\3\2\2\2z{\7\'\2\2{,\3\2\2\2|"+
		"~\5\61\31\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		".\3\2\2\2\u0081\u0082\5-\27\2\u0082\u0083\7\60\2\2\u0083\u0084\5-\27\2"+
		"\u0084\60\3\2\2\2\u0085\u0086\t\3\2\2\u0086\62\3\2\2\2\u0087\u0089\5\25"+
		"\13\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\64\3\2\2\2\u008a\u008c"+
		"\t\4\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\33\2\2\u0090\66\3\2\2"+
		"\2\u0091\u0092\7\61\2\2\u0092\u0093\7,\2\2\u0093\u0097\3\2\2\2\u0094\u0096"+
		"\13\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b"+
		"\7,\2\2\u009b\u009c\7\61\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\34\2\2"+
		"\u009e8\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a5"+
		"\3\2\2\2\u00a2\u00a4\n\5\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a8\u00a9\b\35\2\2\u00a9:\3\2\2\2\n\2UZ\177\u0088\u008d\u0097\u00a5"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}