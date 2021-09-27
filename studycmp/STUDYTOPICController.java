/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    private void startSession(ActionEvent event) throws Exception {
        fakeBar.setVisible(true);
        realBar.setVisible(false);
        loadTimer();
    }

    @FXML
    private void delTopic(ActionEvent event) {
    }

    void setData(String string) throws IOException {
        topicName.setText(string);
        API.overwriteFile("src/StudyBase/curr_std.txt", string);
    }

    private void loadTimer() throws IOException, Exception {
      System.out.println("psg");
      API.overwriteFile("src/StudyBase/bool.txt", "off");
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "/studycmp/CLOCK.fxml"
                            ));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
    }
    
}
