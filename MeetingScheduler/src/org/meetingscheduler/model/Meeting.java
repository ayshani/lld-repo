package org.meetingscheduler.model;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;

import java.util.*;

@Getter
@Setter
public class Meeting {

    private String meetingId;
    private Interval interval;

    // This particular meeting is for which Room
    private MeetingRoom meetingRoom;
    private Map<Attendee,ResponseStatus> attendeeMap;

    // Person who booked the meeting
    private Host host;
    private String subJect;
    private org.meetingscheduler.service.NotificationService NotificationService;

    public Meeting(Interval interval, MeetingRoom meetingRoom, Host host, String subJect) {
        this.meetingId = UUID.randomUUID().toString();
        this.interval = interval;
        this.meetingRoom = meetingRoom;
        this.attendeeMap = new HashMap<>();
        this.host = host;
        this.subJect = subJect;
    }

    public void addAttendees(Attendee attendee){
        this.attendeeMap.put(attendee,ResponseStatus.NO_RESPONSE);
    }

    public void addAttendees(List<Attendee> attendees){
        attendees.forEach(a -> this.attendeeMap.put(a,ResponseStatus.NO_RESPONSE));
    }

    public void invite(List<Attendee> attendees) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(meetingId, meeting.meetingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId);
    }
}
