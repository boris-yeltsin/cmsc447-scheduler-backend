package umbc.cmsc447scheduler.domain;

import java.util.Comparator;

public class Room extends AbstractPersistable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int capacity;
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    // sort room by capacity
    public static Comparator<Room> roomsizeComparator = new Comparator<Room>() {

    	public int compare(Room r1, Room r2) {
    	   int room1 = r1.getCapacity();
    	   int room2 = r2.getCapacity();

    	   //ascending order
    	   return room2-room1;
    	   
    	   }};

    public Room(int id, String name, int capacity) {
        super(id);
        this.capacity = capacity;
        this.name = name;
    }
}