/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */
public class CourseClass implements Serializable {
    private final int courseId, noOfCredits;
    private String courseTitle, courseType, courseCategory;

    public CourseClass(int courseId, int noOfCredits, String courseTitle, String courseType, String courseCategory) {
        this.courseId = courseId;
        this.noOfCredits = noOfCredits;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseCategory = courseCategory;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }
    
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    @Override
    public String toString() {
        return "CourseClass{" + "courseId=" + courseId + ", noOfCredits=" + noOfCredits + ", courseTitle=" + courseTitle + ", courseType=" + courseType + ", courseCategory=" + courseCategory + '}';
    }
    
            
    
}
