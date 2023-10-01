/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package matrixoperationPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class MatrixviewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private ComboBox<Integer> matrix1Rows;
    @FXML private TextField matrix1Cols;
    @FXML private TextField matrix2Cols;
    @FXML private ComboBox<String> matrix2rows;
    @FXML private ComboBox<String> operationboxofmatrix;
    @FXML private RadioButton matrix1TransInverse;
    @FXML private RadioButton matrix2TransInverse;
    @FXML private RadioButton bothTransInverse;
    @FXML private Label elementupdatematrix1;
    @FXML private Label elementupdatematrix2;
    @FXML private TextField getelementmatrix1;
    @FXML private TextField getelementmatrix2;
    @FXML private Button addElementmatrix1;
    @FXML private Button addElementmatrix2;
    @FXML private Button operationbutton;
    @FXML private Label resultshowlabel;
    
    private ToggleGroup tg;
    matrixclass m1;
    matrixclass m2;
    int rPos1=0, cPos1=0, rPos2=0, cPos2=0;
    int program = 0, program2 = 0, count1 = 0, count2 = 1, count3 = 0, count4 = 1;
    String output = "", output1 = "", output2 = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        matrix1Rows.getItems().add(2);
        matrix1Rows.getItems().add(3);
        matrix1Rows.getItems().addAll(4, 5, 6, 7, 8, 9, 10);
        matrix1Rows.setValue(0);
        
        matrix2rows.getItems().add("2");
        matrix2rows.getItems().add("3");
        matrix2rows.getItems().addAll("4", "5", "6", "7", "8", "9", "10");
        matrix2rows.setValue("0");
        
        operationboxofmatrix.getItems().addAll("Addition", 
                "Substraction", 
                "Multiplication", 
                "Transpose",
                "Inverse"
        );
        
        operationboxofmatrix.setValue("Select an operation");
        
        tg = new ToggleGroup();
        matrix1TransInverse.setToggleGroup(tg);
        matrix2TransInverse.setToggleGroup(tg);
        bothTransInverse.setToggleGroup(tg);
        
        //int matrix1NoOfRows = matrix1Rows.getValue();
        //int matrix2NoOfRows = (matrix2rows.getVisibleRowCount);
        //System.out.println(matrix1NoOfRows);
        //System.out.println((matrix2NoOfRows));
        
        //bothTransInverse.setDisable(true);
        //matrix1TransInverse.setDisable(true);
        //matrix2TransInverse.setDisable(true);
        
        /*m1.setMatrixData(0, 0, 1);
        m1.setMatrixData(0, 1, 2);
        m1.setMatrixData(1, 0, 3);
        m1.setMatrixData(1, 1, 4);
        m2.setMatrixData(0, 0, 1);
        m2.setMatrixData(0, 1, 2);
        m2.setMatrixData(1, 0, 3);
        m2.setMatrixData(1, 1, 4);
        matrixclass add = m1.matrixSubstraction(m2);
        String y  = add.getMatrixData();
        String z  = m2.getMatrixData();
        matrixclass trans = m1.matrixTranspose();
        String zk = trans.getMatrixData();
        System.out.println(zk);
        System.out.println(y);
        System.out.println(z);*/
    }    

    @FXML
    private void matrix1RowsComboBox(ActionEvent event) {
        int numOfRowsMatrix1 = matrix1Rows.getValue();
        //System.out.println(numOfRowsMatrix1);
        rPos1 = numOfRowsMatrix1;
    }

    @FXML
    private void matrix2RowsCombo(ActionEvent event) {
        String numOfRowsMatrix2 = matrix2rows.getValue();
        //System.out.println(numOfRowsMatrix2);
        rPos2 = Integer.parseInt(numOfRowsMatrix2);
    }

    @FXML
    private void matrixoperationselection(ActionEvent event) {
        String selectedOperation = operationboxofmatrix.getValue();
        if ( selectedOperation.equals("Addition") ){
        bothTransInverse.setDisable(true);
        matrix1TransInverse.setDisable(true);
        matrix2TransInverse.setDisable(true);
        }
        if ( selectedOperation.equals("Substraction") ){
            bothTransInverse.setDisable(true);
            matrix1TransInverse.setDisable(true);
            matrix2TransInverse.setDisable(true);
        }
        if ( selectedOperation.equals("Multiplication") ){
            bothTransInverse.setDisable(true);
            matrix1TransInverse.setDisable(true);
            matrix2TransInverse.setDisable(true);
        }
        if ( selectedOperation.equals("Transpose") ){
            matrix1TransInverse.setDisable(false);
            matrix2TransInverse.setDisable(false);
            bothTransInverse.setDisable(false);
            
        }
        if ( selectedOperation.equals("Inverse") ){
            matrix1TransInverse.setDisable(false);
            matrix2TransInverse.setDisable(false);
            bothTransInverse.setDisable(false);
            
        }
    }
    
    private void matrix1elementaddedhelper(){
        count2++;
        System.out.println(count1);
        System.out.println(count2);
        m1.setMatrixData(count1, (count2)-1, (Integer.parseInt(getelementmatrix1.getText())));
        String s = m1.getMatrixData();
        //resultshowlabel.setText(s);
        System.out.println(s);
        elementupdatematrix1.setText("Added ["+count1+"]["+(count2-1)+"] element to matrix1:");
        //getelementmatrix1.setText("");
        output1 += "Matrix1 :\n" + m1.getMatrixData() + "\n";
        output += output1 + output2;
        resultshowlabel.setText(output);
        output2 = "";
        output = "";
    }

    @FXML
    private void matrix1elementadded(ActionEvent event) {
        if ( program == 0 ){
            cPos1 = Integer.parseInt(matrix1Cols.getText());
            //cPos2 = Integer.parseInt(matrix2Cols.getText());
            program++;
            m1 = new matrixclass(rPos1, cPos1);
            //m2 = new matrixclass(rPos2, cPos2);
            System.out.println(getelementmatrix1.getText());
            //System.out.println(rPos1);
            m1.setMatrixData(count1, (count2)-1, (Integer.parseInt(getelementmatrix1.getText())));
            elementupdatematrix1.setText("Added ["+count1+"]["+(count2-1)+"] element to matrix1:");
            output1 += "Matrix1 :\n" + m1.getMatrixData() + "\n";
            output += output1 + output2;
            resultshowlabel.setText(output);
            output2= "";
            output = "";
            //String s = m1.getMatrixData();
            //System.out.println(s);
        /*m1.setMatrixData(0, 0, 1);
        m1.setMatrixData(0, 1, 2);
        m1.setMatrixData(1, 0, 3);
        m1.setMatrixData(1, 1, 4);
        m2.setMatrixData(0, 0, 1);
        m2.setMatrixData(0, 1, 2);
        m2.setMatrixData(1, 0, 3);
        m2.setMatrixData(1, 1, 4);
        String y = m1.getMatrixData();
        String z = m2.getMatrixData();*/
        //System.out.println(rPos1);
            //matrix1elementaddedhelper();
        }
        else{
            if (  rPos1 == cPos1 ){
                if (count2 <= rPos1-1){
                matrix1elementaddedhelper();}
                else{
                count2 = 0;
                count1++;
                matrix1elementaddedhelper();    
                }
            }
            else if (  rPos1 > cPos1 ){
                if (count2 <= cPos1-1){
                matrix1elementaddedhelper();}
                else{
                count2 = 0;
                count1++;
                matrix1elementaddedhelper();    
                }
            }
            else if ( rPos1 != cPos1 ) {
                //System.out.println("Hasib");
                if ( count2 <= rPos1 ){
                    matrix1elementaddedhelper();
                }
                else{
                count2 = 0;
                count1++;
                matrix1elementaddedhelper();
                }
            }
            //else{
                //m1.setMatrixData(1, (count2)-1, (Integer.parseInt(getelementmatrix1.getText())));
                //System.out.println(count2);
                //System.out.println(count1);
            //}
        }
        
    }
    
    private void matrix2elementaddedhelper(){
        count4++;
        System.out.println(count4);
        //System.out.println(count2);
        m2.setMatrixData(count3, (count4)-1, (Integer.parseInt(getelementmatrix2.getText())));
        String s = m2.getMatrixData();
        //resultshowlabel.setText(s);
        System.out.println(s);
        elementupdatematrix2.setText("Added ["+count3+"]["+(count4-1)+"] element to matrix2:");
        //getelementmatrix1.setText("");
        output2 += "Matrix2: \n" + m2.getMatrixData() + "\n";
        output += output1 + output2;
        resultshowlabel.setText(output);
        output1 = "";
        //output2 = "";
        output = "";
    }

    @FXML
    private void matrix2elementadded(ActionEvent event) {
        if ( program2 == 0 ){
            //cPos1 = Integer.parseInt(matrix1Cols.getText());
            cPos2 = Integer.parseInt(matrix2Cols.getText());
            program2++;
            //m1 = new matrixclass(rPos1, cPos1);
            m2 = new matrixclass(rPos2, cPos2);
            System.out.println(getelementmatrix2.getText());
            //System.out.println(rPos1);
            m2.setMatrixData(count3, (count4)-1, (Integer.parseInt(getelementmatrix2.getText())));
            elementupdatematrix2.setText("Added ["+count3+"]["+(count4-1)+"] element to matrix2:");
            String s = m2.getMatrixData();
            System.out.println(s);
            output1 += "Matrix2 :\n" + m2.getMatrixData() + "\n";
            output += output1 + output2;
            resultshowlabel.setText(output);
            //output2 = "";
            output1 = "";
            output = "";
        /*m1.setMatrixData(0, 0, 1);
        m1.setMatrixData(0, 1, 2);
        m1.setMatrixData(1, 0, 3);
        m1.setMatrixData(1, 1, 4);
        m2.setMatrixData(0, 0, 1);
        m2.setMatrixData(0, 1, 2);
        m2.setMatrixData(1, 0, 3);
        m2.setMatrixData(1, 1, 4);
        String y = m1.getMatrixData();
        String z = m2.getMatrixData();*/
        //System.out.println(rPos1);
            //matrix1elementaddedhelper();
        }
        else{
            if (  rPos2 == cPos2 ){
                if (count4 <= rPos2-1){
                matrix2elementaddedhelper();}
                else{
                count4 = 0;
                count3++;
                matrix2elementaddedhelper();    
                }
            }
            else if (  rPos2 > cPos2 ){
                if (count4 <= cPos2-1){
                matrix2elementaddedhelper();}
                else{
                count4 = 0;
                count3++;
                matrix2elementaddedhelper();    
                }
            }
            else if ( rPos2 != cPos2 ) {
                if ( count4 <= rPos2 ){
                    matrix2elementaddedhelper();
                }
                else{
                count4 = 0;
                count3++;
                matrix2elementaddedhelper();
                }
            }
            //else{
                //m1.setMatrixData(1, (count2)-1, (Integer.parseInt(getelementmatrix1.getText())));
                //System.out.println(count2);
                //System.out.println(count1);
            //}
        }
    }

    @FXML
    private void executeOperation(ActionEvent event) {
        String selectedOperation = operationboxofmatrix.getValue();
            if ( selectedOperation.equals("Addition") ){
                matrixclass addition = m1.matrixAddition(m2);
                output += "Matrix 1:\n" + m1.getMatrixData() + "\n" + "Matrix2 :\n" + m2.getMatrixData() + "\n" + "Result:\n" + addition.getMatrixData();
                resultshowlabel.setText(output);
            }
            else if ( selectedOperation.equals("Substraction") ){
                matrixclass substract = m1.matrixSubstraction(m2);
                output += "Matrix 1:\n" + m1.getMatrixData() + "\n" + "Matrix2 :\n" + m2.getMatrixData() + "\n" + "Result:\n" + substract.getMatrixData();
                resultshowlabel.setText(output);
            }
            else if (selectedOperation.equals("Multiplication")){
                matrixclass multiplication = m1.matrixSubstraction(m2);
                output += "Matrix 1:\n" + m1.getMatrixData() + "\n" + "Matrix2 :\n" + m2.getMatrixData() + "\n" + "Result:\n" + multiplication.getMatrixData();
                resultshowlabel.setText(output);
            } 
    }

    
}
