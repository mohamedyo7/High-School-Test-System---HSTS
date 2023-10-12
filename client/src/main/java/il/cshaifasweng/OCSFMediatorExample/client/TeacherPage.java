package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
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
                Techer_ID.getItems().add(String.valueOf(event.getMessage().getId()));


            }
        }
    }


    @FXML
    void initialize() {
        int msgId=0;
        EventBus.getDefault().register(this);


        try {
            Message message = new Message(1,"add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
