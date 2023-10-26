package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExamsFinal {
    Message msg = new Message("");
    public static String courseid;
    @FXML
    private TextField extraTime;
    @FXML
    private TextField reason;
    double etime;
    private double time;
    Exams exam;
    @FXML
    private TextField timeT;
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;
    @FXML
    void insetTime(ActionEvent event) {
        etime = Double.parseDouble(extraTime.getText());
        exam = examsTable.getSelectionModel().getSelectedItem();
        exam.setReason(reason.getText());
        exam.setRequest(true);
        msg.setExam(exam);
        msg.setMessage("extraTimeRequest");
        sendMessage(msg);
    }
    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;

    @FXML
    private Button start_b;
    @FXML
    void BackB(ActionEvent event) throws IOException {
        if(SimpleClient.Type.equals("Teacher"))
        SimpleChatClient.setRoot("ExamsPage");
        else if(SimpleClient.Type.equals("Student")){
            Message msg = new Message("give me student data");
            sendMessage(msg);
            SimpleChatClient.setRoot("StudentController");}
    }

    @FXML
    void startB(ActionEvent event) throws IOException {
        msg.setMessage("start exam");
            time=Double.parseDouble(timeT.getText());
            msg.setLogin_name("teacher");
            msg.setTime(time);
            exam=examsTable.getSelectionModel().getSelectedItem();
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
            msg.setCourse_id(Integer.parseInt(courseid));
            sendMessage(msg);
        //delay.play();
        Message msg = new Message("start exam");
        if(SimpleClient.Type.equals("Student")) {
            SimpleChatClient.setRoot("examInside");

            msg.setStudentId(SimpleClient.ID);
        }
        msg.setLogin_name(SimpleClient.Type);
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg.setExam_id(examsTable.getSelectionModel().getSelectedItem().getId());
        msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
        sendMessage(msg);


    }
    @FXML
    void showExams(ActionEvent event) {
        Message msg =new Message("show exams");
        msg.setLogin_name(SimpleClient.Type);
        msg.setId(SimpleClient.ID);
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }

@Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            int c=0;

            coursesList.getItems().clear();

                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Course>courses=event.getMessage().getCourses_list_from_server();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getLecturer() != null)
                        if (Courses_from_server_reg.get(i).getLecturer().getId() == SimpleClient.ID) {
                                coursesList.getItems().add(Courses_from_server_reg.get(i).getName());


                            for(int j=0;j<courses.size();j++){
                                if(Courses_from_server_reg.get(i).getName().equals(courses.get(j).getName()))
                                    courseid= String.valueOf(courses.get(j).getId());
                            }

                        }

                }

            coursesList.refresh();
        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();
            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                    if (coursesList.getSelectionModel().getSelectedItem() != null) {
                        if (coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())) {
                            examsTable.getItems().add(exams.get(i));
                        }
                    }
                }

            examsTable.refresh();
        }else if (event.getMessage().getMessage().equals("extra time accepted")) {
            if(event.getMessage().getExam().getId().equals(exam.getId())) {
                msg.seteTime(etime);
                courseid = coursesList.getSelectionModel().getSelectedItem();
                Exams examID = examsTable.getSelectionModel().getSelectedItem();
                msg.setExam(examID);
                msg.setMessage("extraTime");
                sendMessage(msg);
            }
        }
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
    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        sendMessage("give me the courses");
        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'examsFinal.fxml'.";
        assert examsTable != null : "fx:id=\"examsTable\" was not injected: check your FXML file 'examsFinal.fxml'.";

    }

}
