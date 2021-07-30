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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class LoginCtrl {
    @FXML 
    Button loginB;
    @FXML 
    TextField userIn;
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    
    public void login(ActionEvent event) throws IOException {
        
        String userName = userIn.getText();
        closeWindowOnButton(loginB);
        dashInit(event,userName);
    }

    public void signUP(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/study/signUpPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void dashInit(ActionEvent event, String user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/study/dashBoard.fxml"));
        root = loader.load();

        DashBoardCtrl myDash = loader.getController();
        //	myDash.displayName(username);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void closeWindowOnButton(Button b) {
        // get a handle to the stage
        Stage stage = (Stage) b.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
