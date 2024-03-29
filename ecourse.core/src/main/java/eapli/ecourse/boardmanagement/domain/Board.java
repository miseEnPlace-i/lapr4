package eapli.ecourse.boardmanagement.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import eapli.ecourse.boardmanagement.dto.BoardDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.validations.Preconditions;

@Entity
public class Board implements AggregateRoot<BoardID> {
  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @EmbeddedId
  private BoardID id;

  @Column(nullable = false)
  private BoardTitle title;

  @Column
  private Archived archived;

  @ManyToOne
  private SystemUser owner;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserPermission> permissions;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "board_id")
  private List<BoardColumn> columns;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "board_id")
  private List<BoardRow> rows;

  protected Board() {
    // for ORM
  }

  public Board(final BoardTitle title, final List<UserPermission> permissions,
      final List<BoardColumn> column, final List<BoardRow> row, final BoardID id,
      final SystemUser user) {

    // Only mandatory fields are checked
    Preconditions.noneNull(title, id, column, row, user);

    this.title = title;
    this.archived = null;
    this.permissions = permissions;
    this.id = id;
    this.columns = column;
    this.rows = row;
    this.owner = user;
  }

  public Board(final BoardTitle title, final List<UserPermission> permissions,
      final List<BoardColumn> column, final List<BoardRow> row, final BoardID id,
      final SystemUser user, final Archived archived) {

    // Only mandatory fields are checked
    Preconditions.noneNull(title, id, column, row, user);

    this.title = title;
    this.archived = archived;
    this.permissions = permissions;
    this.id = id;
    this.columns = column;
    this.rows = row;
    this.owner = user;
  }

  public Board(final BoardTitle title, final List<UserPermission> permissions,
      final List<BoardColumn> column, final List<BoardRow> row, final SystemUser user) {

    // Only mandatory fields are checked
    Preconditions.noneNull(title, column, row, user);

    this.title = title;
    this.archived = null;
    this.permissions = permissions;
    this.id = BoardID.newID();
    this.columns = column;
    this.rows = row;
    this.owner = user;
  }

  public BoardTitle title() {
    return this.title;
  }

  public Archived archived() {
    return this.archived;
  }

  public List<BoardColumn> columns() {
    return this.columns;
  }

  public List<BoardRow> rows() {
    return this.rows;
  }

  public List<UserPermission> permissions() {
    return this.permissions;
  }

  public SystemUser owner() {
    return this.owner;
  }

  @Override
  public boolean equals(Object other) {
    return DomainEntities.areEqual(this, other);
  }

  @Override
  public BoardID identity() {
    return this.id;
  }

  @Override
  public boolean sameAs(Object other) {
    if (!(other instanceof Board))
      return false;

    final Board otherBoard = (Board) other;

    if (this == otherBoard)
      return true;

    if (this.columns.size() != otherBoard.columns().size())
      return false;

    if (this.rows.size() != otherBoard.rows().size())
      return false;

    for (BoardColumn column : columns)
      if (!otherBoard.columns().contains(column))
        return false;

    for (BoardRow row : rows)
      if (!otherBoard.rows().contains(row))
        return false;

    for (UserPermission permission : permissions)
      if (!otherBoard.permissions().contains(permission))
        return false;

    return this.identity().equals(otherBoard.identity()) && this.title.equals(otherBoard.title())
        && this.archived != null ? this.archived.equals(otherBoard.archived())
            : otherBoard.archived() == null && this.owner.equals(otherBoard.owner());
  }

  public BoardDTO toDto() {
    return new BoardDTO(this.id, this.title, this.archived, this.owner, this.permissions, this.rows,
        this.columns);
  }

  /**
   * Checks if the user has write permission to the board.
   *
   * @param username
   * @return true if the user has write permission to the board, false otherwise
   */
  public boolean canWrite(Username username) {
    if (this.owner().username().equals(username))
      return true;

    return permissions.stream().anyMatch(p -> p.canWrite(username));
  }

  /**
   * Checks if the user has at least read permission to the board.
   *
   * @param username
   * @return true if the user has at least read permission to the board, false
   *         otherwise
   */
  public boolean participates(Username username) {
    if (this.owner().username().equals(username))
      return true;

    return permissions.stream().anyMatch(p -> p.user().username().equals(username));
  }

  public boolean isArchived() {
    return this.archived != null;
  }

  public void toggleArchive() {
    if (!isArchived())
      this.archived = new Archived(Calendar.getInstance());
    else
      this.archived = null;
  }
}
