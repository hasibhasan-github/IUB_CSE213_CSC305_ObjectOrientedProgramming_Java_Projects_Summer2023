/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package astronutsimulation;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class LoadMissionTableController implements Initializable {

    @FXML
    private TableView<MissionDataTable> tableView;
    @FXML
    private TableColumn<MissionDataTable, String> missionNameColoumn;
    @FXML
    private TableColumn<MissionDataTable, ArrayList<String>> missionMemberListColoumn;
    @FXML
    private TableColumn<MissionDataTable, Integer> leaderIdColoumn;
    @FXML
    private TableColumn<MissionDataTable, Integer> missionCostColoumn;
    @FXML
    private ComboBox<String> destinationComboBox;
    @FXML
    private TableColumn<MissionDataTable, Integer> teamSizeColoumn;
    
    private  ObservableList<Mission> MissionList;
    
    private  ObservableList<MissionDataTable> MissionTableDataList;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              MissionTableDataList =      FXCollections.observableArrayList();
        missionNameColoumn.setCellValueFactory(new PropertyValueFactory<MissionDataTable, String>("missionName"));
        leaderIdColoumn.setCellValueFactory(new PropertyValueFactory<MissionDataTable, Integer>("leaderId"));
        missionCostColoumn.setCellValueFactory(new PropertyValueFactory<MissionDataTable, Integer>("cost"));
        teamSizeColoumn.setCellValueFactory(new PropertyValueFactory<MissionDataTable, Integer>("teamSize"));
        missionMemberListColoumn.setCellValueFactory(new PropertyValueFactory<MissionDataTable, ArrayList<String>>("memberofMission"));
        
        Mission dummyMission = new Mission("", "", "", 1, 1, new ArrayList<String>());
        MissionList = (ObservableList<Mission>) DataReadWrite.readObjectToFile("Mission.bin", dummyMission);
        
        for ( Mission datamsn : MissionList ){
            if ( destinationComboBox.getItems().contains(datamsn.getMissionDestination()) ) continue;
            else destinationComboBox.getItems().add(datamsn.getMissionDestination()); }
            //MissionTableDataList.add(new MissionDataTable (datamsn.getMissionName(), datamsn.getLeaderId(),
              //          datamsn.getCollectionOfAstronutId().size(), datamsn.getMissionCost(), datamsn.getCollectionOfAstronutId()) );
        
        
        //tableView.getItems().addAll(MissionTableDataList);
    }    

    @FXML
    private void destinationComboBoxOnAction(ActionEvent event) {
        tableView.getItems().clear();
         MissionTableDataList.clear();
         barChart.getData().clear();
        for ( Mission datamsn : MissionList ){
            if ( destinationComboBox.getValue().equals(datamsn.getMissionDestination()) ) {
            MissionTableDataList.add(new MissionDataTable (datamsn.getMissionName(), datamsn.getLeaderId(),
                        datamsn.getCollectionOfAstronutId().size(), datamsn.getMissionCost(), datamsn.getCollectionOfAstronutId()) );
            
            }
            }
        tableView.getItems().addAll(MissionTableDataList);
       
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        
        for ( MissionDataTable data : MissionTableDataList ){
            series.getData().add(new XYChart.Data<String,Number>(data.getMissionName(),data.getCost()));
        }
        series.setName(destinationComboBox.getValue());
        barChart.getData().add(series);
        
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
