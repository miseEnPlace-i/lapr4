package eapli.ecourse.exammanagement.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.exammanagement.domain.dto.ExamDTO;
import eapli.ecourse.questionmanagement.domain.Identifier;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

/**
 * Abstract class that describes an exam.
 */
@Entity
public abstract class Exam implements AggregateRoot<ExamCode> {
  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @EmbeddedId
  private ExamCode code;

  @Column(nullable = false)
  private Course course;

  @Column(nullable = false)
  private Teacher teacher;

  @Column(nullable = false)
  private Identifier identifier;

  @Column(nullable = false)
  private Title title;

  @Temporal(TemporalType.TIMESTAMP)
  @AttributeOverride(name = "time", column = @Column(name = "startTime"))
  private Time startTime;

  @Temporal(TemporalType.TIMESTAMP)
  @AttributeOverride(name = "time", column = @Column(name = "endTime"))
  private Time endTime;

  @Column(nullable = true)
  private Description description;

  @Column(nullable = false)
  private ExamState state;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Section> sections;

  protected Exam() {
    // for ORM only
  }

  public Exam(Course course, Teacher teacher, Identifier identifier, Title title, Description description,
      ExamState state, Time starTime, Time endTime, Collection<Section> sections) {
    this.code = ExamCode.newID();
    this.course = course;
    this.teacher = teacher;
    this.identifier = identifier;
    this.title = title;
    this.description = description;
    this.state = state;
    this.startTime = starTime;
    this.endTime = endTime;
    this.sections = new ArrayList<>(sections);
  }

  @Override
  public ExamCode identity() {
    return this.code;
  }

  public abstract boolean sameAs(Object other);

  public Course course() {
    return this.course;
  }

  public ExamDTO toDto() {
    return new ExamDTO(this.code, this.course, this.teacher, this.identifier, this.title, this.description, this.state);
  }

  @Override
  public String toString() {
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return "Exam [code=" + code + ", course=" + course + ", description=" + description + ", identifier=" + identifier
        + ", sections=" + sections + ", state=" + state + ", teacher=" + teacher + ", title=" + title + ", endTime="
        + sdf.format(endTime) + ", startTime=" + sdf.format(startTime) + "]";
  }
}
