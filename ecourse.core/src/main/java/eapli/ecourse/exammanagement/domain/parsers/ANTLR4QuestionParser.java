package eapli.ecourse.exammanagement.domain.parsers;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import eapli.ecourse.exammanagement.application.ExamPrinter;
import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.questionmanagement.domain.Question;

public class ANTLR4QuestionParser implements GrammarParser<List<Question>> {
  public List<Question> parseFromFile(String path) throws IOException, ParseException {
    QuestionLexer lexer = new QuestionLexer(CharStreams.fromFileName(path));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    QuestionParser parser = new QuestionParser(tokens);
    ParseTree tree = parser.start();

    if (parser.getNumberOfSyntaxErrors() > 0)
      throw new ParseException();

    QuestionBuilderVisitor eval = new QuestionBuilderVisitor();
    return (List<Question>) eval.visit(tree);
  }

  public List<Question> parseFromString(String str) throws ParseException {
    QuestionLexer lexer = new QuestionLexer(CharStreams.fromString(str));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    QuestionParser parser = new QuestionParser(tokens);
    ParseTree tree = parser.start();

    if (parser.getNumberOfSyntaxErrors() > 0)
      throw new ParseException();

    QuestionBuilderVisitor eval = new QuestionBuilderVisitor();
    return (List<Question>) eval.visit(tree);
  }

  public List<Question> parseEvaluationExamQuestionsFromString(String str) throws ParseException {
    QuestionLexer lexer = new QuestionLexer(CharStreams.fromString(str));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    QuestionParser parser = new QuestionParser(tokens);
    ParseTree tree = parser.start();

    if (parser.getNumberOfSyntaxErrors() > 0)
      throw new ParseException();

    QuestionBuilderVisitor eval = new QuestionBuilderVisitor(true);
    return (List<Question>) eval.visit(tree);
  }

  public List<Question> parseFromFile(String path, ExamPrinter printer) throws IOException, ParseException {
    throw new UnsupportedOperationException();
  }

  public List<Question> parseFromString(String str, ExamPrinter printer) throws ParseException {
    throw new UnsupportedOperationException();
  }
}
