/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import static studycmp.API.closeWindowOnButton;
import static studycmp.API.dataIn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class INITSETTINGSController implements Initializable {

    @FXML
    JFXTextField getNameFld;
    @FXML
    JFXPasswordField passField;
    @FXML
    JFXPasswordField confirmPassField;
    @FXML
    JFXButton applyButton;

    public boolean yes = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loadMainMenu(ActionEvent event) throws IOException, Exception {

        saveUser();
    }

    private void doThings() throws IOException, Exception {

        API.makeDir("src/StudyBase/" + getNameFld.getText());
        API.userDir(getNameFld.getText());
        dataIn("INIT ", "src/StudyBase/current_user.txt", getNameFld.getText());

    }

    private void loadMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/MAINMENU.fxml"));

        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    public void saveUser() throws IOException, Exception {
        if (!API.isEqualsLimit(getNameFld.getText(), 0) || !API.isEqualsLimit(passField.getText(), 0) || !API.isEqualsLimit(confirmPassField.getText(), 0)) {

            try {
                if (confirmPassField.getText().equals(passField.getText()) && !isUser()) {

                    Connection con = API.connectDb();

                    Statement st = con.createStatement();

                    st.execute("INSERT INTO USERS VALUES('" + getNameFld.getText() + "','" + passField.getText() + "')");
                    doThings();
                    API.closeWindowOnButton(applyButton);
                    Platform.runLater(() -> {

                        Notifications.create()
                                .title("Welcome!")
                                .text("Get ready")
                                .showWarning();

                    });

                    if (API.readFileAsString("src/StudyBase/app_state.txt").equals("pre_user")) {

                        loadMainMenu();

                        API.overwriteFile("src/StudyBase/app_state.txt", "pro_user");
                    } else {
                        loadLogin();
                    }
                } else if (isUser()) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("User already exists");
                    a.show();

                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("Password didn't matched");
                    a.show();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Please enter all fields");
            a.show();
        }

    }

    private boolean isUser() throws SQLException {
        boolean usernameExists = false;
        Connection con = API.connectDb();
        PreparedStatement st = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
        st.setString(1, getNameFld.getText());
        ResultSet r1 = st.executeQuery();
        if (r1.next()) {
            usernameExists = true;
        }
        return usernameExists;
    }

    private void loadLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/LOGINPAGE.fxml"));

        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}
