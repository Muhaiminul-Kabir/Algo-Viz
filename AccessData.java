/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author ASUS
 */
public class AccessData {
    public String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public String matchPass(String user) throws Exception {
         String data;
        String path = "C:/AppDataBase/" + user + "/password.txt";
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
