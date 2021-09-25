/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static studycmp.API.connectDb;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PROFILEController implements Initializable {

    @FXML
    private TextField cUser;
    @FXML
    private TextField cPass;
    @FXML
    private JFXButton DLT6;
    @FXML
    private JFXButton APPLY;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cUser.setText(API.readFileAsString("src/StudyBase/current_user.txt"));
            getP();
        } catch (Exception ex) {
            Logger.getLogger(PROFILEController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void delF(ActionEvent event) throws Exception, SQLException {

        Statement stmt = API.connectDb().createStatement();

        String query = null;
        try {
            query = "DELETE FROM  USERS WHERE ID = '" + API.readFileAsString("src/StudyBase/current_user.txt") + "'";
        } catch (Exception ex) {
            Logger.getLogger(PROFILEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num = stmt.executeUpdate(query);
        System.out.println("Number of records deleted are: " + num);
        API.closeWindowOnButton(DLT6);
        API.overwriteFile("src/StudyBase/current_user.txt", "");
        API.overwriteFile("src/StudyBase/app_state.txt", "pro_user");
        Platform.exit();

    }

    @FXML
    private void applyF(ActionEvent event) throws SQLException, Exception {
        API.updateDB(cUser.getText(), cPass.getText());

    }

    void loadLogin() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/studycmp/LOGINPAGE.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root1);
        stage2.setScene(scene);
        stage2.show();

    }

    void getP() throws SQLException {
        Connection conn = API.connectDb();
        
        Statement stmt = API.connectDb().createStatement();

        String query = null;
            ResultSet rs;
 
            rs = stmt.executeQuery("SELECT PASSWORD FROM USERS WHERE ID = '"+cUser.getText()+"'");
            while ( rs.next() ) {
                String lastName = rs.getString("PASSWORD");
                cPass.setText(lastName);
            }
            conn.close();
        
        

    }



}
