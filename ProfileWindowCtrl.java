/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import study.AccessData;
/**
 *
 * @author ASUS
 */
public class ProfileWindowCtrl  {
    @FXML
    ImageView profileDP;
    @FXML
    Label nameLbl;
   
    
    
   public void showUser(String user) throws FileNotFoundException{
       System.out.println("study.ProfileWindowCtrl.showUser()" + user);
       String ext = AccessData.getExtension(user);
       System.out.println("C:/AppDataBase/"+user+"/Photos/user."+ext);
       AccessData.getSourceImage("C:/AppDataBase/"+user+"/Photos/user."+ext , profileDP);
       nameLbl.setText(user);
   
   }


}
