/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package filechooserandpdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class FileChooserAndPDFController implements Initializable {

    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField idTxtField;
    @FXML
    private TextField cgpaTxtField;
    
    private ArrayList<String> fileTypeList;
    @FXML
    private BorderPane borderPaneId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.bin");
    }    

    @FXML
    private void openBinaryFileMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Fileread.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void writeDataToFileOnButtonClick(ActionEvent event) throws FileNotFoundException, IOException {
        student st = new student(Integer.parseInt(idTxtField.getText()), Float.parseFloat(cgpaTxtField.getText()),
                            nameTxtField.getText());
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Binary File", fileTypeList));
        File f = fc.showSaveDialog(null);
        //System.out.println("Content will be written in: "+f.getAbsolutePath());
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            if (f.exists() ){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try{
                oos.writeObject(st);
                oos.close();
            }
            catch(Exception e){
                System.out.println("Exception");
            }
            finally {
                try{
                    if ( oos != null){
                        oos.close();
                    }
                }
                catch (IOException ex){
                    System.out.println("Exception Finally");
                }
            } 
    idTxtField.clear();
    nameTxtField.clear();
    cgpaTxtField.clear();
    }

    @FXML
    private void dataWriteSceneMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("fileChooserAndPDF.fxml"));
        borderPaneId.setCenter(parent);
    }
    
}
