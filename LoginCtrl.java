/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import com.jfoenix.controls.JFXButton;
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

/**
 *
 * @author ASUS
 */
public class LoginCtrl {

    @FXML
    Button loginB;
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
        API = new AccessData();
        String userName = userIn.getText();

        

        if (API.matchPass(userName).equals("err")) {
            System.out.println("Invalid User");
            userInLbl.setText("Invalid user");
        } else if (API.matchPass(userName).equals(passIn.getText())) {
            closeWindowOnButton(loginB);
            dashInit(event, userName);
            
        }
        else{
            passInLbl.setText("Incorrect password");
        }

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
        myDash.setUser(user);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setX(10);
        stage.setY(10);

    }

    public void closeWindowOnButton(Button b) {
        // get a handle to the stage
        Stage stage = (Stage) b.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
