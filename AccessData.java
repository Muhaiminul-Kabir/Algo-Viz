/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class AccessData {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static String matchPassAPI(String user) throws Exception {
        String data;
        String path = "C:/AppDataBase/" + user + "/password.txt";
        File tmpDir = new File(path);
        boolean exists = tmpDir.exists();
        if (!exists) {
            data = "err";
        } else {
            data = readFileAsString(path);
        }

        return data;
    }

    public static boolean isUserExists(String user) throws Exception {

        String path = "C:/AppDataBase/" + user;
        File tmpDir = new File(path);
        boolean exists = tmpDir.exists();
        return exists;

    }

    public static String filelist(String user) {
        File folder = new File("C:/AppDataBase/" + user + "/Photos");
        File[] listOfFiles = folder.listFiles();
        String ext = null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] filename = file.getName().split("\\.(?=[^\\.]+$)"); //split filename from it's extension
                if (filename[0].equalsIgnoreCase("user")) //matching defined filename
                {
                    System.out.println("File exist: " + filename[0] + "." + filename[1]); // match occures.Apply any condition what you need
                }
                ext = filename[1];
            }
        }
        return ext;
    }

    public static void rename(String patht, String pathr) {

        File file = new File(patht);

        File rename = new File(pathr);

        boolean flag = file.renameTo(rename);

        if (flag == true) {
            System.out.println("File Successfully Renamed");
        } else {
            System.out.println("Operation Failed");
        }

    }

    public static void getSourceImage(String path, ImageView view) throws FileNotFoundException {

        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        view.setImage(image);
    }

}
