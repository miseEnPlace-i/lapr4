package eapli.ecourse.exammanagement.domain.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.ExamDescription;
import eapli.ecourse.exammanagement.domain.ExamIdentifier;
import eapli.ecourse.exammanagement.domain.ExamInfo;
import eapli.ecourse.exammanagement.domain.ExamTitle;
import eapli.ecourse.exammanagement.domain.SectionDescription;
import eapli.ecourse.exammanagement.domain.SectionIdentifier;
import eapli.ecourse.exammanagement.domain.SectionTitle;
import eapli.ecourse.exammanagement.domain.evaluation.ExamScore;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamRequestBuilder;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamSectionRequest;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamSectionRequestBuilder;

public class FormativeExamBuilderVisitor extends FormativeExamBaseVisitor<FormativeExamRequestBuilder> {
  private FormativeExamRequestBuilder examBuilder;
  private FormativeExamSectionRequestBuilder sectionBuilder;
  private List<FormativeExamSectionRequest> sections;

  @Override
  public FormativeExamRequestBuilder visitStart(FormativeExamParser.StartContext ctx) {
    visit(ctx.exam());
    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitExam(FormativeExamParser.ExamContext ctx) {
    examBuilder = new FormativeExamRequestBuilder();

    visit(ctx.startExam());
    visit(ctx.header());
    visit(ctx.sections());

    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitStartExam(FormativeExamParser.StartExamContext ctx) {
    String str = ctx.IDENTIFIER().getText();
    ExamIdentifier identifier = ExamIdentifier.valueOf(str);
    examBuilder.withIdentifier(identifier);
    return examBuilder;
  }

  /**
   * Visits the header of a Exam or Section.
   *
   * Maps all attributes, making sure that there are no duplicates, and that all
   * required attributes are present (and that no forbidden attributes are
   * present).
   */
  @Override
  public FormativeExamRequestBuilder visitHeader(FormativeExamParser.HeaderContext ctx) {
    Map<String, Object> properties = new HashMap<>();
    ctx.properties().forEach(p -> {
      if (p.title() != null) {
        if (properties.containsKey("title"))
          raiseError(p, "Title already defined.");

        properties.put("title", extractString(p.title().STRING().getText()));
      }
      if (p.description() != null) {
        if (properties.containsKey("description"))
          raiseError(p, "Description already defined.");

        properties.put("description", extractString(p.description().STRING().getText()));
      }
      if (p.feedback() != null) {
        if (properties.containsKey("feedback"))
          raiseError(p, "Feedback already defined.");

        properties.put("feedback", p.feedback().FDB_GRD_TYPE().getText());
      }
      if (p.grade() != null) {
        if (properties.containsKey("grade"))
          raiseError(p, "grade already defined");

        properties.put("grade", p.grade().FDB_GRD_TYPE().getText());
      }
      if (p.score() != null) {
        if (properties.containsKey("score"))
          raiseError(p, "score already defined");

        properties.put("score", p.score().NUMBER());
      }
    });

    if (ctx.getParent().getStart().getText().equals("@start-exam")) {
      String[] requiredProps = {
          "title",
          "feedback",
          "grade",
          "score"
      };

      Arrays.asList(requiredProps).forEach(p -> {
        if (!properties.containsKey(p))
          raiseError(ctx,
              "The exam does not contain the " + p + " attribute. Specify a " + p + " using the @" + p + " tag.");
      });

      initializeExam(properties);
    } else {
      String[] requiredProps = {
          "title",
      };
      String[] forbiddenProps = {
          "feedback",
      };

      Arrays.asList(requiredProps).forEach(p -> {
        if (!properties.containsKey(p))
          raiseError(ctx,
              "The section does not contain the " + p + " attribute. Specify a " + p + " using the @" + p + " tag.");
      });

      Arrays.asList(forbiddenProps).forEach(p -> {
        if (properties.containsKey(p))
          raiseError(ctx, "A section cannot contain the " + p + " attribute. Remove the @" + p + " tag.");
      });

      initializeSection(properties);
    }

    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitSections(FormativeExamParser.SectionsContext ctx) {
    sections = new ArrayList<FormativeExamSectionRequest>();
    visitChildren(ctx);
    examBuilder.withSections(sections);
    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitSection(FormativeExamParser.SectionContext ctx) {
    sectionBuilder = new FormativeExamSectionRequestBuilder();

    visit(ctx.startSection());
    visit(ctx.header());
    visit(ctx.numberOfQuestions());
    visit(ctx.questionsType());

    sections.add(sectionBuilder.build());

    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitNumberOfQuestions(FormativeExamParser.NumberOfQuestionsContext ctx) {
    int numberOfQuestions = Integer.parseInt(ctx.NUMBER().getText());
    sectionBuilder.withNumberOfQuestions(numberOfQuestions);

    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitQuestionsType(FormativeExamParser.QuestionsTypeContext ctx) {
    String str = ctx.getChild(1).getText();
    sectionBuilder.withQuestionsType(str);
    return examBuilder;
  }

  @Override
  public FormativeExamRequestBuilder visitStartSection(FormativeExamParser.StartSectionContext ctx) {
    String str = ctx.IDENTIFIER().getText();
    SectionIdentifier identifier = SectionIdentifier.valueOf(str);
    sectionBuilder.withIdentifier(identifier);
    return examBuilder;
  }

  private void initializeExam(Map<String, Object> properties) {
    ExamTitle title = ExamTitle.valueOf(properties.get("title").toString());
    examBuilder.withTitle(title);
    ExamScore score = ExamScore.valueOf(Double.parseDouble(properties.get("score").toString()));
    examBuilder.withScore(score);
    ExamInfo gradeInfo = ExamInfo.convert(properties.get("grade").toString());
    examBuilder.withGradeInfo(gradeInfo);

    if (properties.containsKey("description")) {
      ExamDescription description = ExamDescription.valueOf(properties.get("description").toString());
      examBuilder.withDescription(description);
    } else {
      examBuilder.withDescription(ExamDescription.valueOf(""));
    }
  }

  private void initializeSection(Map<String, Object> properties) {
    SectionTitle title = SectionTitle.valueOf(properties.get("title").toString());
    sectionBuilder.withTitle(title);

    if (properties.containsKey("description")) {
      SectionDescription description = SectionDescription.valueOf(properties.get("description").toString());
      sectionBuilder.withDescription(description);
    } else {
      sectionBuilder.withDescription(SectionDescription.valueOf(""));
    }

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
}
