/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tablehandlingbasic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class TablehandlingfirstpageController implements Initializable {

    @FXML
    private TableView<studData> studentDetails;
    @FXML
    private TableColumn<studData, Integer> idcol;
    @FXML
    private TableColumn<studData, String> namecol;
    @FXML
    private TableColumn<studData, Float> cgpacol;
    @FXML
    private TextField nametxtField;
    @FXML
    private TextField idtxtField;
    @FXML
    private TextField cgpatxtField;
    
    private ObservableList<studData> studTableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idcol.setCellValueFactory(new PropertyValueFactory<studData, Integer>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<studData, String>("name"));
        cgpacol.setCellValueFactory(new PropertyValueFactory<studData, Float>("cgpa"));
        
        //studentDetails.setItems(getStudent());
        
    }  
    
    public ObservableList<studData> getStudent(){
        ObservableList<studData> tmp = FXCollections.observableArrayList();
        
        tmp.add (new studData(222, "Hasib", (float) 2.54));
        tmp.add (new studData(221, "Rashed", (float) 3.54));
        
        return tmp;
    }

    @FXML
    private void adddatatotablebtnOnClick(ActionEvent event) {
        studData std = new studData (Integer.parseInt(idtxtField.getText()), 
                                        nametxtField.getText(), 
                                        Float.parseFloat(cgpatxtField.getText()));
        // studTableList.add(std);
        studentDetails.getItems().add(std);
        idtxtField.clear();
        nametxtField.clear();
        cgpatxtField.clear();
    }
    
}
