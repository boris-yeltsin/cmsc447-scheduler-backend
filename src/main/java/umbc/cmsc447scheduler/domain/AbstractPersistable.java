package umbc.cmsc447scheduler.domain;
 
import java.io.Serializable;
 
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.api.domain.lookup.PlanningId;
 
public class AbstractPersistable implements Serializable, Comparable<AbstractPersistable> {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected Long id;
 
    protected AbstractPersistable() {
    }
 
    protected AbstractPersistable(long id) {
        this.id = id;
    }
 
    @PlanningId
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    @Override
    public int compareTo(AbstractPersistable other) {
        return new CompareToBuilder().append(getClass().getName(), other.getClass().getName()).append(id, other.id)
                .toComparison();
    }
 
    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }

	
}