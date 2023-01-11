package org.meetingscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.user.Host;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MeetingRoom {
    private String roomName;

    // Every Meeting Room has its own Calendar
    private Calendar calendar;
    private List<Interval> bookedIntervals;

    public MeetingRoom(String roomName){
        this.roomName = roomName;
        calendar = new Calendar();
        bookedIntervals = new ArrayList<>();
    }
    public boolean isAvailable(Interval interval){
        return calendar.checkAvailabilty(this,interval);
    }

    public Meeting scheduleMeeting(String subject,Host host, Interval interval){
        return calendar.scheduleMeeting(this,interval, subject, host);
    }
}
