package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

public class MediatorPage {

    @FXML
    private ListView<String> mediator_curr;

    @FXML
    void Courses_Stats(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherStats");
        Message msg=new Message("give me teacher stats");
        if(!mediator_curr.getItems().get(0).isEmpty())
            msg.setId(Integer.parseInt(mediator_curr.getItems().get(0)));
        msg.setLogin_name("Mediator");
        sendMessage(msg);

    }

    @FXML
    void STD_Grades_but(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("primary");
        Message msg=new Message("give me the students");
        msg.setLogin_name("Mediator");
        if(!mediator_curr.getItems().isEmpty())
        msg.setId(Integer.parseInt(mediator_curr.getItems().get(0)));
        sendMessage(msg);

    }
    @FXML
    void Log_out(ActionEvent event) throws IOException {
    SimpleChatClient.setRoot("FirstPage");
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
        if (event.getMessage().getMessage().equals("i will give you the mediator data")) {
            int s = 0;
            if (mediator_curr.getItems().isEmpty()) {
                mediator_curr.getItems().add(String.valueOf(SimpleClient.ID));
                mediator_curr.getItems().add(SimpleClient.Type);

            }
        }
    }


    @FXML
    void initialize() {
        int msgId = 0;
        EventBus.getDefault().register(this);
        Message msg=new Message("log in");
        msg.setId(SimpleClient.ID);
        msg.setType(SimpleClient.Type);
        sendMessage(msg);
        sendMessage("give me mediator data");
    }

}
