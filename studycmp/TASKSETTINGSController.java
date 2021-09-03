/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TASKSETTINGSController implements Initializable {

    @FXML
    private JFXTextField taskNameField;
    @FXML
    private TextField taskTimeField;
    @FXML
    private JFXButton applyTaskSettings;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    void setData(String string) throws Exception {
        
        String time = API.readFileAsString("src/StudyBase/To_do/"
                    + API.readFileAsString("src/StudyBase/temp_day.txt") 
                    +"/"+string+"/time.txt");
        
        taskNameField.setText(string);
        taskTimeField.setText(time);
    }
    
    
    
}
