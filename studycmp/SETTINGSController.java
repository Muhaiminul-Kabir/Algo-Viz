/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static studycmp.API.dataIn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SETTINGSController implements Initializable {

    @FXML
    private JFXButton applySettingsButton;
    @FXML
    private TextField duration;
    @FXML
    private Spinner<Integer> target;
    @FXML
    private JFXToggleButton noti;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

        target.setValueFactory(valueFactory);
        
        try {
            duration.setText(API.readFileAsString("src/StudyBase/session_duration.txt"));
        } catch (Exception ex) {
            Logger.getLogger(SETTINGSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         noti.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    if(noti.getText().equals("ON")){
                        noti.setText("OFF");
                    }else{
                        noti.setText("ON");
                    }
                }
         });
        
        
        
    }

    @FXML
    private void applySettings(ActionEvent event) throws IOException {
         API.overwriteFile("src/StudyBase/Settings/ss_trgt.txt", String.valueOf(target.getValue()));
         API.overwriteFile("src/StudyBase/session_duration.txt",duration.getText());
         API.overwriteFile("src/StudyBase/Settings/notification.txt",noti.getText());
         
    }
    @FXML
    private void proSet(ActionEvent event) throws IOException {
          Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/PROFILE.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();
    }
    @FXML
    private void usSet(ActionEvent event) throws IOException {
          Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/ABOUTUS.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();
    }
}
