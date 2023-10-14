package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GradeExam {
    double gradeis;
    @FXML
    void okB(ActionEvent event) throws IOException {
        Message msg = new Message("change the student grade");
        msg.setGrade(Double.parseDouble(grade.getText()));
        msg.setGrade_to_change((int) msg.getGrade());
        msg.setStudentId(SimpleClient.ID);
        msg.setCourse_id(Integer.parseInt(ExamsFinal.courseid));
        SimpleChatClient.setRoot("StudentController");
        sendMessage(msg);

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
        gradeis = event.getMessage().getGrade();
        String str = String.valueOf(gradeis);
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
