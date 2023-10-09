package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ExamsFinal {
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;

    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;
    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("ExamsPage");
    }

    @FXML
    void startB(ActionEvent event) throws IOException {
        Message msg = new Message("start exam");
        //examsTable.getSelectionModel().getSelectedItem().setStat(1);
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        sendMessage(msg);
        SimpleChatClient.setRoot("examInside");

    }
    @FXML
    void showExams(ActionEvent event) {
        Message msg =new Message("show exams");
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }

@Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            coursesList.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();

            for (Course course : Courses_from_server) {
                // Set the data to the table
                coursesList.getItems().add(course.getName());
            }
            coursesList.refresh();
        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                System.out.println("exam id is" + exams.get(i).getId());
                if(coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())){
                        examsTable.getItems().add(exams.get(i));
                }

            }
            examsTable.refresh();
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
        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'examsFinal.fxml'.";
        assert examsTable != null : "fx:id=\"examsTable\" was not injected: check your FXML file 'examsFinal.fxml'.";

    }

}
