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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
        birthDayPicker.getEditor().setEditable(false);
        // TODO
    }

    @FXML
    private void loadMainMenu(ActionEvent event) throws IOException {

        if (birthDayPicker.getValue() != null) {
            System.out.println(getNameFld.getText());
        
            doThingsAndLoad();

        } else {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter/choose a valid date");
            a.show();
        }
    }

    private void doThingsAndLoad() throws IOException {

        if(getNameFld.getText().equals("")){
            API.dataIn("NAME", "C:/StudyBase/Name.txt", "User1425");
        
        }
        else{
            API.dataIn("NAME", "C:/StudyBase/Name.txt", getNameFld.getText());
        
        }
        
        LocalDate localDate = birthDayPicker.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formatStr = localDate.format(formatter);
        API.dataIn("BIRTHDAY", "C:/StudyBase/Birth_Day.txt", formatStr);
        API.overwriteFile("C:/StudyBase/app_state.txt", "pro_user");

        API.closeWindowOnButton(applyButton);

        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/MAINMENU.fxml"));

        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}
