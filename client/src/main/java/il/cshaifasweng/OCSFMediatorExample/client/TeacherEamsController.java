package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
      Message message = new Message("give me the courses");
        sendMessage(message);
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
        //EventBus.getDefault().register(this); /// this line did lot of problems to me!!

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
