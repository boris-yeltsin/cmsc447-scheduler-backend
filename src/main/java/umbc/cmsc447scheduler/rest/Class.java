package umbc.cmsc447scheduler.rest;

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
}