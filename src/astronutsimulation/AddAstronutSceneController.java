/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package astronutsimulation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class AddAstronutSceneController implements Initializable {

    @FXML
    private TextField astronutNameTxtField;
    @FXML
    private TextField astronutIDTxtField;
    @FXML
    private DatePicker astronutDateOfBirth;
    @FXML
    private TextField astronutYearsOfExperience;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addNewAstronutButtonOnClick(ActionEvent event) {
        try{
            if ( astronutDateOfBirth.getValue() == null ) throw new RuntimeException("Select Date of Birth");
            if ( astronutIDTxtField.getText().isEmpty() ) throw new RuntimeException(" Please add the Id");
            if ( astronutNameTxtField.getText().isEmpty() ) throw new RuntimeException(" Please add the Name");
            if ( astronutYearsOfExperience.getText().isEmpty() ) throw new RuntimeException(" Please add the Experience");
            Astronut newAstro = new Astronut(Integer.parseInt(astronutIDTxtField.getText()), 
                    Integer.parseInt(astronutYearsOfExperience.getText()), 
                       astronutNameTxtField.getText(), astronutDateOfBirth.getValue() );
            if (GenerateAlerts.confirmationAlert()){
            Astronut.addAnewAstronutToFile("Astronut.bin", newAstro);
            astronutIDTxtField.clear();
            astronutNameTxtField.clear();
            astronutYearsOfExperience.clear();
            astronutDateOfBirth.setValue(null);}
        }
        catch ( RuntimeException ex ){
            GenerateAlerts.unsuccessfulAlert(ex.toString());
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Please fill out all the Fields.");
        }
    }

    @FXML
    private void addNewMissionButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MissionScene.fxml"));
        
        Parent root = loader.load();
        
        //DetailsController detailcont = loader.getController();
        
        //detailcont.detailss(k);
        
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void missionDataTabeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loadMissionTable.fxml"));
        
        Parent root = loader.load();
        
        //DetailsController detailcont = loader.getController();
        
        //detailcont.detailss(k);
        
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stage.setScene(scene);
        stage.show();
    }
    
}
