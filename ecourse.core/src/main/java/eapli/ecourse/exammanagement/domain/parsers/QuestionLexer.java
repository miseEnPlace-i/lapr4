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
		REAL_NUMBER=10, INTEGER=11, START_QUESTION=12, END_QUESTION=13, TYPE=14, 
		QUESTION_BODY=15, START_CORRECT_ANSWERS_SECTION=16, CORRECT_ANSWER=17, 
		END_CORRECT_ANSWERS_SECTION=18, ACCEPTED_ERROR=19, FEEDBACK=20, START_OPTIONS_SECTION=21, 
		END_OPTIONS_SECTION=22, OPTION=23, SCORE=24, START_MATCHING_SECTION=25, 
		END_MATCHING_SECTION=26, MATCH=27, TRUE=28, FALSE=29, WS=30, COMMENT=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "EOI", "STRING", "NUMBER", 
			"REAL_NUMBER", "INTEGER", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
			"START_CORRECT_ANSWERS_SECTION", "CORRECT_ANSWER", "END_CORRECT_ANSWERS_SECTION", 
			"ACCEPTED_ERROR", "FEEDBACK", "START_OPTIONS_SECTION", "END_OPTIONS_SECTION", 
			"OPTION", "SCORE", "START_MATCHING_SECTION", "END_MATCHING_SECTION", 
			"MATCH", "TRUE", "FALSE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numerical'", "'multiple-choice'", "'short-answer'", "'true-false'", 
			"'matching'", "'missing-words'", "';'", null, null, null, null, "'@start-question'", 
			"'@end-question'", "'@type'", "'@question-body'", "'@start-correct-answers'", 
			"'@correct-answer'", "'@end-correct-answers'", "'@accepted-error'", "'@feedback'", 
			"'@start-options'", "'@end-options'", "'@option'", "'@score'", "'@start-matching'", 
			"'@end-matching'", "'@match'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "EOI", "STRING", "NUMBER", 
			"REAL_NUMBER", "INTEGER", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
			"START_CORRECT_ANSWERS_SECTION", "CORRECT_ANSWER", "END_CORRECT_ANSWERS_SECTION", 
			"ACCEPTED_ERROR", "FEEDBACK", "START_OPTIONS_SECTION", "END_OPTIONS_SECTION", 
			"OPTION", "SCORE", "START_MATCHING_SECTION", "END_MATCHING_SECTION", 
			"MATCH", "TRUE", "FALSE", "WS", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u01ac\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3\t"+
		"\3\t\3\t\3\t\3\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t\5\t\u00a1\n\t\3"+
		"\n\3\n\5\n\u00a5\n\n\3\13\6\13\u00a8\n\13\r\13\16\13\u00a9\3\13\3\13\6"+
		"\13\u00ae\n\13\r\13\16\13\u00af\3\f\6\f\u00b3\n\f\r\f\16\f\u00b4\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\6\37\u019c\n\37\r\37\16\37\u019d\3\37\3\37\3 \3 \3 \3 \7 \u01a6\n"+
		" \f \16 \u01a9\13 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!\3\2\7\4\2$$^^\4\2^^pp\3\2\62;\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\2\u01b6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2"+
		"\2\5K\3\2\2\2\7[\3\2\2\2\th\3\2\2\2\13s\3\2\2\2\r|\3\2\2\2\17\u008a\3"+
		"\2\2\2\21\u00a0\3\2\2\2\23\u00a4\3\2\2\2\25\u00a7\3\2\2\2\27\u00b2\3\2"+
		"\2\2\31\u00b6\3\2\2\2\33\u00c6\3\2\2\2\35\u00d4\3\2\2\2\37\u00da\3\2\2"+
		"\2!\u00e9\3\2\2\2#\u0100\3\2\2\2%\u0110\3\2\2\2\'\u0125\3\2\2\2)\u0135"+
		"\3\2\2\2+\u013f\3\2\2\2-\u014e\3\2\2\2/\u015b\3\2\2\2\61\u0163\3\2\2\2"+
		"\63\u016a\3\2\2\2\65\u017a\3\2\2\2\67\u0188\3\2\2\29\u018f\3\2\2\2;\u0194"+
		"\3\2\2\2=\u019b\3\2\2\2?\u01a1\3\2\2\2AB\7p\2\2BC\7w\2\2CD\7o\2\2DE\7"+
		"g\2\2EF\7t\2\2FG\7k\2\2GH\7e\2\2HI\7c\2\2IJ\7n\2\2J\4\3\2\2\2KL\7o\2\2"+
		"LM\7w\2\2MN\7n\2\2NO\7v\2\2OP\7k\2\2PQ\7r\2\2QR\7n\2\2RS\7g\2\2ST\7/\2"+
		"\2TU\7e\2\2UV\7j\2\2VW\7q\2\2WX\7k\2\2XY\7e\2\2YZ\7g\2\2Z\6\3\2\2\2[\\"+
		"\7u\2\2\\]\7j\2\2]^\7q\2\2^_\7t\2\2_`\7v\2\2`a\7/\2\2ab\7c\2\2bc\7p\2"+
		"\2cd\7u\2\2de\7y\2\2ef\7g\2\2fg\7t\2\2g\b\3\2\2\2hi\7v\2\2ij\7t\2\2jk"+
		"\7w\2\2kl\7g\2\2lm\7/\2\2mn\7h\2\2no\7c\2\2op\7n\2\2pq\7u\2\2qr\7g\2\2"+
		"r\n\3\2\2\2st\7o\2\2tu\7c\2\2uv\7v\2\2vw\7e\2\2wx\7j\2\2xy\7k\2\2yz\7"+
		"p\2\2z{\7i\2\2{\f\3\2\2\2|}\7o\2\2}~\7k\2\2~\177\7u\2\2\177\u0080\7u\2"+
		"\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7i\2\2\u0083\u0084"+
		"\7/\2\2\u0084\u0085\7y\2\2\u0085\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087"+
		"\u0088\7f\2\2\u0088\u0089\7u\2\2\u0089\16\3\2\2\2\u008a\u008b\7=\2\2\u008b"+
		"\20\3\2\2\2\u008c\u0092\7$\2\2\u008d\u008e\7^\2\2\u008e\u0091\t\2\2\2"+
		"\u008f\u0091\n\2\2\2\u0090\u008d\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u0094"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u00a1\7$\2\2\u0096\u009c\7$\2\2\u0097\u0098\7^\2"+
		"\2\u0098\u009b\t\3\2\2\u0099\u009b\n\2\2\2\u009a\u0097\3\2\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7$\2\2\u00a0\u008c\3\2"+
		"\2\2\u00a0\u0096\3\2\2\2\u00a1\22\3\2\2\2\u00a2\u00a5\5\25\13\2\u00a3"+
		"\u00a5\5\27\f\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\24\3\2\2"+
		"\2\u00a6\u00a8\t\4\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\7\60\2\2"+
		"\u00ac\u00ae\t\4\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\26\3\2\2\2\u00b1\u00b3\t\4\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7B\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9"+
		"\7v\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7v\2\2\u00bc"+
		"\u00bd\7/\2\2\u00bd\u00be\7s\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7g\2\2"+
		"\u00c0\u00c1\7u\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4"+
		"\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\32\3\2\2\2\u00c6\u00c7\7B\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7/\2\2\u00cb"+
		"\u00cc\7s\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7u\2\2"+
		"\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3"+
		"\7p\2\2\u00d3\34\3\2\2\2\u00d4\u00d5\7B\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7"+
		"\7{\2\2\u00d7\u00d8\7r\2\2\u00d8\u00d9\7g\2\2\u00d9\36\3\2\2\2\u00da\u00db"+
		"\7B\2\2\u00db\u00dc\7s\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7u\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7q\2\2"+
		"\u00e2\u00e3\7p\2\2\u00e3\u00e4\7/\2\2\u00e4\u00e5\7d\2\2\u00e5\u00e6"+
		"\7q\2\2\u00e6\u00e7\7f\2\2\u00e7\u00e8\7{\2\2\u00e8 \3\2\2\2\u00e9\u00ea"+
		"\7B\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7c\2\2\u00ed"+
		"\u00ee\7t\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7/\2\2\u00f0\u00f1\7e\2\2"+
		"\u00f1\u00f2\7q\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5"+
		"\7g\2\2\u00f5\u00f6\7e\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7/\2\2\u00f8"+
		"\u00f9\7c\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7y\2\2"+
		"\u00fc\u00fd\7g\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7u\2\2\u00ff\"\3\2"+
		"\2\2\u0100\u0101\7B\2\2\u0101\u0102\7e\2\2\u0102\u0103\7q\2\2\u0103\u0104"+
		"\7t\2\2\u0104\u0105\7t\2\2\u0105\u0106\7g\2\2\u0106\u0107\7e\2\2\u0107"+
		"\u0108\7v\2\2\u0108\u0109\7/\2\2\u0109\u010a\7c\2\2\u010a\u010b\7p\2\2"+
		"\u010b\u010c\7u\2\2\u010c\u010d\7y\2\2\u010d\u010e\7g\2\2\u010e\u010f"+
		"\7t\2\2\u010f$\3\2\2\2\u0110\u0111\7B\2\2\u0111\u0112\7g\2\2\u0112\u0113"+
		"\7p\2\2\u0113\u0114\7f\2\2\u0114\u0115\7/\2\2\u0115\u0116\7e\2\2\u0116"+
		"\u0117\7q\2\2\u0117\u0118\7t\2\2\u0118\u0119\7t\2\2\u0119\u011a\7g\2\2"+
		"\u011a\u011b\7e\2\2\u011b\u011c\7v\2\2\u011c\u011d\7/\2\2\u011d\u011e"+
		"\7c\2\2\u011e\u011f\7p\2\2\u011f\u0120\7u\2\2\u0120\u0121\7y\2\2\u0121"+
		"\u0122\7g\2\2\u0122\u0123\7t\2\2\u0123\u0124\7u\2\2\u0124&\3\2\2\2\u0125"+
		"\u0126\7B\2\2\u0126\u0127\7c\2\2\u0127\u0128\7e\2\2\u0128\u0129\7e\2\2"+
		"\u0129\u012a\7g\2\2\u012a\u012b\7r\2\2\u012b\u012c\7v\2\2\u012c\u012d"+
		"\7g\2\2\u012d\u012e\7f\2\2\u012e\u012f\7/\2\2\u012f\u0130\7g\2\2\u0130"+
		"\u0131\7t\2\2\u0131\u0132\7t\2\2\u0132\u0133\7q\2\2\u0133\u0134\7t\2\2"+
		"\u0134(\3\2\2\2\u0135\u0136\7B\2\2\u0136\u0137\7h\2\2\u0137\u0138\7g\2"+
		"\2\u0138\u0139\7g\2\2\u0139\u013a\7f\2\2\u013a\u013b\7d\2\2\u013b\u013c"+
		"\7c\2\2\u013c\u013d\7e\2\2\u013d\u013e\7m\2\2\u013e*\3\2\2\2\u013f\u0140"+
		"\7B\2\2\u0140\u0141\7u\2\2\u0141\u0142\7v\2\2\u0142\u0143\7c\2\2\u0143"+
		"\u0144\7t\2\2\u0144\u0145\7v\2\2\u0145\u0146\7/\2\2\u0146\u0147\7q\2\2"+
		"\u0147\u0148\7r\2\2\u0148\u0149\7v\2\2\u0149\u014a\7k\2\2\u014a\u014b"+
		"\7q\2\2\u014b\u014c\7p\2\2\u014c\u014d\7u\2\2\u014d,\3\2\2\2\u014e\u014f"+
		"\7B\2\2\u014f\u0150\7g\2\2\u0150\u0151\7p\2\2\u0151\u0152\7f\2\2\u0152"+
		"\u0153\7/\2\2\u0153\u0154\7q\2\2\u0154\u0155\7r\2\2\u0155\u0156\7v\2\2"+
		"\u0156\u0157\7k\2\2\u0157\u0158\7q\2\2\u0158\u0159\7p\2\2\u0159\u015a"+
		"\7u\2\2\u015a.\3\2\2\2\u015b\u015c\7B\2\2\u015c\u015d\7q\2\2\u015d\u015e"+
		"\7r\2\2\u015e\u015f\7v\2\2\u015f\u0160\7k\2\2\u0160\u0161\7q\2\2\u0161"+
		"\u0162\7p\2\2\u0162\60\3\2\2\2\u0163\u0164\7B\2\2\u0164\u0165\7u\2\2\u0165"+
		"\u0166\7e\2\2\u0166\u0167\7q\2\2\u0167\u0168\7t\2\2\u0168\u0169\7g\2\2"+
		"\u0169\62\3\2\2\2\u016a\u016b\7B\2\2\u016b\u016c\7u\2\2\u016c\u016d\7"+
		"v\2\2\u016d\u016e\7c\2\2\u016e\u016f\7t\2\2\u016f\u0170\7v\2\2\u0170\u0171"+
		"\7/\2\2\u0171\u0172\7o\2\2\u0172\u0173\7c\2\2\u0173\u0174\7v\2\2\u0174"+
		"\u0175\7e\2\2\u0175\u0176\7j\2\2\u0176\u0177\7k\2\2\u0177\u0178\7p\2\2"+
		"\u0178\u0179\7i\2\2\u0179\64\3\2\2\2\u017a\u017b\7B\2\2\u017b\u017c\7"+
		"g\2\2\u017c\u017d\7p\2\2\u017d\u017e\7f\2\2\u017e\u017f\7/\2\2\u017f\u0180"+
		"\7o\2\2\u0180\u0181\7c\2\2\u0181\u0182\7v\2\2\u0182\u0183\7e\2\2\u0183"+
		"\u0184\7j\2\2\u0184\u0185\7k\2\2\u0185\u0186\7p\2\2\u0186\u0187\7i\2\2"+
		"\u0187\66\3\2\2\2\u0188\u0189\7B\2\2\u0189\u018a\7o\2\2\u018a\u018b\7"+
		"c\2\2\u018b\u018c\7v\2\2\u018c\u018d\7e\2\2\u018d\u018e\7j\2\2\u018e8"+
		"\3\2\2\2\u018f\u0190\7v\2\2\u0190\u0191\7t\2\2\u0191\u0192\7w\2\2\u0192"+
		"\u0193\7g\2\2\u0193:\3\2\2\2\u0194\u0195\7h\2\2\u0195\u0196\7c\2\2\u0196"+
		"\u0197\7n\2\2\u0197\u0198\7u\2\2\u0198\u0199\7g\2\2\u0199<\3\2\2\2\u019a"+
		"\u019c\t\5\2\2\u019b\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019b\3\2"+
		"\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\b\37\2\2\u01a0"+
		">\3\2\2\2\u01a1\u01a2\7\61\2\2\u01a2\u01a3\7\61\2\2\u01a3\u01a7\3\2\2"+
		"\2\u01a4\u01a6\n\6\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5"+
		"\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa"+
		"\u01ab\b \2\2\u01ab@\3\2\2\2\16\2\u0090\u0092\u009a\u009c\u00a0\u00a4"+
		"\u00a9\u00af\u00b4\u019d\u01a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}