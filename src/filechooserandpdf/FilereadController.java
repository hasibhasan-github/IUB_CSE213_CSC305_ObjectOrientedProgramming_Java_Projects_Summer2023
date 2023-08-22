/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package filechooserandpdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class FilereadController implements Initializable {

    @FXML
    private TextArea binaryFileOutputTxtArea;
    
    private ArrayList<String> fileTypeList;

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
    private void openFileButtonOnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Binary File", fileTypeList));
        
        File f = fc.showOpenDialog(null);
        FileInputStream fis = null;  
        ObjectInputStream oos = null;  
        String ss = "";

        if ( f != null){
            try{
                fis = new FileInputStream(f); 
                oos = new ObjectInputStream(fis);
                student s;
                try{
                    while (true){
                        s = (student) oos.readObject();
                        ss += s.toString() + "\n";
                    }
                }
                catch (IOException e){
                    
                }
                
            }
            catch(Exception e){
                
            }
            finally{
                try{
                    if ( oos != null){
                        oos.close();
                    }
                }
                catch (IOException ex){
                    System.out.println("Exception Finally");
                }
        }
            binaryFileOutputTxtArea.appendText(ss);
        }
    }
    
}
