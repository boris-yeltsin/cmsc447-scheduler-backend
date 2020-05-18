package umbc.cmsc447scheduler.rest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import umbc.cmsc447scheduler.domain.Course;
import umbc.cmsc447scheduler.domain.Room;
import umbc.cmsc447scheduler.domain.RoomSchedule;

@RestController
class ScheduleController {
    @Autowired
    private SolverManager<RoomSchedule, UUID> solverManager;

    @PostMapping(path = "/schedule", consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*")
    public ScheduledClass[] getSchedule(@RequestBody SchedulerInput input) {
        UUID problemId = UUID.randomUUID();

        int numCourses = input.getClasses().length;
        int numClassrooms = input.getClassrooms().length;
        Course[] courses = new Course[input.getClasses().length];
        Room[] rooms = new Room[input.getClassrooms().length];
        for(int i = 0; i < numCourses; i++) {
            courses[i] = input.getClasses()[i].toOptaplannerType();
        }
        for(int i = 0; i < numClassrooms; i++) {
            rooms[i] = input.getClassrooms()[i].toOptaplannerType();
        }

        RoomSchedule problem = new RoomSchedule(Arrays.asList(rooms), Arrays.asList(courses));
        SolverJob<RoomSchedule, UUID> solverJob = solverManager.solve(problemId, problem);
        RoomSchedule solution;
        try {
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }

        List<Course> solutionCourseList = solution.getCourseList();
        int solutionCourseListSize = solutionCourseList.size();
        ScheduledClass[] schedule = new ScheduledClass[solutionCourseListSize];

        for(int i = 0; i < solutionCourseListSize; i++) {
            Course c = solutionCourseList.get(i);
            String time = "TODO";//Integer.toString(c.getTime());
            String section = Integer.toString(c.getSection());
            schedule[i] = new ScheduledClass(
                c.getSubject(),
                c.getCourse_num(),
                c.getCourseTitle(),
                c.getVer(),
                section,
                c.getInstructor(),
                time,
                c.getRoom().getName(),
                c.getCapacity()
            );
        }

        return schedule;
    }

    /*@PostMapping(path = "/schedule", consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*")
    public ScheduledClass[] getSchedule(@RequestBody SchedulerInput input) {
        return getExampleSchedule();
    }*/

    @GetMapping("/test_endpoint")
    @CrossOrigin(origins = "*")
	public ScheduledClass[] test_endpoint() {
        return getExampleSchedule();
    }
    
    private ScheduledClass[] getExampleSchedule() {
        ScheduledClass example_class1 = new ScheduledClass("CMSC", "104", "Problem Solving & Prog.", "", "1", "Staff", "tt530", "Public Policy 105", 40);
        ScheduledClass example_class2 = new ScheduledClass("CMSC", "201", "Computer Science I", "", "1", "Hamilton, Eric", "mw1", "Engineering 122", 40);
        ScheduledClass[] example_schedule = new ScheduledClass[2];
        example_schedule[0] = example_class1;
        example_schedule[1] = example_class2;
        return example_schedule;
    }
}