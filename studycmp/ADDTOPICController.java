/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
public class ADDTOPICController extends STUDYController implements Initializable {

    @FXML
    private JFXTextField topicName;
    @FXML
    private TextField setDuration;
    @FXML
    private TextField numSessions;
    @FXML
    private JFXButton save;

    private String path;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            path = "src/StudyBase/"+API.getUser()+"Study/";
        } catch (Exception ex) {
            Logger.getLogger(ADDTOPICController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @FXML
    private void addTopic(ActionEvent event) throws IOException{
        API.closeWindowOnButton(save);
        temp.getItems().add(topicName.getText());
        API.makeDir(path + topicName.getText());
        API.dataIn("xyz", path + "duration.txt", setDuration.getText());
        API.dataIn("xyz", path + "session_no.txt", setDuration.getText());
        
        
        
    }
    
    
    
    
    
}
