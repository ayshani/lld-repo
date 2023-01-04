package org.meetingscheduler.app;

import org.meetingscheduler.model.Interval;
import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.MeetingRoom;
import org.meetingscheduler.model.user.Host;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MeetingScheduler {

    private List<MeetingRoom> meetingRoomList;
    private Deque<Meeting> historyQueue;
    private static final int MAX_HISTORICAL_MEETING_STORAGE = 20;
    private static volatile MeetingScheduler meetingScheduler;

    private MeetingScheduler(){
        this.historyQueue = new ArrayDeque<>(MAX_HISTORICAL_MEETING_STORAGE);
        this.meetingRoomList =  new ArrayList<>();
    }

    public static MeetingScheduler getInstacne(){
        if(meetingScheduler == null){
            synchronized (MeetingScheduler.class){
                if(meetingScheduler == null){
                    meetingScheduler = new MeetingScheduler();
                }
            }
        }
        return meetingScheduler;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        this.meetingRoomList.add(meetingRoom);
    }

    public Meeting bookRoom(Interval interval, String subject, Host host){
        Meeting newMeeting = null;
        for(MeetingRoom meetingRoom : meetingRoomList){
            if(meetingRoom.isAvailable(interval)){
                newMeeting = meetingRoom.scheduleMeeting(subject, host,interval);
                saveToHistory(newMeeting);
                return newMeeting;
            }
        }
        return newMeeting;
    }

    private void saveToHistory(Meeting newMeeting) {
    }
}
