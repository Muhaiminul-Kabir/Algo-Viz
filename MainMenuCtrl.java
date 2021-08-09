/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

import study.AccessData;
import study.LoginCtrl;

/**
 *
 * @author ASUS
 */
public class MainMenuCtrl {

    @FXML
    ImageView pic;
    @FXML
    Button profileB;
    @FXML
    AnchorPane winContainer;
    @FXML
    Button logOutB;
    @FXML
    SplitPane splitPane;
    @FXML
    Button stickyNotesB;
    @FXML
    Button studyB;
    @FXML
    Button timerB;
    @FXML
    Button insightsB;
    @FXML
    Button reminderB;
    @FXML
    ProfileWindowCtrl profileView;

    Pane tempPane;

    private String userName;
    
    String path;

    void setProfile(String user) throws FileNotFoundException, IOException {
        setUser(user);
        System.out.println("Current user : " + userName);
        String path = "C:/AppDataBase/" + user + "/Photos";
        String file = path + "/user." + AccessData.getExtension(user);
        AccessData.getSourceImage(file, pic);
    }

    //  TO BE DONE IN MID BREAK BY US
    public void loadInsightWindow(ActionEvent event) throws IOException {
    }

    public void loadTimerWindow(ActionEvent event) throws IOException {
    }

    public void loadReminderWindow(ActionEvent event) throws IOException {
    }

    public void loadStudyWindow(ActionEvent event) throws IOException {
    }

    public void loadStickyNotesWindow(ActionEvent event) throws IOException {
        
    }

    //TO BE DONE IN MID BREAK BY US
    
    
    public void loadProfileWindow(ActionEvent event) throws IOException {
        System.out.println(userName);
        // THIS WILL BE PASTED IN ALL LOADWINDOW FUNCTION
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/study/profile.fxml"));
        Pane newLoadedPane = loader.load();
        ProfileWindowCtrl p2 = loader.getController();
        p2.showUser(userName);
       
        winContainer.getChildren().remove(tempPane);
        winContainer.getChildren().add(newLoadedPane);

        tempPane = newLoadedPane;
    }

    
    
    
    
    
    
    Stage stage;

    public  void logout(ActionEvent event) throws IOException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?: ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) winContainer.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
            loginInit(event);  
        }

    }

    public void loginInit(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        Parent root = FXMLLoader.load(getClass().getResource("/study/loginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setUser(String user) {
        this.userName = user;
    }
    
    public String getUser() {
        return userName;
    }

}
