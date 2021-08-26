/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.jnlp.ApiDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ADDNEWTASKController extends TODOController implements Initializable {

    @FXML
    private TextField hourFld;
    @FXML
    private TextField secondFld;
    @FXML
    private TextField miniuteFld;
    @FXML
    private JFXTextField taskNameField;
    @FXML
    private JFXButton addTaskButton;
    @FXML
    private JFXButton cancelButton;

    private Alert a;
    private String dayFolder;
    private String taskFolder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void addTask(ActionEvent event) throws Exception {
        dayFolder = "src/StudyBase/To_do/" + API.readFileAsString("src/StudyBase/temp_day.txt");

        API.makeDir(dayFolder);
        validateAndAdd();

    }

    @FXML
    private void dontCreateTask(ActionEvent event) {

        API.closeWindowOnButton(cancelButton);

    }

    private void validateAndAdd() throws Exception {

        String hour = hourFld.getText();
        String miniute = miniuteFld.getText();
        String second = secondFld.getText();

        if (API.isEqualsLimit(taskNameField.getText(), 0)) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid Task name");
            a.show();
        } else if (!API.tryParse(hour) || !API.tryParse(miniute) || !API.tryParse(second)) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid time");
            a.show();
        } else if (!API.isEqualsLimit(hour, 2) || !API.isEqualsLimit(miniute, 2) || !API.isEqualsLimit(second, 2)) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid time Format (HH:mm:ss)");
            a.show();
        } else if (Integer.parseInt(hourFld.getText()) > 23) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid time");
            a.show();
        } else if (Integer.parseInt(miniuteFld.getText()) > 59) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid time");
            a.show();
        } else if (Integer.parseInt(secondFld.getText()) > 59) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid time");
            a.show();
        } else {

            dayFolder = "src/StudyBase/To_do/" + API.readFileAsString("src/StudyBase/temp_day.txt");
            taskFolder = dayFolder + "/" + taskNameField.getText();
            API.makeDir(taskFolder);
            String time = hour + ":" + miniute + ":" + second;

            API.dataIn("new_task", taskFolder + "/time.txt", time);
            temp.getItems().add(taskNameField.getText() + " at " + time);
            a = new Alert(AlertType.INFORMATION);
            a.setContentText("Task added successfully");
            a.show();
            API.closeWindowOnButton(addTaskButton);
        }
    }

}
