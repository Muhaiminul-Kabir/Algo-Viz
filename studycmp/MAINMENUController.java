/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MAINMENUController implements Initializable {

    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton studyButton;
    @FXML
    private JFXButton todoButton;
    @FXML
    private JFXButton notesButton;
    @FXML
    private JFXButton settingsButton;
    @FXML
    private JFXButton progressButton;
    @FXML
    private JFXButton logOutButton;
    @FXML
    private Pane windowContainer;
    
    
    public Pane tempPane;
    private String[] window = {"/studycmp/HOME.fxml","/studycmp/STUDY.fxml","/studycmp/TODO.fxml","/studycmp/NOTES.fxml","/studycmp/SETTINGS.fxml","/studycmp/PROGRESS.fxml"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadWindow(0);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }    

    @FXML
    private void loadHome(ActionEvent event) throws IOException {
        loadWindow(0);
    }

    
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        API.overwriteFile("src/StudyBase/current_user.txt", "");
        API.closeWindowOnButton(logOutButton);
    }
    
    @FXML
    private void loadStudy(ActionEvent event) throws IOException {
        loadWindow(1);
    }

    @FXML
    private void loadTasks(ActionEvent event) throws IOException {
        loadWindow(2);
    }

    @FXML
    private void loadNotes(ActionEvent event) throws IOException {
        loadWindow(3);
    }

    @FXML
    private void loadSettings(ActionEvent event) throws IOException {
        loadWindow(4);
    }

    @FXML
    private void loadProgress(ActionEvent event) throws IOException {
        loadWindow(5);
    }
    
    
    public void loadWindow(int index) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(window[index]));
        Pane newLoadedPane = loader.load();
        
        windowContainer.getChildren().remove(tempPane);

        windowContainer.getChildren().add(newLoadedPane);

        tempPane = newLoadedPane;

    
    
    }
}
