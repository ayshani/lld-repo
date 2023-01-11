package org.meetingscheduler.model;

import org.meetingscheduler.model.user.Host;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calendar {

    // Every Calendar belongs to particular Meeting Room
    private MeetingRoom meetingRoom;
    // Every Calendar is having List of Meetings
    private List<Meeting> meetingList;

    public Calendar() {
        this.meetingList = new ArrayList<>();
    }

    public boolean checkAvailabilty(MeetingRoom meetingRoom, Interval interval) {
        // Meeting (9 AM to 10:30 AM)
        // Meeting can't be schedule  10:00 - 11:00 AM                            8:00 to 9:15
        //Check for overlaps
        //Start Time of meeting interval is less than endTime of existing meeting
        // And Ent Time of meeting interval is greater than startTime of existing meeting then its a overlap
        //in that case return false
        for(Meeting meeting : meetingList){
            if(meeting.getInterval().getEndTime().compareTo(interval.getStartTime()) > 0 &&
               meeting.getInterval().getStartTime().compareTo(interval.getEndTime())<0){

                return false;
            }
        }

        return true;
    }

    public Meeting scheduleMeeting(MeetingRoom meetingRoom, Interval interval, String subject, Host host) {
        Meeting meeting = new Meeting(interval,meetingRoom,host,subject);
        meetingList.add(meeting);
        return meeting;
    }
}
