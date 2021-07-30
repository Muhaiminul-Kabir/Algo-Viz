/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//(myStr1 == null || myStr1.length() == 0);

/**
 *
 * @author ASUS
 */
public class SignUpCtrl {

    @FXML
    TextField regUser;
    @FXML
    TextField regPass;
    @FXML
    TextField regInstut;
    @FXML
    TextField regMobile;

    public void saveUser(ActionEvent event) {
        String user;
        user = regUser.getText();
        String pass = regPass.getText();
        String instut = regInstut.getText();
        String mobile = regMobile.getText();

        boolean isPass = checkUser(pass);
        boolean isUser = checkUser(user);
        System.out.println(isPass);

        String userFolder;
        String path;
        String pathInstut;
        String pathMobile;

        try {
            if (isUser && isPass) {
                userFolder = "C:/AppDataBase/" + user;

                path = "C:/AppDataBase/" + user + "/password.txt";
                pathInstut = "C:/AppDataBase/" + user + "/Institute.txt";
                pathMobile = "C:/AppDataBase/" + user + "/Mobile.txt";
                dataIn("password", path, pass);
                dataIn("institute", pathInstut, instut);
                dataIn("mobile", pathMobile, mobile);

            } else {
                System.out.println("Something went Wrong");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void makeDir(String path) {

        File f1 = new File(path);
        //Creating a folder using mkdir() method  
        boolean bool = f1.mkdir();
        if (bool) {
            System.out.println("Registerd success");
        } else {
            System.out.println("exists");
        }

    }

    public void dataIn(String sl, String path, String temp) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(path);
        BufferedOutputStream bout = new BufferedOutputStream(fout);

        byte c[] = temp.getBytes();
        bout.write(c);
        bout.flush();
        bout.close();
        fout.close();

        System.out.println(sl + "success...");

    }

    public boolean checkUser(String user) {
        if ((user.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }

}
