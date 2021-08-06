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

import  study.AccessData;


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
    public String user;

    public void saveUser(ActionEvent event) {
        user = regUser.getText();
        String pass = regPass.getText();
        String instut = regInstut.getText();
        String mobile = regMobile.getText();

        boolean isPass = checkString(pass);
        boolean isUser = checkString(user);
        System.out.println(isPass);

        String userFolder;
        String path;
        String pathInstut;
        String pathMobile, pathPicFld, pathPic;

        userFolder = "C:/AppDataBase/" + user;

        try {
            if (isUser && isPass) {
                if (!AccessData.isUserExists(user)) {
                    makeDir(userFolder);
                    path = "C:/AppDataBase/" + user + "/password.txt";
                    pathInstut = "C:/AppDataBase/" + user + "/Institute.txt";
                    pathMobile = "C:/AppDataBase/" + user + "/Mobile.txt";
                    pathPicFld = "C:/AppDataBase/" + user + "/Photos";
                    pathPic = "C:/AppDataBase/" + user + "/Photos" + "/proPic.txt";

                    makeDir(pathPicFld);
                    dataIn("password", path, pass);
                    
                    if(checkString(instut) && checkString(mobile)){
                        dataIn("institute", pathInstut, instut);
                        dataIn("mobile", pathMobile, mobile);
                    
                    } else{
                        dataIn("institute", pathInstut, "Not provided");
                        dataIn("mobile", pathMobile, "Not provided");
                    
                    }

                    //dataIn("mobile", pathPic, "fuid.png");
                    proPicSetter(event, user);

                }
                else{
                    NotifyFactory message = new NotifyFactory();
                    message.notificationInit(event,user+ " Acoount already created",false);
                }
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

    public String getUser() {
        return user;
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

    public boolean checkString(String user) {
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

    public void proPicSetter(ActionEvent event, String user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/study/setProPic.fxml"));
        root = loader.load();

        ProPicCtrl p1 = loader.getController();
        p1.setUser(user);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setX(400);
        stage.setY(200);

    }

}
