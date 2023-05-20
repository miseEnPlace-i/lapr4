package eapli.ecourse.eventsmanagement.courseclassmanagement.application;

import eapli.ecourse.enrolmentmanagement.repositories.EnrolmentRepository;
import eapli.ecourse.eventsmanagement.application.ScheduleAvailabilityService;
import eapli.ecourse.eventsmanagement.courseclassmanagement.domain.CourseClass;
import eapli.ecourse.eventsmanagement.courseclassmanagement.dto.ClassDTO;
import eapli.ecourse.eventsmanagement.courseclassmanagement.repositories.CourseClassRepository;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.eventsmanagement.meetingmanagement.repositories.MeetingRepository;
import eapli.ecourse.studentmanagement.repositories.StudentRepository;
import eapli.ecourse.teachermanagement.dto.TeacherDTO;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

@UseCaseController
public class UpdateClassScheduleController {
  private CourseClassRepository classRepository;
  private ListCourseClassService classService;
  private ScheduleAvailabilityService scheduleAvailabilityService;
  private AuthorizationService authzRegistry;
  private TeacherRepository teacherRepository;

  public UpdateClassScheduleController(final CourseClassRepository classRepository,
      final AuthorizationService authzRegistry,
      MeetingRepository meetingRepository, EnrolmentRepository enrolmentRepository,
      StudentRepository studentRepository, TeacherRepository teacherRepository) {
    this.classRepository = classRepository;
    this.scheduleAvailabilityService = new ScheduleAvailabilityService(classRepository, meetingRepository,
        enrolmentRepository, studentRepository);
    this.classService = new ListCourseClassService(classRepository);
    this.authzRegistry = authzRegistry;
    this.teacherRepository = teacherRepository;
  }

  public CourseClass updateScheduleClass(Time time, ClassDTO courseClass) {
    authzRegistry.ensureAuthenticatedUserHasAnyOf(ClientRoles.TEACHER);

    Preconditions.noneNull(time, courseClass);

    CourseClass newClass = classRepository.ofIdentity(courseClass.getId()).orElseThrow();
    newClass.addSpecialClass(time);
    return saveClass(newClass);

  }

  private CourseClass saveClass(CourseClass newClass) {
    return classRepository.save(newClass);
  }

  public Iterable<ClassDTO> listAllClassesForAuthenticatedTeacher() {
    SystemUser user = authzRegistry.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();
    final TeacherDTO teacherDTO = teacherRepository.findByUsername(user.username()).orElseThrow().toDto();
    return classService.findAllByTeacherTaxPayerNumber(teacherDTO.getNumber());
  }
}
