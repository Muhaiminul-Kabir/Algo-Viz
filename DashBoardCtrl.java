/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
class DashBoardCtrl {

    @FXML
    Button DP;
    @FXML
    ImageView proPic;
    
    Image pic;
    private String user;
    private String path;
    
    String imagePath;
    
    
    public void setImage(ActionEvent event){
        imagePath = "C:/AppDataBase" + user + "/user"+".";
        proPic.setImage(new Image(imagePath));
        // EDIT FROM HERE
    }
    
    void setUser(String user){
        this.user = user;
    }
    
    
    
   
}
