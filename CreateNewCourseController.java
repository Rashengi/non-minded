package com.oop.courseprojects.studentproject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class CreateNewCourseController {

    @FXML    private TextField idTextField;
    @FXML    private TextField nameTextField;
    @FXML    private ComboBox<Integer> creditComboBox;
    @FXML    private ComboBox<String> courseTypeComboBox;

    ArrayList<Course> courseList;

    @FXML
    void accumulateCourseToArrayListButtonMouseOnClicked(MouseEvent event) {
        courseList.add(
                new Course(
                        idTextField.getText(),
                        nameTextField.getText(),
                        courseTypeComboBox.getValue(),
                        creditComboBox.getValue()
                )

        );
        idTextField.clear();
        nameTextField.clear();
        //courseTypeComboBox
    }

    @FXML
    void saveArrayListToFileButtonMouseOnClicked(MouseEvent event) {
        FileWriter fw = null;
        File f = new File("CourseInfo.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f, true);
            }
            else{
                fw = new FileWriter(f);
            }

        } catch (Exception e) {
            //
        }
        String str = "";
        for(Course c:courseList){
           str += c.toString("for file");
        }
        try {
            fw.write(str);
            fw.close();
        } catch (Exception e) {
           //
        }

    }

    @FXML
    void initialize() {
        creditComboBox.getItems().addAll(1,3,4,6);
        courseTypeComboBox.getItems().addAll("Select Course Type","Foundation", "Major", "Minor", "Core", "Optional");
        courseList = new ArrayList<Course>();
    }

    @FXML
    public void goToCourseLoadViewButtonMouseOnClicked(Event event) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(CreateNewBookController.class.getResource("LoadCourseInfoFromFileView.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoadCourseInfoFromFileView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Load Course From File");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @FXML
    public void saveArrayListToBinaryFileButtonMouseOnClicked(Event event) {
        try{
            File f = new File("CourseInfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            for(Course c: courseList){
                oos.writeObject(c);
            }
            oos.close();
        }
        catch (Exception e){
            //
        }


    }

    @FXML
    public void switchToCourseLoadViewButtonMouseOnClicked(Event event) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(CreateNewBookController.class.getResource("LoadCourseInfoFromFileView.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoadCourseInfoFromFileView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            //System.out.println(event.getSource());
            Stage refToCurrentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            refToCurrentStage.setTitle("Load Course From File");
            refToCurrentStage.setScene(nextScene);
            refToCurrentStage.show();
        }
        catch(Exception e){
            //
        }
    }
}
