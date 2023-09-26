package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.greenrobot.eventbus.EventBus;

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
    }

    @FXML
    void StatsB(ActionEvent event) {

    }

    @FXML
    void initialize() {
        int msgId=0;
        //EventBus.getDefault().register(this);


        try {
            Message message = new Message(1,"add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
