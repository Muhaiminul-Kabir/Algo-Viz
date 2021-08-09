/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import study.AccessData;

/**
 *
 * @author ASUS
 */
public class ProfileWindowCtrl {

    @FXML
    ImageView profileDP;
    @FXML
    Label nameLbl;
    @FXML
    Button settingsB;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    public String userName;

    
    
    public void showUser(String user) throws FileNotFoundException {
        setUser(user);
        
            settingsB.setVisible(false);
        
        System.out.println("study.ProfileWindowCtrl.showUser()" + user);
        String ext = AccessData.getExtension(user);
        System.out.println("C:/AppDataBase/" + user + "/Photos/user." + ext);
        AccessData.getSourceImage("C:/AppDataBase/" + user + "/Photos/user." + ext, profileDP);
        nameLbl.setText(user);

    }

    
    public void setUser(String user){
        this.userName = user;
    
    }
    
    

}
