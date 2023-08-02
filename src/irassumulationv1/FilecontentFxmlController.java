/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package irassumulationv1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class FilecontentFxmlController implements Initializable {

    @FXML
    private TextArea filereadTextArea;
    
    private ArrayList<OfferedCourseClass> loadoffercourse;
    private ArrayList<CourseClass> coursearray;
    private ArrayList<Facultyclass> facultyarray;
    private ArrayList<RegisteredCourse> regcourse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void facultybnfilereadbtn(ActionEvent event) {
        filereadTextArea.clear();
        facultyarray = (ArrayList<Facultyclass>) ObjectReadingWritingClass.readObjectToFile("Faculty.bin", true);
        for ( Facultyclass y : facultyarray ){
            filereadTextArea.appendText(y.toString()+"\n");
        }
    }

    @FXML
    private void coursebinreadfilebtn(ActionEvent event) {
        filereadTextArea.clear();
        coursearray = (ArrayList<CourseClass>) ObjectReadingWritingClass.readObjectToFile("Course.bin", false);
        for ( CourseClass x : coursearray ){
            filereadTextArea.appendText(x.toString()+"\n");
        }
    }

    @FXML
    private void offercoursefilebtn(ActionEvent event) {
        filereadTextArea.clear();
        loadoffercourse = (ArrayList<OfferedCourseClass>) ObjectReadingWritingClass.readObjectToFile("OfferedCourse.bin", false);
        for (OfferedCourseClass z : loadoffercourse){
            filereadTextArea.appendText(z.toString()+"\n");
        }
    }

    @FXML
    private void registeredcoursebinfilebtn(ActionEvent event) {
        filereadTextArea.clear();
        regcourse = (ArrayList<RegisteredCourse>) ObjectReadingWritingClass.readObjectToFile("RegisteredCourse.bin", true);
        for ( RegisteredCourse xyz : regcourse ){
            filereadTextArea.appendText(xyz.toString()+"\n");
        }
    }
    
}
