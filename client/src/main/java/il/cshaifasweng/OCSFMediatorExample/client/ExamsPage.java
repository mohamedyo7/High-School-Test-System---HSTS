package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class ExamsPage {
    Exams exam = new Exams();
    @FXML
    private TextField exam_id;
    @FXML
    private ResourceBundle resources;
    @FXML
    private TableColumn<Questions, String> tablecol;
    @FXML
    private TableView<Questions> tableviewq;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;

/*
    @FXML
    private ListView<Questions> questionsList;
*/

    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherEamsController");
    }

    @FXML
    void DoneB(ActionEvent event) throws IOException {
        //should create exam before this lvl
        //Message msg = new Message("add exam");
        //exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());
        //msg.setExam(exam);
        //for (int i=0;i<exam.getQuestions().size();i++){
        //}

        //sendMessage(msg);
        Message msg = new Message("update exam");
        msg.setExam(exam);
        sendMessage(msg);
        SimpleChatClient.setRoot("examsFinal");
    }

    @FXML
    void addToExamB(ActionEvent event) {
        Questions ques = tableviewq.getSelectionModel().getSelectedItem();
        ques.setQues_id(exam_id.getText());
        exam.setId(Integer.parseInt(exam_id.getText()));
        exam.add_Ques(ques);
        //exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());

    }

    @FXML
    void deleteQuesB(ActionEvent event) {
/*        String name = questionsList.getSelectionModel().getSelectedItem();
        Message msg = new Message("delete question");
        msg.setCourseName(name);
        sendMessage(msg);*/
    }

    @FXML
    void insert_id(ActionEvent event) {
        Message msg = new Message("add exam");
        exam.setId(Integer.parseInt(exam_id.getText()));
        exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());
        msg.setExam(exam);
        sendMessage(msg);
    }
    @FXML
    void showQuestionsB(ActionEvent event) {
        Message msg=new Message("show questions");
        exam.setId(Integer.parseInt(exam_id.getText()));
        msg.setExam(exam);
/*        msg.setMessage("update exam");
        sendMessage(msg)*/;
        msg.setMessage("show questions");
       // msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);

    }
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            coursesList.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
/*            course_column.setCellValueFactory(new PropertyValueFactory<>("id"));
            course_column.setCellValueFactory(new PropertyValueFactory<>("name"));*/

            for (int i = 0; i < Courses_from_server.size(); i++) {
                // Set the data to the table
                coursesList.getItems().add(Courses_from_server.get(i).getName());
            }
            coursesList.refresh();
        }
        if(event.getMessage().getMessage().equals("i will show questions")){
            tableviewq.getItems().clear();
            List<Questions> ques = event.getMessage().getQuestions_list_from_server();
            tablecol.setCellValueFactory(new PropertyValueFactory<>("question"));
            exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());
            for(int i=1;i<ques.size();i++){

                if(coursesList.getSelectionModel().getSelectedItem().equals(ques.get(i).getCourse_name())){
                    tableviewq.getItems().add(ques.get(i));
                }

            }
            tableviewq.refresh();
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
            assert exam_id != null : "fx:id=\"exam_id\" was not injected: check your FXML file 'ExamsPage.fxml'.";
           // assert questionsList != null : "fx:id=\"questionsList\" was not injected: check your FXML file 'ExamsPage.fxml'.";

    }

}
