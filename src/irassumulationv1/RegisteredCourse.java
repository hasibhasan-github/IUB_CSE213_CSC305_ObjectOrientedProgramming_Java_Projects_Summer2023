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
public class RegisteredCourse implements Serializable {
    private int courseid, sec;
    private String semester, coursetitle;

    public RegisteredCourse(int courseid, int sec, String semester, String coursetitle) {
        this.courseid = courseid;
        this.sec = sec;
        this.semester = semester;
        this.coursetitle = coursetitle;
    }

    @Override
    public String toString() {
        return "RegisteredCourse{" + "courseid=" + courseid + ", sec=" + sec + ", semester=" + semester + ", coursetitle=" + coursetitle + '}';
    }
    
}
