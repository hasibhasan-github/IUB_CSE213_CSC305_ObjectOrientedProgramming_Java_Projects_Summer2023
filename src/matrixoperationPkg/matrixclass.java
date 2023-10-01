/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixoperationPkg;

/**
 *
 * @author Hasib
 */
public class matrixclass {
    private int[][] vals;
    
    public matrixclass(int rPos, int cPos){
        vals = new int [rPos][cPos]; 
    }
    
    public void setMatrixToNull(){
        vals = null;
    }
    
    public boolean getMatrixStatus(){
        if ( vals == null ){
            return false;
        }
        return true;
    }
    
    public void setMatrixData (int rowIndex, int colIndex, int data){
        vals[rowIndex][colIndex] = data;
    }
    
    public int getMatrixRowColData( int rowIndex, int colIndex ){
        int x = vals[rowIndex][colIndex];
        return x;
    }
    
    public int getMatrixColLength(){
        return vals[0].length;
    }
    
    public String getMatrixData(){
        String res ="";
        for(int i = 0; i < vals.length; i++ ){
            for(int j = 0; j < vals[i].length; j++) {
                res += vals[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }
    
    public matrixclass matrixAddition(matrixclass vals2){
        matrixclass temp = new matrixclass(vals.length,vals[0].length);
        for ( int i = 0; i < vals.length; i++ ){
            for ( int j= 0; j < vals[i].length; j++ ){
                temp.setMatrixData(i, j, vals2.getMatrixRowColData(i, j) + vals[i][j]);
            }
        }
        return temp;
    }
    
    public matrixclass matrixSubstraction(matrixclass vals2){
        matrixclass temp = new matrixclass(vals.length,vals[0].length);
        for ( int i = 0; i < vals.length; i++ ){
            for ( int j= 0; j < vals[i].length; j++ ){
                temp.setMatrixData(i, j, vals[i][j]- vals2.getMatrixRowColData(i, j));
            }
        }
        return temp;
    }
    
    public matrixclass matrixMultiplication(matrixclass vals2){
        int rows1 = vals.length;
        int cols1 = vals[0].length;
        int cols2 = vals2.getMatrixColLength();
        
        matrixclass temp = new matrixclass(rows1, cols2);
        
        int resulthelper = 0;
        
        for ( int  i = 0; i < rows1; i++ ){
            for ( int  j = 0; j < cols2; j++ ){
                for ( int k = 0; k < cols1; k++ ){
                    resulthelper += vals[i][k] * vals2.getMatrixRowColData(k, j);
                }
                temp.setMatrixData(i, j, resulthelper);
                resulthelper = 0;
            }
        }
        return temp;
    }
    
    public matrixclass matrixTranspose(){
        matrixclass temp = new matrixclass(vals[0].length, vals.length);
        
        for ( int i = 0; i < vals[0].length; i++ ){
            for ( int j = 0; j < vals.length; j++ ){
                temp.setMatrixData(i, j, vals[j][i]);
        }
    }
        return temp;
    }
    
}
