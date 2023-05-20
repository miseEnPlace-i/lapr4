package eapli.ecourse.exammanagement.domain;

import java.util.List;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.validations.Preconditions;

public class EvaluationExamBuilder implements DomainFactory<EvaluationExam> {
  private EvaluationExam exam;

  private Course course;
  private Teacher teacher;
  private ExamIdentifier identifier;
  private ExamTitle title;
  private ExamDescription description;
  private List<ExamSection> sections;
  private Time startTime;
  private Time endTime;
  private ExamInfo feedbackInfo;
  private ExamInfo gradeInfo;
  private ExamScore score;

  public EvaluationExamBuilder withCourse(Course course) {
    this.course = course;
    return this;
  }

  public EvaluationExamBuilder withTeacher(Teacher teacher) {
    this.teacher = teacher;
    return this;
  }

  public EvaluationExamBuilder withIdentifier(ExamIdentifier identifier) {
    this.identifier = identifier;
    return this;
  }

  public EvaluationExamBuilder withTitle(ExamTitle title) {
    this.title = title;
    return this;
  }

  public EvaluationExamBuilder withDescription(ExamDescription description) {
    this.description = description;
    return this;
  }

  public EvaluationExamBuilder withSections(List<ExamSection> sections) {
    this.sections = sections;
    return this;
  }

  public EvaluationExamBuilder withStartTime(Time startTime) {
    this.startTime = startTime;
    return this;
  }

  public EvaluationExamBuilder withEndTime(Time endTime) {
    this.endTime = endTime;
    return this;
  }

  public EvaluationExamBuilder withFeedbackInfo(ExamInfo feedbackInfo) {
    this.feedbackInfo = feedbackInfo;
    return this;
  }

  public EvaluationExamBuilder withGradeInfo(ExamInfo gradeInfo) {
    this.gradeInfo = gradeInfo;
    return this;
  }

  public EvaluationExamBuilder withScore(ExamScore score) {
    this.score = score;
    return this;
  }

  private EvaluationExam buildOrThrow() {
    if (exam != null)
      return exam;

    Preconditions.noneNull(course, teacher, identifier, title, description, sections);

    exam = new EvaluationExam(course, teacher, identifier, title, description, sections, startTime, endTime,
        feedbackInfo, gradeInfo, score);
    exam.publish();
    return exam;
  }

  @Override
  public EvaluationExam build() {
    final EvaluationExam ret = buildOrThrow();
    exam = null;
    return ret;
  }
}
