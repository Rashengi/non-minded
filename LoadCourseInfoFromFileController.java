package com.oop.courseprojects.studentproject;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LoadCourseInfoFromFileController{
    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private TableView<Course> courseTableView;
    @FXML    private TableColumn<Course,String> idTableColumn;
    @FXML    private TableColumn<Course,String> titleTableColumn;
    @FXML    private TableColumn<Course,String> courseTypeTableColumn;
    @FXML    private TableColumn<Course,Integer> creditsTableColumn;

    @FXML    private TableView<Course> courseTableView2;
    @FXML    private TableColumn<Course,String> idTableColumn2;
    @FXML    private TableColumn<Course,String> titleTableColumn2;
    @FXML    private TableColumn<Course,String> courseTypeTableColumn2;
    @FXML    private TableColumn<Course,Integer> creditsTableColumn2;

    @FXML
    public void initialize() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("courseId"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("title"));
        courseTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("type"));
        creditsTableColumn.setCellValueFactory(new PropertyValueFactory<Course,Integer>("noOfCredits"));

        idTableColumn2.setCellValueFactory(new PropertyValueFactory<Course,String>("courseId"));
        titleTableColumn2.setCellValueFactory(new PropertyValueFactory<Course,String>("title"));
        courseTypeTableColumn2.setCellValueFactory(new PropertyValueFactory<Course,String>("type"));
        creditsTableColumn2.setCellValueFactory(new PropertyValueFactory<Course,Integer>("noOfCredits"));
    }

    @FXML
    void loadTableFromTextFileButtonOnMouseClicked(MouseEvent event) {
        File f = new File("CourseInfo.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Course c = new Course(
                        tokens[0], tokens[1], tokens[2],
                        Integer.parseInt(tokens[3]));
                courseTableView.getItems().add(c);
            }
        } catch (FileNotFoundException e) {
            //
        }
    }

    @FXML
    void loadTableFromBinFileButtonOnMouseClicked(MouseEvent event) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("CourseInfo.bin");
            if(f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //file not found
            }
            ois = new ObjectInputStream(fis);
            while(true){
                courseTableView2.getItems().add((Course)ois.readObject());
            }
        }
        catch(Exception e){
            //
        }

    }


}