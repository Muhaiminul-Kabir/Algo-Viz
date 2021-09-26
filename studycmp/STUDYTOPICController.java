/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author new
 */
public class STUDYTOPICController implements Initializable {

    @FXML
    private Label topicName;
    @FXML
    private JFXProgressBar realBar;
    @FXML
    private JFXProgressBar fakeBar;
    @FXML
    private JFXButton startButton;
    @FXML
    private JFXButton compButton;
    @FXML
    private Label compSessions;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fakeBar.setVisible(false);
    }    

    @FXML
    private void startSession(ActionEvent event) {
    }

    @FXML
    private void delTopic(ActionEvent event) {
    }

    void setData(String string) {
        topicName.setText(string);
    }
    
}
