package eapli.ecourse.questionmanagement.application;

import java.util.List;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagement.domain.parsers.QuestionsMain;
import eapli.ecourse.questionmanagement.domain.Question;
import eapli.ecourse.questionmanagement.repositories.QuestionRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class AddQuestionsController {
  private final QuestionRepository questionRepository;
  private final CourseRepository courseRepository;
  private final ListCourseService courseListService;
  private final AuthorizationService authz;

  public AddQuestionsController(QuestionRepository questionRepository, CourseRepository courseRepository,
      AuthorizationService authz) {
    this.questionRepository = questionRepository;
    this.courseRepository = courseRepository;
    this.authz = authz;

    this.courseListService = new ListCourseService(courseRepository);
  }

  public Iterable<CourseDTO> listAvailableCourses() {
    return this.courseListService.listNotClosedCourses();
  }

  public void addQuestionsFromFile(String filename, CourseDTO courseDTO) {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);

    Course course = courseRepository.ofIdentity(courseDTO.getCode()).orElseThrow();
    List<Question> questions = QuestionsMain.parseWithVisitor(filename);

    questions.forEach(question -> {
      question.changeCourse(course);
      addQuestion(question);
    });
  }

  public Question addQuestion(Question question) {
    return questionRepository.save(question);
  }
}
