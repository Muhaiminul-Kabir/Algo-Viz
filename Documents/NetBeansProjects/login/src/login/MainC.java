/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class MainC {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUserName;
     @FXML
    private PasswordField txtPassword;
      @FXML
    private Button lgb;
     
     private boolean lt = false;
    
     private void setLt(){
         
         lt = true;
     }
     
     private boolean getLt(){
         
         return lt;
     }
     
     private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) lgb.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
     
     public void signUp(ActionEvent event) throws IOException{
         closeButtonAction();
         Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/login/signUp.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
         
     }
       public void siddeMenu(ActionEvent event) throws IOException{
         
         Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/login/sideMenu.fxml"));
			Scene scene = new Scene(root);
                        stage.setX(50);
                        stage.setY(50);
			stage.setScene(scene);
			stage.show();
         
     }
     
     
     
     
     
     
     
    
    public void login(ActionEvent event) throws IOException{
        
        
        
        
        if(txtUserName.getText().equals("Nirjon") && txtPassword.getText().equals("sala")){
             lblStatus.setText("Succeuss!");
             closeButtonAction();
             Stage stage = new Stage();
             
             Parent root = FXMLLoader.load(getClass().getResource("/login/FXML.fxml"));
			
             
             Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
        }
        else{
             lblStatus.setText("ERROR");
        }
            
    }
    
        
    
    
   
    
}
