/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filechooserandpdf;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */
public class student implements Serializable {
    private int id;
    private float cgpa;
    private String name;

    public student(int id, float cgpa, String name) {
        this.id = id;
        this.cgpa = cgpa;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", cgpa=" + cgpa + ", name=" + name + '}';
    }
    
}
