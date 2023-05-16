package eapli.ecourse.enrolmentmagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.coursemanagement.domain.CourseDescription;
import eapli.ecourse.coursemanagement.domain.CourseEnrolmentState;
import eapli.ecourse.coursemanagement.domain.CourseState;
import eapli.ecourse.coursemanagement.domain.CourseTitle;
import eapli.ecourse.coursemanagement.domain.EnrolmentLimits;
import eapli.ecourse.enrolmentmanagement.domain.Enrolment;
import eapli.ecourse.enrolmentmanagement.domain.EnrolmentID;
import eapli.ecourse.studentmanagement.domain.MecanographicNumber;
import eapli.ecourse.studentmanagement.domain.Student;
import eapli.ecourse.teachermanagement.domain.Acronym;
import eapli.ecourse.teachermanagement.domain.BirthDate;
import eapli.ecourse.teachermanagement.domain.TaxPayerNumber;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

public class EnrolmentTest {
  public static SystemUser dummyUser(final String username, final Role... roles) {
    final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
    return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles)
        .build();
  }

  public static Course dummyCourse(final CourseCode code, final CourseTitle title, final CourseDescription description,
      final EnrolmentLimits enrolmentLimits, final CourseState courseState, final CourseEnrolmentState enrolmentState,
      final Teacher teacher) {
    return new Course(code, title, description, enrolmentLimits, courseState, enrolmentState, teacher);
  }

  public static Student dummyStudent(final SystemUser user, final MecanographicNumber mecanographicNumber) {
    return new Student(user, mecanographicNumber);
  }

  private SystemUser getNewDummyUser() {
    return dummyUser("dummy", ClientRoles.MANAGER);
  }

  private Course getNewDummyCourse() {
    return dummyCourse(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"), CourseDescription.valueOf("dummy"),
        EnrolmentLimits.valueOf(10, 20), new CourseState(CourseState.State.CLOSED),
        new CourseEnrolmentState(CourseEnrolmentState.EnrolmentState.CLOSED), getNewDummyTeacher());
  }

  private Teacher getNewDummyTeacher() {
    return new Teacher(getNewDummyUser(), TaxPayerNumber.valueOf("123456789"), Acronym.valueOf("abc"),
        BirthDate.valueOf(Calendar.getInstance()));
  }

  private Student getNewDummyStudent() {
    return dummyStudent(getNewDummyUser(), MecanographicNumber.valueOf("1234"));
  }

  @Test
  public void ensureEnrolmentHasStudent() {
    assertThrows(IllegalArgumentException.class, () -> new Enrolment(EnrolmentID.newID(), null, getNewDummyCourse()));
  }

  @Test
  public void ensureEnrolmentHasCourse() {
    assertThrows(IllegalArgumentException.class, () -> new Enrolment(EnrolmentID.newID(), getNewDummyStudent(), null));
  }

  @Test
  public void ensureEnrolmentHasStudentAndCourse() {
    assertThrows(IllegalArgumentException.class, () -> new Enrolment(EnrolmentID.newID(), null, null));
  }

  @Test
  public void ensureEnrolmentIdIsUnique() {
    final Enrolment enrolment1 = new Enrolment(EnrolmentID.newID(), getNewDummyStudent(), getNewDummyCourse());
    final Enrolment enrolment2 = new Enrolment(EnrolmentID.newID(), getNewDummyStudent(), getNewDummyCourse());
    assertNotEquals(enrolment1.identity(), enrolment2.identity());
  }

  @Test
  public void ensureEnrolmentsWithSameIdAreEqual() {
    final EnrolmentID id = EnrolmentID.newID();
    final Enrolment enrolment1 = new Enrolment(id, getNewDummyStudent(), getNewDummyCourse());
    final Enrolment enrolment2 = new Enrolment(id, getNewDummyStudent(), getNewDummyCourse());
    assertEquals(enrolment1, enrolment2);
  }

  @Test
  public void ensureEnrolmentIsCreatedWithPendingState() {
    final Enrolment enrolment = new Enrolment(EnrolmentID.newID(), getNewDummyStudent(), getNewDummyCourse());
    assertTrue(enrolment.isPending());
  }

  @Test
  public void ensureGeneratesId() {
    final Enrolment enrolment = new Enrolment(getNewDummyStudent(), getNewDummyCourse());
    assertNotNull(enrolment.identity());
  }

  @Test
  public void ensureEnrolmentIsEqualToSameInstance() {
    final Enrolment enrolment = new Enrolment(EnrolmentID.newID(), getNewDummyStudent(), getNewDummyCourse());
    assertEquals(enrolment, enrolment);
  }

  @Test
  public void ensureEnrolmentIsEqualWithIdButNotSameWithOtherStudent() {
    final EnrolmentID id = EnrolmentID.newID();
    final Student s = dummyStudent(getNewDummyUser(), MecanographicNumber.valueOf("321"));

    final Enrolment enrolment1 = new Enrolment(id, getNewDummyStudent(), getNewDummyCourse());
    final Enrolment enrolment2 = new Enrolment(id, s, getNewDummyCourse());

    assertEquals(enrolment1, enrolment2);
    assertFalse(enrolment1.sameAs(enrolment2));
  }

  @Test
  public void ensureEnrolmentIsEqualWithIdButNotSameWithOtherCourse() {
    final EnrolmentID id = EnrolmentID.newID();
    final Course c = dummyCourse(CourseCode.valueOf("4321"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"),
        EnrolmentLimits.valueOf(10, 20), new CourseState(CourseState.State.CLOSED),
        new CourseEnrolmentState(CourseEnrolmentState.EnrolmentState.CLOSED), getNewDummyTeacher());

    final Enrolment enrolment1 = new Enrolment(id, getNewDummyStudent(), getNewDummyCourse());
    final Enrolment enrolment2 = new Enrolment(id, getNewDummyStudent(), c);

    assertEquals(enrolment1, enrolment2);
    assertFalse(enrolment1.sameAs(enrolment2));
  }
}
