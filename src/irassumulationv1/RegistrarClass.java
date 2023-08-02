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
public class RegistrarClass extends user implements Serializable {
    public static Boolean addNewCouse(int courseId, int noOfCredits, String courseTitle, String courseType, String courseCategory){
        CourseClass course = new CourseClass( courseId, noOfCredits, courseTitle, courseType, courseCategory);
        
        Boolean result = ObjectReadingWritingClass.writeObjectToFile("Course.bin", course);
        return result;
    }
    
}
