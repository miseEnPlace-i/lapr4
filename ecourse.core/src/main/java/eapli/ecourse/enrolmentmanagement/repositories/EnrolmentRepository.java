package eapli.ecourse.enrolmentmanagement.repositories;

import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.enrolmentmanagement.domain.Enrolment;
import eapli.ecourse.enrolmentmanagement.domain.EnrolmentID;
import eapli.ecourse.studentmanagement.domain.MecanographicNumber;
import eapli.framework.domain.repositories.DomainRepository;

public interface EnrolmentRepository extends DomainRepository<EnrolmentID, Enrolment> {
  public Iterable<Enrolment> findByStudentMecanographicNumber(MecanographicNumber studentID);

  public Iterable<Enrolment> findByCourseCode(CourseCode courseCode);

  public Iterable<Enrolment> findCourseAccepted(CourseCode courseCode);

  public Iterable<Enrolment> findCourseRejected(CourseCode courseCode);
}
