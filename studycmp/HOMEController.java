/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXSpinner;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import static studycmp.API.dataIn;
import static studycmp.API.dateToString;
import static studycmp.TODOController.temp;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HOMEController implements Initializable {

    @FXML
    private Label dateLabel;
    @FXML
    private Label grettings;
    @FXML
    private JFXSpinner taskCmplt;
    @FXML
    private Label pendingLabel;

    private String today = API.dateToString(LocalDate.now());
    String[] get;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            get = API.getAvaliableFilesInDir("src/StudyBase/" + API.getUser() + "To_do/" + today);
        } catch (Exception ex) {
            Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            grettings.setText("Hi, " + API.readFileAsString("src/StudyBase/current_user.txt"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        dateLabel.setText(LocalDate.now().toString());
        if (get == null) {
            pendingLabel.setText(String.valueOf(0));
        } else {
            pendingLabel.setText(String.valueOf(get.length));
        }
        update(new Timer());
    }

    @FXML
    private void startTimer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/CLOCK.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void update(Timer timer) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {
                    File t = new File("src/StudyBase/"
                            + API.getUser()
                            + API.dateToString(LocalDate.now())
                            + "_complt.txt");
                    if (!t.exists()) {

                        API.dataIn("INIT ", "src/StudyBase/"
                                + API.getUser()
                                + API.dateToString(LocalDate.now())
                                + "_complt.txt", "0");

                    }

                    String path = "src/StudyBase/"
                            + API.getUser()
                            + "Progress/"
                            + dateToString(LocalDate.now())
                            + "_study";

                    File t1 = new File(path);
                    if (!t1.exists()) {

                        API.makeDir(path);

                    }

                    String[] fils = API.getAvaliableFilesInDir("src/StudyBase/"
                            + API.getUser()
                            + "Study");

                    File[] is = new File[fils.length];

                    for (int i = 0; i < fils.length; i++) {
                        is[i] = new File(path
                                + "/"
                                + fils[i]
                                + ".txt");

                        if (!is[i].exists()) {
                            API.dataIn("reinc", path
                                    + "/"
                                    + fils[i]
                                    + ".txt", "0");
                        }
                    }

                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (Exception ex) {
                    Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    get = API.getAvaliableFilesInDir("src/StudyBase/" + API.getUser() + "To_do/" + today);
                } catch (Exception ex) {
                    Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.runLater(() -> {
                    if (get == null) {
                        pendingLabel.setText(String.valueOf(0));
                    } else {
                        pendingLabel.setText(String.valueOf(get.length));
                    }
                });
                update(timer);
            }
        }, 100);

    }

}
