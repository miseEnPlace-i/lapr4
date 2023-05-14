package eapli.ecourse.questionmanagement.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class MissingWordsQuestion extends Question {
  private static final long serialVersionUID = 1L;

  @ElementCollection(fetch = FetchType.LAZY)
  private List<String> missingWords;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> options;

  public MissingWordsQuestion(final QuestionBody body, QuestionType type) {
    super(body, type);
    this.missingWords = new ArrayList<>();
    this.options = new ArrayList<>();
  }

  protected MissingWordsQuestion() {
    // for ORM only
  }

  public void addMissingWord(final String missingWord) {
    missingWords.add(missingWord);
  }

  public void addOption(final String option) {
    options.add(option);
  }

  public List<String> missingWords() {
    return this.missingWords;
  }

  @Override
  public boolean sameAs(Object other) {
    if (!(other instanceof MissingWordsQuestion))
      return false;

    final MissingWordsQuestion that = (MissingWordsQuestion) other;

    if (this == that)
      return true;

    return this.body().equals(that.body()) && this.type().equals(that.type())
        && this.missingWords.equals(that.missingWords);
  }
}
