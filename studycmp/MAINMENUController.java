/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
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
public class MAINMENUController implements Initializable {

    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton studyButton;
    @FXML
    private JFXButton todoButton;
    @FXML
    private JFXButton notesButton;
    @FXML
    private JFXButton settingsButton;
    @FXML
    private JFXButton progressButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadHome(ActionEvent event) {
    }

    @FXML
    private void loadStudy(ActionEvent event) {
    }

    @FXML
    private void loadTasks(ActionEvent event) {
    }

    @FXML
    private void loadNotes(ActionEvent event) {
    }

    @FXML
    private void loadSettings(ActionEvent event) {
    }

    @FXML
    private void loadProgress(ActionEvent event) {
    }
    
}
