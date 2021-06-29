/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author ASUS
 */
public class SaveUser {
    @FXML
    private TextField inUser;
     @FXML
    private PasswordField getP;
    
    
    public  void makeDir() {
        File f1 = new File("C:/Appdata");
        //Creating a folder using mkdir() method  
        boolean bool = f1.mkdir();        
        if (bool) {            
            System.out.println("Folder is created successfully");            
        } else {            
            System.out.println("exists");            
        }        
    }
    public  void InPass() {
        Scanner inp = new Scanner(System.in);
        String user;
        user = inUser.getText();
        String pass = getP.getText();
        makeDir();
        String path = "C:/AppData/" + user + ".txt";
        
        try {            
            FileOutputStream fout = new FileOutputStream(path);            
            BufferedOutputStream bout = new BufferedOutputStream(fout);            
            
            byte c[] = pass.getBytes();            
            bout.write(c);
            bout.flush();            
            bout.close();            
            fout.close();            
            System.out.println("success...");            
            
        } catch (Exception e) {
            System.out.println(e);
        }        
    }    
}
