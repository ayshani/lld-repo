package org.meetingscheduler.model.user;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.ResponseStatus;
import org.meetingscheduler.model.notification.Notificaton;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Attendee extends User {

    private Map<Meeting, ResponseStatus> meetingResponseStatusMap;
    public Attendee(String name, String email) {

        super(UUID.randomUUID().toString(),name, email);
        meetingResponseStatusMap = new HashMap<>();
    }

    public void responseInvitation(Meeting meeting, ResponseStatus responseStatus){
        // update meeting status in Attendee
        this.meetingResponseStatusMap.put(meeting,responseStatus);
        // update attendee response Status in meeting
        meeting.getAttendeeMap().put(this,responseStatus);
    }

    public void addMeeting(Meeting meeting,ResponseStatus responseStatus)
    {
        this.meetingResponseStatusMap.put(meeting,responseStatus);
    }
}
