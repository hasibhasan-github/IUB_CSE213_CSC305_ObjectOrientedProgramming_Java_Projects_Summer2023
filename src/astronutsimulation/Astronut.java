/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronutsimulation;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public class Astronut implements Serializable {
    private int id, yearsOfExperience;
    private String name;
    private LocalDate dob;

    public Astronut(int id, int yearsOfExperience, String name, LocalDate dob) {
        this.id = id;
        this.yearsOfExperience = yearsOfExperience;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }
    
    public static void addAnewAstronutToFile(String fileName, Astronut instance){
        DataReadWrite.writeObjectToFile(fileName, instance);
        GenerateAlerts.successfulAlert("Astronut added successfully.");
    }
    
}
