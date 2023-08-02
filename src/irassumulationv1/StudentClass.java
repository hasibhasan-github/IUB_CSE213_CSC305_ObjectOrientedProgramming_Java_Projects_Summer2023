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
public class StudentClass extends user implements Serializable {
        
    public static Boolean registerCourse(int courseid, String coursetitle, String semester, int sec){
        RegisteredCourse regcourse = new RegisteredCourse( courseid, sec, semester, coursetitle);
        Boolean result = ObjectReadingWritingClass.writeObjectToFile("RegisteredCourse.bin", regcourse);
        return result;
    }
}
