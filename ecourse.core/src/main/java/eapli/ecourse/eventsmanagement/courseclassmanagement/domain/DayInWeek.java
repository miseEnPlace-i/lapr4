package eapli.ecourse.eventsmanagement.courseclassmanagement.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class DayInWeek implements ValueObject {
  private static final long serialVersionUID = 1L;

  @Enumerated(EnumType.ORDINAL)
  private WeekDay weekDay;

  protected DayInWeek(final WeekDay weekDay) {
    this.weekDay = weekDay;
  }

  protected DayInWeek(final int weekDay) {
    this.weekDay = WeekDay.valueOf(weekDay);
  }

  protected DayInWeek() {
    // for ORM
  }

  public static DayInWeek valueOf(final WeekDay weekDay) {
    Preconditions.nonNull(weekDay);

    return new DayInWeek(weekDay);
  }

  public static DayInWeek valueOf(final int weekDay) {
    Preconditions.nonNull(weekDay);

    if (weekDay < 0 || weekDay > 6)
      throw new IllegalArgumentException("Invalid week day");

    return new DayInWeek(weekDay);
  }

  @Override
  public String toString() {
    return this.weekDay.toString();
  }

  public boolean isSameDay(final DayInWeek other) {
    return this.weekDay == other.weekDay;
  }
}
