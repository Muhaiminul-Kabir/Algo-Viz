/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Notifications;
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
        // TODO
        get = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + today);

        dateLabel.setText(LocalDate.now().toString());
        if (get == null) {
            pendingLabel.setText(String.valueOf(0));
        } else {
            pendingLabel.setText(String.valueOf(get.length));
        }
        update(new Timer());
    }

    void update(Timer timer) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                get = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + today);
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
