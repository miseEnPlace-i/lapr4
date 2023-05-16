package eapli.ecourse.eventsmanagement.meetingmanagement.application;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import eapli.ecourse.eventsmanagement.meetingmanagement.domain.Meeting;
import eapli.ecourse.eventsmanagement.meetingmanagement.dto.MeetingDTO;
import eapli.ecourse.eventsmanagement.meetingmanagement.repositories.MeetingRepository;

public class MeetingService {
  private MeetingRepository meetingRepository;

  public MeetingService(MeetingRepository meetingRepository) {
    this.meetingRepository = meetingRepository;
  }

  public Iterable<MeetingDTO> allTeachers() {
    final Iterable<Meeting> types = meetingRepository.findAll();
    return convertToDto(types);
  }

  private Iterable<MeetingDTO> convertToDto(Iterable<Meeting> meetings) {
    return StreamSupport.stream(meetings.spliterator(), true)
        .map(Meeting::toDto)
        .collect(Collectors.toUnmodifiableList());

  }
}
