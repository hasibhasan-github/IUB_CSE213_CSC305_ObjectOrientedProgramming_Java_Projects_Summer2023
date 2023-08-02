/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package irassumulationv1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class DashboardFxmlController implements Initializable {

    @FXML
    private BorderPane borderPaneId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addNewApprovedCourseButtton(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addnewapprovedcourseFxml.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void addnewfacultyAdminButton(ActionEvent event) throws IOException {
        // 
        Parent parent = FXMLLoader.load(getClass().getResource("addnewfacultyadminFxml.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void registrationOfferCourseButton(ActionEvent event) throws IOException {
        // offeredcourseforregistrationFxml
        Parent parent = FXMLLoader.load(getClass().getResource("offeredcourseforregistrationFxml.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void courseRegistrationButton(ActionEvent event) throws IOException {
        // 
        Parent parent = FXMLLoader.load(getClass().getResource("courseregistrationFxml.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void fileContentButton(ActionEvent event) throws IOException {
        // 
        Parent parent = FXMLLoader.load(getClass().getResource("filecontentFxml.fxml"));
        borderPaneId.setCenter(parent);
    }
    
}
