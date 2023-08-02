/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logintestapplicationMainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField useremailTextfield;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label lblEmailError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void useremailTextfieldOnValidation(ActionEvent event) {
        String email = useremailTextfield.getText();
        
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void passwordFieldOnValidation(ActionEvent event) {
    }
    
}
