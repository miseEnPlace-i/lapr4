package eapli.ecourse.eventsmanagement.meetingmanagement.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import eapli.ecourse.eventsmanagement.domain.Duration;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.eventsmanagement.meetingmanagement.dto.MeetingDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

@Entity
public class Meeting implements AggregateRoot<MeetingID> {
  private static final long serialVersionUID = 1L;

  @Version
  private Long version;

  @Column(nullable = false)
  private Duration duration;

  @ManyToOne(optional = false)
  private SystemUser scheduledBy;

  @Column(nullable = true)
  private Canceled canceledAt;

  @Column(nullable = false)
  private Time time;

  @EmbeddedId
  private MeetingID id;

  protected Meeting() {
    // for ORM
  }

  public Meeting(final Time time, final Duration duration, SystemUser owner) {
    Preconditions.noneNull(time, duration, owner);

    this.id = MeetingID.newID();
    this.time = time;
    this.duration = duration;
    this.canceledAt = null;
    this.scheduledBy = owner;
  }

  public Meeting(MeetingID id, Time time, Duration duration, SystemUser user) {
    Preconditions.noneNull(id, time, duration, user);

    this.id = id;
    this.time = time;
    this.duration = duration;
    this.canceledAt = null;
    this.scheduledBy = user;
  }

  @Override
  public boolean equals(Object other) {
    return DomainEntities.areEqual(this, other);
  }

  @Override
  public boolean sameAs(final Object other) {
    if (!(other instanceof Meeting))
      return false;

    final Meeting that = (Meeting) other;

    if (this == that)
      return true;

    return time().equals(that.time()) && duration().equals(that.duration());
  }

  @Override
  public int hashCode() {
    return DomainEntities.hashCode(this);
  }

  public Time time() {
    return this.time;
  }

  public Duration duration() {
    return this.duration;
  }

  public Canceled canceledAt() {
    return this.canceledAt;
  }

  public void cancel() {
    this.canceledAt = Canceled.valueOf(Calendar.getInstance());
  }

  @Override
  public MeetingID identity() {
    return this.id;
  }

  public MeetingDTO toDto() {
    return new MeetingDTO(this.id, this.time, this.duration, this.scheduledBy, this.canceledAt);
  }

  public SystemUser scheduledBy() {
    return this.scheduledBy;
  }
}
