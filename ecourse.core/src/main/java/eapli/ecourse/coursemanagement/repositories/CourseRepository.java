package eapli.ecourse.coursemanagement.repositories;

import java.util.Optional;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.framework.domain.repositories.DomainRepository;

public interface CourseRepository extends DomainRepository<CourseCode, Course> {
  /**
   * Returns the course with the given code.
   *
   * @param code
   * @return
   */
  default Optional<Course> findByCode(final CourseCode code) {
    return ofIdentity(code);
  }

  /**
   * Returns the courses that are opened for enrollment.
   *
   * @return
   */
  Iterable<Course> coursesOpenedForEnrollment();

  /**
   * Returns the courses that are open
   *
   * @return
   */
  Iterable<Course> openCourses();
}