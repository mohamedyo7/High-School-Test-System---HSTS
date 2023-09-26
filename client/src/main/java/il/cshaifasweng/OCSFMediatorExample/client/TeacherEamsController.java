package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.Subscribe;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.sql.SQLException;
import java.util.List;

public class TeacherEamsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Course> CourseTable;

    @FXML
    private TableColumn<Grade, String> course_column;

    @FXML
    private TableColumn<Grade, Integer> grade_column;

    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherPage");
    }

    @FXML
    void ExamsB(ActionEvent event) {
        Message message = new Message("add questions to course");
        String name = CourseTable.getSelectionModel().getSelectedItem().getName();
        message.setCourseName(name);
        sendMessage("give me the courses");
    }

    @FXML
    void QuestionB(ActionEvent event) throws IOException {

        String name = CourseTable.getSelectionModel().getSelectedItem().getName();
        SimpleChatClient.setRoot("QustionsPage");
        System.out.println("TeacherEamspage1");
        Message message = new Message("add questions to course");
        message.setCourseName(name);
        System.out.println("TeacherEamspage2");
        sendMessage(message);
        System.out.println("TeacherEamspage3");
    }
    void sendMessage(Message message) {

        try {
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void sendMessage(String messageBody) {
        try {
            Message message = new Message( messageBody);

            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
@Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if(event.getMessage().getMessage().equals("i will give you the courses")){
        System.out.println("Gellooooooooooo");
        CourseTable.getItems().clear();
        List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
        System.out.println(Courses_from_server.size());
    course_column.setCellValueFactory(new PropertyValueFactory<>("id"));
    course_column.setCellValueFactory(new PropertyValueFactory<>("name"));

        for (int i = 0; i < Courses_from_server.size(); i++) {
            // Set the data to the table
            CourseTable.getItems().add(Courses_from_server.get(i));
            System.out.println(Courses_from_server.get(i).getName());
        }

        CourseTable.refresh();
    }}

    @FXML
    void initialize() {
        EventBus.getDefault().register(this); /// this line did lot of problems to me!!

/*        int msgId = 0;
        try {
            Message message = new Message(msgId, "add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        System.out.println("TeacherEamsContoller");
        sendMessage("give me the courses");
        System.out.println("TeacherEamsContoller");

        assert CourseTable != null : "fx:id=\"CourseTable\" was not injected: check your FXML file 'TeacherEamsController.fxml'.";
        assert course_column != null : "fx:id=\"course_column\" was not injected: check your FXML file 'TeacherEamsController.fxml'.";
        assert grade_column != null : "fx:id=\"grade_column\" was not injected: check your FXML file 'TeacherEamsController.fxml'.";
        course_column.setVisible(true);
        grade_column.setVisible(true);
        CourseTable.setVisible(true);

    }

}
