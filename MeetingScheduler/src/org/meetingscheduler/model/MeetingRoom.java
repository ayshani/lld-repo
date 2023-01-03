package org.meetingscheduler.model;

import lombok.AllArgsConstructor;
import org.meetingscheduler.model.user.Host;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class MeetingRoom {
    private String roomName;

    // Every Meeting Room has its own Calendar
    private Calendar calendar;
    private List<Interval> bookedIntervals;

    public boolean isAvailable(Interval interval){
        return calendar.checkAvailabilty(this,interval);
    }

    public Meeting scheduleMeeting(String subject,Host host, Interval interval){
        return calendar.scheduleMeeting(this,interval, subject, host);
    }
}
