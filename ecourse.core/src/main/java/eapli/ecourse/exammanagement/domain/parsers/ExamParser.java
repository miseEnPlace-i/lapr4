// Generated from /home/russo/isep/lapr4/sem4pi-22-23-19/ecourse.core/src/main/java/eapli/ecourse/exammanagement/domain/grammars/Exam/Exam.g4 by ANTLR 4.9.2
package eapli.ecourse.exammanagement.domain.parsers;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExamParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, EOI=8, STRING=9, 
		START_EXAM=10, END_EXAM=11, TITLE=12, DESCRIPTION=13, FEEDBACK=14, GRADE=15, 
		START_SECTION=16, END_SECTION=17, SCORE=18, START_QUESTION=19, END_QUESTION=20, 
		TYPE=21, QUESTION_BODY=22, START_CORRECT_ANSWERS_SECTION=23, CORRECT_ANSWER=24, 
		END_CORRECT_ANSWERS_SECTION=25, ACCEPTED_ERROR=26, START_OPTIONS_SECTION=27, 
		END_OPTIONS_SECTION=28, OPTION=29, START_MATCHING_SECTION=30, END_MATCHING_SECTION=31, 
		MATCH=32, TRUE=33, FALSE=34, FDB_GRD_TYPE=35, NUMBER=36, REAL_NUMBER=37, 
		INTEGER=38, IDENTIFIER=39, WS=40, COMMENT=41;
	public static final int
		RULE_start = 0, RULE_exam = 1, RULE_sections = 2, RULE_section = 3, RULE_questions = 4, 
		RULE_header = 5, RULE_properties = 6, RULE_title = 7, RULE_description = 8, 
		RULE_feedback_header = 9, RULE_grade = 10, RULE_start_exam = 11, RULE_end_exam = 12, 
		RULE_start_section = 13, RULE_end_section = 14, RULE_question = 15, RULE_numericalQuestion = 16, 
		RULE_multipleChoiceQuestion = 17, RULE_shortAnswerQuestion = 18, RULE_trueFalseQuestion = 19, 
		RULE_matchingQuestion = 20, RULE_missingWordsQuestion = 21, RULE_body = 22, 
		RULE_feedback = 23, RULE_score = 24, RULE_shortAnswerCorrectAnswer = 25, 
		RULE_multipleChoiceCorrectAnswer = 26, RULE_numericalCorrectAnswer = 27, 
		RULE_numericalAcceptedError = 28, RULE_option = 29, RULE_missingWordsOption = 30, 
		RULE_match = 31, RULE_matchingCorrectAnswer = 32, RULE_missingWordsCorrectAnswer = 33, 
		RULE_trueFalseCorrectAnswer = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exam", "sections", "section", "questions", "header", "properties", 
			"title", "description", "feedback_header", "grade", "start_exam", "end_exam", 
			"start_section", "end_section", "question", "numericalQuestion", "multipleChoiceQuestion", 
			"shortAnswerQuestion", "trueFalseQuestion", "matchingQuestion", "missingWordsQuestion", 
			"body", "feedback", "score", "shortAnswerCorrectAnswer", "multipleChoiceCorrectAnswer", 
			"numericalCorrectAnswer", "numericalAcceptedError", "option", "missingWordsOption", 
			"match", "matchingCorrectAnswer", "missingWordsCorrectAnswer", "trueFalseCorrectAnswer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numerical'", "'multiple-choice'", "'short-answer'", "'true-false'", 
			"'matching'", "'missing-words'", "'-'", "';'", null, "'@start-exam'", 
			"'@end-exam'", "'@title'", "'@description'", "'@feedback'", "'@grade'", 
			"'@start-section'", "'@end-section'", "'@score'", "'@start-question'", 
			"'@end-question'", "'@type'", "'@question-body'", "'@start-correct-answers'", 
			"'@correct-answer'", "'@end-correct-answers'", "'@accepted-error'", "'@start-options'", 
			"'@end-options'", "'@option'", "'@start-matching'", "'@end-matching'", 
			"'@match'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "EOI", "STRING", "START_EXAM", 
			"END_EXAM", "TITLE", "DESCRIPTION", "FEEDBACK", "GRADE", "START_SECTION", 
			"END_SECTION", "SCORE", "START_QUESTION", "END_QUESTION", "TYPE", "QUESTION_BODY", 
			"START_CORRECT_ANSWERS_SECTION", "CORRECT_ANSWER", "END_CORRECT_ANSWERS_SECTION", 
			"ACCEPTED_ERROR", "START_OPTIONS_SECTION", "END_OPTIONS_SECTION", "OPTION", 
			"START_MATCHING_SECTION", "END_MATCHING_SECTION", "MATCH", "TRUE", "FALSE", 
			"FDB_GRD_TYPE", "NUMBER", "REAL_NUMBER", "INTEGER", "IDENTIFIER", "WS", 
			"COMMENT"
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
	public String getGrammarFileName() { return "Exam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExamContext exam() {
			return getRuleContext(ExamContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			exam();
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

	public static class ExamContext extends ParserRuleContext {
		public Start_examContext start_exam() {
			return getRuleContext(Start_examContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public SectionsContext sections() {
			return getRuleContext(SectionsContext.class,0);
		}
		public End_examContext end_exam() {
			return getRuleContext(End_examContext.class,0);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitExam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitExam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			start_exam();
			setState(73);
			header();
			setState(74);
			sections();
			setState(75);
			end_exam();
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

	public static class SectionsContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public SectionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sections; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterSections(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitSections(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitSections(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionsContext sections() throws RecognitionException {
		SectionsContext _localctx = new SectionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sections);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				section();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==START_SECTION );
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

	public static class SectionContext extends ParserRuleContext {
		public Start_sectionContext start_section() {
			return getRuleContext(Start_sectionContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public QuestionsContext questions() {
			return getRuleContext(QuestionsContext.class,0);
		}
		public End_sectionContext end_section() {
			return getRuleContext(End_sectionContext.class,0);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			start_section();
			setState(83);
			header();
			setState(84);
			questions();
			setState(85);
			end_section();
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

	public static class QuestionsContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitQuestions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionsContext questions() throws RecognitionException {
		QuestionsContext _localctx = new QuestionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				question();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==START_QUESTION );
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

	public static class HeaderContext extends ParserRuleContext {
		public List<PropertiesContext> properties() {
			return getRuleContexts(PropertiesContext.class);
		}
		public PropertiesContext properties(int i) {
			return getRuleContext(PropertiesContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				properties();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TITLE) | (1L << DESCRIPTION) | (1L << FEEDBACK) | (1L << GRADE))) != 0) );
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

	public static class PropertiesContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Feedback_headerContext feedback_header() {
			return getRuleContext(Feedback_headerContext.class,0);
		}
		public GradeContext grade() {
			return getRuleContext(GradeContext.class,0);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_properties);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TITLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				title();
				}
				break;
			case DESCRIPTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				description();
				}
				break;
			case FEEDBACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				feedback_header();
				}
				break;
			case GRADE:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				grade();
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

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TITLE() { return getToken(ExamParser.TITLE, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(TITLE);
			setState(104);
			match(STRING);
			setState(105);
			match(EOI);
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

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode DESCRIPTION() { return getToken(ExamParser.DESCRIPTION, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(DESCRIPTION);
			setState(108);
			match(STRING);
			setState(109);
			match(EOI);
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

	public static class Feedback_headerContext extends ParserRuleContext {
		public TerminalNode FEEDBACK() { return getToken(ExamParser.FEEDBACK, 0); }
		public TerminalNode FDB_GRD_TYPE() { return getToken(ExamParser.FDB_GRD_TYPE, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public Feedback_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterFeedback_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitFeedback_header(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitFeedback_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feedback_headerContext feedback_header() throws RecognitionException {
		Feedback_headerContext _localctx = new Feedback_headerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_feedback_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(FEEDBACK);
			setState(112);
			match(FDB_GRD_TYPE);
			setState(113);
			match(EOI);
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

	public static class GradeContext extends ParserRuleContext {
		public TerminalNode GRADE() { return getToken(ExamParser.GRADE, 0); }
		public TerminalNode FDB_GRD_TYPE() { return getToken(ExamParser.FDB_GRD_TYPE, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitGrade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeContext grade() throws RecognitionException {
		GradeContext _localctx = new GradeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(GRADE);
			setState(116);
			match(FDB_GRD_TYPE);
			setState(117);
			match(EOI);
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

	public static class Start_examContext extends ParserRuleContext {
		public TerminalNode START_EXAM() { return getToken(ExamParser.START_EXAM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ExamParser.IDENTIFIER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public Start_examContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterStart_exam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitStart_exam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitStart_exam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_examContext start_exam() throws RecognitionException {
		Start_examContext _localctx = new Start_examContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_start_exam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(START_EXAM);
			setState(120);
			match(IDENTIFIER);
			setState(121);
			match(EOI);
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

	public static class End_examContext extends ParserRuleContext {
		public TerminalNode END_EXAM() { return getToken(ExamParser.END_EXAM, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public End_examContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterEnd_exam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitEnd_exam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitEnd_exam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_examContext end_exam() throws RecognitionException {
		End_examContext _localctx = new End_examContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_end_exam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(END_EXAM);
			setState(124);
			match(EOI);
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

	public static class Start_sectionContext extends ParserRuleContext {
		public TerminalNode START_SECTION() { return getToken(ExamParser.START_SECTION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ExamParser.IDENTIFIER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public Start_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterStart_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitStart_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitStart_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_sectionContext start_section() throws RecognitionException {
		Start_sectionContext _localctx = new Start_sectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_start_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(START_SECTION);
			setState(127);
			match(IDENTIFIER);
			setState(128);
			match(EOI);
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

	public static class End_sectionContext extends ParserRuleContext {
		public TerminalNode END_SECTION() { return getToken(ExamParser.END_SECTION, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public End_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterEnd_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitEnd_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitEnd_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_sectionContext end_section() throws RecognitionException {
		End_sectionContext _localctx = new End_sectionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_end_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(END_SECTION);
			setState(131);
			match(EOI);
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode START_QUESTION() { return getToken(ExamParser.START_QUESTION, 0); }
		public TerminalNode TYPE() { return getToken(ExamParser.TYPE, 0); }
		public TerminalNode END_QUESTION() { return getToken(ExamParser.END_QUESTION, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public NumericalQuestionContext numericalQuestion() {
			return getRuleContext(NumericalQuestionContext.class,0);
		}
		public MultipleChoiceQuestionContext multipleChoiceQuestion() {
			return getRuleContext(MultipleChoiceQuestionContext.class,0);
		}
		public ShortAnswerQuestionContext shortAnswerQuestion() {
			return getRuleContext(ShortAnswerQuestionContext.class,0);
		}
		public TrueFalseQuestionContext trueFalseQuestion() {
			return getRuleContext(TrueFalseQuestionContext.class,0);
		}
		public MatchingQuestionContext matchingQuestion() {
			return getRuleContext(MatchingQuestionContext.class,0);
		}
		public MissingWordsQuestionContext missingWordsQuestion() {
			return getRuleContext(MissingWordsQuestionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(START_QUESTION);
			setState(134);
			match(TYPE);
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(135);
				numericalQuestion();
				}
				break;
			case T__1:
				{
				setState(136);
				multipleChoiceQuestion();
				}
				break;
			case T__2:
				{
				setState(137);
				shortAnswerQuestion();
				}
				break;
			case T__3:
				{
				setState(138);
				trueFalseQuestion();
				}
				break;
			case T__4:
				{
				setState(139);
				matchingQuestion();
				}
				break;
			case T__5:
				{
				setState(140);
				missingWordsQuestion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(143);
			match(END_QUESTION);
			setState(144);
			match(EOI);
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

	public static class NumericalQuestionContext extends ParserRuleContext {
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public NumericalCorrectAnswerContext numericalCorrectAnswer() {
			return getRuleContext(NumericalCorrectAnswerContext.class,0);
		}
		public NumericalAcceptedErrorContext numericalAcceptedError() {
			return getRuleContext(NumericalAcceptedErrorContext.class,0);
		}
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public NumericalQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalQuestionContext numericalQuestion() throws RecognitionException {
		NumericalQuestionContext _localctx = new NumericalQuestionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_numericalQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__0);
			setState(147);
			match(EOI);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(148);
				score();
				}
			}

			setState(151);
			body();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(152);
				feedback();
				}
			}

			setState(155);
			numericalCorrectAnswer();
			setState(156);
			numericalAcceptedError();
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

	public static class MultipleChoiceQuestionContext extends ParserRuleContext {
		public List<TerminalNode> EOI() { return getTokens(ExamParser.EOI); }
		public TerminalNode EOI(int i) {
			return getToken(ExamParser.EOI, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode START_OPTIONS_SECTION() { return getToken(ExamParser.START_OPTIONS_SECTION, 0); }
		public TerminalNode END_OPTIONS_SECTION() { return getToken(ExamParser.END_OPTIONS_SECTION, 0); }
		public TerminalNode START_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.START_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode END_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.END_CORRECT_ANSWERS_SECTION, 0); }
		public List<MultipleChoiceCorrectAnswerContext> multipleChoiceCorrectAnswer() {
			return getRuleContexts(MultipleChoiceCorrectAnswerContext.class);
		}
		public MultipleChoiceCorrectAnswerContext multipleChoiceCorrectAnswer(int i) {
			return getRuleContext(MultipleChoiceCorrectAnswerContext.class,i);
		}
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public MultipleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multipleChoiceQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__1);
			setState(159);
			match(EOI);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(160);
				score();
				}
			}

			setState(163);
			body();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(164);
				feedback();
				}
			}

			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START_CORRECT_ANSWERS_SECTION:
				{
				setState(167);
				match(START_CORRECT_ANSWERS_SECTION);
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(168);
					multipleChoiceCorrectAnswer();
					}
					}
					setState(171); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CORRECT_ANSWER );
				setState(173);
				match(END_CORRECT_ANSWERS_SECTION);
				setState(174);
				match(EOI);
				}
				break;
			case CORRECT_ANSWER:
				{
				setState(176);
				multipleChoiceCorrectAnswer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(179);
			match(START_OPTIONS_SECTION);
			setState(181); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				option();
				}
				}
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPTION );
			setState(185);
			match(END_OPTIONS_SECTION);
			setState(186);
			match(EOI);
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

	public static class ShortAnswerQuestionContext extends ParserRuleContext {
		public List<TerminalNode> EOI() { return getTokens(ExamParser.EOI); }
		public TerminalNode EOI(int i) {
			return getToken(ExamParser.EOI, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode START_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.START_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode END_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.END_CORRECT_ANSWERS_SECTION, 0); }
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<ShortAnswerCorrectAnswerContext> shortAnswerCorrectAnswer() {
			return getRuleContexts(ShortAnswerCorrectAnswerContext.class);
		}
		public ShortAnswerCorrectAnswerContext shortAnswerCorrectAnswer(int i) {
			return getRuleContext(ShortAnswerCorrectAnswerContext.class,i);
		}
		public ShortAnswerQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterShortAnswerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitShortAnswerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitShortAnswerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerQuestionContext shortAnswerQuestion() throws RecognitionException {
		ShortAnswerQuestionContext _localctx = new ShortAnswerQuestionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_shortAnswerQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__2);
			setState(189);
			match(EOI);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(190);
				score();
				}
			}

			setState(193);
			body();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(194);
				feedback();
				}
			}

			setState(197);
			match(START_CORRECT_ANSWERS_SECTION);
			setState(199); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(198);
				shortAnswerCorrectAnswer();
				}
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER );
			setState(203);
			match(END_CORRECT_ANSWERS_SECTION);
			setState(204);
			match(EOI);
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

	public static class TrueFalseQuestionContext extends ParserRuleContext {
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TrueFalseCorrectAnswerContext trueFalseCorrectAnswer() {
			return getRuleContext(TrueFalseCorrectAnswerContext.class,0);
		}
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public TrueFalseQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalseQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseQuestionContext trueFalseQuestion() throws RecognitionException {
		TrueFalseQuestionContext _localctx = new TrueFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_trueFalseQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__3);
			setState(207);
			match(EOI);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(208);
				score();
				}
			}

			setState(211);
			body();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(212);
				feedback();
				}
			}

			setState(215);
			trueFalseCorrectAnswer();
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

	public static class MatchingQuestionContext extends ParserRuleContext {
		public List<TerminalNode> EOI() { return getTokens(ExamParser.EOI); }
		public TerminalNode EOI(int i) {
			return getToken(ExamParser.EOI, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode START_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.START_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode END_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.END_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode START_OPTIONS_SECTION() { return getToken(ExamParser.START_OPTIONS_SECTION, 0); }
		public TerminalNode END_OPTIONS_SECTION() { return getToken(ExamParser.END_OPTIONS_SECTION, 0); }
		public TerminalNode START_MATCHING_SECTION() { return getToken(ExamParser.START_MATCHING_SECTION, 0); }
		public TerminalNode END_MATCHING_SECTION() { return getToken(ExamParser.END_MATCHING_SECTION, 0); }
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<MatchingCorrectAnswerContext> matchingCorrectAnswer() {
			return getRuleContexts(MatchingCorrectAnswerContext.class);
		}
		public MatchingCorrectAnswerContext matchingCorrectAnswer(int i) {
			return getRuleContext(MatchingCorrectAnswerContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<MatchContext> match() {
			return getRuleContexts(MatchContext.class);
		}
		public MatchContext match(int i) {
			return getRuleContext(MatchContext.class,i);
		}
		public MatchingQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingQuestionContext matchingQuestion() throws RecognitionException {
		MatchingQuestionContext _localctx = new MatchingQuestionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_matchingQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__4);
			setState(218);
			match(EOI);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(219);
				score();
				}
			}

			setState(222);
			body();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(223);
				feedback();
				}
			}

			setState(226);
			match(START_CORRECT_ANSWERS_SECTION);
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				matchingCorrectAnswer();
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER );
			setState(232);
			match(END_CORRECT_ANSWERS_SECTION);
			setState(233);
			match(EOI);
			setState(234);
			match(START_OPTIONS_SECTION);
			setState(236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235);
				option();
				}
				}
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPTION );
			setState(240);
			match(END_OPTIONS_SECTION);
			setState(241);
			match(EOI);
			setState(242);
			match(START_MATCHING_SECTION);
			setState(244); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				match();
				}
				}
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MATCH );
			setState(248);
			match(END_MATCHING_SECTION);
			setState(249);
			match(EOI);
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

	public static class MissingWordsQuestionContext extends ParserRuleContext {
		public List<TerminalNode> EOI() { return getTokens(ExamParser.EOI); }
		public TerminalNode EOI(int i) {
			return getToken(ExamParser.EOI, i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode START_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.START_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode END_CORRECT_ANSWERS_SECTION() { return getToken(ExamParser.END_CORRECT_ANSWERS_SECTION, 0); }
		public TerminalNode START_OPTIONS_SECTION() { return getToken(ExamParser.START_OPTIONS_SECTION, 0); }
		public TerminalNode END_OPTIONS_SECTION() { return getToken(ExamParser.END_OPTIONS_SECTION, 0); }
		public ScoreContext score() {
			return getRuleContext(ScoreContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<MissingWordsCorrectAnswerContext> missingWordsCorrectAnswer() {
			return getRuleContexts(MissingWordsCorrectAnswerContext.class);
		}
		public MissingWordsCorrectAnswerContext missingWordsCorrectAnswer(int i) {
			return getRuleContext(MissingWordsCorrectAnswerContext.class,i);
		}
		public List<MissingWordsOptionContext> missingWordsOption() {
			return getRuleContexts(MissingWordsOptionContext.class);
		}
		public MissingWordsOptionContext missingWordsOption(int i) {
			return getRuleContext(MissingWordsOptionContext.class,i);
		}
		public MissingWordsQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingWordsQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingWordsQuestionContext missingWordsQuestion() throws RecognitionException {
		MissingWordsQuestionContext _localctx = new MissingWordsQuestionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_missingWordsQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__5);
			setState(252);
			match(EOI);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCORE) {
				{
				setState(253);
				score();
				}
			}

			setState(256);
			body();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK) {
				{
				setState(257);
				feedback();
				}
			}

			setState(260);
			match(START_CORRECT_ANSWERS_SECTION);
			setState(262); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(261);
				missingWordsCorrectAnswer();
				}
				}
				setState(264); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER );
			setState(266);
			match(END_CORRECT_ANSWERS_SECTION);
			setState(267);
			match(EOI);
			setState(268);
			match(START_OPTIONS_SECTION);
			setState(270); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(269);
				missingWordsOption();
				}
				}
				setState(272); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPTION );
			setState(274);
			match(END_OPTIONS_SECTION);
			setState(275);
			match(EOI);
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

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode QUESTION_BODY() { return getToken(ExamParser.QUESTION_BODY, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(QUESTION_BODY);
			setState(278);
			match(STRING);
			setState(279);
			match(EOI);
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

	public static class FeedbackContext extends ParserRuleContext {
		public TerminalNode FEEDBACK() { return getToken(ExamParser.FEEDBACK, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_feedback);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(FEEDBACK);
			setState(282);
			match(STRING);
			setState(283);
			match(EOI);
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

	public static class ScoreContext extends ParserRuleContext {
		public TerminalNode SCORE() { return getToken(ExamParser.SCORE, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public ScoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_score; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterScore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitScore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitScore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScoreContext score() throws RecognitionException {
		ScoreContext _localctx = new ScoreContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_score);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(SCORE);
			setState(286);
			match(NUMBER);
			setState(287);
			match(EOI);
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

	public static class ShortAnswerCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public ShortAnswerCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterShortAnswerCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitShortAnswerCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitShortAnswerCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerCorrectAnswerContext shortAnswerCorrectAnswer() throws RecognitionException {
		ShortAnswerCorrectAnswerContext _localctx = new ShortAnswerCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shortAnswerCorrectAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(CORRECT_ANSWER);
			setState(290);
			match(STRING);
			setState(291);
			match(NUMBER);
			setState(292);
			match(EOI);
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

	public static class MultipleChoiceCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(ExamParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ExamParser.NUMBER, i);
		}
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public MultipleChoiceCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMultipleChoiceCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMultipleChoiceCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMultipleChoiceCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceCorrectAnswerContext multipleChoiceCorrectAnswer() throws RecognitionException {
		MultipleChoiceCorrectAnswerContext _localctx = new MultipleChoiceCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_multipleChoiceCorrectAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(CORRECT_ANSWER);
			setState(295);
			match(NUMBER);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(296);
				match(NUMBER);
				}
			}

			setState(299);
			match(EOI);
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

	public static class NumericalCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public NumericalCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterNumericalCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitNumericalCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitNumericalCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalCorrectAnswerContext numericalCorrectAnswer() throws RecognitionException {
		NumericalCorrectAnswerContext _localctx = new NumericalCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_numericalCorrectAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(CORRECT_ANSWER);
			setState(302);
			match(NUMBER);
			setState(303);
			match(EOI);
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

	public static class NumericalAcceptedErrorContext extends ParserRuleContext {
		public TerminalNode ACCEPTED_ERROR() { return getToken(ExamParser.ACCEPTED_ERROR, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public NumericalAcceptedErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalAcceptedError; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterNumericalAcceptedError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitNumericalAcceptedError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitNumericalAcceptedError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalAcceptedErrorContext numericalAcceptedError() throws RecognitionException {
		NumericalAcceptedErrorContext _localctx = new NumericalAcceptedErrorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numericalAcceptedError);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(ACCEPTED_ERROR);
			setState(306);
			match(NUMBER);
			setState(307);
			match(EOI);
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

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(ExamParser.OPTION, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public List<TerminalNode> STRING() { return getTokens(ExamParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExamParser.STRING, i);
		}
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(OPTION);
			setState(310);
			match(NUMBER);
			setState(311);
			match(STRING);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(312);
				match(STRING);
				}
			}

			setState(315);
			match(EOI);
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

	public static class MissingWordsOptionContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(ExamParser.OPTION, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public MissingWordsOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingWordsOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMissingWordsOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMissingWordsOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMissingWordsOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingWordsOptionContext missingWordsOption() throws RecognitionException {
		MissingWordsOptionContext _localctx = new MissingWordsOptionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_missingWordsOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(OPTION);
			setState(318);
			match(STRING);
			setState(319);
			match(EOI);
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

	public static class MatchContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(ExamParser.MATCH, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(MATCH);
			setState(322);
			match(NUMBER);
			setState(323);
			match(STRING);
			setState(324);
			match(EOI);
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

	public static class MatchingCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(ExamParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ExamParser.NUMBER, i);
		}
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public MatchingCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMatchingCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMatchingCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMatchingCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingCorrectAnswerContext matchingCorrectAnswer() throws RecognitionException {
		MatchingCorrectAnswerContext _localctx = new MatchingCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_matchingCorrectAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(CORRECT_ANSWER);
			setState(327);
			match(NUMBER);
			setState(328);
			match(T__6);
			setState(329);
			match(NUMBER);
			setState(330);
			match(EOI);
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

	public static class MissingWordsCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public TerminalNode STRING() { return getToken(ExamParser.STRING, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public MissingWordsCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingWordsCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMissingWordsCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMissingWordsCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMissingWordsCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingWordsCorrectAnswerContext missingWordsCorrectAnswer() throws RecognitionException {
		MissingWordsCorrectAnswerContext _localctx = new MissingWordsCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_missingWordsCorrectAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(CORRECT_ANSWER);
			setState(333);
			match(STRING);
			setState(334);
			match(EOI);
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

	public static class TrueFalseCorrectAnswerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER() { return getToken(ExamParser.CORRECT_ANSWER, 0); }
		public TerminalNode EOI() { return getToken(ExamParser.EOI, 0); }
		public TerminalNode TRUE() { return getToken(ExamParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ExamParser.FALSE, 0); }
		public TrueFalseCorrectAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalseCorrectAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterTrueFalseCorrectAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitTrueFalseCorrectAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitTrueFalseCorrectAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseCorrectAnswerContext trueFalseCorrectAnswer() throws RecognitionException {
		TrueFalseCorrectAnswerContext _localctx = new TrueFalseCorrectAnswerContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_trueFalseCorrectAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(CORRECT_ANSWER);
			setState(337);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(338);
			match(EOI);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0157\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\6\4Q\n\4\r\4\16"+
		"\4R\3\5\3\5\3\5\3\5\3\5\3\6\6\6[\n\6\r\6\16\6\\\3\7\6\7`\n\7\r\7\16\7"+
		"a\3\b\3\b\3\b\3\b\5\bh\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0090"+
		"\n\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0098\n\22\3\22\3\22\5\22\u009c"+
		"\n\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00a4\n\23\3\23\3\23\5\23\u00a8"+
		"\n\23\3\23\3\23\6\23\u00ac\n\23\r\23\16\23\u00ad\3\23\3\23\3\23\3\23\5"+
		"\23\u00b4\n\23\3\23\3\23\6\23\u00b8\n\23\r\23\16\23\u00b9\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\5\24\u00c2\n\24\3\24\3\24\5\24\u00c6\n\24\3\24\3\24"+
		"\6\24\u00ca\n\24\r\24\16\24\u00cb\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00d4"+
		"\n\25\3\25\3\25\5\25\u00d8\n\25\3\25\3\25\3\26\3\26\3\26\5\26\u00df\n"+
		"\26\3\26\3\26\5\26\u00e3\n\26\3\26\3\26\6\26\u00e7\n\26\r\26\16\26\u00e8"+
		"\3\26\3\26\3\26\3\26\6\26\u00ef\n\26\r\26\16\26\u00f0\3\26\3\26\3\26\3"+
		"\26\6\26\u00f7\n\26\r\26\16\26\u00f8\3\26\3\26\3\26\3\27\3\27\3\27\5\27"+
		"\u0101\n\27\3\27\3\27\5\27\u0105\n\27\3\27\3\27\6\27\u0109\n\27\r\27\16"+
		"\27\u010a\3\27\3\27\3\27\3\27\6\27\u0111\n\27\r\27\16\27\u0112\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u012c\n\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u013c\n\37"+
		"\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\2\2%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDF\2\3\3\2#$\2\u0155\2H\3\2\2\2\4J\3\2\2\2\6P\3\2"+
		"\2\2\bT\3\2\2\2\nZ\3\2\2\2\f_\3\2\2\2\16g\3\2\2\2\20i\3\2\2\2\22m\3\2"+
		"\2\2\24q\3\2\2\2\26u\3\2\2\2\30y\3\2\2\2\32}\3\2\2\2\34\u0080\3\2\2\2"+
		"\36\u0084\3\2\2\2 \u0087\3\2\2\2\"\u0094\3\2\2\2$\u00a0\3\2\2\2&\u00be"+
		"\3\2\2\2(\u00d0\3\2\2\2*\u00db\3\2\2\2,\u00fd\3\2\2\2.\u0117\3\2\2\2\60"+
		"\u011b\3\2\2\2\62\u011f\3\2\2\2\64\u0123\3\2\2\2\66\u0128\3\2\2\28\u012f"+
		"\3\2\2\2:\u0133\3\2\2\2<\u0137\3\2\2\2>\u013f\3\2\2\2@\u0143\3\2\2\2B"+
		"\u0148\3\2\2\2D\u014e\3\2\2\2F\u0152\3\2\2\2HI\5\4\3\2I\3\3\2\2\2JK\5"+
		"\30\r\2KL\5\f\7\2LM\5\6\4\2MN\5\32\16\2N\5\3\2\2\2OQ\5\b\5\2PO\3\2\2\2"+
		"QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2TU\5\34\17\2UV\5\f\7\2VW\5\n"+
		"\6\2WX\5\36\20\2X\t\3\2\2\2Y[\5 \21\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2"+
		"\\]\3\2\2\2]\13\3\2\2\2^`\5\16\b\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2b\r\3\2\2\2ch\5\20\t\2dh\5\22\n\2eh\5\24\13\2fh\5\26\f\2gc\3\2\2\2"+
		"gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2h\17\3\2\2\2ij\7\16\2\2jk\7\13\2\2kl\7\n"+
		"\2\2l\21\3\2\2\2mn\7\17\2\2no\7\13\2\2op\7\n\2\2p\23\3\2\2\2qr\7\20\2"+
		"\2rs\7%\2\2st\7\n\2\2t\25\3\2\2\2uv\7\21\2\2vw\7%\2\2wx\7\n\2\2x\27\3"+
		"\2\2\2yz\7\f\2\2z{\7)\2\2{|\7\n\2\2|\31\3\2\2\2}~\7\r\2\2~\177\7\n\2\2"+
		"\177\33\3\2\2\2\u0080\u0081\7\22\2\2\u0081\u0082\7)\2\2\u0082\u0083\7"+
		"\n\2\2\u0083\35\3\2\2\2\u0084\u0085\7\23\2\2\u0085\u0086\7\n\2\2\u0086"+
		"\37\3\2\2\2\u0087\u0088\7\25\2\2\u0088\u008f\7\27\2\2\u0089\u0090\5\""+
		"\22\2\u008a\u0090\5$\23\2\u008b\u0090\5&\24\2\u008c\u0090\5(\25\2\u008d"+
		"\u0090\5*\26\2\u008e\u0090\5,\27\2\u008f\u0089\3\2\2\2\u008f\u008a\3\2"+
		"\2\2\u008f\u008b\3\2\2\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\26\2\2\u0092\u0093\7"+
		"\n\2\2\u0093!\3\2\2\2\u0094\u0095\7\3\2\2\u0095\u0097\7\n\2\2\u0096\u0098"+
		"\5\62\32\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2"+
		"\u0099\u009b\5.\30\2\u009a\u009c\5\60\31\2\u009b\u009a\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\58\35\2\u009e\u009f\5:\36\2\u009f"+
		"#\3\2\2\2\u00a0\u00a1\7\4\2\2\u00a1\u00a3\7\n\2\2\u00a2\u00a4\5\62\32"+
		"\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7"+
		"\5.\30\2\u00a6\u00a8\5\60\31\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2"+
		"\u00a8\u00b3\3\2\2\2\u00a9\u00ab\7\31\2\2\u00aa\u00ac\5\66\34\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\33\2\2\u00b0\u00b1\7\n\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b4\5\66\34\2\u00b3\u00a9\3\2\2\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\7\35\2\2\u00b6\u00b8\5<\37\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\36\2\2\u00bc\u00bd\7\n\2\2\u00bd"+
		"%\3\2\2\2\u00be\u00bf\7\5\2\2\u00bf\u00c1\7\n\2\2\u00c0\u00c2\5\62\32"+
		"\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5"+
		"\5.\30\2\u00c4\u00c6\5\60\31\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\u00c9\7\31\2\2\u00c8\u00ca\5\64\33\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00cf\7\n\2\2\u00cf"+
		"\'\3\2\2\2\u00d0\u00d1\7\6\2\2\u00d1\u00d3\7\n\2\2\u00d2\u00d4\5\62\32"+
		"\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7"+
		"\5.\30\2\u00d6\u00d8\5\60\31\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2"+
		"\u00d8\u00d9\3\2\2\2\u00d9\u00da\5F$\2\u00da)\3\2\2\2\u00db\u00dc\7\7"+
		"\2\2\u00dc\u00de\7\n\2\2\u00dd\u00df\5\62\32\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\5.\30\2\u00e1\u00e3\5\60"+
		"\31\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e6\7\31\2\2\u00e5\u00e7\5B\"\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\7\33\2\2\u00eb\u00ec\7\n\2\2\u00ec\u00ee\7\35\2\2\u00ed\u00ef\5"+
		"<\37\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7\36\2\2\u00f3\u00f4\7"+
		"\n\2\2\u00f4\u00f6\7 \2\2\u00f5\u00f7\5@!\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\7!\2\2\u00fb\u00fc\7\n\2\2\u00fc+\3\2\2\2\u00fd\u00fe"+
		"\7\b\2\2\u00fe\u0100\7\n\2\2\u00ff\u0101\5\62\32\2\u0100\u00ff\3\2\2\2"+
		"\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\5.\30\2\u0103\u0105"+
		"\5\60\31\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2"+
		"\u0106\u0108\7\31\2\2\u0107\u0109\5D#\2\u0108\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\7\33\2\2\u010d\u010e\7\n\2\2\u010e\u0110\7\35\2\2\u010f\u0111\5"+
		"> \2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7\36\2\2\u0115\u0116\7"+
		"\n\2\2\u0116-\3\2\2\2\u0117\u0118\7\30\2\2\u0118\u0119\7\13\2\2\u0119"+
		"\u011a\7\n\2\2\u011a/\3\2\2\2\u011b\u011c\7\20\2\2\u011c\u011d\7\13\2"+
		"\2\u011d\u011e\7\n\2\2\u011e\61\3\2\2\2\u011f\u0120\7\24\2\2\u0120\u0121"+
		"\7&\2\2\u0121\u0122\7\n\2\2\u0122\63\3\2\2\2\u0123\u0124\7\32\2\2\u0124"+
		"\u0125\7\13\2\2\u0125\u0126\7&\2\2\u0126\u0127\7\n\2\2\u0127\65\3\2\2"+
		"\2\u0128\u0129\7\32\2\2\u0129\u012b\7&\2\2\u012a\u012c\7&\2\2\u012b\u012a"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\7\n\2\2\u012e"+
		"\67\3\2\2\2\u012f\u0130\7\32\2\2\u0130\u0131\7&\2\2\u0131\u0132\7\n\2"+
		"\2\u01329\3\2\2\2\u0133\u0134\7\34\2\2\u0134\u0135\7&\2\2\u0135\u0136"+
		"\7\n\2\2\u0136;\3\2\2\2\u0137\u0138\7\37\2\2\u0138\u0139\7&\2\2\u0139"+
		"\u013b\7\13\2\2\u013a\u013c\7\13\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3"+
		"\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\7\n\2\2\u013e=\3\2\2\2\u013f\u0140"+
		"\7\37\2\2\u0140\u0141\7\13\2\2\u0141\u0142\7\n\2\2\u0142?\3\2\2\2\u0143"+
		"\u0144\7\"\2\2\u0144\u0145\7&\2\2\u0145\u0146\7\13\2\2\u0146\u0147\7\n"+
		"\2\2\u0147A\3\2\2\2\u0148\u0149\7\32\2\2\u0149\u014a\7&\2\2\u014a\u014b"+
		"\7\t\2\2\u014b\u014c\7&\2\2\u014c\u014d\7\n\2\2\u014dC\3\2\2\2\u014e\u014f"+
		"\7\32\2\2\u014f\u0150\7\13\2\2\u0150\u0151\7\n\2\2\u0151E\3\2\2\2\u0152"+
		"\u0153\7\32\2\2\u0153\u0154\t\2\2\2\u0154\u0155\7\n\2\2\u0155G\3\2\2\2"+
		"\36R\\ag\u008f\u0097\u009b\u00a3\u00a7\u00ad\u00b3\u00b9\u00c1\u00c5\u00cb"+
		"\u00d3\u00d7\u00de\u00e2\u00e8\u00f0\u00f8\u0100\u0104\u010a\u0112\u012b"+
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