/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LOGINPAGEController implements Initializable {

    @FXML
    private JFXTextField userNameFld;
    @FXML
    private JFXPasswordField passField;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton signUpButton;

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException {

        String login = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
        try {
            con = API.connectDb();
            ps = con.prepareStatement(login);
            ps.setString(1, userNameFld.getText());
            ps.setString(2, passField.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                API.closeWindowOnButton(loginButton);
                API.overwriteFile("src/StudyBase/current_user.txt", userNameFld.getText());
                API.overwriteFile("src/StudyBase/app_state.txt","logged_in");
                loadMainMenu();

            } else {
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Inorrect password");
                a.show();

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void loadMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/MAINMENU.fxml"));

        Stage stage = new Stage();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        API.closeWindowOnButton(signUpButton);
        Parent root = FXMLLoader.load(getClass().getResource("/studycmp/INITSETTINGS.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
