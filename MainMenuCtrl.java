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
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import static study.AccessData.*;

/**
 *
 * @author ASUS
 */
public class MainMenuCtrl {

    @FXML
    ImageView pic;
    @FXML
    Button profileB;

    String user;

    String path;

    void setImg(String user) throws FileNotFoundException, IOException {
        path = "C:/AppDataBase/" + user + "/Photos";
        
        String file = path + "/user." + filelist(user);
        FileInputStream input = new FileInputStream(file);
        Image image = new Image(input);
        pic.setImage(image);
    }

}
