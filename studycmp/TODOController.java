/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private JFXButton  dateAheadButton;
    @FXML
    private JFXButton dateBehindButton;
    @FXML
    private Label dateLabel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate date = LocalDate.now();
        String showDate = API.dateToString(date);
        dateLabel.setText(showDate);
        
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
    private void dateIncrementAndLoadTasks(ActionEvent event) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
       
        
        LocalDate dateX = LocalDate.parse(dateLabel.getText(),formatter);
        //System.out.println(dateX);
        LocalDate dateY = dateX.plusDays(1);
        
        dateLabel.setText(API.dateToString(dateY));
        
        
        
    }
    
    @FXML
    private void dateDecrementAndLoadTasks(ActionEvent event) {
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
       
        
        LocalDate dateX = LocalDate.parse(dateLabel.getText(),formatter);
        //System.out.println(dateX);
        LocalDate dateY = dateX.plusDays(-1);
        
        dateLabel.setText(API.dateToString(dateY));
        
        
        
    }
    
}
