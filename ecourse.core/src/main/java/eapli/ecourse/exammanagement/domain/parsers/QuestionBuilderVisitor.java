package eapli.ecourse.exammanagement.domain.parsers;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.evaluation.ExamScore;
import eapli.ecourse.questionmanagement.domain.Feedback;
import eapli.ecourse.questionmanagement.domain.QuestionIdentifier;
import eapli.ecourse.questionmanagement.domain.MatchingQuestion;
import eapli.ecourse.questionmanagement.domain.MissingWordsQuestion;
import eapli.ecourse.questionmanagement.domain.MultipleChoiceQuestion;
import eapli.ecourse.questionmanagement.domain.NumericalQuestion;
import eapli.ecourse.questionmanagement.domain.Question;
import eapli.ecourse.questionmanagement.domain.QuestionBody;
import eapli.ecourse.questionmanagement.domain.QuestionType;
import eapli.ecourse.questionmanagement.domain.ShortAnswerQuestion;
import eapli.ecourse.questionmanagement.domain.TrueFalseQuestion;

public class QuestionBuilderVisitor extends QuestionBaseVisitor<List<Question>> {
  List<Question> questions = new ArrayList<>();
  private Question question;
  private double real;
  private boolean bool;

  private boolean mandatoryScore;

  public QuestionBuilderVisitor(boolean mandatoryScore) {
    this.mandatoryScore = mandatoryScore;
  }

  public QuestionBuilderVisitor() {
    this.mandatoryScore = false;
  }

