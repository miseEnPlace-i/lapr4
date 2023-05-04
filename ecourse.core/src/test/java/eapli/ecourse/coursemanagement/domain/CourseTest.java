package eapli.ecourse.coursemanagement.domain;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CourseTest {
  private Course getDummyCourse() {
    return new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20), new CourseState(),
        new CourseEnrolmentState());
  }

  @Test
  public void ensureCourseHasCode() {
    assertThrows(IllegalArgumentException.class, () -> new Course(null, CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20), new CourseState(),
        new CourseEnrolmentState()));
  }

  @Test
  public void ensureCourseHasTitle() {
    assertThrows(IllegalArgumentException.class, () -> new Course(CourseCode.valueOf("1234"), null,
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20), new CourseState(),
        new CourseEnrolmentState()));
  }

  @Test
  public void ensureCourseHasDescription() {
    assertThrows(IllegalArgumentException.class,
        () -> new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
            null, EnrolmentLimits.valueOf(10, 20), new CourseState(), new CourseEnrolmentState()));
  }

  @Test
  public void ensureCourseHasEnrolmentLimits() {
    assertThrows(IllegalArgumentException.class,
        () -> new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
            CourseDescription.valueOf("dummy"), null, new CourseState(), new CourseEnrolmentState()));
  }

  @Test
  public void ensureCourseHasCourseState() {
    assertThrows(IllegalArgumentException.class,
        () -> new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
            CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20), null, new CourseEnrolmentState()));
  }

  @Test
  public void ensureCourseHasEnrolmentState() {
    assertThrows(IllegalArgumentException.class,
        () -> new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
            CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20), new CourseState(), null));
  }

  @Test
  public void ensureCourseHasDefaultCourseState() {
    final Course course = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));
    assertTrue(course.state().isClosed());
  }

  @Test
  public void ensureCourseHasDefaultEnrolmentState() {
    final Course course = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));
    assertTrue(course.enrolmentState().isClosed());
  }

  @Test
  public void ensureCourseIdIsUnique() {
    final Course course1 = new Course(CourseCode.newID(), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));
    final Course course2 = new Course(CourseCode.newID(), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));

    assertNotEquals(course1.identity(), course2.identity());
  }

  @Test
  public void ensureCourseIsEqualWithSameCode() {
    final Course course1 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy1"),
        CourseDescription.valueOf("dummy1"), EnrolmentLimits.valueOf(10, 20));
    final Course course2 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy2"),
        CourseDescription.valueOf("dummy2"), EnrolmentLimits.valueOf(10, 20));

    assertEquals(course1, course2);
  }

  @Test
  public void ensureCourseIsEqualButNotSame() {
    final Course course1 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy1"),
        CourseDescription.valueOf("dummy1"), EnrolmentLimits.valueOf(10, 20));
    final Course course2 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy2"),
        CourseDescription.valueOf("dummy2"), EnrolmentLimits.valueOf(10, 20));

    assertEquals(course1, course2);
    assertFalse(course1.sameAs(course2));
  }

  @Test
  public void ensureCourseIsTheSameWithEqualAttributes() {
    final Course course1 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));
    final Course course2 = new Course(CourseCode.valueOf("1234"), CourseTitle.valueOf("dummy"),
        CourseDescription.valueOf("dummy"), EnrolmentLimits.valueOf(10, 20));

    assertTrue(course1.sameAs(course2));
  }

  @Test
  public void ensureCourseIsEqualToSameInstance() {
    final Course course = getDummyCourse();

    assertEquals(course, course);
  }

  @Test
  public void ensureCourseIsInCorrectStateAfterToggle() {
    final Course course = getDummyCourse();

    assertTrue(course.enrolmentState().isClosed());
    course.toggleEnrolmentState();
    assertTrue(course.enrolmentState().isOpen());
  }

  @Test
  public void ensureDoubleToggleDoesNotChangeState() {
    final Course course = getDummyCourse();

    assertTrue(course.enrolmentState().isClosed());
    course.toggleEnrolmentState();
    course.toggleEnrolmentState();
    assertTrue(course.enrolmentState().isClosed());
  }
}
