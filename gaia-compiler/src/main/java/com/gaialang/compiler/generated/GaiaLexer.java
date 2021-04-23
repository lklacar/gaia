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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, TIMES=9, 
		DIV=10, PLUS=11, MINUS=12, LPAREN=13, RPAREN=14, POW=15, EQ=16, EQ_EQ=17, 
		LBRACE=18, RBRACE=19, COLON=20, GT=21, LT=22, MOD=23, COMMA=24, INT=25, 
		DECIMAL=26, WS=27, COMMENT=28, LINE_COMMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "ID", "TIMES", 
			"DIV", "PLUS", "MINUS", "LPAREN", "RPAREN", "POW", "EQ", "EQ_EQ", "LBRACE", 
			"RBRACE", "COLON", "GT", "LT", "MOD", "COMMA", "INT", "DECIMAL", "DIGIT", 
			"SIGN", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'let'", "'if'", "'return'", "'while'", "'print'", "'i64'", 
			null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'^'", "'='", "'=='", 
			"'{'", "'}'", "':'", "'>'", "'<'", "'%'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "ID", "TIMES", "DIV", 
			"PLUS", "MINUS", "LPAREN", "RPAREN", "POW", "EQ", "EQ_EQ", "LBRACE", 
			"RBRACE", "COLON", "GT", "LT", "MOD", "COMMA", "INT", "DECIMAL", "WS", 
			"COMMENT", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00be\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\6\tf\n\t\r\t\16\tg\3\t\7\tk\n\t\f\t\16\tn\13\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\6\32\u0092\n\32\r\32\16\32\u0093\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\35\5\35\u009d\n\35\3\36\6\36\u00a0\n\36\r\36\16\36\u00a1\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\7\37\u00aa\n\37\f\37\16\37\u00ad\13\37\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \7 \u00b8\n \f \16 \u00bb\13 \3 \3 \3\u00ab\2"+
		"!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\29\2;\35"+
		"=\36?\37\3\2\6\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00c2"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\3A\3\2\2\2\5F\3\2\2\2\7J\3\2\2\2\tM\3\2\2\2\13T\3\2\2\2\rZ\3\2\2"+
		"\2\17`\3\2\2\2\21e\3\2\2\2\23o\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3\2"+
		"\2\2\33w\3\2\2\2\35y\3\2\2\2\37{\3\2\2\2!}\3\2\2\2#\177\3\2\2\2%\u0082"+
		"\3\2\2\2\'\u0084\3\2\2\2)\u0086\3\2\2\2+\u0088\3\2\2\2-\u008a\3\2\2\2"+
		"/\u008c\3\2\2\2\61\u008e\3\2\2\2\63\u0091\3\2\2\2\65\u0095\3\2\2\2\67"+
		"\u0099\3\2\2\29\u009c\3\2\2\2;\u009f\3\2\2\2=\u00a5\3\2\2\2?\u00b3\3\2"+
		"\2\2AB\7h\2\2BC\7w\2\2CD\7p\2\2DE\7e\2\2E\4\3\2\2\2FG\7n\2\2GH\7g\2\2"+
		"HI\7v\2\2I\6\3\2\2\2JK\7k\2\2KL\7h\2\2L\b\3\2\2\2MN\7t\2\2NO\7g\2\2OP"+
		"\7v\2\2PQ\7w\2\2QR\7t\2\2RS\7p\2\2S\n\3\2\2\2TU\7y\2\2UV\7j\2\2VW\7k\2"+
		"\2WX\7n\2\2XY\7g\2\2Y\f\3\2\2\2Z[\7r\2\2[\\\7t\2\2\\]\7k\2\2]^\7p\2\2"+
		"^_\7v\2\2_\16\3\2\2\2`a\7k\2\2ab\78\2\2bc\7\66\2\2c\20\3\2\2\2df\t\2\2"+
		"\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hl\3\2\2\2ik\5\67\34\2ji\3\2"+
		"\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\22\3\2\2\2nl\3\2\2\2op\7,\2\2p\24"+
		"\3\2\2\2qr\7\61\2\2r\26\3\2\2\2st\7-\2\2t\30\3\2\2\2uv\7/\2\2v\32\3\2"+
		"\2\2wx\7*\2\2x\34\3\2\2\2yz\7+\2\2z\36\3\2\2\2{|\7`\2\2| \3\2\2\2}~\7"+
		"?\2\2~\"\3\2\2\2\177\u0080\7?\2\2\u0080\u0081\7?\2\2\u0081$\3\2\2\2\u0082"+
		"\u0083\7}\2\2\u0083&\3\2\2\2\u0084\u0085\7\177\2\2\u0085(\3\2\2\2\u0086"+
		"\u0087\7<\2\2\u0087*\3\2\2\2\u0088\u0089\7@\2\2\u0089,\3\2\2\2\u008a\u008b"+
		"\7>\2\2\u008b.\3\2\2\2\u008c\u008d\7\'\2\2\u008d\60\3\2\2\2\u008e\u008f"+
		"\7.\2\2\u008f\62\3\2\2\2\u0090\u0092\5\67\34\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\64\3\2\2"+
		"\2\u0095\u0096\5\63\32\2\u0096\u0097\7\60\2\2\u0097\u0098\5\63\32\2\u0098"+
		"\66\3\2\2\2\u0099\u009a\t\3\2\2\u009a8\3\2\2\2\u009b\u009d\5\31\r\2\u009c"+
		"\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d:\3\2\2\2\u009e\u00a0\t\4\2\2"+
		"\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\b\36\2\2\u00a4<\3\2\2\2\u00a5"+
		"\u00a6\7\61\2\2\u00a6\u00a7\7,\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00aa\13"+
		"\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7,"+
		"\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\37\2\2\u00b2"+
		">\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b9\3\2\2"+
		"\2\u00b6\u00b8\n\5\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bd\b \2\2\u00bd@\3\2\2\2\n\2gl\u0093\u009c\u00a1\u00ab\u00b9\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}