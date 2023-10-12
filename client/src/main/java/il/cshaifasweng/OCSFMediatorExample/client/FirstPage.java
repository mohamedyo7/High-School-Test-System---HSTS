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


        //EventBus.getDefault().register(this);

        try {
            int j=1;
            Message message = new Message(j++,"add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // sendMessage("give me the students");
        // Choose_login.setVisible(true);
    }

}
