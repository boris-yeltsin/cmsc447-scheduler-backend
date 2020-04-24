package umbc.cmsc447scheduler.rest;

public class ScheduledClass extends Class {
    private final String classroom;

    public ScheduledClass(
        String subject, String course, String course_title, String ver,
        String sec, String instructor_real_name, String time, String classroom,
        int capacity
    ) {
        super(subject, course, course_title, ver, sec, instructor_real_name, time, capacity);
        this.classroom = classroom;
    }

    public String getClassroom() {
        return this.classroom;
    }
}