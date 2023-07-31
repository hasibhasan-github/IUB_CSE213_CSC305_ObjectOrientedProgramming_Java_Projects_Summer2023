/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package employeepracticeMainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class EmployeeInterfaceController implements Initializable {

    @FXML
    private TextField employeeid;
    @FXML
    private TextField employeename;
    @FXML
    private TextField employeesalary;
    @FXML
    private ComboBox<String> designationbox;
    @FXML
    private ComboBox<String> departmentbox;
    @FXML
    private DatePicker datebirthfield;
    @FXML
    private DatePicker datejoiningfield;
    @FXML
    private Label employeeinformationcount;
    @FXML
    private TextArea addedresultshow;
    @FXML
    private ComboBox<String> searchdeptbox;
    @FXML
    private TextField lowsalary;
    @FXML
    private TextField upsalary;
    @FXML
    private TextArea searchResult;
    @FXML
    private RadioButton maleid;
    @FXML
    private RadioButton femaleid;
    
    private ToggleGroup tg;
    private ArrayList<Employee> employeelist;
    private ArrayList<Employee> Searchresultlist;
    //private String textset;
    @FXML
    private TextArea textFileTracker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employeelist = new ArrayList<Employee>();
        Searchresultlist = new ArrayList<Employee>();
        tg = new ToggleGroup();
        maleid.setToggleGroup(tg);
        femaleid.setToggleGroup(tg);
        
        departmentbox.getItems().addAll("Admin",
                                        "HR",
                                        "Accountant",
                                        "Manager",
                                        "Clerk",
                                        "Security",
                                        "Utility");
        
        designationbox.getItems().addAll("Junior Officer",
                                         "Senior Officer",
                                         "HR Manager",
                                         "Director",
                                         "Executive",
                                         "Senior-Executive",
                                         "CEO",
                                         "COO");

    }    

    @FXML
    private void addEmployeeOnButtonClick(ActionEvent event) {
        //System.out.println();
        String temp;
        boolean done = true;
        for ( String aa : searchdeptbox.getItems() ){
            if ( aa.equals(departmentbox.getValue())  ){
                done = false;
                break;
            }
        }
        if ( done ){
            searchdeptbox.getItems().add(departmentbox.getValue());
        }
        
        if ( maleid.isSelected() ){
             temp  = "Male";
        }
        else{
            temp = "Female";
        }
        Employee tmp = new Employee(Integer.parseInt(employeeid.getText()),
                                      employeename.getText(),
                                      Float.parseFloat(employeesalary.getText()),
                                       datebirthfield.getValue(),
                                       datejoiningfield.getValue(),
                                       designationbox.getValue(),
                                       departmentbox.getValue(),
                                       temp);
        
        //addedresultshow.setText();
        employeelist.add(tmp);
        //System.out.println(textset);
        addedresultshow.appendText(tmp.toString());
        //addedresultshow.appendText("\n");
        employeeinformationcount.setText("After addition there are "+ employeelist.size() + " employees, as shown below");
        employeeid.clear();
        employeename.clear();
        employeesalary.clear();
        designationbox.setValue("Select Designation");
        departmentbox.setValue("Select Department");
        if (maleid.isSelected()){ maleid.setSelected(false); }
        else{ femaleid.setSelected(false); }
        datebirthfield.setValue(null);
        datejoiningfield.setValue(null);
        //  0 :
        
    }
    


    @FXML
    private void searchButton(ActionEvent event) {
        searchResult.clear();
        Searchresultlist.clear();
        String dept = searchdeptbox.getValue();
        float low = Float.parseFloat(lowsalary.getText());
        float high = Float.parseFloat(upsalary.getText());
        float res = 0;
        int count = 0;
        
        for( Employee x : employeelist ){
            if ( x.getSalary() >= low && x.getSalary() <= high && (x.getDepartment()== dept) ){
                Searchresultlist.add(x);
                res += x.getSalary();
                count += 1;
            }
        }
        res = res/count;   
        String fin = "Average Salary of "+dept+" department having salary within "+low+" and "+high+" taka is: "+res + " taka";
        searchResult.appendText(fin);
    }

    @FXML
    private void deatilswithdatasend(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("details.fxml"));
        
        Parent root = loader.load();
        
        DetailsController detailcont = loader.getController();
        
        detailcont.detailss(Searchresultlist);
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SavetoTextFileButtonOnClick(ActionEvent event) {
        textFileTracker.clear();
        textFileTracker.setText("Data Successfully added to the File.");
        FileWriter fw = null;
        String str = "";
        try{
            File f = new File("Employee.txt");
            if (f.exists() ){
                fw = new FileWriter(f, true);
            }
            else{
                fw = new FileWriter(f);
            }
            for ( Employee navigate : employeelist ){
                str += navigate.toString();
            }
            fw.write(str);
            fw.close();
        }
        catch (IOException ex){
        }
        
    }

    @FXML
    private void readfromtextfileButton(ActionEvent event) {
        File file = new File("Employee.txt");
        Scanner sc;
        String str = null;
        try{
            sc = new Scanner(file);
            addedresultshow.setText(null);
            while(sc.hasNextLine()){
                str = sc.nextLine();
                addedresultshow.appendText(str+"\n");
            }
            textFileTracker.setText("Data Successfully readed from the File.");
        }
        catch(FileNotFoundException ex){
            Logger.getLogger(EmployeeInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            textFileTracker.setText("Unable to open the file.");
        }
    }
    
}
