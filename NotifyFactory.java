/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class NotifyFactory {
    
     private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void notificationInit(ActionEvent event, String msg, boolean good) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/study/notification.fxml"));
        root = loader.load();

        NotifyCtrl notf = loader.getController();
      	if(good){
            notf.showMsg(msg);
        } else {
            notf.alert(msg);
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setResizable(false);
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setX(400);
        stage.setY(200);
        
    }
}
