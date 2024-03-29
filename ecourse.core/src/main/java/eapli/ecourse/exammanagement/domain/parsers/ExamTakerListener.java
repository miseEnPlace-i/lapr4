package eapli.ecourse.exammanagement.domain.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import eapli.ecourse.exammanagement.application.ExamPrinter;
import eapli.ecourse.exammanagement.domain.evaluation.ExamScore;
import eapli.ecourse.exammanagement.domain.parsers.ExamParser.PropertiesContext;

public class ExamTakerListener extends ExamBaseListener {
  private final Double DOUBLE_ACCEPTABLE_ERROR = 0.00000000001d;

  private boolean feedbackOn;
  private boolean gradeOn;
  private final ExamPrinter printer;
  private Double examScore;
  private Double studentScore;

  public ExamTakerListener(ExamPrinter printer) {
    if (printer == null)
      throw new IllegalArgumentException("Printer cannot be null!");

    this.printer = printer;
    this.examScore = 0d;
    this.studentScore = 0d;
  }

  @Override
  public void enterHeader(ExamParser.HeaderContext ctx) {
    String title = null, description = null;

    for (PropertiesContext prop : ctx.properties()) {
      // Get exam's title and description
      if (prop.title() != null) {
        title = extractString(prop.title().STRING().getText());
      }
      if (prop.description() != null) {
        description = extractString(prop.description().STRING().getText());
      }

      // Check if grade and feedback should be shown
      if (prop.grade() != null && prop.grade().FDB_GRD_TYPE().getText().equals("on-submit"))
        gradeOn = true;
      else if (prop.grade() != null && prop.grade().FDB_GRD_TYPE().getText().equals("none"))
        gradeOn = false;

      if (prop.feedback_header() != null && prop.feedback_header().FDB_GRD_TYPE().getText().equals("on-submit"))
        feedbackOn = true;
      else if (prop.feedback_header() != null && prop.feedback_header().FDB_GRD_TYPE().getText().equals("none"))
        feedbackOn = false;
    }

    if (ctx.getParent().getStart().getText().equals("@start-exam"))
      // Printing the Exam Header...
      printer.printExamHeader(title, description);
    else
      // Printing the Section Header...
      printer.printSectionHeader(title, description);

  }

  @Override
  public void enterNumericalQuestion(ExamParser.NumericalQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Get correct answer
    Double correctAnswer = Double.parseDouble(ctx.numericalCorrectAnswer().NUMBER().getText());
    feedback.append("\nThe correct answer was: " + correctAnswer.toString());

    // Get accepted error
    Double acceptedError = Double.parseDouble(ctx.numericalAcceptedError().NUMBER().getText());

    // Print question and get student's answer
    Double studentAnswer = printer.getNumericalQuestionAnswer(extractString(ctx.body().STRING().getText()),
        questionScore);

    // Check if student's answer is correct
    if (Math.abs(correctAnswer - studentAnswer) - acceptedError <= DOUBLE_ACCEPTABLE_ERROR)
      showFeedback(questionScore);
    else
      showFeedback(feedback.toString());
  }

  @Override
  public void enterMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Map correct answers
    List<String> correctAnswers = new ArrayList<>();
    ctx.missingWordsCorrectAnswer().forEach(a -> {
      correctAnswers.add(extractString(a.STRING().getText()));
    });

    feedback.append("\nThe correct answers were: ");
    for (String answer : correctAnswers)
      feedback.append(answer + "; ");
    feedback.delete(feedback.length() - 2, feedback.length());

    // Map options
    List<String> options = new ArrayList<>();
    ctx.missingWordsOption().forEach(o -> {
      options.add(extractString(o.STRING().getText()));
    });

    // Print question and get student's answer
    List<String> studentAnswers = printer.getMissingWordsQuestionAnswer(extractString(ctx.body().STRING().getText()),
        options,
        questionScore);

