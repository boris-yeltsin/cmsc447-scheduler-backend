package umbc.cmsc447scheduler.rest;

public class ScheduledClass extends Class {
    private final String classroom;
    private final int classroom_capacity;
    private final boolean hard_constraint_violated;

    public ScheduledClass(
        String subject, String course, String course_title, String ver,
        String sec, String instructor_real_name, String time, String classroom,
        int capacity, int classroom_capacity, boolean hard_constraint_violated
    ) {
        super(subject, course, course_title, ver, sec, instructor_real_name, time, capacity);
        this.classroom = classroom;
        this.classroom_capacity = classroom_capacity;
        this.hard_constraint_violated = hard_constraint_violated;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public int getClassroom_capacity() {
        return this.classroom_capacity;
    }

    public boolean getHard_constraint_violated() {
        return this.hard_constraint_violated;
    }
}