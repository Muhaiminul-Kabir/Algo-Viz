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
                    LocalTime time = LocalTime.parse("03:32:00");
                    LocalTime time1 = LocalTime.parse("03:33:00");
                    
                    
                    LocalDate x = LocalDate.now();
                    if (time.withNano(0).compareTo(myObj.withNano(0)) == 0 || time1.withNano(0).compareTo(myObj.withNano(0)) == 0) {
                        Platform.runLater(() -> {
                            Alert a = new Alert(AlertType.INFORMATION);
                            a.show();

                        });

                    }

                    System.out.println(x + " " +myObj.withNano(0));

                    make(timer);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }, 1000);
    
    }

}
