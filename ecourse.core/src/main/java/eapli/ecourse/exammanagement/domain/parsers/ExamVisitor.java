// Generated from /home/russo/isep/lapr4/sem4pi-22-23-19/ecourse.core/src/main/java/eapli/ecourse/exammanagement/domain/grammars/Exam/Exam.g4 by ANTLR 4.9.2
package eapli.ecourse.exammanagement.domain.parsers;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExamParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam(ExamParser.ExamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#sections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSections(ExamParser.SectionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(ExamParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(ExamParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ExamParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(ExamParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(ExamParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(ExamParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#feedback_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback_header(ExamParser.Feedback_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(ExamParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#start_exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_exam(ExamParser.Start_examContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#end_exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_exam(ExamParser.End_examContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#start_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_section(ExamParser.Start_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#end_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_section(ExamParser.End_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ExamParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#numericalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(ExamParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(ExamParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(ExamParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#missingWordsQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ExamParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(ExamParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#score}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScore(ExamParser.ScoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#shortAnswerCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerCorrectAnswer(ExamParser.ShortAnswerCorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#multipleChoiceCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceCorrectAnswer(ExamParser.MultipleChoiceCorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#numericalCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalCorrectAnswer(ExamParser.NumericalCorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#numericalAcceptedError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalAcceptedError(ExamParser.NumericalAcceptedErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(ExamParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#missingWordsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWordsOption(ExamParser.MissingWordsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(ExamParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#matchingCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingCorrectAnswer(ExamParser.MatchingCorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#missingWordsCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWordsCorrectAnswer(ExamParser.MissingWordsCorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#trueFalseCorrectAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseCorrectAnswer(ExamParser.TrueFalseCorrectAnswerContext ctx);
}