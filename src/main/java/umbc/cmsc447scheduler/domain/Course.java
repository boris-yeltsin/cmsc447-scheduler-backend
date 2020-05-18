/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package umbc.cmsc447scheduler.domain;

import java.util.Comparator;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
 
@PlanningEntity
public class Course  extends AbstractPersistable{
 
	
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private String subject;
	private String course_num;
    private String coursetitle;
    private String instructor;
    private String ver;
    private int section;
    private int capacity;
    private int day;
    private int time;
    private Room room;
    
 // subject
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
   
 // course_num
    public String getCourse_num() {
        return course_num;
    }
 
    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }
    
// coursetitle
    public String getCourseTitle() {
        return coursetitle;
    }
 
    public void setCourseTitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

// instructor
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

// ver
public String getVer() {
    return ver;
}

public void setVer(String ver) {
    this.ver = ver;
}
 
// section
    public int getSection() {
        return section;
    }
 
    public void setSection(int section) {
        this.section = section;
    }
// capacity
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
   
// day
    public int getDay() {
        return day;
    }
 
    public void setDay(int day) {
        this.day = day;
    }
    
    
    // time
    public int getTime() {
        return time;
    }
 
    public void setTime(int time) {
        this.time = time;
    }
    
    public static Comparator<Course> timeComparator = new Comparator<Course>() {

    	public int compare(Course s1, Course s2) {
    	   int time1 = s1.getTime();
    	   int time2 = s2.getTime();

    	   //ascending order
    	   return time1-time2;
    	   
    	   }};
        

    @PlanningVariable(valueRangeProviderRefs={"roomRange"})
    public Room getRoom() {
        return room;
    }
 
    public void setRoom(Room room) {
        this.room = room;
    }
 
    public Course(){}
 
    public Course(int id, String subject, String course_num, String coursetitle, int section, int capacity, int day, int time, String instructor, String ver) {
        super(id);
        this.subject = subject;
        this.course_num = course_num;
        this.coursetitle = coursetitle;
        this.section = section;
        this.capacity = capacity;
        this.day = day;
        this.time = time;
        this.instructor = instructor;
        this.ver = ver;
        //this.day = day;
        //this.period = period;
    }
}