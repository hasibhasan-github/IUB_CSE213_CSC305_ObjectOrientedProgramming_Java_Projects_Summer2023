/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package irassumulationv1;

import irassumulationv1.CITSAdminClass;
import irassumulationv1.Facultyclass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class AddnewfacultyadminFxmlController implements Initializable {

    @FXML
    private TextField facultyid;
    @FXML
    private TextField facultyname;
    @FXML
    private DatePicker dateofbirth;
    @FXML
    private DatePicker dateofjoin;
    @FXML
    private ComboBox<String> designation;
    @FXML
    private ComboBox<String> department;
    @FXML
    private TextField salary;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        designation.getItems().addAll("Adjunct Lecturer",
                                        "Junior Lecturer",
                                        "Senior Lecturer",
                                        "Lecturer",
                                        "Assistant Professor",
                                        "Professor");
    department.getItems().addAll("CSE",
                                "EEE",
                                "Physics",
                                "Math",
                                "Social Science",
                                "Economics",
                                "English",
                                "BBA");
    }    


    @FXML
    private void addnewfacultybutton(ActionEvent event) {
        CITSAdminClass CITSAdminClass = new CITSAdminClass();
        Boolean response = CITSAdminClass.addNewFaculty(Integer.parseInt(facultyid.getText()), 
                                    facultyname.getText(), 
                                    Float.valueOf(salary.getText()),
                                    dateofbirth.getValue(), 
                                    dateofjoin.getValue(), 
                                    department.getValue(), 
                                    designation.getValue());
        //System.out.println(response);
        facultyid.clear();
        facultyname.clear();
        salary.clear();
        dateofbirth.setValue(null);
        dateofjoin.setValue(null);
        designation.setValue(null);
        department.setValue(null); 
        if (response){
            GenerateAlertsClass.successfulAlert("Faculty");
        }
        else{
            GenerateAlertsClass.unsuccessfulAlert("Faculty");
        }
    }

    /*@FXML
    private void readfile(ActionEvent event) {
        //Facultyclass f;
        //Boolean x = ObjectReadingWritingClass.readObjectToFile("Course.bin", false);
        File f = null;
        FileInputStream fw = null;
        ObjectInputStream ois = null;  
        try {
            CourseClass fc;
            f = new File("Course.bin");
            fw = new FileInputStream(f);
            ois = new ObjectInputStream(fw);
            try{
                while (true){
                    fc = (CourseClass)ois.readObject();
                    System.out.println(fc.toString());
                }
            }
            catch(Exception e){
                //System.out.println("Hasib");
            }
            //ois.close();
        }
        catch (IOException ex){
            //ex.printStackTrace();
            //System.out.println("Hasib2");
            
        }
        finally{
            try {
                if ( ois != null ){
                    ois.close();
                }
            }
            catch(IOException ex){
                
            }
        }
    } */
 } 


