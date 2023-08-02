/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public class Facultyclass extends user implements Serializable {
    private Float salary;
    private LocalDate dob;
    private String dept, desig;

    public Facultyclass(int id, String name, Float salary, LocalDate dob, LocalDate doj, String dept, String desig) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
        this.doj = doj;
        this.dept = dept;
        this.desig = desig;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Facultyclass{" + " Id=" + id + ", name=" + name  + " salary=" + salary + ", doj" + doj + ", dob=" + dob + ", dept=" + dept + ", desig=" + desig + '}';
    }
    
}
