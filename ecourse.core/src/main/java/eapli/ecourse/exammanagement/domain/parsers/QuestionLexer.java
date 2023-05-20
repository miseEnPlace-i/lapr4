// Generated from /home/russo/isep/lapr4/sem4pi-22-23-19/ecourse.core/src/main/java/eapli/ecourse/exammanagement/domain/grammars/Question/Question.g4 by ANTLR 4.9.2
package eapli.ecourse.exammanagement.domain.parsers;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, EOI=7, STRING=8, NUMBER=9, 
		REAL_NUMBER=10, START_QUESTION=11, END_QUESTION=12, TYPE=13, QUESTION_BODY=14, 
		START_CORRECT_ANSWERS_SECTION=15, CORRECT_ANSWER=16, END_CORRECT_ANSWERS_SECTION=17, 
		ACCEPTED_ERROR=18, FEEDBACK=19, START_OPTIONS_SECTION=20, END_OPTIONS_SECTION=21, 
		OPTION=22, START_MATCHING_SECTION=23, END_MATCHING_SECTION=24, MATCH=25, 
		TRUE=26, FALSE=27, WS=28, COMMENT=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "EOI", "STRING", "NUMBER", 
			"REAL_NUMBER", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
			"START_CORRECT_ANSWERS_SECTION", "CORRECT_ANSWER", "END_CORRECT_ANSWERS_SECTION", 
			"ACCEPTED_ERROR", "FEEDBACK", "START_OPTIONS_SECTION", "END_OPTIONS_SECTION", 
			"OPTION", "START_MATCHING_SECTION", "END_MATCHING_SECTION", "MATCH", 
			"TRUE", "FALSE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numerical'", "'multiple-choice'", "'short-answer'", "'true-false'", 
			"'matching'", "'missing-words'", "';'", null, null, null, "'@start-question'", 
			"'@end-question'", "'@type'", "'@question-body'", "'@correct-answers'", 
			"'@correct-answer'", "'@end-correct-answers'", "'@accepted-error'", "'@feedback'", 
			"'@start-options'", "'@end-options'", "'@option'", "'@start-matching'", 
			"'@end-matching'", "'@match'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "EOI", "STRING", "NUMBER", 
			"REAL_NUMBER", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
			"START_CORRECT_ANSWERS_SECTION", "CORRECT_ANSWER", "END_CORRECT_ANSWERS_SECTION", 
			"ACCEPTED_ERROR", "FEEDBACK", "START_OPTIONS_SECTION", "END_OPTIONS_SECTION", 
			"OPTION", "START_MATCHING_SECTION", "END_MATCHING_SECTION", "MATCH", 
			"TRUE", "FALSE", "WS", "COMMENT"
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


	public QuestionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Question.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u018e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\7\t\u008d\n\t\f\t\16\t\u0090\13\t\3\t\3\t\3\n\6"+
		"\n\u0095\n\n\r\n\16\n\u0096\3\13\6\13\u009a\n\13\r\13\16\13\u009b\3\13"+
		"\3\13\6\13\u00a0\n\13\r\13\16\13\u00a1\5\13\u00a4\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\6\35\u017e\n\35"+
		"\r\35\16\35\u017f\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u0188\n\36\f\36\16"+
		"\36\u018b\13\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37\3\2\6\4\2$$^^\3\2\62;\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u0195\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5G\3\2\2\2\7W\3\2\2\2\td\3\2"+
		"\2\2\13o\3\2\2\2\rx\3\2\2\2\17\u0086\3\2\2\2\21\u0088\3\2\2\2\23\u0094"+
		"\3\2\2\2\25\u0099\3\2\2\2\27\u00a5\3\2\2\2\31\u00b5\3\2\2\2\33\u00c3\3"+
		"\2\2\2\35\u00c9\3\2\2\2\37\u00d8\3\2\2\2!\u00e9\3\2\2\2#\u00f9\3\2\2\2"+
		"%\u010e\3\2\2\2\'\u011e\3\2\2\2)\u0128\3\2\2\2+\u0137\3\2\2\2-\u0144\3"+
		"\2\2\2/\u014c\3\2\2\2\61\u015c\3\2\2\2\63\u016a\3\2\2\2\65\u0171\3\2\2"+
		"\2\67\u0176\3\2\2\29\u017d\3\2\2\2;\u0183\3\2\2\2=>\7p\2\2>?\7w\2\2?@"+
		"\7o\2\2@A\7g\2\2AB\7t\2\2BC\7k\2\2CD\7e\2\2DE\7c\2\2EF\7n\2\2F\4\3\2\2"+
		"\2GH\7o\2\2HI\7w\2\2IJ\7n\2\2JK\7v\2\2KL\7k\2\2LM\7r\2\2MN\7n\2\2NO\7"+
		"g\2\2OP\7/\2\2PQ\7e\2\2QR\7j\2\2RS\7q\2\2ST\7k\2\2TU\7e\2\2UV\7g\2\2V"+
		"\6\3\2\2\2WX\7u\2\2XY\7j\2\2YZ\7q\2\2Z[\7t\2\2[\\\7v\2\2\\]\7/\2\2]^\7"+
		"c\2\2^_\7p\2\2_`\7u\2\2`a\7y\2\2ab\7g\2\2bc\7t\2\2c\b\3\2\2\2de\7v\2\2"+
		"ef\7t\2\2fg\7w\2\2gh\7g\2\2hi\7/\2\2ij\7h\2\2jk\7c\2\2kl\7n\2\2lm\7u\2"+
		"\2mn\7g\2\2n\n\3\2\2\2op\7o\2\2pq\7c\2\2qr\7v\2\2rs\7e\2\2st\7j\2\2tu"+
		"\7k\2\2uv\7p\2\2vw\7i\2\2w\f\3\2\2\2xy\7o\2\2yz\7k\2\2z{\7u\2\2{|\7u\2"+
		"\2|}\7k\2\2}~\7p\2\2~\177\7i\2\2\177\u0080\7/\2\2\u0080\u0081\7y\2\2\u0081"+
		"\u0082\7q\2\2\u0082\u0083\7t\2\2\u0083\u0084\7f\2\2\u0084\u0085\7u\2\2"+
		"\u0085\16\3\2\2\2\u0086\u0087\7=\2\2\u0087\20\3\2\2\2\u0088\u008e\7$\2"+
		"\2\u0089\u008a\7^\2\2\u008a\u008d\t\2\2\2\u008b\u008d\n\2\2\2\u008c\u0089"+
		"\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7$"+
		"\2\2\u0092\22\3\2\2\2\u0093\u0095\t\3\2\2\u0094\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\24\3\2\2\2\u0098"+
		"\u009a\t\3\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u00a3\3\2\2\2\u009d\u009f\7\60\2\2\u009e"+
		"\u00a0\t\3\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\7B\2\2\u00a6\u00a7\7u\2\2"+
		"\u00a7\u00a8\7v\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab"+
		"\7v\2\2\u00ab\u00ac\7/\2\2\u00ac\u00ad\7s\2\2\u00ad\u00ae\7w\2\2\u00ae"+
		"\u00af\7g\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7k\2\2"+
		"\u00b2\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\7"+
		"B\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba"+
		"\7/\2\2\u00ba\u00bb\7s\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"\u00be\7u\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7q\2\2"+
		"\u00c1\u00c2\7p\2\2\u00c2\32\3\2\2\2\u00c3\u00c4\7B\2\2\u00c4\u00c5\7"+
		"v\2\2\u00c5\u00c6\7{\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7g\2\2\u00c8\34"+
		"\3\2\2\2\u00c9\u00ca\7B\2\2\u00ca\u00cb\7s\2\2\u00cb\u00cc\7w\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd\u00ce\7u\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7k\2\2"+
		"\u00d0\u00d1\7q\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7/\2\2\u00d3\u00d4"+
		"\7d\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7f\2\2\u00d6\u00d7\7{\2\2\u00d7"+
		"\36\3\2\2\2\u00d8\u00d9\7B\2\2\u00d9\u00da\7e\2\2\u00da\u00db\7q\2\2\u00db"+
		"\u00dc\7t\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7e\2\2"+
		"\u00df\u00e0\7v\2\2\u00e0\u00e1\7/\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3"+
		"\7p\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7y\2\2\u00e5\u00e6\7g\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7\u00e8\7u\2\2\u00e8 \3\2\2\2\u00e9\u00ea\7B\2\2\u00ea"+
		"\u00eb\7e\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee\7t\2\2"+
		"\u00ee\u00ef\7g\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2"+
		"\7/\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7u\2\2\u00f5"+
		"\u00f6\7y\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7t\2\2\u00f8\"\3\2\2\2\u00f9"+
		"\u00fa\7B\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7f\2\2"+
		"\u00fd\u00fe\7/\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7q\2\2\u0100\u0101"+
		"\7t\2\2\u0101\u0102\7t\2\2\u0102\u0103\7g\2\2\u0103\u0104\7e\2\2\u0104"+
		"\u0105\7v\2\2\u0105\u0106\7/\2\2\u0106\u0107\7c\2\2\u0107\u0108\7p\2\2"+
		"\u0108\u0109\7u\2\2\u0109\u010a\7y\2\2\u010a\u010b\7g\2\2\u010b\u010c"+
		"\7t\2\2\u010c\u010d\7u\2\2\u010d$\3\2\2\2\u010e\u010f\7B\2\2\u010f\u0110"+
		"\7c\2\2\u0110\u0111\7e\2\2\u0111\u0112\7e\2\2\u0112\u0113\7g\2\2\u0113"+
		"\u0114\7r\2\2\u0114\u0115\7v\2\2\u0115\u0116\7g\2\2\u0116\u0117\7f\2\2"+
		"\u0117\u0118\7/\2\2\u0118\u0119\7g\2\2\u0119\u011a\7t\2\2\u011a\u011b"+
		"\7t\2\2\u011b\u011c\7q\2\2\u011c\u011d\7t\2\2\u011d&\3\2\2\2\u011e\u011f"+
		"\7B\2\2\u011f\u0120\7h\2\2\u0120\u0121\7g\2\2\u0121\u0122\7g\2\2\u0122"+
		"\u0123\7f\2\2\u0123\u0124\7d\2\2\u0124\u0125\7c\2\2\u0125\u0126\7e\2\2"+
		"\u0126\u0127\7m\2\2\u0127(\3\2\2\2\u0128\u0129\7B\2\2\u0129\u012a\7u\2"+
		"\2\u012a\u012b\7v\2\2\u012b\u012c\7c\2\2\u012c\u012d\7t\2\2\u012d\u012e"+
		"\7v\2\2\u012e\u012f\7/\2\2\u012f\u0130\7q\2\2\u0130\u0131\7r\2\2\u0131"+
		"\u0132\7v\2\2\u0132\u0133\7k\2\2\u0133\u0134\7q\2\2\u0134\u0135\7p\2\2"+
		"\u0135\u0136\7u\2\2\u0136*\3\2\2\2\u0137\u0138\7B\2\2\u0138\u0139\7g\2"+
		"\2\u0139\u013a\7p\2\2\u013a\u013b\7f\2\2\u013b\u013c\7/\2\2\u013c\u013d"+
		"\7q\2\2\u013d\u013e\7r\2\2\u013e\u013f\7v\2\2\u013f\u0140\7k\2\2\u0140"+
		"\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142\u0143\7u\2\2\u0143,\3\2\2\2\u0144"+
		"\u0145\7B\2\2\u0145\u0146\7q\2\2\u0146\u0147\7r\2\2\u0147\u0148\7v\2\2"+
		"\u0148\u0149\7k\2\2\u0149\u014a\7q\2\2\u014a\u014b\7p\2\2\u014b.\3\2\2"+
		"\2\u014c\u014d\7B\2\2\u014d\u014e\7u\2\2\u014e\u014f\7v\2\2\u014f\u0150"+
		"\7c\2\2\u0150\u0151\7t\2\2\u0151\u0152\7v\2\2\u0152\u0153\7/\2\2\u0153"+
		"\u0154\7o\2\2\u0154\u0155\7c\2\2\u0155\u0156\7v\2\2\u0156\u0157\7e\2\2"+
		"\u0157\u0158\7j\2\2\u0158\u0159\7k\2\2\u0159\u015a\7p\2\2\u015a\u015b"+
		"\7i\2\2\u015b\60\3\2\2\2\u015c\u015d\7B\2\2\u015d\u015e\7g\2\2\u015e\u015f"+
		"\7p\2\2\u015f\u0160\7f\2\2\u0160\u0161\7/\2\2\u0161\u0162\7o\2\2\u0162"+
		"\u0163\7c\2\2\u0163\u0164\7v\2\2\u0164\u0165\7e\2\2\u0165\u0166\7j\2\2"+
		"\u0166\u0167\7k\2\2\u0167\u0168\7p\2\2\u0168\u0169\7i\2\2\u0169\62\3\2"+
		"\2\2\u016a\u016b\7B\2\2\u016b\u016c\7o\2\2\u016c\u016d\7c\2\2\u016d\u016e"+
		"\7v\2\2\u016e\u016f\7e\2\2\u016f\u0170\7j\2\2\u0170\64\3\2\2\2\u0171\u0172"+
		"\7v\2\2\u0172\u0173\7t\2\2\u0173\u0174\7w\2\2\u0174\u0175\7g\2\2\u0175"+
		"\66\3\2\2\2\u0176\u0177\7h\2\2\u0177\u0178\7c\2\2\u0178\u0179\7n\2\2\u0179"+
		"\u017a\7u\2\2\u017a\u017b\7g\2\2\u017b8\3\2\2\2\u017c\u017e\t\4\2\2\u017d"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0181\3\2\2\2\u0181\u0182\b\35\2\2\u0182:\3\2\2\2\u0183\u0184"+
		"\7\61\2\2\u0184\u0185\7\61\2\2\u0185\u0189\3\2\2\2\u0186\u0188\n\5\2\2"+
		"\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018d\b\36\2\2"+
		"\u018d<\3\2\2\2\13\2\u008c\u008e\u0096\u009b\u00a1\u00a3\u017f\u0189\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}