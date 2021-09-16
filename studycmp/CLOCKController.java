/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CLOCKController implements Initializable {

    @FXML
    private JFXSpinner timeBar;
    @FXML
    private Label timerLabel;
    @FXML
    private JFXButton resetTimerButton;
    @FXML
    private JFXButton finishTimerButton;

    int hours = 00;
    int miniutes = 00;
    int seconds = 02;
    double progress = 0;
    boolean isOk = true;
    String duration;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String duration;
        try {
            duration = API.readFileAsString("src/StudyBase/session_duration.txt");
            String[] splited = duration.split(":");

            hours = Integer.parseInt(splited[0]);
            miniutes = Integer.parseInt(splited[1]);
            seconds = Integer.parseInt(splited[2]);

            // TODO
            timerLabel.setText(duration);
        } catch (Exception ex) {
            System.out.println("caught at line 51 -> " + ex);

        }

        makeTimer(new Timer());
    }

    @FXML
    private void resetTimer(ActionEvent event) throws Exception {
            duration = API.readFileAsString("src/StudyBase/session_duration.txt");
            String[] splited = duration.split(":");

            hours = Integer.parseInt(splited[0]);
            miniutes = Integer.parseInt(splited[1]);
            seconds = Integer.parseInt(splited[2]);

            // TODO
            timerLabel.setText(duration);
        
    
    
    }

    @FXML
    private void finishTimer(ActionEvent event) throws IOException, Exception {
        String x =API.readFileAsString("src/StudyBase/"+API.getUser()+"Progress/daily_session.txt");
        int y = Integer.parseInt(x);
        API.overwriteFile("src/StudyBase/"+API.getUser()+"Progress/daily_session.txt", String.valueOf(++y));
        API.closeWindowOnButton(finishTimerButton);
    }

    String timeStr;

    private void makeTimer(Timer timer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {

                    timerLogic();
                    timeStr = String.valueOf(new DecimalFormat("00").format(hours))
                            + ":" + String.valueOf(new DecimalFormat("00").format(miniutes))
                            + ":" + String.valueOf(new DecimalFormat("00").format(seconds));

                    Platform.runLater(() -> {

                        timerLabel.setText(timeStr);
                        System.out.println(isOk);

                    });

                    if (timerLabel.getText().equals("00:00:00")) {
                        Platform.runLater(() -> {
                            Notifications.create().text("Session completed").showConfirm();
                            resetTimerButton.setVisible(false);
                            timerLabel.setText("Time's up");

                            isOk = false;
                          
                            timer.cancel();
                            timer.purge();
                        });
                    }

                    if (isOk) {
                        makeTimer(timer);
                    }

                } catch (Exception ex) {
                    System.out.println("caught at line 122 -> " + ex);

                } 
            }
        }, 1000);
    }

    private void timerLogic() {
        seconds--;
        if (seconds == 0 && miniutes != 0) {
            miniutes--;
            seconds = 59;
        } else if (miniutes == 0 && hours != 0) {
            hours--;
            miniutes = 59;
        }

    }

}
