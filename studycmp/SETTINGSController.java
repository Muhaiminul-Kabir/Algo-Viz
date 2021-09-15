/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SETTINGSController implements Initializable {

    @FXML
    private JFXListView<String> settingsList;
    @FXML
    private Pane settingsPane;
     @FXML
    private JFXButton logOutButton;
    

    private String setButtons[] = {"General","About Us?","Profile"};
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingsList.getItems().addAll(setButtons);
    }    
    
    @FXML
    private void logOut(ActionEvent e){
        //later
    }
    
    
    
}
