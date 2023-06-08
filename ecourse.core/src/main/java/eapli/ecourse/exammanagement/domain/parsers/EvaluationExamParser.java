package eapli.ecourse.exammanagement.domain.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExamBuilder;

public class EvaluationExamParser {
  public static EvaluationExamBuilder parseWithVisitor(String filePath) throws IOException, ParseException {
    ExamLexer lexer = new ExamLexer(CharStreams.fromFileName(filePath));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExamParser parser = new ExamParser(tokens);
    ParseTree tree = parser.start();

    if (parser.getNumberOfSyntaxErrors() > 0)
      throw new ParseException();

    EvaluationExamVisitor eval = new EvaluationExamVisitor();
    EvaluationExamBuilder builder = (EvaluationExamBuilder) eval.visit(tree);

    String fileContent = Files.readString(Paths.get(filePath));
    return builder.withFileContent(fileContent);
  }
}
