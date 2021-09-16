/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author ASUS
 */
public class StudyCmp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        API.mainDir();

        if (API.readFileAsString("src/StudyBase/app_state.txt").equals("pre_user")) {

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
            Parent root = FXMLLoader.load(getClass().getResource("/studycmp/LOGINPAGE.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        } // code-x
        loadBackGroundTasker(); // don't change occurance of this line after code-x

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void loadBackGroundTasker() throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/BGN.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
//  stage2.initStyle(StageStyle.UNDECORATED);

        stage2.setScene(scene);
        stage2.show();
        stage2.setIconified(true); // don't touch this line
        
    }

}
