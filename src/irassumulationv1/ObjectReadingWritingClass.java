/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irassumulationv1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasib
 */
public class ObjectReadingWritingClass implements Serializable {
    public static <T> Boolean writeObjectToFile(String str, T instance){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File(str);
            if (f.exists() ){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(instance);
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
        return false;
        
    }
    public static ArrayList<?> readObjectToFile(String str, Boolean instance){
        File f = null;
        FileInputStream fw = null;
        ObjectInputStream ois = null;  
        ArrayList<Facultyclass> arrayfaculty = new ArrayList<Facultyclass>();
        ArrayList<CourseClass> coursefaculty = new ArrayList<CourseClass>();
        ArrayList<OfferedCourseClass> offercourse = new ArrayList<OfferedCourseClass>();
        ArrayList<RegisteredCourse> recourse = new ArrayList<RegisteredCourse>();
        try {
            if ( instance == true && str.equals("Faculty.bin") ){
            Facultyclass fc;
            f = new File(str);
            fw = new FileInputStream(f);
            ois = new ObjectInputStream(fw);
            try{
                while (true){
                    fc = (Facultyclass)ois.readObject();
                    arrayfaculty.add(fc);
                    //System.out.println(fc.toString());
                }
                //return arrayfaculty;
            }
            catch(Exception e){
                //System.out.println("Hasib");
            } 
            }
            else if ( instance == false && str.equals("Course.bin") ){
            CourseClass fc;
            f = new File(str);
            fw = new FileInputStream(f);
            ois = new ObjectInputStream(fw);
            try{
                while (true){
                    fc = (CourseClass)ois.readObject();
                    coursefaculty.add(fc);
                    //System.out.println(fc.toString());
                }
            }
            catch(Exception e){
                //System.out.println("Hasib");
            }
        }
        else if (  instance == false && str.equals("OfferedCourse.bin") ) {
            OfferedCourseClass fc;
            f = new File(str);
            fw = new FileInputStream(f);
            ois = new ObjectInputStream(fw);
            try{
                while (true){
                    fc = (OfferedCourseClass)ois.readObject();
                    offercourse.add(fc);
                    //System.out.println(fc.toString());
                }
            }
            catch(Exception e){
                //System.out.println("Hasib");
            }
        }
        else if (  instance == true && str.equals("RegisteredCourse.bin") ) {
            RegisteredCourse fc;
            f = new File(str);
            fw = new FileInputStream(f);
            ois = new ObjectInputStream(fw);
            try{
                while (true){
                    fc = (RegisteredCourse)ois.readObject();
                    recourse.add(fc);
                    //System.out.println(fc.toString());
                }
            }
            catch(Exception e){
                //System.out.println("Hasib");
            }
        }

            //ois.close();
        }
        catch (IOException ex){
            //ex.printStackTrace();
            //System.out.println("Hasib2");
            
        }
        finally{
            try {
                if ( ois != null ){
                    ois.close();
                }
            }
            catch(IOException ex){
                
            }
        }
        if (!coursefaculty.isEmpty()){
            return coursefaculty;
        }
        else if (!offercourse.isEmpty()){
            return offercourse;
        }
        else if (!recourse.isEmpty()){
            return recourse;
        }
        return arrayfaculty;
    }

}
