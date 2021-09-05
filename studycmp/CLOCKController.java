/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CLOCKController implements Initializable {

    @FXML
    private JFXSpinner timeBar;
    @FXML
    private Label timerLabel;
    @FXML
    private JFXButton resetTimerButton;
    @FXML
    private JFXButton finishTimerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        
        Platform.runLater(() -> {
            //TODO: Initialize timer
        });

    }

    @FXML
    private void resetTimer(ActionEvent event) {
    }

    @FXML
    private void finishTimer(ActionEvent event) {
    }

}
