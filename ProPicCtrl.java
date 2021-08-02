/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class ProPicCtrl {

    @FXML
    TextField filePath;

    NotifyFactory notf;
    SignUpCtrl userIns;
    AccessData API;

    String user;
    String photoPath;
    String pathPic;

    public void choosePic(ActionEvent event) {
        userIns = new SignUpCtrl();
        System.out.println(getUser());
         
        pathPic = "C:/AppDataBase/" + getUser() + "/Photos/";
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
        );

        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            // pickUpPathField it's your TextField fx:id
            filePath.setText(file.getPath());
            photoPath = filePath.getText();
        } else {
            System.out.println("error"); // or something else
        }

    }

    public void setPic(ActionEvent event) throws IOException {
        String ext = "";

        int i = photoPath.lastIndexOf('.');
        if (i >= 0) {
            ext =  photoPath.substring(i + 1);
        }
        
        
        String pathDes = pathPic + "user"+ "." + ext;
        
        
        File source = new File(photoPath);
        File dest = new File(pathDes);

        copyFileUsingStream(source, dest);
        System.out.println("Profile picture sat successfully");
        
        
        sendNotification(event);
    }
    
    
    public void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    

    public void sendNotification(ActionEvent event) throws IOException {
        notify(event, "Registration Successfull");
    }

    public void notify(ActionEvent event, String msg) throws IOException {
        notf = new NotifyFactory();
        notf.notificationInit(event, msg);
    }

    public String getPhoto() {
        return photoPath;
    }

    private String getUser() {
        return user;
    }

    void setUser(String user) {
        this.user = user;

    }
}
