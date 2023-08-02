/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package irassumulationv1;

import java.net.URL;
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
public class AddnewapprovedcourseFxmlController implements Initializable {

    @FXML
    private TextField courseidtTextfield;
    @FXML
    private TextField courseTitleTextField;
    @FXML
    private ComboBox<Integer> creditscombobox;
    @FXML
    private ComboBox<String> coursecategorycombobox;
    @FXML
    private ComboBox<String> coursetypecombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        creditscombobox.getItems().addAll(1,3);
        coursecategorycombobox.getItems().addAll("Major", "Minor", "Foundation");
        coursetypecombobox.getItems().addAll("Theory", "Lab");
    }    

    @FXML
    private void addnewcoursebutton(ActionEvent event) {
        RegistrarClass registrar = new RegistrarClass();
        Boolean result = registrar.addNewCouse(Integer.parseInt(courseidtTextfield.getText()),
                              creditscombobox.getValue(),
                              courseTitleTextField.getText(),
                              coursetypecombobox.getValue(),
                              coursecategorycombobox.getValue());
        courseidtTextfield.clear();
        courseTitleTextField.clear();
        creditscombobox.setValue(null);
        coursetypecombobox.setValue(null);
        coursecategorycombobox.setValue(null);
        
        //System.out.println(result);
        if (result){
            GenerateAlertsClass.successfulAlert("Course");
        } 
        else{
            GenerateAlertsClass.unsuccessfulAlert("Course");
        }
    }
    
}
