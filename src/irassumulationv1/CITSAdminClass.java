/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author Hasib
 */
public class CITSAdminClass extends user implements Serializable {
    
    public static Boolean addNewFaculty(int id, String name, Float salary, LocalDate dob, LocalDate doj, String dept, String desig){
        Facultyclass newfaculty = new Facultyclass(id, name, salary, dob, doj, dept, desig);
        
        Boolean result = ObjectReadingWritingClass.writeObjectToFile("Faculty.bin", newfaculty);
        return result;

 /*
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File("Faculty.bin");
            if (f.exists() ){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newfaculty);
            oos.close();
            return true;
        }
        catch (IOException ex){
            Logger.getLogger(CITSAdminClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try{
                if ( oos != null){
                    oos.close();
                }
            }
            catch (IOException ex){
                Logger.getLogger(CITSAdminClass.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        return false;*/
    }
    
}
