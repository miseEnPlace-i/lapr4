package eapli.ecourse.coursemanagement.repositories;

import java.util.Optional;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.studentmanagement.domain.Student;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

public interface CourseRepository extends DomainRepository<CourseCode, Course> {
  /**
   * Returns the courses that are opened for enrollment.
   *
   * @return
   */
  Iterable<Course> findAllOpenForEnrolment();

  /**
   * Returns the courses that are open
   *
   * @return
   */
  Iterable<Course> findAllOpen();

  /**
   * Returns the courses that are not finished
   *
   * @return
   */
  Iterable<Course> findAllNotClosed();

  /**
   * Returns the courses that are closed
   *
   * @return
   */
  Iterable<Course> findAllClosed();

  /**
   * Returns the courses that are in progress
   *
   * @return
   */
  Iterable<Course> findAllInProgress();

  /**
   * Returns the courses that are in progress, lectured by the given teacher
   *
   * @return
   */
  public Iterable<Course> findAllInProgressLecturedByTeacher(Teacher teacher);

  /**
   *
   * @param student
   * @return
   */

  public Iterable<Course> findNotClosedCoursesThatTeacherLectures(Teacher teacher);

  /**
   * Returns the courses that are in progress, in which the given student is
   * enrolled
   *
   * @return
   */
  public Iterable<Course> findAllInProgressThatStudentIsEnrolled(Student student);

  /**
   * Returns the courses that are not closed
   *
   * @return
   */
  Iterable<Course> findAllNotFinished();

  /**
   * Returns the course with the given code
   *
   * @param code
   * @return
   */
  Optional<Course> findByCode(CourseCode code);
}
