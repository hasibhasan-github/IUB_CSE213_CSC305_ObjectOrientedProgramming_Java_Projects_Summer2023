/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logintestapplicationMainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;

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

    private boolean isValidEmail(String email) {
        String emailPattern = "^(.+)@iub\\.edu\\.bd$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    
    //private void useremailTextfieldOnValidation(ActionEvent event) {

    //}

    @FXML
    private void loginButtonOnClick(ActionEvent event) {

    }

    @FXML
    private void passwordFieldOnValidation(ActionEvent event) {
    }

    @FXML
    private void useremailTextfieldOnValidation(DragEvent event) {
        String email = useremailTextfield.getText().trim();
        System.out.println(isValidEmail(email));
        if (isValidEmail(email)) {
            lblEmailError.setVisible(false);
            useremailTextfield.setStyle("-fx-border-color: transparent;");
        } else {
            lblEmailError.setText("Invalid Email");
            lblEmailError.setVisible(true);
            useremailTextfield.setStyle("-fx-border-color: red;");
        }
    }



    @FXML
    private void hasib(TouchEvent event) {
         System.out.println("Hasib");
    }

    @FXML
    private void hasib2(TouchEvent event) {
        System.out.println("Hasib");
    }
    
}
