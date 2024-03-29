package eapli.ecourse.eventsmanagement.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Embeddable;

import eapli.ecourse.eventsmanagement.courseclassmanagement.domain.DayInWeek;
import eapli.ecourse.eventsmanagement.courseclassmanagement.domain.Hours;
import eapli.ecourse.eventsmanagement.courseclassmanagement.domain.WeekDay;
import eapli.framework.domain.model.ValueObject;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class Time implements ValueObject, Comparable<Time> {
  private static final long serialVersionUID = 1L;

  private Calendar time;

  private Time(final Calendar time) {
    this.time = time;
  }

  protected Time() {
    // for ORM
  }

  public static Time valueOf(final Calendar time) {
    if (time == null)
      throw new IllegalArgumentException("Time should not be null");

    time.set(Calendar.SECOND, 0);
    time.set(Calendar.MILLISECOND, 0);

    return new Time(time);
  }

  public DayInWeek dayInWeek() {
    WeekDay weekDay[] = WeekDay.values();
    int day = time.get(Calendar.DAY_OF_WEEK);

    return DayInWeek.valueOf(weekDay[day - 1]);
  }

  public int hour() {
    return time.get(Calendar.HOUR_OF_DAY);
  }

  public int minute() {
    return time.get(Calendar.MINUTE);
  }

  public Time addDuration(Duration duration) {
    Calendar calendar = (Calendar) time.clone();
    calendar.add(Calendar.HOUR_OF_DAY, duration.hour());
    calendar.add(Calendar.MINUTE, duration.minute());

    return Time.valueOf(calendar);
  }

  public Time subtractDuration(Duration duration) {
    Calendar calendar = (Calendar) time.clone();
    calendar.add(Calendar.HOUR_OF_DAY, -duration.hour());
    calendar.add(Calendar.MINUTE, -duration.minute());

    return Time.valueOf(calendar);
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    return sdf.format(time.getTime());
  }

  @Override
  public int compareTo(final Time arg0) {
    return time.compareTo(arg0.time);
  }

  public int compareHours(final Hours hours) {
    Hours thisHours = Hours.valueOf(this.time);

    return thisHours.compareTo(hours);
  }

}
