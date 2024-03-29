package eapli.ecourse.eventsmanagement.domain;

import javax.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class Duration implements ValueObject, Comparable<Duration> {
  private static final long serialVersionUID = 1L;

  private int duration;

  protected Duration(final int duration) {
    if (duration <= 0)
      System.out.println("Duration should be greater than 0");

    this.duration = duration;
  }

  protected Duration() {
    // for ORM
  }

  public static Duration valueOf(final int duration) {
    return new Duration(duration);
  }

  public int hour() {
    return duration / 60;
  }

  public int minute() {
    return duration % 60;
  }

  @Override
  public String toString() {
    return String.valueOf(this.duration);
  }

  @Override
  public int compareTo(final Duration arg0) {
    return duration - arg0.duration;
  }
}
