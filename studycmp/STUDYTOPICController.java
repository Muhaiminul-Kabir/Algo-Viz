/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static studycmp.API.dateToString;

/**
 * FXML Controller class
 *
 * @author new
 */
public class STUDYTOPICController extends STUDYController implements Initializable {

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

    static Label trp;
    
    static JFXProgressBar pp;
    static JFXProgressBar fpp;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trp = compSessions;
        pp = realBar;
        fpp = fakeBar;
    }    

    @FXML
    private void startSession(ActionEvent event) throws Exception {
        fakeBar.setVisible(true);
        realBar.setVisible(false);
        loadTimer();
    }

    @FXML
    private void delTopic(ActionEvent event) throws Exception {
        
        String path2 = "src/StudyBase/" 
                + API.getUser()
                + "Progress/"
                +dateToString(LocalDate.now())
                +"_study/";
        
        String path3 = path2 + API.readFileAsString("src/StudyBase/curr_std.txt");
        
        String path4 = "src/StudyBase/"
                +API.getUser()
                +"Study/"
                + API.readFileAsString("src/StudyBase/curr_std.txt");
        
        API.delete(new File(path3));
        API.delete(new File(path4));
        temp.getItems().remove(API.readFileAsString("src/StudyBase/curr_std.txt"));
        API.overwriteFile("src/StudyBase/curr_std.txt", "0");
        API.closeWindowOnButton(compButton);
    }

    void setData(String string) throws IOException {
        topicName.setText(string);
        API.overwriteFile("src/StudyBase/curr_std.txt", string);
        int c;
        try {
             String x = "src/StudyBase/"
                     + API.getUser()
                     + "Study/" 
                     + API.readFileAsString("src/StudyBase/curr_std.txt")
                     + "/session_no.txt";
             
            c  = Integer.parseInt(API.readFileAsString("src/StudyBase/"
                    + API.getUser()
                    + "Study/" 
                    + API.readFileAsString("src/StudyBase/curr_std.txt")
                    + "/did.txt"));
            
            String h = API.readFileAsString(x);
            double p = c/Double.parseDouble(h);
            realBar.setProgress(p);
            compSessions.setText(c+"/"+h);
        } catch (Exception ex) {
            Logger.getLogger(STUDYTOPICController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fakeBar.setVisible(false);
    
    
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
