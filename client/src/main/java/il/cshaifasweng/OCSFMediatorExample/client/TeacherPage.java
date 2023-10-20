package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void ExamsB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherEamsController");
    }

    @FXML
    void GradesB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("primary");
        Message msg=new Message("give me the students");
        if(!Techer_ID.getItems().get(0).isEmpty())
            msg.setId(Integer.parseInt(Techer_ID.getItems().get(0)));
        msg.setLogin_name("Teacher");
        sendMessage(msg);
    }

    @FXML
    void StatsB(ActionEvent event) throws IOException {

       sendMessage("give me exams info");

        SimpleChatClient.setRoot("TeacherStats");
        Message msg=new Message("give me teacher stats");
        if(!Techer_ID.getItems().get(0).isEmpty())
        msg.setId(Integer.parseInt(Techer_ID.getItems().get(0)));
        msg.setLogin_name("Teacher");
        sendMessage(msg);


    }
    @FXML
    void log_out_but(ActionEvent event) throws IOException {
SimpleChatClient.setRoot("FirstPage");
    }
    @FXML
    void Edit_grades(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("EditGrade");
       // Message msg=new Message("give me students id");
       // msg.setId(SimpleClient.ID);
       // msg.setType(SimpleClient.Type);
        //sendMessage(msg);


    }

    @FXML
    private ListView<String> Techer_ID;



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
        if (event.getMessage().getMessage().equals("i will give you the teacher data")) {

            if (Techer_ID.getItems().isEmpty()) {
                Techer_ID.getItems().add(String.valueOf(SimpleClient.ID));


            }
        }
        else if (event.getMessage().getMessage().equals("i will give you exams info")) {
            List<ExamInfo> lst = event.getMessage().getExamInfos();
            for (ExamInfo examInfo : lst) {
                System.out.println("exam info " + examInfo.getExam_id());
                System.out.println("exam info " + examInfo.getCourseid());
                System.out.println("exam info " + examInfo.getStudentid());
                System.out.println("exam info " + examInfo.getActualDuration());
                System.out.println("exam info " + examInfo.getExecutionDateTime());
                System.out.println("exam info " + examInfo.getNumberOfCompletedStudents());
                System.out.println("exam info " + examInfo.getNumberOfFailedStudents());
                System.out.println("exam info " + examInfo.getNumberOfStartedStudents());
            }
        }
    }

    @FXML
    void initialize() {
        try {
            Message message = new Message(1,"add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int msgId=0;
        EventBus.getDefault().register(this);
        Message msg=new Message("test it baby");
        msg.setToid(7);
        sendMessage(msg);
        sendMessage("give me teacher data");



    }

}
