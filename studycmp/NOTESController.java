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
public class NOTESController implements Initializable {

    @FXML
    private JFXListView<String> noteList;
    @FXML
    private JFXButton addNoteButton;
    
    
    public static JFXListView<String> temp;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        LocalDate date = LocalDate.now();
        String showDate = API.dateToString(date);
       

        try {
            String[] avail = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Notes");
        } catch (Exception ex) {
            Logger.getLogger(TODOController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           
            temp = noteList;
            noteList.setExpanded(true);
            noteList.depthProperty().set(10);
            loadAvaliableNotes();

           noteList.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    try {
                        loadNote();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

                private void loadNote() throws IOException, Exception {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "/studycmp/ADDNEWNOTE.fxml"
                            ));
                    Parent root = loader.load();
                    ADDNEWNOTEController ctrl = loader.getController();
                    ctrl.setData((String) noteList.getSelectionModel().getSelectedItem());
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
    private void createNote(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/ADDNEWNOTE.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();
    }

    private void loadAvaliableNotes() throws Exception {
         String[] avail = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Notes");

        if (avail.length == 0) {
            noteList.getItems().add("NO NOTES ADDED");
            noteList.setMouseTransparent(true);
            noteList.setFocusTraversable(false);
        } else {
            noteList.setMouseTransparent(false);
            noteList.setFocusTraversable(true);
 
            String[] tasks = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Notes");
            String[] showTask = new String[tasks.length];
           
           
            for (int i = 0; i < tasks.length; i++) {
                String[] tokens = tasks[i].split("\\.(?=[^\\.]+$)");

                showTask[i] = tokens[0] ;
            }

            noteList.getItems().addAll(showTask);
        }
        
    }
    
}
