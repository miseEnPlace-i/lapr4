package eapli.ecourse.app.common.console.presentation.meeting;

import eapli.ecourse.eventsmanagement.meetingmanagement.application.ListMeetingController;
import eapli.ecourse.eventsmanagement.meetingmanagement.dto.InviteDTO;
import eapli.ecourse.eventsmanagement.meetingmanagement.dto.MeetingDTO;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class ListMeetingUI extends AbstractUI {
  private ListMeetingController ctrl;

  @Override
  protected boolean doShow() {
    ctrl = new ListMeetingController(PersistenceContext.repositories().meetings(),
        PersistenceContext.repositories().invites(), AuthzRegistry.authorizationService());

    Iterable<MeetingDTO> meetings = ctrl.getMeetingList();

    if (!meetings.iterator().hasNext()) {
      System.out.println("There are no registered meetings.");
      return false;
    }

    SelectWidget<MeetingDTO> selector = new SelectWidget<>(new MeetingPrinter().header(), meetings,
        new MeetingPrinter());
    selector.show();
    final MeetingDTO selected = selector.selectedElement();

    if (selected == null) {
      return false;
    }

    Iterable<InviteDTO> invites = ctrl.getMeetingDetails(selected);

    if (!invites.iterator().hasNext()) {
      System.out.println("There are no registered invites.");
      return false;
    }

    printMeetingDetails(invites);

    Console.readLine("\nPress Enter to continue...");

    return false;
  }

  private void printMeetingDetails(Iterable<InviteDTO> invites) {
    System.out.println("\nInvite details:\n");

    new MeetingParticipantHeader().printHeader();

    for (InviteDTO invite : invites) {
      new MeetingParticipantPrinter().visit(invite, ctrl.getAuthenticatedUser());
      System.out.println();
    }

  }

  @Override
  public String headline() {
    return "Meeting participants and their status";
  }

}
