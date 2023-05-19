package eapli.ecourse.exammanagement.domain.repositories;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagement.domain.EvaluationExam;
import eapli.ecourse.exammanagement.domain.ExamCode;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExamRepository extends DomainRepository<ExamCode, EvaluationExam> {
  /**
   * Returns all exams of the given course.
   *
   * @param course
   * @return
   */
  Iterable<EvaluationExam> findAllCourseExams(Course course);

  /**
   * Returns all future exams of the given course.
   *
   * @param course
   * @return
   */
  Iterable<EvaluationExam> findAllFutureCourseExams(Course course);

}
