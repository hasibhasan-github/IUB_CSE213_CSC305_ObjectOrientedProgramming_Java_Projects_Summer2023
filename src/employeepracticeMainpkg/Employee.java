/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeepracticeMainpkg;

import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public class Employee {
    private int id;
    private String name;
    private float salary;
    private LocalDate birth;
    private LocalDate joining;
    private String designation;
    private String department;
    private String gender;

    public Employee(int id, String name, float salary, LocalDate birth, LocalDate joining, String designation, String department, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birth = birth;
        this.joining = joining;
        this.designation = designation;
        this.department = department;
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID:=" + id + ", Name:" + name + ", Gender:" + gender + ", Dept:"+department + ", Sal:"+salary + ", Desig:"+designation + ", Dob:"+ birth+ ", Doj"+joining + "\n";
    }
    
    public String toStringM(){
        String Hasib = "Name: " + name + "\n";
        Hasib += "ID: " + id + "\n" + "Department: " + department + "\n";
        return Hasib;
    }
    
}
