/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TASKSETTINGSController extends TODOController implements Initializable {

    @FXML
    private JFXTextField taskNameField;
    @FXML
    private JFXTimePicker taskTimeField;
    @FXML
    private JFXButton applyTaskSettings;
    @FXML
    private JFXButton applyTaskSettings1;

    public String name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setData(String string) throws Exception {
        name = string;
        String time = API.readFileAsString("src/StudyBase/To_do/"
                + API.readFileAsString("src/StudyBase/temp_day.txt")
                + "/" + string + "/time.txt");

        taskNameField.setText(string);
        taskTimeField.setValue(LocalTime.parse(time));
    }

    @FXML
    private void change(ActionEvent event) throws Exception {
        String newName = taskNameField.getText();
        String newTime = taskTimeField.getValue().toString();

        String timeFile = "src/StudyBase/To_do/"
                + API.readFileAsString("src/StudyBase/temp_day.txt")
                + "/" + newName + "/time.txt";
        String target = "src/StudyBase/To_do/"
                + API.readFileAsString("src/StudyBase/temp_day.txt")
                + "/" + name;
        String result = "src/StudyBase/To_do/"
                + API.readFileAsString("src/StudyBase/temp_day.txt")
                + "/" + newName;

        API.rename(target, result);
        API.overwriteFile(timeFile, newTime);

        temp.getItems().remove(name);
        temp.getItems().add(newName);
        API.closeWindowOnButton(applyTaskSettings);

        Platform.runLater(() -> {

            Notifications.create()
                    .title("Successful")
                    .text("Task settings updated")
                    .showConfirm();

        });

    }

    @FXML
    private void change1(ActionEvent event) throws Exception {

        API.delete(new File("src/StudyBase/To_do/" + API.dateToString(LocalDate.now()) + "/" + name));
        String x1 = API.readFileAsString("src/StudyBase/task_complt.txt");
        int y = Integer.parseInt(x1);
        API.overwriteFile("src/StudyBase/" + API.dateToString(LocalDate.now()) + "_complt.txt", String.valueOf(++y));
        String[] get = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + API.dateToString(LocalDate.now()));
        if (get.length <= 1) {

            API.delete(new File("src/StudyBase/To_do/" + API.dateToString(LocalDate.now())));
 
        }
        temp.getItems().remove(name);
        
        API.closeWindowOnButton(applyTaskSettings1);
    }

}
