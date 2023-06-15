package eapli.ecourse.postitmanagement.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.ecourse.boardmanagement.domain.Board;
import eapli.ecourse.postitmanagement.domain.PostItState.State;
import eapli.ecourse.postitmanagement.dto.PostItDTO;
import eapli.ecourse.usermanagement.dto.UserDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

@Entity
public class PostIt implements AggregateRoot<PostItID> {

  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @EmbeddedId
  private PostItID id;

  @Column(nullable = false)
  private PostItTitle title;

  @Column(nullable = false)
  private Coordinates coordinates;

  @Column(nullable = false)
  private PostItState state;

  @Column(nullable = false)
  private Calendar createdAt;

  @Column(nullable = false)
  private boolean isLatest;

  @Column(nullable = true)
  private PostItDescription description;

  @Lob
  @Column(nullable = true)
  private PostItImage image;

  /**
   * cascade = CascadeType.NONE as the board is part of another aggregate
   */
  @XmlElement
  @JsonProperty
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  private Board board;

  /**
   * cascade = CascadeType.NONE as the user is part of another aggregate
   */
  @XmlElement
  @JsonProperty
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  private SystemUser owner;

  /**
   * cascade = CascadeType.NONE as the user is part of another aggregate
   */
  @XmlElement
  @JsonProperty
  @OneToOne(optional = true, cascade = CascadeType.ALL)
  private PostIt previous;

  protected PostIt() {
    // for ORM
  }

  public PostIt(final PostItTitle title, final Coordinates coordinates, final Board board,
      final SystemUser owner) {
    Preconditions.noneNull(title, coordinates, board, owner);

    this.id = PostItID.newID();
    this.title = title;
    this.coordinates = coordinates;
    this.state = new PostItState();
    this.board = board;
    this.owner = owner;
    this.createdAt = Calendar.getInstance();
    this.previous = null;
    this.isLatest = true;
    this.description = null;
    this.image = null;
  }

  public PostIt(final PostItTitle title, final Coordinates coordinates, final Board board,
      final SystemUser owner, final PostItDescription description, final PostItImage image) {
    Preconditions.noneNull(title, coordinates, board, owner);

    this.id = PostItID.newID();
    this.title = title;
    this.coordinates = coordinates;
    this.state = new PostItState();
    this.board = board;
    this.owner = owner;
    this.createdAt = Calendar.getInstance();
    this.previous = null;
    this.isLatest = true;
    this.description = description;
    this.image = image;
  }

  public PostIt(final PostItTitle title, final Coordinates coordinates, final Board board,
      final SystemUser owner, final PostItDescription description) {
    Preconditions.noneNull(title, coordinates, board, owner);

    this.id = PostItID.newID();
    this.title = title;
    this.coordinates = coordinates;
    this.state = new PostItState();
    this.board = board;
    this.owner = owner;
    this.createdAt = Calendar.getInstance();
    this.previous = null;
    this.isLatest = true;
    this.description = description;
    this.image = null;
  }

  public PostIt(final PostItTitle title, final Coordinates coordinates, final Board board,
      final SystemUser owner, final PostItImage image) {
    Preconditions.noneNull(title, coordinates, board, owner);

    this.id = PostItID.newID();
    this.title = title;
    this.coordinates = coordinates;
    this.state = new PostItState();
    this.board = board;
    this.owner = owner;
    this.createdAt = Calendar.getInstance();
    this.previous = null;
    this.isLatest = true;
    this.description = null;
    this.image = image;
  }

  // This constructor is used to create a new PostIt from an existing one
  private PostIt(final PostItTitle title, final Coordinates coordinates, final Board board,
      final SystemUser owner, final PostIt previous, final PostItDescription description, final PostItImage image) {
    Preconditions.noneNull(title, coordinates, board, owner);

    this.id = PostItID.newID();
    this.title = title;
    this.coordinates = coordinates;
    this.state = new PostItState();
    this.board = board;
    this.owner = owner;
    this.previous = previous;
    this.createdAt = Calendar.getInstance();
    this.isLatest = true;
    this.description = description;
    this.image = image;
  }

  public PostIt update(final PostItTitle t, final Coordinates c, final PostItDescription d,
      final PostItImage i) {
    Preconditions.noneNull(t, c);

    this.isLatest = false;

    return new PostIt(t, c, this.board, this.owner, this, d, i);
  }

  public SystemUser owner() {
    return this.owner;
  }

  public Board board() {
    return this.board;
  }

  public PostItTitle title() {
    return this.title;
  }

  public Coordinates coordinates() {
    return this.coordinates;
  }

  public PostItState state() {
    return this.state;
  }

  public PostIt previous() {
    return this.previous;
  }

  public Calendar createdAt() {
    return this.createdAt;
  }

  public boolean isLatest() {
    return this.isLatest();
  }

  public PostItDescription description() {
    return this.description;
  }

  public PostItImage image() {
    return this.image;
  }

  @Override
  public PostItID identity() {
    return this.id;
  }

  @Override
  public boolean equals(final Object other) {
    return DomainEntities.areEqual(this, other);
  }

  @Override
  public int hashCode() {
    return DomainEntities.hashCode(this);
  }

  @Override
  public boolean sameAs(final Object other) {
    if (!(other instanceof PostIt))
      return false;

    final PostIt that = (PostIt) other;
    if (this != that)
      return false;

    return this.owner.identity().equals(that.owner.identity())
        && this.board.identity().equals(that.board.identity()) && this.title.equals(that.title)
        && this.coordinates.equals(that.coordinates) && this.identity().equals(that.identity())
        && this.state.equals(that.state) && this.createdAt.equals(that.createdAt)
        && this.isLatest == that.isLatest && this.description.equals(that.description) && this.image.equals(that.image);
  }

  public void delete() {
    this.state = new PostItState(State.DELETED);
  }

  public void toggleIsLatest() {
    this.isLatest = !this.isLatest;
  }

  public boolean isActive() {
    return this.state.isActive();
  }

  public boolean isDeleted() {
    return this.state.isDeleted();
  }

  public PostItDTO toDto() {
    return new PostItDTO(this.id, this.title, this.coordinates, this.state, this.board.toDto(),
        UserDTO.from(this.owner), this.previous == null ? null : this.previous.toDto(),
        this.createdAt, this.isLatest, this.description, this.image);
  }
}
