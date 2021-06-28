/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author ASUS
 */
public class GetData {
  

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public String getPass(String user) throws Exception {
         String data;
        String path = "C:/AppData/" + user + ".txt";
        File tmpDir = new File(path);
        boolean exists = tmpDir.exists();
        if(!exists){
            data = "err";
        }
        else{ 
            data = readFileAsString(path);
        }


        return data;
    }
}
