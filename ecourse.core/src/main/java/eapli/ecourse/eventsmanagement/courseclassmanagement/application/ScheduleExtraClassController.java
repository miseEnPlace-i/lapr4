package eapli.ecourse.eventsmanagement.courseclassmanagement.application;

import java.util.HashSet;
import java.util.Set;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.enrolmentmanagement.application.EnrolmentListService;
import eapli.ecourse.enrolmentmanagement.dto.EnrolmentDTO;
import eapli.ecourse.enrolmentmanagement.repositories.EnrolmentRepository;
import eapli.ecourse.eventsmanagement.application.ScheduleAvailabilityService;
import eapli.ecourse.eventsmanagement.courseclassmanagement.repositories.CourseClassRepository;
import eapli.ecourse.eventsmanagement.courseclassmanagement.repositories.ExtraordinaryClassRepository;
import eapli.ecourse.eventsmanagement.meetingmanagement.repositories.MeetingRepository;
import eapli.ecourse.studentmanagement.domain.Student;
import eapli.ecourse.studentmanagement.dto.StudentDTO;
import eapli.ecourse.studentmanagement.repositories.StudentRepository;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ScheduleExtraClassController {

  private EnrolmentListService enrolmentListService;
  private ListCourseService listCourseService;
  private ScheduleAvailabilityService scheduleAvailabilityService;

  private Teacher teacher;

  private CourseRepository courseRepository;
  private EnrolmentRepository enrolmentRepository;
  private ExtraordinaryClassRepository extraClassRepository;
  private TeacherRepository teacherRepository;
  private StudentRepository studentRepository;

  public ScheduleExtraClassController(CourseRepository courseRepository, EnrolmentRepository enrolmentRepository,
      ExtraordinaryClassRepository extraClassRepository, MeetingRepository meetingRepository,
      StudentRepository studentRepository, TeacherRepository teacherRepository, CourseClassRepository classRepository) {
    this.enrolmentListService = new EnrolmentListService(enrolmentRepository);
    this.listCourseService = new ListCourseService(courseRepository);
    this.scheduleAvailabilityService = new ScheduleAvailabilityService(classRepository, meetingRepository,
        enrolmentRepository, studentRepository);

    this.courseRepository = courseRepository;
    this.enrolmentRepository = enrolmentRepository;
    this.extraClassRepository = extraClassRepository;
    this.teacherRepository = teacherRepository;
    this.studentRepository = studentRepository;

  }

  public Iterable<CourseDTO> listAllInProgressLecturedBy() {
    setCurrentAuthenticatedTeacher();

    return listCourseService.listInProgressCoursesThatTeacherLectures(teacher);
  }

  public void setCurrentAuthenticatedTeacher() {
    AuthorizationService authz = AuthzRegistry.authorizationService();

    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.TEACHER, ClientRoles.POWER_USER);

    SystemUser authenticatedUser = authz.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();

    teacher = teacherRepository.findByUsername(authenticatedUser.username()).orElseThrow();
  }

  public Iterable<StudentDTO> listStudentsEnrolled(CourseDTO courseDTO) {
    Iterable<EnrolmentDTO> enrolments = enrolmentListService.listStudentsEnrolled(courseDTO.getCode());
    Set<StudentDTO> students = new HashSet<>();
    for (EnrolmentDTO enrolment : enrolments)
      students.add(studentRepository.ofIdentity(enrolment.getStudentNumber()).orElseThrow().toDto());

    return students;
  }

}