/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import javafx.scene.control.Alert;

/**
 *
 * @author Hasib
 */
public class GenerateAlertsClass {
    public static void successfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information alert");
            alert.setContentText("You have just added a new "+ str + ".");
            alert.showAndWait();
    }
    public static void unsuccessfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information alert");
            alert.setContentText("Failed to add new "+ str + ".");
            alert.showAndWait(); 
    }
}
