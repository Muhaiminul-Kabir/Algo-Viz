/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import study.ProPicCtrl;

/**
 *
 * @author ASUS
 */
public class Study extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
                        makeDirMAIN();
			Parent root = FXMLLoader.load(getClass().getResource("/study/loginPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public  void makeDirMAIN() throws IOException {
        File f1 = new File("C:/AppDataBase");
        
        
        
        //Creating a folder using mkdir() method  
        boolean bool = f1.mkdir();        
        if (bool) {            
            System.out.println("Folder is created successfully");
            File f11 = new File("C:/AppDataBase/Guest");
             f11.mkdir();
            File f12 = new File("C:/AppDataBase/Guest/Photos");
            f12.mkdir();
            File f13 = new File("C:/AppDataBase/Guest/Photos/user.png");
            File f14 = new File("src/study/images/user.png");
            ProPicCtrl.copyFileUsingStream(f14, f13);
            
        } else {            
            System.out.println("exists");            
        }        
    }
    
}
