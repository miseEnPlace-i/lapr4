package eapli.ecourse.enrolmentmanagement.application;

import java.util.stream.StreamSupport;

import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.enrolmentmanagement.domain.Enrolment;
import eapli.ecourse.enrolmentmanagement.dto.EnrolmentDTO;
import eapli.ecourse.enrolmentmanagement.repositories.EnrolmentRepository;
import eapli.ecourse.studentmanagement.domain.MecanographicNumber;

public class EnrolmentListService {

  private EnrolmentRepository enrolmentRepository;

  public EnrolmentListService(EnrolmentRepository enrolmentRepository) {
    this.enrolmentRepository = enrolmentRepository;
  }

  public Iterable<EnrolmentDTO> listPendingCourseApplications(CourseCode code) {
    final Iterable<Enrolment> enrolments = enrolmentRepository.findPendingByCourseCode(code);

    return convertToDTO(enrolments);
  }

  public Iterable<EnrolmentDTO> findByStudentMecanographicNumber(MecanographicNumber studentID) {
    final Iterable<Enrolment> enrolments = enrolmentRepository.findByStudentMecanographicNumber(studentID);

    return convertToDTO(enrolments);
  }

  public Iterable<EnrolmentDTO> listStudentsEnrolled(CourseCode code) {
    final Iterable<Enrolment> enrolments = enrolmentRepository.findCourseAccepted(code);

    return convertToDTO(enrolments);
  }

  private Iterable<EnrolmentDTO> convertToDTO(Iterable<Enrolment> enrolments) {
    return StreamSupport.stream(enrolments.spliterator(), true)
        .map(Enrolment::toDto)
        .collect(java.util.stream.Collectors.toUnmodifiableList());
  }

}
