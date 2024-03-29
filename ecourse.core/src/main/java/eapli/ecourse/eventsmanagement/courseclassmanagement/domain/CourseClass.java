package eapli.ecourse.eventsmanagement.courseclassmanagement.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.eventsmanagement.courseclassmanagement.dto.ClassDTO;
import eapli.ecourse.eventsmanagement.domain.Duration;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

@Entity
public class CourseClass implements AggregateRoot<ClassID> {
  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @EmbeddedId
  private ClassID id;

  @Column(nullable = false)
  private DayInWeek dayInWeek;

  @Column(nullable = false)
  private Duration duration;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SpecialClass> specialClasses;

  @ManyToOne
  private Teacher scheduledBy;

  @ManyToOne
  private Course course;

  @Column(nullable = false)
  private Hours hours;

  public CourseClass(final DayInWeek dayInWeek, final Duration duration, final Hours hours, final Course course,
      final Teacher scheduledBy) {
    Preconditions.noneNull(dayInWeek, duration, hours);

    this.id = ClassID.newID();
    this.dayInWeek = dayInWeek;
    this.duration = duration;
    this.specialClasses = new ArrayList<>();
    this.hours = hours;
    this.course = course;
    this.scheduledBy = scheduledBy;
  }

  public CourseClass(final ClassID id, final DayInWeek dayInWeek, final Duration duration, final Hours hours,
      final Course course,
      final Teacher scheduledBy) {
    Preconditions.noneNull(dayInWeek, duration, hours);

    this.id = id;
    this.dayInWeek = dayInWeek;
    this.duration = duration;
    this.specialClasses = new ArrayList<>();
    this.hours = hours;
    this.course = course;
    this.scheduledBy = scheduledBy;
  }

  protected CourseClass() {
    // for ORM
  }

  @Override
  public boolean equals(final Object o) {
    return DomainEntities.areEqual(this, o);
  }

  @Override
  public boolean sameAs(Object other) {
    if (!(other instanceof CourseClass))
      return false;

    final CourseClass otherClass = (CourseClass) other;

    if (this == otherClass)
      return true;

    for (SpecialClass sc : this.specialClasses) {
      if (!otherClass.specialClasses().contains(sc))
        return false;
    }

    return this.identity().equals(otherClass.identity()) && this.course.equals(otherClass.course())
        && this.dayInWeek.equals(otherClass.dayInWeek()) && this.duration.equals(otherClass.duration())
        && this.hours.equals(otherClass.hours()) && this.scheduledBy.equals(otherClass.scheduledBy());
  }

  @Override
  public ClassID identity() {
    return this.id;
  }

  @Override
  public int hashCode() {
    return DomainEntities.hashCode(this);
  }

  public DayInWeek dayInWeek() {
    return this.dayInWeek;
  }

  public Duration duration() {
    return this.duration;
  }

  public Course course() {
    return this.course;
  }

  public Hours hours() {
    return this.hours;
  }

  public List<SpecialClass> specialClasses() {
    return this.specialClasses;
  }

  public ClassDTO toDto() {
    return new ClassDTO(this.id, this.dayInWeek, this.duration, this.hours, this.course);
  }

  public void addSpecialClass(Time time) {
    this.specialClasses.add(new SpecialClass(time));
  }

  public Teacher scheduledBy() {
    return this.scheduledBy;
  }
}