    // Check if student's answer is correct
    for (int i = 0; i < correctAnswers.size(); i++) {
      if (!correctAnswers.get(i).toLowerCase().equals(studentAnswers.get(i).toLowerCase())) {
        showFeedback(feedback.toString());
        return;
      }
    }
    showFeedback(questionScore);
  }

  @Override
  public void enterTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Get correct answer
    boolean correctAnswer;
    if (ctx.trueFalseCorrectAnswer().TRUE() != null)
      correctAnswer = true;
    else
      correctAnswer = false;

    feedback.append("\nThe correct answer was: " + correctAnswer);

    // Print question and get student's answer
    boolean studentAnswer = printer.getTrueFalseQuestionAnswer(extractString(ctx.body().STRING().getText()),
        questionScore);

    // Check if student's answer is correct
    if (correctAnswer == studentAnswer)
      showFeedback(questionScore);
    else
      showFeedback(feedback.toString());
  }

  @Override
  public void enterMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Map possible options
    Map<String, String> options = new HashMap<>();
    ctx.option().forEach(o -> {
      options.put(o.NUMBER().getText(), extractString(o.STRING(0).getText()));
    });

    // If there is only one correct answer
    if (ctx.multipleChoiceCorrectAnswer().size() == 1) {
      // Get correct answer's index
      String correctAnswer = ctx.multipleChoiceCorrectAnswer(0).NUMBER(0).getText();

      feedback.append("\nThe correct answer was: " + options.get(correctAnswer));

      // Print question and get student's answer index
      String studentAnswer = printer.getMultipleChoiceSingleQuestionAnswer(extractString(ctx.body().STRING().getText()),
          options,
          questionScore);

      // Check if student's answer is correct
      if (correctAnswer.equals(studentAnswer))
        showFeedback(questionScore);
      else
        showFeedback(feedback.toString());
    } else {
      // Get correct answer's indexes
      Set<String> correctAnswers = new HashSet<>();
      ctx.multipleChoiceCorrectAnswer().forEach(a -> {
        correctAnswers.add(a.NUMBER(0).getText());
      });

      feedback.append("\nThe correct answers were:\n");
      for (String answer : correctAnswers)
        feedback.append("> " + options.get(answer) + "\n");
      feedback.delete(feedback.length() - 1, feedback.length());

      // Print question and get student's answer index
      Set<String> studentAnswers = printer.getMultipleChoiceMultipleQuestionAnswer(
          extractString(ctx.body().STRING().getText()),
          options,
          questionScore);

      // Check if student's answer is correct
      if (studentAnswers.containsAll(correctAnswers))
        showFeedback(questionScore);
      else
        showFeedback(feedback.toString());
    }
  }

  @Override
  public void enterShortAnswerQuestion(ExamParser.ShortAnswerQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Map correct answers
    Map<String, Double> correctAnswers = new HashMap<>();

    // Get each correct answer and respective grade
    ctx.shortAnswerCorrectAnswer().forEach(a -> {
      String answer = extractString(a.STRING().getText());
      Double grade = Double.parseDouble(a.NUMBER().getText());

      correctAnswers.put(answer.toLowerCase(), grade);
    });

    feedback.append("\nThe possible correct answers were:\n");
    for (String answer : correctAnswers.keySet())
      feedback.append("> " + answer + "\n");
    feedback.delete(feedback.length() - 1, feedback.length());

    // Print question and get student's answer
    String studentAnswer = printer.getShortAnswerQuestionAnswer(extractString(ctx.body().STRING().getText()),
        questionScore).toLowerCase();

    // Check if student's answer is in the correct answer's map
    Double studentScore = correctAnswers.get(studentAnswer);
    if (studentScore == null)
      showFeedback(feedback.toString());
    else {
      Double score = studentScore * questionScore;
      showFeedback(score);
    }
  }

  @Override
  public void enterMatchingQuestion(ExamParser.MatchingQuestionContext ctx) {
    // Get question's score and increment exam's total score
    Double questionScore = Double.parseDouble(ctx.score().NUMBER().getText());
    incrementExamScore(questionScore);

    // Get feedback (if present)
    StringBuilder feedback = new StringBuilder();
    if (ctx.feedback() != null)
      feedback.append(extractString(ctx.feedback().STRING().getText()));

    // Map correct matches
    Map<String, String> correctMatches = new HashMap<>();
    ctx.matchingCorrectAnswer().forEach(a -> {
      String optionIdentifier = a.NUMBER(0).getText();
      String matchIdentifier = a.NUMBER(1).getText();

      correctMatches.put(optionIdentifier, matchIdentifier);
    });

    // Map options
    Map<String, String> options = new HashMap<>();
    ctx.option().forEach(o -> {
      options.put(o.NUMBER().getText(), extractString(o.STRING(0).getText()));
    });

    // Map matches
    Map<String, String> matches = new HashMap<>();
    ctx.match().forEach(m -> {
      matches.put(m.NUMBER().getText(), extractString(m.STRING().getText()));
    });

    feedback.append("\nThe correct matches were:\n");
    for (String option : correctMatches.keySet())
      feedback.append("> " + options.get(option) + " -> " + matches.get(correctMatches.get(option)) + "\n");
    feedback.delete(feedback.length() - 1, feedback.length());

    // Print question and get student's answer
    Map<String, String> studentMatches = printer.getMatchingQuestionAnswer(extractString(ctx.body().STRING().getText()),
        options, matches,
        questionScore);

    // Check if student's answer is correct
    if (correctMatches.equals(studentMatches))
      showFeedback(questionScore);
    else
      showFeedback(feedback.toString());
  }

  @Override
  public void exitExam(ExamParser.ExamContext ctx) {
    // Print final score, if needed
    if (gradeOn)
      printer.printFinalScore(studentScore, examScore);
  }

  public ExamScore getStudentsScore() {
    return ExamScore.valueOf(studentScore);
  }

  private String extractString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length() - 1; i++)
      sb.append(s.charAt(i));
    return sb.toString();
  }

  private void incrementStudentScore(Double score) {
    studentScore += score;
  }

  private void incrementExamScore(Double score) {
    examScore += score;
  }

  private void showFeedback(Double score) {
    incrementStudentScore(score);
    printer.printCorrectAnswer();
  }

  private void showFeedback(String feedback) {
    if (feedbackOn)
      printer.printIncorrectAnswer(feedback);
    else
      printer.printIncorrectAnswer();
  }
}
