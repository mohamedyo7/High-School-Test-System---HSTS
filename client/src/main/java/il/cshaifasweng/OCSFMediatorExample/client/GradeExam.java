package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import com.google.protobuf.StringValue;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class GradeExam {

    @FXML
    void okB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherPage");
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text grade;
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        grade.setText("hi");
        Double d = event.getMessage().getGrade();
        String str = String.valueOf(d);
        grade.setText(str);
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
        assert grade != null : "fx:id=\"grade\" was not injected: check your FXML file 'gradeExam.fxml'.";

    }

}
