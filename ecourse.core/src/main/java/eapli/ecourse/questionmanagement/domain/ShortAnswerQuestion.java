package eapli.ecourse.questionmanagement.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;

@Entity
public class ShortAnswerQuestion extends Question {
  private static final long serialVersionUID = 1L;

  @ElementCollection
  @CollectionTable(name = "shortAnswerCorrectAnswer")
  @MapKeyColumn(name = "shortAnswerCorrectAnswerIdentifier")
  @Column(name = "grade")
  private Map<String, Double> correctAnswers;

  public ShortAnswerQuestion(final QuestionBody body, QuestionType type) {
    super(body, type);
    this.correctAnswers = new HashMap<>();
  }

  protected ShortAnswerQuestion() {
    // for ORM only
  }

  public void addCorrectAnswer(final String correctAnswer, final Double grade) {
    correctAnswers.put(correctAnswer, grade);
  }

  @Override
  public boolean sameAs(Object other) {
    if (!(other instanceof ShortAnswerQuestion))
      return false;

    final ShortAnswerQuestion that = (ShortAnswerQuestion) other;

    if (this == that)
      return true;

    return this.body().equals(that.body()) && this.type().equals(that.type())
        && this.correctAnswers.equals(that.correctAnswers);
  }
}
