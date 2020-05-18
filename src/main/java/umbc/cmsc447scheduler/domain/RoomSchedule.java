package umbc.cmsc447scheduler.domain;
 
import java.util.List;
 
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
 
@PlanningSolution
public class RoomSchedule extends AbstractPersistable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private HardSoftScore score;
    
    private List<Room> roomlist;
    private List<Course> courselist;
    
    // score 
    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }
    public void setScore(HardSoftScore score) {
        this.score = score;
    }
    
    // room schedule
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "roomRange")
    public List<Room> getRoomList() {
        return roomlist;
    }
    
    public void setRoomList(List<Room> roomlist) {
        this.roomlist = roomlist;
    }
    
    // course schedule
    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "courseRange")
    public List<Course> getCourseList() {
        return courselist;
    }
    public void setCourseList(List<Course> courselist) {
        this.courselist = courselist;
    }
    public RoomSchedule(List<Room> roomlist, List<Course> courselist ) {
        //super(0);
        this.roomlist = roomlist;
        this.courselist = courselist;
    }
    
    public RoomSchedule(){}
}