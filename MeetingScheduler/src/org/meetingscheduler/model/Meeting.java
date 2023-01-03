package org.meetingscheduler.model;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Meeting {

    private String meetingId;
    private Interval interval;

    // This particular meeting is for which Room
    private MeetingRoom meetingRoom;
    private List<Attendee> attendeeList;

    // Person who booked the meeting
    private Host host;
    private String subJect;
    private org.meetingscheduler.service.NotificationService NotificationService;

    public Meeting(Interval interval, MeetingRoom meetingRoom, Host host, String subJect) {
        this.meetingId = UUID.randomUUID().toString();
        this.interval = interval;
        this.meetingRoom = meetingRoom;
        this.attendeeList = new ArrayList<>();
        this.host = host;
        this.subJect = subJect;
    }
}
