package eapli.ecourse.eventsmanagement.meetingmanagement.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import eapli.ecourse.eventsmanagement.domain.Duration;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

public class MeetingTest {

  private SystemUser getDummyUser() {
    return dummyUser("dummy", ClientRoles.MANAGER);
  }

  public static SystemUser dummyUser(final String username, final Role... roles) {
    final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
    return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles)
        .build();
  }

  private Meeting getDummyMeeting() {
    Calendar c = Calendar.getInstance();
    return new Meeting(Time.valueOf(c), Duration.valueOf(120));
  }

  private Invite getDummyInvite() {
    return new Invite(getDummyMeeting(), getDummyUser());
  }

  @Test
  public void ensureItsPossibleToCreateInvite() {
    Invite invite = getDummyInvite();
    assertEquals(invite.user(), getDummyUser());
    assertTrue(invite.status().isPending());
  }

  @Test
  public void ensureItsPossibleToCancelMeeting() {
    Meeting meeting = getDummyMeeting();
    meeting.cancel();
    assertNotNull(meeting.canceledAt());
  }

  @Test
  public void ensureItsPossibleToAcceptInvite() {
    Invite invite = getDummyInvite();
    invite.status().accept();
    assertTrue(invite.status().isAccepted());
  }

  @Test
  public void ensureIdToStringIsWorking() {
    Calendar c = Calendar.getInstance();

    Meeting meeting = new Meeting(MeetingID.valueOf("123"), Time.valueOf(c), Duration.valueOf(120));
    assertEquals("123", meeting.identity().toString());
  }

  @Test
  public void ensureIdIsComparable() {
    MeetingID id1 = MeetingID.valueOf("123");
    MeetingID id2 = MeetingID.valueOf("122");
    MeetingID id3 = MeetingID.valueOf("124");
    assertTrue(id1.compareTo(id2) > 0);
    assertTrue(id1.compareTo(id3) < 0);
  }
}