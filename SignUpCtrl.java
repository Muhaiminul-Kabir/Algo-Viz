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
import javafx.scene.control.Label;
import java.lang.NullPointerException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    @FXML
    Label userLbl;
    @FXML
    Label passLbl;

    private Stage stage;
    private Scene scene;
    private Parent root;

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

        userFolder = "C:/AppDataBase/" + user;

        try {
            if (isUser && isPass) {
                makeDir(userFolder);
                path = "C:/AppDataBase/" + user + "/password.txt";
                pathInstut = "C:/AppDataBase/" + user + "/Institute.txt";
                pathMobile = "C:/AppDataBase/" + user + "/Mobile.txt";
                dataIn("password", path, pass);
                dataIn("institute", pathInstut, instut);
                dataIn("mobile", pathMobile, mobile);
                notify(event,"Registration Successfull");

            } else {
                System.out.println("Something went Wrong");
                if (!isUser || !isPass) {
                    userLbl.setText("Invalid username");

                    passLbl.setText("Invalid password or username");
                }
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

    public void notify(ActionEvent event,String msg) throws IOException {
        NotifyFactory notf = new NotifyFactory();
        notf.notificationInit(event,msg);
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
    
    
    public void closeWindowOnButton(Button b) {
        // get a handle to the stage
        Stage stage = (Stage) b.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
