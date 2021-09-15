/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LOGINPAGEController implements Initializable {

    @FXML
    private JFXTextField userNameFld;
    @FXML
    private JFXPasswordField passField;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton signUpButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logIn(ActionEvent event) {
    }

    @FXML
    private void signUp(ActionEvent event) {
    }
    
}
