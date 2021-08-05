/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import static study.AccessData.*;

/**
 *
 * @author ASUS
 */
public class NotifyCtrl {
    @FXML
    Label notifyLbl;
    @FXML
    Button okB;
     @FXML
    ImageView alertIcon;
     
    LoginCtrl end;
    
    
    //not Used  
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    
    public void showMsg(String msg) throws FileNotFoundException{
        String fPath = "src/study/images/right.png";
        getSourceImage(fPath,alertIcon);
        notifyLbl.setText(msg);
        
    }
    
    public void alert(String msg) throws FileNotFoundException{
        String fPath = "src/study/images/wrong.png";
        getSourceImage(fPath,alertIcon);
        notifyLbl.setText(msg);
        
        okB.setText("LOG IN");
        
    }
    
    public void action(ActionEvent event){
       
        end = new LoginCtrl();
        end.closeWindowOnButton(okB);
    }
    
    
    
    
}
