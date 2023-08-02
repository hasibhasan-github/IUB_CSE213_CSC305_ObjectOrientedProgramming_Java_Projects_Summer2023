/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

/**
 *
 * @author Hasib
 */
public class HoDClass {
    public static Boolean addNewOfferedCourse( int facultyid, int capacity, int enrolled, int section, String room, String semester, String days, String time, int courseId, int noOfCredits, String courseTitle, String courseType, String courseCategory){
        OfferedCourseClass offercourse = new OfferedCourseClass( facultyid, capacity, enrolled, section, room,  semester,  days, time,  courseId, noOfCredits, courseTitle, courseType, courseCategory);
        Boolean result = ObjectReadingWritingClass.writeObjectToFile("OfferedCourse.bin", offercourse);
        return result;    
        
    }
}
