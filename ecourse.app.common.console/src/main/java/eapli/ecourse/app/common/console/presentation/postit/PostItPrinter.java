package eapli.ecourse.app.common.console.presentation.postit;

import java.text.SimpleDateFormat;
import eapli.ecourse.postitmanagement.dto.PostItDTO;
import eapli.framework.visitor.Visitor;

public class PostItPrinter implements Visitor<PostItDTO> {
  private String format = "%-38s%-15s%-15s%-15s%-8s%-9s%-9s%-11s%-18s%-15s%-7s";

  public String header() {
    return String.format("#  " + format, "ID", "Title", "Board", "Owner", "State", "Pos.",
        "Latest?", "Has Prev?", "Created At", "Description", "Image");
  }

  public void printHeader() {
    System.out.print(header());
  }

  @Override
  public void visit(final PostItDTO visitee) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    System.out.printf(format, visitee.getId(), visitee.getTitle(), visitee.getBoard().getTitle(),
        visitee.getOwner().getUsername(), visitee.getState(), visitee.getCoordinates(),
        visitee.isLatest() ? "Yes" : "No", visitee.getPrevious() == null ? "No" : "Yes",
        formatter.format(visitee.getCreatedAt().getTime()),
        visitee.getDescription() == null ? "null" : visitee.getDescription().toString().substring(0, 10) + "...",
        visitee.getImage() == null ? "No" : "Yes");
  }
}
