/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm.set.c;

import java.util.ArrayList;

/**
 *
 * @author Hasib
 */
public class MyArray {
    private ArrayList<Integer> vals;

    public MyArray(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    public ArrayList<Integer> getVals() {
        return vals;
    }

    public void setVals(ArrayList<Integer> vals) {
        this.vals = vals;
    }
    
    public String MyArraySize(){
        return String.valueOf(vals.size());
    }

    @Override
    public String toString() {
        String result = " ";
        for ( Integer res : vals ){
            result += res + "  ";
        }
        return result;
    }
    
    
}
