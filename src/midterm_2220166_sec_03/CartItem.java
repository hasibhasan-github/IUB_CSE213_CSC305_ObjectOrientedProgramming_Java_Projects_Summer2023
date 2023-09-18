/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm_2220166_sec_03;

/**
 *
 * @author Hasib
 */
public class CartItem {
    private String productName;
    private float unitPrice;
    private int vatRate, quantity;

    public CartItem(String productName, float unitPrice, int vatRate, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public float getVatAmount(){
        String a = String.valueOf(vatRate);
        float x = (Float.parseFloat(a)/Float.parseFloat("100"));
        x = unitPrice*x;
        return x*quantity;
    }
    
    public float getTotalAmount(){
        return (unitPrice*quantity)+getVatAmount();
    }

    @Override
    public String toString() {
        return  "product: " + productName + ", unitPrice: " + unitPrice + ", Vat: " + vatRate + ", quantity=" + quantity + ", Vat Amount: " + getVatAmount() + ", Total Amount: " + getTotalAmount() + "\n";
    }
    
    
}
