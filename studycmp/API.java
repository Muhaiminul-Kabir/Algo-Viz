/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates1
 * and open the template in the editor.
 */
package studycmp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class API {

    // for creating primary folders
    public static void mainDir() throws IOException {

        File f0 = new File("src/StudyBase");

        File f1 = new File("src/StudyBase/To_do");
        File f2 = new File("src/StudyBase/Study");
        File f3 = new File("src/StudyBase/Settings");
        File f4 = new File("src/StudyBase/Progress");

        File[] mainFolder = {f1, f2, f3, f4};
        String[] path = {"src/StudyBase/To_do/empty.txt","src/StudyBase/Study/empty.txt","src/StudyBase/Settings/empty.txt","src/StudyBase/Progress/empty.txt"};
        //Creating a folder using mkdir() method  
        boolean bool = f0.mkdir();
        if (bool) {
            System.out.println("Folder is created successfully");

            for (int i = 0; i < mainFolder.length; i++) {
                mainFolder[i].mkdir();
                dataIn("git", path[i], "0");
            }

            dataIn("init", "src/StudyBase/app_state.txt", "pre_user");
            //dataIn("init", "src/StudyBase/task_state.txt", "no");
            dataIn("temp", "src/StudyBase/temp_day.txt", dateToString(LocalDate.now()));
        } else {
            System.out.println("exists");

        }

    }
    
    // make desierd folder
    public static void makeDir(String path){
        File fld = new File(path);
        fld.mkdir();
    }
    
   // is String inside the limit
    public static boolean isEqualsLimit(String txt, int limit){
        return txt.length() == limit ;
    }
    
    //checks if the String is parsable or not
    public static boolean tryParse(String txt) {
        try{
            Integer.parseInt(txt);
            
        }catch(NumberFormatException ex){
            return false;
        }
        return true;
    }
    

    // Localdate to String like (20-08-2021) -> (20 August 2021)
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        return date.format(formatter);
    }

    //for string
    public static void appendToFile(String path, String data) throws IOException {
        File myFoo = new File(path);
        FileWriter fooWriter = new FileWriter(myFoo, true); // true to append
        // false to overwrite.
        fooWriter.write(data);
        fooWriter.close();
    }

    public static void overwriteFile(String path, String data) throws IOException {
        File myFoo = new File(path);
        FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
        // false to overwrite.
        fooWriter.write(data);
        fooWriter.close();
    }

    // close current window for button click
    public static void closeWindowOnButton(Button b) {
        // get a handle to the stage
        Stage stage = (Stage) b.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    // inserts String data to file
    public static void dataIn(String sl, String path, String temp) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(path);
        BufferedOutputStream bout = new BufferedOutputStream(fout);

        byte c[] = temp.getBytes();
        bout.write(c);
        bout.flush();
        bout.close();
        fout.close();

        System.out.println(sl + "success...");

    }

    // creates file path
    public static String createFolderPath(String key, String flName) {
        String path = null;
        if (!flName.equals("")) {
            path = "src/StudyBase/" + key + "/" + flName;
        } else {
            path = "src/StudyBase/" + key;

        }
        System.out.println(path);
        return path;

    }

    // read a file as a whole String
    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    // checks password (not in use)
    public static String matchPass(String user) throws Exception {
        String data;
        String path = "src/StudyBase/" + user + "/password.txt";
        boolean exists = isUserExists(user, path);
        if (!exists) {
            data = "err";
        } else {
            data = readFileAsString(path);
        }

        return data;
    }

    // checks if the user exists (not in use)
    public static boolean isUserExists(String user, String dirPath) throws Exception {

        boolean exists = true;

        String[] temp = getAvaliableFilesInDir(dirPath);
        int i = 0;
        for (i = 0; i < temp.length; i++) {
            if (user.equals(temp[i])) {
                exists = true;
                break;
            }

        }
        if (i == temp.length) {
            exists = false;
        }

        return exists;

    }

    // gets extension of existing  of a given file name in a directory
    public static String getExtension(String path, String fileName) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String ext = null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] filename = file.getName().split("\\.(?=[^\\.]+$)"); //split filename from it's extension
                if (filename[0].equalsIgnoreCase(fileName)) //matching defined filename
                {
                    System.out.println("File exist: " + filename[0] + "." + filename[1]); // match occures.Apply any condition what you need
                }
                ext = filename[1];
            }
        }
        return ext;
    }

    // renames a file 
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

    // gets targeted image and sets in a imageview
    public static void getSourceImage(String path, ImageView view) throws FileNotFoundException {

        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        view.setImage(image);
    }

    //returns list of files in a directory
    public static String[] getAvaliableFilesInDir(String path) {

        File source = new File(path);
        String[] fileList = source.list();
        return fileList;

    }

}
