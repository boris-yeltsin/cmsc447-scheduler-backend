package umbc.cmsc447scheduler.rest;

public class SchedulerInput {
    private final Class[] classes;
    private final Classroom[] classrooms;

    public SchedulerInput(
        Class[] classes, Classroom[] classrooms
    ) {
        this.classes = classes;
        this.classrooms = classrooms;
    }

    public Class[] getClasses() {
        return classes;
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }
}