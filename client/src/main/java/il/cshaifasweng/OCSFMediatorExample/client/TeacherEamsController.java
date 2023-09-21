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
        sendMessage("give me the courses");
    }

    @FXML
    void QuestionB(ActionEvent event) {

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
        //if(event.getMessage().equals("i will give you the courses")){
    //EventBus.getDefault().register(this);
        System.out.println("Gellooooooooooo");
        System.out.println("i will give you the student grades");
        /*List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
        List<Grade> grades_from_server = event.getMessage().getGrades_list_from_server();
        System.out.println(Courses_from_server.size());
        grade_column.setCellValueFactory(new PropertyValueFactory<>("grade"));
        course_column.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        for (int i = 0; i < grades_from_server.size(); i++) {
            // Set the data to the table
            CourseTable.getItems().add(Courses_from_server.get(i));
        }}
*/}
    @FXML
    void initialize() {
        //EventBus.getDefault().register(this); /// this line did lot of problems to me!!

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
