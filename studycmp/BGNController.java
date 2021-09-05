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
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BGNController implements Initializable {

    private int index = 0;
    private LocalTime[] times;
    private String today = API.dateToString(LocalDate.now());

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

                    String get[] = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + today);
                    if (get == null) {
                        System.out.println("no task inside");
                    } else {
                        System.out.println("is task inside");
                    }

                    if (get != null) {
                        times = new LocalTime[get.length];

                        for (int i = 0; i < get.length; i++) {
                            times[i] = timeOf(get[i]);
                            System.out.println(get[i] + " pending at " + times[i]);
                        }
                    }

                    LocalTime myObj = LocalTime.now();

                    String txtTime;

                    LocalTime temp;

                    LocalDate x = LocalDate.now();

                    if (get != null) {

                        if (searchTime()) {
                            Platform.runLater(() -> {

                                Notifications.create()
                                        .title(get[index])
                                        .text("Get ready")
                                        .showWarning();

                                if (index < get.length) {
                                    index++;

                                }
                            });

                        }
                    }

                    System.out.println(x + " " + myObj.withNano(0));

                    make(timer);
                } catch (Exception ex) {
                    System.out.println("caught at line 88 -> " + ex);
                }
            }
        }, 1000);

    }

    private LocalTime timeOf(String task) throws Exception {
        String dayFolder = "src/StudyBase/To_do/" + API.dateToString(LocalDate.now());

        String tPath = dayFolder + "/" + task + "/time.txt";
        LocalTime time = LocalTime.parse(API.readFileAsString(tPath));

        return time;
    }

    private boolean searchTime() {
        int i;
        for (i = 0; i < times.length; i++) {
            if (LocalTime.now().withNano(0).compareTo(times[i]) == 0) {
                index = i;
                break;
            }
        }
        if (i == times.length) {
            return false;
        } else {
            return true;
        }
    }

}
