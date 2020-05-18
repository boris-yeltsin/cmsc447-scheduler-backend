package umbc.cmsc447scheduler.rest;

import java.util.UUID;

import umbc.cmsc447scheduler.domain.Room;

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

    public Room toOptaplannerType() {
        return new Room(UUID.randomUUID().hashCode(), this.classroom, this.capacity);
    }
}