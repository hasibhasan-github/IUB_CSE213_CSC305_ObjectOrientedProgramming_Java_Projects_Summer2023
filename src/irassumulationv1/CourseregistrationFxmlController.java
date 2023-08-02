/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package irassumulationv1;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class CourseregistrationFxmlController implements Initializable {

    @FXML
    private ComboBox<Integer> courseidcombobox;
    @FXML
    private TextField coursetitleTextfield;
    @FXML
    private TextField secTextfield;
    @FXML
    private TextField semTextfield;
    @FXML
    private TextField studIdTxtfield;
    
    ArrayList<OfferedCourseClass> loadoffercourse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        loadoffercourse = (ArrayList<OfferedCourseClass>) ObjectReadingWritingClass.readObjectToFile("OfferedCourse.bin", false);
        
        for (OfferedCourseClass z : loadoffercourse){
            courseidcombobox.getItems().add(z.getCourseId());
        }
    }    

    @FXML
    private void courseidActionEvent(ActionEvent event) {
        for (OfferedCourseClass z : loadoffercourse){
            if ( courseidcombobox.getValue().equals(z.getCourseId()) ){
                coursetitleTextfield.setText(z.getCourseTitle());
                secTextfield.setText(String.valueOf(z.getSection()));
                semTextfield.setText(z.getSemester());
            }
        }
    }

    @FXML
    private void resgisterbutton(ActionEvent event) {
        Boolean result = StudentClass.registerCourse(courseidcombobox.getValue(), 
                                    coursetitleTextfield.getText(), 
                                    semTextfield.getText(), 
                                    Integer.parseInt(secTextfield.getText()));
        if (result){
            GenerateAlertsClass.successfulAlert("Registration");
        }
        else{
            GenerateAlertsClass.unsuccessfulAlert("Registration");
        }
        secTextfield.clear();
        semTextfield.clear();
        coursetitleTextfield.clear();
    }
    
}
