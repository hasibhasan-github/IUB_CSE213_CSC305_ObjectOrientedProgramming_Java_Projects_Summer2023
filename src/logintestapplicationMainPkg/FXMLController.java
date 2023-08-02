/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logintestapplicationMainPkg;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Label lblpassworderror;
    
    private Map <String, String> emailPasswordContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emailPasswordContainer = new HashMap<String, String>();
        
        emailPasswordContainer.put("2220166@iub.edu.bd", "2220166@Iub");
        emailPasswordContainer.put("2221793@iub.edu.bd", "2221793@Iub");
        emailPasswordContainer.put("2111261@iub.edu.bd", "2111261@Iub");
    }    

    private boolean isValidEmail(String email) {
        String emailPattern = "^(.+)@iub\\.edu\\.bd$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private boolean isValidPassword(String password){
        String passPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(passPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    @FXML
    private void ValidationProcess(MouseEvent event) {
        String email = useremailTextfield.getText().trim();
        String pass = passwordField.getText();
        if (isValidEmail(email)) {
            lblEmailError.setVisible(false);
            useremailTextfield.setStyle("-fx-border-color: transparent;");
        } else {
            lblEmailError.setText("Invalid Email");
            lblEmailError.setVisible(true);
            useremailTextfield.setStyle("-fx-border-color: red;");
        }
        if ( isValidPassword(pass) ){
            lblpassworderror.setVisible(false);
            passwordField.setStyle("-fx-border-color: transparent");
        }
        else{
            lblpassworderror.setText("*Password must content" + "\n" +
                                    "*One Lowercase letter" + "\n" + 
                                    "*One Uppercase letter" + "\n" +
                                    "*One digit" + "\n" +
                                    "*One special character");
            lblpassworderror.setVisible(true);
            passwordField.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    private void LoginButtonOnClick(ActionEvent event) {
        String email = useremailTextfield.getText().trim();
        String pass = passwordField.getText();
        boolean done = true;
        
        if ( isValidEmail(email) && isValidPassword(pass) ){
            for (Map.Entry<String, String> tmp : emailPasswordContainer.entrySet()){
                if ( email.equals(tmp.getKey()) && pass.equals(tmp.getValue()) ){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful Attempt");
                    alert.setHeaderText("Login Successful");
                    alert.setContentText("Welcome back to your account.");
                    alert.showAndWait();
                    done = false;
                    break;
                }
            }
        }
        if (done){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Login Attempt Failed.");
        alert.setContentText("Invalid Email & Password Combination.");
        alert.showAndWait();
        }
    }

    @FXML
    private void usernameTextFieldOnAction(KeyEvent event) {
        lblEmailError.setVisible(false);
        useremailTextfield.setStyle("-fx-border-color: transparent;");
    }

    @FXML
    private void passwordTextFieldOnAction(KeyEvent event) {
            lblpassworderror.setVisible(false);
            passwordField.setStyle("-fx-border-color: transparent;");
    }
    
}
