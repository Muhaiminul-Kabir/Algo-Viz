/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
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
    private boolean is = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // noteTitle.setText(noteName);
    }

    @FXML
    private void addNote(ActionEvent event) throws Exception {
        int i = Integer.parseInt(API.readFileAsString("src/StudyBase/i.txt"));

        String Title = noteTitle.getText();
        if (API.isEqualsLimit(Title, 0)) {
            Title = "untitled" + String.valueOf(++i);
            API.overwriteFile("src/StudyBase/i.txt", String.valueOf(i));
        }
        if (!is) {
            API.dataIn("NewNote", "src/StudyBase/" + API.getUser() + "Notes/" + Title + ".txt", noteText.getText());
            temp.getItems().remove("NO NOTES ADDED");
            temp.getItems().add(Title);
        } else {
            API.rename("src/StudyBase/" + API.getUser() + "Notes/" + noteName + ".txt", "src/StudyBase/" + API.getUser() + "Notes/" + Title + ".txt");

            API.overwriteFile("src/StudyBase/" + API.getUser() + "Notes/" + Title + ".txt", noteText.getText());

            temp.getItems().remove(noteName);
            temp.getItems().add(Title);

        }
        temp.setMouseTransparent(false);
        temp.setFocusTraversable(true);
        API.closeWindowOnButton(createNoteButton);
    }

    @FXML
    private void delNote(ActionEvent event) throws Exception {
        String Title = noteTitle.getText();
        API.delete(new File("src/StudyBase/" + API.getUser() + "Notes/" + Title + ".txt"));

        temp.getItems().remove(Title);
        API.closeWindowOnButton(createNoteButton);
    }

    void setData(String string) throws Exception {
        is = true;
        noteName = string;
        createNoteButton.setText("SAVE");
        String[] tokens = string.split("\\.(?=[^\\.]+$)");

        noteTitle.setText(tokens[0]);
        noteText.setText(API.readFileAsString("src/StudyBase/" + API.getUser() + "Notes/" + tokens[0] + ".txt"));

    }

}
