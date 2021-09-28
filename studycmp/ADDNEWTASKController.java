/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.sun.jnlp.ApiDialog;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private JFXTextField taskNameField;
    @FXML
    private JFXButton addTaskButton;
    @FXML
    private JFXButton cancelButton;
    @FXML
    private JFXTimePicker taskTime;
    @FXML
    private JFXComboBox<String> repeatBox;

    private Alert a;
    private String dayFolder;
    private String taskFolder;
    private boolean noTask;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] choice = {"Once", "Weekly", "For a week"};
        repeatBox.getItems().addAll(choice);
        repeatBox.setValue("Once");
    }

    @FXML
    private void addTask(ActionEvent event) throws Exception {
        dayFolder = "src/StudyBase/" + API.getUser() + "/To_do/" + API.readFileAsString("src/StudyBase/temp_day.txt");

        noTask = API.makeDir(dayFolder);
        System.out.println(noTask);

        validateAndAdd();

    }

    @FXML
    private void dontCreateTask(ActionEvent event) {

        API.closeWindowOnButton(cancelButton);

    }

    private void validateAndAdd() throws Exception {

        if (API.isEqualsLimit(taskNameField.getText(), 0)) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid Task name");
            a.show();
        } else if (taskTime.getValue() == null) {
            a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter a valid Task name");
            a.show();
        } else {
            dayFolder = "src/StudyBase/" + API.getUser() + "To_do/" + API.readFileAsString("src/StudyBase/temp_day.txt");
            taskFolder = dayFolder + "/" + taskNameField.getText();

            API.makeDir(taskFolder);

            API.dataIn("NEW_TASK", taskFolder + "/time.txt", taskTime.getValue().toString());

            if (repeatBox.getValue().equals("For a week")) {

                addForWeek();

            } else if (repeatBox.getValue().equals("Weekly")) {
                addWeekly();
            }

            if (noTask) {
                temp.getItems().clear();
                noTask = false;
            }

            temp.getItems().add(taskNameField.getText()); // from super class
            temp.setMouseTransparent(false);
            temp.setFocusTraversable(true);

            a = new Alert(AlertType.INFORMATION);
            a.setContentText("Task added successfully");
            a.show();
            API.closeWindowOnButton(addTaskButton);
        }
    }

    private void addForWeek() throws Exception {

        LocalDate tDate = API.strToDate(API.readFileAsString("src/StudyBase/temp_day.txt"));

        LocalDate[] dArr = new LocalDate[7];

        for (int i = 0; i < 7; i++) {
            dArr[i] = tDate.plusDays(1);
            tDate = tDate.plusDays(1);
        }

        for (int i = 0; i < dArr.length; i++) {

            dayFolder = "src/StudyBase/" + API.getUser() + "To_do/" + API.dateToString(dArr[i]);
            API.makeDir(dayFolder);
            taskFolder = dayFolder + "/" + taskNameField.getText();

            API.makeDir(taskFolder);

            API.dataIn("NEW_TASK", taskFolder + "/time.txt", taskTime.getValue().toString());

            // System.out.println(repeatBox.getValue());
        }

    }

    private void addWeekly() throws Exception {

        LocalDate tDate = API.strToDate(API.readFileAsString("src/StudyBase/temp_day.txt"));
        for (int i = 0; i < 10; i++) {

            tDate = tDate.plusDays(7);
            dayFolder = "src/StudyBase/" + API.getUser() + "To_do/" + API.dateToString(tDate);
            API.makeDir(dayFolder);
            taskFolder = dayFolder + "/" + taskNameField.getText();

            API.makeDir(taskFolder);

            API.dataIn("NEW_TASK", taskFolder + "/time.txt", taskTime.getValue().toString());
        }
    }

}
