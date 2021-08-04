/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javax.imageio.ImageIO;
import static study.AccessData.*;
import static study.LoginCtrl.*;
/**
 *
 * @author ASUS
 */
public class MainMenuCtrl {

    @FXML
    ImageView pic;
    @FXML
    Button profileB;
     @FXML
    AnchorPane winContainer;
    @FXML
    Button logOutB;
      
    String user;

    String path;

    void setProfile(String user) throws FileNotFoundException, IOException {
         String path = "C:/AppDataBase/" + user + "/Photos";
        String file = path + "/user." + filelist(user);
        getSourceImage(file,pic);
    }
    
    public void logOut(ActionEvent event){
        closeWindowOnButton(logOutB);
    }
    

    
    
    
}
