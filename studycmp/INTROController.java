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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class INTROController implements Initializable {

    @FXML
    private JFXButton nextButton;
    @FXML
    private JFXButton skipButton;
    @FXML
    private JFXProgressBar slideProgress;
    @FXML
    private Pane slideContainer;

    public int index = 1;
    public double p = 0.0;

    public String[] slide = {"/studycmp/SLIDE0.fxml", "/studycmp/SLIDE1.fxml", "/studycmp/SLIDE2.fxml", "/studycmp/SLIDE3.fxml"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            slideProgress.setProgress(0);

            FXMLLoader loader = new FXMLLoader(getClass().getResource(slide[0]));
            Pane newLoadedPane = loader.load();

            slideContainer.getChildren().add(newLoadedPane);
            tempPane = newLoadedPane;

        } catch (IOException ex) {
            Logger.getLogger(INTROController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Pane tempPane;

    @FXML
    public void loadSlide(ActionEvent e) throws IOException {

        if (index < 4) {
            
            p += 0.33;

            

            if (index == 3) {
                nextButton.setText("DONE");
            }
            changeSlide();
            index++;

        }
        else {
            System.out.println("MAXLIMIT");

            initSettings();
        }

    }

    @FXML
    public void loadInitial(ActionEvent e) throws IOException {

        
        initSettings();
        
        
    }

    private void changeSlide() throws IOException {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource(slide[index]));
        Pane newLoadedPane = loader.load();
        slideProgress.setProgress(p);
        slideContainer.getChildren().remove(tempPane);

        slideContainer.getChildren().add(newLoadedPane);

        tempPane = newLoadedPane;

    }

    
    private void initSettings() throws IOException {
        API.closeWindowOnButton(nextButton);

        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/INITSETTINGS.fxml"));

        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
}
