/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package midterm_2220166_sec_03;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class CartController implements Initializable {

    @FXML
    private TextField pvat;
    @FXML
    private TextField upbdt;
    @FXML
    private ComboBox<String> spd;
    @FXML
    private ComboBox<Integer> quan;
    @FXML
    private TextArea bill;
    @FXML
    private TextField maxpuc;
    @FXML
    private TextArea tvata;
    @FXML
    private ComboBox<Integer> convat;
    
    private ArrayList<CartItem> cartList;
    
    private int prevat;
    private float unitpr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        cartList = new ArrayList<CartItem>();
        //float a = float(5/100);
        //System.out.println(a);
        
        spd.getItems().addAll("Aaarong Milk",
                                "Nescafe Gold 100gm",
                                "Rui Fish kg pack",
                                "Lux Soap White 100gm",
                                "Rice kg pack",
                                "Dabur Amla Hair Oil 250gm",
                                "Mutton kg pack",
                                "Egg 12 pieces",
                                "Chicken kg pack",
                                "Beef kg pack");
       
        //System.out.println(spd.getId());
        
        quan.getItems().addAll(1,2,3,4,5,
                                6,7,8,9,10);
        
        convat.getItems().addAll(1,2,3,4,5,6,7,8,9,10
        ,11,12,13,14,15);
        
    }    

    @FXML
    private void addProductToCartButtonOnClick(ActionEvent event) {
        unitpr = Float.parseFloat(upbdt.getText());
        prevat = Integer.parseInt(pvat.getText());
        CartItem tmp = new CartItem((spd.getValue()), unitpr, prevat, (quan.getValue()) );
        cartList.add(tmp);
    }

    @FXML
    private void checkOutAndShowBillButtonOnClick(ActionEvent event) {
        float total = 0;
        for ( CartItem a : cartList ){
            total += a.getTotalAmount();
            bill.appendText(a.toString());
        }
        
        bill.appendText("\n" + "Total payable: ");
        bill.appendText(String.valueOf(total));
    }

    @FXML
    private void showTotalVatForQualifiedProductsButtonOnClick(ActionEvent event) {
        float tovat=0;
        for ( CartItem z : cartList ){
            if ( Float.parseFloat(maxpuc.getText()) >= z.getUnitPrice() && convat.getValue() >= z.getVatRate() ){
                tovat += z.getVatAmount();
            }
        }
        tvata.appendText("Total Vat Amount is: " + String.valueOf(tovat));
    }

    @FXML
    private void hasib(ActionEvent event) {
        //System.out.println("Hasib");
       if ( spd.getValue() == "Aaarong Milk" ){
            upbdt.setText("100");
            pvat.setText("5");
        }
        else if ( spd.getValue().equals("Nescafe Gold 100gm") ){
            upbdt.setText("900");
            pvat.setText("5");            
        }
        else if (spd.getValue().equals("Rui Fish kg pack")){
            upbdt.setText("400");
            pvat.setText("3");            
        }
        else if (spd.getValue().equals("Rice kg pack")){
            upbdt.setText("50");
            pvat.setText("2");            
        }
        else if ( spd.getValue().equals("Dabur Amla Hair Oil 250gm") ){
            upbdt.setText("400");
            pvat.setText("8");            
        }
        else if (spd.getValue().equals("Mutton kg pack")) {
            upbdt.setText("950");
            pvat.setText("10");            
        }
        else if ( spd.getValue().equals("Egg 12 pieces") ){
            upbdt.setText("150");
            pvat.setText("2");            
        }
        else if ( spd.getValue().equals("Chicken kg pac") ){
            upbdt.setText("180");
            pvat.setText("4");            
        }
        else if ( spd.getValue().equals("Beef kg pack") ){
            upbdt.setText("800");
            pvat.setText("8");            
        }
        else if ( spd.getValue().equals("Lux Soap White 100gm") ){
            upbdt.setText("80");
            pvat.setText("5");
        }
    }
    
}
