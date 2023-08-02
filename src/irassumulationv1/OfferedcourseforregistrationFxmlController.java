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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class OfferedcourseforregistrationFxmlController implements Initializable {

    @FXML
    private ComboBox<Integer> courseidcombobox;
    @FXML
    private ComboBox<String> facultyidcombobox;
    private TextField coursetypeTextfield;
    @FXML
    private TextField roomTextField;
    @FXML
    private TextField categoryTextfield;
    @FXML
    private TextField titleTextfield;
    @FXML
    private TextField facnameTextfield;
    @FXML
    private ComboBox<Integer> sectioncbox;
    @FXML
    private ComboBox<String> semestercbox;
    @FXML
    private ComboBox<String> dayscbox;
    @FXML
    private ComboBox<Integer> capacitycbox;
    @FXML
    private TextField creditTextfield;
    @FXML
    private ComboBox<String> timebox;
    @FXML
    private RadioButton theoryradiobtn;
    @FXML
    private RadioButton labradiobtn;
    private ToggleGroup tg;
    private ArrayList<CourseClass> coursearray;
    private ArrayList<CourseClass> tempcoursearray;
    private ArrayList<Facultyclass> facultyarray;
    private ArrayList<Facultyclass> tmpfacultyarray;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg = new ToggleGroup();
        theoryradiobtn.setToggleGroup(tg);
        labradiobtn.setToggleGroup(tg);
        
        sectioncbox.getItems().addAll(1,2,3,4,5);
        semestercbox.getItems().addAll("Spring", "Summer", "Autumn");
        capacitycbox.getItems().addAll(20,30,40,50);
        dayscbox.getItems().addAll("Sunday-Tuesday", "Monday-Wednesday","Saturday-Thursday" );
        timebox.getItems().addAll("8:00-9:30", "9:40-11:10", "11:20-12:50", "13:00-14:30",
                                        "14:40-16:10", "16:20-17:50", "18:30-21:30");
        
        
        coursearray = (ArrayList<CourseClass>) ObjectReadingWritingClass.readObjectToFile("Course.bin", false);
        tempcoursearray = new ArrayList<CourseClass>();
        for ( CourseClass x : coursearray ){
            if ( x.getCourseType().equals("Theory") ){
                courseidcombobox.getItems().add(x.getCourseId());
            }
            tempcoursearray.add(x);
        }
        
        facultyarray = (ArrayList<Facultyclass>) ObjectReadingWritingClass.readObjectToFile("Faculty.bin", true);
        tmpfacultyarray = new ArrayList<Facultyclass>();
        for ( Facultyclass y : facultyarray ){
            facultyidcombobox.getItems().add(y.getName());
            tmpfacultyarray.add(y);
        }
    }    

    @FXML
    private void addnewofferedcoursebutton(ActionEvent event) {
        String coursetype;
        if ( theoryradiobtn.isSelected() ){
            coursetype = "Thoery";
        }
        else{
            coursetype = "Lab";
        }
        Boolean result  = HoDClass.addNewOfferedCourse(
                                    Integer.parseInt(facnameTextfield.getText()),
                                    capacitycbox.getValue(),
                                    0, sectioncbox.getValue(),
                                    roomTextField.getText(), 
                                    semestercbox.getValue(), 
                                    dayscbox.getValue(), 
                                    timebox.getValue(),
                                    courseidcombobox.getValue(),
                                    Integer.parseInt(creditTextfield.getText()), 
                                    titleTextfield.getText(), 
                                    coursetype, 
                                    categoryTextfield.getText());
        if (result){
            GenerateAlertsClass.successfulAlert("Offered Course");
        }
        else {
            GenerateAlertsClass.unsuccessfulAlert("Offered Course");
        }
        
        categoryTextfield.clear();
        titleTextfield.clear();
        roomTextField.clear();
        facnameTextfield.clear();
        creditTextfield.clear();
        capacitycbox.setValue(null);
        sectioncbox.setValue(null);
        semestercbox.setValue(null);
        dayscbox.setValue(null);
        timebox.setValue(null);
        theoryradiobtn.setSelected(false);
        labradiobtn.setSelected(false);
        //courseidcombobox.setValue(null);   
        //facultyidcombobox.setValue(null);
        
    }


    private void courseselectionbuttonhelper(){
        for ( CourseClass tmp : tempcoursearray ){
            if ( ((courseidcombobox.getValue()).equals(tmp.getCourseId()) && theoryradiobtn.isSelected()) && tmp.getCourseType().equals("Theory") ){
               categoryTextfield.setText(tmp.getCourseCategory());
               creditTextfield.setText(String.valueOf( tmp.getNoOfCredits()));
               titleTextfield.setText(tmp.getCourseTitle());
            }
            else if ( ((courseidcombobox.getValue()).equals(tmp.getCourseId()) && labradiobtn.isSelected()) && tmp.getCourseType().equals("Lab") ){
               categoryTextfield.setText(tmp.getCourseCategory());
               creditTextfield.setText(String.valueOf( tmp.getNoOfCredits()));
               titleTextfield.setText(tmp.getCourseTitle());
            }
    }
    }
    
    @FXML
    private void oncourseidcomboboxselect(ActionEvent event) {
        courseselectionbuttonhelper();
    }

    @FXML
    private void ontheoryradiobuttonclick(ActionEvent event) {
        courseselectionbuttonhelper();
    }

    @FXML
    private void onlabradiobuttonclick(ActionEvent event) {
        courseselectionbuttonhelper();
    }

    @FXML
    private void facultynameselectionAction(ActionEvent event) {
        for ( Facultyclass tmp : tmpfacultyarray ){
            if ( facultyidcombobox.getValue().equals(tmp.getName()) ){
                facnameTextfield.setText(String.valueOf(tmp.getId()));
            }
        }
    }
    
}
