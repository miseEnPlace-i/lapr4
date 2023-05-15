// Generated from /home/kappa-laptop/faculdade/22/lapr4/sem4pi-22-23-19/ecourse.core/src/main/java/eapli/ecourse/exammanagement/domain/grammars/Question/Question.g4 by ANTLR 4.9.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, EOI=8, STRING=9, 
		NUMBER=10, REAL_NUMBER=11, START_QUESTION=12, END_QUESTION=13, TYPE=14, 
		QUESTION_BODY=15, START_CORRECT_ANSWERS_SECTION=16, CORRECT_ANSWER=17, 
		END_CORRECT_ANSWERS_SECTION=18, ACCEPTED_ERROR=19, FEEDBACK=20, START_OPTIONS_SECTION=21, 
		END_OPTIONS_SECTION=22, OPTION=23, START_MATCHING_SECTION=24, END_MATCHING_SECTION=25, 
		MATCH=26, TRUE=27, FALSE=28, WS=29, COMMENT=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "EOI", "STRING", 
			"NUMBER", "REAL_NUMBER", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
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
			"'matching'", "'missing-words'", "' '", "';'", null, null, null, "'@start-question'", 
			"'@end-question'", "'@type '", "'@question-body'", "'@correct-answers'", 
			"'@correct-answer '", "'@end-correct-answers'", "'@accepted-error '", 
			"'@feedback '", "'@start-options'", "'@end-options'", "'@option'", "'@start-matching'", 
			"'@end-matching'", "'@match'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "EOI", "STRING", "NUMBER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u0196\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u0091\n\n\f\n\16\n\u0094\13\n\3"+
		"\n\3\n\3\13\6\13\u0099\n\13\r\13\16\13\u009a\3\f\6\f\u009e\n\f\r\f\16"+
		"\f\u009f\3\f\3\f\6\f\u00a4\n\f\r\f\16\f\u00a5\5\f\u00a8\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\6\36\u0186\n\36\r\36\16\36\u0187\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\7\37\u0190\n\37\f\37\16\37\u0193\13\37\3\37\3\37\2"+
		"\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= \3\2\6\4\2$$^^\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u019d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5I\3\2\2\2\7Y\3\2\2\2\tf\3\2\2\2\13q\3\2"+
		"\2\2\rz\3\2\2\2\17\u0088\3\2\2\2\21\u008a\3\2\2\2\23\u008c\3\2\2\2\25"+
		"\u0098\3\2\2\2\27\u009d\3\2\2\2\31\u00a9\3\2\2\2\33\u00b9\3\2\2\2\35\u00c7"+
		"\3\2\2\2\37\u00ce\3\2\2\2!\u00dd\3\2\2\2#\u00ee\3\2\2\2%\u00ff\3\2\2\2"+
		"\'\u0114\3\2\2\2)\u0125\3\2\2\2+\u0130\3\2\2\2-\u013f\3\2\2\2/\u014c\3"+
		"\2\2\2\61\u0154\3\2\2\2\63\u0164\3\2\2\2\65\u0172\3\2\2\2\67\u0179\3\2"+
		"\2\29\u017e\3\2\2\2;\u0185\3\2\2\2=\u018b\3\2\2\2?@\7p\2\2@A\7w\2\2AB"+
		"\7o\2\2BC\7g\2\2CD\7t\2\2DE\7k\2\2EF\7e\2\2FG\7c\2\2GH\7n\2\2H\4\3\2\2"+
		"\2IJ\7o\2\2JK\7w\2\2KL\7n\2\2LM\7v\2\2MN\7k\2\2NO\7r\2\2OP\7n\2\2PQ\7"+
		"g\2\2QR\7/\2\2RS\7e\2\2ST\7j\2\2TU\7q\2\2UV\7k\2\2VW\7e\2\2WX\7g\2\2X"+
		"\6\3\2\2\2YZ\7u\2\2Z[\7j\2\2[\\\7q\2\2\\]\7t\2\2]^\7v\2\2^_\7/\2\2_`\7"+
		"c\2\2`a\7p\2\2ab\7u\2\2bc\7y\2\2cd\7g\2\2de\7t\2\2e\b\3\2\2\2fg\7v\2\2"+
		"gh\7t\2\2hi\7w\2\2ij\7g\2\2jk\7/\2\2kl\7h\2\2lm\7c\2\2mn\7n\2\2no\7u\2"+
		"\2op\7g\2\2p\n\3\2\2\2qr\7o\2\2rs\7c\2\2st\7v\2\2tu\7e\2\2uv\7j\2\2vw"+
		"\7k\2\2wx\7p\2\2xy\7i\2\2y\f\3\2\2\2z{\7o\2\2{|\7k\2\2|}\7u\2\2}~\7u\2"+
		"\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7i\2\2\u0081\u0082\7/\2\2"+
		"\u0082\u0083\7y\2\2\u0083\u0084\7q\2\2\u0084\u0085\7t\2\2\u0085\u0086"+
		"\7f\2\2\u0086\u0087\7u\2\2\u0087\16\3\2\2\2\u0088\u0089\7\"\2\2\u0089"+
		"\20\3\2\2\2\u008a\u008b\7=\2\2\u008b\22\3\2\2\2\u008c\u0092\7$\2\2\u008d"+
		"\u008e\7^\2\2\u008e\u0091\t\2\2\2\u008f\u0091\n\2\2\2\u0090\u008d\3\2"+
		"\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7$"+
		"\2\2\u0096\24\3\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\26\3\2\2\2\u009c"+
		"\u009e\t\3\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a7\3\2\2\2\u00a1\u00a3\7\60\2\2\u00a2"+
		"\u00a4\t\3\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\30\3\2\2\2\u00a9\u00aa\7B\2\2\u00aa\u00ab\7u\2\2"+
		"\u00ab\u00ac\7v\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af"+
		"\7v\2\2\u00af\u00b0\7/\2\2\u00b0\u00b1\7s\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\7g\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7k\2\2"+
		"\u00b6\u00b7\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\32\3\2\2\2\u00b9\u00ba\7"+
		"B\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd\u00be"+
		"\7/\2\2\u00be\u00bf\7s\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7q\2\2"+
		"\u00c5\u00c6\7p\2\2\u00c6\34\3\2\2\2\u00c7\u00c8\7B\2\2\u00c8\u00c9\7"+
		"v\2\2\u00c9\u00ca\7{\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd"+
		"\7\"\2\2\u00cd\36\3\2\2\2\u00ce\u00cf\7B\2\2\u00cf\u00d0\7s\2\2\u00d0"+
		"\u00d1\7w\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7v\2\2"+
		"\u00d4\u00d5\7k\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8"+
		"\7/\2\2\u00d8\u00d9\7d\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7f\2\2\u00db"+
		"\u00dc\7{\2\2\u00dc \3\2\2\2\u00dd\u00de\7B\2\2\u00de\u00df\7e\2\2\u00df"+
		"\u00e0\7q\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7g\2\2"+
		"\u00e3\u00e4\7e\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7"+
		"\7c\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7u\2\2\u00e9\u00ea\7y\2\2\u00ea"+
		"\u00eb\7g\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7u\2\2\u00ed\"\3\2\2\2\u00ee"+
		"\u00ef\7B\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7t\2\2"+
		"\u00f2\u00f3\7t\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7e\2\2\u00f5\u00f6"+
		"\7v\2\2\u00f6\u00f7\7/\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7p\2\2\u00f9"+
		"\u00fa\7u\2\2\u00fa\u00fb\7y\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7t\2\2"+
		"\u00fd\u00fe\7\"\2\2\u00fe$\3\2\2\2\u00ff\u0100\7B\2\2\u0100\u0101\7g"+
		"\2\2\u0101\u0102\7p\2\2\u0102\u0103\7f\2\2\u0103\u0104\7/\2\2\u0104\u0105"+
		"\7e\2\2\u0105\u0106\7q\2\2\u0106\u0107\7t\2\2\u0107\u0108\7t\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010a\7e\2\2\u010a\u010b\7v\2\2\u010b\u010c\7/\2\2"+
		"\u010c\u010d\7c\2\2\u010d\u010e\7p\2\2\u010e\u010f\7u\2\2\u010f\u0110"+
		"\7y\2\2\u0110\u0111\7g\2\2\u0111\u0112\7t\2\2\u0112\u0113\7u\2\2\u0113"+
		"&\3\2\2\2\u0114\u0115\7B\2\2\u0115\u0116\7c\2\2\u0116\u0117\7e\2\2\u0117"+
		"\u0118\7e\2\2\u0118\u0119\7g\2\2\u0119\u011a\7r\2\2\u011a\u011b\7v\2\2"+
		"\u011b\u011c\7g\2\2\u011c\u011d\7f\2\2\u011d\u011e\7/\2\2\u011e\u011f"+
		"\7g\2\2\u011f\u0120\7t\2\2\u0120\u0121\7t\2\2\u0121\u0122\7q\2\2\u0122"+
		"\u0123\7t\2\2\u0123\u0124\7\"\2\2\u0124(\3\2\2\2\u0125\u0126\7B\2\2\u0126"+
		"\u0127\7h\2\2\u0127\u0128\7g\2\2\u0128\u0129\7g\2\2\u0129\u012a\7f\2\2"+
		"\u012a\u012b\7d\2\2\u012b\u012c\7c\2\2\u012c\u012d\7e\2\2\u012d\u012e"+
		"\7m\2\2\u012e\u012f\7\"\2\2\u012f*\3\2\2\2\u0130\u0131\7B\2\2\u0131\u0132"+
		"\7u\2\2\u0132\u0133\7v\2\2\u0133\u0134\7c\2\2\u0134\u0135\7t\2\2\u0135"+
		"\u0136\7v\2\2\u0136\u0137\7/\2\2\u0137\u0138\7q\2\2\u0138\u0139\7r\2\2"+
		"\u0139\u013a\7v\2\2\u013a\u013b\7k\2\2\u013b\u013c\7q\2\2\u013c\u013d"+
		"\7p\2\2\u013d\u013e\7u\2\2\u013e,\3\2\2\2\u013f\u0140\7B\2\2\u0140\u0141"+
		"\7g\2\2\u0141\u0142\7p\2\2\u0142\u0143\7f\2\2\u0143\u0144\7/\2\2\u0144"+
		"\u0145\7q\2\2\u0145\u0146\7r\2\2\u0146\u0147\7v\2\2\u0147\u0148\7k\2\2"+
		"\u0148\u0149\7q\2\2\u0149\u014a\7p\2\2\u014a\u014b\7u\2\2\u014b.\3\2\2"+
		"\2\u014c\u014d\7B\2\2\u014d\u014e\7q\2\2\u014e\u014f\7r\2\2\u014f\u0150"+
		"\7v\2\2\u0150\u0151\7k\2\2\u0151\u0152\7q\2\2\u0152\u0153\7p\2\2\u0153"+
		"\60\3\2\2\2\u0154\u0155\7B\2\2\u0155\u0156\7u\2\2\u0156\u0157\7v\2\2\u0157"+
		"\u0158\7c\2\2\u0158\u0159\7t\2\2\u0159\u015a\7v\2\2\u015a\u015b\7/\2\2"+
		"\u015b\u015c\7o\2\2\u015c\u015d\7c\2\2\u015d\u015e\7v\2\2\u015e\u015f"+
		"\7e\2\2\u015f\u0160\7j\2\2\u0160\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162"+
		"\u0163\7i\2\2\u0163\62\3\2\2\2\u0164\u0165\7B\2\2\u0165\u0166\7g\2\2\u0166"+
		"\u0167\7p\2\2\u0167\u0168\7f\2\2\u0168\u0169\7/\2\2\u0169\u016a\7o\2\2"+
		"\u016a\u016b\7c\2\2\u016b\u016c\7v\2\2\u016c\u016d\7e\2\2\u016d\u016e"+
		"\7j\2\2\u016e\u016f\7k\2\2\u016f\u0170\7p\2\2\u0170\u0171\7i\2\2\u0171"+
		"\64\3\2\2\2\u0172\u0173\7B\2\2\u0173\u0174\7o\2\2\u0174\u0175\7c\2\2\u0175"+
		"\u0176\7v\2\2\u0176\u0177\7e\2\2\u0177\u0178\7j\2\2\u0178\66\3\2\2\2\u0179"+
		"\u017a\7v\2\2\u017a\u017b\7t\2\2\u017b\u017c\7w\2\2\u017c\u017d\7g\2\2"+
		"\u017d8\3\2\2\2\u017e\u017f\7h\2\2\u017f\u0180\7c\2\2\u0180\u0181\7n\2"+
		"\2\u0181\u0182\7u\2\2\u0182\u0183\7g\2\2\u0183:\3\2\2\2\u0184\u0186\t"+
		"\4\2\2\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\36\2\2\u018a<\3\2\2\2"+
		"\u018b\u018c\7\61\2\2\u018c\u018d\7\61\2\2\u018d\u0191\3\2\2\2\u018e\u0190"+
		"\n\5\2\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\b\37"+
		"\2\2\u0195>\3\2\2\2\13\2\u0090\u0092\u009a\u009f\u00a5\u00a7\u0187\u0191"+
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