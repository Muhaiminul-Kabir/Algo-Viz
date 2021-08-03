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
import static study.AccessData.*;
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
    private String ext;
    private String path;
    String user;
    String imagePath;
   
    /*
    void setUser(String user){
        this.user = user;
    }
    */
   
    void setUser(String user) {
        this.user = user;

    }//bug here
    
    
   
}
