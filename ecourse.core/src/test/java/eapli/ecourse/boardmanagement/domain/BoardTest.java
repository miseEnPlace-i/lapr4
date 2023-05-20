package eapli.ecourse.boardmanagement.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

public class BoardTest {

  private SystemUser user;

  @Before
  public void setUp() {
    final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
    this.user = userBuilder.with("username", "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(ClientRoles.STUDENT)
        .build();
  }

  @Test
  public void ensureBoardHasTitle() {
    List<UserPermission> permissions = new ArrayList<>();
    List<BoardColumn> columns = new ArrayList<>();
    List<BoardRow> rows = new ArrayList<>();

    assertThrows(IllegalArgumentException.class, () -> new Board(null, permissions, columns, rows, user));
  }

  @Test
  public void ensureBoardPermissionsAreNotMandatory() {
    List<BoardColumn> columns = new ArrayList<>();
    List<BoardRow> rows = new ArrayList<>();

    Board b = new Board(new BoardTitle("title"), null, columns, rows, user);

    assert (b != null);
  }

  @Test
  public void ensureBoardHasColumns() {
    List<UserPermission> permissions = new ArrayList<>();
    List<BoardRow> rows = new ArrayList<>();

    assertThrows(IllegalArgumentException.class,
        () -> new Board(new BoardTitle("title"), permissions, null, rows, user));
  }

  @Test
  public void ensureBoardHasRows() {
    List<UserPermission> permissions = new ArrayList<>();
    List<BoardColumn> columns = new ArrayList<>();

    assertThrows(IllegalArgumentException.class,
        () -> new Board(new BoardTitle("title"), permissions, columns, null, user));
  }

  @Test
  public void ensureBoardHasUser() {
    List<UserPermission> permissions = new ArrayList<>();
    List<BoardColumn> columns = new ArrayList<>();
    List<BoardRow> rows = new ArrayList<>();

    assertThrows(IllegalArgumentException.class,
        () -> new Board(new BoardTitle("title"), permissions, columns, rows, null));
  }

  @Test
  public void ensureBoardConstructorWorks() {
    List<UserPermission> permissions = new ArrayList<>();
    List<BoardColumn> columns = new ArrayList<>();
    List<BoardRow> rows = new ArrayList<>();

    Board b = new Board(new BoardTitle("title"), permissions, columns, rows, user);

    assertEquals("title", b.title().toString());
    assertEquals(permissions, b.permissions());
    assertEquals(columns, b.columns());
    assertEquals(rows, b.rows());
    assertEquals(user, b.owner());
  }

}