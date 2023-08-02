/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author Hasib
 */
public class OfferedCourseClass extends CourseClass implements Serializable {
    private final int facultyid;
    private int capacity, enrolled, section;
    private String room, semester, days;
    private String time;

    public OfferedCourseClass(int facultyid, int capacity, int enrolled, int section, String room, String semester, String days, String time, int courseId, int noOfCredits, String courseTitle, String courseType, String courseCategory) {
        super(courseId, noOfCredits, courseTitle, courseType, courseCategory);
        //this.courseid = courseid;
        this.facultyid = facultyid;
        this.capacity = capacity;
        this.enrolled = enrolled;
        this.section = section;
        this.room = room;
        this.semester = semester;
        this.days = days;
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OfferedCourseClass{" + ", facultyid=" + facultyid + ", capacity=" + capacity + ", enrolled=" + enrolled + ", section=" + section + ", room=" + room + ", semester=" + semester + ", days=" + days + ", time=" + time + '}';
    }

    
    
}
