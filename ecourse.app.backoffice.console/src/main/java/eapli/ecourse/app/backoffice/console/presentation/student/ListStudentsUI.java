package eapli.ecourse.app.backoffice.console.presentation.student;

import eapli.ecourse.app.common.console.presentation.student.StudentPrinter;
import eapli.ecourse.studentmanagement.application.ListStudentsController;
import eapli.ecourse.studentmanagement.dto.StudentDTO;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListStudentsUI extends AbstractListUI<StudentDTO> {
  private final ListStudentsController controller = new ListStudentsController();

  @Override
  public String headline() {
    return "List Students";
  }

  @Override
  protected String emptyMessage() {
    return "No data.";
  }

  @Override
  protected Iterable<StudentDTO> elements() {
    return controller.allStudents();
  }

  @Override
  protected Visitor<StudentDTO> elementPrinter() {
    return new StudentPrinter();
  }

  @Override
  protected String elementName() {
    return "Student";
  }

  @Override
  protected String listHeader() {
    return String.format("#  %-15s%-20s%-30s%-30s", "Mec. Number", "Username", "F. Name", "L. Name");
  }
}
