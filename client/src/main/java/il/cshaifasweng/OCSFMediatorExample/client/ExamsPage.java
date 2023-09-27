package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ExamsPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;

    @FXML
    private ListView<String> questionsList;

    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherEamsController");
    }

    @FXML
    void DoneB(ActionEvent event) {

    }

    @FXML
    void addToExamB(ActionEvent event) {

    }

    @FXML
    void deleteQuesB(ActionEvent event) {

    }

    @FXML
    void showQuestionsB(ActionEvent event) {
        Message msg=new Message("show questions");
       // msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);

    }
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            System.out.println("Gellooooooooooo");
            coursesList.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
            System.out.println(Courses_from_server.size());
/*            course_column.setCellValueFactory(new PropertyValueFactory<>("id"));
            course_column.setCellValueFactory(new PropertyValueFactory<>("name"));*/

            for (int i = 0; i < Courses_from_server.size(); i++) {
                // Set the data to the table
                coursesList.getItems().add(Courses_from_server.get(i).getName());
                System.out.println(Courses_from_server.get(i).getName());
            }
            coursesList.refresh();
        }
        if(event.getMessage().getMessage().equals("i will show questions")){
            questionsList.getItems().clear();
            List<Questions> ques = event.getMessage().getQuestions_list_from_server();
            System.out.println("size is ");
            System.out.println(ques.size());
            for(int i=1;i<ques.size();i++){
                System.out.println("ExamsPage");
                System.out.println(ques.get(i).getCourse_name());
                System.out.println(coursesList.getSelectionModel().getSelectedItem());
                if(coursesList.getSelectionModel().getSelectedItem().equals(ques.get(i).getCourse_name())){
                    System.out.println("inside if");
                questionsList.getItems().add(ques.get(i).getQuestion());
                System.out.println(ques.get(i).getCourse_name());
                }

            }
            questionsList.refresh();
        }
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
        sendMessage("give me the courses");

        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'ExamsPage.fxml'.";
        assert questionsList != null : "fx:id=\"questionsList\" was not injected: check your FXML file 'ExamsPage.fxml'.";

    }

}
