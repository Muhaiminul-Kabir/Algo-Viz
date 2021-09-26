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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static studycmp.TODOController.temp;

/**
 * FXML Controller class
 *
 * @author new
 */
public class STUDYController implements Initializable {

    @FXML
    private JFXListView<String> topicList;
    @FXML
    private JFXButton addTopic;
    
    static JFXListView<String> temp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         LocalDate date = LocalDate.now();
        String showDate = API.dateToString(date);
        //dateLabel.setText(showDate);

        try {
            String[] avail = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Study");
        } catch (Exception ex) {
            Logger.getLogger(TODOController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           
            temp = topicList;
            topicList.setExpanded(true);
            topicList.depthProperty().set(10);
            loadAvaliableTopics();

            topicList.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    try {
                        loadStudyTopic();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

                private void loadStudyTopic() throws IOException, Exception {
                    System.out.println("psg");
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "/studycmp/STUDYTOPIC.fxml"
                            ));
                    Parent root = loader.load();
                    STUDYTOPICController ctrl = loader.getController();
                    ctrl.setData((String) topicList.getSelectionModel().getSelectedItem());
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
    private void addTopicControl(ActionEvent event) throws IOException {
         Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/ADDTOPIC.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();
        
    }

    private void loadAvaliableTopics() throws Exception {
        String[] avail = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Study");

        if (avail == null) {
            topicList.getItems().add("NO TOPIC ADDED");
            topicList.setMouseTransparent(true);
            topicList.setFocusTraversable(false);
        } else {
            topicList.setMouseTransparent(false);
            topicList.setFocusTraversable(true);
 
            String[] tasks = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Study");
            String[] showTask = new String[tasks.length];

            for (int i = 0; i < tasks.length; i++) {
                showTask[i] = tasks[i] ;
            }

            topicList.getItems().addAll(showTask);
        }
    }
    
}
