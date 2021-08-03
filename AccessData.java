/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author ASUS
 */
public class AccessData {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static String matchPassAPI(String user) throws Exception {
        String data;
        String path = "C:/AppDataBase/" + user + "/password.txt";
        File tmpDir = new File(path);
        boolean exists = tmpDir.exists();
        if (!exists) {
            data = "err";
        } else {
            data = readFileAsString(path);
        }

        return data;
    }
    
    
    
    public static String filelist(String user) {
        File folder = new File("C:/AppDataBase/"+user +"/Photos");
        File[] listOfFiles = folder.listFiles();
        String ext = null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] filename = file.getName().split("\\.(?=[^\\.]+$)"); //split filename from it's extension
                if (filename[0].equalsIgnoreCase("user")) //matching defined filename
                {
                    System.out.println("File exist: " + filename[0] + "." + filename[1]); // match occures.Apply any condition what you need
                }
                ext = filename[1];
            }
        }
        return ext;
    }

    
    
    public void rename(String patht , String pathr ){
        
        File file = new File(patht);
  
        File rename = new File(pathr);
  
        boolean flag = file.renameTo(rename);
  
        if (flag == true) {
            System.out.println("File Successfully Rename");
        }
        else {
            System.out.println("Operation Failed");
        }
    
    }
    

}
