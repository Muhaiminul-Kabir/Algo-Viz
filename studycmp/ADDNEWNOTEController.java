/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ADDNEWNOTEController extends NOTESController implements Initializable {

    @FXML
    private TextArea noteText;
    @FXML
    private JFXButton createNoteButton;
    @FXML
    private JFXTextField noteTitle;
    /**
     * Initializes the controller class.
     */
    private String noteName = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // noteTitle.setText(noteName);
    }

    @FXML
    private void addNote(ActionEvent event) throws Exception {
        String Title = noteTitle.getText();
        API.dataIn("NewNote", "src/StudyBase/" + API.getUser() + "Notes/" + Title + ".txt", noteText.getText());
    }

    void setData(String string) throws Exception {
        
        String[] splited = string.split(".");
        System.err.println(splited[0]);
        noteTitle.setText(splited[0]);
        noteText.setText(API.readFileAsString("src/StudyBase/" + API.getUser() + "Notes/" + splited[0] + ".txt"));
        
    }

}
