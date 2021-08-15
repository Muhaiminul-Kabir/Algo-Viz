/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import studycmp.API;

/**
 *
 * @author ASUS
 */
public class StudyCmp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        API.mainDir();
        if (API.readFileAsString("C:/AUSTBase/app_state.txt").equals("pre_user")) {

            Parent root = FXMLLoader.load(getClass().getResource("/studycmp/INTRO.fxml"));

            FadeTransition ft = new FadeTransition(Duration.millis(300), root);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();

            Scene scene = new Scene(root);

            primaryStage.initStyle(StageStyle.UNDECORATED);

            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/studycmp/MAINMENU.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
