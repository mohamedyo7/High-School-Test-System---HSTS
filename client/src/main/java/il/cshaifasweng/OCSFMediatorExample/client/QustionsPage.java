package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import javafx.scene.control.ListView;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class QustionsPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> list;
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
    void listac(ActionEvent event) {

    }
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
        System.out.println("create question");
        System.out.println();
        Questions q = new Questions(question,ans1,ans2,ans3,ans4,cans);
        q.setCourse_name(list.getSelectionModel().getSelectedItem());
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
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            System.out.println("Gellooooooooooo");
            list.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
            System.out.println(Courses_from_server.size());
/*            course_column.setCellValueFactory(new PropertyValueFactory<>("id"));
            course_column.setCellValueFactory(new PropertyValueFactory<>("name"));*/

            for (int i = 0; i < Courses_from_server.size(); i++) {
                // Set the data to the table
                list.getItems().add(Courses_from_server.get(i).getName());
                System.out.println(Courses_from_server.get(i).getName());
            }
            list.refresh();
        }
    }
    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        sendMessage("give me the courses");
        assert answerText1 != null : "fx:id=\"answerText1\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText2 != null : "fx:id=\"answerText2\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText3 != null : "fx:id=\"answerText3\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText4 != null : "fx:id=\"answerText4\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText5 != null : "fx:id=\"answerText5\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert quesionText != null : "fx:id=\"quesionText\" was not injected: check your FXML file 'QustionsPage.fxml'.";

    }

}
