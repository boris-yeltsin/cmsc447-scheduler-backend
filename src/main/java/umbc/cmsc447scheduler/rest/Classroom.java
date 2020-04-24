package umbc.cmsc447scheduler.rest;

public class Classroom {
    private final String classroom;
    private final int capacity;

    public Classroom(
        String classroom, int capacity
    ) {
        this.classroom = classroom;
        this.capacity = capacity;
    }

    public String getClassroom() {
        return classroom;
    }

    public int getCapacity() {
        return capacity;
    }
}