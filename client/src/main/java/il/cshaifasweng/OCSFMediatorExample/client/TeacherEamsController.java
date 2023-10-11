package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
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
    void existExamsB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("examsFinal");
    }
    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherPage");
    }

    @FXML
    void ExamsB(ActionEvent event) throws IOException {
        //Message message = new Message("show exams");
        SimpleChatClient.setRoot("ExamsPage");
        Message msg=new Message("show questions");
        sendMessage(msg);

    }

    @FXML
    void QuestionB(ActionEvent event) throws IOException {

        SimpleChatClient.setRoot("QustionsPage");
/*        Message message = new Message("add questions to course");
        sendMessage(message);*/
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

    }

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

    }

}
