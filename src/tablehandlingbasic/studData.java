/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablehandlingbasic;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hasib
 */
public class studData {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleFloatProperty cgpa;

    public studData(int id, String name, float cgpa) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.cgpa =new SimpleFloatProperty(cgpa);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public float getCgpa() {
        return cgpa.get();
    }

    public void setCgpa(float cgpa) {
        this.cgpa = new SimpleFloatProperty(cgpa);
    }
    

    

    
}
