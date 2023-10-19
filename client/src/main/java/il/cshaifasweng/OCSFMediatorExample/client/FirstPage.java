package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FirstPage {


    @FXML
    void LogIn_but(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("Login");


    }

    @FXML
    void Register_but(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("RegisterPage");

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


        Message msg=new Message("update state");
        msg.setId(SimpleClient.ID);
        msg.setType(SimpleClient.Type);
        sendMessage(msg);


        //EventBus.getDefault().register(this);

       /* try {
            Message message = new Message(0,"add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        // sendMessage("give me the students");
        // Choose_login.setVisible(true);
    }

}
