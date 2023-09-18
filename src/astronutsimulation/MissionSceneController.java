/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package astronutsimulation;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class MissionSceneController implements Initializable {

    @FXML
    private TextField missionNameTxtField;
    @FXML
    private TextField missionCostTxtField;
    @FXML
    private ComboBox<Integer> teamSizeComboBox;
    @FXML
    private ComboBox<String> missionDurationComboBox;
    @FXML
    private ComboBox<Integer> astronutIDComboBox;
    @FXML
    private TextArea teamDetailsTxtArea;
    @FXML
    private ComboBox<Integer> leaderIdComboBox;
    @FXML
    private ComboBox<String> destinationComboBox;
    
    private ObservableList<Astronut> AstronutList;
    @FXML
    private TextField astronutNameTxtField;
    
    private int teamSize;
    
    private ArrayList<String> astronutIdList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        astronutIdList = new ArrayList<String>();
        teamSize = 0;
        Astronut dummyAstronut = new Astronut(0, 0, "", LocalDate.of(2000, 10, 10));
        AstronutList  = (ObservableList<Astronut>) DataReadWrite.readObjectToFile("Astronut.bin", dummyAstronut);
        for ( Astronut data : AstronutList ){
            astronutIDComboBox.getItems().add(data.getId());
            leaderIdComboBox.getItems().add(data.getId());
        }
        destinationComboBox.getItems().addAll("Mars", "Moon", "Neptune");
        teamSizeComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        missionDurationComboBox.getItems().addAll("1 year", "2 year", "3 year", "4 year",
                "5 year", "6 year", "7 year", "8 year", "9 year", "10 year");
    
    }    

    @FXML
    private void addTeamMemberButtonOnClick(ActionEvent event) {
        try{
            if ( teamSize == 0  ){ 
                throw new RuntimeException("");
            }
            else{
                astronutIdList.add(String.valueOf(astronutIDComboBox.getValue()));
                teamDetailsTxtArea.appendText("Member added: " + String.valueOf(astronutIDComboBox.getValue()) + "\n");
                teamSize--;
            }       
        }
        catch (RuntimeException ee){
            GenerateAlerts.unsuccessfulAlert("Team size full or Zero.");
        }
    }

    @FXML
    private void addNewMissionButtonOnClick(ActionEvent event) {
        try{
            Mission newmission = new Mission (missionNameTxtField.getText(), destinationComboBox.getValue(), missionDurationComboBox.getValue(),
                    leaderIdComboBox.getValue(), Integer.parseInt(missionCostTxtField.getText()), astronutIdList);
            if ( GenerateAlerts.confirmationAlert() ){
                newmission.addNewMission(newmission);
                astronutIdList.clear();
                teamDetailsTxtArea.clear();
                missionNameTxtField.clear();
                missionCostTxtField.clear();
                teamSizeComboBox.setValue(0);
                missionDurationComboBox.setValue(null);
                destinationComboBox.setValue(null);
            }
            
        }
        catch ( Exception e ){
            GenerateAlerts.unsuccessfulAlert("Please select all the fields and fill it.");
        }
    }

    @FXML
    private void astronutIdOnAction(ActionEvent event) {
        for ( Astronut data : AstronutList ){
            if ( data.getId() == astronutIDComboBox.getValue() ){
                astronutNameTxtField.setText(data.getName());
                
            }
        }
    }

    @FXML
    private void teamSizeOnAction(ActionEvent event) {
        teamSize = teamSizeComboBox.getValue();
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addAstronutScene.fxml"));
        
        Parent root = loader.load();
        
        //DetailsController detailcont = loader.getController();
        
        //detailcont.detailss(k);
        
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stage.setScene(scene);
        stage.show();
    }
    
}
