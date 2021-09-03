/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BGNController implements Initializable {

    private int index = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Time checker successfully initialized");

        make(new Timer());
    }

    private void make(Timer timer) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    LocalTime myObj = LocalTime.now();

                    String today = API.dateToString(LocalDate.now());

                    String get[] = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + today);

                    String txtTime;

                    LocalTime temp;

                    LocalDate x = LocalDate.now();

                    if (get != null) {
                        txtTime = API.readFileAsString("src/StudyBase/To_do/" + today + "/" + get[index] + "/time.txt");
                        temp = LocalTime.parse(txtTime);

                        if (temp.withNano(0).compareTo(myObj.withNano(0)) == 0) {
                            Platform.runLater(() -> {
                                Alert a = new Alert(AlertType.INFORMATION);
                                a.setContentText(get[index]);
                                a.show();
                                if (index < get.length) {
                                    index++;

                                }
                            });

                        }
                    }

                    System.out.println(x + " " + myObj.withNano(0));

                    make(timer);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }, 1000);

    }

}
