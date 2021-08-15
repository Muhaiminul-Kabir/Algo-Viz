/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class INITSETTINGSController implements Initializable {

    @FXML
    JFXTextField getNameFld;
    @FXML
    JFXDatePicker birthDayPicker;    
    @FXML
    JFXButton applyButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadMainMenu(ActionEvent event) throws IOException {
        
        System.out.println(getNameFld.getText());
  
        
        API.dataIn("NAME", "C:/AUSTBase/Name.txt", getNameFld.getText());
        LocalDate localDate = birthDayPicker.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formatStr = localDate.format(formatter);
        API.dataIn("BIRTHDAY", "C:/AUSTBase/Birth_Day.txt", formatStr);
        API.overwriteFile("C:/AUSTBase/app_state.txt", "pro_user");
        
        API.closeWindowOnButton(applyButton);
            
            Parent root = FXMLLoader.load(getClass().getResource("/studycmp/MAINMENU.fxml"));
           
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            
            
            stage.setScene(scene);
            stage.show();
      
    }

}
