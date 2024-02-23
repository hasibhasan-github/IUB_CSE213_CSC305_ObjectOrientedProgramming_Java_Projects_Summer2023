/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package midterm.set.c;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField enterElementTxtField;
    @FXML
    private TextArea resultTxtArea;
    @FXML
    private RadioButton forwardRadioButton;
    @FXML
    private RadioButton backwardRadioButton;
    @FXML
    private RadioButton arr1RadioButton;
    @FXML
    private RadioButton arr2RadioButton;
    @FXML
    private RadioButton arr3RadioButton;
    @FXML
    private ComboBox<String> oddEvenComboBox;
    @FXML
    private TextArea bottomresultTxtArea;
    
    private ArrayList<Integer> valList;
    
    private MyArray arr1, arr2, arr3;
    
    private ToggleGroup toggleGroup1, toggleGroup2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        valList = new ArrayList<>();
        arr1 = new MyArray(new ArrayList<>());
        arr2 = new MyArray(new ArrayList<>());
        arr3 = new MyArray(new ArrayList<>());
        
        // Working on Radio Buttons
        toggleGroup1 = new ToggleGroup();
        forwardRadioButton.setToggleGroup(toggleGroup1);
        backwardRadioButton.setToggleGroup(toggleGroup1);
        
        toggleGroup2 = new ToggleGroup();
        arr1RadioButton.setToggleGroup(toggleGroup2);
        arr2RadioButton.setToggleGroup(toggleGroup2);
        arr3RadioButton.setToggleGroup(toggleGroup2);
        
        // Working on ComboBox
        oddEvenComboBox.getItems().addAll("Even", "Odd");
    }    

    @FXML
    private void addElementToValListButton(ActionEvent event) {
        int element = Integer.parseInt(enterElementTxtField.getText());
        valList.add(element);
        enterElementTxtField.clear();
    }

    @FXML
    private void UseValListToCreateArray1Button(ActionEvent event) {
        String sizearr1 = "Size of arr = ";
        arr1.setVals(new ArrayList<>(valList));
        valList.clear();
        resultTxtArea.appendText( "Content of my instance arr1: " + arr1.toString() + "\n" + sizearr1 + arr1.MyArraySize() + "\n" + "\n");
    }

    @FXML
    private void UseValListToCreateArray2Button(ActionEvent event) {
        String sizearr1 = "Size of arr = ";
        arr2.setVals(new ArrayList<>(valList));
        valList.clear();
        resultTxtArea.appendText( "Content of my instance arr2: " + arr2.toString() + "\n" + sizearr1 + arr1.MyArraySize() + "\n" + "\n");
    }

    @FXML
    private void mergeArray1andArray2ShowResultButton(ActionEvent event) {
        resultTxtArea.clear();
        String arr1str = "Content of my instance arr1: ";
        String sizearr1 = "Size of arr = ";
        ArrayList<Integer> temp = new ArrayList<>();
        for ( Integer xy : arr1.getVals() ){
            temp.add(xy);
        }
        for ( Integer ab : arr2.getVals() ){
            temp.add(ab);
        }
        arr3.setVals(new ArrayList<>(temp));
        
        // Result OutPut
        resultTxtArea.appendText(arr1str + arr1.toString() + "\n" + sizearr1 + arr1.MyArraySize() + "\n" + "\n"
                + "Content of my instance arr2: " + arr2.toString() + "\n" + sizearr1 + arr1.MyArraySize() + "\n" + "\n"
                + "Content of merged MyArray arr3: " + arr3.toString() + "\n" + sizearr1 + arr3.MyArraySize() + "\n" + "\n" );
    }

    @FXML
    private void traverseAsPerTheSelectionAndShowResultButton(ActionEvent event) {
        bottomresultTxtArea.clear();
        
        String selectedValueToggleGroup1 = getSelectedToggleGroup1Value();
        String selectedValueToggleGroup2 = getSelectedToggleGroup2Value();
        
        // Final Calculation of the second part!
        ArrayList<Integer> result = new ArrayList<>();
        
            if ( oddEvenComboBox.getValue().equals("Even") ){
                if ( selectedValueToggleGroup2.equals("arr1") ){
                    for ( Integer a : arr1.getVals() ){
                        if ( a%2 == 0 ){
                            result.add(a);
                        }
                    }
                }
                else if ( selectedValueToggleGroup2.equals("arr2") ){
                    for ( Integer a : arr2.getVals() ){
                        if ( a%2 == 0 ){
                            result.add(a);
                        }
                    }
                }
                else if ( selectedValueToggleGroup2.equals("arr3") ){
                    for ( Integer a : arr3.getVals() ){
                        if ( a%2 == 0 ){
                            result.add(a);
                        }
                    }
                }
            }
            else if ( oddEvenComboBox.getValue().equals("Odd") ){
                if ( selectedValueToggleGroup2.equals("arr1") ){
                    for ( Integer a : arr1.getVals() ){
                        if ( a%2 == 1 ){
                            result.add(a);
                        }
                    }
                }
                else if ( selectedValueToggleGroup2.equals("arr2") ){
                    for ( Integer a : arr2.getVals() ){
                        if ( a%2 == 1 ){
                            result.add(a);
                        }
                    }
                }
                else if ( selectedValueToggleGroup2.equals("arr3") ){
                    for ( Integer a : arr3.getVals() ){
                        if ( a%2 == 1 ){
                            result.add(a);
                        }
                    }
                }
            }
            
        // Forward List
        String Forward = "";
        for ( Integer fres : result ){
            Forward += String.valueOf(fres) + " ";
        }
        
        // Backward List
        String Backward = "";
        for ( int i = result.size()-1; i >= 0; i-- ){
            Backward += String.valueOf(result.get(i)) + " ";
        }
        if (selectedValueToggleGroup1.equals("Forward")){
            bottomresultTxtArea.appendText(oddEvenComboBox.getValue() + " nos of " + 
                    "Forward order are: " + Forward);
        }
        else {
            bottomresultTxtArea.appendText(oddEvenComboBox.getValue() + " nos of " + 
                    "Backward order are: " + Backward);
        }
        
    }
    
    public String getSelectedToggleGroup1Value() {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup1.getSelectedToggle();
        return selectedRadioButton != null ? selectedRadioButton.getText() : null;
    }

    public String getSelectedToggleGroup2Value() {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup2.getSelectedToggle();
        return selectedRadioButton != null ? selectedRadioButton.getText() : null;
    }
    
}
