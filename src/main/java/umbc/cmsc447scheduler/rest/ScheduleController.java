package umbc.cmsc447scheduler.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ScheduleController {
    @PostMapping(path = "/schedule", consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*")
    public ScheduledClass[] getSchedule(@RequestBody SchedulerInput input) {
        return getExampleSchedule();
    }

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