package umbc.cmsc447scheduler.rest;

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
        int day = 1;
        int time = 1;
        Pattern pattern = Pattern.compile("^([a-zA-Z]+)(\\d+)$");
        Matcher m = pattern.matcher(this.time);
        if(m.find()) {
           day = getIntFromDayStr(m.group(1));
           time = Integer.parseInt(m.group(2));
        }
        int sec = Integer.parseInt(this.sec);
        return new Course(UUID.randomUUID().hashCode(), this.subject, this.course, this.course_title, sec, this.capacity, day, time, this.instructor_real_name, this.ver);
    }

    public static int getIntFromDayStr(String days) {
        days = days.toLowerCase();
        switch(days) {
            case "tt":
                return 1;
            case "mw":
                return 2;
            case "mwf":
                return 3;
            default:
                return 0;
        }
    }

    public static String getDayStrFromInt(int days) {
        switch(days) {
            case 1:
                return "tt";
            case 2:
                return "mw";
            case 3:
                return "mwf";
            default:
                return "";
        }
    }
}