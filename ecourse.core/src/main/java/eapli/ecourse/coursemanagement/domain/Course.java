package eapli.ecourse.coursemanagement.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

@Entity
public class Course implements AggregateRoot<CourseCode> {
  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @EmbeddedId
  private CourseCode code;

  @Column(nullable = false)
  private CourseTitle title;

  @Column(nullable = false)
  private CourseDescription description;

  @Column(nullable = false)
  private EnrolmentLimits enrolmentLimits;

  @Column(nullable = false)
  private CourseState courseState;

  @Column(nullable = false)
  private CourseEnrolmentState enrolmentState;

  @Column(nullable = false)
  private Calendar createdAt;

  protected Course() {
    // for ORM
  }

  public Course(final CourseCode code, final CourseTitle title, final CourseDescription description,
      final EnrolmentLimits enrolmentLimits, final CourseState courseState, final CourseEnrolmentState enrolmentState) {
    Preconditions.noneNull(code, title, description, enrolmentLimits, courseState, enrolmentState);

    this.code = code;
    this.title = title;
    this.description = description;
    this.enrolmentLimits = enrolmentLimits;
    this.courseState = courseState;
    this.enrolmentState = enrolmentState;
    this.createdAt = Calendar.getInstance();
  }

  public Course(final CourseCode code, final CourseTitle title, final CourseDescription description,
      final EnrolmentLimits enrolmentLimits) {
    Preconditions.noneNull(code, title, description, enrolmentLimits);

    this.code = code;
    this.title = title;
    this.description = description;
    this.enrolmentLimits = enrolmentLimits;
    this.courseState = new CourseState();
    this.enrolmentState = new CourseEnrolmentState();
    this.createdAt = Calendar.getInstance();
  }

  @Override
  public boolean equals(final Object o) {
    return DomainEntities.areEqual(this, o);
  }

  @Override
  public int hashCode() {
    return DomainEntities.hashCode(this);
  }

  @Override
  public boolean sameAs(final Object other) {
    if (!(other instanceof Course))
      return false;

    final Course that = (Course) other;

    if (this == that)
      return true;

    return code().equals(that.code()) && title().equals(that.title())
        && description().equals(that.description()) && enrolmentLimits().equals(that.enrolmentLimits())
        && state().equals(that.state()) && enrolmentState.equals(that.enrolmentState())
        && createdAt().equals(that.createdAt());
  }

  public CourseCode code() {
    return identity();
  }

  public CourseTitle title() {
    return this.title;
  }

  public CourseDescription description() {
    return this.description;
  }

  public CourseState state() {
    return this.courseState;
  }

  public CourseEnrolmentState enrolmentState() {
    return this.enrolmentState;
  }

  public Calendar createdAt() {
    return this.createdAt;
  }

  public EnrolmentLimits enrolmentLimits() {
    return this.enrolmentLimits;
  }

  public void toggleEnrolmentState() {
    if (enrolmentState.isClosed())
      enrolmentState.changeToOpen();
    else
      enrolmentState.changeToClosed();
  }

  @Override
  public CourseCode identity() {
    return this.code;
  }
}
