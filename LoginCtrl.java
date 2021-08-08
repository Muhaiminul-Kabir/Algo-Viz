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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import study.AccessData;

/**
 *
 * @author ASUS
 */
public class LoginCtrl {

    @FXML
    Button loginB;
    @FXML
    Button guestB;
    @FXML
    TextField userIn;
    @FXML
    PasswordField passIn;
     @FXML
     Label passInLbl;
    @FXML
    Label userInLbl;

    private Stage stage;
    private Scene scene;
    private Parent root;

    AccessData API;

    public void login(ActionEvent event) throws IOException, Exception {
       
        String userName = userIn.getText();

        

        if (AccessData.matchPassAPI(userName).equals("err")) {
            System.out.println("Invalid User");
            userInLbl.setText("Invalid user");
        } else if (AccessData.matchPassAPI(userName).equals(passIn.getText())) {
            closeWindowOnButton(loginB);
            System.out.println(AccessData.getExtension(userName));
            mainMenu(event,userName);
            
        }
        else{
            passInLbl.setText("Incorrect password");
        }

    }
    
    
    public void guestLogin(ActionEvent event) throws IOException, Exception {
       
            String userName = "Guest";

        

            closeWindowOnButton(loginB);
            System.out.println(AccessData.getExtension(userName));
            mainMenu(event,userName);
            
       

    }
    

    public void signUP(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        Parent root = FXMLLoader.load(getClass().getResource("/study/signUpPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    public void mainMenu(ActionEvent event,String user) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/study/main.fxml"));
        root = loader.load();
        MainMenuCtrl p2 = loader.getController();
        p2.setProfile(user);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    

    public static void closeWindowOnButton(Button b) {
        // get a handle to the stage
        Stage stage = (Stage) b.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}

