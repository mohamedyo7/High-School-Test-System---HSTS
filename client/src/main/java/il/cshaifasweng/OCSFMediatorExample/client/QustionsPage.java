package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class QustionsPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField answerText1;

    @FXML
    private TextField answerText2;

    @FXML
    private TextField answerText3;

    @FXML
    private TextField answerText4;

    @FXML
    private TextField answerText5;

    @FXML
    private TextField quesionText;
    @FXML
    void backB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherEamsController");
    }

    @FXML
    void addButton(ActionEvent event) {
        System.out.println("QuestionPage1");
        String question = quesionText.getText();
        String ans1 = answerText1.getText();
        String ans2 = answerText2.getText();
        String ans3 = answerText3.getText();
        String ans4 = answerText4.getText();
        String cans = answerText5.getText();
        Message msg=new Message("create question");
        Questions q = new Questions(question,ans1,ans2,ans3,ans4,cans);
        msg.setQuestion(q);
        System.out.println("1");
        sendMessage(msg);
    }

    @FXML
    void deleteButton(ActionEvent event) {
        Message msg=new Message("show questions");
        sendMessage(msg);
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
        assert answerText1 != null : "fx:id=\"answerText1\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText2 != null : "fx:id=\"answerText2\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText3 != null : "fx:id=\"answerText3\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText4 != null : "fx:id=\"answerText4\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText5 != null : "fx:id=\"answerText5\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert quesionText != null : "fx:id=\"quesionText\" was not injected: check your FXML file 'QustionsPage.fxml'.";

    }

}
