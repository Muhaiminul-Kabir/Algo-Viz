/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class NotifyCtrl {
    @FXML
    Label notifyLbl;
    @FXML
    Button okB;
     
    LoginCtrl end;
    
    
    //not Used  
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    
    public void showMsg(String msg){
        notifyLbl.setText(msg);
        
    }
    public void action(ActionEvent event){
       
        end = new LoginCtrl();
        end.closeWindowOnButton(okB);
    }
    
    
    
    
}
