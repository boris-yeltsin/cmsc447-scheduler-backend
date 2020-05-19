package umbc.cmsc447scheduler.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import umbc.cmsc447scheduler.domain.Course;

public class Class {
    private final String subject;
    private final String course;
    private final String course_title;
    private final String ver;
    private final String sec;
    private final String instructor_real_name;
    private final String time;
    private final int capacity;

    public Class(
        String subject, String course, String course_title, String ver,
        String sec, String instructor_real_name, String time, int capacity
    ) {
        this.subject = subject;
        this.course = course;
        this.course_title = course_title;
        this.ver = ver;
        this.sec = sec;
        this.instructor_real_name = instructor_real_name;
        this.time = time;
        this.capacity = capacity;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourse() {
        return course;
    }

    public String getCourse_title() {
        return course_title;
    }

    public String getVer() {
        return ver;
    }

    public String getSec() {
        return sec;
    }

    public String getInstructor_real_name() {
        return instructor_real_name;
    }

    public String getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public Course toOptaplannerType() {
        List<Integer> day = new ArrayList<>();
        int time = 0;
        Pattern pattern = Pattern.compile("^(mwf|tt|mw)(\\d+)$");
        Matcher m = pattern.matcher(this.time.toLowerCase());
        if(m.find()) {
           day = getIntFromDayStr(m.group(1));
           time = formatTime(Integer.parseInt(m.group(2)));
        }
        int sec = Integer.parseInt(this.sec);
        return new Course(UUID.randomUUID().hashCode(), this.subject, this.course, this.course_title, sec, this.ver, this.instructor_real_name, this.capacity, day, time);
    }

    public static List<Integer> getIntFromDayStr(String days) {
        days = days.toLowerCase();
        switch(days) {
            case "tt":
                return new ArrayList<Integer>(Arrays.asList(2,4));
            case "mw":
                return new ArrayList<Integer>(Arrays.asList(1,3));
            case "mwf":
                return new ArrayList<Integer>(Arrays.asList(1,3,5));
            default: // should never be called since pattern only matches above cases
                return new ArrayList<Integer>(Arrays.asList(0));
        }
    }

    public static String getDayStrFromInt(List<Integer> day) {
        String days = "";
        for (int i = 0; i < day.size(); i++) {
            if (day.get(i) == 1)
                days = days + "Mo";
            else if (day.get(i) == 2)
                days = days + "Tu";
            else if (day.get(i) == 3)
                days = days + "We";
            else if (day.get(i) == 4)
                days = days + "Th";
            else if (day.get(i) == 5)
                days = days + "Fr";
            if (i != day.size()-1)
                days = days + " & ";
        }
        return days;
    }

    public static int formatTime(int time) {
        if (time < 100) {
            time = time*100;
            if (time < 1000)
                time = time + 1200; // set it to PM time, else it is AM
        }
        else {
            if (time < 1000)
                time = time + 1200;
        }
        return time;
    }
}