  private String extractString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length() - 1; i++)
      sb.append(s.charAt(i));
    return sb.toString();
  }

  private void raiseError(ParserRuleContext ctx, String msg) {
    Token token = ctx.getStart();
    int lineNo = token.getLine();
    throw new ParseException(lineNo, msg);
  }

  @Override
  public List<Question> visitStart(QuestionParser.StartContext ctx) {
    visitChildren(ctx);
    return questions;
  }

  @Override
  public List<Question> visitMatchingQuestion(QuestionParser.MatchingQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new MatchingQuestion(QuestionType.REGULAR);
    else
      this.question = new MatchingQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx, "The question does not contain the score attribute. Specify a score using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());
    if (ctx.feedback() != null)
      visit(ctx.feedback());

    MatchingQuestion q = (MatchingQuestion) this.question;

    ctx.matchingCorrectAnswer().forEach(a -> {
      String matchIdentifier = a.NUMBER(0).getText();
      String optionIdentifier = a.NUMBER(1).getText();

      q.addCorrectMatch(matchIdentifier, optionIdentifier);
    });

    ctx.option().forEach(o -> {
      String id = o.NUMBER().getText();
      QuestionIdentifier identifier = QuestionIdentifier.valueOf(id);

      String body = extractString(o.STRING(0).getText());

      if (o.STRING().size() > 1) {
        String feedback = extractString(o.STRING(1).getText());
        Feedback f = Feedback.valueOf(feedback);
        q.addFeedback(identifier, f);
      }

      q.addOption(identifier, body);
    });

    ctx.match().forEach(m -> {
      String id = m.NUMBER().getText();
      QuestionIdentifier identifier = QuestionIdentifier.valueOf(id);

      String body = extractString(m.STRING().getText());

      q.addMatch(identifier, body);
    });

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitNumericalQuestion(QuestionParser.NumericalQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new NumericalQuestion(QuestionType.REGULAR);
    else
      this.question = new NumericalQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx, "The question does not contain the score attribute. Specify a score using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());
    if (ctx.feedback() != null)
      visit(ctx.feedback());

    NumericalQuestion q = (NumericalQuestion) this.question;

    visit(ctx.numericalCorrectAnswer());
    q.changeCorrectAnswer(real);
    visit(ctx.numericalAcceptedError());
    q.changeAcceptedError(real);

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitMultipleChoiceQuestion(QuestionParser.MultipleChoiceQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new MultipleChoiceQuestion(QuestionType.REGULAR);
    else
      this.question = new MultipleChoiceQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx,
          "Some question does not contain the score attribute. Specify a score for all questions using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());
    if (ctx.feedback() != null)
      visit(ctx.feedback());

    MultipleChoiceQuestion q = (MultipleChoiceQuestion) this.question;

    ctx.multipleChoiceCorrectAnswer().forEach(a -> {
      String id = a.NUMBER(0).getText();

      double grade = 0;
      if (a.NUMBER(1) == null)
        grade = 1;
      else
        grade = Double.parseDouble(a.NUMBER(1).getText());

      QuestionIdentifier identifier = QuestionIdentifier.valueOf(id);

      q.addCorrectAnswer(identifier, grade);
    });

    ctx.option().forEach(o -> {
      String id = o.NUMBER().getText();
      QuestionIdentifier identifier = QuestionIdentifier.valueOf(id);

      String body = extractString(o.STRING(0).getText());

      if (o.STRING().size() > 1) {
        String feedback = extractString(o.STRING(1).getText());
        Feedback f = Feedback.valueOf(feedback);
        q.addFeedback(identifier, f);
      }

      q.addOption(identifier, body);
    });

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitShortAnswerQuestion(QuestionParser.ShortAnswerQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new ShortAnswerQuestion(QuestionType.REGULAR);
    else
      this.question = new ShortAnswerQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx, "The question does not contain the score attribute. Specify a score using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());
    if (ctx.feedback() != null)
      visit(ctx.feedback());

    ShortAnswerQuestion q = (ShortAnswerQuestion) this.question;

    ctx.shortAnswerCorrectAnswer().forEach(a -> {
      String answer = extractString(a.STRING().getText());
      double grade = Double.parseDouble(a.NUMBER().getText());

      q.addCorrectAnswer(answer, grade);
    });

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitTrueFalseQuestion(QuestionParser.TrueFalseQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new TrueFalseQuestion(QuestionType.REGULAR);
    else
      this.question = new TrueFalseQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx, "The question does not contain the score attribute. Specify a score using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());
    if (ctx.feedback() != null)
      visit(ctx.feedback());

    TrueFalseQuestion q = (TrueFalseQuestion) this.question;

    visit(ctx.trueFalseCorrectAnswer());
    q.changeCorrectAnswer(bool);

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitMissingWordsQuestion(QuestionParser.MissingWordsQuestionContext ctx) {
    if (mandatoryScore)
      this.question = new MissingWordsQuestion(QuestionType.REGULAR);
    else
      this.question = new MissingWordsQuestion(QuestionType.FORMATIVE);

    if (mandatoryScore && ctx.score() == null)
      raiseError(ctx, "The question does not contain the score attribute. Specify a score using the @score tag.");
    else if (ctx.score() != null)
      visit(ctx.score());

    visit(ctx.body());

    if (ctx.feedback() != null)
      visit(ctx.feedback());

    MissingWordsQuestion q = (MissingWordsQuestion) this.question;

    ctx.missingWordsCorrectAnswer().forEach(a -> {
      String missingWord = extractString(a.STRING().getText());
      q.addMissingWord(missingWord);
    });

    ctx.missingWordsOption().forEach(o -> {
      String option = extractString(o.STRING().getText());

      q.addOption(option);
    });

    questions.add(q);
    return questions;
  }

  @Override
  public List<Question> visitBody(QuestionParser.BodyContext ctx) {
    String body = extractString(ctx.STRING().getText());

    QuestionBody b = new QuestionBody(body);
    this.question.changeBody(b);
    return null;
  }

  @Override
  public List<Question> visitScore(QuestionParser.ScoreContext ctx) {
    double score = Double.parseDouble(ctx.NUMBER().getText());

    ExamScore s = ExamScore.valueOf(score);
    this.question.changeScore(s);
    return null;
  }

  @Override
  public List<Question> visitFeedback(QuestionParser.FeedbackContext ctx) {
    String feedback = extractString(ctx.STRING().getText());

    Feedback f = Feedback.valueOf(feedback);
    this.question.changeFeedback(f);
    return null;
  }

  @Override
  public List<Question> visitNumericalCorrectAnswer(QuestionParser.NumericalCorrectAnswerContext ctx) {
    this.real = Double.parseDouble(ctx.NUMBER().getText());
    return null;
  }

  @Override
  public List<Question> visitNumericalAcceptedError(QuestionParser.NumericalAcceptedErrorContext ctx) {
    this.real = Double.parseDouble(ctx.NUMBER().getText());
    return null;
  }

  @Override
  public List<Question> visitTrueFalseCorrectAnswer(QuestionParser.TrueFalseCorrectAnswerContext ctx) {
    if (ctx.TRUE() != null)
      this.bool = true;
    else
      this.bool = false;

    return null;
  }
}
