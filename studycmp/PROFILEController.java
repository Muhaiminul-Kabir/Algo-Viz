/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PROFILEController implements Initializable {

    @FXML
    private TextField cUser;
    @FXML
    private TextField cPass;
    @FXML
    private JFXButton DLT6;
    @FXML
    private JFXButton APPLY;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cUser.setText(API.readFileAsString("src/StudyBase/current_user.txt"));
        } catch (Exception ex) {
            Logger.getLogger(PROFILEController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void delF(ActionEvent event) {
    }

    @FXML
    private void applyF(ActionEvent event) {
    }
    
}
