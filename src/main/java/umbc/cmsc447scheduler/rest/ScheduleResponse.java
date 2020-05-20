package umbc.cmsc447scheduler.rest;

import java.util.Collection;
import java.util.Map;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.constraint.ConstraintMatchTotal;
import org.optaplanner.core.api.score.constraint.Indictment;

public class ScheduleResponse {
    private final ScheduledClass[] schedule;
    private final HardSoftScore score;
    private final Collection<ConstraintMatchTotal> constraintMatchTotals;
    private final Map<Object, Indictment> indictmentMap;

    public ScheduleResponse(
        ScheduledClass[] schedule,
        HardSoftScore score,
        Collection<ConstraintMatchTotal> constraintMatchTotals,
        Map<Object, Indictment> indictmentMap
    ) {
        this.schedule = schedule;
        this.score = score;
        this.constraintMatchTotals = constraintMatchTotals;
        this.indictmentMap = indictmentMap;
    }

    public ScheduledClass[] getSchedule() {
        return this.schedule;
    }

    public HardSoftScore getScore() {
        return this.score;
    }

    public Collection<ConstraintMatchTotal> getConstraintMatchTotals() {
        return this.constraintMatchTotals;
    }

    public Map<Object, Indictment> getIndictmentMap() {
        return this.indictmentMap;
    }
}
