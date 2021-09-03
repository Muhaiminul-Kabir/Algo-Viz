/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.text.DateFormatter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TODOController implements Initializable {

    @FXML
    private JFXButton addNewTaskButton;
    @FXML
    private JFXListView<String> taskList;
    @FXML
    private JFXButton dateAheadButton;
    @FXML
    private JFXButton dateBehindButton;
    @FXML
    private Label dateLabel;

    public static JFXListView<String> temp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        LocalDate date = LocalDate.now();
        String showDate = API.dateToString(date);
        dateLabel.setText(showDate);

        String[] avail = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + showDate);
        try {
           
            temp = taskList;
            taskList.setExpanded(true);
            taskList.depthProperty().set(10);
            loadAvaliableTasks(showDate);

            taskList.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    try {
                        loadTaskSettings();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

                private void loadTaskSettings() throws IOException, Exception {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "/studycmp/TASKSETTINGS.fxml"
                            ));
                    Parent root = loader.load();
                    TASKSETTINGSController ctrl = loader.getController();
                    ctrl.setData((String) taskList.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void addNewTask(ActionEvent event) throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/ADDNEWTASK.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();
    }

    @FXML
    private void dateIncrementAndLoadTasks(ActionEvent event) throws Exception {

        taskList.getItems().clear();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        LocalDate dateX = LocalDate.parse(dateLabel.getText(), formatter);
        LocalDate dateY = dateX.plusDays(1);

        String day = API.dateToString(dateY);
        dateLabel.setText(day);
        API.overwriteFile("src/StudyBase/temp_day.txt", day);

        loadAvaliableTasks(day);

    }

    @FXML
    private void dateDecrementAndLoadTasks(ActionEvent event) throws Exception {

        taskList.getItems().clear();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        LocalDate dateX = LocalDate.parse(dateLabel.getText(), formatter);
        LocalDate dateY = dateX.plusDays(-1);

        String day1 = API.dateToString(dateY);
        dateLabel.setText(day1);
        API.overwriteFile("src/StudyBase/temp_day.txt", day1);

        loadAvaliableTasks(day1);

    }

    private void loadAvaliableTasks(String day) throws Exception {
        String[] avail = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + day);

        if (avail == null) {
            taskList.getItems().add("NO TASK ADDED");
            taskList.setMouseTransparent(true);
            taskList.setFocusTraversable(false);
        } else {
            taskList.setMouseTransparent(false);
            taskList.setFocusTraversable(true);
 
            String[] tasks = API.getAvaliableFilesInDir("src/StudyBase/To_do/" + day);
            String[] showTask = new String[tasks.length];

            for (int i = 0; i < tasks.length; i++) {
                showTask[i] = tasks[i] ;
            }

            taskList.getItems().addAll(showTask);
        }

    }

}
