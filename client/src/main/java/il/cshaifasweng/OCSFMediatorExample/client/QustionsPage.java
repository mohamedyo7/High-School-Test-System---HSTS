package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class QustionsPage {

    @FXML
    private TextField idText;
    @FXML
    private ResourceBundle resources;
int allow=0;
    @FXML
    private URL location;

    @FXML
    private ListView<String> list;
    @FXML
    private TextField answerText1;
    @FXML
    private Text errorText;
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
        allow=1;
        if (idText.getText().length() != 3)
            errorText.setText("The id you intered is not 3 digits long , please try again");
        else {
                errorText.setText("Question added Successfully");
                String question = quesionText.getText();
                String ans1 = answerText1.getText();
                String ans2 = answerText2.getText();
                String ans3 = answerText3.getText();
                String ans4 = answerText4.getText();
                String cans = answerText5.getText();
                Message msg = new Message("create question");
                Questions q = new Questions(question, ans1, ans2, ans3, ans4, cans);
                q.setToShow(true);
                String a = idText.getText() + SimpleClient.getCourderid(list.getSelectionModel().getSelectedItem());
                q.setId(a);
                System.out.println(a);
                q.setCourse_name(list.getSelectionModel().getSelectedItem());
                msg.setQuestion(q);
                sendMessage(msg);
            if(allow == 0){
                errorText.setText("error ! Question id already exists");
            }
        }
    }

    @FXML
    void deleteButton(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("ExamsPage");
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
            list.getItems().clear();
            List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();

            for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                if(Courses_from_server_reg.get(i).getLecturer()!=null)
                    if(Courses_from_server_reg.get(i).getLecturer().getId()==SimpleClient.ID){



                        list.getItems().add(Courses_from_server_reg.get(i).getName());

                    }
            }
            list.refresh();
        } else if (event.getMessage().getMessage().equals("questions id exist")) {
            errorText.setText("Error ! Question id already exists");
            allow = 0;

        }
    }
    @FXML
    void initialize() {
        EventBus.getDefault().register(this);

        assert answerText1 != null : "fx:id=\"answerText1\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText2 != null : "fx:id=\"answerText2\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText3 != null : "fx:id=\"answerText3\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText4 != null : "fx:id=\"answerText4\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert answerText5 != null : "fx:id=\"answerText5\" was not injected: check your FXML file 'QustionsPage.fxml'.";
        assert quesionText != null : "fx:id=\"quesionText\" was not injected: check your FXML file 'QustionsPage.fxml'.";

    }

}
