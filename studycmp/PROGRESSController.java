/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycmp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author new
 */
public class PROGRESSController implements Initializable {

    @FXML
    private PieChart piChart;
    @FXML
    private JFXButton piCheck;
    String[] topics = null;
    PieChart.Data[] x;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            topics = API.getAvaliableFilesInDir("src/StudyBase/"+API.getUser()+"Study");
        } catch (Exception ex) {
            Logger.getLogger(PROGRESSController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleButton1Action(ActionEvent event) {
        getData();
        System.out.println(x.length);
        ObservableList<PieChart.Data> pieChartData=
                FXCollections.observableArrayList(x);
        

        piChart.setTitle("Study Duration");
        piChart.setData(pieChartData);

    }

    private void getData() {
        
        x = new PieChart.Data[topics.length];
        
        for (int i = 0; i < topics.length; i++) {
            x[i] = new PieChart.Data(topics[i], i);

        }
    }

}
