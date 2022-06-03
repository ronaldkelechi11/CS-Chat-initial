package com.bms.cs.classes;

public class TimeTableItem {
    
    String Date,Time,Course,Venue;

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getCourse() {
        return Course;
    }

    public String getVenue() {
        return Venue;
    }



public TimeTableItem(String date, String time, String course, String venue) {
        Date = date;
        Time = time;
        Course = course;
        Venue = venue;
    }



}
